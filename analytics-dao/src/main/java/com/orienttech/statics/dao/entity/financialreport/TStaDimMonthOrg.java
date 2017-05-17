package com.orienttech.statics.dao.entity.financialreport;

import static com.orienttech.statics.commons.utils.Contants.TJ_SCHEMA;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import javax.persistence.Id;

@Entity
@Table(name = "T_STA_DIM_MONTH_ORG", schema = TJ_SCHEMA)
public class TStaDimMonthOrg {

	@Column(name = "BUSI_MONTH",length=6)
	private String busiMonth;//指标说明
	
	@Column(name="BUSI_DATE")
	private Date busiDate;
	
	@Id
	@Column(name="ORG_ID",length=8)
	private String orgId;//机构ID
	
	@Column(name="ORG_DESC",length=100)
	private String orgDesc;
	
	@Column(name="PARENT_ORG_ID",length=8)
	private String parentOrgId;
	
	@Column(name="PARENT_ORG_DESC",length=100)
	private String parentOrgDesc;
	
	@Column(name="IF_RECOMMEND",length=8)
	private String ifRecommend;
	
	public TStaDimMonthOrg(){
		super();
	}

	public String getBusiMonth() {
		return busiMonth;
	}

	public void setBusiMonth(String busiMonth) {
		this.busiMonth = busiMonth;
	}

	public Date getBusiDate() {
		return busiDate;
	}

	public void setBusiDate(Date busiDate) {
		this.busiDate = busiDate;
	}

	public String getOrgId() {
		return orgId;
	}

	public void setOrgId(String orgId) {
		this.orgId = orgId;
	}

	public String getOrgDesc() {
		return orgDesc;
	}

	public void setOrgDesc(String orgDesc) {
		this.orgDesc = orgDesc;
	}

	public String getParentOrgId() {
		return parentOrgId;
	}

	public void setParentOrgId(String parentOrgId) {
		this.parentOrgId = parentOrgId;
	}

	public String getParentOrgDesc() {
		return parentOrgDesc;
	}

	public void setParentOrgDesc(String parentOrgDesc) {
		this.parentOrgDesc = parentOrgDesc;
	}

	public String getIfRecommend() {
		return ifRecommend;
	}

	public void setIfRecommend(String ifRecommend) {
		this.ifRecommend = ifRecommend;
	}

}
