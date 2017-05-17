package com.orienttech.statics.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.orienttech.statics.dao.UserLogDao;
import com.orienttech.statics.dao.entity.UserLog;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class TestUserLogService {
	@Autowired
	private UserLogDao userLogDao;
	@Test
	public void testSaveLog() throws Exception {
		userLogDao.save(new UserLog());
	}
}
