package com.orienttech.statics.service;

import java.io.File;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang3.time.StopWatch;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.orienttech.statics.dao.AutoExecPlanDao;
import com.orienttech.statics.dao.AutoExecRecordDao;
import com.orienttech.statics.service.cognos.ReportRunnerHelper;
import com.orienttech.statics.service.cognos.ReportRunnerService;
import com.orienttech.statics.service.cognos.common.ServerInfoHelper;
import com.orienttech.statics.service.cognos.entity.ReportParam;
import com.orienttech.statics.service.report.BizReportService;
import com.orienttech.statics.service.report.HistoryReportService;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class TestAutoExecService {
	@Autowired
	private AutoExecRecordDao autoExecRecordDao;
	@Autowired
	private AutoExecPlanDao autoExecPlanDao;
	@Autowired
	private HistoryReportService historyReportService;
	@Autowired
	private ReportRunnerService reportRunnerService;
	
	@Autowired
	private BizReportService bizReportService;
	@Test
	public void testName() throws Exception {
		System.out.println(autoExecPlanDao.findAll());
		//System.out.println(autoExecRecordDao.findAll());
	}
	
	@Test
	public void testPlanList() throws Exception {
		System.out.println(autoExecPlanDao.findListByState());
		//System.out.println(autoExecRecordDao.findAll());
	}
	@Test
	public void testAutoExecReport() throws Exception {
		historyReportService.autoExecReport();
	}
	
	/**
	 * 无参报表
	 * @throws Exception
	 */
	@Test
	public void testRunReport() throws Exception {
		reportRunnerService.runReport("/content/folder[@name='AutoExecReport']/report[@name='LoanAll_Detail']", ServerInfoHelper.getTempReportPath(), "sserererer.PDF", null, 0);
	}
	/**
	 * 无参报表
	 * @throws Exception
	 */
	@Test
	public void testRunReport0() throws Exception {
		List<ReportParam> params = Arrays.asList(new ReportParam("abc", "61540"));
		reportRunnerService.runReport("/content/folder[@name='temp']/report[@name='test1']", ServerInfoHelper.getTempReportPath(), "sserererer.PDF", params, 0);
	}
	/**
	 * 当个测试
	 * @throws Exception
	 */
	@Test
	public void testRunReport00() throws Exception {
		List<ReportParam> params = Arrays.asList(new ReportParam("Porgcd",""),
				new ReportParam("Pyear", "2014"), new ReportParam("Pmonth","09"));
		reportRunnerService.runReport("/content/folder[@name='New_Public']/folder[@name='Finance']/folder[@name='OverallFinance']/report[@name='Overall_financial_profile']", ServerInfoHelper.getTempReportPath(), "sserererer.PDF", params, 0);
	}
	/**
	 * 当个测试
	 * @throws Exception
	 */
	@Test
	public void testRunReport1() throws Exception {
		/*List<ReportParam> params = Arrays.asList(new ReportParam("Porgcd", "61540"),
				new ReportParam("Pyear", "2014"), new ReportParam("Pmonth","05"));
		reportRunnerService.runReport("/content/folder[@name='temp']/report[@name='Balance_structure_report']", ServerInfoHelper.getTempReportPath(), "sserererer.PDF", params);*/
		List<ReportParam> params = null;
		reportRunnerService.runReport("/content/folder[@name='New_Public']/folder[@name='Finance']/folder[@name='Performance']/report[@name='Quantitative_performance_scores']", ServerInfoHelper.getTempReportPath(), "sserererer.PDF", params, 0);
	}
	/**
	 * 批量测试
	 * @throws Exception
	 */
	@Test
	public void testBuildReport() throws Exception {
		bizReportService.buildReport("61540", "2014", "05");
	}
	
	@Test
	public void testBuildMergerReport() throws Exception {
		StopWatch sw=new StopWatch();
		sw.start();
		String str=bizReportService.buildMergeReport("61540", "2014", "05");
		System.out.println(str);
		sw.stop();
		System.out.println("耗时"+sw.getTime()+"ms");
	}
	
	/**
	 * 定时报表测试
	 * @throws Exception
	 */
//	@Test
//	public void testRunReportPoint() throws Exception {
//		List<ReportParam> params = Arrays.asList(new ReportParam("Porgcd", "61540"));
//		reportRunnerService.runReportBatch("/content/folder[@name='temp']/report[@name='LoanAll_Detail']", "E:\\", "report.xlsx", params, reportRunnerService.loginCognos());
//	}
}
