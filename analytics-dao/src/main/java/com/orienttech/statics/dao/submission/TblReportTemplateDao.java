/**
 * 报表模版Dao
 * @author dz
 */
package com.orienttech.statics.dao.submission;

import java.util.List;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.orienttech.statics.dao.entity.submission.TblReportTemplate;
import com.orienttech.statics.dao.entity.submission.TblTemplateSubmit;

public interface TblReportTemplateDao extends
		PagingAndSortingRepository<TblReportTemplate, Integer>,
		JpaSpecificationExecutor<TblReportTemplate> {

	@Query("select max(r.id) from TblReportTemplate r")
	public Integer getMaxId();
	
	@Query("select count(*) from TblReportTemplate r where r.name =?1")
	public int  getCountByName(String name);
	
	@Query("select count(*) from TblReportTemplate r where r.no =?1")
	public int  getCountByNo(String name);
	
	/**
	 * 通过数据报表中的流程Id查找报表模版
	 * @param workflowId 注意：这是数据报表中的流程Id
	 * @return 报表模版对象
	 */
	@Query("from TblReportTemplate r where r.id =(select distinct ts.templateId from TblTemplateSubmit ts where ts.workflowId=?1)")
	public TblReportTemplate findReportTemplateByWorkflowId(String workflowId);
	
	/**
	 * 通过报表模板中的流程Id查找报表模版
	 * @param workflowId 注意：这是数据报表中的流程Id
	 * @return 报表模版对象
	 */
	@Query("from TblReportTemplate r where r.workflowId=?1")
	public TblReportTemplate findReportTemplateByWorkflow(String workflowId);
	
	@Query("from TblReportTemplate r where r.state=?1 and r.cycle=?2")
	public List<TblReportTemplate> findTemplateByStatusAndCycle(String templateStatus,String cycle);
	
	@Query("select t from TblReportTemplate t where t.id=?1")
	public TblReportTemplate findReportTemplateById(int id);
	
	@Query("select distinct s.name from StaDimOrg s where s.orgId=?1")
	public String findOrgNameById(String orgId);

	@Query("from TblTemplateSubmit r where r.workflowId=?1")
	public TblTemplateSubmit getTblTemplateSubmitByWorkflowId(String workflowId);
	
	@Query("from TblReportTemplate r where r.workflowId=?1")
	public TblReportTemplate getTblReportTemplateByWorkflowId(String workflowId);
	
	@Query("from TblTemplateSubmit r where r.id=?1")
	public TblTemplateSubmit getTblTemplateSubmitById(int submitId);

}
