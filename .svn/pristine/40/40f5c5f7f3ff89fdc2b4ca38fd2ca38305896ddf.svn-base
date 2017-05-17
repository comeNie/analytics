package com.orienttech.statics.service.model.sysmng;

import java.util.ArrayList;
import java.util.List;

import com.orienttech.statics.commons.base.BaseBo;

/**
 * 菜单（业务层数据对象）
 *
 */
public class MenuBo extends BaseBo{

	/**
	 * 
	 */
	private static final long serialVersionUID = 9112337008982730762L;
	
	private Long id;
	private Long pid;
	private String name;
	private Integer level;
	private String url;
	private String actionType;
	private String action;
	private boolean open;
	private List<MenuBo> children=new ArrayList<MenuBo>();
	
	private String analysisUrl;
	private String queryUrl;
	
	
	public MenuBo() {
		super();
	}
	public MenuBo(Long id, Long pid, String name) {
		super();
		this.id = id;
		this.pid = pid;
		this.name = name;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getLevel() {
		return level;
	}
	public void setLevel(Integer level) {
		this.level = level;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getActionType() {
		return actionType;
	}
	public void setActionType(String actionType) {
		this.actionType = actionType;
	}
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}
	public List<MenuBo> getChildren() {
		return children;
	}
	public void setChildren(List<MenuBo> children) {
		this.children = children;
	}
	public Long getPid() {
		return pid;
	}
	public void setPid(Long pid) {
		this.pid = pid;
	}
	
	public boolean isOpen() {
		return open;
	}
	public void setOpen(boolean open) {
		this.open = open;
	}
	public String getAnalysisUrl() {
		return analysisUrl;
	}
	public void setAnalysisUrl(String analysisUrl) {
		this.analysisUrl = analysisUrl;
	}
	public String getQueryUrl() {
		return queryUrl;
	}
	public void setQueryUrl(String queryUrl) {
		this.queryUrl = queryUrl;
	}
	
}
