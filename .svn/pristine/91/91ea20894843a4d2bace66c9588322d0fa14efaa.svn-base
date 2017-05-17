package com.orienttech.statics.web.controller.todoList;


import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.orienttech.statics.commons.base.BaseController;
import com.orienttech.statics.commons.base.Result;
import com.orienttech.statics.commons.datatables.DataTablesPage;
import com.orienttech.statics.commons.security.SessionUser;
import com.orienttech.statics.service.dateSummarize.DateSummarizeService;
import com.orienttech.statics.service.model.workflow.CurrentTask;
import com.orienttech.statics.service.model.workflow.DoneTask;
import com.orienttech.statics.service.model.workflow.PageTypedResultData;
import com.orienttech.statics.service.model.workflow.TodoTask;
import com.orienttech.statics.service.model.workflow.TypedResult;
import com.orienttech.statics.service.model.workflow.WorkFlowTaskIds;
import com.orienttech.statics.service.workflow.WorkFlowService;
import com.orienttech.statics.service.workflow.WorkFlowService.ActionCode;
import com.orienttech.statics.service.workflow.WorkFlowService.WorkFlowCode;
import com.orienttech.statics.service.workflow.WorkFlowService.WorkFlowNode;

@Controller
@RequestMapping("/" + "todoList")
public class TodoListController extends BaseController{
	
	private Log log=LogFactory.getLog(TodoListController.class);
	
	@Autowired private WorkFlowService workFlowService;
	@Autowired private DateSummarizeService dateSummarizeService;
	
	/*
	 * 待办总数
	 */
	@RequestMapping("/findTodoListToltalNum")
	@ResponseBody
	public String findTodoListToltalNum(){
		
		SessionUser shiroUser = (SessionUser) SecurityUtils.getSubject()
				.getPrincipal();
		String curUser = "";
		if (shiroUser != null) {
			curUser = shiroUser.getLoginName();
			if (StringUtils.isNotEmpty(shiroUser.getLoginName())) {
				curUser += "," + shiroUser.getLoginName();
			}
		}
		TypedResult<PageTypedResultData<TodoTask>> todoTask = workFlowService
				.queryPortalToDoListByCondition(curUser,"4", "", "", "", "", "",
						0 / 10 + 1, 10);
		//System.out.println("--------------findTodoListToltalNum---------------:"+todoTask.getData().getTotalElements()+"##");
		return todoTask.getData().getTotalElements()+"";
	}
	/**
	 * TODO 撤销退回的待办任务
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
	@RequestMapping(value = "/deleteTodo")
	@ResponseBody
	public Result deleteTodo(String workflowCode, String workflowId, String taskId,
			String nodeId, String taskSubject, String orgId) {
		
		SessionUser curUser = (SessionUser) SecurityUtils.getSubject().getPrincipal();
		String logName = curUser.getLoginName();
		
		workFlowService.executeTask(WorkFlowCode.getById(workflowCode), workflowId, 
				taskId, logName, WorkFlowNode.getNodeById(nodeId), ActionCode.CANCEL, "", "", taskSubject, "");
		
		return success();
	}
	
	
	/**
	 * 查询待办列表(新)
	 * @author Wangxy
	 */
	@RequestMapping("/findTodoListByCondition")
	@ResponseBody
	public DataTablesPage findTodoListByCondition(
			String taskSubject,
			String taskCreateDateStart,
			String taskCreateDateEnd,
			String taskCreatorName,
			String workflowCode,
			@RequestParam("search[value]") String search, 
			@RequestParam("draw") Integer draw,
			@RequestParam("start") Integer firstIndex,
			@RequestParam("length") Integer pageSize){
		
		DataTablesPage dt = new DataTablesPage();
		try {
			SessionUser shiroUser = (SessionUser)SecurityUtils.getSubject().getPrincipal();
			String curUser = "";
			if(shiroUser != null){
				curUser = shiroUser.getLoginName();
				if (StringUtils.isNotEmpty(shiroUser.getLoginName())) {
					curUser += "," + shiroUser.getLoginName();
				}
			}
			TypedResult<PageTypedResultData<TodoTask>> todoTask =  workFlowService.queryPortalToDoListByCondition(curUser,"4",workflowCode, taskCreatorName, taskSubject, taskCreateDateStart, taskCreateDateEnd, firstIndex / pageSize + 1, pageSize);
			if(todoTask.getSuccess()){
				dt.setData(todoTask.getData().getContent());
				dt.setRecordsTotal(todoTask.getData().getTotalElements());
				dt.setRecordsFiltered(todoTask.getData().getTotalElements());
				dt.setDraw(draw);
			}else{
				log.error("查询待办列表出错>>>>" + todoTask.getMsg());
			}
				
		}catch(Exception e){
			log.error("查询待办列表出错>>>>" + e.getStackTrace());
		}
		return dt;
	}
	
	/**
	 * 查询已办列表(新)
	 * @author Wangxy
	 */
	@RequestMapping("/findDoneListByCondition")
	@ResponseBody
	public DataTablesPage findDoneListByCondition(
			String taskSubject,
			String taskAssignDateStart,
			String taskAssignDateEnd,
			String taskCreatorName,
			String workflowCode,
			String taskConfirmDateStart,
			String taskConfirmDateEnd,
			@RequestParam(value = "search[value]", required = false) String search,
			@RequestParam("draw") Integer draw,
			@RequestParam("start") Integer firstIndex,
			@RequestParam("length") Integer pageSize) {
		
		DataTablesPage dt = new DataTablesPage();
		try {
			SessionUser shiroUser = (SessionUser)SecurityUtils.getSubject().getPrincipal();
			String curUser = "";
			if(shiroUser != null){
				curUser = shiroUser.getLoginName();
				if (StringUtils.isNotEmpty(shiroUser.getLoginName())) {
					curUser += "," + shiroUser.getLoginName();
				}
			}
			TypedResult<PageTypedResultData<DoneTask>> doneTask =  workFlowService.queryPortalDoneListByCondition(curUser, "4", workflowCode, taskCreatorName, taskSubject, taskConfirmDateStart, taskConfirmDateEnd, taskAssignDateStart, taskAssignDateEnd, firstIndex / pageSize + 1, pageSize);
			if(doneTask.getSuccess()){
				dt.setData(doneTask.getData().getContent());
				dt.setRecordsTotal(doneTask.getData().getTotalElements());
				dt.setRecordsFiltered(doneTask.getData().getTotalElements());
				dt.setDraw(draw);
			}else{
				log.error("查询已办列表出错>>>>" + doneTask.getMsg());
			}
				
		}catch(Exception e) {
			log.error("查询已办列表出错>>>>" + e.getStackTrace());
		}
		return dt;
	}
	/**
	 * 
	 * @param orgId
	 * @param workflowId
	 * @return
	 */
	@RequestMapping(value="/findCurrentTaskAssignee")
	@ResponseBody
	public Result findCurrentTaskAssignee(String orgId, String workflowId){
		
		TypedResult<CurrentTask> currentTask = workFlowService.getCurrentTaskAssigneeByWorkflowIdAndOrgId(workflowId, orgId);
//		String task = "";
//		if(currentTask.getSuccess()){
//			task = currentTask.getData().getCurrentAssigneerName();
//		}
//		System.out.println(task);
		return success(currentTask);
	}
}
