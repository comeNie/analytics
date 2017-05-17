package com.orienttech.statics.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.orienttech.statics.dao.entity.AutoExecPlan;

public interface AutoExecPlanDao extends PagingAndSortingRepository<AutoExecPlan, String>,
JpaSpecificationExecutor<AutoExecPlan>{
	/**
	 * @return
	 */
	@Query("From AutoExecPlan aep where aep.planStat='1'")
	List<AutoExecPlan> findListByState();
}
