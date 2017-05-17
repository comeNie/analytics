package com.orienttech.statics.commons.base;

import java.io.Serializable;

/**
 * 业务层数据对象
 * 
 */
public class BaseBo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String operation;

	public String getOperation() {
		return operation;
	}

	public void setOperation(String operation) {
		this.operation = operation;
	}

}
