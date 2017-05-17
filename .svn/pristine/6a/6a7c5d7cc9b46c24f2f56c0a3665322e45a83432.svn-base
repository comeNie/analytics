package com.orienttech.statics.dao.entity.mobile;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import static com.orienttech.statics.commons.utils.Contants.TJ_SCHEMA;
import com.orienttech.statics.commons.entity.BaseEntity;

@Entity
@Table(name = "FACT_LOAN_DASHBOARD_WEEK", schema = TJ_SCHEMA)
public class FactLoanDashboardWeek extends BaseEntity {
	private static final long serialVersionUID = -8375544680063344333L;

	@Id
	@Column(name = "dashboard_id",length=3)
	private Integer dashboardId;
	@Column(name = "org_id",length=8)
	private String orgId;
	@Column(name = "org_name",length=100)
	private String orgName;
	@Column(name = "week_ago",length=1)
	private String weekAgo;
	@Column(name = "busi_date")
	private Date busiDate;
	@Column(name = "amt")
	private Float amt;
	@Column(name = "memo", length = 27)
	private String memo;

	public FactLoanDashboardWeek() {
		super();
	}
	
	public FactLoanDashboardWeek(Integer dashboardId, String orgId,
			String orgName, String weekAgo, Date busiDate, Float amt,
			String memo) {
		this.dashboardId = dashboardId;
		this.orgId = orgId;
		this.orgName = orgName;
		this.weekAgo = weekAgo;
		this.busiDate = busiDate;
		this.amt = amt;
		this.memo = memo;
	}

	public Integer getDashboardId() {
		return dashboardId;
	}

	public void setDashboardId(Integer dashboardId) {
		this.dashboardId = dashboardId;
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

	public String getWeekAgo() {
		return weekAgo;
	}

	public void setWeekAgo(String weekAgo) {
		this.weekAgo = weekAgo;
	}

	public Date getBusiDate() {
		return busiDate;
	}

	public void setBusiDate(Date busiDate) {
		this.busiDate = busiDate;
	}

	public Float getAmt() {
		return amt;
	}

	public void setAmt(Float amt) {
		this.amt = amt;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}
	
	
}
