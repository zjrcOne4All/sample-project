package com.one4all.datacenter.connector.service.config;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.alibaba.druid.pool.DruidDataSource;
import com.one4all.datacenter.connector.service.properties.CustomDatasourceProperties;
import com.one4all.datacenter.connector.service.properties.DruidDatasourceProperties;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.util.Assert;

import javax.sql.DataSource;

@Configuration
@EnableConfigurationProperties(DruidDatasourceProperties.class)
//@MapperScan(basePackages = "com.one4all.datacenter.connector.service.dao", sqlSessionFactoryRef = "sqlSessionFactory")
@tk.mybatis.spring.annotation.MapperScan(basePackages = "com.one4all.datacenter.connector.service.dao", sqlSessionFactoryRef = "sqlSessionFactory")
public class DynamicDataSourceConfig {

    @Autowired
    DataSourceProperties dsPropertiesTemplate;

    /**
     * 注入系统默认的application.yml属性映射文件
     * @return
     */
    @Autowired
    DruidDatasourceProperties druidDatasourceProperties;
    /**
     * 注入自定义yml属性映射文件
     */
    @Autowired
    CustomDatasourceProperties customDatasourceProperties;

    @Primary
    @Bean(name = "defaultDataSource")
    public DataSource initDefaultDateSource() {
        DataSourceProperties dataSourceProperties = new DataSourceProperties();
        BeanUtils.copyProperties(dsPropertiesTemplate, dataSourceProperties);//将系统的数据源作为bean模板
        if(customDatasourceProperties.isDatabaseDefaultOn()) { //自定义配置中指定了默认数据源，使用自定义的数据库作为数据源
            dataSourceProperties.setUrl(customDatasourceProperties.getDatabaseProperties().getUrl());
            dataSourceProperties.setDriverClassName(customDatasourceProperties.getDatabaseProperties().getDriverClassName());
            dataSourceProperties.setUsername(customDatasourceProperties.getDatabaseProperties().getUsername());
            dataSourceProperties.setPassword(customDatasourceProperties.getDatabaseProperties().getPassword());
        }else {//自定配置项中没有指定默认数据源，使用H2数据库作为数据源
            dataSourceProperties.setUrl(druidDatasourceProperties.getDatabaseH2().getUrl());
            dataSourceProperties.setDriverClassName(druidDatasourceProperties.getDatabaseH2().getDriverClassName());
            dataSourceProperties.setUsername(druidDatasourceProperties.getDatabaseH2().getUsername());
            dataSourceProperties.setPassword(druidDatasourceProperties.getDatabaseH2().getPassword());
        }
        DruidDataSource defaultDataSource = dataSourceProperties.initializeDataSourceBuilder().type(DruidDataSource.class).build();
        defaultDataSource.configFromPropety(druidDatasourceProperties.toProperties(null));
        defaultDataSource.setInitialSize(druidDatasourceProperties.getInitialSize());
        defaultDataSource.setMinIdle(druidDatasourceProperties.getMinIdle());
        defaultDataSource.setMaxActive(druidDatasourceProperties.getMaxActive());
        defaultDataSource.setMaxWait(druidDatasourceProperties.getMaxWait());
        //defaultDataSource.setConnectProperties(druidDatasourceProperties.getConnectionProperties());
        return defaultDataSource;
    }

    /**
     * 目前仅做到静态初始化数据源，暂时未实现动态新增数据源，需要后期继续改造
     * 此处初始化的数据源与配置文件中指定的相对应，配置文件中指定了n个自定义数据源，相应的初始化bean就需要写n个
     * @return
     */
    @Bean(name = "customDataSource1")
    public DataSource initCustomDateSource1() {
        DataSourceProperties customDataSourceProperties = new DataSourceProperties();
        //设置自定义数据源1的基础参数
        customDataSourceProperties.setUrl(customDatasourceProperties.getDatabaseGroup().get(0).getUrl());
        customDataSourceProperties.setDriverClassName(customDatasourceProperties.getDatabaseGroup().get(0).getDriverClassName());
        customDataSourceProperties.setUsername(customDatasourceProperties.getDatabaseGroup().get(0).getUsername());
        customDataSourceProperties.setPassword(customDatasourceProperties.getDatabaseGroup().get(0).getPassword());
        //构建数据源
        DruidDataSource customDatasource = customDataSourceProperties.initializeDataSourceBuilder().type(DruidDataSource.class).build();
        //补充数据源配置参数
        customDatasource.configFromPropety(druidDatasourceProperties.toProperties(getDbType(customDatasourceProperties.getDatabaseGroup().get(0).getUrl())));
        customDatasource.setInitialSize(druidDatasourceProperties.getInitialSize());
        customDatasource.setMinIdle(druidDatasourceProperties.getMinIdle());
        customDatasource.setMaxActive(druidDatasourceProperties.getMaxActive());
        customDatasource.setMaxWait(druidDatasourceProperties.getMaxWait());
        return customDatasource;
    }

    /**
     * 目前仅做到静态初始化数据源，暂时未实现动态新增数据源，需要后期继续改造
     * 此处初始化的数据源与配置文件中指定的相对应，配置文件中指定了n个自定义数据源，相应的初始化bean就需要写n个
     * @return
     */
    @Bean(name = "customDataSource2")
    public DataSource initCustomDateSource2() {
        DataSourceProperties customDataSourceProperties = new DataSourceProperties();
        //设置自定义数据源2的基础参数
        customDataSourceProperties.setUrl(customDatasourceProperties.getDatabaseGroup().get(1).getUrl());
        customDataSourceProperties.setDriverClassName(customDatasourceProperties.getDatabaseGroup().get(1).getDriverClassName());
        customDataSourceProperties.setUsername(customDatasourceProperties.getDatabaseGroup().get(1).getUsername());
        customDataSourceProperties.setPassword(customDatasourceProperties.getDatabaseGroup().get(1).getPassword());
        //构建数据源
        DruidDataSource customDatasource = customDataSourceProperties.initializeDataSourceBuilder().type(DruidDataSource.class).build();
        //补充数据源配置参数
        customDatasource.configFromPropety(druidDatasourceProperties.toProperties(getDbType(customDatasourceProperties.getDatabaseGroup().get(1).getUrl())));
        customDatasource.setInitialSize(druidDatasourceProperties.getInitialSize());
        customDatasource.setMinIdle(druidDatasourceProperties.getMinIdle());
        customDatasource.setMaxActive(druidDatasourceProperties.getMaxActive());
        customDatasource.setMaxWait(druidDatasourceProperties.getMaxWait());
        return customDatasource;
    }

    @Bean(name = "customDataSource3")
    public DataSource initCustomDateSource3() {
        DataSourceProperties customDataSourceProperties = new DataSourceProperties();
        //设置自定义数据源3的基础参数
        customDataSourceProperties.setUrl(customDatasourceProperties.getDatabaseGroup().get(2).getUrl());
        customDataSourceProperties.setDriverClassName(customDatasourceProperties.getDatabaseGroup().get(2).getDriverClassName());
        customDataSourceProperties.setUsername(customDatasourceProperties.getDatabaseGroup().get(2).getUsername());
        customDataSourceProperties.setPassword(customDatasourceProperties.getDatabaseGroup().get(2).getPassword());
        //构建数据源
        DruidDataSource customDatasource = customDataSourceProperties.initializeDataSourceBuilder().type(DruidDataSource.class).build();
        //补充数据源配置参数
        customDatasource.configFromPropety(druidDatasourceProperties.toProperties(getDbType(customDatasourceProperties.getDatabaseGroup().get(2).getUrl())));
        customDatasource.setInitialSize(druidDatasourceProperties.getInitialSize());
        customDatasource.setMinIdle(druidDatasourceProperties.getMinIdle());
        customDatasource.setMaxActive(druidDatasourceProperties.getMaxActive());
        customDatasource.setMaxWait(druidDatasourceProperties.getMaxWait());
        return customDatasource;
    }

    @Bean(name = "dynamicDataSource")
    public DynamicDataSource DataSource(@Qualifier("defaultDataSource") DataSource defaultDs,
                                        @Qualifier("customDataSource1") DataSource customDs1,
                                        @Qualifier("customDataSource2") DataSource customDs2,
                                        @Qualifier("customDataSource3") DataSource customDs3) {
        Map<Object, Object> targetDataSource = new HashMap<>();
        targetDataSource.put("defaultDataSource", defaultDs);
        targetDataSource.put("customDataSource1", customDs1);
        targetDataSource.put("customDataSource2", customDs2);
        targetDataSource.put("customDataSource3", customDs3);
        DynamicDataSource dataSource = new DynamicDataSource();
        dataSource.setTargetDataSources(targetDataSource);
        dataSource.setDefaultTargetDataSource(defaultDs);
        DynamicDataSourceContextHolder.addDatasourceName("defaultDataSource");
        DynamicDataSourceContextHolder.addDatasourceName("customDataSource1");
        DynamicDataSourceContextHolder.addDatasourceName("customDataSource2");
        DynamicDataSourceContextHolder.addDatasourceName("customDataSource3");
        return dataSource;
    }


/*    @Bean(name="dynamicDataSource")
    public DynamicDataSource dynamicDataSource() {
        Map<Object, Object> targetDataSources = new HashMap<>();
        LinkedList<String> datasourceNames = new LinkedList<>();
        DynamicDataSource dynamicDataSource = DynamicDataSource.getInstance();
        Assert.notNull(dataSourceProperties.getType(), "【配置文件参数缺失】无法获取到数据源类型{spring.datasource.type}！");
        DruidDataSource defaultDataSource = (DruidDataSource) dataSourceProperties.initializeDataSourceBuilder()
                .type(DruidDataSource.class)
                .build();
        if(defaultDatasourceProperties() == null) {//属性文件中没有指定默认数据源配置，使用H2数据库配置默认数据源
            defaultDataSource.setUrl(h2DatasourceProperties().getUrl());
            defaultDataSource.setDriverClassName(h2DatasourceProperties().getDriverClassName());
            defaultDataSource.setUsername(h2DatasourceProperties().getUsername());
            defaultDataSource.setPassword(h2DatasourceProperties().getPassword());
        } else {//按照自定义的默认数据源进行参数配置
            defaultDataSource.setUrl(defaultDatasourceProperties().getUrl());
            defaultDataSource.setDriverClassName(defaultDatasourceProperties().getDriverClassName());
            defaultDataSource.setUsername(defaultDatasourceProperties().getUsername());
            defaultDataSource.setPassword(defaultDatasourceProperties().getPassword());
        }
        targetDataSources.put(DynamicDataSourceContextHolder.DEFAULT_DATASOURCE_NAME, defaultDataSource);
        datasourceNames.add(DynamicDataSourceContextHolder.DEFAULT_DATASOURCE_NAME);
        if(customDatasourceProperties != null) {
            Assert.notEmpty(customDatasourceProperties.getDatabaseGroup(), "【配置文件参数缺失】无法获取到自定义数据库属性参数{custom.datasource.database-group}！");
            Assert.isTrue(customDatasourceProperties.getDatabaseGroup().size() < 5, "【参数值超出最大范围限制】自定义数据源数量不能超过5个{custom.datasource.database-group}！");
            //循环创建自定义数据源
            for(int i = 0;i < customDatasourceProperties.getDatabaseGroup().size();i++) {
                DruidDataSource customDatasource = (DruidDataSource) dataSourceProperties.initializeDataSourceBuilder()
                        .type(DruidDataSource.class)
                        .build();
                customDatasource.setUrl(customDatasourceProperties.getDatabaseGroup().get(i).getUrl());
                customDatasource.setDriverClassName(customDatasourceProperties.getDatabaseGroup().get(i).getDriverClassName());
                customDatasource.setUsername(customDatasourceProperties.getDatabaseGroup().get(i).getUsername());
                customDatasource.setPassword(customDatasourceProperties.getDatabaseGroup().get(i).getPassword());
                targetDataSources.put(DynamicDataSourceContextHolder.CUSTOM_DATASOURCE_PREFIX + (i+1),customDatasource);
                datasourceNames.add(DynamicDataSourceContextHolder.CUSTOM_DATASOURCE_PREFIX + (i+1));
            }
        }
        dynamicDataSource.setTargetDataSources(targetDataSources);
        dynamicDataSource.setDefaultTargetDataSource(defaultDataSource);

        DynamicDataSourceContextHolder.initDatasourceName(datasourceNames);

        return dynamicDataSource;
    }*/

    @Bean(name = "sqlSessionFactory")
    public SqlSessionFactory sqlSessionFactory(@Qualifier("dynamicDataSource") DataSource dynamicDataSource)
            throws Exception {
        SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(dynamicDataSource);
        sessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mapper/**/*.xml"));
        sessionFactory.setTypeAliasesPackage("com.one4all.datacenter.connector.service.domain.entity");
        return sessionFactory.getObject();
    }

   @Bean(name = "sqlSessionTemplate")
    public SqlSessionTemplate sqlSessionTemplate(@Qualifier("sqlSessionFactory") SqlSessionFactory dynamicSqlSessionFactory)
            throws Exception {
        return new SqlSessionTemplate(dynamicSqlSessionFactory);
    }

    private String getDbType(String jdbcUrl) {
        String regex = "(?<=\\:).*?(?=\\:)";//获取两个冒号之间的内容（数据库类型）
        Pattern pattern = Pattern.compile(regex);
        Matcher m = pattern.matcher(jdbcUrl);
        while(m.find()) {
            System.out.println(m.group());
            return m.group();
        }
        return "";
    }

}
