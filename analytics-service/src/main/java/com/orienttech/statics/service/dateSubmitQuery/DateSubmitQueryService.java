package com.orienttech.statics.service.dateSubmitQuery;

import java.util.Date;

import org.springframework.data.domain.Page;

import com.orienttech.statics.dao.entity.submission.TblReportTemplate;
import com.orienttech.statics.service.model.submission.SubmitDetail;

public interface DateSubmitQueryService {
	Page<Object[]> findTemplateList(int pageNumber,int pageSize,String submitState, Date startDate,Date endDate, String name, String cycle,String orgId);
	public TblReportTemplate findReportTemplateById(int id,int submitId);
	public SubmitDetail findDateSubmitById(int id,String workflowId);
}
