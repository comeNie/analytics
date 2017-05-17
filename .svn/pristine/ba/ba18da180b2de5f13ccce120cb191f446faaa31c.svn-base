package com.orienttech.statics.web.controller.reportResultQuery;



import java.util.List;

import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.orienttech.statics.dao.entity.PassRead;
import com.orienttech.statics.commons.base.BaseController;
import com.orienttech.statics.commons.base.Result;
import com.orienttech.statics.commons.datatables.DataTablesPage;
import com.orienttech.statics.commons.security.SessionUser;
import com.orienttech.statics.dao.entity.UserSso;
import com.orienttech.statics.service.reportResultQuery.ReportResultQueryService;
import com.orienttech.statics.service.sysmng.RoleMngService;
import com.orienttech.statics.service.usermng.UserMngService;
@RequestMapping("/reportResultQuery")
@Controller
public class ReportResultQueryController extends BaseController {
	
	@Autowired ReportResultQueryService reportResultQueryService;
	@Autowired private RoleMngService roleMngService;
	@Autowired private UserMngService userMngService;
	
	/**
	 * 根据报表类型加载不同的页面
	 * @param type	JSP名称
	 * @param model
	 * @return
	 */
	@RequestMapping
	public String index(@RequestParam(defaultValue="")String type,Model model){
		SessionUser sUser = (SessionUser) SecurityUtils.getSubject().getPrincipal();
		
		String[] roleIds = sUser.getRoleId().split(",");
		String ifPassRole = "no";
		for(String roleId : roleIds){
			if(roleId.equals("479")){//传阅权限发送人员
				ifPassRole = "yes";
			}
		}
		model.addAttribute("ifPassRole", ifPassRole);
		
		String loginName = sUser.getUserName();
		model.addAttribute("loginName", loginName);
		return "/reportResultQuery/"+type;
	}
	/**
	 * 查询报送结果
	 * @param pageNumber
	 * @param pageSize
	 * @param sEcho
	 * @param reportName
	 * @param reportCycle
	 * @param releaseTimeBegin
	 * @param releaseTimeEnd
	 * @param releasePeople
	 * @return
	 */
	@RequestMapping(value="/queryReportResult",method=RequestMethod.POST)
	@ResponseBody
	public DataTablesPage queryReportResult(@RequestParam("start") Integer pageNumber,
			@RequestParam("length") Integer pageSize, Integer sEcho, String reportName,
			 String reportCycle, String sumTimeBegin, String sumTimeEnd, String sumPeople) {
		Page<Object[]> page = reportResultQueryService.queryReportResult(pageNumber/pageSize + 1, pageSize, reportName, reportCycle, sumTimeBegin, sumTimeEnd, sumPeople);
		return new DataTablesPage(sEcho, page);
	}
	/**
	 * 查询传阅接收人
	 * @param roleId
	 * @return
	 */
	@RequestMapping(value="/queryUsersByRoleId",method=RequestMethod.POST)
	@ResponseBody
	public Result queryUsersByRoleId(String roleId){
		List<UserSso> list = userMngService.findUsersByRoleId(roleId);
		return success(list);
	}
	/**
	 * TODO
	 * 保存传阅信息
	 * @param names
	 * @return
	 */
	@RequestMapping(value="/savePassUser",method=RequestMethod.POST)
	@ResponseBody
	public Result savePassUser(String readUserId,String templateName,String reportSumId){
		
		SessionUser sUser = (SessionUser) SecurityUtils.getSubject().getPrincipal();
		
		PassRead pr = new PassRead();
		pr.setPassUserId(sUser.getLoginName());
		pr.setPassUserName(sUser.getUserName());
		
		pr.setReadUserId(readUserId);
		
		pr.setReportSumId(reportSumId);
		pr.setTemplateName(templateName);
		
		reportResultQueryService.addPassRead(pr);
		return success("保存传阅信息成功");
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
