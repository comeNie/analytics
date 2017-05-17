package com.orienttech.statics.service.model;

import java.math.BigDecimal;

public class FillFormItemBo {

	private String formId;
	private String itemId;
	private String itemName;
	private String orgId;
	private BigDecimal balance;
	private BigDecimal profit;
	private String memo;
	private String fillDate;
	private String fillTime;
	
	public FillFormItemBo() {
	}
	public FillFormItemBo(String formId, String itemId, String itemName,
			String orgId, BigDecimal balance, BigDecimal profit, String memo,
			String fillDate, String fillTime) {
		this.formId = formId;
		this.itemId = itemId;
		this.itemName = itemName;
		this.orgId = orgId;
		this.balance = balance;
		this.profit = profit;
		this.memo = memo;
		this.fillDate = fillDate;
		this.fillTime = fillTime;
	}

	public String getFormId() {
		return formId;
	}

	public void setFormId(String formId) {
		this.formId = formId;
	}

	public String getItemId() {
		return itemId;
	}

	public void setItemId(String itemId) {
		this.itemId = itemId;
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

	public String getFillDate() {
		return fillDate;
	}

	public void setFillDate(String fillDate) {
		this.fillDate = fillDate;
	}

	public String getFillTime() {
		return fillTime;
	}

	public void setFillTime(String fillTime) {
		this.fillTime = fillTime;
	}
	
	
	
}
