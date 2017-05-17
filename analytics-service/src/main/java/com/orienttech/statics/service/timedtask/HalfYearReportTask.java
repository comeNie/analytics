/**
 * 半年报定时器
 * @author gph
 */
package com.orienttech.statics.service.timedtask;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.orienttech.statics.commons.utils.Contants;

public class HalfYearReportTask extends Task{
	private static final Logger logger = LoggerFactory
			.getLogger(HalfYearReportTask.class);
	
	@Override
	public void doBiz(){
		logger.info("开始执行半年报定时调度...");
		super.doBiz(Contants.CYCLE_HALF_YEAR);
	}
}
