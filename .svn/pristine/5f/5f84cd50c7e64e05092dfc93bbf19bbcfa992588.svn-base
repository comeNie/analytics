package com.orienttech.statics.service.report.thread;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.StopWatch;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.cognos.developer.schemas.bibus._3.ReportService_PortType;
import com.google.common.collect.Lists;
import com.orienttech.statics.commons.utils.CommonHelper;
import com.orienttech.statics.commons.utils.Contants;
import com.orienttech.statics.commons.utils.FileUtils;
import com.orienttech.statics.commons.utils.FreemarkerUtils;
import com.orienttech.statics.commons.utils.ImageUtils;
import com.orienttech.statics.commons.utils.Pdf2Image;
import com.orienttech.statics.dao.entity.FinancialReport;
import com.orienttech.statics.service.cognos.common.ServerInfoHelper;
import com.orienttech.statics.service.cognos.entity.ReportParam;
import com.orienttech.statics.service.cognos.exception.CognosBaseException;
import com.orienttech.statics.service.report.BizReportService;

/**
 * 构建报告线程
 *
 */
public class BuildReportProgress extends Thread {
	private Logger logger=LoggerFactory.getLogger(BuildReportProgress.class);
	
	private BizReportService bizReportService;
	private String percent = "";
	private int step=0;
	private int totalStep=3;
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

	public BuildReportProgress(BizReportService bizReportService,String orgCd, String year, String month, String orgName, String templetName) {
		super();
		this.bizReportService = bizReportService;
		this.param=new Param(orgCd, year, month, orgName, templetName);
	}
	@Override
	public void run() {
		StopWatch sw=new StopWatch();
		sw.start();
		try {
			this.changeStep();
			logger.info("CreateReportThread doing ..............................");
			List<FinancialReport> list = bizReportService.findFinancialReportAllList(param.getTempletName());
			if(CollectionUtils.isEmpty(list)){
				this.fail("模板不存在");
				logger.error("模板不存在，如有需要请联系管理员！");
			}
			totalStep = totalStep + list.size()*2;//初始化总步骤
			List<File> files=Lists.newArrayList();
			String filename=null;
			List<ReportParam> params = Arrays.asList(new ReportParam("Porgcd", param.getOrgCd()),
					new ReportParam("Pyear", param.getYear()), new ReportParam("Pmonth",param.getMonth()));
			//String filenamePrefix = this.makeFilenamePrefix(param.getOrgCd(), param.getYear(), param.getMonth());
			String filenamePrefix = String.valueOf(new Date().getTime());
			/*percent="准备开始 生成报表！";//备份 请勿 删除
			//int count = 1;
			for (FinancialReport fr : list) {
				//count++;//计数
				this.changeStep();
				percent="正在生成第"+fr.getRowId()+"个报表！";
				filename=filenamePrefix+fr.getRowId()+".pdf";
				
				try {
					bizReportService.runReport(fr.getSearchPath(), ServerInfoHelper.getTempReportPath(), filename, params);
					logger.info("{}报表保存在{}",fr.getReportName(),ServerInfoHelper.getTempReportPath()+File.separator+filename);
					if (count == 20) {
						throw new Exception("我的一个异常");
					}
				} catch (Exception e) {
					logger.info("执行[{}]报表失败",fr.getReportName());
					logger.error("执行报表失败",e);
					this.fail("执行["+fr.getReportName()+"]报表失败，如有需要请联系管理员！");
					over = true;
					return;
				} finally {
					files.add(new File(ServerInfoHelper.getTempReportPath() + File.separator + filename));
					logger.info(percent);
					if (this.failed) {//如果失败,提前停掉线程
						this.interrupt();
					}
				}
				
			}*/
			//尝试全部跑完，然后重新跑失败的
			//首先初始化跑批列表
			List<PdfRunReportModel> cacheFiles = new ArrayList<PdfRunReportModel>();
			
			for (FinancialReport fr : list) {
				filename = filenamePrefix + fr.getRowId() + ".pdf";
				PdfRunReportModel pdf = new PdfRunReportModel();
				pdf.setRowId(fr.getRowId());
				pdf.setReportName(fr.getReportName());
				pdf.setSearchPath(fr.getSearchPath());
				pdf.setFile(new File(ServerInfoHelper.getTempReportPath() + File.separator + filename));
				cacheFiles.add(pdf);
			}
			this.changeStep();
			
			percent="准备开始 生成报表！";
			int index = cacheFiles.size();
			int count = 0;
			while(index > 0) {
				ReportService_PortType runReport = bizReportService.loginCognos();
				for (PdfRunReportModel prrm : cacheFiles) {
					if (!prrm.isSuccess()) {
						if (count > 0) {
							percent="重新尝试生成第" + prrm.getRowId() + "个报表！";
						}else {
							percent="正在生成第" + prrm.getRowId() + "个报表！";
						}
						boolean isSuccess = bizReportService.runReportBatch(
								prrm.getSearchPath(), ServerInfoHelper.getTempReportPath(), 
								prrm.getFile().getName(),
								params, runReport,prrm.getRowId());
						if(isSuccess){
							this.changeStep();
							prrm.setSuccess(isSuccess);
							index--;
						}
					}
				}
				logger.info("执行[{}]个报表失败", index);
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
				percent = "正在处理第" + (i + 1) + "个报表！";
				this.changeStep();
				File pdf = cacheFiles.get(i).getFile();
				FinancialReport fr = list.get(i);
				
				String key = "image" + (i + 1);
				String pdfName = pdf.getName();
				String prefix = key + "_" + pdfName.substring(0, pdfName.lastIndexOf("."));
				String tPath = ServerInfoHelper.getTempImagePath() + File.separator + prefix + ".png";
				
				Pdf2Image.pdf2PNG(pdf.getPath(), tPath, fr.getX1(), fr.getY1(), fr.getX2(), fr.getY2());
				fileImages.put(key , tPath);
			}
			
			percent="正在将" + cacheFiles.size() + "个报表合并！";
			Pdf2WordUtil.createWord(fileImages, filenamePrefix + ".doc", param.getYear(), param.getMonth(), param.getOrgName(), param.getTempletName());
			reportPath = FreemarkerUtils.wordPath + File.separator + filenamePrefix + ".doc";
			if(Contants.ALL_TEMPLET.equals(param.getTempletName())){
				reportName = "邦信所有机构财务及经营情况月报";
			} else if(Contants.XD_TEMPLET.equals(param.getTempletName())){
				reportName = "邦信小贷全辖财务及经营情况月报";
			} else if(Contants.SIG_TEMPLET.equals(param.getTempletName())){
				reportName = "邦信小贷公司财务及经营情况月报";
			} else {
				reportName = "邦信小贷公司财务及经营情况月报";
			}
			
			this.changeStep();
			over = true;
		} catch (CognosBaseException e) {
			this.fail("报表获取失败！如有需要请联系管理员！");
			logger.error("文件找不到",e);
		} catch (Exception e) {
			this.fail("报表生成失败！如有需要请联系管理员！");
			logger.error("报表生成失败",e);
		}
		over = true;
		sw.stop();
		logger.info("生成报表共耗时{}秒",(double)(Math.round(sw.getTime()/1000)*100/100.0));
	}
	private void changeStep(){
		step++;
		logger.info("正在进行：{}",step);
	}
	/**
	 * @param msg
	 */
	private void fail(String msg){
		this.failed=true;
		percent=msg;
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
	/**
	 * 进度比例（两位小数处理）
	 * @return
	 */
	public double getProgressRatio() {
		double d=new Double(totalStep);
		BigDecimal bd = new BigDecimal(step/d);
		return bd.movePointRight(2).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
	}
	
	/**
	 * 生成文件前缀规则
	 * @param orgCd
	 * @param year
	 * @param month
	 * @return
	 */
	private String makeFilenamePrefix(String orgCd, String year, String month) {
		StringBuffer strBuffer=new StringBuffer("temp"+CommonHelper
				.date2Str(CommonHelper.getNow(), "yyyyMMdd"));
		strBuffer.append(StringUtils.defaultString(StringUtils.contains(orgCd, ",")?"ALL":orgCd));//机构
		strBuffer.append(StringUtils.defaultString(year));//查询年份
		strBuffer.append(StringUtils.defaultString(month));//查询月份
		return strBuffer.toString();
	}
	private class Param{
		private String orgCd;
		private String year;
		private String month;
		private String orgName;
		private String templetName;
		public Param(String orgCd, String year, String month, String orgName, String templetName) {
			super();
			this.orgCd = orgCd;
			this.year = year;
			this.month = month;
			this.orgName = orgName;
			this.templetName = templetName;
		}
		public String getOrgCd() {
			return orgCd;
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
	public String getPercent() {
		return percent;
	}
	public int getStep() {
		return step;
	}
}
