package com.orienttech.statics.service.sysmng;

import java.util.Map;

import com.orienttech.statics.service.model.ColumnAndLineChartInfo;
import com.orienttech.statics.service.model.LineChartInfo;

public interface DashboardService {
	/**
	 * 查询当年累计贷款金额
	 * @param orgId
	 * @return
	 */
	LineChartInfo findChartDataTotalLoanAmt(String orgId);
	/**
	 * @param orgId
	 * @return
	 */
	LineChartInfo findChartDataLoanAddLine(String orgId);
	
	/**
	 * @param orgId
	 * @return
	 */
	LineChartInfo findChartDataOfLbBar(String orgId);
	/**
	 * @param orgId
	 * @return
	 */
	Map<String, Object> findChartDataOfLbGuarModePie(String orgId);
	/**
	 * @param orgId
	 * @return
	 */
	Map<String, Object> findChartDataOfLbAmtPie(String orgId);
	
	
	//一下为柱状图和曲线图混合类型
	/**
	 * 图1_1
	 * @param orgId
	 * @return
	 */
	ColumnAndLineChartInfo findColumnAndLineChartData1_1(String orgId);
	
	/**
	 * 图1_2
	 * @param orgId
	 * @return
	 */
	ColumnAndLineChartInfo findColumnAndLineChartData1_2(String orgId);
	
	/**
	 * 图2_1
	 * @param orgId
	 * @return
	 */
	ColumnAndLineChartInfo findColumnAndLineChartData2_1(String orgId);
	
	/**
	 * 图2_2
	 * @param orgId
	 * @return
	 */
	ColumnAndLineChartInfo findColumnAndLineChartData2_2(String orgId);
	
	/**
	 * 图3_1
	 * @param orgId
	 * @return
	 */
	ColumnAndLineChartInfo findColumnAndLineChartData3_1(String orgId);
	
	/**
	 * 图3_2
	 * @param orgId
	 * @return
	 */
	ColumnAndLineChartInfo findColumnAndLineChartData3_2(String orgId);
	
	/**
	 * 图4_1
	 * @param orgId
	 * @return
	 */
	ColumnAndLineChartInfo findColumnAndLineChartData4_1(String orgId);
	
	/**
	 * 图4_2
	 * @param orgId
	 * @return
	 */
	ColumnAndLineChartInfo findColumnAndLineChartData4_2(String orgId);
	
	/**
	 * 图5_1
	 * @param orgId
	 * @return
	 */
	ColumnAndLineChartInfo findColumnAndLineChartData5_1(String orgId);
	
	/**
	 * 图5_2
	 * @param orgId
	 * @return
	 */
	ColumnAndLineChartInfo findColumnAndLineChartData5_2(String orgId);
	
}
