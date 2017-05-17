package com.orienttech.statics.service.model.submission;

import java.util.Date;

import javax.xml.crypto.Data;

import com.orienttech.statics.commons.base.BaseBo;
import com.orienttech.statics.commons.utils.CommonHelper;

/**
 *
 */
public class TblTemplateSumBo  extends BaseBo{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1849795067481632730L;
	private String id;
	private String templateId;
	private String path;
	private String sumState;
	private Date sumTime;
	private String sumPeople;
	private Date templateTime;
	private Date templateStartTime;
	private Date templateEndTime;
	
	public TblTemplateSumBo() {
		super();
	}
	
	public TblTemplateSumBo(Object[] objs) {
		super();
		int i=0;
		this.id = CommonHelper.toStr(objs[i++]);
		this.templateId = CommonHelper.toStr(objs[i++]);
		this.path = CommonHelper.toStr(objs[i++]);
		this.sumState = CommonHelper.toStr(objs[i++]);
		this.sumTime = (Date)objs[i++];
		this.sumPeople=CommonHelper.toStr(objs[i++]);
		this.templateTime = (Date)objs[i++];
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}

	public String getTemplateId() {
		return templateId;
	}

	public void setTemplateId(String templateId) {
		this.templateId = templateId;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getSumState() {
		return sumState;
	}

	public void setSumState(String sumState) {
		this.sumState = sumState;
	}

	public Date getSumTime() {
		return sumTime;
	}

	public void setSumTime(Date sumTime) {
		this.sumTime = sumTime;
	}

	public String getSumPeople() {
		return sumPeople;
	}

	public void setSumPeople(String sumPeople) {
		this.sumPeople = sumPeople;
	}

	public Date getTemplateTime() {
		return templateTime;
	}

	public void setTemplateTime(Date templateTime) {
		this.templateTime = templateTime;
	}

	public Date getTemplateStartTime() {
		return templateStartTime;
	}

	public void setTemplateStartTime(Date templateStartTime) {
		this.templateStartTime = templateStartTime;
	}

	public Date getTemplateEndTime() {
		return templateEndTime;
	}

	public void setTemplateEndTime(Date templateEndTime) {
		this.templateEndTime = templateEndTime;
	}

	
}
