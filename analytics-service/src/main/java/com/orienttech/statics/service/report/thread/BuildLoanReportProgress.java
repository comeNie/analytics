package com.orienttech.statics.service.report.thread;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.time.StopWatch;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.cognos.developer.schemas.bibus._3.ReportService_PortType;
import com.orienttech.statics.commons.utils.FreemarkerUtils;
import com.orienttech.statics.commons.utils.Pdf2Image;
import com.orienttech.statics.dao.entity.ReportChartCoordinate;
import com.orienttech.statics.service.cognos.common.ServerInfoHelper;
import com.orienttech.statics.service.cognos.entity.ReportParam;
import com.orienttech.statics.service.cognos.exception.CognosBaseException;
import com.orienttech.statics.service.model.report.MonthlyLoanBusiNotificationBo;
import com.orienttech.statics.service.report.MonthlyLoanBusiNotificationService;

public class BuildLoanReportProgress extends Thread {
	private Logger logger=LoggerFactory.getLogger(BuildLoanReportProgress.class);
	
	private MonthlyLoanBusiNotificationService monthlyLoanBusiNotificationService;
	/**
	 * 是否已失败
	 */
	private boolean failed=false;
	/**
	 * 结束标识
	 */
	private boolean over = false;
	/**
	 * 参数
	 */
	private Param param;
	/**
	 * 生成的报告路径
	 */
	private String reportPath;
	/**
	 * 生成的报告名称
	 */
	private String reportName;
	
	public BuildLoanReportProgress(MonthlyLoanBusiNotificationService monthlyLoanBusiNotificationService,String orgId, String year, String month, String orgName, String templetName,MonthlyLoanBusiNotificationBo bo) {
		super();
		this.monthlyLoanBusiNotificationService = monthlyLoanBusiNotificationService;
		this.param=new Param(orgId, year, month, orgName, templetName);
	}
	@Override
	public void run() {
		StopWatch sw=new StopWatch();
		sw.start();
		try {
			logger.info("启动线程开始 ..............................");//TODO
			List<ReportChartCoordinate> list = monthlyLoanBusiNotificationService.findReportChartCoordinateAllList();
			if(CollectionUtils.isEmpty(list)){
				this.fail("模板不存在");
				logger.error("模板不存在，如有需要请联系管理员！");
			}
			String filename=null;
			List<ReportParam> params = Arrays.asList(new ReportParam("Porgcd", param.getOrgId()),
					new ReportParam("Pyear", param.getYear()), new ReportParam("Pmonth",param.getMonth()));
			
			String filenamePrefix = String.valueOf(new Date().getTime());
			
			//尝试全部跑完，然后重新跑失败的
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
				Thread.sleep(3000);
				count++;
			}
			
			//生成png并切割图片
			Map<String, String> fileImages = new HashMap<String, String>();
			for (int i = 0; i < cacheFiles.size(); i++) {
				File pdf = cacheFiles.get(i).getFile();
				ReportChartCoordinate fr = list.get(i);
				
				String key = "image" + (i + 1);
				String pdfName = pdf.getName();
				String prefix = key + "_" + pdfName.substring(0, pdfName.lastIndexOf("."));
				String tPath = ServerInfoHelper.getTempImagePath() + File.separator + prefix + ".png";
				//生成图片
				Pdf2Image.pdf2PNG(pdf.getPath(), tPath, fr.getX1(), fr.getY1(), fr.getX2(), fr.getY2());
				fileImages.put(key , tPath);
				
			}
			
			
			
			
			Pdf2WordUtil.createWord(fileImages, filenamePrefix + ".doc", param.getYear(), param.getMonth(), param.getOrgName(), param.getTempletName());
			reportPath = FreemarkerUtils.wordPath + File.separator + filenamePrefix + ".doc";
			reportName = "邦信小贷月度贷款业务情况通报";
			
			over = true;
		} catch (CognosBaseException e) {
			this.fail("报表获取失败！如有需要请联系管理员！");
			logger.error("文件找不到",e);
		} catch (Exception e) {
			this.fail("报表获取失败！如有需要请联系管理员！");
			logger.error("报表生成失败",e);
		}
		over = true;
		sw.stop();
	}
	
	public boolean isOver() {
		return over;
	}
	public boolean isFailed() {
		return failed;
	}
	public String getReportPath() {
		return reportPath;
	}
	public String getReportName() {
		return reportName;
	}
	
	private class Param{
		private String orgId;
		private String year;
		private String month;
		private String orgName;
		private String templetName;
		public Param(String orgId, String year, String month, String orgName, String templetName) {
			super();
			this.orgId = orgId;
			this.year = year;
			this.month = month;
			this.orgName = orgName;
			this.templetName = templetName;
		}
		public String getOrgId() {
			return orgId;
		}
		public String getYear() {
			return year;
		}
		public String getMonth() {
			return month;
		}
		public String getOrgName() {
			return orgName;
		}
		public String getTempletName() {
			return templetName;
		}
	}
	private void fail(String msg){
		this.failed=true;
	}
	
	
}
