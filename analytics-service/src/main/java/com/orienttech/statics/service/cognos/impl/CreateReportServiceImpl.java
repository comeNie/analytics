package com.orienttech.statics.service.cognos.impl;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.cognos.developer.schemas.bibus._3.AsynchDetailReportObject;
import com.cognos.developer.schemas.bibus._3.AsynchReply;
import com.cognos.developer.schemas.bibus._3.AsynchReplyStatusEnum;
import com.cognos.developer.schemas.bibus._3.Option;
import com.cognos.developer.schemas.bibus._3.ParameterValue;
import com.cognos.developer.schemas.bibus._3.ReportServiceQueryOptionBoolean;
import com.cognos.developer.schemas.bibus._3.ReportServiceQueryOptionEnum;
import com.cognos.developer.schemas.bibus._3.ReportServiceQueryOptionSpecificationFormat;
import com.cognos.developer.schemas.bibus._3.ReportServiceReportSpecification;
import com.cognos.developer.schemas.bibus._3.SearchPathSingleObject;
import com.cognos.developer.schemas.bibus._3.Specification;
import com.cognos.developer.schemas.bibus._3.SpecificationFormatEnum;
import com.orienttech.statics.service.cognos.CreateReportService;
import com.orienttech.statics.service.cognos.ReportRunnerHelper;
import com.orienttech.statics.service.cognos.common.LogonSessionMng;
import com.orienttech.statics.service.cognos.common.ServerInfoHelper;
import com.orienttech.statics.service.cognos.entity.AddReport;
import com.orienttech.statics.service.cognos.entity.CRNConnect;
import com.orienttech.statics.service.cognos.entity.DeleteReport;
@Service
public class CreateReportServiceImpl implements CreateReportService {
	private Logger logger = LoggerFactory
			.getLogger(CreateReportServiceImpl.class);

	@Override
	public void runReport(String orgCd, String year, String month,
			String queryContent,String outFileName) {

		String tempdirsearchpath = "/content/folder[@name='temp']";
		String tempreportname = "temp2014120501";
		String tempreportsearchpath = tempdirsearchpath + "/report[@name='"
				+ tempreportname + "']";
		CRNConnect connect = LogonSessionMng.initLoginInfo();
		/*
		 * if (LogonSessionMng.checkLogin(connect)) {
		 * logger.error("Login Fail !!!"); return; }
		 */
		String reportXml = this.getReportSpec(connect, queryContent);
		//logger.info(reportXml);
		reportXml = this.replaceAllParams(reportXml);
		/* 创建新的临时报表 */
		ReportServiceReportSpecification newReportSpec = new ReportServiceReportSpecification();
		newReportSpec.setValue(new Specification(reportXml));
		logger.info("===============================================================================");
		//logger.info(reportXml);
		AddReport addreport = new AddReport();

		try {
			String result = addreport.addSpecToCM(connect, newReportSpec,
					tempdirsearchpath, tempreportname);
			logger.info(result);
			ReportRunnerHelper.runReport(tempreportsearchpath,ServerInfoHelper.getTempReportPath(),outFileName, ReportRunnerHelper.loginCognos());
			DeleteReport dr=new DeleteReport();
			dr.todeleteReport(connect,tempreportsearchpath);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * 
	 * @return
	 */
	private String getReportSpec(CRNConnect connect, String reportPath) {
		String reportSpec = "";

		if ((connect.getReportService() != null)
		// && (report != null)
				&& (connect.getDefaultSavePath() != null)) {
			// sn_dg_prm_smpl_modifyreport_P1_start_0
			try {
				Option[] qOpts = new Option[2];

				ReportServiceQueryOptionBoolean upgradeSpecFlag = new ReportServiceQueryOptionBoolean();
				upgradeSpecFlag.setName(ReportServiceQueryOptionEnum.upgrade);
				upgradeSpecFlag.setValue(true);

				ReportServiceQueryOptionSpecificationFormat specFormat = new ReportServiceQueryOptionSpecificationFormat();
				specFormat
						.setName(ReportServiceQueryOptionEnum.specificationFormat);
				specFormat.setValue(SpecificationFormatEnum.report);

				qOpts[0] = upgradeSpecFlag;
				qOpts[1] = specFormat;

				// sn_dg_sdk_method_reportService_query_start_1
				AsynchReply qResult = connect.getReportService().query(
						new SearchPathSingleObject(reportPath),
						new ParameterValue[] {}, qOpts);
				// sn_dg_sdk_method_reportService_query_end_1

				if ((qResult.getStatus() == AsynchReplyStatusEnum.working)
						|| (qResult.getStatus() == AsynchReplyStatusEnum.stillWorking)) {
					while ((qResult.getStatus() == AsynchReplyStatusEnum.working)
							|| (qResult.getStatus() == AsynchReplyStatusEnum.stillWorking)) {
						qResult = connect.getReportService().wait(
								qResult.getPrimaryRequest(),
								new ParameterValue[] {}, new Option[] {});
					}
				}

				// sn_dg_sdk_method_reportService_query_start_2

				// extract the report spec
				if (qResult.getDetails() != null) {
					for (int i = 0; i < qResult.getDetails().length; i++) {
						if (qResult.getDetails()[i] instanceof AsynchDetailReportObject) {
							reportSpec = ((AsynchDetailReportObject) qResult
									.getDetails()[i]).getReport()
									.getSpecification().getValue();
						}
					}
				}
				// sn_dg_sdk_method_reportService_query_end_2

			}
			// sn_dg_prm_smpl_modifyreport_P1_end_0
			catch (java.rmi.RemoteException remoteEx) {
				System.out.println(remoteEx.getMessage());
				remoteEx.printStackTrace();
			}
		}
		return reportSpec;
	}

	private String replaceAllParams(String reportXml) {
		/* 替换报表参数 */
		// 调换机构
		reportXml = reportXml.replaceAll("\\?Porgcd\\?", "'61540'");
		String[] searchList={"# prompt (&#39;Porgcd&#39;)  #",
				"#promptmany (&#39;Porgcd&#39;)  #","# promptmany (&#39;Porgcd&#39;)  #",
				"# promptmany(&#39;Porgcd&#39;)  #","#promptmany (&#39;Porgcd&#39;) #"};
		String[] replaceList={"'61540'","'61540'","'61540'","'61540'","'61540'"};
		
		reportXml=StringUtils.replaceEach(reportXml, searchList, replaceList);
		/*reportXml=StringUtils.replace(reportXml, "# prompt (&#39;Porgcd&#39;)  #", "'61540'");
		reportXml=StringUtils.replace(reportXml, "#promptmany (&#39;Porgcd&#39;)  #", "'61540'");
		reportXml=StringUtils.replace(reportXml, "# promptmany (&#39;Porgcd&#39;)  #", "'61540'");
		reportXml=StringUtils.replace(reportXml, "# promptmany(&#39;Porgcd&#39;)  #", "'61540'");
		reportXml=StringUtils.replace(reportXml, "#promptmany (&#39;Porgcd&#39;) #", "'61540'");*/
		
		// 如果是全部机构
		// reportxml = reportxml.replaceAll("=\\?Porgcd\\?","<>''") ;

		/* 替换报表参数 */
		// 年度
		reportXml = reportXml.replaceAll("\\?Pyear\\?", "'2014'");
		reportXml = reportXml
				.replaceAll("ParamDisplayValue('Pyear')", "'2014'");
		// 月份
		reportXml = reportXml.replaceAll("\\?Pmonth\\?", "'05'");
		reportXml = reportXml.replaceAll("ParamDisplayValue('Pmonth')", "'05'");
		return reportXml;
	}

}
