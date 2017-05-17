/**
 * 父类定时器，所有报表周期定时器都继承它
 * @author gph
 */
package com.orienttech.statics.service.timedtask;

import java.util.List;

import net.sf.json.JSONObject;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.orienttech.statics.commons.utils.CommonHelper;
import com.orienttech.statics.commons.utils.Contants;
import com.orienttech.statics.commons.webservice.WebServices;
import com.orienttech.statics.dao.entity.submission.TblReportTemplate;
import com.orienttech.statics.dao.entity.submission.TblTemplateSubmit;
import com.orienttech.statics.dao.entity.submission.TblTemplateSum;
import com.orienttech.statics.service.datasubmitted.DataEntryService;
import com.orienttech.statics.service.dateSummarize.DateSummarizeService;
import com.orienttech.statics.service.templateMng.TemplateMngService;
import com.orienttech.statics.service.workflow.WorkFlowService.RoleCode;

@Component
public class Task {
	private static final Logger logger = LoggerFactory.getLogger(Task.class);

	public static final String SERVICENAME = "workflowService";// webService名称
	public static final String METHODNAME = "startWithWorkflowType";// 方法名
	public static final String SYSCODE = "4";// 所属系统编号
	public static final String WORKFLOWCODE = "1006";// 流程类型编号
	public static final String NODEID = "100610";// 启动环节的环节ID
	public static final String LOGNAME = "admin/admin,9080075,9080061&90100077,9050007";// 登录帐号
	public static final String ORGID = "";// 用户有权限机构ID

	@Autowired
	private WebServices client;
	@Autowired
	private TemplateMngService templateMngService;// 模版
	@Autowired
	private DataEntryService dataEntryService;// 数据录入
	@Autowired
	private DateSummarizeService dateSummarizeService;

	public void doBiz() {}

	public void doBiz(int cycle) {
		logger.info("开始启动流程...");
		try {
			// 查询所有已发布的模版
			List<TblReportTemplate> list = this
					.findTemplateByStatusAndCycle(cycle);
			if (list.size() > 0) {
				// 遍历判断报送周期定时发送待办任务
				for (int i = 0; i < list.size(); i++) {
					String reportWrite = templateMngService.getTaskSender(
							String.valueOf(list.get(i).getId()),
							RoleCode.TJ_ReportWrite.getId());// 数据填写人

					String reportCollect = templateMngService
							.getTaskReceiver(RoleCode.TJ_ReportCollect.getId());// 数据收集

					logger.info("接收人/部门填报人员："
							+ (reportCollect.concat("/").concat(reportWrite)));
					// 填报人和汇总人不为空
					if (StringUtils.isNotEmpty(reportWrite)
							&& StringUtils.isNotEmpty(reportCollect)) {
						// 任务主题
						String taskSubject = "模版编号："+list.get(i).getNo().toString();
						int count = 1;
						boolean flag = true;
						do {
							// 启动流程并处理返回结果
							count += 1;
							String json = startWithWorkflowType(
									taskSubject,
									reportCollect.concat("/").concat(
											reportWrite));
							JSONObject object = JSONObject.fromObject(json);
							if (object.getBoolean("success")) {
								flag = true;
								logger.info("流程启动成功,正在保存数据....");
								save(json, list.get(i));
							} else {
								flag = false;
								logger.info("待办流程正在尝试第" + (count - 1) + "重发...");
								Thread.sleep(10L * 1000L);
							}

						} while (!flag && count <= 5);
					}
				}
			}
		} catch (Exception e) {
			logger.error("启动流程时发生异常，方法名doBiz，错误原因：" + e.getMessage());
		}
	}

	/**
	 * 保存模版信息到数据报送表和汇总表
	 * 
	 * @param strJson
	 *            json字符串
	 * @param template
	 *            数据模版对象
	 */
	public void save(String strJson, TblReportTemplate template) {
		JSONObject object = JSONObject.fromObject(strJson);
		try {
			// 实例化保存数据报送对象
			String[] arrays = template.getSubmitOrg().split(",");
			if (arrays.length > 0) {
				for (int i = 0; i < arrays.length; i++) {
					TblTemplateSubmit templateSubmit = new TblTemplateSubmit();
					templateSubmit.setTemplateId(template.getId());// 模版Id
					templateSubmit.setWorkflowId((((JSONObject) object.get("data")).get("workflowId")).toString());// 流程Id
					templateSubmit.setStartTime(CommonHelper.str2Date(ReportCycleUtils.getReportTime(template.getCycle(),0), CommonHelper.DF_DATE));// 开始时间
					templateSubmit.setEndTime(CommonHelper.str2Date(ReportCycleUtils.getReportTime(template.getCycle(),1), CommonHelper.DF_DATE));// 结束时间
					templateSubmit.setOrgId(arrays[i]);// 填报机构
					templateSubmit.setCycle(template.getCycle());// 报表周期
					templateSubmit.setSubmitState(Contants.UNREPORT);// 上报状态
					dataEntryService.save(templateSubmit);
				}
			}
			// 实例化保存数据汇总对象
			TblTemplateSum templateSum = new TblTemplateSum();
			templateSum.setTemplateId(template.getId());
			templateSum.setSumState(Contants.STATE_UNSUM);
			templateSum.setTemplateStartTime(CommonHelper.str2Date(ReportCycleUtils.getReportTime(template.getCycle(), 0),CommonHelper.DF_DATE));// 报送开始时间
			templateSum.setTemplateEndTime(CommonHelper.str2Date(ReportCycleUtils.getReportTime(template.getCycle(), 1),CommonHelper.DF_DATE));// 报送结束时间
			templateSum.setWorkflowId((((JSONObject) object.get("data")).get("workflowId")).toString());// 流程Id
			// 保存数据到数据报表和汇总表
			dateSummarizeService.save(templateSum);
		} catch (Exception e) {
			logger.error("保存数据时发生异常，异常原因：" + e.getMessage());
		}
	}

	/**
	 * 调用WebService启动流程接口
	 * 
	 * @param recever
	 * @param sender
	 * 
	 * @return Json字符串
	 */
	public String startWithWorkflowType(String subject, String logname) {
		try {
			return client.invoke(SERVICENAME, METHODNAME, SYSCODE,
					WORKFLOWCODE, NODEID, logname, subject, ORGID);
		} catch (Exception e) {
			logger.error("启动流程时发生异常，方法名startWithWorkflowType，异常原因："
					+ e.getMessage());
			return "";
		}
	}

	/**
	 * 查找状态是已发布的报表模版
	 * 
	 * @param cycle
	 *            报表周期
	 * @return 报表模版列表
	 */
	protected List<TblReportTemplate> findTemplateByStatusAndCycle(int cycle) {
		return templateMngService.getTemplateByStatusAndCycle(
				Contants.STATE_RELEASE, cycle);
	}
}
