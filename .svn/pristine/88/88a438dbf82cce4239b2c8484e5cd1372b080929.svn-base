package com.orienttech.statics.service.dateSummarize;

import java.io.FileNotFoundException;
import java.io.IOException;

import com.orienttech.statics.commons.datatables.DataTablesPage;
import com.orienttech.statics.dao.entity.submission.TblTemplateSum;

public interface DateSummarizeService {
	
	
	DataTablesPage findAll(String workflowId,Integer draw,String search,Integer pageNumber,
			Integer pageSize);
	/**
	 * 根据流程ID查询
	 * @param workflowId
	 * @return
	 */
	String ifShowSelectAll(String workflowId);
	
	void save(TblTemplateSum tblTemplateSum);

	String findUserByRole(String orgId);
	
	void updateByOrgId(String orgId,String workflowId);
	
	void updateStatusByWorkflowId(String workflowId);
	
	String findStatusByTemplateId(String templateId);
	/**
	 * 报表汇总
	 * @param checkedId
	 * @param workflowId
	 * @param templateId
	 * @return
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	String reportSummarize(String checkedId, String workflowId,String templateId)
			throws FileNotFoundException, IOException;
	
	String findSubmitTimeByTemplateId(String templateId,Long timeLimit,String workflowId);

}
