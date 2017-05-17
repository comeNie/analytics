package com.orienttech.statics.service.model.workflow;


public class NextTaskReceiver {


	/**用户待办数量**/
	private String total;
	/**登录名**/
	private String logName;
	/**显示名称**/
	private String name;
	/**机构ID**/
	private String orgId;
	/**机构名称*/
	private String orgName;
	public String getTotal() {
		return total;
	}
	public void setTotal(String total) {
		this.total = total;
	}
	public String getLogName() {
		return logName;
	}
	public void setLogName(String logName) {
		this.logName = logName;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getOrgId() {
		return orgId;
	}
	public void setOrgId(String orgId) {
		this.orgId = orgId;
	}
	public String getOrgName() {
		return orgName;
	}
	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}
	
}
