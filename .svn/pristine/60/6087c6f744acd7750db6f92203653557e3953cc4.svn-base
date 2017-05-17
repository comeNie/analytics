package com.orienttech.statics.service.model.usermng;

import com.orienttech.statics.commons.base.BaseBo;
import com.orienttech.statics.commons.utils.CommonHelper;

/**
 *
 */
public class UserBo  extends BaseBo{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1849795067481632730L;
	private Long id;
	private String loginName;
	private String userName;
	private String password;
	private String orgCode;
	private String otherOrgCode;
	private String otherOrgName;
	private String orgName;
	private String roleId;
	public UserBo() {
		super();
	}
	
	public UserBo(Object[] objs) {
		super();
		int i=0;
		this.id = CommonHelper.toLong(objs[i++]);
		this.loginName = CommonHelper.toStr(objs[i++]);
		this.userName = CommonHelper.toStr(objs[i++]);
		this.password = CommonHelper.toStr(objs[i++]);
		this.orgCode = CommonHelper.toStr(objs[i++]);
		this.otherOrgCode = CommonHelper.toStr(objs[i++]);
		this.otherOrgName = CommonHelper.toStr(objs[i++]);
		this.roleId = CommonHelper.toStr(objs[i++]);
		this.orgName=CommonHelper.toStr(objs[i++]);
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getLoginName() {
		return loginName;
	}
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public String getOtherOrgCode() {
		return otherOrgCode;
	}

	public void setOtherOrgCode(String otherOrgCode) {
		this.otherOrgCode = otherOrgCode;
	}

	public String getOtherOrgName() {
		return otherOrgName;
	}

	public void setOtherOrgName(String otherOrgName) {
		this.otherOrgName = otherOrgName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getCredentialsSalt() {
		return loginName+password;
	}

	public String getOrgCode() {
		return orgCode;
	}

	public void setOrgCode(String orgCode) {
		this.orgCode = orgCode;
	}

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	public String getOrgName() {
		return orgName;
	}

	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}
}
