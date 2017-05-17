/**
 * 数据报送Dao
 * @author dz
 */
package com.orienttech.statics.dao.submission;

import java.util.Date;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.orienttech.statics.dao.entity.submission.TblTemplateSubmit;

public interface TblTemplateSubmitDao extends
		PagingAndSortingRepository<TblTemplateSubmit, Long>,
		JpaSpecificationExecutor<TblTemplateSubmit> {

	/**
	 * 通过机构Id和流程Id查找报表
	 * @param orgId 机构Id
	 * @return 数据报表对象
	 */
	@Query("from TblTemplateSubmit ts where ts.orgId =?1 and ts.workflowId=?2")
	TblTemplateSubmit getTemplateSubmitByOrgIdAndWorkflowId(String orgId,String workflowId);
	/**
	 * 通过模版Id查找数据报表对象实例
	 * @param templateId
	 * @return
	 */
	@Query("from TblTemplateSubmit ts where ts.templateId =?1")
	TblTemplateSubmit findTemplateSubmitByTemplateId(int templateId);
	
	@Query("select count(*) from TblTemplateSubmit t where t.templateId=?1 and t.submitState='1' and t.workflowId=?2")
	int countHavenSubmitNumberByTemplateId(int id,String workflowId);
	
	@Query("select count(*) from TblTemplateSubmit t where t.templateId=?1 and t.workflowId=?2")
	int countShouldSubmitNumberByTemplateId(int id,String workflowId);

	@Modifying
	@Query("update TblTemplateSubmit t set t.releasePeople=?1, t.releaseTime=?2 where workflowId=?3")
	void updateByWorkflowId(String releasePeople,Date date, String workflowId);
	
	@Query("select t from TblTemplateSubmit t where t.orgId=?1 and t.workflowId=?2")
	TblTemplateSubmit getTemplateSubmitByWorkflowIdAndOrgId(String orgId, String workflowId);
	
	
}
