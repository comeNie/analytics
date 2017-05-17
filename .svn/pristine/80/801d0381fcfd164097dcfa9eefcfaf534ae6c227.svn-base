package com.orienttech.statics.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.orienttech.statics.dao.entity.fixednum.FinIndexFixed;
import com.orienttech.statics.dao.entity.fixednum.FinIndexFixedPK;

public interface FixedNumberDao extends
		PagingAndSortingRepository<FinIndexFixed, FinIndexFixedPK>,
		JpaSpecificationExecutor<FinIndexFixed> {

	@Query(value = "select count(*) from FinIndexFixed f where f.finIndexFixedPK.indexId=?1 and f.finIndexFixedPK.detailNo=?2 and f.finIndexFixedPK.id=?3 and f.finIndexFixedPK.fperiodnumber=?4")
	public int findFixedIsExist(String indexId, String detailNo, String orgId,
			String fperiodnumber);
	
	@Query(value="from FinIndexFixed f where f.finIndexFixedPK.fperiodnumber =?1 and f.finIndexFixedPK.indexId=?2")
	public List<FinIndexFixed> findLastMonthDatas(String fperiodNumber,String indexId);

}
