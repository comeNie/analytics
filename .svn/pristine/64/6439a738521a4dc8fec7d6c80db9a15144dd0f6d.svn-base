package com.orienttech.statics.service.statisticsIndex.impl;


import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.common.collect.Lists;
import com.orienttech.statics.commons.dynamicquery.DynamicQuery;
import com.orienttech.statics.dao.entity.indexshows.Index;
import com.orienttech.statics.dao.entity.indexshows.PrivFunction;
import com.orienttech.statics.dao.statisticsIndex.StatisticsIndexDao;
import com.orienttech.statics.service.statisticsIndex.StatisticsIndexService;

@Service
public class StatisticsIndexServiceImpl implements StatisticsIndexService {

	@Autowired
	private DynamicQuery dynamicQuery;
	
	@Autowired
	private StatisticsIndexDao statisticsIndexDao;
	
	@SuppressWarnings("unchecked")
	@Override
	public Page<Object[]> findAllIndex(int pageNumber, int pageSize, String search) {
		List<Object> params=Lists.newArrayList();
		StringBuffer sb = new StringBuffer();
		sb.append("select * from TBL_INDEX t");
		if(StringUtils.isNotBlank(search)){
			sb.append(" where t.index_name like ");
			sb.append("'%"+search+"%'");
		}
		sb.append(" order by t.index_id desc");
		return dynamicQuery.nativeQuery(new PageRequest(pageNumber, pageSize), sb.toString(),params.toArray());
	}

	@Override
	public Index findIndexById(int indexId) {
		return statisticsIndexDao.findIndexById(indexId);
	}

	@Transactional(readOnly = true)
	@Override
	public boolean findIndexByCode(int indexId, String indexCode, String flag) {
		if(flag.equals("1")){
			String str = statisticsIndexDao.findIndexIdByCode(indexCode.trim());
			if(str!=null && Integer.parseInt(str)>0){
				int num =Integer.parseInt(str);
				if(num == indexId){
					return true;
				}else{
					return false;
				}
			}else{
				return true;
			}
		}else{
			boolean f = statisticsIndexDao.findIndexByCode(indexCode.trim()) <= 0;
			return f;
		}
	}

	@Transactional(readOnly = true)
	@Override
	public boolean findIndexByName(int indexId, String indexName, String flag) {
		if(flag.equals("1")){
			String str = statisticsIndexDao.findIndexIdByName(indexName.trim());
			if(str!=null && Integer.parseInt(str)>0){
				int num =Integer.parseInt(str);
				if(num == indexId){
					return true;
				}else{
					return false;
				}
			}else{
				return true;
			}
		}else{
			boolean f = statisticsIndexDao.findIndexByName(indexName.trim())<= 0;
			return f;
		}
	}
	
	@Transactional(readOnly = true)
	@Override
	public void modifyIndex(Index index) {
		statisticsIndexDao.modifyIndex(index.getIndexCode(), index.getIndexName(), index.getIndexMeaning(), index.getIndexId());
	}

	@Override
	public void addIndex(Index index) {
		statisticsIndexDao.save(index);
	}

	@Override
	public void deleteIndexById(int indexId) {
		statisticsIndexDao.delete(statisticsIndexDao.findIndexById(indexId));
	}

	@SuppressWarnings("unchecked")
	@Override
	public Page<Object[]> findReportByIndexId(int pageNumber, int pageSize,
			int indexId) {
		List<Object> params=Lists.newArrayList();
		String str = "select p.name,p.function_id from priv_function_t p , index_function_relation i where p.function_id=i.function_id and i.index_id="+indexId;
		return dynamicQuery.nativeQuery(new PageRequest(pageNumber, pageSize), str,params.toArray());
	}

	@Override
	public int findCountIndex(int indexId) {
		return statisticsIndexDao.findCountIndex(indexId);
	}

}
