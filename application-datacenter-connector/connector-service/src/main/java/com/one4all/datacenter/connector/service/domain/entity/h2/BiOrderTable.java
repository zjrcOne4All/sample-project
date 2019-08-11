package com.one4all.datacenter.connector.service.domain.entity.h2;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "BI_ORDER_TABLE")
public class BiOrderTable {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "ddid", nullable = false)
	private String ddid;
	
	private String hzid;
	
	private String yyid;
	
	private String yypbid;
	
	private Date czsj;
	
	private String yyrq;
	
	private String yysj;
	
	private String yyxh;
	
	private String sxwbz;
	
	private String qhmm;
	
	private String ddzt;
	
	private String hisjg;
	
	private String qhzt;
	
	private Date qhsj;
	
	private Date jzsj;
	
	private Date yzsj;
	
	private Date ffsj;
	
	private Date qysj;
	
	private String fwsid;
	
	private String czygh;
	
	private String hyid;
	
	private String ksid;
	
	private String hispbid;
	
	private String pbid;
	
	private String ysid;
	
	private String xqj;
	
	private String yyqd;
	
	private Date hisfhsj;
	
	private String jfcl;

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

	public String getYypbid() {
		return yypbid;
	}

	public void setYypbid(String yypbid) {
		this.yypbid = yypbid;
	}

	public Date getCzsj() {
		return czsj;
	}

	public void setCzsj(Date czsj) {
		this.czsj = czsj;
	}

	public String getYyrq() {
		return yyrq;
	}

	public void setYyrq(String yyrq) {
		this.yyrq = yyrq;
	}

	public String getYysj() {
		return yysj;
	}

	public void setYysj(String yysj) {
		this.yysj = yysj;
	}

	public String getYyxh() {
		return yyxh;
	}

	public void setYyxh(String yyxh) {
		this.yyxh = yyxh;
	}

	public String getSxwbz() {
		return sxwbz;
	}

	public void setSxwbz(String sxwbz) {
		this.sxwbz = sxwbz;
	}

	public String getQhmm() {
		return qhmm;
	}

	public void setQhmm(String qhmm) {
		this.qhmm = qhmm;
	}

	public String getDdzt() {
		return ddzt;
	}

	public void setDdzt(String ddzt) {
		this.ddzt = ddzt;
	}

	public String getHisjg() {
		return hisjg;
	}

	public void setHisjg(String hisjg) {
		this.hisjg = hisjg;
	}

	public String getQhzt() {
		return qhzt;
	}

	public void setQhzt(String qhzt) {
		this.qhzt = qhzt;
	}

	public Date getQhsj() {
		return qhsj;
	}

	public void setQhsj(Date qhsj) {
		this.qhsj = qhsj;
	}

	public Date getJzsj() {
		return jzsj;
	}

	public void setJzsj(Date jzsj) {
		this.jzsj = jzsj;
	}

	public Date getYzsj() {
		return yzsj;
	}

	public void setYzsj(Date yzsj) {
		this.yzsj = yzsj;
	}

	public Date getFfsj() {
		return ffsj;
	}

	public void setFfsj(Date ffsj) {
		this.ffsj = ffsj;
	}

	public Date getQysj() {
		return qysj;
	}

	public void setQysj(Date qysj) {
		this.qysj = qysj;
	}

	public String getFwsid() {
		return fwsid;
	}

	public void setFwsid(String fwsid) {
		this.fwsid = fwsid;
	}

	public String getCzygh() {
		return czygh;
	}

	public void setCzygh(String czygh) {
		this.czygh = czygh;
	}

	public String getHyid() {
		return hyid;
	}

	public void setHyid(String hyid) {
		this.hyid = hyid;
	}

	public String getKsid() {
		return ksid;
	}

	public void setKsid(String ksid) {
		this.ksid = ksid;
	}

	public String getHispbid() {
		return hispbid;
	}

	public void setHispbid(String hispbid) {
		this.hispbid = hispbid;
	}

	public String getPbid() {
		return pbid;
	}

	public void setPbid(String pbid) {
		this.pbid = pbid;
	}

	public String getYsid() {
		return ysid;
	}

	public void setYsid(String ysid) {
		this.ysid = ysid;
	}

	public String getXqj() {
		return xqj;
	}

	public void setXqj(String xqj) {
		this.xqj = xqj;
	}

	public String getYyqd() {
		return yyqd;
	}

	public void setYyqd(String yyqd) {
		this.yyqd = yyqd;
	}

	public Date getHisfhsj() {
		return hisfhsj;
	}

	public void setHisfhsj(Date hisfhsj) {
		this.hisfhsj = hisfhsj;
	}

	public String getJfcl() {
		return jfcl;
	}

	public void setJfcl(String jfcl) {
		this.jfcl = jfcl;
	}

}
