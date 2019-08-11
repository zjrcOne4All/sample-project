package com.one4all.datacenter.connector.service.dao.bookplat;

import com.one4all.datacenter.connector.service.domain.entity.bookplat.SysUser;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

@Repository
public interface SysUserMapper extends Mapper<SysUser> {
	
	/**
	 * 使用tk.mybatis的通用mapper进行单表查询的例子，通用mapper已经覆盖了单表大多数的查询场景
	 * 例如：如果是多表联合查询的场景，则无法使用通用mapper，需要自定义接口方法和SQL语句
	 * @param
	 * @return
	 */
	//public List<SysUser> selectAll();

}
