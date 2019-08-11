package com.one4all.datacenter.connector.service.domain.entity.h2;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PUSH_DATA_TABLE")
public class PushDataTable {
	
	@Id
	@Column(name = "ddid", nullable = false)
	private String ddid;
	
	private String hzid;
	
	private String yyid;
	
	private String ksid;
	
	private String ysid;
	
	private Date czsj;

	public String getDdid() {
		return ddid;
	}

	public void setDdid(String ddid) {
		this.ddid = ddid;
	}

	public String getHzid() {
		return hzid;
	}

	public void setHzid(String hzid) {
		this.hzid = hzid;
	}

	public String getYyid() {
		return yyid;
	}

	public void setYyid(String yyid) {
		this.yyid = yyid;
	}

	public String getKsid() {
		return ksid;
	}

	public void setKsid(String ksid) {
		this.ksid = ksid;
	}

	public String getYsid() {
		return ysid;
	}

	public void setYsid(String ysid) {
		this.ysid = ysid;
	}

	public Date getCzsj() {
		return czsj;
	}

	public void setCzsj(Date czsj) {
		this.czsj = czsj;
	}

}
