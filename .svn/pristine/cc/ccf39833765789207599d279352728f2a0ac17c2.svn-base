package com.orienttech.statics.web.controller.report;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.common.base.Function;
import com.google.common.collect.Lists;
import com.orienttech.statics.commons.base.BaseController;
import com.orienttech.statics.commons.datatables.DataTablesPage;
import com.orienttech.statics.commons.security.SessionUser;
import com.orienttech.statics.commons.utils.CommonHelper;
import com.orienttech.statics.commons.utils.FileUtils;
import com.orienttech.statics.commons.utils.PropertiesConstants;
import com.orienttech.statics.service.model.report.HistoryReportBo;
import com.orienttech.statics.service.report.HistoryReportService;
import com.orienttech.statics.service.sysmng.MenuService;
import com.orienttech.statics.service.usermng.OrgDeptService;
@RequestMapping("/historyReport")
@Controller
public class HistoryReportController extends BaseController {
	private Log log=LogFactory.getLog(HistoryReportController.class);
	@Autowired
	private MenuService menuService;
	@Autowired
	private HistoryReportService historyReportService;
	
	@Autowired
	private OrgDeptService orgDeptService;
	
	@RequestMapping
	public String index(Long functionId,Model model){
		SessionUser user=getSessionUser();
		model.addAttribute("menu", menuService.findMenu(functionId));
		model.addAttribute("typeCodes", historyReportService.findAllHistRptListByCode());
		//model.addAttribute("orgs", orgDeptService.findOrgDeptBySelfOrgId(user.getOrgCode()));
		model.addAttribute("selfOrgId", user.getOrgCode());
		model.addAttribute("orgs", orgDeptService.findOrgDeptListForHistoryReport(user.getOrgCode()));
		return "/report/brHistoryList";
	}
	/**
	 * @param draw
	 * @param firstIndex
	 * @param pageSize
	 * @return
	 */
	@RequestMapping(value = "/findList", method = RequestMethod.POST)
	@ResponseBody
	public DataTablesPage findList(Integer draw,
			@RequestParam("start") Integer firstIndex,
			@RequestParam("length") Integer pageSize, String reportType,
			String startDateStr, String endDateStr, String orgId) {
		SessionUser user=getSessionUser();
		Date startDate=CommonHelper.str2Date(startDateStr, CommonHelper.DF_DATE);
		Date endDate=CommonHelper.str2Date(endDateStr, CommonHelper.DF_DATE);
		Page<Object[]> page=historyReportService.findHistoryReportList(firstIndex / pageSize, pageSize, reportType, startDate, endDate, orgId, user.getOrgCode());
		DataTablesPage dtPage=new DataTablesPage(draw, page);
		dtPage.setData(Lists.transform(page.getContent(), new Function<Object[], HistoryReportBo>() {
			@Override
			public HistoryReportBo apply(Object[] objs) {
				return new HistoryReportBo(objs);
			}
		}));
		
		return dtPage;
	}
	/**
	 * 下载
	 * @param fileName
	 * @param req
	 * @param resp
	 */
	@RequestMapping(value = "/download")
	@ResponseBody
	public String download(String fileName,HttpServletRequest req,HttpServletResponse resp){
		String filePath = PropertiesConstants.getString(PropertiesConstants.USER_HOME) + PropertiesConstants.getString(PropertiesConstants.HISTORY_REPORT_PATH)+File.separator+fileName;
		log.info(filePath);
		try {
			File file=new File(filePath);
			if(FileUtils.isExists(file)){
				FileUtils.downloadFile(new File(filePath), fileName, req, resp);
			}else{
				return "文件不存在";
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "";
	}
	
	/**
	 * 下载
	 * @param fileName
	 * @param req
	 * @param resp
	 */
	@RequestMapping(value = "/fileIsExists")
	@ResponseBody
	public String fileIsExists(String fileName,HttpServletRequest req,HttpServletResponse resp){
		String filePath = PropertiesConstants.getString(PropertiesConstants.USER_HOME) + PropertiesConstants.getString(PropertiesConstants.HISTORY_REPORT_PATH)+File.separator+fileName;
		log.info(filePath);
		File file=new File(filePath);
		if(FileUtils.isExists(file)){
			return "";
		}else{
			return "文件不存在";
		}
	}
}
