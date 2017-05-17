package com.orienttech.statics.service.log.impl;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.base.Function;
import com.google.common.collect.Lists;
import com.orienttech.statics.commons.dynamicquery.DynamicQuery;
import com.orienttech.statics.commons.security.SessionUser;
import com.orienttech.statics.commons.utils.CommonHelper;
import com.orienttech.statics.dao.UserLogDao;
import com.orienttech.statics.dao.entity.UserLog;
import com.orienttech.statics.service.log.UserLogService;
import com.orienttech.statics.service.model.sysmng.MenuBo;
@Service
public class UserLogServiceImpl implements UserLogService{
	@Autowired
	private UserLogDao userLogDao;
	@Autowired
	private DynamicQuery dynamicQuery;
	@Override
	public void addQueryLog(SessionUser user, String searchObj) {
		if(user==null){
			return ;
		}
		UserLog userLog=new UserLog();
		userLog.setUserId(user.getId());
		userLog.setLoginName(user.getLoginName());
		userLog.setUserName(user.getUserName());
		userLog.setOperateType("query");//查询日志
		MenuBo bo=this.findFunctionBySearchPath(searchObj);
		if(bo==null){
			return;
		}
		userLog.setFunctionId(bo.getId());
		userLog.setFunctionName(bo.getName());
		userLog.setOperateTime(CommonHelper.getNow());
		userLogDao.save(userLog);
	}
	@Override
	public void addQueryLog(SessionUser user, Long functionId,
			String functionName) {
		if(user==null){
			return ;
		}
		UserLog userLog=new UserLog();
		userLog.setUserId(user.getId());
		userLog.setLoginName(user.getLoginName());
		userLog.setUserName(user.getUserName());
		userLog.setOperateType("query");//查询日志
		userLog.setFunctionId(functionId);
		userLog.setFunctionName(functionName);
		userLog.setOperateTime(CommonHelper.getNow());
		userLogDao.save(userLog);
	}
	/**
	 * @param searchObj
	 * @return
	 */
	private MenuBo findFunctionBySearchPath(String searchObj){
		String str="select a.function_id,a.name  from priv_function_t a where a.url = ?1";
		List<Object[]> objs=dynamicQuery.nativeQuery(str, searchObj);
		if(CollectionUtils.isEmpty(objs)){
			return null;
		}
		List<MenuBo> menus=Lists.transform(objs, new Function<Object[], MenuBo>() {
			@Override
			public MenuBo apply(Object[] objs) {
				MenuBo bo=new MenuBo();
				bo.setId(CommonHelper.toLong(objs[0]));
				bo.setName(CommonHelper.toStr(objs[1]));
				return bo;
			}
		});
		return menus.get(0);
	}
	
	
}
