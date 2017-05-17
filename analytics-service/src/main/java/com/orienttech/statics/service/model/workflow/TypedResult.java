package com.orienttech.statics.service.model.workflow;

import com.orienttech.statics.commons.base.Result;



public class TypedResult<T> extends Result {

	public TypedResult(){
		super();
	}

	public TypedResult(Boolean success, String msg, T typedDatas) {
		super(success, msg, null);
		this.typedDatas = typedDatas;
	}

	private T typedDatas;

	@Override
	public T getData() {
		return typedDatas;
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public void setData(Object data) {
		this.typedDatas = (T) data;
	}
	
}
