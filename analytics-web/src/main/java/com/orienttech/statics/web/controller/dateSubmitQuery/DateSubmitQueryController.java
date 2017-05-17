package com.orienttech.statics.web.controller.dateSubmitQuery;

import java.util.Date;

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
import com.orienttech.statics.commons.base.BaseController;
import com.orienttech.statics.commons.base.Result;
import com.orienttech.statics.commons.datatables.DataTablesPage;
import com.orienttech.statics.commons.security.SessionUser;
import com.orienttech.statics.commons.utils.CommonHelper;
import com.orienttech.statics.dao.entity.submission.TblReportTemplate;
import com.orienttech.statics.dao.submission.TblReportTemplateDao;
import com.orienttech.statics.service.dateSubmitQuery.DateSubmitQueryService;
import com.orienttech.statics.service.model.submission.ReportTemplateVO;
import com.orienttech.statics.service.templateMng.TemplateMngService;


@Controller
@RequestMapping("/dateSubmitQuery")
public class DateSubmitQueryController extends BaseController {
	@Autowired
	private TemplateMngService templateMngService;
	
	@Autowired
	TblReportTemplateDao tblReportTemplateDao;
	
	@Autowired
	private DateSubmitQueryService dateSubmitQueryService;
	
	@Autowired
	private TblReportTemplateDao dateSubmitQueryDao;
	
	/**
	 * 根据报表类型加载不同的页面
	 * @param type	JSP名称
	 * @param model
	 * @return
	 */
	@RequestMapping
	public String index(@RequestParam(defaultValue="")String type,Model model){
		return "/dateSubmitQuery/"+type;
	}

	/**
	 * 数据报送查询
	 * @param draw
	 * @param firstIndex
	 * @param pageSize
	 * @param submitState
	 * @param startDateStr
	 * @param endDateStr
	 * @param name
	 * @param cycle
	 * @param orgName
	 * @return
	 */
	@RequestMapping(value = "/findDateSubmitList", method = RequestMethod.POST)
	@ResponseBody
	public DataTablesPage findList(Integer draw,
				@RequestParam("start") Integer firstIndex,
				@RequestParam("length") Integer pageSize, String submitState,
				String startDateStr, String endDateStr, String name,String cycle) {
		
		final SessionUser user=getSessionUser();
		
		Date startDate=CommonHelper.str2Date(startDateStr, CommonHelper.DF_DATE);
		Date endDate=CommonHelper.str2Date(endDateStr, CommonHelper.DF_DATE);
		
		Page<Object[]> page=dateSubmitQueryService.findTemplateList(firstIndex / pageSize, pageSize, submitState, startDate, endDate, name, cycle,user.getOrgCode());
		DataTablesPage dtPage=new DataTablesPage(draw, page);
		dtPage.setData(Lists.transform(page.getContent(), new Function<Object[], ReportTemplateVO>() {
			@Override
			public ReportTemplateVO apply(Object[] objs) {
				ReportTemplateVO reportTemplateVO =new ReportTemplateVO(objs);
				String str=tblReportTemplateDao.findOrgNameById(user.getOrgCode());
				reportTemplateVO.setOrgName(str);
				return reportTemplateVO;
			}
		}));
		
		return dtPage;
	}
	
	/**
	 * 根据模板id查找模板 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/findTemplateById", method = RequestMethod.POST)
	@ResponseBody
	public Result findTemplateById(int id,int submitId) {
		TblReportTemplate tblReportTemplate =dateSubmitQueryService.findReportTemplateById(id,submitId);
		String orgName =templateMngService.queryOrgNameByOrgId(tblReportTemplate.getSubmitOrg());
		String roleName = templateMngService.queryRoleNameByRoleId(tblReportTemplate.getCheckRole());
		String fileName = "";
		if(tblReportTemplate.getPath()!=null){
		   fileName = tblReportTemplate.getPath().substring(tblReportTemplate.getPath().lastIndexOf("/")+1);
		}
		tblReportTemplate.setSubmitOrg(orgName);
		tblReportTemplate.setCheckRole(roleName);
		tblReportTemplate.setPath(fileName);
		tblReportTemplate.setCreatePeople(
			dateSubmitQueryDao.getTblTemplateSubmitById(submitId).getRealPath());//暂用此字段
		return success(tblReportTemplate);
	}
	
	@RequestMapping(value = "/findDateSubmitById", method = RequestMethod.POST)
	@ResponseBody
	public Result findDateSubmitById(int id,String workflowId) {
		return success(dateSubmitQueryService.findDateSubmitById(id,workflowId));
	}
}
