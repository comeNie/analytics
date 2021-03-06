package com.orienttech.statics.web.controller.report;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.google.common.base.Function;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.orienttech.statics.commons.base.BaseController;
import com.orienttech.statics.commons.base.Result;
import com.orienttech.statics.commons.security.SessionUser;
import com.orienttech.statics.commons.utils.CommonHelper;
import com.orienttech.statics.commons.utils.Contants;
import com.orienttech.statics.commons.utils.FileUtils;
import com.orienttech.statics.service.model.report.AssetPackageInfo;
import com.orienttech.statics.service.model.sysmng.MenuBo;
import com.orienttech.statics.service.model.usermng.OrgDeptBo;
import com.orienttech.statics.service.report.BizReportService;
import com.orienttech.statics.service.report.thread.BuildReportProgress;
import com.orienttech.statics.service.sysmng.MenuService;
import com.orienttech.statics.service.usermng.OrgDeptService;
@RequestMapping("/bizReport")
@Controller
public class BizReportController extends BaseController {
	private int[] months={1,2,3,4,5,6,7,8,9,10,11,12};
	private final String SESSION_BUILD_REPORT_PROGRESS="BUILD_REPORT_PROGRESS";
	@Autowired
	private MenuService menuService;
	@Autowired
	private OrgDeptService orgDeptService;
	@Autowired
	private BizReportService bizReportService;
	
	/**
	 * TODO
	 * 根据报表类型加载不同的页面
	 * @param type	报表类型
	 * @param functionId	菜单id
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/store",method=RequestMethod.GET)
	public String store(@RequestParam(defaultValue="")String type,Long functionId,Model model){
		MenuBo bo=menuService.findMenu(functionId);
		SessionUser user=getSessionUser();
		
		model.addAttribute("menu", bo);
		model.addAttribute("user", user);
		model.addAttribute("orgs", orgDeptService.findOrgDeptListByOrgId(user.getOrgCode()));//所有机构
		
		//"K","L","N","O","P","Q"的报表需要资产包数据
		if(Arrays.asList("K","L","N","O","P","Q").contains(type)){
			model.addAttribute("apks", bizReportService.findAssetPackageInfo(user.getOrgCode()));
		}
		
		String orgId = user.getOrgCode();
		
		model.addAttribute("now", CommonHelper.date2Str(CommonHelper.getNow(),"yyyy-MM-dd"));//当前时间
		model.addAttribute("orgId", orgId);
		
		SessionUser curUser = getSessionUser();
		//加载组织机构(不含工作组)
		List<OrgDeptBo> list = orgDeptService.findOrgDeptListByOrgId("00");
		
		model.addAttribute("curUser", curUser);
		model.addAttribute("orgList", list);
		
		//当前系统时间
		String sysdate = new SimpleDateFormat("yyyy年MM月dd日").format(new Date());
		model.addAttribute("curYear", sysdate.substring(0,4));
		model.addAttribute("curMonth", sysdate.substring(5,7));
		
		Date now = CommonHelper.getNow();
		Calendar cal = Calendar.getInstance();
		String curYear = CommonHelper.date2Str(now, "yyyy");
		model.addAttribute("years", this.initYears(curYear));//年份
		model.addAttribute("months", months);//月份
		model.addAttribute("curYears", curYear);//当前年份
		model.addAttribute("curMonths", cal.get(Calendar.MONTH )+1);//当前月份
				
		String menuAction = menuService.findMenu(functionId).getAction();
		String actionType = menuService.findMenu(functionId).getActionType();
		
		if(actionType.equalsIgnoreCase("SYS")){
			return "/report/"+menuAction;
		}
		
		return "/report/bizReport"+type;
	}
	
	/**
	 * 根据报表类型加载不同的页面
	 * @param type	报表类型
	 * @param functionId	菜单id
	 * @param model
	 * @return
	 */
	@RequestMapping
	public String index(@RequestParam(defaultValue="")String type,Long functionId,Model model){
		MenuBo bo=menuService.findMenu(functionId);
		SessionUser user=getSessionUser();
		model.addAttribute("menu", bo);
		model.addAttribute("user", user);
		//所有机构
		model.addAttribute("orgs", orgDeptService.findOrgDeptListByOrgId(user.getOrgCode()));
		//"K","L","N","O","P","Q"的报表需要资产包数据
		if(Arrays.asList("K","L","N","O","P","Q").contains(type)){
			model.addAttribute("apks", bizReportService.findAssetPackageInfo(user.getOrgCode()));
		}
		String orgId = user.getOrgCode();
		model.addAttribute("now", CommonHelper.date2Str(CommonHelper.getNow(),"yyyy-MM-dd"));//当前时间
		model.addAttribute("orgId", orgId);
		return "/report/bizReport"+type;
	}
	/**
	 *  加载资产包
	 * @return
	 */
	@RequestMapping("/loadApksData")
	@ResponseBody
	public List<AssetPackageInfo> loadApksData(){
		SessionUser user=getSessionUser();
		return bizReportService.findAssetPackageInfo(user.getOrgCode());
	}
	/**
	 * 加载组织机构
	 * @return
	 */
	@RequestMapping("/loadOrgDeptsData")
	@ResponseBody
	public List<OrgDeptBo> loadOrgDeptsData(){
		SessionUser user=getSessionUser();
		return orgDeptService.findOrgDeptListByOrgId(user.getOrgCode());
	}
	/**
	 * 加载组织机构(不含工作组)
	 * @return
	 */
	@RequestMapping("/loadOrgDeptsDataExcTeam")
	@ResponseBody
	public List<OrgDeptBo> loadOrgDeptsDataExcTeam(){
		SessionUser user=getSessionUser();
		return orgDeptService.findOrgDeptListByOrgId("00");
	//public Result loadOrgDeptsDataExcTeam(){
//		List<OrgDeptBo> orgList = orgDeptService.findOrgDeptListByOrgId("00");
//		List<String> list = new ArrayList<String>();
//		if(orgList.size()>0 && !orgList.isEmpty()){
//			for(OrgDeptBo bo : orgList){
//				String desc = bo.getDesc();
//				list.add(desc);
//			}
//		}
//		return success(list);
	}
	/**
	 * 加载资金来源
	 * @return
	 */
	@RequestMapping("/loadFundSource")
	@ResponseBody
	public List<OrgDeptBo> loadFundSource(){
		SessionUser user=getSessionUser();
		return orgDeptService.findFundSource();
	}
	/**
	 * 查询历史报表
	 * @param functionId
	 * @param model
	 * @return
	 */
	@RequestMapping("/queryHistoryList")
	public String queryHistoryList(Long functionId,Model model){
		model.addAttribute("menu", menuService.findMenu(functionId));
		return "/report/brHistoryList";
	}
	/**
	 * TODO
	 * 初始化报表页面
	 * @param functionId
	 * @param model
	 * @return
	 */
//	@RequestMapping(value="/createReport",method=RequestMethod.GET)
//	public String createReoprt(Long functionId, Model model){
//		SessionUser user=getSessionUser();
//		model.addAttribute("menu", menuService.findMenu(functionId));
//		model.addAttribute("curUser", user);
//		model.addAttribute("orgs", orgDeptService.findOrgDeptListByOrgId(user.getOrgCode()));
//		Date now = CommonHelper.getNow();
//		Calendar cal = Calendar.getInstance();
//		String curYear = CommonHelper.date2Str(now, "yyyy");
//		model.addAttribute("years", this.initYears(curYear));//年份
//		model.addAttribute("months", months);//月份
//		model.addAttribute("curYear", curYear);//当前年份
//		model.addAttribute("curMonth", cal.get(Calendar.MONTH )+1);//当前月份
//		return "/report/brCreateReoprt";
//	}
	/**
	 * 启动线程
	 * @param orgCd
	 * @param year
	 * @param month
	 * @param req
	 * @return
	 */
	@RequestMapping(value="/createReport",method=RequestMethod.POST)
	@ResponseBody
	public Result createReportByThread(@RequestParam(defaultValue = "") String orgCd,
			String year, String month,HttpServletRequest req){
		HttpSession session=req.getSession();
		String orgName = this.getOrgName(orgCd);
		BuildReportProgress progress = new BuildReportProgress(
				bizReportService, this.handleParamsOfCreateReport(orgCd), year,
				month, orgName, this.getTempletName(orgCd));
		session.setAttribute(SESSION_BUILD_REPORT_PROGRESS, progress);
		progress.start();
		return success("正在生成报表");
	}
	/**
	 * 获取进度
	 * @param req
	 * @param progressRatio 当前进度比例
	 * @return
	 */
	@RequestMapping("/getProgress")
	@ResponseBody
	public Result progress(
			@RequestParam(defaultValue = "0", value = "progressRatio") double progressRatio,
			@RequestParam(defaultValue = "0", value = "pageStep", required = false) int pageStep, 
			HttpServletRequest req) {
		HttpSession session = req.getSession();
		BuildReportProgress progress = (BuildReportProgress) session.getAttribute(SESSION_BUILD_REPORT_PROGRESS);
		Map<String, Object> data = Maps.newHashMap();
		if(progress == null){
			return failure("生成报表失败，请稍后重试");
		}
		if(progress.isFailed()){
			progress.interrupt();
			return failure(progress.getPercent());
		}
		data.put("over", progress.isOver());
		data.put("content", progress.getPercent());
		//data.put("progressRatio", this.handleProgressRatio(progressRatio, progress.getProgressRatio()));
		
		//data.put("progressRatio", this.handleProgressRatioByStep(pageStep, progress.getStep(), progressRatio, progress.getProgressRatio()));
		data.put("progressRatio", progress.getProgressRatio());
		data.put("reportPath", progress.getReportPath());
		data.put("pageStep", progress.getStep());
		return success("", data);
	}
	/**
	 * 下载
	 * @param reportPath
	 * @param req
	 * @param resp
	 */
	@RequestMapping("/download")
	public void download(String reportPath,HttpServletRequest req,HttpServletResponse resp){
		HttpSession session=req.getSession();
		BuildReportProgress progress=(BuildReportProgress) session.getAttribute(SESSION_BUILD_REPORT_PROGRESS);
		try {
			if(progress!=null){
				FileUtils.downloadFile(new File(progress.getReportPath()), progress.getReportName() + ".doc", req, resp);
				progress.interrupt();//终止线程
				session.removeAttribute(SESSION_BUILD_REPORT_PROGRESS);
			}
		} catch (IOException e) {
			logger.error("下载失败");
		}
	}
	/**
	 * @param orgCd
	 * @param year
	 * @param month
	 * @param req
	 * @param resp
	 */
	@RequestMapping("/downloadReport")
	@Deprecated
	public void downloadReport(@RequestParam(defaultValue = "") String orgCd,
			String year, String month,HttpServletRequest req,HttpServletResponse resp) {
		String filePath=bizReportService.buildMergeReport(orgCd, year, month);
		//String filePath=ServerInfoHelper.getTempReportPath()+File.separator+"mergeReport.pdf";
		try {
			FileUtils.downloadFile(new File(filePath), "邦信小贷公司财务及经营情况月报.pdf", req, resp);
		} catch (IOException e) {
			logger.error("下载失败");
		}
		
	}
	/**
	 * 初始化年份
	 * @param curYear
	 * @return
	 */
	private List<String> initYears(String curYear){
		int startYear= Integer.parseInt(curYear)+5;
		List<String> list=Lists.newArrayList();
		for (int i = startYear; i >= 2012; i--) {
			list.add(String.valueOf(i));
		}
		return list;
	}
	/**
	 * 处理进度条比例<br/>
	 * 如果没有改变则自增0.02否则更新
	 * @param progressRatio
	 * @param new_progressRatio
	 * @return
	 */
	@Deprecated
	private double handleProgressRatio(double progressRatio,double new_progressRatio){
		BigDecimal bd=new BigDecimal(progressRatio==new_progressRatio?(progressRatio+0.02):new_progressRatio);
		return bd.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
	}
	
	/**
	 * 处理进度条比例<br/>
	 * 如果没有改变则自增0.00否则更新
	 * @param progressRatio
	 * @param new_progressRatio
	 * @return
	 */
	@Deprecated
	private double handleProgressRatioByStep(int pageStep, int nextStep,
			double oldProgressRatio, double nextProgressRatio) {
		double progressRatio = 0d;
		if (pageStep == nextStep) {
			progressRatio = oldProgressRatio + 0.00;
		} else {
			progressRatio = nextProgressRatio;
		}
		BigDecimal bd=new BigDecimal(progressRatio);
		return bd.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
	}
	
	/**
	 * 生成报表的组织机构处理<br/>
	 * 如果为空，则查询全部机构
	 * @param orgCd
	 * @return
	 */
	private String handleParamsOfCreateReport(String orgCd){
		System.out.println(StringUtils.isNoneBlank(orgCd) + "=============" + orgCd);
		/*if(StringUtils.isNoneBlank(orgCd)){
			return orgCd;
		}*/
		List<OrgDeptBo> orgs = null;
		if ("".equals(orgCd)) {
			orgs = orgDeptService.findOrgDeptListByOrgId("");
		} else if ("0".equals(orgCd)) {
			orgs = orgDeptService.findOrgDeptListByOrgId("0");
		} else if ("01".equals(orgCd)) {
			orgs = orgDeptService.findOrgDeptListByOrgId("01");
		} else if ("02".equals(orgCd)) {
			orgs = orgDeptService.findOrgDeptListByOrgId("02");
		} else if (orgCd == null) {
			orgs = orgDeptService.findOrgDeptListByOrgId(getSessionUser().getOrgCode());
		} else {
			return orgCd;
		}
		
		if(CollectionUtils.isEmpty(orgs)){
			return StringUtils.EMPTY;
		}
		List<String> orgCds=Lists.transform(orgs, new Function<OrgDeptBo, String>() {
			@Override
			public String apply(OrgDeptBo org) {
				return org.getId();
			}
		});
		if(CollectionUtils.isEmpty(orgCds)){
			return StringUtils.EMPTY;
		}
		return StringUtils.join(new HashSet<String>(orgCds), ",");
	}
	
	
	/**
	 * 获得机构名称<br/>
	 * @param orgCd
	 * @return
	 */
	private String getOrgName(String orgCd){
		if(StringUtils.isBlank(orgCd)){
			return StringUtils.EMPTY;
		}
		return orgDeptService.findOrgNametListByOrgId(orgCd);
	}
	
	/**
	 * 生成报表的组织机构处理<br/>
	 * 如果为空，则查询全部机构
	 * @param orgCd
	 * @return
	 */
	private String getTempletName(String orgCd){
		if("".equals(orgCd)||"02".equals(orgCd)){
			return Contants.ALL_TEMPLET;
		} else if("0".equals(orgCd)||"01".equals(orgCd)){
			return Contants.XD_TEMPLET;
		} else {
			return Contants.SIG_TEMPLET;
		}
	}
}
