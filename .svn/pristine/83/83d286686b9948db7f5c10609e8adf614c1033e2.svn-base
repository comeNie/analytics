package com.orienttech.statics.service;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.orienttech.statics.dao.FinancialReportDao;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class TestReportService {
	@Autowired
	private FinancialReportDao financialReportDao;
	@Test
	public void testFinancialReportAllList() throws Exception {
		System.out.println(financialReportDao.findAllList("1"));
	}
}
