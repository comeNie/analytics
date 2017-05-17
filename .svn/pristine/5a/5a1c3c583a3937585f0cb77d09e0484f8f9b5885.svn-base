package com.orienttech.statics.service.submitDetailQuery.impl;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.google.common.collect.Lists;
import com.orienttech.statics.commons.dynamicquery.DynamicQuery;
import com.orienttech.statics.dao.entity.submission.TblTemplateSubmit;
import com.orienttech.statics.service.submitDetailQuery.SubmitDetailQueryService;
@Service
public class SubmitDetailQueryServiceImpl implements SubmitDetailQueryService {
	
	@Autowired
	private DynamicQuery dynamicQuery;
	        
	@Override
	public Page<Object[]> findSubmitDetailList(int pageNumber, int pageSize,
			String sumState, Date startDate, Date endDate, String name,String cycle) {
		StringBuffer sb = new StringBuffer();
		int paramsIndex=1;
		List<Object> params=Lists.newArrayList();
		sb.append("select rt.name,rt.cycle,ts.template_start_time,ts.template_end_time,ts.sum_state,rt.create_people,rt.id,ts.workflow_id from tbl_report_template rt,tbl_template_sum ts where rt.id = ts.template_id ");
		if(StringUtils.isNoneBlank(sumState)){
			sb.append(" and ts.sum_state =?").append(paramsIndex++);
			params.add(sumState);
		}
		if(startDate != null){
			sb.append(" and trunc(ts.template_end_time,'dd') >=?").append(paramsIndex++);
			params.add(startDate);
		}
		if(endDate != null){
			sb.append(" and trunc(ts.template_end_time,'dd') <=?").append(paramsIndex++);
			params.add(endDate);
		}
		if(StringUtils.isNoneBlank(name)){
			sb.append(" and rt.name like ?").append(paramsIndex++);
			params.add("%"+ name +"%");
		}
		if(StringUtils.isNoneBlank(cycle)){
			sb.append(" and rt.cycle =?").append(paramsIndex++);
			params.add(cycle);
		}
		return dynamicQuery.nativeQuery(new PageRequest(pageNumber, pageSize), sb.toString(),params.toArray());
	}

	@SuppressWarnings("unchecked")
	@Override
	public Page<Object[]> findDetailList(int pageNumber, int pageSize, int id,String workflowId) {
		List<Object> params=Lists.newArrayList();
		StringBuffer sb = new StringBuffer();
		sb.append("select ts.org_id,ts.submit_state,ts.sub_time,ts.real_path from tbl_template_submit ts where ts.template_id=?1 and ts.workflow_id=?2");
		params.add(id);
		params.add(workflowId);
		return dynamicQuery.nativeQuery(new PageRequest(pageNumber, pageSize), sb.toString(), params.toArray());
	}

}
