package com.one4all.datacenter.connector.service.domain.model.vo;

import java.io.Serializable;

public class OrderCount implements Serializable {

	/** serialVersionUID */
	private static final long serialVersionUID = 1L;

	private String hzsjh;
	private int cnt;// 预约次数

	public String getHzsjh() {
		return hzsjh;
	}

	public void setHzsjh(String hzsjh) {
		this.hzsjh = hzsjh;
	}

	public int getCnt() {
		return cnt;
	}

	public void setCnt(int cnt) {
		this.cnt = cnt;
	}
}
