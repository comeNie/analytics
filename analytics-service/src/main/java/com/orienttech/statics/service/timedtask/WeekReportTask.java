/**
 * 周报定时器
 * @author gph
 */
package com.orienttech.statics.service.timedtask;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.orienttech.statics.commons.utils.Contants;

public class WeekReportTask extends Task {
	private static final Logger logger = LoggerFactory
			.getLogger(WeekReportTask.class);

	@Override
	public void doBiz() {
		logger.info("启动周报定时调度...");
		super.doBiz(Contants.CYCLE_WEEK);
	}
}
