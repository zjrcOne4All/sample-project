package com.one4all.datacenter.connector.service.domain.model.vo;

import java.io.Serializable;
import java.util.Date;

public class TPatient implements Serializable {
	
    private Long patientId;

    private String patientName;

    private String patientIdCardType;

    private String patientIdCard;

    private String patientSex;

    private String patientMediCardType;

    private String patientMediCard;

    private Short patientMediFlag;

    private String patientMobile;

    private String patientTele;

    private String patientAddr;

    private String patientPostCode;

    private String registerFrom;

    private Date registerTime;

    private Short patientState;

    private String operNo;

    private Date updateTime;

    private Short orderState;

    // 患者身份证有效期开始时间 
    private String shengxsj;

    // 患者身份证有效期结束时间 
    private String shixsj;

    // 是否经过实名认证，1表示已认证，其他表示未认证 
    private String smrz;

    private static final long serialVersionUID = 1L;
    
    public Long getPatientId() {
        return patientId;
    }

    public void setPatientId(Long patientId) {
        this.patientId = patientId;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getPatientIdCardType() {
        return patientIdCardType;
    }

    public void setPatientIdCardType(String patientIdCardType) {
        this.patientIdCardType = patientIdCardType;
    }

    public String getPatientIdCard() {
        return patientIdCard;
    }

    public void setPatientIdCard(String patientIdCard) {
        this.patientIdCard = patientIdCard;
    }

    public String getPatientSex() {
        return patientSex;
    }

    public void setPatientSex(String patientSex) {
        this.patientSex = patientSex;
    }

    public String getPatientMediCardType() {
        return patientMediCardType;
    }

    public void setPatientMediCardType(String patientMediCardType) {
        this.patientMediCardType = patientMediCardType;
    }

    public String getPatientMediCard() {
        return patientMediCard;
    }

    public void setPatientMediCard(String patientMediCard) {
        this.patientMediCard = patientMediCard;
    }

    public Short getPatientMediFlag() {
        return patientMediFlag;
    }

    public void setPatientMediFlag(Short patientMediFlag) {
        this.patientMediFlag = patientMediFlag;
    }

    public String getPatientMobile() {
        return patientMobile;
    }

    public void setPatientMobile(String patientMobile) {
        this.patientMobile = patientMobile;
    }

    public String getPatientTele() {
        return patientTele;
    }

    public void setPatientTele(String patientTele) {
        this.patientTele = patientTele;
    }

    public String getPatientAddr() {
        return patientAddr;
    }

    public void setPatientAddr(String patientAddr) {
        this.patientAddr = patientAddr;
    }

    public String getPatientPostCode() {
        return patientPostCode;
    }

    public void setPatientPostCode(String patientPostCode) {
        this.patientPostCode = patientPostCode;
    }

    public String getRegisterFrom() {
        return registerFrom;
    }

    public void setRegisterFrom(String registerFrom) {
        this.registerFrom = registerFrom;
    }

    public Date getRegisterTime() {
        return registerTime;
    }

    public void setRegisterTime(Date registerTime) {
        this.registerTime = registerTime;
    }

    public Short getPatientState() {
        return patientState;
    }

    public void setPatientState(Short patientState) {
        this.patientState = patientState;
    }

    public String getOperNo() {
        return operNo;
    }

    public void setOperNo(String operNo) {
        this.operNo = operNo;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Short getOrderState() {
        return orderState;
    }

    public void setOrderState(Short orderState) {
        this.orderState = orderState;
    }

	public String getShengxsj() {
		return shengxsj;
	}

	public void setShengxsj(String shengxsj) {
		this.shengxsj = shengxsj;
	}

	public String getShixsj() {
		return shixsj;
	}

	public void setShixsj(String shixsj) {
		this.shixsj = shixsj;
	}

	public String getSmrz() {
		return smrz;
	}

	public void setSmrz(String smrz) {
		this.smrz = smrz;
	}
}