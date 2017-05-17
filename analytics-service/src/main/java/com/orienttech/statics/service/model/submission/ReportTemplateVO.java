package com.orienttech.statics.service.model.submission;

import java.util.Date;

import com.orienttech.statics.commons.utils.CommonHelper;

public class ReportTemplateVO{
	
	private String name;
	private String cycle;
	private Date startTime;
	private Date endTime;
	private Date subTime;//最后报送时间
	private String orgName;
	private String createPeople;
	private String submitState;
	private String no;
	private Date minDate;
	private Date maxDate;
	private int id;
	private int timeLimit;
	private int submitId;
	
	public ReportTemplateVO() {
		super();
	}
	
	public ReportTemplateVO(Object[] objs) {
		super();
		int i=0;
		this.name=CommonHelper.toStr(objs[i++]);
		this.cycle=CommonHelper.toStr(objs[i++]);
		this.startTime=(Date)objs[i++];
		this.endTime=(Date)(objs[i++]);
		this.subTime=(Date)(objs[i++]);
		this.orgName=CommonHelper.toStr(objs[i++]);
		this.createPeople=CommonHelper.toStr(objs[i++]);
		this.submitState=CommonHelper.toStr(objs[i++]);
		this.id=CommonHelper.toInt(objs[i++]);
		this.timeLimit=CommonHelper.toInt(objs[i++]);
		this.submitId =CommonHelper.toInt(objs[i++]); 
	}
	
	public String getStartTimeStr() {
		return CommonHelper.date2Str(startTime, CommonHelper.DF_DATE);
	}
	public String getEndTimeStr() {
		return CommonHelper.date2Str(endTime, CommonHelper.DF_DATE);
	}
	public String getSubTimeStr() {
		return CommonHelper.date2Str(subTime, CommonHelper.DF_DATE);
	}
	public String getMinDateStr() {
		return CommonHelper.date2Str(minDate, CommonHelper.DF_DATE);
	}
	public String getMaxDateStr() {
		return CommonHelper.date2Str(maxDate, CommonHelper.DF_DATE);
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
	/*public String getSubmitStateStr(){
		String submitStateStr = "";
		Date date = new Date();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
	    long to=0;
	    long from=0;
		try {
			to = df.parse(CommonHelper.date2Str(date, CommonHelper.DF_DATE)).getTime()/(1000 * 60 * 60 * 24);
			from= df.parse(CommonHelper.date2Str(endTime, CommonHelper.DF_DATE)).getTime()/(1000 * 60 * 60 * 24);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		if("0".equals(this.submitState)){
			if((to-from) > timeLimit){
				submitStateStr = "已延迟";
			}else{
				submitStateStr = "未报送";
			}
		}else if("1".equals(this.submitState)){
			submitStateStr = "已报送";
		}else if("3".equals(this.submitState)){
			submitStateStr = "已退回";
		}
		return submitStateStr;
	}*/

	public Date getMinDate() {
		return minDate;
	}

	public void setMinDate(Date minDate) {
		this.minDate = minDate;
	}
	public Date getMaxDate() {
		return maxDate;
	}
	public void setMaxDate(Date maxDate) {
		this.maxDate = maxDate;
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
	public Date getSubTime() {
		return subTime;
	}
	public void setSubTime(Date subTime) {
		this.subTime = subTime;
	}
	public String getOrgName() {
		return orgName;
	}
	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}
	public String getCreatePeople() {
		return createPeople;
	}
	public void setCreatePeople(String createPeople) {
		this.createPeople = createPeople;
	}
	public String getSubmitState() {
		return submitState;
	}
	public void setSubmitState(String submitState) {
		this.submitState = submitState;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getTimeLimit() {
		return timeLimit;
	}
	public void setTimeLimit(int timeLimit) {
		this.timeLimit = timeLimit;
	}
	public int getSubmitId() {
		return submitId;
	}
	public void setSubmitId(int submitId) {
		this.submitId = submitId;
	}
	
}
