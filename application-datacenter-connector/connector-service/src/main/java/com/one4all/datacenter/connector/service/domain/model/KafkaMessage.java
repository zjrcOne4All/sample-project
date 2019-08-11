/**
 * <p>Title: KafkaMessage.java</p>
 * <p>Description:</p>
 * <p>Company: www.sunyard.com</p>
 * @author Liuxq
 * @date 2018年9月11日
 * @version 1.0
 */
package com.one4all.datacenter.connector.service.domain.model;

import java.util.Date;

/**
 * @author Will Liu
 * @date 2018/9/11
 *
 */
public class KafkaMessage {
	
	private Long id;
	
	private String msg;
	
	private Date sendTime;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Date getSendTime() {
		return sendTime;
	}

	public void setSendTime(Date sendTime) {
		this.sendTime = sendTime;
	}

}
