package com.orienttech.statics.web.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.orienttech.statics.commons.base.BaseController;
import com.orienttech.statics.commons.dynamicquery.DynamicQuery;
import com.orienttech.statics.commons.security.SessionUser;
import com.orienttech.statics.service.model.ColumnAndLineChartInfo;
import com.orienttech.statics.service.model.LineChartInfo;
import com.orienttech.statics.service.model.sysmng.MenuBo;
import com.orienttech.statics.service.sysmng.DashboardService;
@RequestMapping("/dashboard")
@Controller
public class DashboardController extends BaseController {
	Log log=LogFactory.getLog(DashboardController.class);
	@Autowired
	private DashboardService dashboardService;
	@Autowired
	private DynamicQuery dynamicQuery;
	@RequestMapping
	public String index(Model model){
		SessionUser sUser=getSessionUser();
		String orgId=getSessionUser().getOrgCode();
		String userRoleId = sUser.getRoleId();
		String [] roleId = userRoleId.split(",");
		List<String> llist = new ArrayList<String>();
		for(String str :roleId){
			llist.add(str.toString());
		}
		StringBuffer strBuffer = new StringBuffer();
		strBuffer.append("select distinct PICTURE_ID from TBL_COGNOS_DASHBOARD_SHOW where role_id in (?1) ");
		List<String> list =dynamicQuery.nativeQuery(String.class, strBuffer.toString(), llist);
		
		String listToString = org.apache.commons.lang.StringUtils.join(list.toArray(),",");
		model.addAttribute("listToString", listToString);
		if(listToString.contains("2001001")){
			StringBuffer strBuffer1_1 = new StringBuffer();
			List<String> list1_1 = new ArrayList<String>();
			List<Object> params1_1 = new ArrayList<Object>();
			StringBuffer strBuffer1_2 = new StringBuffer();
			List<String> list1_2 = new ArrayList<String>();
			List<Object> params1_2 = new ArrayList<Object>();
			if("10001".equals(orgId)){
				strBuffer1_1.append(" select trim(to_char(SUM(amt)/10000,'999,999,999,999,990')) amt from fact_loan_dashboard  ");
				strBuffer1_1.append(" where 1=1 and busi_month >= to_char( trunc(sysdate,'yyyy' )-365,'yyyymm') and busi_month <= to_char( trunc(sysdate,'dd'),'yyyymm')  ");
				strBuffer1_1.append(" and DASHBOARD_ID='A01' ");
				strBuffer1_1.append(" group by busi_month order by busi_month");
			    list1_1 = dynamicQuery.nativeQuery(String.class, strBuffer1_1.toString());
			    
			    strBuffer1_2.append(" select SUM(amt) amt from fact_loan_dashboard  ");
			    strBuffer1_2.append(" where 1=1 and busi_month >= to_char( trunc(sysdate,'yyyy' )-365,'yyyymm') and busi_month <= to_char( trunc(sysdate,'dd'),'yyyymm')  ");
			    strBuffer1_2.append(" and DASHBOARD_ID='A02' ");
			    strBuffer1_2.append(" group by busi_month order by busi_month");
			    list1_2 = dynamicQuery.nativeQuery(String.class, strBuffer1_2.toString());
			}else{
				strBuffer1_1.append(" select trim(to_char(SUM(amt)/10000,'999,999,999,999,990')) amt from fact_loan_dashboard  ");
				strBuffer1_1.append(" where 1=1 and busi_month >= to_char( trunc(sysdate,'yyyy' )-365,'yyyymm') and busi_month <= to_char( trunc(sysdate,'dd'),'yyyymm')  ");
				strBuffer1_1.append(" and DASHBOARD_ID='A01' and ORG_ID=?1 ");
				strBuffer1_1.append(" group by busi_month order by busi_month");
				params1_1.add(orgId);
				list1_1 = dynamicQuery.nativeQuery(String.class, strBuffer1_1.toString(), params1_1.toArray());
				
				strBuffer1_2.append(" select SUM(amt) amt from fact_loan_dashboard  ");
				strBuffer1_2.append(" where 1=1 and busi_month >= to_char( trunc(sysdate,'yyyy' )-365,'yyyymm') and busi_month <= to_char( trunc(sysdate,'dd'),'yyyymm')  ");
				strBuffer1_2.append(" and DASHBOARD_ID='A02' and ORG_ID=?1 ");
				strBuffer1_2.append(" group by busi_month order by busi_month");
				params1_2.add(orgId);
				list1_2 = dynamicQuery.nativeQuery(String.class, strBuffer1_2.toString(), params1_2.toArray());
			}
			
			String list11 = org.apache.commons.lang.StringUtils.join(list1_1.toArray(),"@");
			model.addAttribute("list11", list11);
			String list12 = org.apache.commons.lang.StringUtils.join(list1_2.toArray(),",");
			model.addAttribute("list12", list12);
		}
		
		if(listToString.contains("2001002")){
			StringBuffer strBuffer2_1 = new StringBuffer();
			List<String> list2_1 = new ArrayList<String>();
			List<Object> params2_1 = new ArrayList<Object>();
			StringBuffer strBuffer2_2 = new StringBuffer();
			List<String> list2_2 = new ArrayList<String>();
			List<Object> params2_2 = new ArrayList<Object>();
			StringBuffer strBuffer2_3 = new StringBuffer();
			List<String> list2_3 = new ArrayList<String>();
			List<Object> params2_3 = new ArrayList<Object>();
			if("10001".equals(orgId)){
				strBuffer2_1.append(" select trim(to_char(SUM(amt)/10000,'999,999,999,999,990')) amt from fact_loan_dashboard  ");
				strBuffer2_1.append(" where 1=1 and busi_month >= to_char( trunc(sysdate,'yyyy' )-365,'yyyymm') and busi_month <= to_char( trunc(sysdate,'dd'),'yyyymm')  ");
				strBuffer2_1.append(" and DASHBOARD_ID='A03' ");
				strBuffer2_1.append(" group by busi_month order by busi_month");
				list2_1 = dynamicQuery.nativeQuery(String.class, strBuffer2_1.toString());
			    
			    strBuffer2_2.append(" select SUM(amt) amt from fact_loan_dashboard  ");
			    strBuffer2_2.append(" where 1=1 and busi_month >= to_char( trunc(sysdate,'yyyy' )-365,'yyyymm') and busi_month <= to_char( trunc(sysdate,'dd'),'yyyymm')  ");
			    strBuffer2_2.append(" and DASHBOARD_ID='A04' ");
			    strBuffer2_2.append(" group by busi_month order by busi_month");
			    list2_2 = dynamicQuery.nativeQuery(String.class, strBuffer2_2.toString());
			    
			    strBuffer2_3.append(" select SUM(amt) amt from fact_loan_dashboard  ");
			    strBuffer2_3.append(" where 1=1 and busi_month >= to_char( trunc(sysdate,'yyyy' )-365,'yyyymm') and busi_month <= to_char( trunc(sysdate,'dd'),'yyyymm')  ");
			    strBuffer2_3.append(" and DASHBOARD_ID='A05' ");
			    strBuffer2_3.append(" group by busi_month order by busi_month");
			    list2_3 = dynamicQuery.nativeQuery(String.class, strBuffer2_3.toString());
			}else{
				strBuffer2_1.append(" select trim(to_char(SUM(amt)/10000,'999,999,999,999,990')) amt from fact_loan_dashboard  ");
				strBuffer2_1.append(" where 1=1 and busi_month >= to_char( trunc(sysdate,'yyyy' )-365,'yyyymm') and busi_month <= to_char( trunc(sysdate,'dd'),'yyyymm')  ");
				strBuffer2_1.append(" and DASHBOARD_ID='A03' and ORG_ID=?1 ");
				strBuffer2_1.append(" group by busi_month order by busi_month");
				params2_1.add(orgId);
				list2_1 = dynamicQuery.nativeQuery(String.class, strBuffer2_1.toString(), params2_1.toArray());
				
				strBuffer2_2.append(" select SUM(amt) amt from fact_loan_dashboard  ");
				strBuffer2_2.append(" where 1=1 and busi_month >= to_char( trunc(sysdate,'yyyy' )-365,'yyyymm') and busi_month <= to_char( trunc(sysdate,'dd'),'yyyymm')  ");
				strBuffer2_2.append(" and DASHBOARD_ID='A04' and ORG_ID=?1 ");
				strBuffer2_2.append(" group by busi_month order by busi_month");
				params2_2.add(orgId);
				list2_2 = dynamicQuery.nativeQuery(String.class, strBuffer2_2.toString(), params2_2.toArray());
				
				strBuffer2_3.append(" select SUM(amt) amt from fact_loan_dashboard  ");
				strBuffer2_3.append(" where 1=1 and busi_month >= to_char( trunc(sysdate,'yyyy' )-365,'yyyymm') and busi_month <= to_char( trunc(sysdate,'dd'),'yyyymm')  ");
				strBuffer2_3.append(" and DASHBOARD_ID='A05' and ORG_ID=?1 ");
				strBuffer2_3.append(" group by busi_month order by busi_month");
				params2_3.add(orgId);
				list2_3 = dynamicQuery.nativeQuery(String.class, strBuffer2_3.toString(), params2_3.toArray());
			}
			
			String list21 = org.apache.commons.lang.StringUtils.join(list2_1.toArray(),"@");
			model.addAttribute("list21", list21);
			String list22 = org.apache.commons.lang.StringUtils.join(list2_2.toArray(),",");
			model.addAttribute("list22", list22);
			String list23 = org.apache.commons.lang.StringUtils.join(list2_3.toArray(),",");
			model.addAttribute("list23", list23);
		}
		
		if(listToString.contains("2001003")){
			StringBuffer strBuffer3_1 = new StringBuffer();
			List<String> list3_1 = new ArrayList<String>();
			List<Object> params3_1 = new ArrayList<Object>();
			StringBuffer strBuffer3_2 = new StringBuffer();
			List<String> list3_2 = new ArrayList<String>();
			List<Object> params3_2 = new ArrayList<Object>();
			StringBuffer strBuffer3_3 = new StringBuffer();
			List<String> list3_3 = new ArrayList<String>();
			List<Object> params3_3 = new ArrayList<Object>();
			if("10001".equals(orgId)){
				strBuffer3_1.append(" select trim(to_char(SUM(amt)/10000,'999,999,999,999,990')) amt from fact_loan_dashboard  ");
				strBuffer3_1.append(" where 1=1 and busi_month >= to_char( trunc(sysdate,'yyyy' )-365,'yyyymm') and busi_month <= to_char( trunc(sysdate,'dd'),'yyyymm')  ");
				strBuffer3_1.append(" and DASHBOARD_ID='A06' ");
				strBuffer3_1.append(" group by busi_month order by busi_month");
			    list3_1 = dynamicQuery.nativeQuery(String.class, strBuffer3_1.toString());
			    
			    strBuffer3_2.append(" select trim(to_char(SUM(amt)/10000,'999,999,999,999,990')) amt from fact_loan_dashboard  ");
			    strBuffer3_2.append(" where 1=1 and busi_month >= to_char( trunc(sysdate,'yyyy' )-365,'yyyymm') and busi_month <= to_char( trunc(sysdate,'dd'),'yyyymm')  ");
			    strBuffer3_2.append(" and DASHBOARD_ID='A07' ");
			    strBuffer3_2.append(" group by busi_month order by busi_month");
			    list3_2 = dynamicQuery.nativeQuery(String.class, strBuffer3_2.toString());
			    
			    strBuffer3_3.append(" select trim(to_char(SUM(amt)/10000,'999,999,999,999,990')) amt from fact_loan_dashboard  ");
			    strBuffer3_3.append(" where 1=1 and busi_month >= to_char( trunc(sysdate,'yyyy' )-365,'yyyymm') and busi_month <= to_char( trunc(sysdate,'dd'),'yyyymm')  ");
			    strBuffer3_3.append(" and DASHBOARD_ID='A12' ");
			    strBuffer3_3.append(" group by busi_month order by busi_month");
			    list3_3 = dynamicQuery.nativeQuery(String.class, strBuffer3_3.toString());
			}else{
				strBuffer3_1.append(" select trim(to_char(SUM(amt)/10000,'999,999,999,999,990')) amt from fact_loan_dashboard  ");
				strBuffer3_1.append(" where 1=1 and busi_month >= to_char( trunc(sysdate,'yyyy' )-365,'yyyymm') and busi_month <= to_char( trunc(sysdate,'dd'),'yyyymm')  ");
				strBuffer3_1.append(" and DASHBOARD_ID='A06' and ORG_ID=?1 ");
				strBuffer3_1.append(" group by busi_month order by busi_month");
				params3_1.add(orgId);
				list3_1 = dynamicQuery.nativeQuery(String.class, strBuffer3_1.toString(), params3_1.toArray());
				
				strBuffer3_2.append(" select trim(to_char(SUM(amt)/10000,'999,999,999,999,990')) amt from fact_loan_dashboard  ");
				strBuffer3_2.append(" where 1=1 and busi_month >= to_char( trunc(sysdate,'yyyy' )-365,'yyyymm') and busi_month <= to_char( trunc(sysdate,'dd'),'yyyymm')  ");
				strBuffer3_2.append(" and DASHBOARD_ID='A07' and ORG_ID=?1 ");
				strBuffer3_2.append(" group by busi_month order by busi_month");
				params3_2.add(orgId);
				list3_2 = dynamicQuery.nativeQuery(String.class, strBuffer3_2.toString(), params3_2.toArray());
				
				strBuffer3_3.append(" select trim(to_char(SUM(amt)/10000,'999,999,999,999,990')) amt from fact_loan_dashboard  ");
				strBuffer3_3.append(" where 1=1 and busi_month >= to_char( trunc(sysdate,'yyyy' )-365,'yyyymm') and busi_month <= to_char( trunc(sysdate,'dd'),'yyyymm')  ");
				strBuffer3_3.append(" and DASHBOARD_ID='A12' and ORG_ID=?1 ");
				strBuffer3_3.append(" group by busi_month order by busi_month");
				params3_3.add(orgId);
				list3_3 = dynamicQuery.nativeQuery(String.class, strBuffer3_3.toString(), params3_3.toArray());
			}
			
			String list31 = org.apache.commons.lang.StringUtils.join(list3_1.toArray(),"@");
			model.addAttribute("list31", list31);
			String list32 = org.apache.commons.lang.StringUtils.join(list3_2.toArray(),"@");
			model.addAttribute("list32", list32);
			String list33 = org.apache.commons.lang.StringUtils.join(list3_3.toArray(),"@");
			model.addAttribute("list33", list33);
		}
		
		if(listToString.contains("2001004")){
			StringBuffer strBuffer4_1 = new StringBuffer();
			List<String> list4_1 = new ArrayList<String>();
			List<Object> params4_1 = new ArrayList<Object>();
			StringBuffer strBuffer4_2 = new StringBuffer();
			List<String> list4_2 = new ArrayList<String>();
			List<Object> params4_2 = new ArrayList<Object>();
			if("10001".equals(orgId)){
				strBuffer4_1.append(" select trim(to_char(SUM(amt)/10000,'999,999,999,999,990')) amt from fact_loan_dashboard  ");
				strBuffer4_1.append(" where 1=1 and busi_month >= to_char( trunc(sysdate,'yyyy' )-365,'yyyymm') and busi_month <= to_char( trunc(sysdate,'mm')+365,'yyyymm')  ");
				strBuffer4_1.append(" and DASHBOARD_ID='A08' ");
				strBuffer4_1.append(" group by busi_month order by busi_month");
			    list4_1 = dynamicQuery.nativeQuery(String.class, strBuffer4_1.toString());
			    
			    strBuffer4_2.append(" select trim(to_char(SUM(amt)/10000,'999,999,999,999,990')) amt from fact_loan_dashboard  ");
			    strBuffer4_2.append(" where 1=1 and busi_month >= to_char( trunc(sysdate,'yyyy' )-365,'yyyymm') and busi_month <= to_char( trunc(sysdate,'mm')+365,'yyyymm')  ");
			    strBuffer4_2.append(" and DASHBOARD_ID='A09' ");
			    strBuffer4_2.append(" group by busi_month order by busi_month");
			    list4_2 = dynamicQuery.nativeQuery(String.class, strBuffer4_2.toString());
			}else{
				strBuffer4_1.append(" select trim(to_char(SUM(amt)/10000,'999,999,999,999,990')) amt from fact_loan_dashboard  ");
				strBuffer4_1.append(" where 1=1 and busi_month >= to_char( trunc(sysdate,'yyyy' )-365,'yyyymm') and busi_month <= to_char( trunc(sysdate,'mm')+365,'yyyymm')  ");
				strBuffer4_1.append(" and DASHBOARD_ID='A08' and ORG_ID=?1 ");
				strBuffer4_1.append(" group by busi_month order by busi_month");
				params4_1.add(orgId);
				list4_1 = dynamicQuery.nativeQuery(String.class, strBuffer4_1.toString(), params4_1.toArray());
				
				strBuffer4_2.append(" select trim(to_char(SUM(amt)/10000,'999,999,999,999,990')) amt from fact_loan_dashboard  ");
				strBuffer4_2.append(" where 1=1 and busi_month >= to_char( trunc(sysdate,'yyyy' )-365,'yyyymm') and busi_month <= to_char( trunc(sysdate,'mm')+365,'yyyymm')  ");
				strBuffer4_2.append(" and DASHBOARD_ID='A09' and ORG_ID=?1 ");
				strBuffer4_2.append(" group by busi_month order by busi_month");
				params4_2.add(orgId);
				list4_2 = dynamicQuery.nativeQuery(String.class, strBuffer4_2.toString(), params4_2.toArray());
			}
			
			String list41 = org.apache.commons.lang.StringUtils.join(list4_1.toArray(),"@");
			model.addAttribute("list41", list41);
			String list42 = org.apache.commons.lang.StringUtils.join(list4_2.toArray(),"@");
			model.addAttribute("list42", list42);
		}
		
		if(listToString.contains("2001005")){
			StringBuffer strBuffer5_1 = new StringBuffer();
			List<String> list5_1 = new ArrayList<String>();
			List<Object> params5_1 = new ArrayList<Object>();
			StringBuffer strBuffer5_2 = new StringBuffer();
			List<String> list5_2 = new ArrayList<String>();
			List<Object> params5_2 = new ArrayList<Object>();
			StringBuffer strBuffer5_3 = new StringBuffer();
			List<String> list5_3 = new ArrayList<String>();
			List<Object> params5_3 = new ArrayList<Object>();
			StringBuffer strBuffer5_4 = new StringBuffer();
			List<String> list5_4 = new ArrayList<String>();
			List<Object> params5_4 = new ArrayList<Object>();
			StringBuffer strBuffer5_5 = new StringBuffer();
			List<String> list5_5 = new ArrayList<String>();
			List<Object> params5_5 = new ArrayList<Object>();
			
			if("10001".equals(orgId)){
				strBuffer5_1.append(" select to_char(ROUND(amt*100,2),'9999999999990.00') amt from fact_loan_dashboard  ");
				strBuffer5_1.append(" where 1=1 and busi_month >= to_char( trunc(sysdate,'yyyy' )-365,'yyyymm') and busi_month <= to_char( trunc(sysdate,'dd'),'yyyymm') ");
				strBuffer5_1.append(" and DASHBOARD_ID='A10' AND ORG_ID = '99999' ");
				strBuffer5_1.append(" order by busi_month");
			    list5_1 = dynamicQuery.nativeQuery(String.class, strBuffer5_1.toString());
			    
			    strBuffer5_2.append(" select to_char(ROUND(amt*100,2),'9999999999990.00') amt from fact_loan_dashboard  ");
			    strBuffer5_2.append(" where 1=1 and busi_month >= to_char( trunc(sysdate,'yyyy' )-365,'yyyymm') and busi_month <= to_char( trunc(sysdate,'dd'),'yyyymm') ");
			    strBuffer5_2.append(" and DASHBOARD_ID='A11' AND ORG_ID = '99999' ");
			    strBuffer5_2.append(" order by busi_month");
			    list5_2 = dynamicQuery.nativeQuery(String.class, strBuffer5_2.toString());
			    
			    strBuffer5_3.append("select to_char(ROUND(a.amt,2),'9999999999990.00') atm from (select ORG_NAME ORG_NAME,ROUND(amt*100,2) amt from fact_loan_dashboard where 1=1 and DASHBOARD_ID='A10' and ORG_ID <> '99999' and APPLY_USER_NAME IS NULL and BUSI_MONTH = TO_CHAR(SYSDATE, 'yyyymm') ) a left join (select ORG_NAME ORG_NAME,ROUND(amt*100,2) num from fact_loan_dashboard where 1=1 and DASHBOARD_ID='A11' and ORG_ID <> '99999' and APPLY_USER_NAME IS NULL and BUSI_MONTH = TO_CHAR(SYSDATE, 'yyyymm') ) b on a.ORG_NAME=b.ORG_NAME order by a.amt,nlssort( a.ORG_NAME,'NLS_SORT=SCHINESE_PINYIN_M')");
			    list5_3 = dynamicQuery.nativeQuery(String.class, strBuffer5_3.toString());
			    
			    strBuffer5_4.append("select to_char(ROUND(b.num,2),'9999999999990.00') atm from (select ORG_NAME ORG_NAME,ROUND(amt*100,2) amt from fact_loan_dashboard where 1=1 and DASHBOARD_ID='A10' and ORG_ID <> '99999' and APPLY_USER_NAME IS NULL and BUSI_MONTH = TO_CHAR(SYSDATE, 'yyyymm') ) a left join (select ORG_NAME ORG_NAME,ROUND(amt*100,2) num from fact_loan_dashboard where 1=1 and DASHBOARD_ID='A11' and ORG_ID <> '99999' and APPLY_USER_NAME IS NULL and BUSI_MONTH = TO_CHAR(SYSDATE, 'yyyymm') ) b on a.ORG_NAME=b.ORG_NAME order by a.amt,nlssort( a.ORG_NAME,'NLS_SORT=SCHINESE_PINYIN_M')");
			    list5_4 = dynamicQuery.nativeQuery(String.class, strBuffer5_4.toString());
			    
			    strBuffer5_5.append("select a.ORG_NAME from (select ORG_NAME ORG_NAME,ROUND(amt*100,2) amt from fact_loan_dashboard where 1=1 and DASHBOARD_ID='A10' and ORG_ID <> '99999' and APPLY_USER_NAME IS NULL and BUSI_MONTH = TO_CHAR(SYSDATE, 'yyyymm') ) a left join (select ORG_NAME ORG_NAME,ROUND(amt*100,2) num from fact_loan_dashboard where 1=1 and DASHBOARD_ID='A11' and ORG_ID <> '99999' and APPLY_USER_NAME IS NULL and BUSI_MONTH = TO_CHAR(SYSDATE, 'yyyymm') ) b on a.ORG_NAME=b.ORG_NAME order by a.amt,nlssort( a.ORG_NAME,'NLS_SORT=SCHINESE_PINYIN_M')");
			    list5_5 = dynamicQuery.nativeQuery(String.class, strBuffer5_5.toString());
			}else{
				strBuffer5_1.append(" select to_char(ROUND(amt*100,2),'9999999999990.00') amt from fact_loan_dashboard  ");
				strBuffer5_1.append(" where 1=1 and busi_month >= to_char( trunc(sysdate,'yyyy' )-365,'yyyymm') and busi_month <= to_char( trunc(sysdate,'dd'),'yyyymm') ");
				strBuffer5_1.append(" and DASHBOARD_ID='A10' and ORG_ID=?1 AND APPLY_USER_NAME IS NULL ");
				strBuffer5_1.append(" order by busi_month");
				params5_1.add(orgId);
				list5_1 = dynamicQuery.nativeQuery(String.class, strBuffer5_1.toString(), params5_1.toArray());
				
				strBuffer5_2.append(" select to_char(ROUND(amt*100,2),'9999999999990.00') amt from fact_loan_dashboard  ");
				strBuffer5_2.append(" where 1=1 and busi_month >= to_char( trunc(sysdate,'yyyy' )-365,'yyyymm') and busi_month <= to_char( trunc(sysdate,'dd'),'yyyymm') ");
				strBuffer5_2.append(" and DASHBOARD_ID='A11' and ORG_ID=?1 AND APPLY_USER_NAME IS NULL ");
				strBuffer5_2.append(" order by busi_month");
				params5_2.add(orgId);
				list5_2 = dynamicQuery.nativeQuery(String.class, strBuffer5_2.toString(), params5_2.toArray());
				
				strBuffer5_3.append("select to_char(ROUND(a.amt,2),'9999999999990.00') atm from (select APPLY_USER_NAME APPLY_USER_NAME,ROUND(amt*100,2) amt from fact_loan_dashboard where 1=1 and DASHBOARD_ID='A10' and ORG_ID=?1 and BUSI_MONTH = TO_CHAR(SYSDATE, 'yyyymm') and APPLY_USER_NAME IS NOT NULL ) a left join (select APPLY_USER_NAME APPLY_USER_NAME,ROUND(amt*100,2) num from fact_loan_dashboard where 1=1 and DASHBOARD_ID='A11' and ORG_ID=?2 and BUSI_MONTH = TO_CHAR(SYSDATE, 'yyyymm') and APPLY_USER_NAME IS NOT NULL ) b on a.APPLY_USER_NAME=b.APPLY_USER_NAME order by a.amt,nlssort( a.APPLY_USER_NAME,'NLS_SORT=SCHINESE_PINYIN_M')");
				params5_3.add(orgId);
				params5_3.add(orgId);
				list5_3 = dynamicQuery.nativeQuery(String.class, strBuffer5_3.toString(), params5_3.toArray());
			    
			    strBuffer5_4.append("select to_char(ROUND(case when b.num is null then 0 else b.num end,2),'9999999999990.00') atm from (select APPLY_USER_NAME APPLY_USER_NAME,ROUND(amt*100,2) amt from fact_loan_dashboard where 1=1 and DASHBOARD_ID='A10' and ORG_ID=?1 and BUSI_MONTH = TO_CHAR(SYSDATE, 'yyyymm') and APPLY_USER_NAME IS NOT NULL ) a left join (select APPLY_USER_NAME APPLY_USER_NAME,ROUND(amt*100,2) num from fact_loan_dashboard where 1=1 and DASHBOARD_ID='A11' and ORG_ID=?2 and BUSI_MONTH = TO_CHAR(SYSDATE, 'yyyymm') and APPLY_USER_NAME IS NOT NULL ) b on a.APPLY_USER_NAME=b.APPLY_USER_NAME order by a.amt,nlssort( a.APPLY_USER_NAME,'NLS_SORT=SCHINESE_PINYIN_M')");
			    params5_4.add(orgId);
			    params5_4.add(orgId);
			    list5_4 = dynamicQuery.nativeQuery(String.class, strBuffer5_4.toString(), params5_4.toArray());
			    
			    strBuffer5_5.append("select nvl(a.APPLY_USER_NAME,b.APPLY_USER_NAME) from (select APPLY_USER_NAME APPLY_USER_NAME,ROUND(amt*100,2) amt from fact_loan_dashboard where 1=1 and DASHBOARD_ID='A10' and ORG_ID=?1 and BUSI_MONTH = TO_CHAR(SYSDATE, 'yyyymm') and APPLY_USER_NAME IS NOT NULL ) a FULL OUTER JOIN (select APPLY_USER_NAME APPLY_USER_NAME,ROUND(amt*100,2) num from fact_loan_dashboard where 1=1 and DASHBOARD_ID='A11' and ORG_ID=?2 and BUSI_MONTH = TO_CHAR(SYSDATE, 'yyyymm') and APPLY_USER_NAME IS NOT NULL ) b on a.APPLY_USER_NAME=b.APPLY_USER_NAME order by a.amt,nlssort( a.APPLY_USER_NAME,'NLS_SORT=SCHINESE_PINYIN_M')");
			    params5_5.add(orgId);
			    params5_5.add(orgId);
			    list5_5 = dynamicQuery.nativeQuery(String.class, strBuffer5_5.toString(), params5_5.toArray());
			}
			
			String list51 = org.apache.commons.lang.StringUtils.join(list5_1.toArray(),",");
			model.addAttribute("list51", list51);
			String list52 = org.apache.commons.lang.StringUtils.join(list5_2.toArray(),",");
			model.addAttribute("list52", list52);
			String list53 = org.apache.commons.lang.StringUtils.join(list5_3.toArray(),",");
			model.addAttribute("list53", list53);
			String list54 = org.apache.commons.lang.StringUtils.join(list5_4.toArray(),",");
			model.addAttribute("list54", list54);
			String list55 = org.apache.commons.lang.StringUtils.join(list5_5.toArray(),",");
			model.addAttribute("list55", list55);
		}
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
		String currentMonth = sdf.format(date);
		Calendar calender = Calendar.getInstance();
        calender.setTime(date);
        calender.add(Calendar.MONTH, 1);
        String nextMonth = sdf.format(calender.getTime());
        model.addAttribute("currentMonth", currentMonth);
        model.addAttribute("nextMonth", nextMonth);
        
        List<String> monthOfCurrentYear = new ArrayList<String>();
        List<String> monthOfNextYear = new ArrayList<String>();
        
        String sql_mocy="select substr(busi_month,0,4)||'-'||substr(busi_month,5,6) busi_month from fact_loan_dashboard where 1=1 and busi_month >= to_char( trunc(sysdate,'yyyy' )-365,'yyyymm') and busi_month <= to_char( trunc(sysdate,'dd'),'yyyymm') and DASHBOARD_ID='A01' group by busi_month order by busi_month";
        String sql_mony="select substr(busi_month,0,4)||'-'||substr(busi_month,5,6) busi_month from fact_loan_dashboard where 1=1 and busi_month >= to_char( trunc(sysdate,'yyyy' )-365,'yyyymm') and busi_month <= to_char( trunc(sysdate,'mm')+365,'yyyymm') and DASHBOARD_ID='A08' group by busi_month order by busi_month ";
        monthOfCurrentYear = dynamicQuery.nativeQuery(String.class, sql_mocy.toString());
        monthOfNextYear = dynamicQuery.nativeQuery(String.class, sql_mony.toString());
        String mocy = org.apache.commons.lang.StringUtils.join(monthOfCurrentYear.toArray(),",");
        String mony = org.apache.commons.lang.StringUtils.join(monthOfNextYear.toArray(),",");
        model.addAttribute("monthOfCurrentYear", mocy);
        model.addAttribute("monthOfNextYear", mony);
        //机构or客户经理
        if("10001".equals(orgId)){
        	model.addAttribute("adminOrOrg", "机构");
        }else{
        	model.addAttribute("adminOrOrg", "经理");
        }
		
		return "/main/dashboard";
	}
	
	@RequestMapping("/loadChartData")
	public void loadChartData(@RequestParam(defaultValue="0")String type,HttpServletResponse resp){
		String orgId=getSessionUser().getOrgCode();
//		if(StringUtils.equals("10001", orgId)){
//			orgId="62400";
//		}
		
		
		
		
		
		//判断用户角色，控制相应图表的显示
		SessionUser sUser=getSessionUser();
		String userRoleId = sUser.getRoleId();
		String [] roleId = userRoleId.split(",");
		List<String> llist = new ArrayList<String>();
		for(String str :roleId){
			llist.add(str.toString());
		}
		StringBuffer strBuffer = new StringBuffer();
		strBuffer.append("select distinct PICTURE_ID from TBL_COGNOS_DASHBOARD_SHOW where role_id in (?1) ");
		List<String> list =dynamicQuery.nativeQuery(String.class, strBuffer.toString(), llist);
		
			if("0".equals(type)){
				if(list.contains("2001002"))	{
					ColumnAndLineChartInfo info=dashboardService.findColumnAndLineChartData2_1(orgId);
				toJson(resp, info);
			}
		}
			if("00".equals(type)){
				if(list.contains("2001002"))	{
					ColumnAndLineChartInfo info=dashboardService.findColumnAndLineChartData2_2(orgId);
				toJson(resp, info);
			}
		}
		
			if("1".equals(type)){
				if(list.contains("2001003"))	{
					ColumnAndLineChartInfo info=dashboardService.findColumnAndLineChartData3_1(orgId);
				toJson(resp, info);
			}
		}
			if("11".equals(type)){
				if(list.contains("2001003"))	{
					ColumnAndLineChartInfo info=dashboardService.findColumnAndLineChartData3_2(orgId);
				toJson(resp, info);
			}
		}
		
			if("2".equals(type)){
				if(list.contains("2001004"))	{
					ColumnAndLineChartInfo info=dashboardService.findColumnAndLineChartData4_1(orgId);
				toJson(resp, info);
			}
		}
			if("22".equals(type)){
				if(list.contains("2001004"))	{
					ColumnAndLineChartInfo info=dashboardService.findColumnAndLineChartData4_2(orgId);
				toJson(resp, info);
			}
		}
			//第5页签柱形图
			if("3".equals(type)){
				if(list.contains("2001005"))	{
					ColumnAndLineChartInfo info=dashboardService.findColumnAndLineChartData5_1(orgId);
				toJson(resp, info);
			}
		}
			if("33".equals(type)){
				if(list.contains("2001005"))	{
					ColumnAndLineChartInfo info=dashboardService.findColumnAndLineChartData5_2(orgId);
				toJson(resp, info);
			}
		}
				
		
			if("4".equals(type)){
				if(list.contains("2001001"))	{
				ColumnAndLineChartInfo info=dashboardService.findColumnAndLineChartData1_1(orgId);
				toJson(resp, info);
			}
		}		
			
			if("44".equals(type)){
				if(list.contains("2001001"))	{
				ColumnAndLineChartInfo info=dashboardService.findColumnAndLineChartData1_2(orgId);
				toJson(resp, info);
			}
			}

	}
	private void toJson(HttpServletResponse resp,Object obj){
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("application/json; charset=utf-8");
		String result=StringUtils.EMPTY;
		if(obj!=null){
			result=JSONObject.fromObject(obj).toString();
		}
		log.info("结果是："+result);  
		PrintWriter out = null;  
        try {  
	        out = resp.getWriter();
	        out.write(result);  
	    } catch (IOException e) {  
	        e.printStackTrace();  
	    } finally {  
	        if (out != null) {  
	            out.close();  
	        }  
	    }
	}
}


  