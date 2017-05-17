package com.orienttech.statics.service.model.submission;

import java.util.Date;

import javax.xml.crypto.Data;

import com.orienttech.statics.commons.base.BaseBo;
import com.orienttech.statics.commons.utils.CommonHelper;

/**
 *
 */
public class TblReportTemplateBo  extends BaseBo{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1849795067481632730L;
	private String id;
	private String no;
	private String name;
	private String cycle;
	private Long timeLimit;
	private String sumType;
	private String path;
	private String submitOrg;
	private String checkRole;
	private String state;
	private String workflowId;
	private Date createTime;
	private Date createPeople;
	private String businessExaminePeople;
	private Date businessExamineTime;
	private String statisticsExaminePeople;
	private Date statisticsExamineTime;
	private String financialExaminePeople;
	private Date financialExamineTime;
	private String releasePeople;
	private Date releaseTime;
	private Long startRow;
	
	public TblReportTemplateBo() {
		super();
	}
	
	public TblReportTemplateBo(Object[] objs) {
		super();
		int i=0;
		this.id = CommonHelper.toStr(objs[i++]);
		this.no = CommonHelper.toStr(objs[i++]);
		this.name = CommonHelper.toStr(objs[i++]);
		this.cycle = CommonHelper.toStr(objs[i++]);
		this.timeLimit = CommonHelper.toLong(objs[i++]);
		this.sumType = CommonHelper.toStr(objs[i++]);
		this.path=CommonHelper.toStr(objs[i++]);
		this.submitOrg=CommonHelper.toStr(objs[i++]);
		this.checkRole=CommonHelper.toStr(objs[i++]);
		this.state=CommonHelper.toStr(objs[i++]);
		this.workflowId=CommonHelper.toStr(objs[i++]);
		this.createTime=(Date)objs[i++];
		this.businessExaminePeople=CommonHelper.toStr(objs[i++]);
		this.businessExamineTime=(Date)objs[i++];
		this.statisticsExaminePeople=CommonHelper.toStr(objs[i++]);
		this.statisticsExamineTime=(Date)objs[i++];
		this.financialExaminePeople=CommonHelper.toStr(objs[i++]);
		this.financialExamineTime=(Date)objs[i++];
		this.releasePeople=CommonHelper.toStr(objs[i++]);
		this.releaseTime=(Date)objs[i++];
		this.startRow=CommonHelper.toLong(objs[i++]);
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNo() {
		return no;
	}

	public void setNo(String no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCycle() {
		return cycle;
	}

	public void setCycle(String cycle) {
		this.cycle = cycle;
	}

	public Long getTimeLimit() {
		return timeLimit;
	}

	public void setTimeLimit(Long timeLimit) {
		this.timeLimit = timeLimit;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getSubmitOrg() {
		return submitOrg;
	}

	public void setSubmitOrg(String submitOrg) {
		this.submitOrg = submitOrg;
	}

	public String getCheckRole() {
		return checkRole;
	}

	public void setCheckRole(String checkRole) {
		this.checkRole = checkRole;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getWorkflowId() {
		return workflowId;
	}

	public void setWorkflowId(String workflowId) {
		this.workflowId = workflowId;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getBusinessExaminePeople() {
		return businessExaminePeople;
	}

	public void setBusinessExaminePeople(String businessExaminePeople) {
		this.businessExaminePeople = businessExaminePeople;
	}

	public Date getBusinessExamineTime() {
		return businessExamineTime;
	}

	public void setBusinessExamineTime(Date businessExamineTime) {
		this.businessExamineTime = businessExamineTime;
	}

	public String getStatisticsExaminePeople() {
		return statisticsExaminePeople;
	}

	public void setStatisticsExaminePeople(String statisticsExaminePeople) {
		this.statisticsExaminePeople = statisticsExaminePeople;
	}

	public Date getStatisticsExamineTime() {
		return statisticsExamineTime;
	}

	public void setStatisticsExamineTime(Date statisticsExamineTime) {
		this.statisticsExamineTime = statisticsExamineTime;
	}

	public String getFinancialExaminePeople() {
		return financialExaminePeople;
	}

	public void setFinancialExaminePeople(String financialExaminePeople) {
		this.financialExaminePeople = financialExaminePeople;
	}

	public Date getFinancialExamineTime() {
		return financialExamineTime;
	}

	public void setFinancialExamineTime(Date financialExamineTime) {
		this.financialExamineTime = financialExamineTime;
	}

	public String getReleasePeople() {
		return releasePeople;
	}

	public void setReleasePeople(String releasePeople) {
		this.releasePeople = releasePeople;
	}

	public Date getReleaseTime() {
		return releaseTime;
	}

	public void setReleaseTime(Date releaseTime) {
		this.releaseTime = releaseTime;
	}

	public Long getStartRow() {
		return startRow;
	}

	public void setStartRow(Long startRow) {
		this.startRow = startRow;
	}

	public String getSumType() {
		return sumType;
	}

	public void setSumType(String sumType) {
		this.sumType = sumType;
	}

	public Date getCreatePeople() {
		return createPeople;
	}

	public void setCreatePeople(Date createPeople) {
		this.createPeople = createPeople;
	}

    	
}
