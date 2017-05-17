package com.orienttech.statics.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.orienttech.statics.dao.entity.ReportChartCoordinate;


public interface ReportChartCoordinateDao extends PagingAndSortingRepository<ReportChartCoordinate, Long>,
	JpaSpecificationExecutor<ReportChartCoordinate>{
	
	@Query("select new ReportChartCoordinate(t.rowId,t.reportName,t.searchPath,t.x1,t.x2,t.y1,t.y2) from ReportChartCoordinate t where t.taskId='344' and t.rowId in (1,2,3,4) order by t.rowId")
	List<ReportChartCoordinate> findAllList();
}
