package com.orienttech.statics.dao.entity.mobile;

import static com.orienttech.statics.commons.utils.Contants.TJ_SCHEMA;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.orienttech.statics.commons.entity.BaseEntity;
@Entity
@Table(name = "MOBILE_BRIEF_REPORT", schema = TJ_SCHEMA)
public class MobileBriefReport extends BaseEntity {
	private static final long serialVersionUID = -8375544680063344333L;
	@Id
	@SequenceGenerator(name="SEQ_MOBILE_SYSTEM" , sequenceName="SEQ_MOBILE_SYSTEM",allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="SEQ_MOBILE_SYSTEM")
	private Integer id;
	
	@Column(name = "DESCRIPTION",length=1000)
	private String description;//摘要
	
	@Column(name = "REPORT_NAME",length=10)
	private String reportName;//报告类别
	
	@Column(name = "REPORT_DESC",length=10)
	private String reportDesc;//报告简称

	@Column(name = "PATH",length=10)
	private String path;//文件路径

	@Column(name = "SUBMIT_TIME",length=10)
	private Date submitTime;//提交时间

	@Column(name = "SUBMIT_ORG_ID",length=10)
	private String submitOrgId;//提交人所在机构

	@Column(name = "SUBMIT_PERSON",length=10)
	private String submitPerson;//提交人
	
	@Column(name = "SUBMIT_PERSON_NAME",length=100)
	private String submitPersonName;//提交人姓名
	
	@Column(name = "BELONGS_ORG_ID",length=100)
	private String belongsOrgId;//信息所属机构
	
	@Column(name = "BUSI_DATE",length=10)
	private String busiDate;//业务日期
	
	public MobileBriefReport() {
		super();
	}
	public MobileBriefReport(Integer id,String description,String reportName,String reportDesc,
							String path,Date submitTime,String submitOrgId,
							String submitPerson,String submitPersonName,String belongsOrgId,String busiDate) {
		this.id = id;
		this.description = description;
		this.reportName = reportName;
		this.reportDesc = reportDesc;
		this.path = path;
		this.submitTime = submitTime;
		this.submitOrgId = submitOrgId;
		this.submitPerson = submitPerson;
		this.submitPersonName = submitPersonName;
		this.belongsOrgId = belongsOrgId;
		this.busiDate = busiDate;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getReportName() {
		return reportName;
	}
	public void setReportName(String reportName) {
		this.reportName = reportName;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public Date getSubmitTime() {
		return submitTime;
	}
	public void setSubmitTime(Date submitTime) {
		this.submitTime = submitTime;
	}
	public String getSubmitOrgId() {
		return submitOrgId;
	}
	public void setSubmitOrgId(String submitOrgId) {
		this.submitOrgId = submitOrgId;
	}
	public String getSubmitPerson() {
		return submitPerson;
	}
	public void setSubmitPerson(String submitPerson) {
		this.submitPerson = submitPerson;
	}
	public String getBelongsOrgId() {
		return belongsOrgId;
	}
	public void setBelongsOrgId(String belongsOrgId) {
		this.belongsOrgId = belongsOrgId;
	}
	public String getBusiDate() {
		return busiDate;
	}
	public void setBusiDate(String busiDate) {
		this.busiDate = busiDate;
	}
	public String getReportDesc() {
		return reportDesc;
	}
	public void setReportDesc(String reportDesc) {
		this.reportDesc = reportDesc;
	}
	public String getSubmitPersonName() {
		return submitPersonName;
	}
	public void setSubmitPersonName(String submitPersonName) {
		this.submitPersonName = submitPersonName;
	}
	
}
