package com.orienttech.statics.service.model.report;

import java.io.Serializable;

import org.apache.commons.lang3.StringUtils;

import com.orienttech.statics.commons.utils.CommonHelper;

/**
 * 资产包信息
 *
 */
public class AssetPackageInfo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8375544680063344333L;
	private String id;
	private String name;
	
	
	public AssetPackageInfo() {
		super();
	}
	public AssetPackageInfo(Object[] objs) {
		super();
		this.id=CommonHelper.toStr(objs[0]);
		this.name=StringUtils.equals(id, "99999")?"未转出":CommonHelper.toStr(objs[1]);
		
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

}
