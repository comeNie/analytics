/**
 * 指标详情
 */
package com.orienttech.statics.dao.entity.fixednum;

import static com.orienttech.statics.commons.utils.Contants.TJ_SCHEMA;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.orienttech.statics.commons.entity.BaseEntity;

@Entity
@Table(name="t_fin_index_detail", schema = TJ_SCHEMA)
public class FinIndexDetail extends BaseEntity {

	private static final long serialVersionUID = -8375544680063344333L;
	private String indexId;// 指标ID
	private String detailNo;// 指标明细ID
	private String dataSource;// 数据来源：01科目余额 02科目发生额 11资本金固定数 21固定数表 31 业务系统余额
	private Double fractionFlag;// 分数标志:1 分子 -1 分母
	private Double sumFlag;// 汇总标志:1 乘1 -1 乘（-1）
	private String accountNumber;// 科目代码
	private String memo;// 备注

	@Id
	@Column(name="indexid")
	public String getIndexId() {
		return indexId;
	}

	public void setIndexId(String indexId) {
		this.indexId = indexId;
	}

	@Id
	@Column(name="detailno")
	public String getDetailNo() {
		return detailNo;
	}

	public void setDetailNo(String detailNo) {
		this.detailNo = detailNo;
	}

	@Column(name="datasource")
	public String getDataSource() {
		return dataSource;
	}

	public void setDataSource(String dataSource) {
		this.dataSource = dataSource;
	}

	@Column(name="fractionflag")
	public Double getFractionFlag() {
		return fractionFlag;
	}

	public void setFractionFlag(Double fractionFlag) {
		this.fractionFlag = fractionFlag;
	}

	@Column(name="sumflag")
	public Double getSumFlag() {
		return sumFlag;
	}

	public void setSumFlag(Double sumFlag) {
		this.sumFlag = sumFlag;
	}

	@Column(name="accountnumber")
	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	@Column(name="memo")
	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

}
