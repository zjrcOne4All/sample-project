package com.one4all.datacenter.connector.service.annotation;

import java.lang.annotation.*;

/**
 * 通用响应体注解
 */
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface GenericResponseBody {

}
