package com.orienttech.statics.service.report;

import java.util.List;
import java.util.Map;

import com.cognos.developer.schemas.bibus._3.ReportService_PortType;
import com.orienttech.statics.dao.entity.ReportChartCoordinate;
import com.orienttech.statics.service.cognos.entity.ReportParam;
import com.orienttech.statics.service.model.report.MonthlyLoanBusiNotificationBo;

/**   
 * 类名称：RiskReportMonthService
 * 类描述 ：
 * 创建人:wangxy
 * 创建时间：2015年7月20日 下午4:11:32  
 * 修改人：wangxy
 * 修改时间：
 * 修改备注：
 * 版本： V1.0
 */
public interface MonthlyLoanBusiNotificationService {
	/**
	 * 查询数据,封装Bo
	 * @param condition
	 * @author wangxy 20150718
	 * @return
	 */
	MonthlyLoanBusiNotificationBo searchCurMonthDatas(String condition, String orgId);
	/**
	 * 将BO组装成Map
	 * @param bo
	 * @author wangxy 20150721
	 * @return
	 */
	public Map<String, Object> toGetMap(MonthlyLoanBusiNotificationBo bo);
	
	List<ReportChartCoordinate> findReportChartCoordinateAllList();
	
	ReportService_PortType loginCognos() throws InterruptedException;
	
	boolean runReportBatch(String searchPath, String outfileDir,
			String outfileName, List<ReportParam> params,
			ReportService_PortType repService, Long rowId) throws InterruptedException;
}
