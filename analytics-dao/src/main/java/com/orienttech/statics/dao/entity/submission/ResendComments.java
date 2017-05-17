/**
 * 报表模版表
 * @author dz
 */
package com.orienttech.statics.dao.entity.submission;

import static com.orienttech.statics.commons.utils.Contants.TJ_SCHEMA;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.orienttech.statics.commons.entity.BaseEntity;

@Entity
@Table(name = "Tbl_Report_Resend_Comments", schema = TJ_SCHEMA)
public class ResendComments extends BaseEntity{
	private static final long serialVersionUID = -3943743020630752201L;
	@Id
	//@GeneratedValue(strategy=GenerationType.TABLE)
	@SequenceGenerator(name="SEQ_REPORT_RESENDCOMMENTS" , sequenceName="SEQ_REPORT_RESENDCOMMENTS",allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="SEQ_REPORT_RESENDCOMMENTS")
	@Column(name="ID")
	private Integer id;					//标识符，自增
	@Column(name="WORKFLOW_ID",length=100)
	private String workflowId;			//流程ID
	@Column(name="TASK_ID",length=100)
	private String taskId;	            
	@Column(name="COMMENTS",length=400)
	private String comments;	        //退回意见
	@Column(name="SUBMIT_TIME",length=100)
	private String submitTime;			//报送时间
	@Temporal(TemporalType.TIMESTAMP)
	private Date resendTime;	//退回时间
	@Column(name="RESEND_PEOPLE",length=100)
	private String resendPeople;		//退回人
	@Column(name="ORG_ID",length=100)
	private String orgId;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getWorkflowId() {
		return workflowId;
	}
	public void setWorkflowId(String workflowId) {
		this.workflowId = workflowId;
	}
	public String getTaskId() {
		return taskId;
	}
	public void setTaskId(String taskId) {
		this.taskId = taskId;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	
	public String getSubmitTime() {
		return submitTime;
	}
	public void setSubmitTime(String submitTime) {
		this.submitTime = submitTime;
	}
	public Date getResendTime() {
		return resendTime;
	}
	public void setResendTime(Date resendTime) {
		this.resendTime = resendTime;
	}
	public String getResendPeople() {
		return resendPeople;
	}
	public void setResendPeople(String resendPeople) {
		this.resendPeople = resendPeople;
	}
	public String getOrgId() {
		return orgId;
	}
	public void setOrgId(String orgId) {
		this.orgId = orgId;
	}
	
	
}
