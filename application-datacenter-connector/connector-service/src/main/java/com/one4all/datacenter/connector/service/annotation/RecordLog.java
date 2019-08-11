/**
 * <p>Title: RecordLog.java</p>
 * <p>Description:</p>
 * <p>Company: www.sunyard.com</p>
 * @author Liuxq
 * @date 2018年10月3日
 * @version 1.0
 */
package com.one4all.datacenter.connector.service.annotation;

import com.one4all.datacenter.connector.service.domain.enums.LogContextEnum;

import java.lang.annotation.*;



/**
 * @author xiaoqing.liu
 * @since    2019/7/5
 */
@Target({ElementType.PARAMETER, ElementType.METHOD})  
@Retention(RetentionPolicy.RUNTIME)  
@Documented
public @interface RecordLog {
	
	LogContextEnum actionEnum()  default LogContextEnum.ACTION_UNKNOWN;
		
	String remarks() default "";
	
	LogContextEnum[] featureTags() default {};
	
	String xPoint() default "";
	
	String yPoint() default "";

}
