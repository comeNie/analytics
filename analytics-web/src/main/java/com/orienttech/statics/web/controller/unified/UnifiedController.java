package com.orienttech.statics.web.controller.unified;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.orienttech.statics.commons.base.BaseController;
import com.orienttech.statics.commons.base.Result;
import com.orienttech.statics.commons.security.SessionUser;
import com.orienttech.statics.commons.utils.FileUtils;
import com.orienttech.statics.commons.utils.PropertiesConstants;
import com.orienttech.statics.dao.entity.submission.ResendComments;
import com.orienttech.statics.dao.entity.submission.TblReportTemplate;
import com.orienttech.statics.dao.entity.submission.TblTemplateSubmit;
import com.orienttech.statics.dao.entity.submission.TblTemplateSum;
import com.orienttech.statics.dao.submission.ResendCommentsDao;
import com.orienttech.statics.service.datasubmitted.DataEntryService;
import com.orienttech.statics.service.dateSummarize.DateSummarizeService;
import com.orienttech.statics.service.model.workflow.TaskAction;
import com.orienttech.statics.service.model.workflow.TaskTransferProcess;
import com.orienttech.statics.service.model.workflow.TodoTask;
import com.orienttech.statics.service.model.workflow.TypedResult;
import com.orienttech.statics.service.model.workflow.WorkFlowTaskIds;
import com.orienttech.statics.service.reportResultQuery.ReportResultQueryService;
import com.orienttech.statics.service.templateMng.TemplateMngService;
import com.orienttech.statics.service.usermng.UserMngService;
import com.orienttech.statics.service.workflow.WorkFlowService;
import com.orienttech.statics.service.workflow.WorkFlowService.ActionCode;
import com.orienttech.statics.service.workflow.WorkFlowService.WorkFlowCode;
import com.orienttech.statics.service.workflow.WorkFlowService.WorkFlowNode;

@Controller
@RequestMapping("/unified")
public class UnifiedController extends BaseController {

	@RequestMapping("/verifyidentity")
	@ResponseBody
	public Result verifyIdentity(HttpServletRequest request, String logname) {
		SessionUser curUser = (SessionUser) SecurityUtils.getSubject().getPrincipal();
		if (curUser != null && curUser.getLoginName() != null && logname.equals(curUser.getLoginName())) {
			//宸茬櫥褰�骞朵笖璐﹀彿涓�嚧
			return success();
		} else {
			return failure();
		}
	}
	/** ----------------------------------鍒嗗壊绾�------------------------------------------------- */
	
	@Autowired
	private WorkFlowService workFlowService;
	@Autowired
	private TemplateMngService templateMngService;
	@Autowired
	private DataEntryService dataEntryService;
	@Autowired
	private DateSummarizeService dateSummarizeService;
	@Autowired
	private ResendCommentsDao resendCommentsDao;
	@Autowired
	private ReportResultQueryService reportResultQueryService;
	@Autowired
	private UserMngService userMngService;
	
	@RequestMapping("/todoDeal")
	public String audit(Model model, HttpServletRequest request) {
		
		String workflowId = request.getParameter("workflowid");
		String workflowCode = request.getParameter("workflowcode");
		String wfTaskId = request.getParameter("wftaskid");
		String nodeId = request.getParameter("nodeid");
		String taskStatus = request.getParameter("taskstatus");
		
		SessionUser curUser = (SessionUser) SecurityUtils.getSubject().getPrincipal();
		String loginName = curUser.getLoginName();
		logger.info(UnifiedController.class + " : loginName " + loginName);
		
		TodoTask taskInfo = new TodoTask();
		taskInfo.setWorkflowId(workflowId);
		taskInfo.setWorkflowCode(workflowCode);
		taskInfo.setWfTaskId(wfTaskId);
		taskInfo.setNodeId(nodeId);
		taskInfo.setOrgId(curUser.getOrgCode());
		String path = "/templateAudit";
		try {
			
			if (WorkFlowCode.TemplateWorkflow.getCodeId().equalsIgnoreCase(taskInfo.getWorkflowCode())) {
				
				TblReportTemplate tblReportTemplate =  templateMngService.getTemplateByWorkflowId(taskInfo.getWorkflowId());
				
				model.addAttribute("reportTemplate", tblReportTemplate);
				path = "/templateAudit";//模板发布
				logger.info("模板发布环节：" + path.substring(1) + ".jsp");
			} else if(WorkFlowCode.ReportWorkflow.getCodeId().equalsIgnoreCase(taskInfo.getWorkflowCode())) {
				
				path = "/reportWriteAudit";//报表填写
				logger.info("报表填写环节：" + path.substring(1) + ".jsp");
				if (WorkFlowNode.TJ_ReportCollect.getId().equalsIgnoreCase(taskInfo.getNodeId())) {
					
					TblReportTemplate reportTemplate = templateMngService.getReportTemplateId(taskInfo.getWorkflowId());
					model.addAttribute("reportTemplateId",(reportTemplate == null || reportTemplate.getId() == null) ? "0" : reportTemplate.getId());
					
					TblTemplateSum templateSum = reportResultQueryService.queryByWorkflowId(workflowId);
					String templateSumId = ((templateSum == null || templateSum.getId() == null) ? "0" : templateSum.getId()).toString();
					model.addAttribute("templateSumId", templateSumId);
					
					path = "/reportCollectAudit";//报表收集
					logger.info("报表收集环节：" + path.substring(1) + ".jsp");
				} else if (WorkFlowNode.TJ_ReportWrite.getId().equalsIgnoreCase(taskInfo.getNodeId())) {
					
					path = "/reportWriteAudit";
					logger.info("报表填写环节：" + path.substring(1) + ".jsp");
				}
			}
			if (StringUtils.isNoneEmpty(taskStatus) && "80".equals(taskStatus)) {
				workFlowService.startProcessingTask(taskInfo.getWorkflowId(), taskInfo.getWfTaskId(), loginName);
			}
		} catch (Exception e) {
			return "error/500";
		}
		model.addAttribute("taskInfo",taskInfo);
		return "unified" + path;
	}
	
	@RequestMapping("/doneDeal")
	public String view(Model model, HttpServletRequest request) {
		
		SessionUser curUser = (SessionUser) SecurityUtils.getSubject().getPrincipal();
		
		String workflowId = request.getParameter("workflowid");
		String workflowCode = request.getParameter("workflowcode");
		String nodeId = request.getParameter("nodeId");
		
		TodoTask taskInfo = new TodoTask();
		taskInfo.setWorkflowId(workflowId);
		taskInfo.setWorkflowCode(workflowCode);
		taskInfo.setNodeId(nodeId);
		taskInfo.setOrgId(curUser.getOrgCode());
		String path = "/templateView";
		try{
			if (WorkFlowCode.TemplateWorkflow.getCodeId().equalsIgnoreCase(taskInfo.getWorkflowCode())) {
				TblReportTemplate tblReportTemplate =  templateMngService.getTemplateByWorkflowId(taskInfo.getWorkflowId());
				model.addAttribute("reportTemplate", tblReportTemplate);
				path = "/templateView";
				logger.info("模板发布环节(已办)：" + path.substring(1) + ".jsp");
			} else if(WorkFlowCode.ReportWorkflow.getCodeId().equalsIgnoreCase(taskInfo.getWorkflowCode())) {
				
				if (WorkFlowNode.TJ_ReportCollect.getId().equalsIgnoreCase(taskInfo.getNodeId())) {
					TblReportTemplate reportTemplate = templateMngService.getReportTemplateId(taskInfo.getWorkflowId());
					model.addAttribute("reportTemplateId",(reportTemplate == null || reportTemplate.getId() == null) ? "" : reportTemplate.getId());
					path = "/reportCollectView";
					logger.info("报表收集环节/发布后(已办)：" + path.substring(1) + ".jsp");
				} else{
					path = "/reportWriteView";
					logger.info("报表填写环节(已办)：" + path.substring(1) + ".jsp");
				}
			}
			
		}catch(Exception e) {
			e.printStackTrace();
			return "error/500";
		}
		model.addAttribute("taskInfo",taskInfo);
		return "unified" + path;
	}
	/** ----------------------------------------娴佺▼瀹℃壒------------------------------------------------*/
	/**
	 * 鑾峰彇鎿嶄綔鍔熻兘淇℃伅
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/getTaskActions/{nodeId}", method = RequestMethod.POST)
	@ResponseBody
	public Result getTaskActions(@PathVariable("nodeId") String nodeId) {
		TypedResult<List<TaskAction>> actionList = null;
		try {
			actionList = workFlowService.getTaskActions(WorkFlowNode.getNodeById(nodeId));
		} catch (Exception e) {
			e.printStackTrace();
			return failure("数据异常，请联系管理员解决",null);
		}
		return success(actionList.getData());
	}
	/**
	 * 查看单机构弹出框的审批过程意见、时间等
	 * @param workflowId
	 * @return
	 */
	@RequestMapping(value = "/openDetail", method = RequestMethod.POST)
	@ResponseBody
	public Result openDetail(String workflowId,String orgId) {
		TypedResult<List<TaskTransferProcess>> result = null;
		try {
			result = workFlowService.getTaskTransferProcessOfWorkflow(workflowId,"DESC");
			/**
			 * 单机构处理，使用remove()方法倒序遍历
			 * add by wangxy 20160125
			 */
			List<TaskTransferProcess> list = result.getData();
			
			for(int i = list.size()-1;i>=0;i--){
				String org_Id = list.get(i).getOrgId();//接收人机构
				String[] taskAssignee = list.get(i).getTaskAssignee().split(",");//接收人账号
				
				if(org_Id == null){
					org_Id = userMngService.findUserBySsoId(taskAssignee[0]).getOrgCode();
					list.get(i).setOrgId(org_Id);
				}else{
					if(!org_Id.equals(orgId)){
						list.remove(i);
					}
				}
			}
			result.setData(list);
		} catch (Exception e) {
			return failure("数据异常，请联系管理员解决",null);
		}
		return result;
	}
	/**
	 *  查看审批过程意见、时间等
	 * @param workflowId
	 * @return
	 */
	@RequestMapping(value = "/detail", method = RequestMethod.POST)
	@ResponseBody
	public Result detail(String workflowId) {
		TypedResult<List<TaskTransferProcess>> result = null;
		try {
			result = workFlowService.getTaskTransferProcessOfWorkflow(workflowId,"DESC");
		} catch (Exception e) {
			return failure("数据异常，请联系管理员解决",null);
		}
		return result;
	}
	/**
	 *  重发意见
	 * @param workflowId
	 * @param orgId
	 * @param response
	 */
	@RequestMapping(value = "/resendComments", method = RequestMethod.POST)
	@ResponseBody
	public void resendComments(String workflowId,String orgId,HttpServletResponse response) {
		List<ResendComments> result = null;
		PrintWriter out = null;
		try {
			out = response.getWriter();
			if("".equals(orgId)||orgId==null){
			result = resendCommentsDao.getResendCommentsByWorkflowId(workflowId);
			}else{
			result = resendCommentsDao.getResendCommentsByWorkflowIdAndOrgid(workflowId,orgId);
			}
			} catch (Exception e) {
			e.printStackTrace();
		}
		JSONArray array = JSONArray.fromObject(result);
		out.print(array);
	}
	
	@RequestMapping(value = "/auditNext", method = RequestMethod.POST)
	@ResponseBody
	public Result auditNext(String actionCode,
			String workflowId, String wfTaskId, String comments,
			String nodeId, String workflowCode,String receivers) {
		String msg = "";
		SessionUser curUser = (SessionUser) SecurityUtils.getSubject().getPrincipal();
		try {
			/**
			 * 模板发布流程
			 */
			if (WorkFlowCode.TemplateWorkflow.getCodeId().equals(workflowCode)) {
				templateMngService.updateTemplateModel(actionCode,workflowId,nodeId,curUser);
				/**
				 * 提交审核actionCode 1
				 */
				if (ActionCode.COMMIT.getCodeId().equals(actionCode)) {
					templateMngService.auditCommitOrSendBack( 
							WorkFlowCode.getById(workflowCode), 
							workflowId, 
							wfTaskId, 
							curUser.getLoginName(), 
							WorkFlowNode.getNodeById(nodeId), 
							ActionCode.getActionCodeById(actionCode), 
							comments, 
							curUser.getOrgCode().toString(),
							receivers,
							nodeId);
				/**
				 * 退回actionCode 2
				 */
				} else if (ActionCode.SEND_BACK.getCodeId().equals(actionCode)) {
					templateMngService.auditSendBack(
							WorkFlowCode.getById(workflowCode), 
							workflowId, 
							wfTaskId, 
							curUser.getLoginName(), 
							WorkFlowNode.getNodeById(nodeId), 
							ActionCode.getActionCodeById(actionCode), 
							comments, 
							curUser.getOrgCode().toString(), 
							receivers);
					/*templateMngService.auditCommitOrSendBack(
							WorkFlowCode.getById(workflowCode), 
							workflowId, 
							wfTaskId, 
							curUser.getLoginName(), 
							WorkFlowNode.getNodeById(nodeId), 
							ActionCode.getActionCodeById(actionCode), 
							comments, 
							curUser.getOrgCode().toString());*/
				/**
				 * 发布actionCode 8
				 */
				} else if (ActionCode.FINISH.getCodeId().equals(actionCode)) {
					templateMngService.auditFinish(
							WorkFlowCode.getById(workflowCode), 
							workflowId, 
							wfTaskId, 
							curUser.getLoginName(), 
							WorkFlowNode.getNodeById(nodeId), 
							ActionCode.getActionCodeById(actionCode), 
							comments, 
							curUser.getOrgCode().toString());
				} else {
					return failure("流程审核失败，请稍后重试", null);
				}
			/**
			 * 报表上报流程
			 */
			} else if (WorkFlowCode.ReportWorkflow.getCodeId().equals(workflowCode)) {
				
				if (ActionCode.COMMIT.getCodeId().equals(actionCode)) {
					templateMngService.auditCommitOrSendBack(
							WorkFlowCode.getById(workflowCode), 
							workflowId, 
							wfTaskId, 
							curUser.getLoginName(), 
							WorkFlowNode.getNodeById(nodeId), 
							ActionCode.getActionCodeById(actionCode), 
							comments, 
							curUser.getOrgCode().toString(),
							receivers,
							nodeId);
					msg = dataEntryService.updateTemplateSubmitModel(workflowId, nodeId, curUser);
					
				} else if (ActionCode.SEND_BACK.getCodeId().equals(actionCode)) {
					templateMngService.auditCommitOrSendBack(
							WorkFlowCode.getById(workflowCode), 
							workflowId, 
							wfTaskId, 
							curUser.getLoginName(), 
							WorkFlowNode.getNodeById(nodeId), 
							ActionCode.getActionCodeById(actionCode), 
							comments, 
							curUser.getOrgCode().toString(),
							receivers,
							nodeId);
					msg = dataEntryService.updateTemplateSubmitModelOfSendback(workflowId, nodeId, curUser);
					
				} else if (ActionCode.FINISH.getCodeId().equals(actionCode)) {
					templateMngService.auditFinish(
							WorkFlowCode.getById(workflowCode), 
							workflowId, 
							wfTaskId, 
							curUser.getLoginName(), 
							WorkFlowNode.getNodeById(nodeId), 
							ActionCode.getActionCodeById(actionCode), 
							comments, 
							curUser.getOrgCode().toString());
					msg="";
				} else {
					return failure("流程审核失败，请稍后重试", null);
				}
				if (!"".equals(msg)) return failure(msg, null);
			} else {
				return failure("您无法审批该类型的流程，请询问管理员", null);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return failure(!"".equals(msg) ? msg : "发生异常，请联系管理员解决",null);
		}
		return success();
	}
	/**
	 * 退回重发
	 * @param actionCode
	 * @param workflowId
	 * @param wfTaskId
	 * @param comments
	 * @param nodeId
	 * @param workflowCode
	 * @param orgId
	 * @param templateId
	 * @param submitTime
	 * @return
	 */
	@RequestMapping(value = "/resend", method = RequestMethod.POST)
	@ResponseBody
	public Result resend(String actionCode, String workflowId, String wfTaskId,
			String comments, String nodeId, String workflowCode, String orgId,String templateId,String submitTime) {
		SessionUser curUser = (SessionUser) SecurityUtils.getSubject().getPrincipal();
		try {
			
			String taskSubject = "退回重发："+templateId;
//			String taskReceiver = dateSummarizeService.findUserByRole(orgId);
			/**
			 * 退回到报表创建人
			 */
			TblTemplateSubmit tblTemplateSubmit = dataEntryService.getTemplateSubmitByOrgIdAndWorkflowId(orgId, workflowId);
			String taskReceiver = tblTemplateSubmit.getSubPeople();
			
			TypedResult<WorkFlowTaskIds> result =workFlowService.executeTask(WorkFlowCode.getById(workflowCode),
					workflowId, wfTaskId, curUser.getLoginName(),
					WorkFlowNode.getNodeById(nodeId),
					ActionCode.getActionCodeById(actionCode), taskReceiver,
					comments, taskSubject, orgId);
			//记录退回意见
			ResendComments resendComments = new ResendComments();
			resendComments.setWorkflowId(workflowId);
			resendComments.setTaskId(result.getData().getTaskId());
			resendComments.setComments(comments);
			resendComments.setResendPeople(curUser.getUserName());
			resendComments.setOrgId(orgId);
			resendComments.setResendTime(new Date());
			resendComments.setSubmitTime(submitTime);
			resendCommentsDao.save(resendComments);
			dateSummarizeService.updateByOrgId(orgId, workflowId);// 閫�洖
		} catch (Exception e) {
			return failure("数据异常，请联系管理员解决", null);
		}
		return success();
	}
	
	/** ----------------------------------鍒嗗壊绾�------------------------------------------------- */
	
	@RequestMapping(value = "/ajaxLogin", method = RequestMethod.POST)
	@ResponseBody
	public Result ajaxLogin(Model model, String logname) {
		SessionUser sUser = getSessionUser();
		logger.info(sUser.toString());
		if (sUser == null || !logname.equals(sUser.getLoginName())) {
			return failure();
		}
		return success();
	}
	
	/** ----------------------------------鍒嗗壊绾�------------------------------------------------- */
	/**
	 * 涓嬭浇
	 * @param fileName
	 * @param req
	 * @param resp
	 * @throws UnsupportedEncodingException 
	 */
	@RequestMapping(value = "/download")
	@ResponseBody
	public String download(String fileName,HttpServletRequest req,HttpServletResponse resp){
		String filePath = PropertiesConstants.getString(PropertiesConstants.USER_HOME)
				+ PropertiesConstants.getString(PropertiesConstants.DATA_SUBMIT)
				+ File.separator + fileName;
		try {
			File file=new File(filePath);
			if(FileUtils.isExists(file)){
				FileUtils.downloadFile(new File(filePath), fileName, req, resp);
			}else{
				return "文件不存在";
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "";
	}
	
	/**
	 * 文件下载
	 * @param req
	 * @param resp
	 * @return
	 * @throws Exception
	 * @modified by Wangxy 20150831
	 */
	@RequestMapping(value = "/fileIsExists")
	@ResponseBody
	public String fileIsExists(HttpServletRequest req,HttpServletResponse resp) throws Exception {
		//req.setCharacterEncoding("utf-8");
		String s = req.getParameter("fileName");
		String fileName = java.net.URLDecoder.decode(s,"utf8");
		String filePath = PropertiesConstants.getString(PropertiesConstants.USER_HOME)
				+ PropertiesConstants.getString(PropertiesConstants.DATA_SUBMIT)
				+ File.separator + fileName;
		File file=new File(filePath);
		System.out.println(file);
		if(FileUtils.isExists(file)){
			return "";
		}else{
			return "文件不存在";
		}
	}
	
	@RequestMapping("/get/{workflowId}")
	@ResponseBody
	public TblReportTemplate get(@PathVariable String workflowId) {
		return templateMngService.getTemplateByWorkflowId(workflowId) ;
	}
}
