package com.orienttech.statics.dao;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.orienttech.statics.dao.entity.FillFormCapitalPosition;

public interface FillFormCapitalPositionDao extends PagingAndSortingRepository<FillFormCapitalPosition, String>,
JpaSpecificationExecutor<FillFormCapitalPosition>{
	
	@Query("From FillFormCapitalPosition f where f.orgId=?1 and f.itemId=?2 and f.fillDate=sysdate order by f.itemId")
	FillFormCapitalPosition searchByItemIdAndOrgId(String orgId,String itemId);
	
	
	
}
