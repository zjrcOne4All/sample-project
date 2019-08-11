/**
 * <p>Title: LoggerUtil.java</p>
 * <p>Description:</p>
 * <p>Company: www.sunyard.com</p>
 * @author Liuxq
 * @date 2018年10月3日
 * @version 1.0
 */
package com.one4all.datacenter.connector.service.util;

import javax.servlet.http.HttpServletRequest;

import com.one4all.datacenter.connector.service.domain.enums.LogContextEnum;
import com.one4all.datacenter.connector.service.domain.model.DefaultLogInfo;
import org.apache.commons.lang3.StringUtils;

/**
 * @author Will Liu
 * @date 2018/10/03
 */
public class LoggerUtil {
    
    public LoggerUtil() {
    	
    }

    public static DefaultLogInfo initLog(HttpServletRequest request) {
        //1.依次获取每个属性信息 userId,operator,action,remark,ip,targetType
    	DefaultLogInfo log = new DefaultLogInfo();
    	log.setStartTime(System.currentTimeMillis());
        log.setOriginIp(LoggerUtil.getCliectIp(request));
        log.setOperator("operator-1");
        log.setAcceptType(request.getHeader("Accept"));
        if("GET".equalsIgnoreCase(request.getMethod())) {
        	log.setAction(LogContextEnum.ACTION_READ);
        }else if("POST".equalsIgnoreCase(request.getMethod())) {
        	log.setAction(LogContextEnum.ACTION_WRITE);
        }else {
        	log.setAction(LogContextEnum.ACTION_UNKNOWN);
        }
        log.setPathUrl(request.getRequestURI());
        return log;
    }
    /**
     * 获取客户端ip地址
     * @param request
     * @return
     */
    public static String getCliectIp(HttpServletRequest request){
        String ip = request.getHeader("X-Real-IP");
        if (!StringUtils.isBlank(ip) && !"unknown".equalsIgnoreCase(ip)) {
            return ip;
        }
        ip = request.getHeader("X-Forwarded-For");
        if (!StringUtils.isBlank(ip) && !"unknown".equalsIgnoreCase(ip)) {
            // 多次反向代理后会有多个IP值，第一个为真实IP。
            int index = ip.indexOf(',');
            if (index != -1) {
                return ip.substring(0, index);
            } else {
                return ip;
            }
        } else {
            return request.getRemoteAddr();
        }
    }

}
