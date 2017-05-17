package com.orienttech.statics.service.sysmng;

import java.util.List;

import com.orienttech.statics.service.model.sysmng.MenuBo;

public interface MenuService {
	/**
	 * 
	 * @param orgId
	 * @return
	 */
	List<MenuBo> findMenuListByRoleId(String roleId);
	/**
	 * 构建菜单树（所有可用菜单,除Dashboard之外）
	 * @return
	 */
	List<MenuBo> findMenuTreeList();
	
	/**
	 * 构建菜单树（所有可用菜单,除Dashboard之外）
	 * @return
	 */
	List<MenuBo> findReportMenuTreeList();
	
	/**
	 * 构建菜单树（Dashboard菜单）
	 * @return
	 */
	List<MenuBo> findDashboardMenuTreeList();
	
	/**
	 * 根据functionId查询菜单
	 * @param id
	 * @return
	 */
	MenuBo findMenu(Long id);
	
	List<MenuBo> findAllFunctionId(Long roleId);
	
	List<MenuBo> findAllDshaboardFunctionId(String roleId);
	List<MenuBo> findAllDashboardId(String roleId);
	
	public List<MenuBo> findStoreByUserId(int userId);
}
