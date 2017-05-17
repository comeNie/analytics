package com.orienttech.statics.dao.entity;

import static com.orienttech.statics.commons.utils.Contants.TJ_SCHEMA;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.orienttech.statics.commons.entity.BaseEntity;

/**
 * 用户使用功能日志，用于统计（功能使用率）
 *
 */
@Entity
@Table(name = "TB_USER_LOG", schema = TJ_SCHEMA)
public class UserLog extends BaseEntity{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8275127878403661052L;
	@Id
	@SequenceGenerator(name = "generator", sequenceName="SEQ_USER_LOG", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generator")
	@Column(name="ID",precision=20,scale=0)
	private Long id;
	/**
	 * 用户id
	 */
	@Column(name="USER_ID",precision=20,scale=0)
	private Long userId;
	/**
	 * 用户登录名
	 */
	@Column(name="LOGIN_NAME",length=100)
	private String loginName;
	/**
	 * 用户名
	 */
	@Column(name="USER_NAME",length=200)
	private String userName;
	/**
	 * 日志类型（query：查询,add:添加,update:修改,delete:删除）
	 */
	@Column(name="OPERATE_TYPE",length=30)
	private String operateType;
	/**
	 * 功能id
	 */
	@Column(name="FUNCTION_ID",precision=20,scale=0)
	private Long functionId;
	/**
	 * 功能名称
	 */
	@Column(name="FUNCTION_NAME",length=300)
	private String functionName;
	/**
	 * 参数<br/>
	 * JSON 存储{'id':343,'name':'王芬'}
	 */
	@Column(name="params")
	private String params;
	/**
	 * 备注
	 */
	@Column(name="remark",length=300)
	private String remark;
	/**
	 * 操作时间
	 */
	@Column(name="OPERATE_TIME")
	@Temporal(TemporalType.TIMESTAMP)
	private Date operateTime;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public String getLoginName() {
		return loginName;
	}
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Long getFunctionId() {
		return functionId;
	}
	public void setFunctionId(Long functionId) {
		this.functionId = functionId;
	}
	public String getFunctionName() {
		return functionName;
	}
	public void setFunctionName(String functionName) {
		this.functionName = functionName;
	}
	public String getParams() {
		return params;
	}
	public void setParams(String params) {
		this.params = params;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public Date getOperateTime() {
		return operateTime;
	}
	public void setOperateTime(Date operateTime) {
		this.operateTime = operateTime;
	}
	public String getOperateType() {
		return operateType;
	}
	public void setOperateType(String operateType) {
		this.operateType = operateType;
	}
}
