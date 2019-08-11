package com.one4all.datacenter.connector.service.domain.entity.h2;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "SYSTEM_USER")
@Data
public class SystemUser {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Long id;

    @Column(name = "USER_NAME")
    private String userName;

    private long mobile;

    private String operator;

    @Column(name = "CREATE_TIME")
    private Date createTime;

    @Column(name = "UPDATE_TIME")
    private Date updateTime;
}
