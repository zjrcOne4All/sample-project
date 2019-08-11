package com.one4all.datacenter.connector.service.domain.entity.cm12580;

import javax.persistence.Id;
import javax.persistence.Table;

import com.one4all.datacenter.connector.service.domain.entity.BaseEntity;
import lombok.Data;

@Data
@Table(name = "YYGH_YHXX")
public class UserInfo extends BaseEntity {

	@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String yhid;
	
	private String yhxm;
	
	private String yhmm;
	
	private String yhzsxm;
	
	private String yhxb;
	
	private String yhgh;
	
	private String yhzid;
	
	private String pass_err_num;
	
	private String yhszt;
	
	private String yhmmwtda;
	
	private String yhsjh;
	
	private String yhsfky;
	
	private String yhipzt;
	
	private String rid;
}
