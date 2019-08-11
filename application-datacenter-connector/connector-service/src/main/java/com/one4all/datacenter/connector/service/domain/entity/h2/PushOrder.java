package com.one4all.datacenter.connector.service.domain.entity.h2;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PUSH_ORDER")
public class PushOrder {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Long id;
	private String hospitalId;
	private Long deptId;
	private Long docId;
	private String patientIdCard;
	private String patientBirth;
	private String patientMobileSection;
	private String orderTime;
	private String patientSex;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getHospitalId() {
		return hospitalId;
	}

	public void setHospitalId(String hospitalId) {
		this.hospitalId = hospitalId;
	}

	public Long getDeptId() {
		return deptId;
	}

	public void setDeptId(Long deptId) {
		this.deptId = deptId;
	}

	public Long getDocId() {
		return docId;
	}

	public void setDocId(Long docId) {
		this.docId = docId;
	}

	public String getPatientIdCard() {
		return patientIdCard;
	}

	public void setPatientIdCard(String patientIdCard) {
		this.patientIdCard = patientIdCard;
	}

	public String getPatientBirth() {
		return patientBirth;
	}

	public void setPatientBirth(String patientBirth) {
		this.patientBirth = patientBirth;
	}

	public String getPatientMobileSection() {
		return patientMobileSection;
	}

	public void setPatientMobileSection(String patientMobileSection) {
		this.patientMobileSection = patientMobileSection;
	}

	public String getOrderTime() {
		return orderTime;
	}

	public void setOrderTime(String orderTime) {
		this.orderTime = orderTime;
	}

	public String getPatientSex() {
		return patientSex;
	}

	public void setPatientSex(String patientSex) {
		this.patientSex = patientSex;
	}

}
