/**
 * <p>Title: SystemBaseLog.java</p>
 * <p>Description:</p>
 * <p>Company: www.sunyard.com</p>
 * @author Liuxq
 * @date 2018年10月3日
 * @version 1.0
 */
package com.one4all.datacenter.connector.service.domain.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.one4all.datacenter.connector.service.domain.enums.LogContextEnum;

/**
 * @author Will Liu
 * @param <T>
 *
 */
public class DefaultLogInfo implements Serializable{

	/**
	 * auto generated
	 */
	private static final long serialVersionUID = 5889347718539726820L;
	
	public DefaultLogInfo() {
		
	}
	
	/**
	 * 流程起始时间
	 */
	private long startTime;
		
	/**
	 * 请求动作（创建、修改、查询、删除、复合调用(provision)、任务处理(task)、消息通知(notice)）
	 */
	private LogContextEnum action;
		
	/**
	 * 特性标签，自定义标签关键字用于日志的快捷检索或者分析
	 */
	private ArrayList<LogContextEnum> featureTags;
	
	/**
	 * 日志记录的位置（键为横坐标，值为纵坐标）可自定义输入，默认的键为类名，值为方法名
	 */
	private List<Map<String, String>> position;
		
	/**
	 * 备注说明
	 */
	private String remarks;
	
	/**
	 * 调用阶段（前置、环绕、后置、返回、异常）
	 */
	private LogContextEnum flowStage;
	
	/**
	 * 调用的发起者
	 */
	private String operator;
	
	/**
	 * Accept类型
	 */
	private String acceptType;
	
	/**
	 * 调用发起者IP
	 */
	private String originIp;
	
	/**
	 * 调用路径
	 */
	private String pathUrl;
	
	/**
	 * 执行状态，用于标明请求执行的状态（初始、执行中、挂起、超时、取消、完成、异常等）
	 */
	private LogContextEnum excutionState;
	
	/**
	 * 截至当前流程消耗的时间（单位.毫秒）
	 */
	private Map<String, Long> durationMap;
	
	/**
	 * 输入参数
	 */
	private Map<String, Object> inputParam;
	
	/**
	 * 输出参数
	 */
	private Object outputParam;
	
	/**
	 * 异常信息
	 */
	private String exceptionMsg;

	public long getStartTime() {
		return startTime;
	}

	public void setStartTime(long startTime) {
		this.startTime = startTime;
	}

	public LogContextEnum getAction() {
		return action;
	}

	public void setAction(LogContextEnum action) {
		this.action = action;
	}

	public ArrayList<LogContextEnum> getFeatureTags() {
		return featureTags;
	}

	public void setFeatureTags(ArrayList<LogContextEnum> featureTags) {
		this.featureTags = featureTags;
	}

	public List<Map<String, String>> getPosition() {
		return position;
	}

	public void setPosition(List<Map<String, String>> position) {
		this.position = position;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public LogContextEnum getFlowStage() {
		return flowStage;
	}

	public void setFlowStage(LogContextEnum flowStage) {
		this.flowStage = flowStage;
	}

	public String getOperator() {
		return operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}

	public String getAcceptType() {
		return acceptType;
	}

	public void setAcceptType(String acceptType) {
		this.acceptType = acceptType;
	}

	public String getOriginIp() {
		return originIp;
	}

	public void setOriginIp(String originIp) {
		this.originIp = originIp;
	}

	public String getPathUrl() {
		return pathUrl;
	}

	public void setPathUrl(String pathUrl) {
		this.pathUrl = pathUrl;
	}

	public LogContextEnum getExcutionState() {
		return excutionState;
	}

	public void setExcutionState(LogContextEnum excutionState) {
		this.excutionState = excutionState;
	}

	public Map<String, Long> getDurationMap() {
		return durationMap;
	}

	public void setDurationMap(Map<String, Long> durationMap) {
		this.durationMap = durationMap;
	}

	public Map<String, Object> getInputParam() {
		return inputParam;
	}

	public void setInputParam(Map<String, Object> inputParam) {
		this.inputParam = inputParam;
	}

	public Object getOutputParam() {
		return outputParam;
	}

	public void setOutputParam(Object outputParam) {
		this.outputParam = outputParam;
	}

	public String getExceptionMsg() {
		return exceptionMsg;
	}

	public void setExceptionMsg(String exceptionMsg) {
		this.exceptionMsg = exceptionMsg;
	}


}
