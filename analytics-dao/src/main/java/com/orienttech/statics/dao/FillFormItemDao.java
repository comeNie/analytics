package com.orienttech.statics.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.orienttech.statics.dao.entity.FillFormItem;

public interface FillFormItemDao extends PagingAndSortingRepository<FillFormItem, String>,
JpaSpecificationExecutor<FillFormItem>{
	
	@Query("From FillFormItem ffi where ffi.formId=?1 order by ffi.itemId")
	List<FillFormItem> findByFormId(String formId);
	
}
