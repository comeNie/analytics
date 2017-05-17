package com.orienttech.statics.service.model.submission;

import java.util.Date;

import com.orienttech.statics.commons.utils.CommonHelper;

public class ReportSumVo {
	
	private String templateId;
	
	private String orgName;
	private String reportName;
	private Date releaseTime;
	private Date subTime;
	private Date firstSubTime;
	private String totalSubTimes;
	private String lateDays;
	private String subPeople;
	private String examinePeople;
	private String timeLimit;
	
	public ReportSumVo(Object[] objs) {
		super();
		int i=0;
//		this.templateId=CommonHelper.toStr(objs[i++]);
		this.orgName=CommonHelper.toStr(objs[i++]);
		this.reportName=CommonHelper.toStr(objs[i++]);
		this.releaseTime=(Date)objs[i++];
		this.firstSubTime=(Date)(objs[i++]);
		this.subTime=(Date)(objs[i++]);
		this.totalSubTimes=CommonHelper.toStr(objs[i++]);
		this.lateDays=CommonHelper.toStr(objs[i++]);
		this.subPeople=CommonHelper.toStr(objs[i++]);
		this.examinePeople=CommonHelper.toStr(objs[i++]);
		this.timeLimit=CommonHelper.toStr(objs[i++]);
	}
	
	public String getReleaseTimeStr() {
		return CommonHelper.date2Str(releaseTime, CommonHelper.DF_DATE);
	}
	public String getFirstSubTimeStr() {
		return CommonHelper.date2Str(firstSubTime, CommonHelper.DF_DATE);
	}
	public String getSubTimeStr() {
		return CommonHelper.date2Str(subTime, CommonHelper.DF_DATE);
	}
	public String getTimeLimit() {
		return timeLimit;
	}
	public void setTimeLimit(String timeLimit) {
		this.timeLimit = timeLimit;
	}

	public String getTemplateId() {
		return templateId;
	}
	public void setTemplateId(String templateId) {
		this.templateId = templateId;
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
	public Date getReleaseTime() {
		return releaseTime;
	}
	public void setReleaseTime(Date releaseTime) {
		this.releaseTime = releaseTime;
	}
	public Date getFirstSubTime() {
		return firstSubTime;
	}
	public void setFirstSubTime(Date firstSubTime) {
		this.firstSubTime = firstSubTime;
	}
	public Date getSubTime() {
		return subTime;
	}
	public void setSubTime(Date subTime) {
		this.subTime = subTime;
	}
	public String getTotalSubTimes() {
		return totalSubTimes;
	}
	public void setTotalSubTimes(String totalSubTimes) {
		this.totalSubTimes = totalSubTimes;
	}
	public String getLateDays() {
		return lateDays;
	}
	public void setLateDays(String lateDays) {
		this.lateDays = lateDays;
	}
	public String getSubPeople() {
		return subPeople;
	}
	public void setSubPeople(String subPeople) {
		this.subPeople = subPeople;
	}
	public String getExaminePeople() {
		return examinePeople;
	}
	public void setExaminePeople(String examinePeople) {
		this.examinePeople = examinePeople;
	}
	
	
	
}
