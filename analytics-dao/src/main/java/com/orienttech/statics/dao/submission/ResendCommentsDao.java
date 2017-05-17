/**
 * 报表模版Dao
 * @author dz
 */
package com.orienttech.statics.dao.submission;

import java.util.List;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.orienttech.statics.dao.entity.submission.ResendComments;
import com.orienttech.statics.dao.entity.submission.TblTemplateSubmit;

public interface ResendCommentsDao extends
		PagingAndSortingRepository<ResendComments, Integer>,
		JpaSpecificationExecutor<ResendComments> {

	@Query("from ResendComments r where r.workflowId=?1 and orgId=?2")
	public List<ResendComments> getResendCommentsByWorkflowIdAndOrgid(String workflowId,String orgId);
	
	@Query("from ResendComments r where r.workflowId=?1")
	public List<ResendComments> getResendCommentsByWorkflowId(String workflowId);
}
