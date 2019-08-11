package com.one4all.datacenter.connector.service.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

import java.util.HashMap;
import java.util.Map;

/**
 * 动态数据源
 */
public class DynamicDataSource extends AbstractRoutingDataSource {

    private static final Logger logger = LoggerFactory.getLogger(DynamicDataSource.class);

    private static DynamicDataSource dsInstance;

    private static byte[] lock=new byte[0];

    private static Map<Object, Object> dataSourceMap = new HashMap<>();

    /**
     * 动态设置数据源集（需要调整为既可以新增又可以初始化注入）
     * @param //targetDataSources
     */
/*    public void setTargetDataSources(Map<Object, Object> targetDataSources) {
        super.setTargetDataSources(targetDataSources);
        dataSourceMap.putAll(targetDataSources);
        super.afterPropertiesSet();// 必须添加该句，否则新添加数据源无法识别到
    }*/

    public Map<Object, Object> getDataSourceMap() {
        return dataSourceMap;
    }

    /**
     * 最好将这种锁模式的单例改为非锁模式
     * @return
     */
    public static synchronized DynamicDataSource getInstance() {
        if(dsInstance == null){
            synchronized (lock){
                if(dsInstance == null){
                    dsInstance = new DynamicDataSource();
                }
            }
        }
        return dsInstance;
    }

    @Override
    protected Object determineCurrentLookupKey() {
        logger.debug("数据源为{}", DynamicDataSourceContextHolder.getDataSourceName());
        return DynamicDataSourceContextHolder.getDataSourceName();
    }


}
