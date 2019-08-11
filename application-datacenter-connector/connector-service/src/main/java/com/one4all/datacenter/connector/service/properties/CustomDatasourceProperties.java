package com.one4all.datacenter.connector.service.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * 通过配置文件指定的数据库属性配置
 *
 * @author xiaoqing.liu
 * @since 2019/7/5.
 */
@Component
@ConfigurationProperties(prefix = "custom.datasource")
public class CustomDatasourceProperties {

    private DatabaseProperties databaseDefault = new DatabaseProperties();

    private List<DatabaseProperties> databaseGroup = new ArrayList<>();

    public DatabaseProperties getDatabaseProperties() {
        return databaseDefault;
    }

    public void setDatabaseProperties(DatabaseProperties databaseDefault) {
        this.databaseDefault =  databaseDefault;
    }

    public List<DatabaseProperties> getDatabaseGroup() {
        return databaseGroup;
    }

    public void setDatabaseGroup(List<DatabaseProperties> databaseGroup) {
        this.databaseGroup = databaseGroup;
    }

    public boolean isDatabaseDefaultOn() {
        if(databaseDefault.getUrl() == null || databaseDefault.getUrl().isEmpty()) {
            return false;
        }
        if(databaseDefault.getDriverClassName() == null || databaseDefault.getDriverClassName().isEmpty()) {
            return false;
        }
        if(databaseDefault.getUsername() == null || databaseDefault.getUsername().isEmpty()) {
            return false;
        }
        if(databaseDefault.getPassword() == null) {
            return false;
        }
        return true;
    }
}
