package com.orienttech.statics.service.dateSubmitQuery.impl;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.common.collect.Lists;
import com.orienttech.statics.commons.dynamicquery.DynamicQuery;
import com.orienttech.statics.dao.entity.submission.TblReportTemplate;
import com.orienttech.statics.dao.submission.TblReportTemplateDao;
import com.orienttech.statics.service.dateSubmitQuery.DateSubmitQueryService;
import com.orienttech.statics.service.model.submission.SubmitDetail;
@Service
public class DateSubmitQueryServiceImpl implements DateSubmitQueryService {
	@Autowired
	private TblReportTemplateDao dateSubmitQueryDao;
	
	@Autowired
	private DynamicQuery dynamicQuery;
	
	@SuppressWarnings("unchecked")
	@Override
	public Page<Object[]> findTemplateList(int pageNumber, int pageSize,
			String submitState, Date startDate, Date endDate, String name,
			String cycle, String orgId) {
		StringBuffer sb = new StringBuffer();
		int paramsIndex=1;
		List<Object> params=Lists.newArrayList();
		sb.append("select rt.name,rt.cycle,ts.start_time,ts.end_time,ts.sub_time,ts.org_id,rt.create_people,ts.submit_state,rt.id,rt.time_limit,ts.id as tempId from tbl_report_template rt,tbl_template_submit ts where rt.id = ts.template_id ");
		sb.append(" and ts.org_id=?").append(paramsIndex++);
		params.add(orgId);
		if(StringUtils.isNoneBlank(submitState)){
			if("1".equals(submitState)){
				sb.append(" and ts.submit_state =1");
			}else if("3".equals(submitState)){
				sb.append(" and ts.submit_state =3");
			}else if("0".equals(submitState)){
				sb.append(" and ts.submit_state =0 and sysdate-1-ts.end_time<=rt.time_limit ");
			}else {
				sb.append(" and (ts.submit_state =0 or ts.submit_state =3) and sysdate-1-ts.end_time>rt.time_limit ");
			}
		}
		if(startDate != null){
			sb.append(" and trunc(ts.sub_time,'dd') >=?").append(paramsIndex++);
			params.add(startDate);
		}
		if(endDate != null){
			sb.append(" and trunc(ts.sub_time,'dd') <=?").append(paramsIndex++);
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
		sb.append(" order by ts.sub_time desc");
		Page p = dynamicQuery.nativeQuery(new PageRequest(pageNumber, pageSize), sb.toString(),params.toArray());
		return p;
	}

	@Transactional(readOnly = true)
	@Override
	public TblReportTemplate findReportTemplateById(int id,int submitId) {
		TblReportTemplate tblReportTemplate = dateSubmitQueryDao.findReportTemplateById(id);
		tblReportTemplate.setPath(dateSubmitQueryDao.getTblTemplateSubmitById(submitId).getPath());
		return tblReportTemplate;
	}
	@Transactional(readOnly = true)
	@Override
	public SubmitDetail findDateSubmitById(int id,String workflowId) {
		List<Object> params=Lists.newArrayList();
		SubmitDetail sd=null;
		StringBuffer sb = new StringBuffer();
		sb.append("select rt.no,rt.name,rt.cycle,min(ts.sub_time),max(ts.sub_time) from tbl_report_template rt ,tbl_template_submit ts where rt.id=ts.template_id and ts.template_id=?1 and ts.workflow_id=?2 group by (name,no,rt.cycle)");
		params.add(id);
		params.add(workflowId);
		List<Object[]> reportTemplates= dynamicQuery.nativeQuery(sb.toString(), params.toArray());
		for(Object[] obs:reportTemplates){
			sd = new SubmitDetail();
			sd.setNo(String.valueOf(obs[0]));
			sd.setName(String.valueOf(obs[1]));
			sd.setCycle(String.valueOf(obs[2]));
			sd.setMinDate((Date)(obs[3]));
			sd.setMaxDate((Date)(obs[4]));
		}
		return sd;
	}
	
}


