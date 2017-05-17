package com.orienttech.statics.service.model.submission;

import java.util.Date;

import javax.xml.crypto.Data;

import com.orienttech.statics.commons.base.BaseBo;
import com.orienttech.statics.commons.utils.CommonHelper;

/**
 *
 */
public class TblTemplateSubmitBo  extends BaseBo{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1849795067481632730L;
	private String id;
	private String templateId;
	private String orgId;
	private String submitState;
	private Date startTime;
	private Date endTime;
	private String path;
	private String cycle;
	private String workflowId;
	private String submitorgExaminePeople;
	private Date submitorgExamineTime;
	private String releasePeople;
	private Date releaseTime;
	private Date subTime;
	private String subPeople;
	
	public TblTemplateSubmitBo() {
		super();
	}
	
	public TblTemplateSubmitBo(Object[] objs) {
		super();
		int i=0;
		this.id = CommonHelper.toStr(objs[i++]);
		this.templateId = CommonHelper.toStr(objs[i++]);
		this.orgId = CommonHelper.toStr(objs[i++]);
		this.submitState = CommonHelper.toStr(objs[i++]);
		this.startTime = (Date)objs[i++];
		this.endTime = (Date)objs[i++];
		this.path=CommonHelper.toStr(objs[i++]);
		this.cycle=CommonHelper.toStr(objs[i++]);
		this.workflowId=CommonHelper.toStr(objs[i++]);
		this.submitorgExaminePeople=CommonHelper.toStr(objs[i++]);
		this.submitorgExamineTime=(Date)objs[i++];
		this.releasePeople=CommonHelper.toStr(objs[i++]);
		this.releaseTime=(Date)objs[i++];
		this.subTime=(Date)objs[i++];
		this.subPeople=CommonHelper.toStr(objs[i++]);
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}

	public String getTemplateId() {
		return templateId;
	}

	public void setTemplateId(String templateId) {
		this.templateId = templateId;
	}

	public String getOrgId() {
		return orgId;
	}

	public void setOrgId(String orgId) {
		this.orgId = orgId;
	}

	public String getSubmitState() {
		return submitState;
	}

	public void setSubmitState(String submitState) {
		this.submitState = submitState;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getCycle() {
		return cycle;
	}

	public void setCycle(String cycle) {
		this.cycle = cycle;
	}

	public String getWorkflowId() {
		return workflowId;
	}

	public void setWorkflowId(String workflowId) {
		this.workflowId = workflowId;
	}

	public String getSubmitorgExaminePeople() {
		return submitorgExaminePeople;
	}

	public void setSubmitorgExaminePeople(String submitorgExaminePeople) {
		this.submitorgExaminePeople = submitorgExaminePeople;
	}

	public Date getSubmitorgExamineTime() {
		return submitorgExamineTime;
	}

	public void setSubmitorgExamineTime(Date submitorgExamineTime) {
		this.submitorgExamineTime = submitorgExamineTime;
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

	public Date getSubTime() {
		return subTime;
	}

	public void setSubTime(Date subTime) {
		this.subTime = subTime;
	}

	public String getSubPeople() {
		return subPeople;
	}

	public void setSubPeople(String subPeople) {
		this.subPeople = subPeople;
	}
	
}
