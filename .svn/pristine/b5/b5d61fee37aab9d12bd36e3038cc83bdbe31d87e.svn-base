package com.orienttech.statics.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.orienttech.statics.commons.base.BaseController;
import com.orienttech.statics.commons.base.Result;
import com.orienttech.statics.commons.datatables.DataTablesPage;
import com.orienttech.statics.commons.utils.Utils;
import com.orienttech.statics.dao.entity.UserSso;
import com.orienttech.statics.service.usermng.UserMngService;

@Controller
@RequestMapping("/userMng")
public class UserMngController extends BaseController {

	@Autowired
	private UserMngService userMngService;
	
	@RequestMapping
	public String index() {
		return "sysMng/userMng";
	}

	@RequestMapping(value = "/findAllUser", method = RequestMethod.POST)
	@ResponseBody
	public DataTablesPage findAllUser(Integer draw,
			@RequestParam("search[value]") String search,
			@RequestParam("start") Integer firstIndex,
			@RequestParam("length") Integer pageSize) {
		Page<UserSso> page = userMngService.findAll(search, firstIndex
				/ pageSize + 1, pageSize);
		return Utils.transferToJqueryDataTablesFormat_v110(draw, page);
	}

	@RequestMapping(value = "/modifyUserSsoRole", method = RequestMethod.POST)
	@ResponseBody
	public Result modifyUserSsoRole(String roleId, String ssoId) {
		return userMngService.modifyUserRole(roleId, ssoId) == true ? success()
				: failure();
	}
	
	@RequestMapping(value = "/findUserSsoInfo", method = RequestMethod.POST)
	@ResponseBody
	public DataTablesPage findUserSsoInfo(Integer draw,
			@RequestParam("search[value]") String search,
			@RequestParam("start") Integer firstIndex,
			@RequestParam("length") Integer pageSize){
		Page<Object[]> page = userMngService.findUserSsoInfo(search, firstIndex
				/ pageSize + 1, pageSize);
		return Utils.transferToJqueryDataTablesFormat_v110(draw, page);
	}
}
