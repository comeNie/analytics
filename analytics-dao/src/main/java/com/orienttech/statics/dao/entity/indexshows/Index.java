package com.orienttech.statics.dao.entity.indexshows;

import static com.orienttech.statics.commons.utils.Contants.TJ_SCHEMA;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.orienttech.statics.commons.entity.BaseEntity;
import com.orienttech.statics.commons.utils.CommonHelper;

@Entity
@Table(name = "TBL_INDEX", schema = TJ_SCHEMA)
public class Index  extends BaseEntity{
	private static final long serialVersionUID = 1963518584772322398L;
	
	@Id
	@SequenceGenerator(name="SEQ_INDEX", sequenceName="SEQ_INDEX",allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="SEQ_INDEX")
	@Column(name="INDEX_ID")
	private int indexId;
	
	@Column(name="INDEX_CODE",length=50)
	private String indexCode;
	
	@Column(name="INDEX_NAME",length=200)
	private String indexName;
	
	@Column(name="INDEX_MEANING",length=800)
	private String indexMeaning;
	
	public Index(){
		
	}
	
	public Index(int indexId, String indexCode, String indexName, String indexMeaning){
		this.indexId = indexId;
		this.indexCode = indexCode;
		this.indexName = indexName;
		this.indexMeaning = indexMeaning;
	}
	
	public Index(Object[] objs) {
		super();
		int i=0;
		this.indexId=CommonHelper.toInt(objs[i++]);
		this.indexCode=CommonHelper.toStr(objs[i++]);
		this.indexName=CommonHelper.toStr(objs[i++]);
		this.indexMeaning=CommonHelper.toStr(objs[i++]);
	}

	public int getIndexId() {
		return indexId;
	}

	public void setIndexId(int indexId) {
		this.indexId = indexId;
	}

	public String getIndexCode() {
		return indexCode;
	}

	public void setIndexCode(String indexCode) {
		this.indexCode = indexCode;
	}

	public String getIndexName() {
		return indexName;
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
	
	public String getIndexCodeStr(){
		if(indexCode!=null && !"".equals(indexCode) && indexCode.contains(">")){
			indexCode = indexCode.replace(">", "&gt;");
		}
		if(indexCode!=null && !"".equals(indexCode) && indexCode.contains("<")){
			indexCode = indexCode.replace("<", "&lt;");
		}
		return indexCode ;
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
