package com.one4all.datacenter.connector.service.aspect;


import com.one4all.datacenter.connector.service.annotation.TargetDataSource;
import com.one4all.datacenter.connector.service.config.DynamicDataSourceContextHolder;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Order(-1)// 保证该AOP在@Transactional之前执行
@Component
public class DynamicDataSourceAspect {

    private static final Logger logger = LoggerFactory.getLogger(DynamicDataSourceAspect.class);


    @Before("@annotation(ds)")
    public void switchDataSource(JoinPoint point, TargetDataSource ds) {
        if (!DynamicDataSourceContextHolder.containsDataSource(ds.value())) {
            logger.error("数据源[{}]不存在，使用默认数据源 > {}", ds.value(), point.getSignature());
        } else {
            logger.debug("Use DataSource : {} > {}", ds.value(), point.getSignature());
            DynamicDataSourceContextHolder.setDataSourceName(ds.value());
        }
    }

    @After("@annotation(ds)")
    public void restoreDataSource(JoinPoint point, TargetDataSource ds) {
        logger.debug("Revert DataSource : {} > {}", ds.value(), point.getSignature());
        DynamicDataSourceContextHolder.clearDataSourceName();
    }

}
