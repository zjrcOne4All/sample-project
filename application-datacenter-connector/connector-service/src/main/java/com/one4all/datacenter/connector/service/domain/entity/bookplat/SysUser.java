package com.one4all.datacenter.connector.service.domain.entity.bookplat;

import com.one4all.datacenter.connector.service.domain.entity.BaseEntity;
import lombok.Data;

import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Data
@Table(name = "SYS_USER")
public class SysUser extends BaseEntity {

	@Id
	private String user_id;

	private String user_name;

	private String user_realname;

	private String user_mobile;

	private String user_tel;

	private String user_email;

	private String user_password;

	private String user_unit;

	private String user_is_admin;

	private Date update_date;

	private String operator;

	private String lock_status;
}
