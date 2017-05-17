package com.orienttech.statics.web.controller.reportSumQuery;



import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.common.base.Function;
import com.google.common.collect.Lists;
import com.orienttech.statics.dao.UserSsoDao;
import com.orienttech.statics.dao.entity.PassRead;
import com.orienttech.statics.commons.base.BaseController;
import com.orienttech.statics.commons.base.Result;
import com.orienttech.statics.commons.datatables.DataTablesPage;
import com.orienttech.statics.commons.security.SessionUser;
import com.orienttech.statics.commons.utils.CommonHelper;
import com.orienttech.statics.dao.entity.UserSso;
import com.orienttech.statics.service.model.submission.ReportSumVo;
import com.orienttech.statics.service.model.submission.SubmitDetailVO;
import com.orienttech.statics.service.model.sysmng.MenuBo;
import com.orienttech.statics.service.model.usermng.OrgDeptBo;
import com.orienttech.statics.service.reportResultQuery.ReportResultQueryService;
import com.orienttech.statics.service.reportSumQuery.ReportSumQueryService;
import com.orienttech.statics.service.submitDetailQuery.SubmitDetailQueryService;
import com.orienttech.statics.service.sysmng.RoleMngService;
import com.orienttech.statics.service.usermng.UserMngService;
@RequestMapping("/reportSumQuery")
@Controller
public class ReportSumQueryController extends BaseController {
	
	@Autowired
	private ReportSumQueryService reportSumQueryService;
	@Autowired
	private UserSsoDao userSsoDao;
	
	@RequestMapping
	public String index(Long functionId,Model model){
		
		return "/reportSumQuery/reportSumQuery";
	}
	
	/**
	 * TODO
	 * @param draw
	 * @param firstIndex
	 * @param pageSize
	 * @param startDateStr
	 * @param endDateStr
	 * @param reportName
	 * @param orgName
	 * @return
	 */
	@RequestMapping(value = "/findSumDetailList", method = RequestMethod.POST)
	@ResponseBody
	public DataTablesPage findSumDetailList(Integer draw,
			@RequestParam("start") Integer firstIndex,
			@RequestParam("length") Integer pageSize,
			String startDateStr, String endDateStr, String reportName, String orgName) {
		
		Date startTime = CommonHelper.str2Date(startDateStr,CommonHelper.DF_DATE);
		Date endTime = CommonHelper.str2Date(endDateStr, CommonHelper.DF_DATE);
		
		Page<Object[]> page = reportSumQueryService.findSumDetailList(firstIndex / pageSize, pageSize, startTime, endTime, reportName, orgName);
		
		DataTablesPage dtPage = new DataTablesPage(draw, page);
		dtPage.setData(Lists.transform(page.getContent(),
				new Function<Object[], ReportSumVo>() {
					@Override
					public ReportSumVo apply(Object[] objs) {
						ReportSumVo reportSumVo = new ReportSumVo(objs);
						//迟报天数
						Date releaseTime = reportSumVo.getReleaseTime();
						Date firstSubTime = reportSumVo.getFirstSubTime();
						String lateDays = "0";
						//TODO
						if(releaseTime != null && firstSubTime != null){
							Long timeLimit = Long.valueOf(reportSumVo.getTimeLimit());
//							lateDays = String.valueOf((firstSubTime.getTime()-releaseTime.getTime())/(1000 * 60 * 60 *24));
							Long late = (firstSubTime.getTime()-releaseTime.getTime())/(1000 * 60 * 60 *24)-timeLimit;
							lateDays = late>0?late.toString():"0";
						}
						reportSumVo.setLateDays(lateDays);
						//填报人
						String subPeople = userSsoDao.queryUserNameBySsoId(reportSumVo.getSubPeople());
						reportSumVo.setSubPeople(subPeople);
						//审核人
						String examinePeople = userSsoDao.queryUserNameBySsoId(reportSumVo.getExaminePeople());
						reportSumVo.setExaminePeople(examinePeople);
						
						return reportSumVo;
					}
				}));

		return dtPage;
	}

	
}
