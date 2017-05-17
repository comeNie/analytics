package com.orienttech.statics.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.orienttech.statics.commons.security.SessionUser;
import com.orienttech.statics.commons.utils.CacheMapHelper;
import com.orienttech.statics.commons.utils.CacheMapHelper.SysFuncItem;
import com.orienttech.statics.commons.utils.SpringHolder;
import com.orienttech.statics.service.log.UserLogService;

/**
 * 用户日志处理
 */
public class UserLogFilter implements Filter {
	private Logger logger = LoggerFactory.getLogger(UserLogFilter.class);
	private String contextPath;
	public static final String PARAM_NAME_EXCLUSIONS = "exclusions";
	private UserLogService userLogService;

	public UserLogFilter() {
	}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		logger.info("UserLogFilter destroy................");
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		this.handleUserLog(req);
		String servletPath = req.getServletPath();
		//logger.info("is filter:{},servletPath：{}"+StringUtils.endsWith(servletPath, "log"),servletPath);
		if(StringUtils.endsWith(servletPath, "log")){
			String searchObj = req.getParameter("searchObj");
			SessionUser user = (SessionUser) SecurityUtils.getSubject()
					.getPrincipal();
			userLogService.addQueryLog(user, searchObj);
			return;
		}
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fc) throws ServletException {
		logger.info("UserLogFilter init................");
		ServletContext sc=fc.getServletContext();
		ApplicationContext ac= WebApplicationContextUtils.getRequiredWebApplicationContext(sc);
		userLogService = ac.getBean(UserLogService.class);
	}
	/**
	 * 如果需要记录则为true,否则为false
	 * @param servletPath
	 * @return
	 */
	private void handleUserLog(HttpServletRequest req){
		contextPath = req.getContextPath();
		//String requestURI = req.getRequestURI();
		String servletPath = req.getServletPath();
		String reqMethod=req.getMethod();
		/*logger.info("contextPath:{},servletPath:{},requestURI:{},Method:{}", contextPath,
				servletPath, requestURI,req.getMethod());*/
		SysFuncItem sfci=CacheMapHelper.getInstance().getSysFuncItem(servletPath, reqMethod);
		if(sfci!=null){
			SessionUser user = (SessionUser) SecurityUtils.getSubject()
					.getPrincipal();
			userLogService.addQueryLog(user, sfci.getFunctionId(), sfci.getFunctionName());
			return;
		}
	}
}
