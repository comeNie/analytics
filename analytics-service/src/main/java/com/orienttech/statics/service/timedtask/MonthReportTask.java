/**
 * 月报定时器
 */
package com.orienttech.statics.service.timedtask;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.orienttech.statics.commons.utils.Contants;

public class MonthReportTask extends Task {
	private static final Logger logger = LoggerFactory
			.getLogger(MonthReportTask.class);

	@Override
	public void doBiz() {
		logger.info("开始执行月报定时调度...");
		super.doBiz(Contants.CYCLE_MONTH);
	}
}
