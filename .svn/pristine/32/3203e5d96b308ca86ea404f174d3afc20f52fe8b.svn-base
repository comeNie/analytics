package com.orienttech.statics.dao.entity;

import static com.orienttech.statics.commons.utils.Contants.TJ_SCHEMA;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import com.orienttech.statics.commons.entity.BaseEntity;
/**
 * 传阅
 * @author wangxy
 *
 */
@Entity
@Table(name = "TBL_PASS_READ", schema = TJ_SCHEMA)
public class PassRead extends BaseEntity {
	
	private static final long serialVersionUID = 6872424412924383366L;
	@Id
	@Column(name="REPORT_SUM_ID",length=10)
	private String reportSumId;//汇总ID
	@Column(name="TEMPLATE_NAME",length=100)
	private String templateName;//模板名称
	@Column(name="PASS_USER_ID",length=100)
	private String passUserId;//传阅发送人ID
	@Column(name="PASS_USER_NAME",length=100)
	private String passUserName;//传阅发送人
	@Column(name="READ_USER_ID",length=100)
	private String readUserId;//传阅接收人ID
	@Column(name="READ_USER_NAME",length=100)
	private String readUserName;//传阅接收人
	
	public PassRead(){
		super();
	}

	public String getReportSumId() {
		return reportSumId;
	}

	public void setReportSumId(String reportSumId) {
		this.reportSumId = reportSumId;
	}

	public String getTemplateName() {
		return templateName;
	}

	public void setTemplateName(String templateName) {
		this.templateName = templateName;
	}

	public String getPassUserId() {
		return passUserId;
	}

	public void setPassUserId(String passUserId) {
		this.passUserId = passUserId;
	}

	public String getPassUserName() {
		return passUserName;
	}

	public void setPassUserName(String passUserName) {
		this.passUserName = passUserName;
	}

	public String getReadUserId() {
		return readUserId;
	}

	public void setReadUserId(String readUserId) {
		this.readUserId = readUserId;
	}

	public String getReadUserName() {
		return readUserName;
	}

	public void setReadUserName(String readUserName) {
		this.readUserName = readUserName;
	}
	

	
}
