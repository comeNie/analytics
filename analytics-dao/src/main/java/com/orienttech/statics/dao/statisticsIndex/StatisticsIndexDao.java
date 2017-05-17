package com.orienttech.statics.dao.statisticsIndex;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.orienttech.statics.dao.entity.indexshows.Index;

public interface StatisticsIndexDao extends PagingAndSortingRepository<Index, Integer>,
JpaSpecificationExecutor<Index>{
	@Query(value="from Index i where i.indexId=?1")
	public Index findIndexById(int indexId);
	
	@Query(value="select count(*) from Index i where i.indexCode=?1")
	public int findIndexByCode(String indexCode);
	
	@Query(value="select count(*) from Index i where i.indexName=?1")
	public int findIndexByName(String indexName);
	
	@Query(value="select i.indexId from Index i where i.indexCode=?1")
	public String findIndexIdByCode(String indexCode);
	
	@Query(value="select i.indexId from Index i where i.indexName=?1")
	public String findIndexIdByName(String indexName);
	
	@Modifying
	@Query("update Index i set i.indexCode=?1 , i.indexName=?2 ,i.indexMeaning=?3 where i.indexId=?4")
	public void modifyIndex(String indexCode,String indexName,String indexMeaning, int indexId);
	
	@Query(value="select count(*) from index_function_relation i where i.index_id=?1",nativeQuery=true)
	public int findCountIndex(int indexId);
	
}
