package com.orienttech.statics.dao.entity;

import static com.orienttech.statics.commons.utils.Contants.TJ_SCHEMA;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.orienttech.statics.commons.entity.BaseEntity;

@Entity
@Table(name = "AUTO_EXEC_PLAN", schema = TJ_SCHEMA)
public class AutoExecPlan extends BaseEntity{
	/**
	 * 
	 */
	private static final long serialVersionUID = -3943743020630752201L;
	/**
	 * 
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	@Column(name="PLAN_NO",length=10)
	private String planNo;
	@Column(name="REPORT_NAME",length=100)
	private String reportName;
	@Column(name="REPORT_CODE",length=100)
	private String reportCode;
	@Column(name="REPORT_TYPE",length=20)
	private String reportType;
	@Column(name="FREQUENCY",length=2)
	private String frequency;
	@Column(name="SEARCHPATH",length=100)
	private String searchPath;
	@Column(name="PLAN_STAT",length=1)
	private String planStat;
	
	@Column(name="ORG_ID",length=8)
	private String orgCd;
	
	public String getPlanNo() {
		return planNo;
	}
	public void setPlanNo(String planNo) {
		this.planNo = planNo;
	}
	public String getReportName() {
		return reportName;
	}
	public void setReportName(String reportName) {
		this.reportName = reportName;
	}
	public String getReportCode() {
		return reportCode;
	}
	public void setReportCode(String reportCode) {
		this.reportCode = reportCode;
	}
	public String getReportType() {
		return reportType;
	}
	public void setReportType(String reportType) {
		this.reportType = reportType;
	}
	public String getFrequency() {
		return frequency;
	}
	public void setFrequency(String frequency) {
		this.frequency = frequency;
	}
	public String getSearchPath() {
		return searchPath;
	}
	public void setSearchPath(String searchPath) {
		this.searchPath = searchPath;
	}
	public String getPlanStat() {
		return planStat;
	}
	public void setPlanStat(String planStat) {
		this.planStat = planStat;
	}
	public String getOrgCd() {
		return orgCd;
	}
	public void setOrgCd(String orgCd) {
		this.orgCd = orgCd;
	}
}
