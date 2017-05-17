package com.orienttech.statics.web.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.orienttech.statics.commons.base.BaseController;
import com.orienttech.statics.commons.security.SessionUser;
import com.orienttech.statics.dao.entity.Role;
import com.orienttech.statics.service.model.sysmng.MenuBo;
import com.orienttech.statics.service.model.workflow.PageTypedResultData;
import com.orienttech.statics.service.model.workflow.TodoTask;
import com.orienttech.statics.service.model.workflow.TypedResult;
import com.orienttech.statics.service.report.BizReportService;
import com.orienttech.statics.service.sysmng.MenuService;
import com.orienttech.statics.service.sysmng.RoleMngService;
import com.orienttech.statics.service.usermng.OrgDeptService;
import com.orienttech.statics.service.usermng.UserMngService;
import com.orienttech.statics.service.workflow.WorkFlowService;

@Controller
public class HomeController extends BaseController {
	@Autowired
	private MenuService menuService;
	@Autowired
	private WorkFlowService workFlowService;
	@Autowired
	private BizReportService bizReportService;
	@Autowired
	private RoleMngService roleMngService;
	@Autowired
	private OrgDeptService orgDeptService;
	@Autowired
	private UserMngService userMngService;


	@RequestMapping("/main")
	public String index(Model model) {
		SessionUser sUser = getSessionUser();
		
		String realOrgCode = userMngService.findUserBySsoId(sUser.getLoginName()).getOrgCode();
		String realOrgName = orgDeptService.findOrgNameByOrgId(realOrgCode);
		
		//处理其他机构
		Map<String,String> orgMap = new HashMap<String,String>();

		if(sUser.getOtherOrgCode() != null){
			String[] orgCodes = sUser.getOtherOrgCode().split(",");
			for(int i=0;i<orgCodes.length;i++){
				String orgName = orgDeptService.findOrgNameByOrgId(orgCodes[i]);
				orgMap.put(orgCodes[i], orgName);
			}
			if(!orgMap.containsKey(realOrgCode)){
				orgMap.put(realOrgCode, realOrgName);
				orgMap.remove(sUser.getOrgCode());
			}
		}
		
		model.addAttribute("orgMap", orgMap);
		
		//是否显示待办页面
		String[] roleIds = sUser.getRoleId().split(",");
		String ifTodoList = "";
		for(String roleId : roleIds){
			Role role = roleMngService.findById(Integer.valueOf(roleId));
			if(StringUtils.isNotEmpty(role.getIfTodoList())){
				ifTodoList = role.getIfTodoList();
			}
		}
		model.addAttribute("ifTodoList", ifTodoList);
		
		//菜单-我的收藏夹
		List<MenuBo> mblist = menuService.findStoreByUserId(sUser.getId().intValue());
		//菜单
		List<MenuBo> menuList = menuService.findMenuListByRoleId(sUser.getRoleId());
		model.addAttribute("menuList", menuList);
		model.addAttribute("mblist", mblist);

		String curUserName = "";
		if (sUser != null) {
			curUserName = sUser.getLoginName();
			if (StringUtils.isNotEmpty(curUserName)) {
				curUserName += "," + sUser.getLoginName();
			}
		}
		TypedResult<PageTypedResultData<TodoTask>> todoTask = workFlowService.queryPortalToDoListByCondition(curUserName,"4", "", "", "", "", "",0/10+1, 10);
		model.addAttribute("todoListToltal", todoTask.getData().getTotalElements());
		// cognos参数中的用户名和密码
		List<Object[]> list = bizReportService.getUsernameAndPsw();
		String userNameOfCognos = "";
		String pswOfCognos = "";
		if (list.size() > 0) {
			Object[] obj = list.get(0);
			userNameOfCognos = obj[0].toString();
			pswOfCognos = obj[1].toString();
		}
		model.addAttribute("userNameOfCognos", userNameOfCognos);
		model.addAttribute("pswOfCognos", pswOfCognos);

		return "index";
	}
	/**
	 * 切换机构
	 * @param orgCode
	 * @return
	 */
	@RequestMapping("/checkOrgCode")
	public String checkOrgCode(String orgCode,Model model){
		SessionUser curUser = getSessionUser();
		
		String orgName = orgDeptService.findOrgNameByOrgId(orgCode);
		if(orgCode != null){
			curUser.setOrgCode(orgCode);
			curUser.setOrgName(orgName);
		}
		
		return "redirect:/main";
	}

	@RequestMapping("/todoList")
	public String todoList(Model model) {
		SessionUser curUser = getSessionUser();
		model.addAttribute("curUser", curUser);
		return "main/todoList";
	}

	@RequestMapping("/test")
	public String test() {
		return "test";
	}
	
	
}
