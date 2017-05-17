package com.orienttech.statics.service.fillFormItem;

import java.util.List;

import com.orienttech.statics.dao.entity.FillFormCapitalPosition;
import com.orienttech.statics.service.model.FillFormItemBo;

public interface FillFormItemService {
	/**
	 * 获取所有FillFormItem
	 * @return
	 */
	List<FillFormItemBo> findByFormId(String formId,String orgId);
	
	String save(String orgId,List<FillFormCapitalPosition> fcpList);
	
}

