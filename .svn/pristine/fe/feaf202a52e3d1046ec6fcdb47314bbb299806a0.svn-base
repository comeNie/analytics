package com.orienttech.statics.service.templateMng;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.web.multipart.MultipartFile;

import com.orienttech.statics.commons.security.SessionUser;
import com.orienttech.statics.dao.entity.submission.TblReportTemplate;
import com.orienttech.statics.service.model.submission.TaskReceiverBo;
import com.orienttech.statics.service.model.sysmng.MenuBo;
import com.orienttech.statics.service.model.workflow.WorkFlowTaskIds;
import com.orienttech.statics.service.workflow.WorkFlowService.ActionCode;
import com.orienttech.statics.service.workflow.WorkFlowService.RoleCode;
import com.orienttech.statics.service.workflow.WorkFlowService.WorkFlowCode;
import com.orienttech.statics.service.workflow.WorkFlowService.WorkFlowNode;

public interface TemplateMngService {

	Page<Object[]> queryTemplate(Integer pageNumber, Integer pageSize, 
			String beginTime, String endTime, String status, String cycle, String reportName);
	
	TblReportTemplate queryTemplateById(String templateId);
	
	boolean updateExcute(String templateId, String state);
	
	void add(TblReportTemplate tblReportTemplate, MultipartFile myfile,String sOs);
	
	void sendAudit(TblReportTemplate tblReportTemplate,SessionUser sessionUser, MultipartFile myfile,String receivers);
	
	boolean getCountByName(String name,String id);
	
	boolean getCountByNo(String no,String id);
	
	TblReportTemplate getTemplateByWorkflowId(String workflowId);
	
	String queryRoleBySsoId(String loginName);
	
	String queryOrgNameByOrgId(String orgId);
	
	String queryRoleNameByRoleId(String roleId); 
	
	String getTaskReceiver(String roleId);
	
	String getTemplateTaskSubject(String loginName, String nodeId,String workflowCode, boolean isBack);
	
	String getReportTaskSubject(String workflowCode, boolean isBack);
	
	RoleCode getRoleCode(String nodeId);
	
	void updateTemplateModel(String actionCode,String workflowId, String nodeId, SessionUser curUser);
	
	List<TblReportTemplate> getTemplateByStatusAndCycle(String status,int cycle);
	
	TblReportTemplate getReportTemplateId(String workflowId);
	
	String getTaskSender(String templateId,String roleId);
	
	String getTaskReceiver(String orgIdArrays,String roleId);
	
	WorkFlowTaskIds auditCommitOrSendBack(WorkFlowCode wfc, String workflowId,
			String wfTaskId, String loginName, WorkFlowNode wfn, ActionCode ac,
			String comments, String orgId, String receivers, String nodeId) throws Exception;
	
	WorkFlowTaskIds auditFinish(WorkFlowCode wfc, String workflowId,
			String wfTaskId, String loginName, WorkFlowNode wfn, ActionCode ac,
			String comments, String orgId) throws Exception;

	String queryUserNameByLoginName(Object loginName);
	
	WorkFlowTaskIds auditSendBack(WorkFlowCode byId, String workflowId, String wfTaskId,
			String loginName, WorkFlowNode nodeById, ActionCode actionCodeById,
			String comments, String string, String receivers) throws Exception;
	
	List<TaskReceiverBo> findTaskReceiverMenuTreeList(String orgId);
}

