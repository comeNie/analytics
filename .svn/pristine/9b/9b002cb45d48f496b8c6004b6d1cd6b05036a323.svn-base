package com.orienttech.statics.service.model.submission;

import java.io.Serializable;
import java.util.Date;

import com.orienttech.statics.commons.utils.CommonHelper;

public class SubmitDetailVO  implements Serializable{
	private String name;
	private String cycle;
	private Date templateStartTime;
	private Date templateEndTime;
	private String sumState;
	private String releasePeople;
	private int id;
	private String accept;
	private String workflowId;
	private String createPeople;
	
	
	public String getCreatePeople() {
		return createPeople;
	}
	public void setCreatePeople(String createPeople) {
		this.createPeople = createPeople;
	}
	public String getTemplateStartTimeStr() {
		return CommonHelper.date2Str(templateStartTime, CommonHelper.DF_DATE);
	}
	public String getTemplateEndTimeStr() {
		return CommonHelper.date2Str(templateEndTime, CommonHelper.DF_DATE);
	}
	public String getSumStateStr(){
		String subStateStr ="";
		if("0".equals(sumState)){
			subStateStr="未汇总";
		}else if("1".equals(sumState)){
			subStateStr="已汇总";
		}else if("2".equals(sumState)){
			subStateStr="已发布";
		}
		return subStateStr;
	}
	public String getCycleStr(){
		String cycleStr ="";
		if("1".equals(cycle)){
			cycleStr="一次性填报";
		}else if("2".equals(cycle)){
			cycleStr="年报";
		}else if("3".equals(cycle)){
			cycleStr="半年报";
		}else if("4".equals(cycle)){
			cycleStr="季报";
		}else if("5".equals(cycle)){
			cycleStr="月报";
		}else if("6".equals(cycle)){
			cycleStr="旬报";
		}else if("7".equals(cycle)){
			cycleStr="周报";
		}
		return cycleStr;
	}
	public SubmitDetailVO(Object[] objs) {
		super();
		int i=0;
		this.name=CommonHelper.toStr(objs[i++]);
		this.cycle=CommonHelper.toStr(objs[i++]);
		this.templateStartTime=(Date)objs[i++];
		this.templateEndTime=(Date)(objs[i++]);
		this.sumState=CommonHelper.toStr(objs[i++]);
		this.createPeople=CommonHelper.toStr(objs[i++]);
		this.id=CommonHelper.toInt(objs[i++]);
		this.workflowId=CommonHelper.toStr(objs[i++]);
	}
	public String getWorkflowId() {
		return workflowId;
	}
	public void setWorkflowId(String workflowId) {
		this.workflowId = workflowId;
	}
	public String getAccept() {
		return accept;
	}

	public void setAccept(String accept) {
		this.accept = accept;
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
	public Date getTemplateStartTime() {
		return templateStartTime;
	}
	public void setTemplateStartTime(Date templateStartTime) {
		this.templateStartTime = templateStartTime;
	}
	public Date getTemplateEndTime() {
		return templateEndTime;
	}
	public void setTemplateEndTime(Date templateEndTime) {
		this.templateEndTime = templateEndTime;
	}
	public String getSumState() {
		return sumState;
	}
	public void setSumState(String sumState) {
		this.sumState = sumState;
	}
	public String getReleasePeople() {
		return releasePeople;
	}
	public void setReleasePeople(String releasePeople) {
		this.releasePeople = releasePeople;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	
}
