package com.orienttech.statics.service.sysmng.impl;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.base.Function;
import com.google.common.collect.Lists;
import com.orienttech.statics.commons.dynamicquery.DynamicQuery;
import com.orienttech.statics.service.model.sysmng.SysFunctionInfoBo;
import com.orienttech.statics.service.sysmng.WebAppInitService;
@Service
public class WebAppInitServiceImpl implements WebAppInitService {
	@Autowired
	private DynamicQuery dynamicQuery;
	@Override
	public List<SysFunctionInfoBo> findAllSysFuncInfoList() {
		String str="select sfi.id,sfi.function_id,sfi.function_name,sfi.servlet_path,sfi.req_method from TB_SYS_FUNCTION_INFO sfi order by id";
		List<Object[]> list=dynamicQuery.nativeQuery(str);
		if(CollectionUtils.isEmpty(list)){
			return null;
		}
		return Lists.transform(list, new Function<Object[], SysFunctionInfoBo>() {
			@Override
			public SysFunctionInfoBo apply(Object[] objs) {
				return new SysFunctionInfoBo(objs);
			}
		});
	}

}
