package com.orienttech.statics.service.cognos.impl;

import java.io.File;
import java.io.FileOutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import javax.xml.rpc.ServiceException;

import org.apache.axis.AxisFault;
import org.apache.axis.client.Stub;
import org.apache.axis.encoding.Base64;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognos.developer.schemas.bibus._3.AsynchDetailReportOutput;
import com.cognos.developer.schemas.bibus._3.AsynchOptionEnum;
import com.cognos.developer.schemas.bibus._3.AsynchOptionInt;
import com.cognos.developer.schemas.bibus._3.AsynchReply;
import com.cognos.developer.schemas.bibus._3.AsynchReplyStatusEnum;
import com.cognos.developer.schemas.bibus._3.BiBusHeader;
import com.cognos.developer.schemas.bibus._3.CAM;
import com.cognos.developer.schemas.bibus._3.FormFieldVar;
import com.cognos.developer.schemas.bibus._3.FormatEnum;
import com.cognos.developer.schemas.bibus._3.HdrSession;
import com.cognos.developer.schemas.bibus._3.Option;
import com.cognos.developer.schemas.bibus._3.OutputEncapsulationEnum;
import com.cognos.developer.schemas.bibus._3.ParameterValue;
import com.cognos.developer.schemas.bibus._3.ParmValueItem;
import com.cognos.developer.schemas.bibus._3.ReportService_PortType;
import com.cognos.developer.schemas.bibus._3.ReportService_ServiceLocator;
import com.cognos.developer.schemas.bibus._3.RunOptionBoolean;
import com.cognos.developer.schemas.bibus._3.RunOptionEnum;
import com.cognos.developer.schemas.bibus._3.RunOptionOutputEncapsulation;
import com.cognos.developer.schemas.bibus._3.RunOptionStringArray;
import com.cognos.developer.schemas.bibus._3.SearchPathSingleObject;
import com.cognos.developer.schemas.bibus._3.SimpleParmValueItem;
import com.google.common.base.Function;
import com.google.common.collect.Lists;
import com.orienttech.statics.service.cognos.ReportRunnerService;
import com.orienttech.statics.service.cognos.common.BIBusHeaderHelper;
import com.orienttech.statics.service.cognos.common.ServerInfoHelper;
import com.orienttech.statics.service.cognos.common.ServerInfoHelper.ServerInfo;
import com.orienttech.statics.service.cognos.entity.ReportParam;
import com.orienttech.statics.service.cognos.exception.CognosBIException;
import com.orienttech.statics.service.cognos.exception.CognosBaseException;
import com.orienttech.statics.service.model.usermng.OrgDeptBo;
import com.orienttech.statics.service.usermng.OrgDeptService;
@Service
public class ReportRunnerServiceImpl implements ReportRunnerService {
	private Logger logger = LoggerFactory
			.getLogger(ReportRunnerServiceImpl.class);

	@Autowired
	private OrgDeptService orgDeptService;
	@Override
	@Deprecated
	public boolean runReport(String reportPath, String outfileDir,
			String outfileName, List<ReportParam> params, int count) throws InterruptedException {
		count++;//计数加1
		boolean flag = true;
		String reportType = getExtensionName(outfileName);
		ServerInfo si = ServerInfoHelper.getServerInfo();
		// Specify a user to log in as.
		final String userName = si.getUserName();
		final String userPassword = si.getUserPassword();
		final String userNamespace = si.getUserNamespace();
		final String COGNOS_URL = this.getCognosUrl(si);
		final String outputPath = outfileDir + File.separator + outfileName;
		// yhz add
		byte binaryOutput[] = null;
		ReportService_PortType repService = this.getReportService(COGNOS_URL);
		if (repService == null) {
			throw new CognosBaseException("get ReportService_PortType Fail !");
		}
		// Set up the biBusHeader for a logon.
		if (StringUtils.isNoneBlank(userName)
				&& StringUtils.isNoneBlank(userPassword)
				&& StringUtils.isNoneBlank(userNamespace)) {
			//logger.info("Logging on as {} in the {} namespace.", userName, userNamespace);
			this.setUpHeader(repService, userName, userPassword, userNamespace);
		}
		// Set up the report parameters.
		boolean yesParam=true;
		if(CollectionUtils.isEmpty(params)){
			yesParam=false;
		}
		ParameterValue parameters[] = this.initParameterValues(params);
		Option[] runOptions = this.initRunOptions(reportType,yesParam);

		// Now, run the report.
		try {
			//logger.info("Running the report...");
			//logger.info("Report search path is:{}",reportPath);
			
			SearchPathSingleObject spso = new SearchPathSingleObject(reportPath);
			
			AsynchReply res = repService.run(spso, parameters, runOptions);
			// The report is finished, let's fetch the results and save them to
			// a file.
			if (res.getStatus() == AsynchReplyStatusEnum.complete) {
				AsynchDetailReportOutput reportOutput = null;
				for (int i = 0; i < res.getDetails().length; i++) {
					if (res.getDetails()[i] instanceof AsynchDetailReportOutput) {
						reportOutput = (AsynchDetailReportOutput) res.getDetails()[i];
						break;
					}
				}

				/*
				 * String[] data = reportOutput.getOutputPages();
				 */
				File tFile = new File(outputPath);
				if (tFile.exists()) {
					boolean isSuccess = tFile.delete();
					System.out.println("=====================" + isSuccess + "==================");
				}
				//logger.info("Writing report output to {}...", outputPath);
				FileOutputStream fs = new FileOutputStream(outputPath);

				/*
				 * 
				 * // URIs in the output are relative on the server; we need to
				 * // make them absolute so they reference the server properly.
				 * String uriFix = "http://" + serverHost + ":" + serverPort +
				 * "/ibmcognos/";
				 * 
				 * for (int idx = 0; idx < data.length; idx++) { String
				 * fixed_hunk = replaceSubstring(data[idx], "../", uriFix);
				 * fs.write( fixed_hunk.getBytes() ); }
				 */
				binaryOutput = Base64.decode(reportOutput.getOutputPages()[0]);
				fs.write(binaryOutput);
				fs.close();
				//logger.info("RunReport done.............................");
			}
		} catch (AxisFault ex) {
			//logger.error("SOAP exception!\n {}", CognosBIException.convertToString(ex));
			/*logger.error("当前重连次数为：第" + count + "次;" + "my tried counts is " + count + "| 重试中....");
			Thread.sleep(2000);
			runReport(reportPath, outfileDir, outfileName, params, count);*/
			
			/*logger.error("SOAP exception!\n {}", CognosBIException.convertToString(ex));
			if (count > 5) {//计数大于5
				logger.error("计数超过" + count + "次，" + "抛出SOAP exception!");
				throw new CognosBaseException("SOAP exception!", ex);
			} else {//重试
				logger.error("当前重试次数为：第" + count + "次;" + "my tried counts is " + count + "| 重试中.");
				Thread.sleep(2000);
				runReport(reportPath, outfileDir, outfileName, params, count);
			}*/
			flag = false;
		} catch (Exception ex) {
			//logger.error("SOAP exception!\n {}", ex.getMessage());
			flag = false;
		}
		return flag;
	}
	
	
	//kyf create 20150120
	@Override
	public boolean runReportBatch(String reportPath, String outfileDir,
			String outfileName, List<ReportParam> params,
			ReportService_PortType repService, Long rowId) throws InterruptedException {
		boolean flag = true;
		StringBuffer sb = new StringBuffer();
		String orgIdBefore="";
		if(params!=null){// 历史报表生成“全部”报表时params为空
		orgIdBefore = params.get(0).getVal().toString();
		if(orgIdBefore.length()==5){
			if(rowId==14L||rowId==16L||rowId==18L||rowId==23L||rowId==29L){
				List<OrgDeptBo> list = orgDeptService.findOrgDeptListByOrgId("0");
				for(int i=0;i<list.size();i++){
					sb.append(list.get(i).getId().toString());
					if(i<list.size()-1){
						sb.append(",");
					}
				}
				params.get(0).setVal(sb.toString());
			}
		}
		}
		String reportType = getExtensionName(outfileName);
		final String outputPath = outfileDir + File.separator + outfileName;
		byte binaryOutput[] = null;
		// Set up the report parameters.
		boolean yesParam=true;
		if(CollectionUtils.isEmpty(params)){
			yesParam=false;
		}
		ParameterValue parameters[] = this.initParameterValues(params);
		Option[] runOptions = this.initRunOptions(reportType,yesParam);
		try {
			SearchPathSingleObject spso = new SearchPathSingleObject(reportPath);
			
			AsynchReply res = repService.run(spso, parameters, runOptions);
			if (res.getStatus() == AsynchReplyStatusEnum.complete) {
				AsynchDetailReportOutput reportOutput = null;
				for (int i = 0; i < res.getDetails().length; i++) {
					if (res.getDetails()[i] instanceof AsynchDetailReportOutput) {
						reportOutput = (AsynchDetailReportOutput) res.getDetails()[i];
						break;
					}
				}
				File tFile = new File(outputPath);
				if (tFile.exists()) {
					boolean isSuccess = tFile.delete();
				}
				FileOutputStream fs = new FileOutputStream(outputPath);
				binaryOutput = Base64.decode(reportOutput.getOutputPages()[0]);
				fs.write(binaryOutput);
				fs.close();
			}
			if(params!=null){
			if(orgIdBefore.length()==5){
				if(rowId==14L||rowId==16L||rowId==18L||rowId==23L||rowId==29L){
					params.get(0).setVal(orgIdBefore);
				}
			}
			}
		} catch (AxisFault ex) {
			flag = false;
		} catch (Exception ex) {
			flag = false;
		}
		return flag;
	}
	
	@Override
	public ReportService_PortType loginCognos(){
		ServerInfo si = ServerInfoHelper.getServerInfo();
		final String userName = si.getUserName();
		final String userPassword = si.getUserPassword();
		final String userNamespace = si.getUserNamespace();
		final String COGNOS_URL = this.getCognosUrl(si);
		
		// yhz add
		ReportService_PortType repService = this.getReportService(COGNOS_URL);
		if (repService == null) {
			throw new CognosBaseException("get ReportService_PortType Fail !");
		}
		// Set up the biBusHeader for a logon.
		if (StringUtils.isNoneBlank(userName)
				&& StringUtils.isNoneBlank(userPassword)
				&& StringUtils.isNoneBlank(userNamespace)) {
			//logger.info("Logging on as {} in the {} namespace.", userName, userNamespace);
			this.setUpHeader(repService, userName, userPassword, userNamespace);
		}
		return repService;
	}

	private ParameterValue[] initParameterValues(List<ReportParam> params) {
		if(CollectionUtils.isEmpty(params)){
			return new ParameterValue[]{};
		}
		List<ParameterValue> pvs=Lists.transform(params, new Function<ReportParam, ParameterValue>() {

			@Override
			public ParameterValue apply(ReportParam rr) {
				ParameterValue pv=new ParameterValue();
				pv.setName(rr.getName());
				pv.setValue(new ParmValueItem[]{new SimpleParmValueItem(Boolean.TRUE, rr.getVal(), rr.getVal())});
				return pv;
			}
		});
		return pvs.toArray(new ParameterValue[pvs.size()]);
	}

	private Option[] initRunOptions(final String outFileType,boolean yesParam) {
		String outputFormatVal = "HTML";
		if (StringUtils.equalsIgnoreCase(outFileType, "XLSX")) {
			outputFormatVal = "spreadsheetML";
		} else if (StringUtils.equalsIgnoreCase(outFileType, "PDF")) {
			outputFormatVal = "PDF";
		}
		
		Option runOptions[] = new Option[5];

		RunOptionBoolean saveOutput = new RunOptionBoolean();
		saveOutput.setName(RunOptionEnum.saveOutput);
		saveOutput.setValue(false);
		runOptions[0] = saveOutput;

		// TODO: Output format should be specified on the command-line
		RunOptionStringArray outputFormat = new RunOptionStringArray();
		outputFormat.setName(RunOptionEnum.outputFormat);
		outputFormat.setValue(new String[] { outputFormatVal });
		runOptions[1] = outputFormat;
		if(yesParam){
			RunOptionBoolean prompt = new RunOptionBoolean();
			prompt.setName(RunOptionEnum.prompt);
			prompt.setValue(false);
			runOptions[2] = prompt;
		}else{
			RunOptionOutputEncapsulation outputEncapsulation = new RunOptionOutputEncapsulation();
			outputEncapsulation.setName(RunOptionEnum.outputEncapsulation);
			outputEncapsulation.setValue(OutputEncapsulationEnum.none);
			runOptions[2] = outputEncapsulation;
		}

		AsynchOptionInt primaryWait = new AsynchOptionInt();
		primaryWait.setName(AsynchOptionEnum.primaryWaitThreshold);
		primaryWait.setValue(0);
		runOptions[3] = primaryWait;

		AsynchOptionInt secondaryWait = new AsynchOptionInt();
		secondaryWait.setName(AsynchOptionEnum.secondaryWaitThreshold);
		secondaryWait.setValue(0);
		runOptions[4] = secondaryWait;
		return runOptions;
	}

	/**
	 * @param cognosUrl
	 * @return
	 */
	private ReportService_PortType getReportService(final String cognosUrl) {
		ReportService_ServiceLocator reportServiceLocator = new ReportService_ServiceLocator();
		ReportService_PortType repService = null;
		try {
			repService = reportServiceLocator.getreportService(new URL(
					cognosUrl));
		} catch (MalformedURLException ex) {
			logger.info("Server URL was: {}", cognosUrl);
			logger.error("Caught a MalformedURLException:\n{}"
					+ ex.getMessage());
		} catch (ServiceException ex) {
			logger.error("Caught a ServiceException: {}", ex.getMessage());
			ex.printStackTrace();
		}
		return repService;
	}

	/**
	 * @param repService
	 * @param user
	 * @param pass
	 * @param name
	 */
	private void setUpHeader(ReportService_PortType repService, String user,
			String pass, String name) {
		BiBusHeader bibus = BIBusHeaderHelper
				.getHeaderObject(((Stub) repService).getResponseHeader("",
						"biBusHeader"));
		if (bibus != null) {
			if (bibus.getTracking() != null) {
				if (bibus.getTracking().getConversationContext() != null) {
					bibus.getTracking().setConversationContext(null);
				}
			}

			return;
		}
		bibus = new BiBusHeader();
		bibus.setCAM(new CAM());
		bibus.getCAM().setAction("logonAs");
		bibus.setHdrSession(new HdrSession());

		FormFieldVar ffs[] = new FormFieldVar[3];

		ffs[0] = new FormFieldVar();
		ffs[0].setName("CAMUsername");
		ffs[0].setValue(user);
		ffs[0].setFormat(FormatEnum.not_encrypted);

		ffs[1] = new FormFieldVar();
		ffs[1].setName("CAMPassword");
		ffs[1].setValue(pass);
		ffs[1].setFormat(FormatEnum.not_encrypted);

		ffs[2] = new FormFieldVar();
		ffs[2].setName("CAMNamespace");
		ffs[2].setValue(name);
		ffs[2].setFormat(FormatEnum.not_encrypted);

		bibus.getHdrSession().setFormFieldVars(ffs);

		((Stub) repService).setHeader(
				"http://developer.cognos.com/schemas/bibus/3/", "biBusHeader",
				bibus);
	}

	private String getCognosUrl(ServerInfo si) {
		logger.info("Creating connection to {}:{}", si.getServerHost(),
				si.getServerPort());
		return "http://" + si.getServerHost() + ":" + si.getServerPort()
				+ "/p2pd/servlet/dispatch";
	}

	/**
	 * 获取文件扩展名
	 * 
	 * @param filename
	 * @return
	 */
	private String getExtensionName(String filename) {
		if ((filename != null) && (filename.length() > 0)) {
			int dot = filename.lastIndexOf('.');
			if ((dot > -1) && (dot < (filename.length() - 1))) {
				return filename.substring(dot + 1);
			}
		}
		return filename;
	}
}
