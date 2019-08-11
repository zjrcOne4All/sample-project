package com.one4all.datacenter.connector.service.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.Map;
import java.util.Properties;

/**
 * 只提供了常用的属性，如果有需要，自己添加
 *
 * @author xiaoqing.liu
 * @since 2019/7/5.
 */
@Data
@ConfigurationProperties(prefix = "spring.datasource.druid")
public class DruidDatasourceProperties {

    private int initialSize = 5;

    private int minIdle = 5;

    private int maxActive = 20;

    private Long maxWait = 60000L;

    private Long timeBetweenEvictionRunsMillis = 60000L;

    private Long minEvictableIdleTimeMillis = 300000L;

    private int maxPoolPreparedStatementPerConnectionSize = 20;

    private boolean testWhileIdle = true;

    private boolean testOnBorrow;

    private boolean testOnReturn;

    private boolean exceptionSorter;

    private boolean useGlobalDataSourceStat;

    private String validationQuery;

    private Map<String, String> statViewServlet;

    private DatabaseProperties databaseH2;

    public Properties toProperties(String dbType) {
        Properties properties = new Properties();
        notNullAdd(properties, "testWhileIdle", this.testWhileIdle);
        notNullAdd(properties, "testOnBorrow", this.testOnBorrow);
        notNullAdd(properties, "useGlobalDataSourceStat", this.useGlobalDataSourceStat);
        notNullAdd(properties, "minEvictableIdleTimeMillis", this.minEvictableIdleTimeMillis);
        notNullAdd(properties, "initialSize", this.initialSize);
        notNullAdd(properties, "minIdle", this.minIdle);
        notNullAdd(properties, "maxActive", this.maxActive);
        notNullAdd(properties, "maxWait", this.maxWait);
        notNullAdd(properties, "timeBetweenEvictionRunsMillis", this.timeBetweenEvictionRunsMillis);
        notNullAdd(properties, "maxPoolPreparedStatementPerConnectionSize", this.maxPoolPreparedStatementPerConnectionSize);
        //validationQuery每种数据库都有可能不一样，这里需要对几种特殊的数据库进行个性化处理
        if(dbType != null && dbType.length() > 0) {
            if("oracle".equalsIgnoreCase(dbType)) {
                notNullAdd(properties, "validationQuery", "select 1 from dual");
            }
            if("db2".equalsIgnoreCase(dbType)) {
                notNullAdd(properties, "validationQuery", "select 1 from sysibm.sysdummy1");
            }
            if("postgresql".equalsIgnoreCase(dbType)) {
                notNullAdd(properties, "validationQuery", "select version()");
            }
        }else {
            notNullAdd(properties, "validationQuery", this.validationQuery);
        }
        return properties;
    }
    private void notNullAdd(Properties properties, String key, Object value) {
        if (value != null) {
            properties.setProperty("druid." + key, value.toString());
        }
    }

}
