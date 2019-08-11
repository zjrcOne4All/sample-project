/**
 * <p>Title: RecordLogAspect.java</p>
 * <p>Description:</p>
 * <p>Company: www.sunyard.com</p>
 * @author Liuxq
 * @date 2018年10月4日
 * @version 1.0
 */
package com.one4all.datacenter.connector.service.aspect;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.one4all.datacenter.connector.service.annotation.RecordLog;
import com.one4all.datacenter.connector.service.domain.enums.LogContextEnum;
import com.one4all.datacenter.connector.service.domain.model.DefaultLogInfo;
import com.one4all.datacenter.connector.service.util.LoggerUtil;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.NamedThreadLocal;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;

import javax.servlet.http.HttpServletRequest;


/**
 * @author Will Liu
 * 默认的日志切点类，包含自定义的@RecordLog注解切入点和controller层的切入点
 *
 */
@Aspect
@Component
public class DefaultLogAspect {
	
	private static final Logger logger = LoggerFactory.getLogger(DefaultLogAspect.class);
	
    @Autowired(required=false)
	HttpServletRequest request;
    
	private static final ThreadLocal<DefaultLogInfo> threadLocalLog =  new NamedThreadLocal<DefaultLogInfo>("ThreadLocal-LogBean");

	
	/**
	 * 定义controller层切入点
	 * <p>Title: ControllerPointCut</p>
	 * <p>Description: 该切入点的作用域为所有controller</p>
	 */
	@Pointcut("execution(public * com.one4all.datacenter.connector.service.controller.*.*(..))")
	public void ControllerPointCut() {
		
	}
	

	/**
	 * 定义@RecordLog注解切入点
	 * <p>Title: RecordLogPointCut</p>
	 * <p>Description: 该切入点的作用域为所有带有@RecordLog注解方法</p>
	 */
	@Pointcut("@annotation(com.one4all.datacenter.connector.service.annotation.RecordLog)")
	public void RecordLogPointCut() {
		
	}
	
	/**
	 * 前置日志处理
	 * 用于记录进入Controller之前的日志信息，主要是网络传输方面的参数
	 * <p>Title: doBeforeController</p>
	 * <p>Description: </p>
	 * @param joinPoint
	 */
	@Before("ControllerPointCut()")
	public  void doBefore(JoinPoint joinPoint) throws Throwable{
		 logger.debug("------------------------------前置日志处理------------------------------");
		 DefaultLogInfo logInfo = LoggerUtil.initLog(request);
		 logInfo.setFlowStage(LogContextEnum.STAGE_BEFORE);
		 logInfo.setExcutionState(LogContextEnum.STATE_READY);
		 //记录请求用模块的坐标
		 List<Map<String, String>> positionList = new ArrayList<Map<String, String>>();
		 Map<String, String> pointMap = new HashMap<String, String>();
		 pointMap.put(joinPoint.getTarget().getClass().getName(), joinPoint.getSignature().getName());
		 positionList.add(pointMap);
		 //获取输入参数
		 Object[] args = joinPoint.getArgs();
		 String[] argNames = ((MethodSignature)joinPoint.getSignature()).getParameterNames();
		 //记录输入参数
		 HashMap<String, Object> inputMap = new HashMap<String, Object>();
		 for(int i = 0;i < args.length;i++) {
			 inputMap.put(argNames[i], args[i]);
		 }
		 logInfo.setInputParam(inputMap);
		 //将初始化的日志信息放入线程级对象，作为后续处理的上下文
		 threadLocalLog.set(logInfo);
		 logger.debug(JSON.toJSONString(logInfo));
	}
	
	/**
	 * 环绕日志处理
	 * 用于处理自定义注释@RecordLog标记的方法中的日志
	 * <p>Title: arround</p>
	 * <p>Description: </p>
	 * @param pjp
	 * @return
	 * @throws Throwable
	 */
    @Around("RecordLogPointCut()")
    public Object doArround(ProceedingJoinPoint pjp) throws Throwable {
    	logger.debug("------------------------------环绕日志处理------------------------------");
		long startTime = System.currentTimeMillis();
    	MethodSignature signature = (MethodSignature) pjp.getSignature();
    	Method method = signature.getMethod();
    	RecordLog recordLog = method.getAnnotation(RecordLog.class);
    	DefaultLogInfo logInfo = threadLocalLog.get();
		logInfo.setFlowStage(LogContextEnum.STAGE_ARROUND);
		Optional.ofNullable(recordLog.actionEnum()).ifPresent(action -> {logInfo.setAction(action);});
		Optional.ofNullable(recordLog.featureTags()).ifPresent(
				newTags -> {Optional<ArrayList<LogContextEnum>> optOldTags = Optional.ofNullable(logInfo.getFeatureTags());
				optOldTags.ifPresent(oldTags -> {Collections.addAll(oldTags,newTags);logInfo.setFeatureTags(oldTags);});
				optOldTags.orElseGet(() -> {
					ArrayList<LogContextEnum> featureTags = Stream.of(newTags).collect(Collectors.toCollection(ArrayList::new));
					logInfo.setFeatureTags(featureTags);
					return featureTags;
				});
		});
		Optional.ofNullable(recordLog.remarks()).ifPresent(remarks -> {logInfo.setRemarks(remarks);});
		Map<String, String> pointMap = new HashMap<String, String>();
		if(recordLog.xPoint().length() > 0 && recordLog.yPoint().length() > 0) {
			pointMap.put(recordLog.xPoint(), recordLog.yPoint());
			//先判断logInfo中的position是否为空，不为空则取出实例并添加坐标map，否则先初始化，然后再添加坐标map
			Optional<List<Map<String, String>>> optPosition = Optional.ofNullable(logInfo.getPosition());
			optPosition.ifPresent(position -> {position.add(pointMap);logInfo.setPosition(position);});
			optPosition.orElseGet(() -> {
						ArrayList<Map<String, String>> position = new ArrayList<Map<String, String>>();
						position.add(pointMap);
						logInfo.setPosition(position);
						return position;
			});
		}else {
			pointMap.put(pjp.getTarget().getClass().getName(), pjp.getSignature().getName());
			Optional<List<Map<String, String>>> optPosition = Optional.ofNullable(logInfo.getPosition());
			optPosition.ifPresent(position -> {position.add(pointMap);logInfo.setPosition(position);});
			optPosition.orElseGet(() -> {
						ArrayList<Map<String, String>> position = new ArrayList<Map<String, String>>();
						position.add(pointMap);
						logInfo.setPosition(position);
						return position;
			});
		}
		Object ob = pjp.proceed();// ob 为方法的返回值
		//计算环绕阶段的消耗时间和截至当前阶段的消耗时间（单位.毫秒）
		Map<String, Long> durationMap = Optional.ofNullable(logInfo.getDurationMap()).orElseGet(() -> {
			HashMap<String, Long> optionalMap = new HashMap<String, Long>();
			return optionalMap;
		});
		//添加当前消耗时间
		logInfo.setDurationMap(getConsuming(durationMap,logInfo.getFlowStage().getValue(),startTime,1));
		//添加截至消耗时间
		logInfo.setDurationMap(getConsuming(durationMap,logInfo.getFlowStage().getValue(),logInfo.getStartTime(),0));
		logInfo.setOutputParam(ob);
		logger.debug(JSON.toJSONString(logInfo));
        return ob;
    }
		
	/**
	 * 后置日志处理
	 * 用于记录controller层调度结束后的日志信息，主要是返回值处理
	 * <p>Title: doAfter</p>
	 * <p>Description: </p>
	 * @param joinPoint
	 */
	@After("ControllerPointCut()")
	public void doAfter(JoinPoint joinPoint) {
		logger.debug("------------------------------后置日志处理------------------------------");
		DefaultLogInfo logInfo = threadLocalLog.get();
		logInfo.setFlowStage(LogContextEnum.STAGE_AFTER);
		//更新执行状态
		logInfo.setExcutionState(LogContextEnum.STATE_PROCESSING);
		//计算截至该阶段的消耗时间（单位.毫秒）
		Map<String, Long> durationMap = Optional.ofNullable(logInfo.getDurationMap()).orElseGet(() -> {
			HashMap<String, Long> optionalMap = new HashMap<String, Long>();
			return optionalMap;
		});
		logInfo.setDurationMap(getConsuming(durationMap,logInfo.getFlowStage().getValue(),logInfo.getStartTime(),0));
		logger.debug(JSON.toJSONString(logInfo));
	}
	
	@AfterReturning(returning="result", pointcut = "ControllerPointCut()")
	public void doAfterReturning(JoinPoint joinPoint, Object result) {
		logger.debug("------------------------------请求返回后日志处理------------------------");
		DefaultLogInfo logInfo = threadLocalLog.get();
		logInfo.setFlowStage(LogContextEnum.STAGE_RETURN);
		logInfo.setExcutionState(LogContextEnum.STATE_COMPLETE);
		logInfo.setOutputParam(result);
		//计算截至该阶段的消耗时间（单位.毫秒）
		Map<String, Long> durationMap = Optional.ofNullable(logInfo.getDurationMap()).orElseGet(() -> {
			HashMap<String, Long> optionalMap = new HashMap<String, Long>();
			return optionalMap;
		});
		logInfo.setDurationMap(getConsuming(durationMap,logInfo.getFlowStage().getValue(),logInfo.getStartTime(),0));
		logger.info(JSON.toJSONString(logInfo));
	}
	    
	/**
	 * 异常后日志处理
	 * <p>Title: doAfterThrowing</p>
	 * <p>Description: </p>
	 * @param joinPoint
	 * @param e
	 */
	@AfterThrowing(pointcut = "ControllerPointCut()", throwing = "e")  
	public  void doAfterThrowing(JoinPoint joinPoint, Throwable e) {
		logger.debug("------------------------------异常后日志处理----------------------------");
		//更新日志上线文对象，写入具体的异常信息或异常说明
		DefaultLogInfo logInfo = threadLocalLog.get();
		logInfo.setFlowStage(LogContextEnum.STAGE_EXCEPTION);
		logInfo.setExcutionState(LogContextEnum.STATE_ERROR);
		HashMap<String, String> errorInfoMap = new HashMap<String, String>();
		errorInfoMap.put("异常方法", joinPoint.getSignature().getName() + "@" + joinPoint.getTarget().getClass().getName());
		errorInfoMap.put("异常类型", e.getClass().getName());
		errorInfoMap.put("异常信息", e.getMessage());
		logInfo.setExceptionMsg(errorInfoMap.toString());
		//计算截至该阶段的消耗时间（单位.毫秒）
		Map<String, Long> durationMap = Optional.ofNullable(logInfo.getDurationMap()).orElseGet(() -> {
			HashMap<String, Long> optionalMap = new HashMap<String, Long>();
			return optionalMap;
		});
		logInfo.setDurationMap(getConsuming(durationMap,logInfo.getFlowStage().getValue(),logInfo.getStartTime(),0));
		logger.error(JSON.toJSONString(logInfo));
	}
    
    private Map<String, Long> getConsuming(Map<String, Long> durationMap, String key, Long startTime, int type) {
    	StringBuilder strBuilder = new StringBuilder();
    	if(type == 0) {//type=0表示计算截至耗时，以请求进入调用链作为计时开始，当前阶段的时间为当前时间
        	strBuilder.append("截至.");
        	strBuilder.append(key);
        	strBuilder.append(".总耗时=");
    	}else {
        	strBuilder.append("当前.");
        	strBuilder.append(key);
        	strBuilder.append(".单耗时=");
    	}
    	Long endTime = System.currentTimeMillis();
    	strBuilder.append(endTime);
    	strBuilder.append("（当前时间）-");
    	strBuilder.append(startTime);
    	strBuilder.append("（开始时间）");
    	durationMap.put(strBuilder.toString(), endTime - startTime);
    	return durationMap;
    }
	
}
