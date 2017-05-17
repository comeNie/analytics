package com.orienttech.statics.service.reportSumQuery;

import java.util.Date;

import org.springframework.data.domain.Page;

import com.orienttech.statics.dao.entity.submission.TblTemplateSubmit;
public interface ReportSumQueryService {
	
	Page<Object[]> findSumDetailList(int pageNumber,int pageSize, Date startTime,Date endTime, String reportName, String orgName);
	
}
