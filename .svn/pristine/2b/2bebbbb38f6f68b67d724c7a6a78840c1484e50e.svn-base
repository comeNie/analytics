package com.orienttech.statics.service.model.report;

import java.io.Serializable;
import java.util.Date;

import com.orienttech.statics.commons.utils.CommonHelper;

public class HistoryReportBo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8109657068970354619L;
	
	private String planNo; /* 编号 */
	private String orgName; /* 机构名称*/
	private String reportName; /* 报表中文名称 */
	private String reportCode; /* 报表代号 */
	private String reportType; /* 报表格式 PDF spreadsheetML XLSX */
	private String frequency; /* 1每日 2*每周 3*每月 */
	private String searchPath; /* searchpath */
	private Date reportDate; /* 报表日期 */
	private String filePathName; /* 报表存储完整路径+文件名 */
	private Date buildDate;
	
	public HistoryReportBo(Object[] objs) {
		super();
		int i=0;
		this.orgName=CommonHelper.toStr(objs[i++]);
		this.reportName=CommonHelper.toStr(objs[i++]);
		this.reportDate=(Date)objs[i++];
		this.filePathName=CommonHelper.toStr(objs[i++]);
		this.reportType=CommonHelper.toStr(objs[i++]);
		this.buildDate=(Date)objs[i++];
	}
	public String getPlanNo() {
		return planNo;
	}
	public void setPlanNo(String planNo) {
		this.planNo = planNo;
	}
	public String getOrgName() {
		return orgName;
	}
	public void setOrgName(String orgName) {
		this.orgName = orgName;
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
	public Date getReportDate() {
		return reportDate;
	}
	public String getReportDateStr() {
		return CommonHelper.date2Str(reportDate, CommonHelper.DF_DATE);
	}
	public void setReportDate(Date reportDate) {
		this.reportDate = reportDate;
	}
	public String getFilePathName() {
		return filePathName;
	}
	public void setFilePathName(String filePathName) {
		this.filePathName = filePathName;
	}
	public Date getBuildDate() {
		return buildDate;
	}
	public String getBuildDateStr() {
		return CommonHelper.date2Str(buildDate, CommonHelper.DF_DATE_SHORT_TIME);
	}
	public void setBuildDate(Date buildDate) {
		this.buildDate = buildDate;
	}
	

}
