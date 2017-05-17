package com.orienttech.statics.service.timedtask;

import java.util.Properties;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.orienttech.statics.commons.utils.CommonHelper;
import com.orienttech.statics.commons.utils.PropertiesConstants;
import com.orienttech.statics.commons.utils.SpringHolder;
import com.orienttech.statics.commons.utils.SystemHelper;
import com.orienttech.statics.service.report.HistoryReportService;

public class ExpireJobTask {
	/** Logger */
	private static final Logger logger = LoggerFactory
			.getLogger(ExpireJobTask.class);

	/**
	 * 业务 辑处理
	 */
	public void doBiz() {
		boolean isExe = false;
		if (PropertiesConstants.getQuartzOpen().equals("on")) {
			isExe = true;
			if (PropertiesConstants.getClusterOpen().equals("on")) {
				isExe = executeTask();
			}

			if (isExe) {
				logger.info(CommonHelper.date2Str(CommonHelper.getNow(),
						CommonHelper.DF_DATE_TIME));
				logger.info("ExpireJobTask doing..........................................");
				HistoryReportService historyReportService = SpringHolder
						.getBean(HistoryReportService.class);
				historyReportService.autoExecReport();
				// logger.info(ServerInfoHelper.getServerInfo().toString());
				logger.info("ExpireJobTask end !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
			}
		}

	}

	private boolean executeTask() {
		Properties prop = new Properties();
		try {
			String localMachineName = SystemHelper.getLocalIP();
			logger.info("LocalHost IP:{}", localMachineName);
			prop.load(Thread.currentThread().getContextClassLoader()
					.getResourceAsStream("application.properties"));
			return StringUtils.equals(localMachineName,
					prop.getProperty("quartz.executeMachineName"));
		} catch (Exception e) {
			logger.error(
					"application.properties读取quartz.executeMachineName发生错误", e);
		}
		return false;
	}
}