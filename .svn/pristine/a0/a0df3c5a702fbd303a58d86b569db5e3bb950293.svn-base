package com.orienttech.statics.service.submitDetailQuery;

import java.util.Date;

import org.springframework.data.domain.Page;

import com.orienttech.statics.dao.entity.submission.TblTemplateSubmit;
public interface SubmitDetailQueryService {
	Page<Object[]> findSubmitDetailList(int pageNumber,int pageSize,String submitState, Date startDate,Date endDate, String name, String cycle);
	Page<Object[]> findDetailList(int pageNumber,int pageSize,int id,String workflowId);
	
}
