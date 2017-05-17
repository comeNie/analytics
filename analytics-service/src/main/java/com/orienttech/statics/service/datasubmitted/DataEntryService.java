/**
 * 数据报送录入Service
 * @author gph
 */
package com.orienttech.statics.service.datasubmitted;

import com.orienttech.statics.commons.security.SessionUser;
import com.orienttech.statics.dao.entity.submission.TblReportTemplate;
import com.orienttech.statics.dao.entity.submission.TblTemplateSubmit;

public interface DataEntryService {
	/**
	 * 保存
	 * 
	 * @param templateSubmit
	 *            数据报表对象
	 */
	void save(TblTemplateSubmit templateSubmit);
	
	/**
	 * 修改数据报表状态
	 * @param orgId
	 * @param workflowId
	 */
	void modifyStatus(SessionUser curUser,String workflowId);
	
	/**
	 * 修改对象
	 * @param templateSubmit
	 */
	void update(TblTemplateSubmit templateSubmit);

	/**
	 * 通过机构Id和流程Id查找数据报表对象
	 * @param orgId 机构Id
	 * @return 数据报表对象
	 */
	TblTemplateSubmit getTemplateSubmitByOrgIdAndWorkflowId(String orgId,String workflowId);
	/**
	 * 通过模版Id查找数据报表
	 * @param templateId
	 * @return
	 */
	TblTemplateSubmit getTemplateSubmit(int templateId);
	
	/**
	 * 通过流程Id查找实例对象
	 * @param workflowId
	 * @param orgId
	 * @return
	 */
	TblReportTemplate getReportTemplate(String workflowId);

	String updateTemplateSubmitModel(String workflowId, String nodeId, SessionUser curUser);

	String updateTemplateSubmitModelOfSendback(String workflowId,
			String nodeId, SessionUser curUser);
}
