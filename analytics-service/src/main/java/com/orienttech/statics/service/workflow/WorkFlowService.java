package com.orienttech.statics.service.workflow;


import java.util.List;

import com.orienttech.statics.service.model.workflow.CurrentTask;
import com.orienttech.statics.service.model.workflow.DoneTask;
import com.orienttech.statics.service.model.workflow.HandledWorkflows;
import com.orienttech.statics.service.model.workflow.NextTaskReceiver;
import com.orienttech.statics.service.model.workflow.PageTypedResultData;
import com.orienttech.statics.service.model.workflow.TaskAction;
import com.orienttech.statics.service.model.workflow.TaskTransferProcess;
import com.orienttech.statics.service.model.workflow.TodoTask;
import com.orienttech.statics.service.model.workflow.TypedResult;
import com.orienttech.statics.service.model.workflow.WorkFlowId;
import com.orienttech.statics.service.model.workflow.WorkFlowTaskIds;



public interface WorkFlowService {
	
	
	/**系统编号**/
	public static enum SysCode{
		/**统计系统code**/
		TJ_SYS("统计系统code","4");
		
		private final String codeName;
		private final String codeId;
		
		private SysCode(String codeName,String codeId){
			this.codeId = codeId;
			this.codeName = codeName;
		}
		public String getCodeName() {
			return codeName;
		}
		public String getCodeId() {
			return codeId;
		}
		
		public static SysCode getById(String codeId){
			for (SysCode sysCode : SysCode.values()) {
				if(sysCode.getCodeId().equals(codeId)){
					return sysCode;
				}
			}
			throw new IllegalArgumentException("没有id为" + codeId + "的系统");
		}
	}
	
	/****
	 * 流程类型
	 * @author xc
	 */
	public static enum WorkFlowCode{
		
		TemplateWorkflow("模板发布流程","1005"),
		ReportWorkflow("报表上报流程","1006");
		
		private final String codeName;
		private final String codeId;
		
		private WorkFlowCode(String codeName,String codeId){
			this.codeId = codeId;
			this.codeName = codeName;
		}
		public String getCodeName() {
			return codeName;
		}
		public String getCodeId() {
			return codeId;
		}
		
		public static WorkFlowCode getById(String codeId){
			for (WorkFlowCode wfCode : WorkFlowCode.values()) {
				if(wfCode.getCodeId().equals(codeId)){
					return wfCode;
				}
			}
			throw new IllegalArgumentException("没有id为" + codeId + "的流程");
		}
	}
	
	
	/****
	 * 操作按钮
	 * @author xc
	 */
	public static enum ActionCode{
		/**提交审核:当前节点执行完后提交到下一节点。**/
		COMMIT("提交审核","1"),
		/**退回:可退回到某个节点继续流转，<br>
		 * 具体退回到哪个节点不是由执行人指定，<br>
		 * 而是由流程设计时指定<br>
		 * （一般可指定退回到流程发起节点或前面的审批节点，默认是退回到上一节点）**/
		SEND_BACK("退回","2"),
		/**撤销:如果在某个节点设置有“撤消”的权限，说明当前执行人有权在此时撤消此流程。**/
		CANCEL("撤销","3"),
		/**撤回:当前节点执行完后、下一节点执行前，可以收回进行修改然后再提交。**/
		RECALL("撤回","4"),
		/**转交 :转交人与接收人有完全相同的权限，转交后任务在原节点且任务状态为待处理。**/
		TRANSFER("转交","5"),
		/**挂起:相当于该流程处于挂起状态，当前节点及之后的其它节点不再执行。<br>
		 * “挂起”一般是由管理员或项目负责人操作的，执行“恢复”操作后能继续该流程。**/
		HANG_UP("挂起","6"),
		/**恢复:将处于挂起状态的流程重新恢复执行，并继续流程流转。**/
		CONTINUE("恢复","7"),
		/**完成:流程流转到最后一个节点，且最后一个节点任务处理完成时执行该操作。**/
		FINISH("完成","8"),
		/**提交签订合同 **/
		SUBMIT_CONTACT("提交签订合同","11");
		
		private final String codeName;
		private final String codeId;
		
		private ActionCode(String codeName,String codeId){
			this.codeId = codeId;
			this.codeName = codeName;
		}

		public String getCodeName() {
			return codeName;
		}

		public String getCodeId() {
			return codeId;
		}
		
		public static ActionCode getActionCodeById(String id){
			for (ActionCode actCode : ActionCode.values()) {
				if(actCode.getCodeId().equals(id)){
					return actCode;
				}
			}
			throw new IllegalArgumentException("没有id为" + id + "的操作");
		}
	}
	
	/***
	 * 流程节点
	 * @author xc
	 */
	public static enum WorkFlowNode{
		/**模板:新建模板 100510**/
		TJ_TemplateBuild("新建模板","100510"),
		/**模板:部门审核 100511**/
		TJ_OrgCheck("部门审核","100511"),
		/**模板:统计组审核100512**/
		TJ_TjOrgCheck("统计组审核","100512"),
		/**模板:负责人审核 100513**/
		TJ_ManagerCheck("负责人审核","100513"),
		/**模板:模板发布 100514**/
		TJ_TemplatePublish ("模板发布","100514"),
		
		/**模板:报表收集 100610**/
		TJ_ReportCollect("报表收集","100610"),
		/**模板:报表填写 100611**/
		TJ_ReportWrite("报表填写","100611"),
		/**模板:报表审核 100612**/
		TJ_ReportCheck("报表审核","100612");
		
		
		private final String name;
		private final String id;
		
		private WorkFlowNode(String name,String id){
			this.name = name;
			this.id = id;
		}
		
		public String getName() {
			return name;
		}
		public String getId() {
			return id;
		}
		
		public static WorkFlowNode getNodeById(String nodeId){
			for (WorkFlowNode node : values()) {
				if(node.getId().equals(nodeId)){
					return node;
				}
			}
			throw new IllegalArgumentException("没有id为" + nodeId + "的流程");
		}
	}
	
	
	/**角色编号**/
	public static enum RoleCode{
		
		
		/*TJ_BusinessDepartmentEmployees("业务部门统计人员","391"),
		TJ_BusinessDepartmentManager("业务部门负责人","392"),
		TJ_ElectronicBankingDepartmentGroup("电子金融部统计组","393"),
		TJ_ElectronicBankingDepartment("电子金融部审批","394"),
		TJ_ReportOrgEmployees("报送机构统计人员","395"),
		TJ_ReportDepartmentManager("报送部门负责人","396");*/
		
		/**模板:新建模板 100510**/
		TJ_TemplateBuild("391","100510"),
		/**模板:部门审核 100511**/
		TJ_OrgCheck("392","100511"),
		/**模板:统计组审核100512**/
		TJ_TjOrgCheck("393","100512"),
		/**模板:负责人审核 100513**/
		TJ_ManagerCheck("394","100513"),
		/**模板:模板发布 100514**/
		TJ_TemplatePublish ("393","100514"),
		
		/**模板:报表收集 100610**/
		TJ_ReportCollect("393","100610"),
		/**模板:报表填写 100611**/
		TJ_ReportWrite("395","100611"),
		/**模板:报表审核 100612**/
		TJ_ReportCheck("396","100612");
		
		private final String id;
		private final String roleId;
		
		private RoleCode(String id,String roleId){
			this.roleId = roleId;
			this.id = id;
		}
		public String getRodeId() {
			return roleId;
		}
		public String getId() {
			return id;
		}
		
		public static RoleCode getById(String rodeId){
			for (RoleCode roleCode : RoleCode.values()) {
				if(roleCode.getRodeId().equals(rodeId)){
					return roleCode;
				}
			}
			throw new IllegalArgumentException("没有id为" + rodeId + "的角色");
		}
	}
	
	
	/**
	 * <b>启动流程</b><BR>
	 * 1. 发起流程的先决条件，必须先调用此接口，创建任务流程才能继续以下操作。<BR>
	 * 2. taskSubject是当前任务的主题（每个任务都可以有自己的主题）<BR>
	 * 3. 返回流程编号和当前环节对应的任务节点的编号<BR>
	 * @param sysCode 所属系统编号
	 * @param workflowCode 流程编号
	 * @param nodeId 启动环节的环节ID
	 * @param userId 用户ID
	 * @param taskSubject 任务主题
	 * @return
	 * @author xc
	 */
	TypedResult<WorkFlowTaskIds> startWorkflow(SysCode sysCode,
						WorkFlowCode workflowCode,
						WorkFlowNode node,
						String logName,
						String taskSubject,
						String orgId
						);
	
	/**
	 * <b>开始处理任务</b><br>
	 * 1. 根据待办任务状态进行调用<br>
	 * 2. 如果当待办任务状态为未处理时，则必须调用此方法，设置任务状态为处理中<br>
	 * 3. 如果当待办任务状态为处理中时，无需再次调用<br>
	 * @param workflowId 流程ID
	 * @param taskId 任务ID
	 * @param logName 登录账号
	 * @return
	 * @author xc
	 */
	TypedResult<WorkFlowId> startProcessingTask(String workflowId,
								String taskId,
								String logName);
	/**
	 * 获取本环节的操作功能信息
	 * @param nodeId
	 * @return
	 * @author xc
	 */
	TypedResult<List<TaskAction>> getTaskActions(WorkFlowNode node);
	
	/**
	 * 获取当前环节发送给下一环节的人员列表及用户待处理的代办数量
	 * @param workflowId 流程ID 
	 * @param taskId 任务ID 
	 * @param logName 登录账号
	 * @param nodeId 环节ID
	 * @param actionNameEn
	 * @param actionCode
	 * @return
	 * @author xc
	 */
	TypedResult<List<NextTaskReceiver>> getNextTaskReceivers(String taskId,ActionCode actionCode);
	/**
	 * <b>执行任务:</b><br>
	 * 1. 根据操作按钮执行当前任务，并将当前任务的状态设置为已完成<br>
	 * 2. 设置并创建下一任务，设置下一任务的状态为待处理，并将下一任务分配给任务接收人<br>
	 * 3. taskSubject是当前用户给下一任务接收人设置的任务主题<br>
	 * 4.分为4种调用情况：<br>
	 * &nbsp;正常发送（本环节发送给下一环节）、退回、撤销、最后一环节发送。<br>
	 * &nbsp;其中除了正常发送情况需要传任务接收人Id，其他情况都可不传；<br>
	 * &nbsp;最后一环节的发送可不传任务主题。<br>
	 * @param workflowCode
	 * @param workflowId
	 * @param logName
	 * @param nodeId
	 * @param taskId
	 * @param actionCode
	 * @param taskReceiver
	 * @param comments
	 * @param taskSubject
	 * @return
	 * @author xc
	 */
	TypedResult<WorkFlowTaskIds> executeTask(WorkFlowCode workflowCode,
						String workflowId,
						String taskId,
						String logName,
						WorkFlowNode node,
						ActionCode actionCode,
						String taskReceiver,
						String comments,
						String taskSubject,
						String orgId);
	/**
	 * <b>转交任务:</b><br>
	 * @param workflowId
	 * @param taskId
	 * @param transferor
	 * @param transferee
	 * @param reason
	 * @return
	 * @author xc
	 */
	TypedResult<WorkFlowId> transferTask(String workflowId,
						String taskId,
						String transferor,
						String transferee,
						String reason);
	/**
	 * 获取流程中任务的流转过程
	 * @param workflowId
	 * @param sortFlag
	 * @return
	 * @author xc
	 */
	TypedResult<List<TaskTransferProcess>> getTaskTransferProcessOfWorkflow(String workflowId,String sortFlag);
	
	/**
	 * 获取用户经办的所有流程列表
	 * @param deptCode
	 * @param logName
	 * @param sysCode
	 * @param sortFlag
	 * @param workflowCodes
	 * @param taskStatus
	 * @param taskCreateDateStart
	 * @param taskCreateDateEnd
	 * @param pageNumber
	 * @param pageSize
	 * @return
	 * @author xc
	 */
	TypedResult<PageTypedResultData<HandledWorkflows>> getHandledWorkflowsByUser(
														String deptCode,
														String logName,
														SysCode sysCode,
														String sortFlag,
														List<WorkFlowCode> workflowCodes,
														String taskStatus,
														String taskSubject,
														String taskCreateDateStart,
														String taskCreateDateEnd,
														Integer pageNumber, 
														Integer pageSize);
	
	/**
	 * 获取待办列表
	 * @param logName
	 * @param workflowCodes
	 * @param sysCode
	 * @param taskCreatorName
	 * @param taskSubject
	 * @param taskCreateDateStart
	 * @param taskCreateDateEnd
	 * @param pageNumber
	 * @param pageSize
	 * @return
	 * @author xc
	 */
	TypedResult<PageTypedResultData<TodoTask>> queryToDoListByCondition (
														String logName, 
														List<WorkFlowCode> workflowCodes,
														SysCode sysCode, 
														List<String> nodeIds,
														String taskCreatorName,
														String taskSubject,
														String taskCreateDateStart,
														String taskCreateDateEnd, 
														Integer pageNumber, 
														Integer pageSize);
	
	
	/***
	 * 获取已办列表
	 * @param logName
	 * @param workflowCodes
	 * @param sysCode
	 * @param taskCreatorName
	 * @param taskSubject
	 * @param taskConfirmDateStart
	 * @param taskConfirmDateEnd
	 * @param taskAssignDateStart
	 * @param taskAssignDateEnd
	 * @param pageNumber
	 * @param pageSize
	 * @return
	 * @author xc
	 */
	TypedResult<PageTypedResultData<DoneTask>> queryDoneListByCondition(
														String logName, 
														List<WorkFlowCode> workflowCodes,
														SysCode sysCode, 
														String taskCreatorName,
														String taskSubject,
														String taskConfirmDateStart,
														String taskConfirmDateEnd, 
														String taskAssignDateStart,
														String taskAssignDateEnd, 
														Integer pageNumber, 
														Integer pageSize);

	TypedResult<PageTypedResultData<DoneTask>> queryPortalDoneListByCondition(
			String curUser,
			String sysCode,
			String workflowCode,
			String taskCreatorName,
			String taskSubject,
			String taskConfirmDateStart,
			String taskConfirmDateEnd,
			String taskAssignDateStart,
			String taskAssignDateEnd,
			Integer pageNumber,
			Integer pageSize);
	
	/**
	 * 获取待办列表(新)
	 * @param curUser 门户用户登录账号
	 * @param workflowCode 流程类型编号
	 * @param taskCreatorName 分配人名称
	 * @param taskSubject 任务主题
	 * @param taskCreateDateStart 分配开始日期
	 * @param taskCreateDateEnd 分配结束日期
	 * @param pageNumber 页号
	 * @param pageSize 页面显示查询结果条数
	 * @author Wangxy
	 */
	TypedResult<PageTypedResultData<TodoTask>> queryPortalToDoListByCondition(
									String curUser,
									String sysCode,
									String workflowCode,
									String taskCreatorName,
									String taskSubject,
									String taskCreateDateStart,
									String taskCreateDateEnd,
									Integer pageNumber,
									Integer pageSize);
	/**
	 * TODO
	 * 获取当前流程所处环节信息
	 * @param workflowId
	 * @param orgId
	 * @return
	 */
	TypedResult<CurrentTask> getCurrentTaskAssigneeByWorkflowIdAndOrgId(
			String workflowId,
			String orgId);

}
