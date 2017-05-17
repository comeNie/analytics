package com.orienttech.statics.service.model.reportAndIndex;

import java.io.Serializable;

import com.orienttech.statics.commons.utils.CommonHelper;

public class ReportIndex implements Serializable{
	private String indexName;
	private String indexMeaning;
	private int id;
	private int rowNumber;
	public ReportIndex(){
		
	}
	public ReportIndex(Object[] objs) {
		int i=0;
		this.indexName=CommonHelper.toStr(objs[i++]);
		this.indexMeaning=CommonHelper.toStr(objs[i++]);
		this.id=CommonHelper.toInt(objs[i++]);
		this.rowNumber = CommonHelper.toInt(objs[i++]);
	}
	
	public void setIndexName(String indexName) {
		this.indexName = indexName;
	}
	public String getIndexMeaning() {
		return indexMeaning;
	}
	public void setIndexMeaning(String indexMeaning) {
		this.indexMeaning = indexMeaning;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public int getRowNumber() {
		return rowNumber;
	}
	public void setRowNumber(int rowNumber) {
		this.rowNumber = rowNumber;
	}
	public String getIndexNameStr(){
		if(indexName.contains(">")){
			indexName = indexName.replace(">", "&gt;");
		}
		if(indexName.contains("<")){
			indexName = indexName.replace("<", "&lt;");
		}
		return indexName;
	}
	public String getIndexMeaningStr(){
		if(indexMeaning.contains(">")){
			indexMeaning = indexMeaning.replace(">", "&gt;");
		}
		if(indexMeaning.contains("<")){
			indexMeaning = indexMeaning.replace("<", "&lt;");
		}
		return indexMeaning;
	}
	
}
