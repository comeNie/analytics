package com.orienttech.statics.dao.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "fill_form_item", schema = "cognos_data")
public class FillFormItem {

//	private static final long serialVersionUID = 6872424412924383366L;
	@Id
	@Column(name="ITEM_ID",length=8)
	String itemId;
	@Column(name="FORM_ID",length=8)
	String formId;
	@Column(name="FORM_NAME",length=100)
	String formName;
	@Column(name="ITEM_NAME",length=100)
	String itemName;
	
	public FillFormItem() {
	}
	public FillFormItem(String itemId, String formId, String formName,
			String itemName) {
		this.itemId = itemId;
		this.formId = formId;
		this.formName = formName;
		this.itemName = itemName;
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
	public String getFormName() {
		return formName;
	}
	public void setFormName(String formName) {
		this.formName = formName;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
}
