/**
 * 汇总表
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
@Table(name = "TBL_TEMPLATE_SUM", schema = TJ_SCHEMA)
public class TblTemplateSum extends BaseEntity{
	private static final long serialVersionUID = -3943743020630752201L;
	
	@Id
	//@GeneratedValue(strategy=GenerationType.TABLE)
	@SequenceGenerator(name="SEQ_TEMPLATE_SUM" , sequenceName="SEQ_TEMPLATE_SUM",allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="SEQ_TEMPLATE_SUM")
	@Column(name="ID")
	private Integer id;				//编号
	@Column(name="WORKFLOW_ID")
	private String workflowId;		
	@Column(name="TEMPLATE_ID")
	private Integer templateId;		//模版编号
	@Column(name="PATH",length=100)
	private String path;			//存放路径
	@Column(name="SUM_STATE",length=100)
	private String sumState;		//汇总状态
	@Temporal(TemporalType.TIMESTAMP)
	private Date sumTime;			//汇总时间
	@Column(name="SUM_PEOPLE",length=100)
	private String sumPeople;		//汇总人
	@Temporal(TemporalType.TIMESTAMP)
	private Date templateStartTime;	//报表开始时间
	@Temporal(TemporalType.TIMESTAMP)
	private Date templateEndTime;	//报表结束时间
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public String getSumState() {
		return sumState;
	}
	public void setSumState(String sumState) {
		this.sumState = sumState;
	}
	public Date getSumTime() {
		return sumTime;
	}
	public void setSumTime(Date sumTime) {
		this.sumTime = sumTime;
	}
	public String getSumPeople() {
		return sumPeople;
	}
	public void setSumPeople(String sumPeople) {
		this.sumPeople = sumPeople;
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
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getTemplateId() {
		return templateId;
	}
	public void setTemplateId(Integer templateId) {
		this.templateId = templateId;
	}
	public String getWorkflowId() {
		return workflowId;
	}
	public void setWorkflowId(String workflowId) {
		this.workflowId = workflowId;
	}
}
