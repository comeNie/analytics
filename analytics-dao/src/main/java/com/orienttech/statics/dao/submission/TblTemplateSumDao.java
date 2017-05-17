/**
 * 数据汇总Dao
 * @author dz
 */
package com.orienttech.statics.dao.submission;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.orienttech.statics.dao.entity.submission.TblTemplateSum;

public interface TblTemplateSumDao extends
		PagingAndSortingRepository<TblTemplateSum, Integer>, JpaSpecificationExecutor<TblTemplateSum> {

	@Query("from TblTemplateSum r where r.workflowId =?1")
	public TblTemplateSum findTblTemplateSumByTemplateId(String workflowId);
	
	@Query("from TblTemplateSum r where r.workflowId =?1 and r.templateId=?2")
	public TblTemplateSum findTblTemplateSumByTemplateIdAndWId(String workflowId, Integer templateId);

	@Query("from TblTemplateSum r where r.templateId =?1")
	public TblTemplateSum findByTemplateId(Integer templateId);
}
