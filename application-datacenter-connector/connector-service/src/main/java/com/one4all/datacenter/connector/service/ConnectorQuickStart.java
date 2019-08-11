package com.one4all.datacenter.connector.service;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@tk.mybatis.spring.annotation.MapperScan("com.one4all.datacenter.connector.service.dao")
public class ConnectorQuickStart {

    public static void main(String[] args) {
        SpringApplication.run(ConnectorQuickStart.class, args);
        System.out.println("开始运行！");
    }


}
