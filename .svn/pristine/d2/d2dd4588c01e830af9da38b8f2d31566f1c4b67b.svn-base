package com.orienttech.statics.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.orienttech.statics.commons.utils.PropertiesConstants;

@Controller
public class LoginController {
	private Log log=LogFactory.getLog(LoginController.class);
	@RequestMapping("/toLogin")
	public String toLogin(HttpServletRequest request, Model model){
		Subject currentUser = SecurityUtils.getSubject();
		if (currentUser.isAuthenticated()) {
			currentUser.logout(); // 如果认证了,先登出.避免重复认证
		}
		String error=request.getParameter("error");
		if(StringUtils.isNotBlank(error)){
			model.addAttribute("error", error);
		}
		return "login";
	}
	@RequestMapping(value="/login")
	public String login(HttpServletRequest request, Model model) {

		String error = "";
		String exceptionClassName = (String) request.getAttribute(FormAuthenticationFilter.DEFAULT_ERROR_KEY_ATTRIBUTE_NAME);
		/*if (IncorrectCaptchaException.class.getName().equals(exceptionClassName)) {
			error = "验证码错误";
		}*/
		if (UnknownAccountException.class.getName().equals(exceptionClassName)||IncorrectCredentialsException.class.getName().equals(exceptionClassName)) {
			error = "用户名或密码错误";
		}
		if(StringUtils.isNotBlank(error)){
			model.addAttribute("error", error);
		}
		return "redirect:/toLogin";
	}
	@RequestMapping(value="/cas")
	public String cas(HttpServletRequest request, Model model) {

		String exceptionClassName = (String) request.getAttribute(FormAuthenticationFilter.DEFAULT_ERROR_KEY_ATTRIBUTE_NAME);
		log.info("登录失败"+exceptionClassName);
		model.addAttribute("portalUrl", PropertiesConstants.getPortalUrl());
		return "casFailure";
	}
}
