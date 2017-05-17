package com.orienttech.statics.webservice.impl;

import javax.jws.WebService;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;
import com.orienttech.statics.commons.base.Result;
import com.orienttech.statics.dao.entity.UserSso;
import com.orienttech.statics.service.usermng.UserMngService;
import com.orienttech.statics.webservice.WsSyncInfoService;
import com.orienttech.statics.webservice.exception.WsParamException;
import com.orienttech.statics.webservice.model.SyncUser;
@Component("wsSyncInfoService")
@WebService(endpointInterface = "com.orienttech.statics.webservice.WsSyncInfoService", targetNamespace = "http://webservice.statics.orienttech.com/", serviceName = "wsSyncInfoService")
public class WsUserInfoServiceImpl implements WsSyncInfoService {
	private Logger logger=LoggerFactory.getLogger(WsUserInfoServiceImpl.class);
	@Autowired
	private UserMngService userMngService;

	@Override
	public String syncUser(String jsonUser, String operation) {
		logger.info("同步用户{}",jsonUser);
		String jsonStr=JSON.toJSONString(result(true, "统计用户同步成功"));
		try {
			SyncUser syncUser = JSON.parseObject(jsonUser, SyncUser.class);
			UserSso userSso=new UserSso();
			this.copyUser(syncUser, userSso);
			userMngService.saveUserSsoBySsoId(userSso);
		}catch(WsParamException e){
			logger.info("WsParamException:{}", e.getMessage());
			jsonStr=JSON.toJSONString(result(false, "统计用户同步失败"));
		}catch (Exception e) {
			jsonStr=JSON.toJSONString(result(false, "统计用户同步失败"));
		}
		return jsonStr;
	}
	
	/**
	 * @param syncUser
	 * @param user
	 */
	private void copyUser(SyncUser syncUser,UserSso user){
		if(StringUtils.isBlank(syncUser.getLoginName())){
			logger.error("LoginName is Null");
			throw new WsParamException("LoginName is Null");
		}
		user.setEmail(syncUser.getEmail());
		user.setLoginName(syncUser.getLoginName());
		user.setSsoId(syncUser.getLoginName());
		user.setPassword(syncUser.getPassword());
		user.setOrgCode(String.valueOf(syncUser.getOrgId()));
		user.setUserName(syncUser.getName());
		if("1".contains(syncUser.getState())){//使用
			user.setUserStatus("0");
		}else{
			user.setUserStatus("1");//禁用
		}
	}
	private Result result(boolean success,String msg){
		return new Result(success, msg, null);
	}

}
