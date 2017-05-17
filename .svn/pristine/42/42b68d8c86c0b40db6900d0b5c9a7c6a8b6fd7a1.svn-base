package com.orienttech.statics.web.controller.report;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.orienttech.statics.commons.base.BaseController;
import com.orienttech.statics.commons.base.Result;
import com.orienttech.statics.commons.security.SessionUser;
import com.orienttech.statics.commons.utils.FileUtils;
import com.orienttech.statics.commons.utils.FreemarkerUtils;
import com.orienttech.statics.service.model.report.FactLoanReportPeriodBo;
import com.orienttech.statics.service.model.sysmng.MenuBo;
import com.orienttech.statics.service.report.TenDaysReportService;
import com.orienttech.statics.service.report.impl.HistoryReportServiceImpl;
import com.orienttech.statics.service.sysmng.MenuService;

/**   
 * 类名称：tenDaysReportController
 * 类描述 ：
 * 创建人:wangxy
 * 创建时间：2015年7月20日 上午11:26:07  
 * 修改人：wangxy
 * 修改时间：
 * 修改备注：
 * 版本： V1.0
 */
@RequestMapping("/tenDaysReport")
@Controller
public class TenDaysReportController extends BaseController {
	
	private Logger logger=LoggerFactory.getLogger(HistoryReportServiceImpl.class);
	
	@Autowired
	private MenuService menuService;
	@Autowired
	private TenDaysReportService tenDaysReportService;
	
	@RequestMapping
	public String index(Long functionId,Model model){
		
		MenuBo menuBo = menuService.findMenu(functionId);
		SessionUser curUser = getSessionUser();
		
		model.addAttribute("menu", menuBo);
		model.addAttribute("curUser", curUser);
		
		//当前系统时间
		Date now = new Date(); 
		String sysdate = new SimpleDateFormat("yyyy年MM月dd日").format(now);
		
		model.addAttribute("curYear", sysdate.substring(0,4));
		model.addAttribute("curMonth", sysdate.substring(5,7));
		model.addAttribute("curDecadDays", sysdate.substring(8,10));
		
		return "/report/tenDaysReport";
	}
	/**
	 * 根据年月旬生成WORD
	 * @param year
	 * @param month
	 * @param decadDays
	 * @author wangxy 20150721
	 * @return
	 */
	@RequestMapping(value="/searchByCondition")
	@ResponseBody
	public Result searchByCondition(String year, String month, String decadDays){
		String condition = year + month + decadDays;
		//获得Bo格式的数据
		FactLoanReportPeriodBo bo = tenDaysReportService.searchByCondition(condition);
        try {
        	if(bo != null){
        		//获得Map格式的数据
        		Map<String, Object> dataMap = new HashMap<String, Object>();
            	dataMap = tenDaysReportService.toGetMap(bo);
            	//程序生成文件名(非汉字,易乱码)
            	String outFileName = bo.getOutFileName() + ".doc";
            	//在程序里生成word
            	FreemarkerUtils.createDoc("MiniLoanReport.xml",outFileName,dataMap);
            	logger.info("文件名："+outFileName);
            }
		} catch (Exception e) {
			e.printStackTrace();
		}
        return success(bo);
	}
	/**
	 * 生成word另存为
	 * @param year
	 * @param month
	 * @param decadDays
	 * @param req
	 * @param resp
	 */
	@RequestMapping("/download")
	public void download(String outFileName, HttpServletRequest req, HttpServletResponse resp){
		
		try {
			String filePath = FreemarkerUtils.wordPath+File.separator + outFileName + ".doc";
			logger.info("文件生成路径："+filePath);
			FileUtils.downloadFile(new File(filePath), "旬度贷款业务情况通报"+ ".doc", req, resp);
			
		} catch (IOException e) {
			e.printStackTrace();
			try {
				resp.sendError(HttpServletResponse.SC_NOT_FOUND, "文件未生成");
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
	}
	

}
