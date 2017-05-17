package com.orienttech.statics.dao.fixednum;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.orienttech.statics.dao.entity.StaDimOrg;

public interface StaDimOrgDao extends
		PagingAndSortingRepository<StaDimOrg, String>,
		JpaSpecificationExecutor<StaDimOrg> {

	@Query("from StaDimOrg s where s.orgId=?1")
	StaDimOrg getOrgById(String orgId);
	
	
}
