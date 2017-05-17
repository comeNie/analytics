package com.orienttech.statics.dao.entity;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "fill_form_capital_position", schema = "cognos_data")
public class FillFormCapitalPosition {

//	private static final long serialVersionUID = 6872424412924383366L;
	@Id
	@Column(name="ITEM_ID",length=8)
	String itemId;
	@Column(name="FORM_ID",length=8)
	String formId;
	@Column(name="ITEM_NAME",length=100)
	String itemName;
	@Column(name="ORG_ID",length=8)
	String orgId;
	@Column(name="FILL_DATE")
	Date fillDate;
	@Column(name="BALANCE")
	BigDecimal balance;
	@Column(name="PROFIT")
	BigDecimal profit;
	@Column(name="MEMO",length=1000)
	String memo;
	@Column(name="FILL_USER",length=50)
	String fillUser;
	@Column(name="FILL_TIME")
	Date fillTime;
	public FillFormCapitalPosition() {
	}
	public FillFormCapitalPosition(String itemId, String formId,
			String itemName, String orgId, Date fillDate, BigDecimal balance,
			BigDecimal profit, String memo, String fillUser, Date fillTime) {
		this.itemId = itemId;
		this.formId = formId;
		this.itemName = itemName;
		this.orgId = orgId;
		this.fillDate = fillDate;
		this.balance = balance;
		this.profit = profit;
		this.memo = memo;
		this.fillUser = fillUser;
		this.fillTime = fillTime;
	}
	public String getItemId() {
		return itemId;
	}
	public void setItemId(String itemId) {
		this.itemId = itemId;
	}
	public String getFormId() {
		return formId;
	}
	public void setFormId(String formId) {
		this.formId = formId;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public String getOrgId() {
		return orgId;
	}
	public void setOrgId(String orgId) {
		this.orgId = orgId;
	}
	public Date getFillDate() {
		return fillDate;
	}
	public void setFillDate(Date fillDate) {
		this.fillDate = fillDate;
	}
	public BigDecimal getBalance() {
		return balance;
	}
	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}
	public BigDecimal getProfit() {
		return profit;
	}
	public void setProfit(BigDecimal profit) {
		this.profit = profit;
	}
	public String getMemo() {
		return memo;
	}
	public void setMemo(String memo) {
		this.memo = memo;
	}
	public String getFillUser() {
		return fillUser;
	}
	public void setFillUser(String fillUser) {
		this.fillUser = fillUser;
	}
	public Date getFillTime() {
		return fillTime;
	}
	public void setFillTime(Date fillTime) {
		this.fillTime = fillTime;
	}
}
