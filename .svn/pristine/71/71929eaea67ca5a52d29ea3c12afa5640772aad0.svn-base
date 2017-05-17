package com.orienttech.statics.web.controller.sysmng;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.orienttech.statics.commons.base.BaseController;
import com.orienttech.statics.commons.base.Result;
import com.orienttech.statics.commons.security.SessionUser;
import com.orienttech.statics.service.model.sysmng.MenuBo;
import com.orienttech.statics.service.sysmng.MenuService;

@Controller
@RequestMapping("/menuMng")
public class MenuMngController extends BaseController {
	@Autowired
	private MenuService menuService;

	/**
	 * 查询一级权限菜单
	 * 
	 * @return
	 * @throws IOException
	 */

	@SuppressWarnings("null")
	@RequestMapping(value = "/findFirstMenuList", method = RequestMethod.POST)
	@ResponseBody
	public void findFirstMenuList(HttpServletResponse response) {
		Subject currentUser = SecurityUtils.getSubject();
		SessionUser sUser = (SessionUser) currentUser.getPrincipal();
		PrintWriter out = null;
		try {
			out = response.getWriter();
			List<MenuBo> menuList = menuService.findMenuTreeList();
			for (int i = 0; i < menuList.size(); i++) {
				menuList.get(i).setOpen(i == 0 ? true : false);// 默认第一个节点展开
			}
			JSONArray array = JSONArray.fromObject(menuList);
			out.print(array);
		} catch (IOException e) {
			out.print("");
		}
	}

	/**
	 * 查询一级权限菜单
	 * 报表说明维护加载报表列表
	 * @return
	 * @throws IOException
	 */

	@SuppressWarnings("null")
	@RequestMapping(value = "/findReportFirstMenuList", method = RequestMethod.POST)
	@ResponseBody
	public void findReportFirstMenuList(HttpServletResponse response) {
		Subject currentUser = SecurityUtils.getSubject();
		SessionUser sUser = (SessionUser) currentUser.getPrincipal();
		PrintWriter out = null;
		try {
			out = response.getWriter();
			List<MenuBo> menuList = menuService.findReportMenuTreeList();
			for (int i = 0; i < menuList.size(); i++) {
				menuList.get(i).setOpen(i == 0 ? true : false);// 默认第一个节点展开
			}
			JSONArray array = JSONArray.fromObject(menuList);
			out.print(array);
		} catch (IOException e) {
			out.print("");
		}
	}
	
	
	/**
	 * Dashboard权限菜单
	 * 
	 * @return
	 * @throws IOException
	 */

	@SuppressWarnings("null")
	@RequestMapping(value = "/findDashboardMenuList", method = RequestMethod.POST)
	@ResponseBody
	public void findFirstDashboardList(HttpServletResponse response) {
		Subject currentUser = SecurityUtils.getSubject();
		SessionUser sUser = (SessionUser) currentUser.getPrincipal();
		PrintWriter out = null;
		try {
			out = response.getWriter();
			List<MenuBo> menuList = menuService.findDashboardMenuTreeList();
			for (int i = 0; i < menuList.size(); i++) {
				menuList.get(i).setOpen(i == 0 ? true : false);// 默认第一个节点展开
			}
			JSONArray array = JSONArray.fromObject(menuList);
			out.print(array);
		} catch (IOException e) {
			out.print("");
		}
	}
	
	@RequestMapping(value = "/findAllFunctionIdDshaboard", method = RequestMethod.POST)
	@ResponseBody
	public Result findAllDshaboardFunctionId(String roleId) {
		return success(menuService.findAllDshaboardFunctionId(roleId));
	}
	
	@RequestMapping(value = "/findAllFunctionId", method = RequestMethod.POST)
	@ResponseBody
	public Result findAllFunctionId(Long roleId) {
		return success(menuService.findAllFunctionId(roleId));
	}
	
	
	
	
	@RequestMapping(value = "/findAllDashboardId", method = RequestMethod.POST)
	@ResponseBody
	public Result findAllDashboardId(String roleId) {
		return success(menuService.findAllDashboardId(roleId));
	}
	
	
	
	
	
}
