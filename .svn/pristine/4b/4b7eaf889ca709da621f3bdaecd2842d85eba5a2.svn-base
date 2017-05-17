/**
 * 数据报送录入Service Impl
 * @author gph
 */
package com.orienttech.statics.service.datasubmitted.impl;

import java.util.Date;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.orienttech.statics.commons.security.SessionUser;
import com.orienttech.statics.commons.utils.CommonHelper;
import com.orienttech.statics.commons.utils.Contants;
import com.orienttech.statics.dao.entity.submission.TblReportTemplate;
import com.orienttech.statics.dao.entity.submission.TblTemplateSubmit;
import com.orienttech.statics.dao.submission.TblReportTemplateDao;
import com.orienttech.statics.dao.submission.TblTemplateSubmitDao;
import com.orienttech.statics.service.datasubmitted.DataEntryService;
import com.orienttech.statics.service.workflow.WorkFlowService.WorkFlowNode;

@Service("dataEntryService")
public class DataEntryServiceImpl implements DataEntryService {
	private Log log = LogFactory.getLog(DataEntryServiceImpl.class);

	@Autowired
	private TblTemplateSubmitDao templateSubmitDao;
	@Autowired
	private TblReportTemplateDao reportTemplateDao;
	@Autowired
	private TblTemplateSubmitDao tblTemplateSubmitDao;

	@Override
	public void save(TblTemplateSubmit templateSubmit) {
		templateSubmitDao.save(templateSubmit);
	}

	@Override
	public TblReportTemplate getReportTemplate(String workflowId) {
		return reportTemplateDao.findReportTemplateByWorkflowId(workflowId);
	}

	@Override
	public TblTemplateSubmit getTemplateSubmit(int templateId) {
		return templateSubmitDao.findTemplateSubmitByTemplateId(templateId);
	}

	@Override
	public TblTemplateSubmit getTemplateSubmitByOrgIdAndWorkflowId(
			String orgId, String workflowId) {
		return templateSubmitDao.getTemplateSubmitByOrgIdAndWorkflowId(orgId,
				workflowId);
	}

	@Override
	public void modifyStatus(SessionUser curUser, String workflowId) {
		TblTemplateSubmit ts = getTemplateSubmitByOrgIdAndWorkflowId(
				curUser.getOrgCode(), workflowId);
		if (ts != null) {
			ts.setSubmitState(Contants.REPORTED);// 状态：已上报
			ts.setSubPeople(curUser.getLoginName());// 上报人
			ts.setSubTime(CommonHelper.formatDate(new Date(),
					CommonHelper.DF_DATE));// 上报时间
			save(ts);
		} else {
			log.info("更新报表数据失败，错误原因：对象为null...");
		}
	}

	@Override
	public void update(TblTemplateSubmit templateSubmit) {
		save(templateSubmit);
	}
	
	/** 
	 * TODO
	 * 更新库状态 方法
	 */
	@Override
	@Transactional
	public String updateTemplateSubmitModel(String workflowId, String nodeId, SessionUser curUser) {
		String msg = "";
		TblTemplateSubmit ts = this.getTemplateSubmitByOrgIdAndWorkflowId(curUser.getOrgCode(), workflowId);
		if (ts == null) {
			msg = "没有找到要审批的数据，数据异常！";
		}
		if (WorkFlowNode.TJ_ReportWrite.getId().equals(nodeId)) {// 部门审核
			ts.setSubPeople(curUser.getLoginName());//上报人
			/**
			 * 报送次数，第一次上报时间
			 */
			String totalSubTimes = ts.getTotalSubTimes();
			int sum = 0;
			if(StringUtils.isNoneBlank(totalSubTimes)){
				sum = Integer.parseInt(totalSubTimes);
			}
			if(ts.getFirstSubTime() == null){
				ts.setTotalSubTimes("1");
				ts.setFirstSubTime(new Date());//第一次上报时间
				ts.setSubTime(new Date());//第一次上报，均为当前时间
			}else{
				sum += 1;
				ts.setTotalSubTimes(String.valueOf(sum));
				ts.setSubTime(new Date());//上报时间
			}
			
			this.save(ts);
		} else if (WorkFlowNode.TJ_ReportCheck.getId().equals(nodeId)) {// 统计组审核
			ts.setSubmitorgExaminePeople(curUser.getLoginName());//报送部门审核人
			ts.setSubmitorgExamineTime(new Date());//报送部门审核时间
			ts.setSubmitState(Contants.REPORTED);//已报送
			this.save(ts);
		} else if (WorkFlowNode.TJ_ReportCollect.getId().equals(nodeId)) {// 负责人审核
			//TblTemplateSubmit updateTs = new TblTemplateSubmit();
			//updateTs.setReleasePeople(curUser.getUserName());
			//updateTs.setReleaseTime(new Date());
			//updateTs.setWorkflowId(workflowId);
			//tblTemplateSubmitDao.updateByWorkflowId(curUser.getUserName(), new Date(), workflowId);
		} else {
			msg = "该环节不属于任何一个流程，请仔细查看流程！";
		}
		return msg;
	}
	/** 更新库状态 方法 */
	
	
	//审批退回时     by dz
	@Override
	@Transactional
	public String updateTemplateSubmitModelOfSendback(String workflowId, String nodeId, SessionUser curUser) {
		String msg = "";
		TblTemplateSubmit ts = this.getTemplateSubmitByOrgIdAndWorkflowId(curUser.getOrgCode(), workflowId);
		if (ts == null) {
			msg = "没有找到要审批的数据，数据异常！";
		}
		if (WorkFlowNode.TJ_ReportWrite.getId().equals(nodeId)) {// 部门审核
//			ts.setSubPeople(curUser.getLoginName());//上报人
//			ts.setSubTime(new Date());//上报时间
//			this.save(ts);
		} else if (WorkFlowNode.TJ_ReportCheck.getId().equals(nodeId)) {// 统计组审核
			ts.setSubmitorgExaminePeople(curUser.getLoginName());//报送部门审核人
			ts.setSubmitorgExamineTime(new Date());//报送部门审核时间
			ts.setSubmitState("3");//已退回
			this.save(ts);
		} else if (WorkFlowNode.TJ_ReportCollect.getId().equals(nodeId)) {// 负责人审核
			//TblTemplateSubmit updateTs = new TblTemplateSubmit();
			//updateTs.setReleasePeople(curUser.getUserName());
			//updateTs.setReleaseTime(new Date());
			//updateTs.setWorkflowId(workflowId);
			//tblTemplateSubmitDao.updateByWorkflowId(curUser.getUserName(), new Date(), workflowId);
		} else {
			msg = "该环节不属于任何一个流程，请仔细查看流程！";
		}
		return msg;
	}
}
