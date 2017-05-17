package com.orienttech.statics.dao.entity;

import static com.orienttech.statics.commons.utils.Contants.TJ_SCHEMA;

import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.orienttech.statics.commons.entity.BaseEntity;
@Entity
@Table(name = "AUTO_EXEC_RECORD", schema = TJ_SCHEMA)
public class AutoExecRecord extends BaseEntity{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1963518584772322368L;
	@EmbeddedId
	private AutoExecRecordPk autoExecRecordPk;
	@Column(name="REPORT_NAME",length=100)
	private String reportName; /* 报表中文名称 */
	@Column(name="REPORT_CODE",length=100)
	private String reportCode; /* 报表代号 */
	@Column(name="REPORT_TYPE",length=100)
	private String reportType; /* 报表格式 PDF spreadsheetML XLSX */
	@Column(name="REPORT_DATE")
	@Temporal(TemporalType.DATE)
	private Date reportDate; /* 报表日期 */
	@Column(name="BUILD_DATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date buildDate; /* 报表日期 */
	
	
	@Column(name="ORG_ID",length=8)
	private String orgId; /* 报表中文名称 */
	
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
	public Date getReportDate() {
		return reportDate;
	}
	public void setReportDate(Date reportDate) {
		this.reportDate = reportDate;
	}
	public AutoExecRecordPk getAutoExecRecordPk() {
		return autoExecRecordPk;
	}
	public void setAutoExecRecordPk(AutoExecRecordPk autoExecRecordPk) {
		this.autoExecRecordPk = autoExecRecordPk;
	}
	public Date getBuildDate() {
		return buildDate;
	}
	public void setBuildDate(Date buildDate) {
		this.buildDate = buildDate;
	}
	public String getOrgId() {
		return orgId;
	}
	public void setOrgId(String orgId) {
		this.orgId = orgId;
	}
	
}
