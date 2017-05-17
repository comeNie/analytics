package com.orienttech.statics.service.cognos;

import java.util.List;

import com.cognos.developer.schemas.bibus._3.ReportService_PortType;
import com.orienttech.statics.service.cognos.entity.ReportParam;

public interface ReportRunnerService {
	/**
	 * @param searchPath	模板路径
	 * @param outfileDir	输出文件路径
	 * @param outfileName	输出文件名称
	 * @param params	参数
	 
	void runReport(String searchPath,String outfileDir,String outfileName,
			List<ReportParam> params);
	*/
	/**
	 * 
	 * @param reportPath   模板路径
	 * @param outfileDir   输出文件路径
	 * @param outfileName  输出文件名称
	 * @param params       参数
	 * @param count        重试次数计数
	 * @return 
	 * @throws InterruptedException 
	 */
	boolean runReport(String reportPath, String outfileDir, String outfileName,
			List<ReportParam> params, int count) throws InterruptedException;

	boolean runReportBatch(String reportPath, String outfileDir,
			String outfileName, List<ReportParam> params,
			ReportService_PortType repService, Long rowId) throws InterruptedException;

	ReportService_PortType loginCognos();

}
