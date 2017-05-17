package com.orienttech.statics.service.reportShows;

import java.util.List;

import org.springframework.data.domain.Page;

public interface ReportShowsService{
	public String findReportShowsByFunctionId(int functionId);
	Page<Object[]> findIndexByFunctionId(int pageNumber,int pageSize, int functionId);
	List<Object[]> findReportByFunctionId(int functionId);
	Page<Object[]> findIndexForReport(int pageNumber,int pageSize, int functionId,String indexCode, String indexName);
	public void deleteIndexFunctionById(int id);
	public void updatePirvFunction(String indexShows, int functionId );
	public int cancelStore(int functionId);
	public void execute(int rowNumber, int id);
}
