package com.orienttech.statics.web.security;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.cas.CasFilter;
import org.apache.shiro.subject.Subject;

import com.orienttech.statics.commons.utils.PropertiesConstants;
import com.orienttech.statics.web.security.exception.IncorrectRefererException;

/**
 * 增加对登入入口的校验
 * 
 * @author wh
 * @lastModified wanghui 2014-11-13 16:59:26
 */
public class MyCasFilter extends CasFilter {

	public static final String ERROR_KEY_ATTRIBUTE_NAME = MyCasFilter.class.getName() + ".casShiroLoginFailure";

	@Override
	protected boolean executeLogin(ServletRequest request, ServletResponse response) throws Exception {
		AuthenticationToken token = createToken(request, response);
		if (token == null) {
			String msg = "createToken method implementation returned null. A valid non-null AuthenticationToken "
					+ "must be created in order to execute a login attempt.";
			throw new IllegalStateException(msg);
		}
		try {
			validateReferer(request);
			Subject subject = getSubject(request, response);
			subject.login(token);
			return onLoginSuccess(token, subject, request, response);
		} catch (AuthenticationException e) {
			return onLoginFailure(token, e, request, response);
		}
	}

	/**
	 * 要求只能是从portal中跳转过来的才可以
	 * 
	 * @param request
	 */
	private void validateReferer(ServletRequest request) {
		HttpServletRequest req = (HttpServletRequest) request;
		String referer = req.getHeader("referer");
		boolean portalJump=PropertiesConstants.getBoolean(PropertiesConstants.PORTAL_JUMP);
		if (portalJump&&(StringUtils.isEmpty(referer)
				|| !StringUtils.startsWith(referer, PropertiesConstants.getPortalUrl()))) { // 从portal中跳转过来的
			throw new IncorrectRefererException();
		}
	}

	@Override
	protected boolean onLoginFailure(AuthenticationToken token, AuthenticationException ae, 
			ServletRequest request, ServletResponse response) {
		String className = ae.getClass().getName();
		request.setAttribute(ERROR_KEY_ATTRIBUTE_NAME, className);
		return true;
	}

}
