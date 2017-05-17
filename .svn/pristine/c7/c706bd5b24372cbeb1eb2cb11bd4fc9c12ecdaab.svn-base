package com.orienttech.statics.dao.entity.financialreport;

import static com.orienttech.statics.commons.utils.Contants.TJ_SCHEMA;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
/**   
 * 类名称：FactLoanReportMoth
 * 类描述 ：指标表
 * 创建人:liqiao
 * 创建时间：2015年7月28日 下午2:08:52  
 * 修改人：liqiao
 * 修改时间：
 * 修改备注：
 * 版本： V1.0
 */
@Entity
@Table(name = "RISK_REPORT_MONTH", schema = TJ_SCHEMA)
public class RiskReportMonth {
	/**
	 * serialVersionUID,用于版本控制,保持版本的兼容性
	 */
	private static final long serialVersionUID = -3702677297360646614L;
	@Id
	@Column(name = "REPORT_ID")
	private String reportId;//指标说明
	
	@Column(name="BUSI_PERIOD",length=200)
	private String busiPeriod;//年度月份旬
	
	@Column(name="ORG_NAME",length=200)
	private String orgName;//机构名称
	
	@Column(name="ORG_AREA",length=200)
	private String orgarea;//机构区域
	
	@Column(name="ORG_CNT",length=200)
	private Integer orgcnt;//机构数
	
	@Column(name="CLASSIFY",length=200)
	private String classify;//分类区间
	
	@Column(name="RANK_NUM",length=200)
	private Integer rankNum;//排名
	
	@Column(name="AMT1",length=200)
	private BigDecimal amt1;//数值1
	
	@Column(name="AMT2",length=200)
	private BigDecimal amt2;//数值2
	
	@Column(name="AMT3",length=200)
	private BigDecimal amt3;//数值3
	
	@Column(name="AMT4",length=200)
	private BigDecimal amt4;//数值4
	
	@Column(name="AMT5",length=200)
	private BigDecimal amt5;//数值5
	
	@Column(name="AMT6",length=200)
	private BigDecimal amt6;//数值6
	
	@Column(name="AMT7",length=200)
	private BigDecimal amt7;//数值7
	
	@Column(name="AMT8",length=200)
	private BigDecimal amt8;//数值8
	
	@Column(name="AMT9",length=200)
	private BigDecimal amt9;//数值9
	
	@Column(name="AMT10",length=200)
	private BigDecimal amt10;//数值10
	
	@Column(name="AMT11",length=200)
	private BigDecimal amt11;//数值11
	
	@Column(name="MEMO",length=200)
	private String memo;//备注
	
	private BigDecimal dtabl;//比上月末新增
	private BigDecimal etabl;//环比去年12月新增
	
	public RiskReportMonth(){
		super();
	}
	
	public RiskReportMonth(String reportId, String busiPeriod,  
			String orgId, String orgName,String orgarea, Integer orgcnt, String classify,Integer rankNum,
			BigDecimal amt1, BigDecimal amt2, BigDecimal amt3, BigDecimal amt4, BigDecimal amt5,
			BigDecimal amt6, BigDecimal amt7, BigDecimal amt8, BigDecimal amt9, BigDecimal amt10,BigDecimal amt11,String memo) {
			super();
			this.reportId = reportId;
			this.busiPeriod = busiPeriod;
			this.orgName = orgName;
			this.orgarea = orgarea;
			this.orgcnt = orgcnt;
			this.classify = classify;
			this.rankNum = rankNum;
			this.amt1 = amt1;
			this.amt2 = amt2;
			this.amt3 = amt3;
			this.amt4 = amt4;
			this.amt5 = amt5;
			this.amt6 = amt6;
			this.amt7 = amt7;
			this.amt8 = amt8;
			this.amt9 = amt9;
			this.amt10 = amt10;
			this.amt11 = amt11;
			this.memo = memo;
	}
	
	public RiskReportMonth(String busiPeriod){
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

	public String getOrgName() {
		return orgName;
	}

	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}

	public String getOrgarea() {
		return orgarea;
	}

	public void setOrgarea(String orgarea) {
		this.orgarea = orgarea;
	}

	public Integer getOrgcnt() {
		return orgcnt;
	}

	public void setOrgcnt(Integer orgcnt) {
		this.orgcnt = orgcnt;
	}

	public String getClassify() {
		return classify;
	}

	public void setClassify(String classify) {
		this.classify = classify;
	}

	public Integer getRankNum() {
		return rankNum;
	}

	public void setRankNum(Integer rankNum) {
		this.rankNum = rankNum;
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

	public BigDecimal getAmt4() {
		return amt4;
	}

	public void setAmt4(BigDecimal amt4) {
		this.amt4 = amt4;
	}

	public BigDecimal getAmt5() {
		return amt5;
	}

	public void setAmt5(BigDecimal amt5) {
		this.amt5 = amt5;
	}

	public BigDecimal getAmt6() {
		return amt6;
	}

	public void setAmt6(BigDecimal amt6) {
		this.amt6 = amt6;
	}

	public BigDecimal getAmt7() {
		return amt7;
	}

	public void setAmt7(BigDecimal amt7) {
		this.amt7 = amt7;
	}

	public BigDecimal getAmt8() {
		return amt8;
	}

	public void setAmt8(BigDecimal amt8) {
		this.amt8 = amt8;
	}

	public BigDecimal getAmt9() {
		return amt9;
	}

	public void setAmt9(BigDecimal amt9) {
		this.amt9 = amt9;
	}

	public BigDecimal getAmt10() {
		return amt10;
	}

	public void setAmt10(BigDecimal amt10) {
		this.amt10 = amt10;
	}

	public BigDecimal getAmt11() {
		return amt11;
	}

	public void setAmt11(BigDecimal amt11) {
		this.amt11 = amt11;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	public BigDecimal getDtabl() {
		return dtabl;
	}

	public void setDtabl(BigDecimal dtabl) {
		this.dtabl = dtabl;
	}

	public BigDecimal getEtabl() {
		return etabl;
	}

	public void setEtabl(BigDecimal etabl) {
		this.etabl = etabl;
	}
	

}
