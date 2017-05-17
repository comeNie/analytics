package com.orienttech.statics.dao;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.orienttech.statics.dao.entity.PassRead;

public interface PassReadDao extends PagingAndSortingRepository<PassRead, String>,JpaSpecificationExecutor<PassRead>{
	

}
