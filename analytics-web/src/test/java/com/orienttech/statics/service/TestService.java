package com.orienttech.statics.service;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import org.junit.Test;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import com.orienttech.statics.commons.utils.PdfMergeUtils;
import com.orienttech.statics.service.cognos.CreateReportService;
import com.orienttech.statics.service.cognos.ReportRunnerService;
import com.orienttech.statics.service.cognos.common.ServerInfoHelper;
import com.orienttech.statics.service.cognos.impl.CreateReportServiceImpl;
import com.orienttech.statics.service.cognos.impl.ReportRunnerServiceImpl;
import com.orienttech.statics.webservice.model.SyncUser;

public class TestService {
	@Test
	public void test00() throws Exception {
		CreateReportService createReportService=new CreateReportServiceImpl();
		createReportService.runReport("'61540'", "'2014'", "'05'",
				"/content/folder[@name='temp']/report[@name='demo1']",
				"wertertwer.PDF");
	}
	@Test
	public void test01() throws Exception {
		SyncUser user=new SyncUser();
		user.setName("345354345");
		System.out.println(JSON.toJSONString(user));
		CreateReportService createReportService=new CreateReportServiceImpl();
		createReportService.runReport("'61540'", "'2014'", "'05'",
				"/content/folder[@name='New_Public']/folder[@name='Finance']/folder[@name='OverallFinance']/report[@name='Asset_liability_structure']",
				"wertertwer.PDF");
	}
	@Test
	public void testName2() throws Exception {
		CreateReportService createReportService=new CreateReportServiceImpl();
		createReportService.runReport("'61540'", "'2014'", "'05'",
				"/content/folder[@name='New_Public']/folder[@name='Finance']/folder[@name='OverallFinance']/report[@name='Overall_financial_profile']",
				"wertertwer08888888888.PDF");
	}
	
	@Test
	public void testName() throws Exception {
		List<File> list=Lists.newArrayList();
		String filePath=null;
		for (int i = 0; i < 38; i++) {
			filePath=ServerInfoHelper.getTempReportPath()+File.separator+"temp20141210"+i+".PDF";
			System.out.println(filePath);
			list.add(new File(filePath));
		}
		PdfMergeUtils.concatPdfs(new FileOutputStream("D:/testMerge01.pdf"),list);
	}
	@Test
	public void testName1() throws Exception {
		ReportRunnerService rrs=new ReportRunnerServiceImpl();
		String reportPath = "/content/folder[@name='AutoExecReport']/report[@name='Loan_OverDue_Org']";
		rrs.runReport(reportPath, ServerInfoHelper.getReportPath(), "reportrunner344.xlsx", null, 0);
	}
}
