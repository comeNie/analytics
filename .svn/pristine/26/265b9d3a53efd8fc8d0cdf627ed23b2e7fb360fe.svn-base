package com.orienttech.statics.dao.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class AutoExecRecordPk implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 4685156011530559661L;
	@Column(name="PLAN_NO",length=10)
	private String planNo; /* 编号 */
	@Column(name="FILEPATHNAME",length=100)
	private String filePathName; /* 报表存储完整路径+文件名 */

	public String getPlanNo() {
		return planNo;
	}

	public void setPlanNo(String planNo) {
		this.planNo = planNo;
	}

	public String getFilePathName() {
		return filePathName;
	}

	public void setFilePathName(String filePathName) {
		this.filePathName = filePathName;
	}
}
