package com.orienttech.statics.dao.entity.fixednum;

import static com.orienttech.statics.commons.utils.Contants.TJ_SCHEMA;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.orienttech.statics.commons.entity.BaseEntity;

/**
 * 机构
 * 
 * @author gph
 * 
 */
@Entity
@Table(name = "ec_org_department", schema = TJ_SCHEMA)
public class EcorgDepartment extends BaseEntity{
	private static final long serialVersionUID = -8375544680063344333L;
	private String id;
	private String parentDepartmentId;
	private String name;
	private String description;
	private Float levels;
	private Float orders;
	private Float state;
	private String bizAttri;
	private String orgAttr;
	private String businessLicense;
	private String principal;
	private String easOrg;

	@Id
	@Column(name="id")
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Column(name="parentdepartmentid")
	public String getParentDepartmentId() {
		return parentDepartmentId;
	}

	public void setParentDepartmentId(String parentDepartmentId) {
		this.parentDepartmentId = parentDepartmentId;
	}

	@Column(name="name")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name="description")
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Column(name="levels")
	public Float getLevels() {
		return levels;
	}

	public void setLevels(Float levels) {
		this.levels = levels;
	}

	@Column(name="orders")
	public Float getOrders() {
		return orders;
	}

	public void setOrders(Float orders) {
		this.orders = orders;
	}

	@Column(name="state")
	public Float getState() {
		return state;
	}

	public void setState(Float state) {
		this.state = state;
	}

	@Column(name="biz_attri")
	public String getBizAttri() {
		return bizAttri;
	}

	public void setBizAttri(String bizAttri) {
		this.bizAttri = bizAttri;
	}

	@Column(name="org_attr")
	public String getOrgAttr() {
		return orgAttr;
	}

	public void setOrgAttr(String orgAttr) {
		this.orgAttr = orgAttr;
	}

	@Column(name="business_license")
	public String getBusinessLicense() {
		return businessLicense;
	}

	public void setBusinessLicense(String businessLicense) {
		this.businessLicense = businessLicense;
	}

	@Column(name="principal")
	public String getPrincipal() {
		return principal;
	}

	public void setPrincipal(String principal) {
		this.principal = principal;
	}

	@Column(name="eas_org")
	public String getEasOrg() {
		return easOrg;
	}

	public void setEasOrg(String easOrg) {
		this.easOrg = easOrg;
	}

}
