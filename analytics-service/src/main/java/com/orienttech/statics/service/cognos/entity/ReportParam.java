package com.orienttech.statics.service.cognos.entity;

public class ReportParam {
	private String name;
	private String val;
	
	public ReportParam(String name, String val) {
		super();
		this.name = name;
		this.val = val;
	}
	
	public ReportParam() {
		super();
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getVal() {
		return val;
	}
	public void setVal(String val) {
		this.val = val;
	}
}
