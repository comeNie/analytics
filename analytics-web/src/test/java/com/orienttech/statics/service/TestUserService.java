package com.orienttech.statics.service;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.orienttech.statics.dao.entity.UserSso;
import com.orienttech.statics.service.model.usermng.OrgNodeBo;
import com.orienttech.statics.service.sysmng.MenuService;
import com.orienttech.statics.service.usermng.OrgDeptService;
import com.orienttech.statics.service.usermng.UserMngService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class TestUserService {
	@Autowired
	private UserMngService userMngService;
	@Autowired
	private MenuService menuService;
	@Autowired
	private OrgDeptService orgDeptService;
	
	@Test
	public void testName() throws Exception {
		UserSso user=new UserSso();
		user.setLoginName("10000012");
		user.setUserName("ewrewrtewrter");
		user.setSsoId("10000012");
		user.setOrgCode("10001");
		userMngService.saveUserSsoBySsoId(user);
	}
	@Test
	public void testMenuTree() throws Exception {
		System.out.println(menuService.findMenuTreeList().size());
	}
	
	@Test
	public void testOrgSelect() throws Exception {
		List<OrgNodeBo> list = orgDeptService.findOrgDeptBySelfOrgId("10001");
		OrgNodeBo orgNodeBo = null;
		System.out.println("====================开始打印===================");
		for (int i = 0; i < list.size(); i++) {
			orgNodeBo = list.get(i);
			System.out.println(orgNodeBo.getId());
		}
		System.out.println("====================打印结束===================");
	}
	
}
