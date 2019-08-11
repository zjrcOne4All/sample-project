package com.one4all.datacenter.connector.service.properties;

import lombok.Data;

@Data
public class DatabaseProperties {

    private String url;

    private String driverClassName;

    private String username;

    private String password;

}
