package com.one4all.datacenter.connector.service.service.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.one4all.datacenter.connector.service.annotation.TargetDataSource;
import com.one4all.datacenter.connector.service.dao.bookplat.SysUserMapper;
import com.one4all.datacenter.connector.service.dao.cm12580.UserInfoMapper;
import com.one4all.datacenter.connector.service.dao.h2.H2OrderMapper;
import com.one4all.datacenter.connector.service.domain.entity.bookplat.SysUser;
import com.one4all.datacenter.connector.service.domain.entity.cm12580.UserInfo;
import com.one4all.datacenter.connector.service.domain.entity.h2.BiOrderTable;
import com.one4all.datacenter.connector.service.domain.entity.h2.SystemUser;
import com.one4all.datacenter.connector.service.repository.SystemUserRepository;
import com.one4all.datacenter.connector.service.service.ISampleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SampleService implements ISampleService {

    @Autowired
    private H2OrderMapper h2OrderMapper;

    @Autowired
    private UserInfoMapper userInfoMapper;

    @Autowired
    private SysUserMapper sysUserMapper;

    @Autowired
    private SystemUserRepository systemUserRepo;


    @Override
    @TargetDataSource("customDataSource2")
    public PageInfo<SysUser> getSysUserAll(String currentPage, String pageSize) throws Exception {
        PageHelper.startPage(currentPage == null ? 1 : Integer.parseInt(currentPage), pageSize == null ? 10 : Integer.parseInt(pageSize));
        List<SysUser> sysUserList = sysUserMapper.selectAll();
        PageInfo<SysUser> pageInfo = new PageInfo<>(sysUserList);
        return pageInfo;
    }

    @Override
    @TargetDataSource("customDataSource1")
    public PageInfo<UserInfo> getUserAll(String currentPage, String pageSize) throws Exception {
        PageHelper.startPage(currentPage == null ? 1 : Integer.parseInt(currentPage), pageSize == null ? 10 : Integer.parseInt(pageSize));
        List<UserInfo> userList = userInfoMapper.selectAll();
        PageInfo<UserInfo> pageInfo = new PageInfo<>(userList);
        return pageInfo;
    }

    @Override
    @TargetDataSource("defaultDataSource")
    public List<BiOrderTable> getOrderAll() throws Exception {
        List<BiOrderTable> orderList = h2OrderMapper.selectAll();
        return orderList;
    }

    @Override
    @TargetDataSource("defaultDataSource")
    public SystemUser getSystemUser(String userName) throws Exception {
        SystemUser systemUser = systemUserRepo.findByUserName(userName);
        return systemUser;
    }
}
