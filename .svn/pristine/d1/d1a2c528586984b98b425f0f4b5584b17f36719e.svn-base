package com.orienttech.statics.dao.reportShows;

import java.util.List;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.orienttech.statics.dao.entity.indexshows.Favorite;
import com.orienttech.statics.dao.entity.indexshows.PrivFunction;

public interface FavoriteDao  extends PagingAndSortingRepository<Favorite, Integer>,
JpaSpecificationExecutor<Favorite>{
	@Query("select count(*) from Favorite f where f.functionId=?1 and f.userId=?2")
	public int findIfStore(int functionId, int userId);
	
	@Query("select count(*) from Favorite f where f.userId=?1")
	public int findCountStore(int userId);
	
	@Modifying
	@Query(value="delete from tbl_favorite f where f.function_id=?1",nativeQuery=true)
	public int cancelStore(int functionId);
	
	@Query(value="select pft.action_type,pft.function_id,pft.name from tbl_favorite f , priv_function_t pft where f.function_id = pft.function_id and f.user_id=?1 order by f.id",nativeQuery=true)
	public List<Object[]> findStoreByUserId(int userId);

	@Query("select pf.functionId, pf.actionType  from Favorite f,PrivFunction pf where f.functionId = pf.functionId and f.userId=?1 order by f.id")
	public List<Object[]> findStores(int userId);
}
