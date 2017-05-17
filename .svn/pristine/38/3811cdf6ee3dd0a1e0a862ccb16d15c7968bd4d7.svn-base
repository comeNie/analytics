package com.orienttech.statics.webservice;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSON;
import com.orienttech.statics.commons.webservice.WebServices;
import com.orienttech.statics.webservice.model.SyncUser;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext.xml" })
public class TestWebService {
	@Autowired
	private WebServices webServices;
	@Before
	public void init() {
		webServices.initClients();
	}
	@Test
	public void testSyncUser() throws Exception {
		SyncUser user=new SyncUser();
		user.setName("王丽吉");
		user.setState("0");
		user.setEmail("hjsdfk@sfds.com");
		user.setLoginName("890897045");
		user.setPassword("SDFSDFSDFSDFDSF");
		user.setOrgId(10001);
		String result= webServices.invoke("analyticsWs", "syncUser",JSON.toJSONString(user),"add");
		System.out.println(result);
	}
}
