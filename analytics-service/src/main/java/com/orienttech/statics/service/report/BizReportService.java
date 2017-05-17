package com.orienttech.statics.service.report;

import java.util.List;

import com.cognos.developer.schemas.bibus._3.ReportService_PortType;
import com.orienttech.statics.dao.entity.FinancialReport;
import com.orienttech.statics.service.cognos.entity.ReportParam;
import com.orienttech.statics.service.model.report.AssetPackageInfo;

public interface BizReportService {
	 /**
	 * @param orgId
	 * @return
	 */
	List<AssetPackageInfo> findAssetPackageInfo(String orgId);
	
	/**
	 * 构建报表
	 * @param orgCd
	 * @param year
	 * @param month
	 * @return
	 */
	List<String> buildReport(String orgCd, String year, String month);
	/**
	 * 构建报表并合并
	 * @param orgCd
	 * @param year
	 * @param month
	 * @return
	 */
	String buildMergeReport(String orgCd, String year, String month);
	/**
	 * 
	 * @return
	 */
	List<FinancialReport> findFinancialReportAllList(String templetName);
	/**
	 * @param reportPath
	 * @param outfileDir
	 * @param outfileName
	 * @param params
	 * @return 
	 * @throws InterruptedException 
	 */
	public boolean runReport(String searchPath, String outfileDir,
			String outfileName, List<ReportParam> params) throws InterruptedException;

	boolean runReportBatch(String searchPath, String outfileDir,
			String outfileName, List<ReportParam> params,
			ReportService_PortType repService, Long rowId) throws InterruptedException;

	ReportService_PortType loginCognos() throws InterruptedException;

	/*
	 * cognos参数中的用户名和密码
	 */
	List getUsernameAndPsw();

}
