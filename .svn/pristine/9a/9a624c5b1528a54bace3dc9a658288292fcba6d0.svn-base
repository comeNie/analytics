package com.orienttech.statics.service.reportSumQuery.impl;

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
import com.orienttech.statics.service.reportSumQuery.ReportSumQueryService;
import com.orienttech.statics.service.submitDetailQuery.SubmitDetailQueryService;
@Service
public class ReportSumQueryServiceImpl implements ReportSumQueryService {
	
	@Autowired
	private DynamicQuery dynamicQuery;
	        
	@Override
	public Page<Object[]> findSumDetailList(int pageNumber,int pageSize,Date startTime,Date endTime,String reportName,String orgName) {
		StringBuffer sb = new StringBuffer("select c.name as org_name,a.name as report_name,a.release_time,b.first_sub_time,"
										+ " b.sub_time,b.total_sub_times,b.late_days,b.sub_people,b.submitorg_examine_people,a.time_limit"
										+ " from tbl_report_template a, tbl_template_submit b, t_sta_dim_org c"
										+ " where a.id=b.template_id and b.org_id=c.orgid");
		int index = 1;
		List<Object> params=Lists.newArrayList();
		
		if(startTime != null){
			sb.append(" and trunc(a.release_time,'dd') >=?").append(index++);
			params.add(startTime);
		}
		if(endTime != null){
			sb.append(" and trunc(a.release_time,'dd') <=?").append(index++);
			params.add(endTime);
		}
		if(StringUtils.isNoneBlank(reportName)){
			sb.append(" and a.name like ?").append(index++);
			params.add("%"+ reportName +"%");
		}
		if(StringUtils.isNoneBlank(orgName)){
			
			sb.append(" and c.name like ?").append(index++);
			params.add("%"+ orgName +"%");
		}
		sb.append(" order by a.release_time desc");
		return dynamicQuery.nativeQuery(new PageRequest(pageNumber, pageSize), sb.toString(),params.toArray());
	}

}
