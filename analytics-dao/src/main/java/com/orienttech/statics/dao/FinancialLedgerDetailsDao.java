package com.orienttech.statics.dao;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.orienttech.statics.dao.entity.FinancialLedgerDetails;

public interface FinancialLedgerDetailsDao extends
		PagingAndSortingRepository<FinancialLedgerDetails, Integer>,
		JpaSpecificationExecutor<FinancialLedgerDetails> {
	
	@Modifying
	@Query(value=("delete from financial_ledger_details"),nativeQuery=true)
	public void truncateAll();
	
}