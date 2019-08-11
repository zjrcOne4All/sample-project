package com.one4all.datacenter.connector.service.config;

import java.util.LinkedList;
import java.util.List;

/**
 *  使用ThreadLocal对象保存动态数据源名称，保证在线程隔离的前提下，动态的对数据源进行设置和移除
 */
public class DynamicDataSourceContextHolder {

    /** 设置默认数据源的名称 **/
    public static final String DEFAULT_DATASOURCE_NAME = "defaultDataSource";

    /** 设置自定义数据源的名称前缀，多个自定义数据源从1开始依次在前缀后拼接上序号 **/
    public static final String CUSTOM_DATASOURCE_PREFIX = "customDataSource";

    /** 设置contextHolder对象用于保存当前线程的数据源名称 **/
    private static final ThreadLocal<String> contextHolder = new ThreadLocal<>();

    public static String getDataSourceName() {
        return contextHolder.get();
    }

    public static void setDataSourceName(String dataSourceName) {
        contextHolder.set(dataSourceName);
    }

    public static void clearDataSourceName() {
        contextHolder.remove();
    }

    /** 设置所有数据源的名称列表，用于数据源切换时对指定要切换的数据源做有效性校验 **/
    private static List<String> dataSourceNameList = new LinkedList<>();

    /**
     * 判断指定的DataSource是否存在
     *
     * @param dataSourceName
     * @return boolean
     * @author xiaoqing.liu
     * @since  2019/7/5
     */
    public static boolean containsDataSource(String dataSourceName){
        return dataSourceNameList.contains(dataSourceName);
    }

    public synchronized static void initDatasourceName(LinkedList<String> dataSourceNames) {
        dataSourceNameList = dataSourceNames;
    }

    public synchronized static void addDatasourceName(String dataSourceName) {
        dataSourceNameList.add(dataSourceName);
    }

    public synchronized static void removeDatasourcName(String dataSourceName) {
        dataSourceNameList.remove(dataSourceName);
    }

}
