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
@Table(name = "Tbl_Report_Template", schema = TJ_SCHEMA)
public class TblReportTemplate extends BaseEntity{
	private static final long serialVersionUID = -3943743020630752201L;
	@Id
	//@GeneratedValue(strategy=GenerationType.TABLE)
	@SequenceGenerator(name="SEQ_REPORT_TEMPLATE" , sequenceName="SEQ_REPORT_TEMPLATE",allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="SEQ_REPORT_TEMPLATE")
	@Column(name="ID")
	private Integer id;					//标识符，自增
	@Column(name="NO",length=100)
	private String no;					//报表模版编号
	@Column(name="NAME",length=100)
	private String name;				//报表名称
	@Column(name="CYCLE",length=100)
	private String cycle;				//报表周期
	@Column(name="TIME_LIMIT")
	private Long timeLimit;				//报表时限
	@Column(name="SUM_TYPE",length=100)
	private String sumType;				//汇总方式	
	@Column(name="PATH",length=100)
	private String path;				//存放路径
	@Column(name="SUBMIT_ORG",length=100)
	private String submitOrg;			//提交机构
	@Column(name="CHECK_ROLE",length=100)
	private String checkRole;			//查阅角色
	@Column(name="STATE",length=100)
	private String state;				//报送状态
	@Column(name="WORKFLOW_ID",length=100)
	private String workflowId;			//流程ID
	@Column(name="CREATE_PEOPLE",length=100)
	private String createPeople;		//创建人
	@Temporal(TemporalType.TIMESTAMP)
	private Date createTime;			//创建时间
	@Column(name="BUSINESS_EXAMINE_PEOPLE",length=100)
	private String businessExaminePeople;//报送部门审核人
	@Temporal(TemporalType.TIMESTAMP)
	private Date businessExamineTime;	//报送部门审核人审核时间
	@Column(name="STATISTICS_EXAMINE_PEOPLE",length=100)
	private String statisticsExaminePeople;//电子金融部统计组审核人
	@Temporal(TemporalType.TIMESTAMP)
	private Date statisticsExamineTime;	//电子金融部统计组审核人审核时间
	@Column(name="FINANCIAL_EXAMINE_PEOPLE",length=100)
	private String financialExaminePeople;//电子金融部审批人
	@Temporal(TemporalType.TIMESTAMP)
	private Date financialExamineTime;	//电子金融部审批人审批时间
	@Column(name="RELEASE_PEOPLE",length=100)
	private String releasePeople;		//发布人
	@Temporal(TemporalType.TIMESTAMP)
	private Date releaseTime;			//发布时间
	@Column(name="START_ROW")
	private Long startRow;				//汇总开始行
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
	public Long getTimeLimit() {
		return timeLimit;
	}
	public void setTimeLimit(Long timeLimit) {
		this.timeLimit = timeLimit;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public String getSubmitOrg() {
		return submitOrg;
	}
	public void setSubmitOrg(String submitOrg) {
		this.submitOrg = submitOrg;
	}
	public String getCheckRole() {
		return checkRole;
	}
	public void setCheckRole(String checkRole) {
		this.checkRole = checkRole;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getWorkflowId() {
		return workflowId;
	}
	public void setWorkflowId(String workflowId) {
		this.workflowId = workflowId;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public String getBusinessExaminePeople() {
		return businessExaminePeople;
	}
	public void setBusinessExaminePeople(String businessExaminePeople) {
		this.businessExaminePeople = businessExaminePeople;
	}
	public Date getBusinessExamineTime() {
		return businessExamineTime;
	}
	public void setBusinessExamineTime(Date businessExamineTime) {
		this.businessExamineTime = businessExamineTime;
	}
	public String getStatisticsExaminePeople() {
		return statisticsExaminePeople;
	}
	public void setStatisticsExaminePeople(String statisticsExaminePeople) {
		this.statisticsExaminePeople = statisticsExaminePeople;
	}
	public Date getStatisticsExamineTime() {
		return statisticsExamineTime;
	}
	public void setStatisticsExamineTime(Date statisticsExamineTime) {
		this.statisticsExamineTime = statisticsExamineTime;
	}
	public String getFinancialExaminePeople() {
		return financialExaminePeople;
	}
	public void setFinancialExaminePeople(String financialExaminePeople) {
		this.financialExaminePeople = financialExaminePeople;
	}
	public Date getFinancialExamineTime() {
		return financialExamineTime;
	}
	public void setFinancialExamineTime(Date financialExamineTime) {
		this.financialExamineTime = financialExamineTime;
	}
	public String getReleasePeople() {
		return releasePeople;
	}
	public void setReleasePeople(String releasePeople) {
		this.releasePeople = releasePeople;
	}
	public Date getReleaseTime() {
		return releaseTime;
	}
	public void setReleaseTime(Date releaseTime) {
		this.releaseTime = releaseTime;
	}
	public Long getStartRow() {
		return startRow;
	}
	public void setStartRow(Long startRow) {
		this.startRow = startRow;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getSumTypeStr(){
		String sumTypeStr = "";
		if("1".equals(sumType)){
			sumTypeStr="按行汇总";
		}else if("2".equals(sumType)){
			sumTypeStr="按页汇总";
		}
		return sumTypeStr;
	}
	public String getSumType() {
		return sumType;
	}
	public void setSumType(String sumType) {
		this.sumType = sumType;
	}
	public String getCreatePeople() {
		return createPeople;
	}
	public void setCreatePeople(String createPeople) {
		this.createPeople = createPeople;
	}
	
	
}
