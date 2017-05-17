package com.orienttech.statics.service.reportResultQuery;

import org.springframework.data.domain.Page;

import com.orienttech.statics.dao.entity.PassRead;
import com.orienttech.statics.dao.entity.submission.TblTemplateSum;
public interface ReportResultQueryService {
	
	Page<Object[]> queryReportResult(Integer pageNumber, Integer pageSize, String reportName, String reportCycle, String releaseTimeBegin, String releaseTimeEnd, String releasePeople);
	
	TblTemplateSum queryById(String id);
	/**
	 * 根据流程ID获取汇总表
	 * @param workflowId
	 * @return
	 */
	TblTemplateSum queryByWorkflowId(String workflowId);
	
	/**
	 * 添加传阅信息
	 * @param passRead
	 */
	void addPassRead(PassRead passRead);
}
