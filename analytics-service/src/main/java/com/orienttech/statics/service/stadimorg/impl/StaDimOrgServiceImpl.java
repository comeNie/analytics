package com.orienttech.statics.service.stadimorg.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.orienttech.statics.dao.entity.StaDimOrg;
import com.orienttech.statics.dao.fixednum.StaDimOrgDao;
import com.orienttech.statics.service.stadimorg.StaDimOrgService;

@Service("staDimOrgService")
public class StaDimOrgServiceImpl implements StaDimOrgService {

	@Autowired
	private StaDimOrgDao staDimOrgDao;

	@Override
	public StaDimOrg getOrgById(String orgId) {
		return staDimOrgDao.getOrgById(orgId);
	}

}
