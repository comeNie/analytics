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
@Table(name = "TBL_FAVORITE", schema = TJ_SCHEMA)
public class Favorite extends BaseEntity{
	private static final long serialVersionUID = 1963518584772322399L;
	
	@Id
	@SequenceGenerator(name="SEQ_FAVORITE", sequenceName="SEQ_FAVORITE",allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="SEQ_FAVORITE")
	@Column(name="ID")
	private int id;
	
	@Column(name="FUNCTION_ID")
	private int functionId;
	
	@Column(name="USER_ID")
	private int userId;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getFunctionId() {
		return functionId;
	}

	public void setFunctionId(int functionId) {
		this.functionId = functionId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}
}
