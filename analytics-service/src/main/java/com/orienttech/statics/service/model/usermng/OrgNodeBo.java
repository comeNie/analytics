package com.orienttech.statics.service.model.usermng;

import com.orienttech.statics.commons.base.BaseBo;
import com.orienttech.statics.commons.utils.CommonHelper;

public class OrgNodeBo extends BaseBo {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2699232858915226599L;
	private String id;
	private String parentId;
	private String name;
	private String desc;
	
	public OrgNodeBo(Object[] objs) {
		super();
		int i=0;
		this.id = CommonHelper.toStr(objs[i++]);
		this.parentId = CommonHelper.toStr(objs[i++]);
		this.name = CommonHelper.toStr(objs[i++]);
		this.desc = CommonHelper.toStr(objs[i++]);
	}
	
	public OrgNodeBo() {
		super();
	}
	
	public OrgNodeBo(String id, String parentId) {
		super();
		this.id = id;
		this.parentId = parentId;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getParentId() {
		return parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}
	
	
}
