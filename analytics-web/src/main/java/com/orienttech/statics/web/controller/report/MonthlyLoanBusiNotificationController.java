package com.orienttech.statics.web.controller.report;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import sun.misc.BASE64Encoder;

import com.cognos.developer.schemas.bibus._3.ReportService_PortType;
import com.orienttech.statics.commons.base.BaseController;
import com.orienttech.statics.commons.base.Result;
import com.orienttech.statics.commons.security.SessionUser;
import com.orienttech.statics.commons.utils.FileUtils;
import com.orienttech.statics.commons.utils.FreemarkerUtils;
import com.orienttech.statics.commons.utils.Pdf2Image;
import com.orienttech.statics.dao.entity.ReportChartCoordinate;
import com.orienttech.statics.service.cognos.common.ServerInfoHelper;
import com.orienttech.statics.service.cognos.entity.ReportParam;
import com.orienttech.statics.service.cognos.exception.CognosBaseException;
import com.orienttech.statics.service.model.report.MonthlyLoanBusiNotificationBo;
import com.orienttech.statics.service.model.sysmng.MenuBo;
import com.orienttech.statics.service.model.usermng.OrgDeptBo;
import com.orienttech.statics.service.report.MonthlyLoanBusiNotificationService;
import com.orienttech.statics.service.report.impl.MonthlyLoanBusiNotificationServiceImpl;
import com.orienttech.statics.service.report.thread.PdfRunReportModel;
import com.orienttech.statics.service.sysmng.MenuService;
import com.orienttech.statics.service.usermng.OrgDeptService;

@RequestMapping("/monthlyLoanBusiNotification")
@Controller
public class MonthlyLoanBusiNotificationController extends BaseController {
	
	private Logger logger=LoggerFactory.getLogger(MonthlyLoanBusiNotificationServiceImpl.class);
	
	@Autowired
	private MenuService menuService;
	@Autowired
	MonthlyLoanBusiNotificationService monthlyLoanBusiNotificationService;
	@Autowired
	private OrgDeptService orgDeptService;
	
	@RequestMapping
	public String index(Long functionId,Model model){
		
		MenuBo menuBo = menuService.findMenu(functionId);
		SessionUser curUser = getSessionUser();

		//加载组织机构(不含工作组)
		List<OrgDeptBo> list = orgDeptService.findOrgDeptListByOrgId("00");
		
		model.addAttribute("menu", menuBo);
		model.addAttribute("curUser", curUser);
		model.addAttribute("orgList", list);
		//当前系统时间
		String sysdate = new SimpleDateFormat("yyyy年MM月dd日").format(new Date());
		model.addAttribute("curYear", sysdate.substring(0,4));
		model.addAttribute("curMonth", sysdate.substring(5,7));
		
		return "/report/monthlyLoanBusiNotification";
	}
	
	/**
	 * 根据年月生成WORD
	 */
	@RequestMapping(value="/searchByCondition")
	@ResponseBody
	public Result searchByCondition(String year, String month, String orgId){
		String busiDate = year + month;
		//获得Bo格式的数据
		MonthlyLoanBusiNotificationBo bo = monthlyLoanBusiNotificationService.searchCurMonthDatas(busiDate, orgId);
        try {
        	if(bo != null){
        		//获得Map格式的数据
        		Map<String, Object> dataMap = new HashMap<String, Object>();
        		//插入文本
            	dataMap = monthlyLoanBusiNotificationService.toGetMap(bo);
            	//插入图片
            	List<String> imageList = this.getImageStr(year, month, orgId);
            	dataMap.put("image1", imageList.get(0));
            	dataMap.put("image2", imageList.get(1));
            	dataMap.put("image3", imageList.get(2));
            	dataMap.put("image4", imageList.get(3));
            	//程序生成文件名(非汉字,易乱码)
            	String outFileName = bo.getOutFileName() + ".doc";
            	//在程序里生成word
            	FreemarkerUtils.createDoc("MonthlyLoanBusiNotification.xml",outFileName,dataMap);
            	logger.info("文件名："+outFileName);
            }
		} catch (Exception e) {
			e.printStackTrace();
		}
        return success(bo);
	}
	
	/**
	 * 生成word另存为
	 */
	@RequestMapping("/download")
	public void download(String outFileName, HttpServletRequest req, HttpServletResponse resp){
		
		try {
			String filePath = FreemarkerUtils.wordPath+File.separator + outFileName + ".doc";
			logger.info("文件生成路径："+filePath);
			FileUtils.downloadFile(new File(filePath), "邦信小贷月度贷款业务情况通报"+ ".doc", req, resp);
			
		} catch (IOException e) {
			e.printStackTrace();
			try {
				resp.sendError(HttpServletResponse.SC_NOT_FOUND, "文件未生成");
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
	}
	/**
	 * 从COGNOS获取PDF并截图,插入word文档
	 * @throws InterruptedException 
	 */
	public List<String> getImageStr(String year,String month,String orgId) throws InterruptedException{
		
		List<ReportChartCoordinate> list = monthlyLoanBusiNotificationService.findReportChartCoordinateAllList();
		if(CollectionUtils.isEmpty(list)){
			logger.error("模板不存在，如有需要请联系管理员！");
			return null;
		}
		String filename="";
		List<ReportParam> params = Arrays.asList(new ReportParam("Porgcd", orgId),
				new ReportParam("Pyear", year), new ReportParam("Pmonth",month));
		
		String filenamePrefix = String.valueOf(new Date().getTime());
		//首先初始化跑批列表
		List<PdfRunReportModel> cacheFiles = new ArrayList<PdfRunReportModel>();
		for (ReportChartCoordinate fr : list) {
			filename = filenamePrefix + fr.getRowId() + ".pdf";
			PdfRunReportModel pdf = new PdfRunReportModel();
			pdf.setRowId(fr.getRowId());
			pdf.setReportName(fr.getReportName());
			pdf.setSearchPath(fr.getSearchPath());
			pdf.setFile(new File(ServerInfoHelper.getTempReportPath() + File.separator + filename));
			cacheFiles.add(pdf);
		}
		
		int index = cacheFiles.size();
		int count = 0;
		while(index > 0) {
			ReportService_PortType runReport = monthlyLoanBusiNotificationService.loginCognos();
			for (PdfRunReportModel prrm : cacheFiles) {
				if (!prrm.isSuccess()) {
					boolean isSuccess = monthlyLoanBusiNotificationService.runReportBatch(
							prrm.getSearchPath(), ServerInfoHelper.getTempReportPath(), 
							prrm.getFile().getName(),
							params, runReport,prrm.getRowId());
					if(isSuccess){
						prrm.setSuccess(isSuccess);
						index--;
					}
				}
			}
			if (index <= 0) {
				break;
			}
			if (count > 100) {
				throw new CognosBaseException("SOAP exception!");
			}
			count++;
		}
		
		List<String> images = new ArrayList<String>();
		
		//生成.png并切割图片
		for (int i = 0; i < cacheFiles.size(); i++) {
			File pdf = cacheFiles.get(i).getFile();
			ReportChartCoordinate fr = list.get(i);
			
			String key = "image" + (i + 1);
			String pdfName = pdf.getName();
			String prefix = key + "_" + pdfName.substring(0, pdfName.lastIndexOf("."));
			String tPath = ServerInfoHelper.getTempImagePath() + File.separator + prefix + ".png";
			//生成图片
			Pdf2Image.pdf2PNG(pdf.getPath(), tPath, fr.getX1(), fr.getX2(), fr.getY1(), fr.getY2());
			
			FileInputStream in = null;
			byte[] data = null;
			try{
				in = new FileInputStream(tPath);
				data = new byte[in.available()];
				in.read(data);
				in.close();
			}catch (IOException e) {
				e.printStackTrace();
			}
			BASE64Encoder encoder = new BASE64Encoder();
			images.add(encoder.encode(data));
			
		}
		return images;
	}
	
}
