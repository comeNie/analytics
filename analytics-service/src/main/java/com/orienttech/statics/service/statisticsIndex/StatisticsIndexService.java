package com.orienttech.statics.service.statisticsIndex;


import org.springframework.data.domain.Page;

import com.orienttech.statics.dao.entity.indexshows.Index;
import com.orienttech.statics.dao.entity.indexshows.PrivFunction;

public interface StatisticsIndexService {
	Page<Object[]> findAllIndex(int pageNumber,int pageSize, String search);
	public Index findIndexById(int indexId);
	public boolean findIndexByCode(int indexId, String indexCode, String flag);
	public boolean findIndexByName(int indexId, String indexName, String flag);
	public void modifyIndex(Index index);
	public void addIndex(Index index);
	public void deleteIndexById(int indexId);
	Page<Object[]> findReportByIndexId(int pageNumber,int pageSize, int indexId);
	public int findCountIndex(int indexId);
}
