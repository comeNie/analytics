package com.orienttech.statics.dao;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.orienttech.statics.dao.entity.mobile.MobileBriefReport;

public interface MobileMngDao extends PagingAndSortingRepository<MobileBriefReport, Integer>,
	JpaSpecificationExecutor<MobileBriefReport> {
	
	@Modifying
	@Query(value="update MobileBriefReport t set t.description =?1 where t.id =?2")
	public void modifyMobileDesc(String description,Integer mobileId);
	
}
