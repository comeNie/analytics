package com.orienttech.statics.dao.entity.indexshows;

import static com.orienttech.statics.commons.utils.Contants.TJ_SCHEMA;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.orienttech.statics.commons.entity.BaseEntity;

@Entity
@Table(name = "INDEX_FUNCTION_RELATION", schema = TJ_SCHEMA)
public class IndexFunction extends BaseEntity{
	private static final long serialVersionUID = 1963518584772322350L;
	
	@Id
	@SequenceGenerator(name="SEQ_INDEX_FUNCTION", sequenceName="SEQ_INDEX_FUNCTION", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="SEQ_INDEX_FUNCTION")
	@Column(name="ID")
	private int id;
	
	@Column(name="INDEX_ID")
	private int indexId;
	
	@Column(name="FUNCTION_ID")
	private int functionId;
	
	@Column(name="ROW_NUMBER")
	private int rowNumber;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIndexId() {
		return indexId;
	}

	public void setIndexId(int indexId) {
		this.indexId = indexId;
	}

	public int getFunctionId() {
		return functionId;
	}

	public void setFunctionId(int functionId) {
		this.functionId = functionId;
	}

	public int getRowNumber() {
		return rowNumber;
	}

	public void setRowNumber(int rowNumber) {
		this.rowNumber = rowNumber;
	}
}
