package com.orienttech.statics.service.monitorMng;

import org.springframework.data.domain.Page;
import org.springframework.web.multipart.MultipartFile;

import com.orienttech.statics.dao.entity.EastlendingMonitor;


public interface MonitorMngService {
	
	Page<Object[]> findAll(Integer pageNumber, Integer pageSize, String search);
	
	public void delete(Integer id);
	
	public String add(MultipartFile myfile,EastlendingMonitor eastlendingMonitor);
	
}

