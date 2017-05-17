package com.orienttech.statics.dao;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.orienttech.statics.dao.entity.UserLog;

public interface UserLogDao extends PagingAndSortingRepository<UserLog, Long>,
JpaSpecificationExecutor<UserLog>{

}
