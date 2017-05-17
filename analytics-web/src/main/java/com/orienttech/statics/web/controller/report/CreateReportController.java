package com.orienttech.statics.web.controller.report;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.google.common.collect.Lists;
import com.orienttech.statics.commons.base.BaseController;
import com.orienttech.statics.commons.security.SessionUser;
import com.orienttech.statics.commons.utils.CommonHelper;
import com.orienttech.statics.service.report.BizReportService;
import com.orienttech.statics.service.sysmng.MenuService;
import com.orienttech.statics.service.usermng.OrgDeptService;

@RequestMapping("/brCreateReoprt")
@Controller
public class CreateReportController extends BaseController {
	
	private int[] months={1,2,3,4,5,6,7,8,9,10,11,12};
	private final String SESSION_BUILD_REPORT_PROGRESS="BUILD_REPORT_PROGRESS";
	@Autowired
	private MenuService menuService;
	@Autowired
	private OrgDeptService orgDeptService;
	@Autowired
	private BizReportService bizReportService;
	
	/**
	 * TODO
	 * 初始化报表页面
	 * @param functionId
	 * @param model
	 * @return
	 */
	@RequestMapping
	public String index(Long functionId, Model model) {
		SessionUser user=getSessionUser();
		model.addAttribute("menu", menuService.findMenu(functionId));
		model.addAttribute("curUser", user);
		model.addAttribute("orgs", orgDeptService.findOrgDeptListByOrgId(user.getOrgCode()));
		Date now = CommonHelper.getNow();
		Calendar cal = Calendar.getInstance();
		String curYear = CommonHelper.date2Str(now, "yyyy");
		model.addAttribute("years", this.initYears(curYear));//年份
		model.addAttribute("months", months);//月份
		model.addAttribute("curYears", curYear);//当前年份
		model.addAttribute("curMonths", cal.get(Calendar.MONTH )+1);//当前月份
		return "/report/brCreateReoprt";
	}
	
	/**
	 * 初始化年份
	 * @param curYear
	 * @return
	 */
	private List<String> initYears(String curYear){
		int startYear= Integer.parseInt(curYear)+5;
		List<String> list=Lists.newArrayList();
		for (int i = startYear; i >= 2012; i--) {
			list.add(String.valueOf(i));
		}
		return list;
	}
}
