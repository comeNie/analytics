package com.orienttech.statics.service.log;

import com.orienttech.statics.commons.security.SessionUser;

public interface UserLogService {
	/**
	 * @param user
	 * @param searchObj
	 */
	void addQueryLog(SessionUser user,String searchObj);
	/**
	 * @param user
	 * @param functionId
	 * @param functionName
	 */
	void addQueryLog(SessionUser user,Long functionId,String functionName);
}
