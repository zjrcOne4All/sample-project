package com.one4all.datacenter.connector.service.annotation;

import java.lang.annotation.*;

/**
 * 在方法上使用，用于指定使用哪个数据源
 *
 * @author   xiaoqing.liu
 * @since    2019/7/5
 */
@Target({ ElementType.METHOD, ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface TargetDataSource {
    //此处接收的是数据源的名称
    String value();
}