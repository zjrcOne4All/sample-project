package com.one4all.datacenter.connector.service.repository;

import com.one4all.datacenter.connector.service.domain.entity.h2.SystemUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SystemUserRepository extends JpaRepository<SystemUser, Long> {
    // 自定义查询方法
    SystemUser findByUserName(String name);
}
