package com.one4all.datacenter.connector.service.service;

import com.github.pagehelper.PageInfo;
import com.one4all.datacenter.connector.service.domain.entity.bookplat.SysUser;
import com.one4all.datacenter.connector.service.domain.entity.cm12580.UserInfo;
import com.one4all.datacenter.connector.service.domain.entity.h2.BiOrderTable;
import com.one4all.datacenter.connector.service.domain.entity.h2.SystemUser;

import java.util.List;

public interface ISampleService {

	PageInfo<SysUser> getSysUserAll(String currentPage, String pageSize) throws Exception;

	PageInfo<UserInfo> getUserAll(String currentPage, String pageSize) throws Exception;

	List<BiOrderTable> getOrderAll() throws Exception;

	SystemUser getSystemUser(String userName) throws Exception;

}
