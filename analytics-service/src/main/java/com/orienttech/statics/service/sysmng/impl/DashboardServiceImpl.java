package com.orienttech.statics.service.sysmng.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.collect.Maps;
import com.orienttech.statics.commons.dynamicquery.DynamicQuery;
import com.orienttech.statics.commons.utils.CommonHelper;
import com.orienttech.statics.service.model.ColumnAndLineChartInfo;
import com.orienttech.statics.service.model.ColumnAndLineChartInfo.LciSerieColumnAndLine;
import com.orienttech.statics.service.model.LineChartInfo;
import com.orienttech.statics.service.sysmng.DashboardService;
@Service
public class DashboardServiceImpl implements DashboardService {
	@Autowired
	private DynamicQuery dynamicQuery;
	
	@Override
	public LineChartInfo findChartDataTotalLoanAmt(String orgId) {
		StringBuffer strBuffer=new StringBuffer();
		//type 0 :全部，1：小微
		strBuffer.append("Select 0 type_cd,'全部' type_name,busi_month,amt");
		strBuffer.append(" from fact_loan_dashboard ");
		strBuffer
				.append(" where dashboard_id='A051' and busi_month >= to_char( trunc(sysdate,'yyyy' )-365   ,'yyyymm'   ) ");
		strBuffer
				.append(" and busi_month <= to_char( trunc(sysdate,'dd' )   ,'yyyymm'   ) and org_id=?1");
		strBuffer.append(" union all");
		strBuffer.append(" Select 1 type_cd,'小微' type_name,busi_month,amt");
		strBuffer.append(" from fact_loan_dashboard ");
		strBuffer
				.append(" where dashboard_id='A052' and busi_month >= to_char( trunc(sysdate,'yyyy' )-365  ,'yyyymm'   ) ");
		strBuffer
				.append(" and busi_month <= to_char( trunc(sysdate,'dd' )   ,'yyyymm'   ) and org_id=?1");
		strBuffer.append(" order by busi_month,type_cd ");
		List<Object[]> list=dynamicQuery.nativeQuery(strBuffer.toString(), orgId);
		if(list==null||list.isEmpty()){
			return null;
		}
		LineChartInfo lci=new LineChartInfo();
		Object[] objs=null;
		Integer type=null;
		Map<Integer, LineChartInfo.LciSerie> map =Maps.newHashMap();
		LineChartInfo.LciXAxis xAxis=lci.new LciXAxis();
		LineChartInfo.LciSerie serie=null;
		BigDecimal[] totalBbs={BigDecimal.ZERO,BigDecimal.ZERO};//累计金额
		BigDecimal bd=null;
		String month=null;
		String temp_month=null;
		
		for (int i = 0,len=list.size(); i < len; i++) {
			objs=(Object[])list.get(i);
			type=CommonHelper.toInt(objs[0]);
			if(!map.containsKey(type)){
				serie=lci.new LciSerie();
				serie.setName(this.getLoanAddLineName(CommonHelper.toStr(objs[0])));
				bd=CommonHelper.toBigDecimal(objs[3]);
				totalBbs[type]=totalBbs[type].add(bd);
				bd=totalBbs[type].movePointLeft(4).setScale(4, BigDecimal.ROUND_HALF_UP);
				serie.addData(bd);
				map.put(type, serie);
			}else{
				serie=map.get(type);
				bd=CommonHelper.toBigDecimal(objs[3]);
				totalBbs[type]=totalBbs[type].add(bd);
				bd=totalBbs[type].movePointLeft(4).setScale(4, BigDecimal.ROUND_HALF_UP);
				serie.addData(bd);
			}
			temp_month=CommonHelper.toStr(objs[2]);
			if(!StringUtils.equals(month, temp_month)){
				month=temp_month;
				xAxis.getCategories().add(month);
			}
		}
		int i_month=xAxis.getCategories().size();
		if(i_month<12){//如果月数小于12个月则补全
			Date startDate=CommonHelper.str2Date(xAxis.getCategories().get(i_month-1), "yyyyMM");
			for (int i = i_month; i < 12; i++) {
				month=CommonHelper.date2Str(CommonHelper.addMonth(startDate, 1), "yyyyMM");
				xAxis.getCategories().add(month);
				map.get(0).getData().add(null);
				map.get(1).getData().add(null);
			}
		}
		lci.setxAxis(xAxis);
		lci.setSeries(new ArrayList<LineChartInfo.LciSerie>(map.values()));
		return lci;
	}
	@Override
	public LineChartInfo findChartDataLoanAddLine(String orgId) {
		StringBuffer strBuffer=new StringBuffer();
		//type 0 :全部，1：小微
		strBuffer.append("Select 0 type_cd,'全部' type_name,busi_month,amt");
		strBuffer.append(" from fact_loan_dashboard ");
		strBuffer
				.append(" where dashboard_id='A051' and busi_month >= to_char( add_months ( trunc(sysdate,'mm' )-365 , -11 )   ,'yyyymm'   ) ");
		strBuffer
				.append(" and busi_month <= to_char( trunc(sysdate,'dd' )   ,'yyyymm'   ) and org_id=?1");
		strBuffer.append(" union all");
		strBuffer.append(" Select 1 type_cd,'小微' type_name,busi_month,amt");
		strBuffer.append(" from fact_loan_dashboard ");
		strBuffer
				.append(" where dashboard_id='A052' and busi_month >= to_char( add_months ( trunc(sysdate,'mm' )-365 , -11 )   ,'yyyymm'   ) ");
		strBuffer
				.append(" and busi_month <= to_char( trunc(sysdate,'dd' )   ,'yyyymm'   ) and org_id=?1");
		strBuffer.append(" order by busi_month,type_cd ");
		List<Object[]> list=dynamicQuery.nativeQuery(strBuffer.toString(), orgId);
		if(list==null||list.isEmpty()){
			return null;
		}
		LineChartInfo lci=new LineChartInfo();
		Object[] objs=null;
		String type=null;
		Map<String, LineChartInfo.LciSerie> map =new HashMap<String, LineChartInfo.LciSerie>();
		LineChartInfo.LciXAxis xAxis=lci.new LciXAxis();
		LineChartInfo.LciSerie serie=null;
		BigDecimal bd=null;
		String month=null;
		String temp_month=null;
		for (int i = 0,len=list.size(); i < len; i++) {
			objs=(Object[])list.get(i);
			type=CommonHelper.toStr(objs[0]);
			if(!map.containsKey(type)){
				serie=lci.new LciSerie();
				serie.setName(this.getLoanAddLineName(CommonHelper.toStr(objs[0])));
				bd=CommonHelper.toBigDecimal(objs[3]);
				bd=bd.movePointLeft(4).setScale(4, BigDecimal.ROUND_HALF_UP);
				serie.addData(bd);
				map.put(type, serie);
			}else{
				serie=map.get(type);
				bd=CommonHelper.toBigDecimal(objs[3]);
				bd=bd.movePointLeft(4).setScale(4, BigDecimal.ROUND_HALF_UP);
				serie.addData(bd);
			}
			temp_month=CommonHelper.toStr(objs[2]);
			if(!StringUtils.equals(month, temp_month)){
				month=temp_month;
				xAxis.getCategories().add(month);
			}
		}
		lci.setxAxis(xAxis);
		lci.setSeries(new ArrayList<LineChartInfo.LciSerie>(map.values()));
		return lci;
	}
	private String getLoanAddLineName(String type){
		if("0".equals(type)){
			return "全部新增贷款金额";
		}else if("1".equals(type)){
			return "小微新增贷款金额";
		}
		return "未知";
	}
	@Override
	public LineChartInfo findChartDataOfLbBar(String orgId) {
		StringBuffer strBuffer=new StringBuffer();
		strBuffer.append("Select busi_month,amt");
		strBuffer.append(" from fact_loan_dashboard");
		strBuffer
				.append(" where dashboard_id='A01' and busi_month >= to_char( trunc(sysdate,'yyyy' )-365,'yyyymm')");
		strBuffer
				.append(" and busi_month <= to_char( trunc(sysdate,'dd' ),'yyyymm')");
		strBuffer.append(" and org_id=?1");
		strBuffer.append(" Order by busi_month");
		List<Object[]> list=dynamicQuery.nativeQuery(strBuffer.toString(), orgId);
		if(list==null||list.isEmpty()){
			return null;
		}
		LineChartInfo lci=new LineChartInfo();
		LineChartInfo.LciXAxis xAxis=lci.new LciXAxis();
		LineChartInfo.LciSerie serie=null;
		Object[] objs=null;
		BigDecimal bd=null;
		for (int i = 0,len=list.size(); i < len; i++) {
			objs=(Object[]) list.get(i);
			xAxis.getCategories().add(CommonHelper.toStr(objs[0]));
			if(i==0){
				serie=lci.new LciSerie();
				serie.setName("金额");
				bd=CommonHelper.toBigDecimal(objs[1]);
				bd=bd.movePointLeft(4).setScale(4, BigDecimal.ROUND_HALF_UP);
				serie.addData(bd);
			}else{
				bd=CommonHelper.toBigDecimal(objs[1]);
				bd=bd.movePointLeft(4).setScale(4, BigDecimal.ROUND_HALF_UP);
				serie.addData(bd);
			}
		}
		lci.setxAxis(xAxis);
		lci.setSeries(Arrays.asList(serie));
		return lci;
	}
	@Override
	public Map<String, Object> findChartDataOfLbGuarModePie(String orgId) {
		StringBuffer strBuffer=new StringBuffer();
		strBuffer.append(" Select 0 type_cd, '保证' type,amt from fact_loan_dashboard");
		strBuffer.append(" where dashboard_id='B011' and busi_month = to_char(sysdate-365,'yyyymm')");
		strBuffer.append(" And org_id=?1");
		strBuffer.append(" Union all");
		strBuffer.append(" Select 1 type_cd, '信用' type,amt from fact_loan_dashboard");
		strBuffer.append(" where dashboard_id='B012' and busi_month = to_char(sysdate-365,'yyyymm')");
		strBuffer.append(" And org_id=?1");
		strBuffer.append(" Union all");
		strBuffer.append(" Select 2 type_cd, '抵押' type,amt from fact_loan_dashboard");
		strBuffer.append(" where dashboard_id='B013' and busi_month = to_char(sysdate-365,'yyyymm')");
		strBuffer.append(" And org_id=?1");
		strBuffer.append(" Union all");
		strBuffer.append(" Select 3 type_cd, '质押' type,amt from fact_loan_dashboard");
		strBuffer.append(" where dashboard_id='B014' and busi_month = to_char(sysdate-365,'yyyymm')");
		strBuffer.append(" And org_id=?1");
		List<Object[]> list=dynamicQuery.nativeQuery(strBuffer.toString(), orgId);
		if(list==null||list.isEmpty()){
			return null;
		}
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("subtitle", this.getSubTitle());
		map.put("data", this.getPieData(list, "2"));
		return map;
	}
	@Override
	public Map<String, Object> findChartDataOfLbAmtPie(String orgId) {
		StringBuffer strBuffer=new StringBuffer();
		strBuffer.append("Select 0 type_cd, '100万元（含）以下' type ,amt");
		strBuffer.append(" from fact_loan_dashboard where dashboard_id='B021' ");
		strBuffer.append(" and busi_month = to_char(sysdate-365,'yyyymm')  And org_id= ?1");
		strBuffer.append(" Union all");
		strBuffer.append(" Select 1 type_cd, '(100万元,200万元 ]' type ,amt");
		strBuffer.append(" from fact_loan_dashboard where dashboard_id='B022' ");
		strBuffer.append(" and busi_month = to_char(sysdate-365,'yyyymm')  And org_id= ?1");
		strBuffer.append(" Union all");
		strBuffer.append(" Select 2 type_cd, '(200万元,300万元 ]' type ,amt");
		strBuffer.append(" from fact_loan_dashboard where dashboard_id='B023' ");
		strBuffer.append(" and busi_month = to_char(sysdate-365,'yyyymm')  And org_id= ?1");
		strBuffer.append(" Union all");
		strBuffer.append(" Select 3 type_cd, '(300万元,400万元 ]' type ,amt");
		strBuffer.append(" from fact_loan_dashboard where dashboard_id='B024' ");
		strBuffer.append(" and busi_month = to_char(sysdate-365,'yyyymm')  And org_id= ?1");
		strBuffer.append(" Union all");
		strBuffer.append(" Select 4 type_cd, '(400万元,500万元 ]' type ,amt");
		strBuffer.append(" from fact_loan_dashboard where dashboard_id='B025' ");
		strBuffer.append(" and busi_month = to_char(sysdate-365,'yyyymm')  And org_id= ?1");
		strBuffer.append(" Union all");
		strBuffer.append(" Select 5 type_cd, '500万元以上' type ,amt");
		strBuffer.append(" from fact_loan_dashboard where dashboard_id='B026' ");
		strBuffer.append(" and busi_month = to_char(sysdate-365,'yyyymm')  And org_id= ?1");
		List<Object[]> list=dynamicQuery.nativeQuery(strBuffer.toString(), orgId);
		if(list==null||list.isEmpty()){
			return null;
		}
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("subtitle", this.getSubTitle());
		map.put("data", this.getPieData(list, "3"));
		return map;
	}
	private String getSubTitle(){
		return "统计时间："+CommonHelper.date2Str(CommonHelper.getNow(), CommonHelper.DF_DATE);
	}
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private List getPieData(List list,String openType){
		if(StringUtils.isBlank(openType)){
			openType="0";
		}
		double sumBd=0L;
		Object[] objs=null;
		for (Object obj : list) {
			objs=(Object[]) obj;
			sumBd=sumBd+CommonHelper.toBigDecimal(objs[2]).doubleValue();
		}
		BigDecimal bd=BigDecimal.ZERO;
		List re_list=new ArrayList();
		double temp_d=0L;
		Map<String, Object> item=null;
		for (Object obj : list) {
			objs=(Object[]) obj;
			temp_d=CommonHelper.toBigDecimal(objs[2]).doubleValue();
			bd=BigDecimal.valueOf(temp_d/sumBd).movePointRight(2).setScale(2, BigDecimal.ROUND_HALF_UP);
			if(StringUtils.equals(openType, CommonHelper.toStr(objs[0]))){
				item=new HashMap<String, Object>();
				item.put("name", CommonHelper.toStr(objs[1]));
				item.put("y", bd);
				item.put("sliced", true);
				item.put("selected", true);
				re_list.add(item);
			}else{
				re_list.add(Arrays.asList(CommonHelper.toStr(objs[1]),bd));
			}
		}
		return re_list;
	}
	
	
	//柱状图和曲线图混合类型
	
	@Override
	public ColumnAndLineChartInfo findColumnAndLineChartData1_1(String orgId) {
		StringBuffer strBuffer=new StringBuffer();
		List<Object> params = new ArrayList<Object>();
		strBuffer.append("select a.busi_month,a.amt,b.num from ");
		strBuffer.append(" (select busi_month busi_month,sum(amt) amt from fact_loan_dashboard  ");
		strBuffer.append(" where 1=1 and busi_month >= to_char( trunc(sysdate,'yyyy' )-365,'yyyymm') and busi_month <= to_char( trunc(sysdate,'dd'),'yyyymm')  ");
		strBuffer.append(" and DASHBOARD_ID='A01' ");
		if(!"10001".equals(orgId)){
			strBuffer.append(" and ORG_ID=?1 ");
			params.add(orgId);
		}
		strBuffer.append(" group by busi_month order by busi_month) a");
		strBuffer.append(" left join ");
		strBuffer.append(" (select busi_month,sum(amt) num from fact_loan_dashboard  ");
		strBuffer.append(" where 1=1 and busi_month >= to_char( trunc(sysdate,'yyyy' )-365,'yyyymm') and busi_month <= to_char( trunc(sysdate,'dd'),'yyyymm') ");
		strBuffer.append(" and DASHBOARD_ID='A02' ");
		if(!"10001".equals(orgId)){
			strBuffer.append(" and ORG_ID=?2 ");
			params.add(orgId);
		}
		strBuffer.append(" group by busi_month order by busi_month) b ");
		strBuffer.append(" on a.busi_month=b.busi_month ");
		
		List<Object[]> list=dynamicQuery.nativeQuery(strBuffer.toString(), params.toArray());
		if(list==null||list.isEmpty()){
			return null;
		}
		ColumnAndLineChartInfo series= new ColumnAndLineChartInfo();
		ColumnAndLineChartInfo.LciXAxis xAxis=series.new LciXAxis();
		Object[] objs=null;
		String month=null;
		BigDecimal amt=null;
		Integer count=null;
		
		for (int i = 0,len=list.size(); i < len; i++) {
			objs=(Object[])list.get(i);
			month=CommonHelper.toStr(objs[0]);
		    amt=CommonHelper.toBigDecimal(objs[1]);
			amt=amt.movePointLeft(4).setScale(0, BigDecimal.ROUND_HALF_UP);
			series.getSeriesColumn().add(amt);
				
			count=CommonHelper.toInt(objs[2]);
			series.getSeriesLine().add(count);
			xAxis.getCategories().add(month);
		}
		series.setxAxis(xAxis);
		
		return series;
	}
	
	
	@Override
	public ColumnAndLineChartInfo findColumnAndLineChartData1_2(String orgId) {
		StringBuffer strBuffer=new StringBuffer();
		List<Object> params = new ArrayList<Object>();
		if("10001".equals(orgId)){
			strBuffer.append(" select n.DESCRIPTION1,nvl(m.amt,0),nvl(m.num,0) from(select a.ORG_NAME,a.amt,b.num from (select ORG_NAME ORG_NAME,sum(amt) amt from fact_loan_dashboard where 1=1 and busi_month = to_char( trunc(sysdate,'dd' )   ,'yyyymm'   ) and DASHBOARD_ID='A01'  group by ORG_NAME) a left join (select ORG_NAME ORG_NAME,sum(amt) num from fact_loan_dashboard where 1=1 and busi_month = to_char( trunc(sysdate,'dd' )   ,'yyyymm'   ) and DASHBOARD_ID='A02' group by ORG_NAME) b on a.ORG_NAME=b.ORG_NAME order by a.amt desc, nlssort( a.ORG_NAME,'NLS_SORT=SCHINESE_PINYIN_M'))m full outer join (select distinct DESCRIPTION1 from T_STA_DIM_ORG where orgid like '6%')n on m.ORG_NAME = n.DESCRIPTION1 ORDER BY nvl(m.amt,0) DESC,nlssort( n.DESCRIPTION1,'NLS_SORT=SCHINESE_PINYIN_M') ");
		}else{
			strBuffer.append(" select nvl(a.APPLY_USER_NAME,b.APPLY_USER_NAME),nvl(a.amt,0) amt,nvl(b.num,0) num from (select APPLY_USER_NAME APPLY_USER_NAME,sum(amt) amt from fact_loan_dashboard where 1=1 and busi_month = to_char( trunc(sysdate,'dd' )   ,'yyyymm'   ) and DASHBOARD_ID='A01' and ORG_ID=?1 group by APPLY_USER_NAME) a FULL OUTER JOIN (select APPLY_USER_NAME APPLY_USER_NAME,sum(amt) num from fact_loan_dashboard where 1=1 and busi_month = to_char( trunc(sysdate,'dd' )   ,'yyyymm'   ) and DASHBOARD_ID='A02' and ORG_ID=?2 group by APPLY_USER_NAME) b on a.APPLY_USER_NAME=b.APPLY_USER_NAME order by a.amt desc, nlssort( a.APPLY_USER_NAME,'NLS_SORT=SCHINESE_PINYIN_M') ");
			params.add(orgId);
			params.add(orgId);
		}
		
		List<Object[]> list=dynamicQuery.nativeQuery(strBuffer.toString(), params.toArray());
		if(list==null||list.isEmpty()){
			return null;
		}
		ColumnAndLineChartInfo series= new ColumnAndLineChartInfo();
		ColumnAndLineChartInfo.LciXAxis xAxis=series.new LciXAxis();
		Object[] objs=null;
		String month=null;
		BigDecimal amt=null;
		Integer count=null;
		
		for (int i = 0,len=list.size(); i < len; i++) {
			objs=(Object[])list.get(i);
			month=CommonHelper.toStr(objs[0]);
		    amt=CommonHelper.toBigDecimal(objs[1]);
			amt=amt.movePointLeft(4).setScale(0, BigDecimal.ROUND_HALF_UP);
			series.getSeriesColumn().add(amt);
				
			count=CommonHelper.toInt(objs[2]);
			series.getSeriesLine().add(count);
			xAxis.getCategories().add(month);
		}
		series.setxAxis(xAxis);
		
		return series;
	}
	
	@Override
	public ColumnAndLineChartInfo findColumnAndLineChartData2_1(String orgId) {
		StringBuffer strBuffer=new StringBuffer();
		List<Object> params = new ArrayList<Object>();
		strBuffer.append("select a.busi_month,a.amt,b.num,c.total from ");
		strBuffer.append(" (select busi_month busi_month,sum(amt) amt from fact_loan_dashboard  ");
		strBuffer.append(" where 1=1 and busi_month >= to_char( trunc(sysdate,'yyyy' )-365,'yyyymm') and busi_month <= to_char( trunc(sysdate,'dd'),'yyyymm')  ");
		strBuffer.append(" and DASHBOARD_ID='A03' ");
		if(!"10001".equals(orgId)){
			strBuffer.append(" and ORG_ID=?1 ");
			params.add(orgId);
		}
		strBuffer.append(" group by busi_month order by busi_month) a");
		strBuffer.append(" left join ");
		strBuffer.append(" (select busi_month,sum(amt) num from fact_loan_dashboard  ");
		strBuffer.append(" where 1=1 and busi_month >= to_char( trunc(sysdate,'yyyy' )-365,'yyyymm') and busi_month <= to_char( trunc(sysdate,'dd'),'yyyymm') ");
		strBuffer.append(" and DASHBOARD_ID='A04' ");
		if(!"10001".equals(orgId)){
			strBuffer.append(" and ORG_ID=?2 ");
			params.add(orgId);
		}
		strBuffer.append(" group by busi_month order by busi_month) b");
		strBuffer.append(" on a.busi_month=b.busi_month ");
		strBuffer.append(" left join ");
		strBuffer.append(" (select busi_month,sum(amt) total from fact_loan_dashboard  ");
		strBuffer.append(" where 1=1 and busi_month >= to_char( trunc(sysdate,'yyyy' )-365,'yyyymm') and busi_month <= to_char( trunc(sysdate,'dd'),'yyyymm') ");
		strBuffer.append(" and DASHBOARD_ID='A05' ");
		if(!"10001".equals(orgId)){
			strBuffer.append(" and ORG_ID=?3 ");
			params.add(orgId);
		}
		strBuffer.append(" group by busi_month order by busi_month) c ");
		strBuffer.append(" on c.busi_month=b.busi_month ");
		
		List<Object[]> list=dynamicQuery.nativeQuery(strBuffer.toString(), params.toArray());
		if(list==null||list.isEmpty()){
			return null;
		}
		ColumnAndLineChartInfo series= new ColumnAndLineChartInfo();
		ColumnAndLineChartInfo.LciXAxis xAxis=series.new LciXAxis();
		Object[] objs=null;
		String month=null;
		BigDecimal amt=null;
		Integer count=null;
		Integer total=null;
		
		for (int i = 0,len=list.size(); i < len; i++) {
			objs=(Object[])list.get(i);
			month=CommonHelper.toStr(objs[0]);
		    amt=CommonHelper.toBigDecimal(objs[1]);
			amt=amt.movePointLeft(4).setScale(0, BigDecimal.ROUND_HALF_UP);
			series.getSeriesColumn().add(amt);
				
			count=CommonHelper.toInt(objs[2]);
			total=CommonHelper.toInt(objs[3]);
			series.getSeriesLine().add(count);
			series.getSeriesCount().add(total);
			xAxis.getCategories().add(month);
		}
		series.setxAxis(xAxis);
		
		return series;
	}
	
	@Override
	public ColumnAndLineChartInfo findColumnAndLineChartData2_2(String orgId) {
		StringBuffer strBuffer=new StringBuffer();
		List<Object> params = new ArrayList<Object>();
		if("10001".equals(orgId)){
			strBuffer.append(" select n.DESCRIPTION1,nvl(m.amt,0),nvl(m.num,0) from(select a.ORG_NAME,a.amt,b.num from (select ORG_NAME ORG_NAME,sum(amt) amt from fact_loan_dashboard where 1=1 and busi_month = to_char( trunc(sysdate,'dd' ),'yyyymm') and DASHBOARD_ID='A03'  group by ORG_NAME) a left join (select ORG_NAME ORG_NAME,sum(amt) num from fact_loan_dashboard where 1=1 and busi_month = to_char( trunc(sysdate,'dd' ),'yyyymm') and DASHBOARD_ID='A05' group by ORG_NAME) b on a.ORG_NAME=b.ORG_NAME order by a.amt desc, nlssort( a.ORG_NAME,'NLS_SORT=SCHINESE_PINYIN_M'))m full outer join (select distinct DESCRIPTION1 from T_STA_DIM_ORG where orgid like '6%')n on m.ORG_NAME = n.DESCRIPTION1 ORDER BY nvl(m.amt,0) DESC,nlssort( n.DESCRIPTION1,'NLS_SORT=SCHINESE_PINYIN_M')");
		}else{
			strBuffer.append(" select nvl(a.APPLY_USER_NAME,b.APPLY_USER_NAME),nvl(a.amt,0) amt,nvl(b.num,0) num from (select APPLY_USER_NAME APPLY_USER_NAME,sum(amt) amt from fact_loan_dashboard where 1=1 and busi_month = to_char( trunc(sysdate,'dd' ),'yyyymm') and DASHBOARD_ID='A03' and ORG_ID=?1 group by APPLY_USER_NAME) a FULL OUTER JOIN (select APPLY_USER_NAME APPLY_USER_NAME,sum(amt) num from fact_loan_dashboard where 1=1 and busi_month = to_char( trunc(sysdate,'dd' ),'yyyymm') and DASHBOARD_ID='A05' and ORG_ID=?2 group by APPLY_USER_NAME) b on a.APPLY_USER_NAME=b.APPLY_USER_NAME order by a.amt desc, nlssort( a.APPLY_USER_NAME,'NLS_SORT=SCHINESE_PINYIN_M')");
			params.add(orgId);
			params.add(orgId);
		}
		
		List<Object[]> list=dynamicQuery.nativeQuery(strBuffer.toString(), params.toArray());
		if(list==null||list.isEmpty()){
			return null;
		}
		ColumnAndLineChartInfo series= new ColumnAndLineChartInfo();
		ColumnAndLineChartInfo.LciXAxis xAxis=series.new LciXAxis();
		Object[] objs=null;
		String month=null;
		BigDecimal amt=null;
		Integer count=null;
		
		for (int i = 0,len=list.size(); i < len; i++) {
			objs=(Object[])list.get(i);
			month=CommonHelper.toStr(objs[0]);
		    amt=CommonHelper.toBigDecimal(objs[1]);
			amt=amt.movePointLeft(4).setScale(0, BigDecimal.ROUND_HALF_UP);
			series.getSeriesColumn().add(amt);
				
			count=CommonHelper.toInt(objs[2]);
			series.getSeriesLine().add(count);
			xAxis.getCategories().add(month);
		}
		series.setxAxis(xAxis);
		
		return series;
	}
	
	@Override
	public ColumnAndLineChartInfo findColumnAndLineChartData3_1(String orgId) {
		StringBuffer strBuffer=new StringBuffer();
		List<Object> params = new ArrayList<Object>();
		strBuffer.append("select a.busi_month,a.amt,b.num from ");
		strBuffer.append(" (select busi_month busi_month,sum(amt) amt from fact_loan_dashboard  ");
		strBuffer.append(" where 1=1 and busi_month >= to_char( trunc(sysdate,'yyyy' )-365,'yyyymm') and busi_month <= to_char( trunc(sysdate,'dd'),'yyyymm')  ");
		strBuffer.append(" and DASHBOARD_ID='A06' ");
		if(!"10001".equals(orgId)){
			strBuffer.append(" and ORG_ID=?1 ");
			params.add(orgId);
		}
		strBuffer.append(" group by busi_month order by busi_month) a");
		strBuffer.append(" left join ");
		strBuffer.append(" (select busi_month,sum(amt) num from fact_loan_dashboard  ");
		strBuffer.append(" where 1=1 and busi_month >= to_char( trunc(sysdate,'yyyy' )-365,'yyyymm') and busi_month <= to_char( trunc(sysdate,'dd'),'yyyymm') ");
		strBuffer.append(" and DASHBOARD_ID='A13' ");
		if(!"10001".equals(orgId)){
			strBuffer.append(" and ORG_ID=?2 ");
			params.add(orgId);
		}
		strBuffer.append(" group by busi_month order by busi_month) b ");
		strBuffer.append(" on a.busi_month=b.busi_month ");
		
		List<Object[]> list=dynamicQuery.nativeQuery(strBuffer.toString(), params.toArray());
		if(list==null||list.isEmpty()){
			return null;
		}
		ColumnAndLineChartInfo series= new ColumnAndLineChartInfo();
		ColumnAndLineChartInfo.LciXAxis xAxis=series.new LciXAxis();
		Object[] objs=null;
		String month=null;
		BigDecimal amt=null;
		BigDecimal count=null;
		
		for (int i = 0,len=list.size(); i < len; i++) {
			objs=(Object[])list.get(i);
			month=CommonHelper.toStr(objs[0]);
		    amt=CommonHelper.toBigDecimal(objs[1]);
			amt=amt.movePointLeft(4).setScale(0, BigDecimal.ROUND_HALF_UP);
			series.getSeriesColumn().add(amt);
				
			count=CommonHelper.toBigDecimal(objs[2]);
			//转换成"万元"并四舍五入
			count=count.movePointLeft(4).setScale(0, BigDecimal.ROUND_HALF_UP);
			series.getSeriesPercent().add(count);
			xAxis.getCategories().add(month);
		}
		series.setxAxis(xAxis);
		
		return series;
	}
	
	@Override
	public ColumnAndLineChartInfo findColumnAndLineChartData3_2(String orgId) {
		StringBuffer strBuffer=new StringBuffer();
		List<Object> params = new ArrayList<Object>();
		if("10001".equals(orgId)){
			strBuffer.append(" select n.DESCRIPTION1,nvl(m.amt,0),nvl(m.num,0) from(select a.ORG_NAME,a.amt,b.num from (select ORG_NAME ORG_NAME,sum(amt) amt from fact_loan_dashboard where 1=1 and busi_month = to_char( trunc(sysdate,'dd' ),'yyyymm') and DASHBOARD_ID='A06'  group by ORG_NAME) a left join (select ORG_NAME ORG_NAME,sum(amt) num from fact_loan_dashboard where 1=1 and busi_month = to_char( trunc(sysdate,'dd' ),'yyyymm') and DASHBOARD_ID='A13' group by ORG_NAME) b on a.ORG_NAME=b.ORG_NAME order by a.amt desc,nlssort( a.ORG_NAME,'NLS_SORT=SCHINESE_PINYIN_M'))m full outer join (select distinct DESCRIPTION1 from T_STA_DIM_ORG where orgid like '6%')n on m.ORG_NAME = n.DESCRIPTION1 ORDER BY nvl(m.amt,0) DESC,nlssort( n.DESCRIPTION1,'NLS_SORT=SCHINESE_PINYIN_M')");
		}else{
			strBuffer.append(" select nvl(a.APPLY_USER_NAME,b.APPLY_USER_NAME),nvl(a.amt,0) amt,nvl(b.num,0) num from (select APPLY_USER_NAME APPLY_USER_NAME,sum(amt) amt from fact_loan_dashboard where 1=1 and busi_month = to_char( trunc(sysdate,'dd' ),'yyyymm') and DASHBOARD_ID='A06' and ORG_ID=?1 group by APPLY_USER_NAME) a FULL OUTER JOIN (select APPLY_USER_NAME APPLY_USER_NAME,sum(amt) num from fact_loan_dashboard where 1=1 and busi_month = to_char( trunc(sysdate,'dd' ),'yyyymm') and DASHBOARD_ID='A13' and ORG_ID=?2 group by APPLY_USER_NAME) b on a.APPLY_USER_NAME=b.APPLY_USER_NAME order by a.amt desc,nlssort( a.APPLY_USER_NAME,'NLS_SORT=SCHINESE_PINYIN_M')");
			params.add(orgId);
			params.add(orgId);
		}
		
		List<Object[]> list=dynamicQuery.nativeQuery(strBuffer.toString(), params.toArray());
		if(list==null||list.isEmpty()){
			return null;
		}
		ColumnAndLineChartInfo series= new ColumnAndLineChartInfo();
		ColumnAndLineChartInfo.LciXAxis xAxis=series.new LciXAxis();
		Object[] objs=null;
		String month=null;
		BigDecimal amt=null;
		BigDecimal count=null;
		
		for (int i = 0,len=list.size(); i < len; i++) {
			objs=(Object[])list.get(i);
			month=CommonHelper.toStr(objs[0]);
		    amt=CommonHelper.toBigDecimal(objs[1]);
			amt=amt.movePointLeft(4).setScale(0, BigDecimal.ROUND_HALF_UP);
			series.getSeriesColumn().add(amt);
				
			count=CommonHelper.toBigDecimal(objs[2]);
			//转换成"万元"并四舍五入
			count=count.movePointLeft(4).setScale(0, BigDecimal.ROUND_HALF_UP);
			series.getSeriesPercent().add(count);
			xAxis.getCategories().add(month);
		}
		series.setxAxis(xAxis);
		
		return series;
	}
	
	@Override
	public ColumnAndLineChartInfo findColumnAndLineChartData4_1(String orgId) {
		StringBuffer strBuffer=new StringBuffer();
		List<Object> params = new ArrayList<Object>();
		strBuffer.append("select a.busi_month,a.amt,b.num from ");
		strBuffer.append(" (select busi_month busi_month,sum(amt) amt from fact_loan_dashboard  ");
		strBuffer.append(" where 1=1 and busi_month >= to_char( trunc(sysdate,'yyyy' )-365,'yyyymm') and busi_month <= to_char( trunc(sysdate,'mm')+365,'yyyymm')  ");
		strBuffer.append(" and DASHBOARD_ID='A08' ");
		if(!"10001".equals(orgId)){
			strBuffer.append(" and ORG_ID=?1 ");
			params.add(orgId);
		}
		strBuffer.append(" group by busi_month order by busi_month) a");
		strBuffer.append(" left join ");
		strBuffer.append(" (select busi_month,sum(amt) num from fact_loan_dashboard  ");
		strBuffer.append(" where 1=1 and busi_month >= to_char( trunc(sysdate,'yyyy' )-365,'yyyymm') and busi_month <= to_char( trunc(sysdate,'mm')+365,'yyyymm') ");
		strBuffer.append(" and DASHBOARD_ID='A09' ");
		if(!"10001".equals(orgId)){
			strBuffer.append(" and ORG_ID=?2 ");
			params.add(orgId);
		}
		strBuffer.append(" group by busi_month order by busi_month) b ");
		strBuffer.append(" on a.busi_month=b.busi_month ");
		
		List<Object[]> list=dynamicQuery.nativeQuery(strBuffer.toString(), params.toArray());
		if(list==null||list.isEmpty()){
			return null;
		}
		ColumnAndLineChartInfo series= new ColumnAndLineChartInfo();
		ColumnAndLineChartInfo.LciXAxis xAxis=series.new LciXAxis();
		Object[] objs=null;
		String month=null;
		BigDecimal amt=null;
		BigDecimal count=null;
		
		for (int i = 0,len=list.size(); i < len; i++) {
			objs=(Object[])list.get(i);
			month=CommonHelper.toStr(objs[0]);
		    amt=CommonHelper.toBigDecimal(objs[1]);
			amt=amt.movePointLeft(4).setScale(0, BigDecimal.ROUND_HALF_UP);
			series.getSeriesColumn().add(amt);
				
			count=CommonHelper.toBigDecimal(objs[2]);
			//转换成"万元"并四舍五入
			count=count.movePointLeft(4).setScale(0, BigDecimal.ROUND_HALF_UP);
			series.getSeriesPercent().add(count);
			xAxis.getCategories().add(month);
		}
		series.setxAxis(xAxis);
		
		return series;
	}
	
	@Override
	public ColumnAndLineChartInfo findColumnAndLineChartData4_2(String orgId) {
		StringBuffer strBuffer=new StringBuffer();
		List<Object> params = new ArrayList<Object>();
		if("10001".equals(orgId)){
			strBuffer.append(" select n.DESCRIPTION1,nvl(m.amt,0),nvl(m.num,0) from(select a.ORG_NAME,a.amt,b.num from (select ORG_NAME ORG_NAME,sum(amt) amt from fact_loan_dashboard where 1=1 and busi_month = to_char( trunc(ADD_MONTHS(sysdate, +1),'mm'),'yyyymm') and DASHBOARD_ID='A08'  group by ORG_NAME) a left join (select ORG_NAME ORG_NAME,sum(amt) num from fact_loan_dashboard where 1=1 and busi_month = to_char( trunc(ADD_MONTHS(sysdate, +1),'mm'),'yyyymm') and DASHBOARD_ID='A09' group by ORG_NAME) b on a.ORG_NAME=b.ORG_NAME order by a.amt desc,nlssort( a.ORG_NAME,'NLS_SORT=SCHINESE_PINYIN_M'))m full outer join (select distinct DESCRIPTION1 from T_STA_DIM_ORG where orgid like '6%')n on m.ORG_NAME = n.DESCRIPTION1 ORDER BY nvl(m.amt,0) DESC,nlssort( n.DESCRIPTION1,'NLS_SORT=SCHINESE_PINYIN_M')");
		}else{
			strBuffer.append(" select nvl(a.APPLY_USER_NAME,b.APPLY_USER_NAME),nvl(a.amt,0) amt,nvl(b.num,0) num from (select APPLY_USER_NAME APPLY_USER_NAME,sum(amt) amt from fact_loan_dashboard where 1=1 and busi_month = to_char( trunc(ADD_MONTHS(sysdate, +1),'mm'),'yyyymm') and DASHBOARD_ID='A08' and ORG_ID=?1 group by APPLY_USER_NAME) a FULL OUTER JOIN (select APPLY_USER_NAME APPLY_USER_NAME,sum(amt) num from fact_loan_dashboard where 1=1 and busi_month = to_char( trunc(ADD_MONTHS(sysdate, +1),'mm'),'yyyymm') and DASHBOARD_ID='A09' and ORG_ID=?2 group by APPLY_USER_NAME) b on a.APPLY_USER_NAME=b.APPLY_USER_NAME order by a.amt desc,nlssort( a.APPLY_USER_NAME,'NLS_SORT=SCHINESE_PINYIN_M')");
			params.add(orgId);
			params.add(orgId);
		}
		
		List<Object[]> list=dynamicQuery.nativeQuery(strBuffer.toString(), params.toArray());
		if(list==null||list.isEmpty()){
			return null;
		}
		ColumnAndLineChartInfo series= new ColumnAndLineChartInfo();
		ColumnAndLineChartInfo.LciXAxis xAxis=series.new LciXAxis();
		Object[] objs=null;
		String month=null;
		BigDecimal amt=null;
		BigDecimal count=null;
		
		for (int i = 0,len=list.size(); i < len; i++) {
			objs=(Object[])list.get(i);
			month=CommonHelper.toStr(objs[0]);
		    amt=CommonHelper.toBigDecimal(objs[1]);
			amt=amt.movePointLeft(4).setScale(0, BigDecimal.ROUND_HALF_UP);
			series.getSeriesColumn().add(amt);
				
			count=CommonHelper.toBigDecimal(objs[2]);
			//转换成"万元"并四舍五入
			count=count.movePointLeft(4).setScale(0, BigDecimal.ROUND_HALF_UP);
			series.getSeriesPercent().add(count);
			xAxis.getCategories().add(month);
		}
		series.setxAxis(xAxis);
		
		return series;
	}
	
	@Override
	public ColumnAndLineChartInfo findColumnAndLineChartData5_1(String orgId) {
		StringBuffer strBuffer=new StringBuffer();
		List<Object> params = new ArrayList<Object>();
		strBuffer.append("select a.busi_month,a.amt,b.num from ");
		strBuffer.append(" (select busi_month busi_month,ROUND(amt*100,2) amt from fact_loan_dashboard  ");
		strBuffer.append(" where 1=1 and busi_month >= to_char( trunc(sysdate,'yyyy' )-365,'yyyymm') and busi_month <= to_char( trunc(sysdate,'dd'),'yyyymm')  ");
		strBuffer.append(" and DASHBOARD_ID='A10' ");
		if(!"10001".equals(orgId)){
			strBuffer.append(" and ORG_ID=?1 AND APPLY_USER_NAME IS NULL ");
			params.add(orgId);
		}else{
			strBuffer.append(" AND ORG_ID = '99999' ");
		}
		strBuffer.append(" order by busi_month) a");
		strBuffer.append(" left join ");
		strBuffer.append(" (select busi_month,ROUND(amt*100,2) num from fact_loan_dashboard  ");
		strBuffer.append(" where 1=1 and busi_month >= to_char( trunc(sysdate,'yyyy' )-365,'yyyymm') and busi_month <= to_char( trunc(sysdate,'dd'),'yyyymm') ");
		strBuffer.append(" and DASHBOARD_ID='A11' ");
		if(!"10001".equals(orgId)){
			strBuffer.append(" and ORG_ID=?2 AND APPLY_USER_NAME IS NULL ");
			params.add(orgId);
		}else{
			strBuffer.append(" AND ORG_ID = '99999' ");
		}
		strBuffer.append(" order by busi_month) b ");
		strBuffer.append(" on a.busi_month=b.busi_month order by a.busi_month, a.amt");
		
		List<Object[]> list=dynamicQuery.nativeQuery(strBuffer.toString(), params.toArray());
		if(list==null||list.isEmpty()){
			return null;
		}
		ColumnAndLineChartInfo series= new ColumnAndLineChartInfo();
		ColumnAndLineChartInfo.LciXAxis xAxis=series.new LciXAxis();
		Object[] objs=null;
		String month=null;
		BigDecimal amt=null;
		BigDecimal percent=null;
		
		for (int i = 0,len=list.size(); i < len; i++) {
			objs=(Object[])list.get(i);
			month=CommonHelper.toStr(objs[0]);
		    amt=CommonHelper.toBigDecimal(objs[1]);
			//amt=amt.movePointLeft(4).setScale(2, BigDecimal.ROUND_HALF_UP);
			series.getSeriesColumn().add(amt);
				
			percent=CommonHelper.toBigDecimal(objs[2]);
			series.getSeriesPercent().add(percent);
			xAxis.getCategories().add(month);
		}
		series.setxAxis(xAxis);
		
		return series;
	}
	
	@Override
	public ColumnAndLineChartInfo findColumnAndLineChartData5_2(String orgId) {
		StringBuffer strBuffer=new StringBuffer();
		List<Object> params = new ArrayList<Object>();
		if("10001".equals(orgId)){
			strBuffer.append(" select a.ORG_NAME,a.amt,b.num from (select ORG_NAME ORG_NAME,ROUND(amt*100,2) amt from fact_loan_dashboard where 1=1 and DASHBOARD_ID='A10' and ORG_ID <> '99999' and APPLY_USER_NAME IS NULL and BUSI_MONTH = TO_CHAR(SYSDATE, 'yyyymm') ) a left join (select ORG_NAME ORG_NAME,ROUND(amt*100,2) num from fact_loan_dashboard where 1=1 and DASHBOARD_ID='A11' and ORG_ID <> '99999' and APPLY_USER_NAME IS NULL and BUSI_MONTH = TO_CHAR(SYSDATE, 'yyyymm') ) b on a.ORG_NAME=b.ORG_NAME order by a.amt,nlssort( a.ORG_NAME,'NLS_SORT=SCHINESE_PINYIN_M')");
		}else{
			strBuffer.append(" select nvl(a.APPLY_USER_NAME,b.APPLY_USER_NAME),nvl(a.amt,0) amt,nvl(b.num,0) num from (select APPLY_USER_NAME APPLY_USER_NAME,ROUND(amt*100,2) amt from fact_loan_dashboard where 1=1 and DASHBOARD_ID='A10' and ORG_ID=?1 and BUSI_MONTH = TO_CHAR(SYSDATE, 'yyyymm') and APPLY_USER_NAME IS NOT NULL ) a FULL OUTER JOIN (select APPLY_USER_NAME APPLY_USER_NAME,ROUND(amt*100,2) num from fact_loan_dashboard where 1=1 and DASHBOARD_ID='A11' and ORG_ID=?2 and BUSI_MONTH = TO_CHAR(SYSDATE, 'yyyymm') and APPLY_USER_NAME IS NOT NULL ) b on a.APPLY_USER_NAME=b.APPLY_USER_NAME order by a.amt,nlssort( a.APPLY_USER_NAME,'NLS_SORT=SCHINESE_PINYIN_M')");
			params.add(orgId);
			params.add(orgId);
		}
		
		List<Object[]> list=dynamicQuery.nativeQuery(strBuffer.toString(), params.toArray());
		if(list==null||list.isEmpty()){
			return null;
		}
		ColumnAndLineChartInfo series= new ColumnAndLineChartInfo();
		ColumnAndLineChartInfo.LciXAxis xAxis=series.new LciXAxis();
		Object[] objs=null;
		String month=null;
		BigDecimal amt=null;
		BigDecimal count=null;
		
		for (int i = 0,len=list.size(); i < len; i++) {
			objs=(Object[])list.get(i);
			month=CommonHelper.toStr(objs[0]);
		    amt=CommonHelper.toBigDecimal(objs[1]);
		   
//			amt=amt.movePointLeft(4).setScale(2, BigDecimal.ROUND_HALF_UP);
			series.getSeriesColumn().add(amt);
				
			count=CommonHelper.toBigDecimal(objs[2]);
			series.getSeriesPercent().add(count);
			xAxis.getCategories().add(month);
		}
		series.setxAxis(xAxis);
		
		return series;
	}
	
}


