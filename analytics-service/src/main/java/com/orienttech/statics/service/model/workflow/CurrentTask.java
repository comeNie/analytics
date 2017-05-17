package com.orienttech.statics.service.model.workflow;


public class CurrentTask{
	private String currentAssigneerName;//当前所处环节处理人名称
	private String currentAssigneer;//当前所处环节任务处理人账号
	private String currentStage;//当前所处环节号
	private String taskId;//任务ID
	
	public CurrentTask(){}
	
	public CurrentTask(String taskId,String currentAssigneer,String currentAssigneerName,String currentStage){
		this.taskId = taskId;
		this.currentAssigneer = currentAssigneer;
		this.currentAssigneerName = currentAssigneerName;
		this.currentStage = currentStage;
	}
	
	public CurrentTask(Object[] obj){
		super();
		int index = 0;
		this.setTaskId(toStr(obj[index++]));
		this.setCurrentAssigneer(toStr(obj[index++]));
		this.setCurrentAssigneerName(toStr(obj[index++]));
		this.setCurrentStage(toStr(obj[index++]));
	}
	
	public String getCurrentAssigneer() {
		return currentAssigneer;
	}
	public void setCurrentAssigneer(String currentAssigneer) {
		this.currentAssigneer = currentAssigneer;
	}
	public String getCurrentAssigneerName() {
		return currentAssigneerName;
	}
	public void setCurrentAssigneerName(String currentAssigneerName) {
		this.currentAssigneerName = currentAssigneerName;
	}
	public String getCurrentStage() {
		return currentStage;
	}
	public void setCurrentStage(String currentStage) {
		this.currentStage = currentStage;
	}
	public String getTaskId() {
		return taskId;
	}
	public void setTaskId(String taskId) {
		this.taskId = taskId;
	}
	private String toStr(Object obj) {
		return obj == null ? null : obj.toString();
	}
	
}
