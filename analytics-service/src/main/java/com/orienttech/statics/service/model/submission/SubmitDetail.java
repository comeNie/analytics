package com.orienttech.statics.service.model.submission;

import java.util.Date;

import com.orienttech.statics.commons.utils.CommonHelper;

public class SubmitDetail {
	private String name;
	private String cycle;
	private String no;
	private Date minDate;
	private Date maxDate;
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
	public String getMinDateStr() {
		return CommonHelper.date2Str(minDate, CommonHelper.DF_DATE);
	}
	public String getMaxDateStr() {
		return CommonHelper.date2Str(maxDate, CommonHelper.DF_DATE);
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
	public String getNo() {
		return no;
	}
	public void setNo(String no) {
		this.no = no;
	}
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
	
}
