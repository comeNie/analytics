package com.orienttech.statics.dao.fixednum;

import java.util.List;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.orienttech.statics.dao.entity.fixednum.EcorgDepartment;

public interface EcorgDepartmentDao extends PagingAndSortingRepository<EcorgDepartment, Long>, JpaSpecificationExecutor<EcorgDepartment> {
		
	@Query(value="select distinct id from EcorgDepartment ec")
	public List<EcorgDepartment> getEcorgIds();
}
