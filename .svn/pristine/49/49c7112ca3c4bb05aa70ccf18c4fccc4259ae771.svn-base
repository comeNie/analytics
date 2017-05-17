/**
 * 季报定时器
 * @author gph
 */
package com.orienttech.statics.service.timedtask;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.orienttech.statics.commons.utils.Contants;

public class SeasonReportTask extends Task {
	private static final Logger logger = LoggerFactory
			.getLogger(SeasonReportTask.class);

	@Override
	public void doBiz() {
		logger.info("开始执行季报定时调度...");
		super.doBiz(Contants.CYCLE_SEASON);
	}
	
}
