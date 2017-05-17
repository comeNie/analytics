package com.orienttech.statics.dao.fixednum;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.orienttech.statics.dao.entity.fixednum.FinIndexDetail;

public interface FinIndexDetailDao extends PagingAndSortingRepository<FinIndexDetail, Long>,
		JpaSpecificationExecutor<FinIndexDetail> {
	
	@Query(value="select fd.detailNo from FinIndexDetail fd where fd.indexId=?1")
	public String getDetailNoByIndexId(String indexId);
}
