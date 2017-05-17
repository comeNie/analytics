package com.orienttech.statics.service.report.impl;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.shiro.SecurityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognos.developer.schemas.bibus._3.ReportService_PortType;
import com.google.common.base.Function;
import com.google.common.collect.Lists;
import com.orienttech.statics.commons.dynamicquery.DynamicQuery;
import com.orienttech.statics.commons.security.SessionUser;
import com.orienttech.statics.commons.utils.CommonHelper;
import com.orienttech.statics.commons.utils.PdfMergeUtils;
import com.orienttech.statics.dao.FinancialReportDao;
import com.orienttech.statics.dao.entity.FinancialReport;
import com.orienttech.statics.service.cognos.CreateReportService;
import com.orienttech.statics.service.cognos.ReportRunnerService;
import com.orienttech.statics.service.cognos.common.ServerInfoHelper;
import com.orienttech.statics.service.cognos.entity.ReportParam;
import com.orienttech.statics.service.cognos.exception.CognosBaseException;
import com.orienttech.statics.service.model.report.AssetPackageInfo;
import com.orienttech.statics.service.report.BizReportService;

import static com.orienttech.statics.commons.utils.Contants.ALL_TEMPLET;
import static com.orienttech.statics.commons.utils.Contants.XD_TEMPLET;

@Service
public class BizReportServiceImpl implements BizReportService {
	private Logger logger=LoggerFactory.getLogger(BizReportServiceImpl.class);
	@Autowired
	private DynamicQuery dynamicQuery;
	@Autowired
	private FinancialReportDao financialReportDao;
	@Autowired
	private CreateReportService createReportService;
	@Autowired
	private ReportRunnerService reportRunnerService;
	
	@Override
	public List<AssetPackageInfo> findAssetPackageInfo(String orgId) {
		// 取机构
		String sql = null;
		List<Object[]> list=null;
		if(StringUtils.isBlank(orgId)){
			return null;
		}
		if (("10001").equals(orgId)) {
			sql = "select distinct asset_package_id,asset_package_name from fact_contract order by asset_package_id";
			list=dynamicQuery.nativeQuery(sql);
		} else {
			sql = "select distinct asset_package_id,asset_package_name from fact_contract  where  apply_org_id=?1 order by asset_package_id  ";
			list=dynamicQuery.nativeQuery(sql,orgId);
		}
		if(CollectionUtils.isEmpty(list)){
			return null;
		}
		return Lists.transform(list, new Function<Object[], AssetPackageInfo>() {

			@Override
			public AssetPackageInfo apply(Object[] objs) {
				return new AssetPackageInfo(objs);
			}
		});
	}
	@Override
	public List<String> buildReport(String orgCd, String year, String month) {
		List<FinancialReport> list=financialReportDao.findAllList("1");//修改dao方法之后默认查询结果和以前全部查询保持一致
		if(CollectionUtils.isEmpty(list)){
			throw new CognosBaseException("模板不存在");
		}
		List<String> filenames=Lists.newArrayList();
		String filename=null;
		List<ReportParam> params = Arrays.asList(new ReportParam("Porgcd", orgCd),
				new ReportParam("Pyear", year), new ReportParam("Pmonth",month));
		String filenamePrefix = this.getFilenamePrefix(orgCd, year, month);
		for (FinancialReport fr : list) {
			filename=filenamePrefix+fr.getRowId()+".PDF";
			//createReportService.runReport(orgCd, year, month, fr.getSearchPath(), filename);
			try {
				reportRunnerService.runReport(fr.getSearchPath(), ServerInfoHelper.getTempReportPath(), filename, params, 0);
			} catch (Exception e) {
				continue;
			}
			filenames.add(filename);
		}
		logger.info(ToStringBuilder.reflectionToString(filenames));
		return filenames;
	}
	private String getFilenamePrefix(String orgCd, String year, String month) {
		String str=CommonHelper
				.date2Str(CommonHelper.getNow(), "yyyyMMdd")
		+ StringUtils.defaultString(orgCd)+StringUtils.defaultString(year)+StringUtils.defaultString(month);
		return "temp"+str.hashCode();
	}
	@Override
	public String buildMergeReport(String orgCd, String year, String month) {
		List<String> filenames = this.buildReport(orgCd, year, month);
		if(CollectionUtils.isEmpty(filenames)){
			throw new CognosBaseException("生成文件失败");
		}
		List<File> files=Lists.newArrayList();
		for (String filename : filenames) {
			files.add(new File(ServerInfoHelper.getTempReportPath()+File.separator+filename));
		}
		String filePath=ServerInfoHelper.getTempReportPath()+File.separator+"mergeReport.pdf";
		try {
			PdfMergeUtils.concatPdfs(new FileOutputStream(filePath), files);
		} catch (FileNotFoundException e) {
			throw new CognosBaseException("文件找不到");
		} catch (IOException e) {
			throw new CognosBaseException("文件合并失败");
		}
		return filePath;
	}
	@Override
	public List<FinancialReport> findFinancialReportAllList(String templetName) {
		System.out.println("=============" + templetName);//1:单家机构2:所有机构3:所有小贷机构
		if (XD_TEMPLET.equals(templetName)) {
			return financialReportDao.findAllList("3");
		} else if (ALL_TEMPLET.equals(templetName)) {
			return financialReportDao.findAllList("2");
		} else {
			return financialReportDao.findAllList("1");
		}
	}
	@Override
	public boolean runReport(String searchPath, String outfileDir,
			String outfileName, List<ReportParam> params) throws InterruptedException {
		return reportRunnerService.runReport(searchPath, outfileDir, outfileName, params, 0);
	}
	
	@Override
	public boolean runReportBatch(String searchPath, String outfileDir,
			String outfileName, List<ReportParam> params, ReportService_PortType repService,Long rowId) throws InterruptedException {
		return reportRunnerService.runReportBatch(searchPath, outfileDir, outfileName, params, repService, rowId);
	}
	
	@Override
	public ReportService_PortType loginCognos() throws InterruptedException {
		return reportRunnerService.loginCognos();
	}
	
	//设置查询下载报表时参数中的用户名和密码
	@Override
	public List<Object[]> getUsernameAndPsw(){
		SessionUser user=	(SessionUser)SecurityUtils.getSubject().getPrincipal();
		String userName = user.getLoginName();
		
		String sql = "select USERNAME,PASSWORD from COGUSERS where USERNAME='"+userName+"'";
		
		List<Object[]> list = dynamicQuery.nativeQuery(sql);
		
		return list;
	}
	
}
