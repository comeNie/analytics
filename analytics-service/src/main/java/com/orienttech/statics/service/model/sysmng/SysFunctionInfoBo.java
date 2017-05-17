package com.orienttech.statics.service.model.sysmng;

import java.io.Serializable;

import com.orienttech.statics.commons.utils.CommonHelper;

/**
 * 系统功能信息表
 *
 */
public class SysFunctionInfoBo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5460738677681040061L;
	private Long id;
	private Long functionId;
	private String functionName;
	private String servletPath;
	/**
	 * ALL,POST,GET
	 */
	private String reqMethod;
	
	
	
	public SysFunctionInfoBo(Object[] objs) {
		super();
		int i=0;
		this.id=CommonHelper.toLong(objs[i++]);
		this.functionId=CommonHelper.toLong(objs[i++]);
		this.functionName=CommonHelper.toStr(objs[i++]);
		this.servletPath=CommonHelper.toStr(objs[i++]);
		this.reqMethod=CommonHelper.toStr(objs[i++]);
	}
	public String getServletPath() {
		return servletPath;
	}
	public void setServletPath(String servletPath) {
		this.servletPath = servletPath;
	}
	public String getReqMethod() {
		return reqMethod;
	}
	public void setReqMethod(String reqMethod) {
		this.reqMethod = reqMethod;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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

}
