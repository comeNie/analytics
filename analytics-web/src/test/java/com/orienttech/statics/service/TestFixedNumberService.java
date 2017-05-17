package com.orienttech.statics.service;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.orienttech.statics.service.fixednum.FixednumService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class TestFixedNumberService {
	@Autowired
	private FixednumService fixednumService;
	@org.junit.Test
	public void testName() throws Exception {
		//fixednumService.initDatas(false, "7", "201412");
	}
}
