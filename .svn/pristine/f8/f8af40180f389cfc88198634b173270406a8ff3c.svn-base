package com.orienttech.statics.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.orienttech.statics.dao.entity.FinancialReport;


public interface FinancialReportDao extends PagingAndSortingRepository<FinancialReport, Long>,
	JpaSpecificationExecutor<FinancialReport>{
	/**
	 * @return
	 */
	@Query("from  FinancialReport fr where fr.status='0' and fr.label = ?1 order by fr.rowId")
	List<FinancialReport> findAllList(String label);
}
