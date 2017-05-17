package com.orienttech.statics.dao.entity.financialreport;

import static com.orienttech.statics.commons.utils.Contants.TJ_SCHEMA;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.orienttech.statics.commons.entity.BaseEntity;

/**   
 * 类名称：FactLoanReportPeriod
 * 类描述 ：指标表
 * 创建人:wangxy
 * 创建时间：2015年7月18日 下午2:08:52  
 * 修改人：wangxy
 * 修改时间：
 * 修改备注：
 * 版本： V1.0
 */
@Entity
@Table(name = "FACT_LOAN_REPORT_PERIOD", schema = TJ_SCHEMA)
public class FactLoanReportPeriod extends BaseEntity {
	/**
	 * serialVersionUID,用于版本控制,保持版本的兼容性
	 */
	private static final long serialVersionUID = -3702677297360646614L;
	@Id
	@Column(name = "REPORT_ID")
	private String reportId;//指标说明
	@Column(name="BUSI_PERIOD",length=200)
	private String busiPeriod;//年度月份旬
	@Column(name="RANK_NUM",length=200)
	private Integer rankNum;//排名
	@Column(name="ORG_ID")
	private String orgId;//机构代码
	@Column(name="ORG_NAME",length=200)
	private String orgName;//机构名称
	
	@Column(name="APPLY_USER_ID")
	private String applyUserId;//人员代码
	
	@Column(name="APPLY_USER_NAME",length=200)
	private String applyUserName;//人员姓名
	
	@Column(name="AMT1",length=200)
	private BigDecimal amt1;//数值1
	
	@Column(name="AMT2",length=200)
	private BigDecimal amt2;//数值2
	
	@Column(name="AMT3",length=200)
	private BigDecimal amt3;//数值3
	
	@Column(name="MEMO",length=200)
	private String memo;//备注
	
	public FactLoanReportPeriod(){
		super();
	}
	
	public FactLoanReportPeriod(String reportId, String busiPeriod, Integer rankNum, 
			String orgId, String orgName, String applyUserId, String applyUserName, 
			BigDecimal amt1, BigDecimal amt2, BigDecimal amt3, String memo) {
			super();
			this.reportId = reportId;
			this.busiPeriod = busiPeriod;
			this.rankNum = rankNum;
			this.orgId = orgId;
			this.orgName = orgName;
			this.applyUserId = applyUserId;
			this.applyUserName = applyUserName;
			this.amt1 = amt1;
			this.amt2 = amt2;
			this.amt3 = amt3;
			this.memo = memo;
	}
	
	public FactLoanReportPeriod(String busiPeriod){
			super();
			this.busiPeriod = busiPeriod;
	}
	
	public String getReportId() {
		return reportId;
	}

	public void setReportId(String reportId) {
		this.reportId = reportId;
	}

	public String getBusiPeriod() {
		return busiPeriod;
	}

	public void setBusiPeriod(String busiPeriod) {
		this.busiPeriod = busiPeriod;
	}

	public Integer getRankNum() {
		return rankNum;
	}

	public void setRankNum(Integer rankNum) {
		this.rankNum = rankNum;
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

	public String getApplyUserId() {
		return applyUserId;
	}

	public void setApplyUserId(String applyUserId) {
		this.applyUserId = applyUserId;
	}

	public String getApplyUserName() {
		return applyUserName;
	}

	public void setApplyUserName(String applyUserName) {
		this.applyUserName = applyUserName;
	}

	public BigDecimal getAmt1() {
		return amt1;
	}

	public void setAmt1(BigDecimal amt1) {
		this.amt1 = amt1;
	}

	public BigDecimal getAmt2() {
		return amt2;
	}

	public void setAmt2(BigDecimal amt2) {
		this.amt2 = amt2;
	}

	public BigDecimal getAmt3() {
		return amt3;
	}

	public void setAmt3(BigDecimal amt3) {
		this.amt3 = amt3;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}
}
