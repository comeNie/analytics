package com.orienttech.statics.dao.entity;

import static com.orienttech.statics.commons.utils.Contants.TJ_SCHEMA;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.orienttech.statics.commons.entity.BaseEntity;

@Entity
@Table(name = "T_STA_DIM_ORG", schema = TJ_SCHEMA)
public class StaDimOrg extends BaseEntity {
	private static final long serialVersionUID = -8375544680063344333L;

	@Id
	@Column(name = "ORGID", length = 8, nullable = false)
	private String orgId;

	@Column(name = "NAME", length = 100)
	private String name;

	@Column(name = "DESCRIPTION", length = 100)
	private String description;

	@Column(name = "ORGID1", length = 8)
	private String orgId1;

	public String getOrgId() {
		return orgId;
	}

	public void setOrgId(String orgId) {
		this.orgId = orgId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getOrgId1() {
		return orgId1;
	}

	public void setOrgId1(String orgId1) {
		this.orgId1 = orgId1;
	}

}
