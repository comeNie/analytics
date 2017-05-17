package com.orienttech.statics.web.listener;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import com.orienttech.statics.commons.utils.CacheMapHelper;
import com.orienttech.statics.service.model.sysmng.SysFunctionInfoBo;
import com.orienttech.statics.service.sysmng.WebAppInitService;

/**
 * 应用初始化
 *
 */
public class WebAppInitListener extends AbstractResourcePreloaderListener {
	private Logger logger=LoggerFactory.getLogger(WebAppInitListener.class);
	@Autowired
	private WebAppInitService webAppInitService;
	@Override
	protected void preload(ApplicationContext applicationContext) {
		logger.info("WebAppInitListener init *******************************");
		webAppInitService=applicationContext.getBean(WebAppInitService.class);
		this.initSysFunInfo();
		
	}
	private void initSysFunInfo(){
		List<SysFunctionInfoBo> sfciList=webAppInitService.findAllSysFuncInfoList();
		if(CollectionUtils.isEmpty(sfciList)){
			return;
		}
		CacheMapHelper cmHelper=CacheMapHelper.getInstance();
		for (SysFunctionInfoBo sfci : sfciList) {
			cmHelper.putSysFunc(sfci.getServletPath(), sfci.getReqMethod(), cmHelper.new SysFuncItem(sfci.getId(), sfci.getFunctionId(), sfci.getFunctionName()) );
		}
	}

}
