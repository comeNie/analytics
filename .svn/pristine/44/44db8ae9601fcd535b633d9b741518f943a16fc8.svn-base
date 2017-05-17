/**
 * 年报定时器
 * @author gph
 */
package com.orienttech.statics.service.timedtask;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.orienttech.statics.commons.utils.Contants;

public class YearReportTask extends Task {
	private static final Logger logger = LoggerFactory
			.getLogger(YearReportTask.class);

	@Override
	public void doBiz() {
		logger.info("开始执行年报定时调度...");
		super.doBiz(Contants.CYCLE_YEAR);
	}
}
