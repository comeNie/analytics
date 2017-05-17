package com.orienttech.statics.dao.reportShows;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.orienttech.statics.dao.entity.indexshows.IndexFunction;
import com.orienttech.statics.dao.entity.indexshows.PrivFunction;

public interface ReportShowsDao extends PagingAndSortingRepository<IndexFunction, Integer>,
JpaSpecificationExecutor<IndexFunction>{
	
	@Query(value="select pf.index_shows from priv_function_t pf where pf.function_id=?1", nativeQuery= true)
	public String findReportShowsByFunctionId(int functionId);
	
	@Modifying
	@Query(value="delete index_function_relation ifr where ifr.id=?1",nativeQuery=true)
	public void deleteIndexFunctionById(int id);
	
	@Modifying
	@Query(value="update priv_function_t pf set pf.index_shows=?1 where pf.function_id=?2",nativeQuery=true)
	public void updatePirvFunction(String indexShows, int functionId);
	
	@Query(value="select ti.index_name from index_function_relation ifr, tbl_index ti where ti.index_id=ifr.index_id and ifr.index_id=?1 and ifr.function_id=?2", nativeQuery= true)
	public String findHavenSave(int id, int functionId);
	
	@Query(value="select r.id,r.row_number from tbl_index i, index_function_relation r where i.index_id=r.index_id and r.function_id=?1 and r.row_number>?2 order by r.row_number",nativeQuery = true)
	public List<Object[]> findIdByRownumber(int functionId, int rowNumber);
	
	@Modifying
	@Query(value="update index_function_relation ifr set ifr.row_number=?1 where ifr.id =?2",nativeQuery = true)
	public void execute(int rowNumber, int id);
	
	@Query(value="select r.id,r.row_number from tbl_index i, index_function_relation r where i.index_id=r.index_id and r.function_id=?1 order by r.row_number",nativeQuery = true)
	public List<Object[]> findAllByFunctionId(int functionId);
}
