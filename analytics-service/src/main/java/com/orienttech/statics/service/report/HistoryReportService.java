package com.orienttech.statics.service.report;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Page;

import com.orienttech.statics.service.model.report.HistoryReportBo;

public interface HistoryReportService {
	/**
	 * 根据code分组报表名称
	 * @return
	 */
	List<HrTypeCode> findAllHistRptListByCode();
	/**
	 * 查询历史报表
	 * @param reportNameType
	 * @param stateDate
	 * @param endDate
	 * @return
	 */
	Page<Object[]> findHistoryReportList(int pageNumber,int pageSize,String reportNameType, Date stateDate,Date endDate, String orgId, String fOrgId);
	
	
	/**
	 * 保存历史报表
	 * @param reportBo
	 */
	void saveHistoryReport(HistoryReportBo reportBo);
	
	void autoExecReport();
	
	public class HrTypeCode{
		private String code;
		private String name;
		
		
		public HrTypeCode(String code, String name) {
			super();
			this.code = code;
			this.name = name;
		}
		public String getCode() {
			return code;
		}
		public void setCode(String code) {
			this.code = code;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		
	}
}
