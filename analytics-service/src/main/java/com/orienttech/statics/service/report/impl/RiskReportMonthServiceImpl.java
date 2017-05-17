package com.orienttech.statics.service.report.impl;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.orienttech.statics.commons.dynamicquery.DynamicQuery;
import com.orienttech.statics.commons.utils.CommonHelper;
import com.orienttech.statics.dao.entity.financialreport.RiskReportMonth;
import com.orienttech.statics.service.cognos.ReportRunnerService;
import com.orienttech.statics.service.model.report.RiskReportMonthBo;
import com.orienttech.statics.service.report.RiskReportMonthService;
/**   
 * 类名称：RiskReportMonthServiceImpl
 * 类描述 ：
 * 创建人:liqiao
 * 创建时间：2015年7月20日 下午3:08:54  
 * 修改人：liqiao
 * 修改时间：
 * 修改备注：
 * 版本： V1.0
 */
@Service
public class RiskReportMonthServiceImpl implements RiskReportMonthService {

	@Autowired
	private DynamicQuery dynamicQuery;
	@Autowired
	private ReportRunnerService reportRunnerService;
	public RiskReportMonthBo searchLastMonthTotalByCondition(RiskReportMonthBo bo, String lbusiMonth){
		StringBuffer sb = new StringBuffer();
		sb.append("select sum(r.amt1),sum(r.amt2) from risk_report_month r where r.busi_period <= ?1 and r.report_id='Z40' order by r.busi_period");
		List<Object[]> objList = dynamicQuery.nativeQuery(sb.toString(), lbusiMonth);
		if(objList.size()==0 || objList==null){
			return null;
		}
		BigDecimal secondNum1 = BigDecimal.ZERO;
		BigDecimal secondNum2 = BigDecimal.ZERO;
		for(Object[] objs: objList){
			secondNum1 = CommonHelper.toBigDecimal(objs[0]);
			secondNum2 = CommonHelper.toBigDecimal(objs[1]);
		}
		bo.setSecondNum1(secondNum1);
		bo.setSecondNum2(secondNum2);
		return bo;
	}
	public RiskReportMonthBo searchLastMonthDataByCondition(RiskReportMonthBo bo, String lbusiMonth){
		StringBuffer buffer=new StringBuffer();
		buffer.append(" SELECT REPORT_ID ,BUSI_PERIOD, ORG_NAME, ORG_AREA, ORG_CNT,CLASSIFY,RANK_NUM,AMT1,AMT2,AMT3,AMT4,AMT5,AMT6,AMT7,AMT8,AMT9,AMT10,AMT11,MEMO");
		buffer.append(" FROM RISK_REPORT_MONTH WHERE BUSI_PERIOD =?1");
		buffer.append(" ORDER BY REPORT_ID");
		
		List<Object[]> objList = dynamicQuery.nativeQuery(Object[].class, buffer.toString(), lbusiMonth);
		if(objList.size()==0 || objList==null){
			return null;
		}
        for(Object[] objs: objList){
        	String lreport_id = CommonHelper.toStr(objs[0]);
//			String lbusi_period = CommonHelper.toStr(objs[1]);
//			String lorg_name = CommonHelper.toStr(objs[2]);
//			String lorg_area = CommonHelper.toStr(objs[3]);
//			Integer lorg_cnt =  CommonHelper.toInt(objs[4]);
//			String lclassify = CommonHelper.toStr(objs[5]);
//			Integer lrank_num =  CommonHelper.toInt(objs[6]);
			BigDecimal lamt1 = CommonHelper.toBigDecimal(objs[7]);
			BigDecimal lamt2 = CommonHelper.toBigDecimal(objs[8]);
			BigDecimal lamt3 = CommonHelper.toBigDecimal(objs[9]);
			BigDecimal lamt4 = CommonHelper.toBigDecimal(objs[10]);
			BigDecimal lamt5 = CommonHelper.toBigDecimal(objs[11]);
			BigDecimal lamt6 = CommonHelper.toBigDecimal(objs[12]);
			BigDecimal lamt7 = CommonHelper.toBigDecimal(objs[13]);
//			BigDecimal lamt8 = CommonHelper.toBigDecimal(objs[14]);
//			BigDecimal lamt9 = CommonHelper.toBigDecimal(objs[15]);
//			BigDecimal lamt10 = CommonHelper.toBigDecimal(objs[16]);
//			BigDecimal lamt11 = CommonHelper.toBigDecimal(objs[17]);
//			String lmemo = CommonHelper.toStr(objs[18]);
		
			if(lreport_id.equals("Z20")){
				bo.setFirstNum2(lamt1);//结存贷款余额
			}
			if(lreport_id.equals("Z20")){
				bo.setFirstNum4(lamt3);//上月逾期贷款金额
			}
			if(lreport_id.equals("Z20")){
				bo.setFirstMoney1(lamt5);//不良贷款金额
			}
			if(lreport_id.equalsIgnoreCase("Z20") && lamt6 != null){
				bo.setFisrtPercent3(lamt6);//逾期率
			}
			if(lreport_id.equalsIgnoreCase("Z20") && lamt7 != null){
				bo.setFisrtPercent6(lamt7);//不良率
			}

//			if(lreport_id.equalsIgnoreCase("Z40") && lamt1 != null){
//				bo.setSecondNum1(lamt1);//投放贷款
//			}
//			if(lreport_id.equalsIgnoreCase("Z40") && lamt2 != null){
//				bo.setSecondNum2(lamt2);//投放户数
//			}
			if(lreport_id.equalsIgnoreCase("Z50") && lamt1 != null){
				bo.setSecondNum3(lamt1);//贷款余额
			}
			if(lreport_id.equalsIgnoreCase("Z50") && lamt2 != null){
				bo.setSecondNum4(lamt2);//结存户数
			}
			if(lreport_id.equalsIgnoreCase("Z50") && lamt3 != null){
				bo.setSecondNum5(lamt3);//户均余额
			}
        }
        this.searchLastMonthTotalByCondition(bo,lbusiMonth);
		return bo;
	}
	/**
	 * 查询去年末数据
	 * @param bo
	 * @param lbusiYearEnd
	 * @return
	 */
	public RiskReportMonthBo searchLastYearEndDataByCondition(RiskReportMonthBo bo, String lbusiYearEnd){
		StringBuffer strBuffer=new StringBuffer();
		strBuffer.append(" SELECT REPORT_ID ,BUSI_PERIOD, ORG_NAME, ORG_AREA, ORG_CNT,CLASSIFY,RANK_NUM,AMT1,AMT2,AMT3,AMT4,AMT5,AMT6,AMT7,AMT8,AMT9,AMT10,AMT11,MEMO");
		strBuffer.append(" FROM RISK_REPORT_MONTH WHERE BUSI_PERIOD =?1");
		strBuffer.append(" ORDER BY REPORT_ID");
		
		List<Object[]> objList = dynamicQuery.nativeQuery(Object[].class, strBuffer.toString(), lbusiYearEnd);
		if(objList.size()==0 || objList==null){
			return null;
		}
		for(Object[] objs: objList){
			String lreport_id = CommonHelper.toStr(objs[0]);
//			String lbusi_period = CommonHelper.toStr(objs[1]);
//			String lorg_name = CommonHelper.toStr(objs[2]);
//			String lorg_area = CommonHelper.toStr(objs[3]);
//			Integer lorg_cnt =  CommonHelper.toInt(objs[4]);
//			String lclassify = CommonHelper.toStr(objs[5]);
//			Integer lrank_num =  CommonHelper.toInt(objs[6]);
			BigDecimal lamt1 = CommonHelper.toBigDecimal(objs[7]);
			BigDecimal lamt2 = CommonHelper.toBigDecimal(objs[8]);
//			BigDecimal lamt3 = CommonHelper.toBigDecimal(objs[9]);
			BigDecimal lamt4 = CommonHelper.toBigDecimal(objs[10]);
//			BigDecimal lamt5 = CommonHelper.toBigDecimal(objs[11]);
			BigDecimal lamt6 = CommonHelper.toBigDecimal(objs[12]);
			BigDecimal lamt7 = CommonHelper.toBigDecimal(objs[13]);
//			BigDecimal lamt8 = CommonHelper.toBigDecimal(objs[14]);
//			BigDecimal lamt9 = CommonHelper.toBigDecimal(objs[15]);
//			BigDecimal lamt10 = CommonHelper.toBigDecimal(objs[16]);
//			BigDecimal lamt11 = CommonHelper.toBigDecimal(objs[17]);
//			String lmemo = CommonHelper.toStr(objs[18]);
			
			//从这里开始组织BO(使用的是上年同期的数据)
//			if( lreport_id.equals("Z20") ){
//				bo.setFirstNum3(lamt2) ;   //上一年逾期贷款金额
//			}
//			if( lreport_id.equals("Z20") ){
//				bo.setFirstMoney(lamt4) ;   //上一年不良贷款金额
//			}
//			if( lreport_id.equalsIgnoreCase("Z20") && lamt6 != null){
//				bo.setFisrtPercent2(lamt6);//逾期率
//			}
//			if( lreport_id.equalsIgnoreCase("Z20") && lamt7 != null){
//				bo.setFisrtPercent5(lamt7);//不良率
//			}
			//第二章 历史及本年信贷资产情况
			//二、本年净化及恶化情况
			if( lreport_id.equalsIgnoreCase("Z54") && lamt1 != null){
				bo.setSecondNum14(lamt1);//去年末全辖逾期贷款余额
			}
		}
		return bo;
	}
	
	@Override
	public RiskReportMonthBo searchByCondition(String condition){
		StringBuffer sb = new StringBuffer("select t.report_id,t.busi_period,t.org_name,t.org_area,t.org_cnt,"
				+ "t.classify, t.rank_num, t.amt1,t.amt2,t.amt3,t.amt4,t.amt5,t.amt6,t.amt7,t.amt8,t.amt9,t.amt10,t.amt11,t.memo"
				+ " from RISK_REPORT_MONTH t where t.busi_period=?1"
				+ " order by t.rank_num");
		RiskReportMonthBo bo = new RiskReportMonthBo();
		//统计日期
		bo.setBusidate(condition);
		//要生成word的名称
		String time = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		bo.setOutFileName(time);
		
		List<Object[]> objsList = dynamicQuery.nativeQuery(Object[].class, sb.toString(), condition);
		if(objsList.size()==0 || objsList==null){
			return null;
		}
		for(Object[] objs: objsList){
			String report_id = CommonHelper.toStr(objs[0]);
			String busi_period = CommonHelper.toStr(objs[1]);
			String org_name = CommonHelper.toStr(objs[2]);
			String org_area = CommonHelper.toStr(objs[3]);
			Integer org_cnt =  CommonHelper.toInt(objs[4]);
			String classify = CommonHelper.toStr(objs[5]);
			Integer rank_num =  CommonHelper.toInt(objs[6]);
			BigDecimal amt1 = CommonHelper.toBigDecimal(objs[7]);
			BigDecimal amt2 = CommonHelper.toBigDecimal(objs[8]);
			BigDecimal amt3 = CommonHelper.toBigDecimal(objs[9]);
			BigDecimal amt4 = CommonHelper.toBigDecimal(objs[10]);
			BigDecimal amt5 = CommonHelper.toBigDecimal(objs[11]);
			BigDecimal amt6 = CommonHelper.toBigDecimal(objs[12]);
			BigDecimal amt7 = CommonHelper.toBigDecimal(objs[13]);
			BigDecimal amt8 = CommonHelper.toBigDecimal(objs[14]);
			BigDecimal amt9 = CommonHelper.toBigDecimal(objs[15]);
			BigDecimal amt10 = CommonHelper.toBigDecimal(objs[16]);
			BigDecimal amt11 = CommonHelper.toBigDecimal(objs[17]);
			String memo = CommonHelper.toStr(objs[18]);
			
			//第一部分 资产质量状况简报
			//第一章	信贷资产的整体情况
			if( report_id.equalsIgnoreCase("Z10") && amt1 != null){
				bo.setOrg_cnt(amt1.intValue());//机构数
			}	
			if( report_id.equalsIgnoreCase("Z20") && amt1 != null){
				bo.setFirstNum1((amt1));//结存贷款余额
			}			
			if( report_id.equalsIgnoreCase("Z20") && amt6 != null){
				bo.setFisrtPercent2(amt6);//逾期率
			}			
			if( report_id.equalsIgnoreCase("Z20") && amt7 != null){
				bo.setFisrtPercent5(amt7);//不良率
			}
			if( report_id.equalsIgnoreCase("Z20") && amt3 != null){
				bo.setFirstNum3(amt3);
			}
			if( report_id.equals("Z20") ){
				bo.setFirstMoney(amt5);//不良贷款金额
			}
			//第二章 历史及本年信贷资产情况
			//一、历史及本年总体概况(本月)				
			if( report_id.equalsIgnoreCase("Z50") && amt2 != null){
				bo.setSecondNum6(amt2);//本月结存户数
			}
			if( report_id.equalsIgnoreCase("Z51") && amt1 != null){
				bo.setSecondNum7(amt1);//本月新增投放贷款结存规模
			}
			if( report_id.equalsIgnoreCase("Z51") && amt2 != null){
				bo.setSecondNum8(amt2);//本月新增结存户数
			}
			if( report_id.equalsIgnoreCase("Z51") && amt3 != null){
				bo.setSecondNum9(amt3);//本月新增投放结存户均余额
			}
			if( report_id.equalsIgnoreCase("Z58") && amt1 != null){
				bo.setSecondNum10(amt1);//新增投放产生的逾期
			}
			//TODO
			if( report_id.equalsIgnoreCase("Z52") && amt1 != null){
				bo.setSecondNum101(amt1);//新增投放产生的逾期
			}
			
			if( report_id.equalsIgnoreCase("Z58") && amt3 != null){
				bo.setSecondNum11(amt3);//全辖本年逾期率
			}
			if( report_id.equalsIgnoreCase("Z52") && amt3 != null){
				bo.setSecondNum111(amt3);//全辖本年逾期率
			}
			
			if( report_id.equalsIgnoreCase("Z59") && amt1 != null){
				bo.setSecondNum12(amt1);//本年新增投放的不良规模
			}
			if( report_id.equalsIgnoreCase("Z53") && amt1 != null){
				bo.setSecondNum121(amt1);//本年新增投放的不良规模
			}
			
			if( report_id.equalsIgnoreCase("Z59") && amt3 != null){
				bo.setSecondNum13(amt3);//不良率
			}
			if( report_id.equalsIgnoreCase("Z53") && amt3 != null){
				bo.setSecondNum131(amt3);//不良率
			}
			
			if( report_id.equalsIgnoreCase("Z56") && amt1 != null){
				bo.setSecondNum16(amt1);//本月不良迁徙情况贷款
			}
			if( report_id.equalsIgnoreCase("Z55") && amt2 != null){
				bo.setSecondNum17(amt2);//本月逾期贷款余额减少额
			}
			if( report_id.equalsIgnoreCase("Z57") && amt1 != null){
				bo.setSecondNum18(amt1);//本月逾期贷款余额减少额
			}
			//二、本年净化及恶化情况
			//不良迁徙情况(恶化)
			if( report_id.equalsIgnoreCase("Z56") && amt1 != null){
				bo.setFirstNum7(amt1);//由逾期迁徙至不良类别
			}
			if( report_id.equalsIgnoreCase("Z57") && amt1 != null){
				bo.setFirstNum8(amt1);//平均迁徙率
				bo.setFirstNum9(amt2);//本月迁徙率
			}
			
					
			RiskReportMonth tabledata = new RiskReportMonth();
			tabledata.setReportId(report_id);
			tabledata.setBusiPeriod(busi_period);
			tabledata.setOrgName(org_name);
			tabledata.setOrgarea(org_area);
			tabledata.setOrgcnt(org_cnt);
			tabledata.setClassify(classify);
			tabledata.setRankNum(rank_num);
			tabledata.setAmt1(amt1);
			tabledata.setAmt2(amt2) ;
			tabledata.setAmt3(amt3);
			tabledata.setAmt4(amt4);
			tabledata.setAmt5(amt5) ;
			tabledata.setAmt6(amt6);
			tabledata.setAmt7(amt7);
			tabledata.setAmt8(amt8) ;
			tabledata.setAmt9(amt9);
			tabledata.setAmt10(amt10);	
			tabledata.setAmt11(amt11);
			tabledata.setMemo(memo);
			
			//第一部分 资产质量状况简报      第二章 历史及本年信贷资产情况
			//表三：各机构当月逾期和不良对比
			if(report_id.equalsIgnoreCase("Z80")){
				bo.setTabledata3(tabledata);
			}
			//表四：2015年旧口径新增逾期贷款逾期率
			if(report_id.equalsIgnoreCase("Z90")){
				bo.setTabledata4(tabledata);
			}
			//表五：2015年旧口径新增不良贷款不良率
			if(report_id.equalsIgnoreCase("Z100")){
				bo.setTabledata5(tabledata);
			}
			//表六：2015年新增投放逾期贷款逾期率
			if(report_id.equalsIgnoreCase("Z110")){
				bo.setTabledata6(tabledata);
			}
			//表七：2015年新增投放不良贷款不良率
			if(report_id.equalsIgnoreCase("Z120")){
				bo.setTabledata7(tabledata);
			}
			//第一部分 资产质量状况简报     第三章 资产五级分类情况汇总表
			//TODO 表八：全辖资产五级分类统计
			if(report_id.equalsIgnoreCase("Z130")){
				bo.setTabledata8(tabledata);
			}
			if(report_id.equalsIgnoreCase("Z131")){
				bo.setTabledata81(tabledata);
			}
			
			//表九  小贷公司五级分类统计
			if( report_id.equalsIgnoreCase("Z140")){
				bo.setTabledata9(tabledata);
			}
			//表十 小贷公司八级分类规模占比分布统计
			if( report_id.equalsIgnoreCase("Z150")){
				bo.setTabledata10(tabledata);
			}

			//第二部分 风险分析报告
			//表一 各区域资产结构整体情况
			if( report_id.equalsIgnoreCase("R10")){
				bo.setTabledata101(tabledata);
			}
			//表二 机构与区域风险指标对比
			if( report_id.equalsIgnoreCase("R20")){
				bo.setTabledata102(tabledata);
			}
			//表三 各贷款额度区间资产结构分布(1)
			if( report_id.equalsIgnoreCase("R30")){
				bo.setTabledata103a(tabledata);
			}
			//表三 各贷款额度区间资产结构分布(2) 贷款期限
			if( report_id.equalsIgnoreCase("R40")){
				bo.setTabledata103b(tabledata);
			}
			//表五 各担保方式资产结构分布
			if( report_id.equalsIgnoreCase("R50")){
				bo.setTabledata105(tabledata);
			}
			//表六 各利率区间资产结构分布
			if( report_id.equalsIgnoreCase("R70")){
				bo.setTabledata106(tabledata);
			}
			//表七 各还款方式资产结构分布
			if( report_id.equalsIgnoreCase("R80")){
				bo.setTabledata107(tabledata);
			}
			//表八 各投放行业资产结构分布
			if( report_id.equalsIgnoreCase("R90")){
				bo.setTabledata108(tabledata);
			}
			//表九 各客户来源资产结构分布
			if( report_id.equalsIgnoreCase("R60")){
				bo.setTabledata109(tabledata);//各客户来源资产结构分布
			}
			//表十 各产品资产结构分布
			if( report_id.equalsIgnoreCase("R110")){
				bo.setTabledata1011(tabledata);
			}
			//表  迁徙率
//			if( report_id.equalsIgnoreCase("R100")){
//				bo.setTabledata1010(tabledata);//违约滚动率和回滚率分析
//			}
		}
		//上年末
		String lbusiYearEnd=String.valueOf(Integer.parseInt(condition.substring(0,4))-1+"12");
		this.searchLastYearEndDataByCondition(bo, lbusiYearEnd);
		
		//上个月
	    String lbusiMonth = "";
	    if(condition.substring(4, 6).equals("01")){
	    	lbusiMonth = Integer.parseInt(condition.substring(0, 4))-1 +"12";
	    }else{
	    	lbusiMonth = Integer.parseInt(condition)-1 +"";
	    }
	    this.searchLastMonthDataByCondition(bo, lbusiMonth);
	    
	    //第一部分 资产质量状况简报
        //表一  逾期净增对比
		StringBuffer sb1= new StringBuffer("select REPORT_ID,BUSI_PERIOD,ORG_NAME,AMT1,"
			+ " (AMT1 - DECODE(AMT11,null,'0',AMT11) ) as dtabl,( AMT1 -DECODE(AMT22,null,'0',AMT22)) as etabl"
			+ " from (select REPORT_ID,BUSI_PERIOD,ORG_NAME,AMT1,"
            + " (select AMT1 from (select REPORT_ID, BUSI_PERIOD, ORG_NAME, AMT1 from risk_report_month WHERE BUSI_PERIOD ="
			+ lbusiMonth
            + " AND REPORT_ID = 'Z60' order by AMT1 ) B where a.org_name = b.org_name) AMT11,"
            + " (select AMT1 from (select REPORT_ID, BUSI_PERIOD, ORG_NAME, AMT1 from risk_report_month WHERE BUSI_PERIOD = "
            + lbusiYearEnd
            + " AND REPORT_ID = 'Z60' order by AMT1) c where a.org_name = c.org_name) AMT22"
            + " from (select REPORT_ID, BUSI_PERIOD, ORG_NAME, AMT1 from risk_report_month WHERE BUSI_PERIOD = ?1"
            + " AND REPORT_ID = 'Z60'  order by AMT1) A)");
    		
		List<Object[]> objsListTab = dynamicQuery.nativeQuery(Object[].class, sb1.toString(), condition);
		if(objsListTab.size()==0 || objsListTab==null){
			return null;
		}
		for(Object[] objs: objsListTab){
			String report_id = CommonHelper.toStr(objs[0]);
			String busi_period = CommonHelper.toStr(objs[1]);
			String org_name = CommonHelper.toStr(objs[2]);
			BigDecimal amt1 = CommonHelper.toBigDecimal(objs[3]);
			BigDecimal dtabl = CommonHelper.toBigDecimal(objs[4]);
			BigDecimal etabl = CommonHelper.toBigDecimal(objs[5]);	
			
			RiskReportMonth tabledata = new RiskReportMonth();
			tabledata.setReportId(report_id);
			tabledata.setBusiPeriod(busi_period);
			tabledata.setOrgName(org_name);
			tabledata.setAmt1(amt1);
			tabledata.setDtabl(dtabl);
			tabledata.setEtabl(etabl);	
				
			//表1 逾期净增对比
			if(report_id.equals("Z60") && org_name !=null ){
			    bo.setTabledata1(tabledata);//表1	
			}
		}
    	
        //表二 不良净增对比
 		StringBuffer sb2= new StringBuffer("select REPORT_ID,BUSI_PERIOD,ORG_NAME,AMT1,"
			+ " (AMT1- DECODE(AMT11,null,'0',AMT11)) as dtabl,(AMT1 -DECODE(AMT22,null,'0',AMT22)) as etabl"
			+ " from (select REPORT_ID,BUSI_PERIOD,ORG_NAME,AMT1,"
            + " (select AMT1 from (select REPORT_ID, BUSI_PERIOD, ORG_NAME, AMT1 from risk_report_month WHERE BUSI_PERIOD ="
			+ lbusiMonth
            + " AND REPORT_ID = 'Z70' order by AMT1 ) B where a.org_name = b.org_name) AMT11,"
            + " (select AMT1 from (select REPORT_ID, BUSI_PERIOD, ORG_NAME, AMT1 from risk_report_month WHERE BUSI_PERIOD = "
            + lbusiYearEnd
            + " AND REPORT_ID = 'Z70' order by AMT1) c where a.org_name = c.org_name) AMT22"
            + " from (select REPORT_ID, BUSI_PERIOD, ORG_NAME, AMT1 from risk_report_month WHERE BUSI_PERIOD = ?1"
            + " AND REPORT_ID = 'Z70'  order by AMT1) A)");
     		
 		List<Object[]> objsListTab2 = dynamicQuery.nativeQuery(Object[].class, sb2.toString(), condition);
 		if(objsListTab2.size()==0 || objsListTab2==null){
 			return null;
 		}
 		for(Object[] objs: objsListTab2){
 			String report_id = CommonHelper.toStr(objs[0]);
 			String busi_period = CommonHelper.toStr(objs[1]);
 			String org_name = CommonHelper.toStr(objs[2]);
 			BigDecimal amt1 = CommonHelper.toBigDecimal(objs[3]);
 			BigDecimal dtabl = CommonHelper.toBigDecimal(objs[4]);
 			BigDecimal etabl = CommonHelper.toBigDecimal(objs[5]);	
 			
 			//组装成RiskReportMonth
 			RiskReportMonth tabledata1 = new RiskReportMonth();
 			tabledata1.setReportId(report_id);
 			tabledata1.setBusiPeriod(busi_period);
 			tabledata1.setOrgName(org_name);
 			tabledata1.setAmt1(amt1);
 			tabledata1.setDtabl(dtabl);
 			tabledata1.setEtabl(etabl);	
 			//表2 不良净增对比 
 			if(report_id.equals("Z70") && org_name !=null ){
 			    bo.setTabledata2(tabledata1);//表2	
 			}
     	}
 		
		//专门处理第二部分风险报告 表10  违约滚动率和回滚率分析
		String secTim=String.valueOf(bo.getBusidate().substring(0,6));	
		StringBuffer strSec=new StringBuffer();
		strSec.append(" SELECT REPORT_ID ,BUSI_PERIOD, ORG_NAME, ORG_AREA, ORG_CNT,CLASSIFY,RANK_NUM,AMT1,AMT2,AMT3,AMT4,AMT5,AMT6,AMT7,AMT8,AMT9,AMT10,AMT11,MEMO");
		strSec.append(" FROM RISK_REPORT_MONTH WHERE REPORT_ID='R100' AND BUSI_PERIOD LIKE '%" + secTim + "%'");
		//strSec.append(" FROM RISK_REPORT_MONTH WHERE REPORT_ID='R100' AND BUSI_PERIOD = secTim ");
		strSec.append(" ORDER BY REPORT_ID,BUSI_PERIOD,RANK_NUM ");
		List<Object[]> objListSec = dynamicQuery.nativeQuery(Object[].class, strSec.toString());
		if(objListSec.size()==0 || objListSec==null){
			return null;
		}
		
        for(Object[] objs: objListSec){
			String secreport_id = CommonHelper.toStr(objs[0]);
			String secbusi_period = CommonHelper.toStr(objs[1]);
			String secorg_name = CommonHelper.toStr(objs[2]);
			String secorg_area = CommonHelper.toStr(objs[3]);
			Integer secorg_cnt =  CommonHelper.toInt(objs[4]);
			String secclassify = CommonHelper.toStr(objs[5]);
			Integer secrank_num =  CommonHelper.toInt(objs[6]);
			BigDecimal secamt1 = CommonHelper.toBigDecimal(objs[7]);
			BigDecimal secamt2 = CommonHelper.toBigDecimal(objs[8]);
			BigDecimal secamt3 = CommonHelper.toBigDecimal(objs[9]);
			BigDecimal secamt4 = CommonHelper.toBigDecimal(objs[10]);
			BigDecimal secamt5 = CommonHelper.toBigDecimal(objs[11]);
			BigDecimal secamt6 = CommonHelper.toBigDecimal(objs[12]);
			BigDecimal secamt7 = CommonHelper.toBigDecimal(objs[13]);
			BigDecimal secamt8 = CommonHelper.toBigDecimal(objs[14]);
			BigDecimal secamt9 = CommonHelper.toBigDecimal(objs[15]);
			BigDecimal secamt10 = CommonHelper.toBigDecimal(objs[16]);
			BigDecimal secamt11 = CommonHelper.toBigDecimal(objs[17]);
			String secmemo = CommonHelper.toStr(objs[18]);

			RiskReportMonth sectabledata = new RiskReportMonth();
			sectabledata.setReportId(secreport_id);
			sectabledata.setBusiPeriod(secbusi_period);
			sectabledata.setOrgName(secorg_name);
			sectabledata.setOrgarea(secorg_area);
			sectabledata.setOrgcnt(secorg_cnt);
			sectabledata.setClassify(secclassify);
			sectabledata.setRankNum(secrank_num);
			sectabledata.setAmt1(secamt1);
			sectabledata.setAmt2(secamt2) ;
			sectabledata.setAmt3(secamt3);
			sectabledata.setAmt4(secamt4);
			sectabledata.setAmt5(secamt5) ;
			sectabledata.setAmt6(secamt6);
			sectabledata.setAmt7(secamt7);
			sectabledata.setAmt8(secamt8) ;
			sectabledata.setAmt9(secamt9);
			sectabledata.setAmt10(secamt10);	
			sectabledata.setAmt11(secamt11);
			sectabledata.setMemo(secmemo);
			//表十 违约滚动率和回滚率分析
			bo.setTabledata1010(sectabledata);
        }
		return bo;
	}
	@Override
	public Map<String, Object> toGetMap(RiskReportMonthBo bo) {
		Map<String, Object> dataMap = new HashMap<String, Object>();
		//今年
		String firstYear = bo.getBusidate().substring(0,4);
		//上一年
		String firstLastYear =String.valueOf(Integer.parseInt(bo.getBusidate().substring(0,4))-1); 
		//月如果月份是0开头，把0截掉吧
		String firstMonth="";
		if (bo.getBusidate().substring(4,5).equals("0")){ 
			firstMonth = bo.getBusidate().substring(5,6);
		}else{ 
			firstMonth = bo.getBusidate().substring(4,6);
		}	
		//上一个月
//		String firsrtLastMoth =String.valueOf(Integer.parseInt(firstMonth)-1); 
		String firsrtLastMoth ="";
		if(firstMonth.equals("1")){
			firsrtLastMoth = "12";
		}else{
			firsrtLastMoth =String.valueOf(Integer.parseInt(firstMonth)-1);
		}
		//机构数
		String companycount = String.valueOf(bo.getOrg_cnt());
		
		/****************************信贷资产的整体情况**********************************/
		//结存贷款余额
		String firstNum1 = String.valueOf(bo.getFirstNum1().divide(new BigDecimal(10000)).setScale(2, BigDecimal.ROUND_HALF_UP));
		//上个月结存贷款余额
		String firstNum2 = String.valueOf(bo.getFirstNum2().divide(new BigDecimal(10000)).setScale(2, BigDecimal.ROUND_HALF_UP));
		//上年月逾期贷款余额
		String firstNum3 = String.valueOf(bo.getFirstNum3().divide(new BigDecimal(10000)).setScale(2, BigDecimal.ROUND_HALF_UP));
		//上个月逾期贷款余额
		String firstNum4 = String.valueOf(bo.getFirstNum4().divide(new BigDecimal(10000)).setScale(2, BigDecimal.ROUND_HALF_UP));
		//不良贷款金额
		String firstMoney = String.valueOf(bo.getFirstMoney().divide(new BigDecimal(10000)).setScale(2, BigDecimal.ROUND_HALF_UP));
		//上月不良贷款金额
		String firstMoney1 = String.valueOf(bo.getFirstMoney1().divide(new BigDecimal(10000)).setScale(2, BigDecimal.ROUND_HALF_UP));
		//上年逾期率
		String fisrtPercent2 = String.valueOf(bo.getFisrtPercent2());
		//上月逾期率
		String fisrtPercent3 = String.valueOf(bo.getFisrtPercent3());
		//上年不良率
		String fisrtPercent5 = String.valueOf(bo.getFisrtPercent5());
		//上月不良率
		String fisrtPercent6 = String.valueOf(bo.getFisrtPercent6());
		
  	    //结存贷款余额"上升"或"下降"
  	    String contractamtflag = "";
  	    String fisrtPercent = "";
		if (bo.getFirstNum1().compareTo(bo.getFirstNum2())<=0){
			contractamtflag="下降";
			BigDecimal a1 = bo.getFirstNum2().subtract(bo.getFirstNum1());
			BigDecimal a2 = a1.multiply(new BigDecimal(100)).divide(bo.getFirstNum2(),4).setScale(2, BigDecimal.ROUND_HALF_UP); 
			fisrtPercent = a2.toString();
		}else {
			contractamtflag="上升";
			BigDecimal a1 = bo.getFirstNum1().subtract(bo.getFirstNum2());
			BigDecimal a2 = a1.multiply(new BigDecimal(100)).divide(bo.getFirstNum1(),4).setScale(2, BigDecimal.ROUND_HALF_UP); 
			fisrtPercent = a2.toString();
  	    }
		
  	    //逾期贷款金额"上升"或"下降"
  	    String contractamtflag1="";
  	    String fisrtPercent1 = "";
  	    BigDecimal bb1 = (bo.getFirstNum3() == null ?  new BigDecimal(0.00) :bo.getFirstNum3());//当月逾期贷款余额
  	    BigDecimal bb2 = (bo.getFirstNum4() == null ?  new BigDecimal(0.00) :bo.getFirstNum4());//上个月逾期贷款余额
		if (bb1.compareTo(bb2) <=0){
			contractamtflag1="下降";
			BigDecimal a1 = bb2.subtract(bb1);
//			BigDecimal a2 = a1.multiply(new BigDecimal(100)).divide(bb2,4).setScale(2, BigDecimal.ROUND_HALF_UP);
			BigDecimal a2 = a1.divide(bb2,4,BigDecimal.ROUND_HALF_UP).multiply(new BigDecimal(100));
			fisrtPercent1 = a2.setScale(2, BigDecimal.ROUND_HALF_UP).toString();
		}else {
			contractamtflag1="上升";
			BigDecimal a1 = bb1.subtract(bb2);
//			BigDecimal a2 = a1.multiply(new BigDecimal(100)).divide(bb2,4).setScale(2, BigDecimal.ROUND_HALF_UP);
			BigDecimal a2 = a1.divide(bb2, 4, BigDecimal.ROUND_HALF_UP).multiply(new BigDecimal(100));
			fisrtPercent1 = a2.setScale(2, BigDecimal.ROUND_HALF_UP).toString();
  	    }
		
  	    //逾期率"上升"或"下降"
  	    String contractamtflag2="";
  	    String firstNum5 = "";
  	    BigDecimal cc1 = (bo.getFisrtPercent3() == null ?  new BigDecimal(0.00) :bo.getFisrtPercent3());//上月
  	    BigDecimal cc2 = (bo.getFisrtPercent2() == null ?  new BigDecimal(0.00) :bo.getFisrtPercent2());//本期
		if (cc1.compareTo(cc2) <=0   ){
			contractamtflag2="上升";
			BigDecimal a1 = cc2.subtract(cc1);
			//BigDecimal a2 = a1.divide(bo.getFisrtPercent2(),2,BigDecimal.ROUND_HALF_EVEN).multiply(new BigDecimal(100)); 
			firstNum5 = a1.toString();
  	    }else {
  	    	contractamtflag2="下降";
  	    	BigDecimal a1 = cc1.subtract(cc2);
  	    	//BigDecimal a2 = a1.divide(bo.getFisrtPercent3(),2,BigDecimal.ROUND_HALF_EVEN).multiply(new BigDecimal(100)); 
  	    	firstNum5 = a1.toString();
  	    }
  	    //不良贷款金额"上升"或"下降"
  	    String contractamtflag3="";
  	    String fisrtPercent4 = "";
  	    BigDecimal aa1 = (bo.getFirstMoney1() == null ? new BigDecimal(0.00) :bo.getFirstMoney1());//上期
  	    BigDecimal aa2 = (bo.getFirstMoney() == null ? new BigDecimal(0.00) :bo.getFirstMoney());//本期
		if (aa1.compareTo (aa2) <=0 ){
			contractamtflag3="上升";
			BigDecimal a1 = aa2.subtract(aa1);
			BigDecimal a2 = a1.multiply(new BigDecimal(100)).divide(aa1,2,BigDecimal.ROUND_HALF_UP); 
			fisrtPercent4 = a2.toString();
  	    }else {
  	    	contractamtflag3="下降";
  	    	BigDecimal a1 = aa1.subtract(aa2);
  	    	BigDecimal a2 = a1.multiply(new BigDecimal(100)).divide(aa1,2,BigDecimal.ROUND_HALF_UP); 
  	    	fisrtPercent4 = a2.toString();
  	    }
  	    //不良贷款金额"上升"或"下降"
  	    String contractamtflag4="";
  	    String firstNum6 = null;
  	    BigDecimal dd1 = (bo.getFisrtPercent6() == null ?  new BigDecimal(0.00) :bo.getFisrtPercent6());
  	    BigDecimal dd2 = (bo.getFisrtPercent5() == null ?  new BigDecimal(0.00) :bo.getFisrtPercent5());
		if (dd1.compareTo(dd2) <=0   ){
			contractamtflag4="上升";
			BigDecimal a1 = dd2.subtract(dd1);
			//BigDecimal a2 = a1.divide(bo.getFirstMoney().multiply(new BigDecimal(100))); 
			firstNum6 = a1.toString();
  	    }else {
  	    	contractamtflag4="下降";
  	    	BigDecimal a1 = dd1.subtract(dd2);
  	    	//BigDecimal a2 = a1.divide(bo.getFirstMoney1().multiply(new BigDecimal(100))); 
  	    	firstNum6 = a1.toString();
  	    }
		
		/****************************历史及本年总体概况**********************************/
		/***************上月****************/
		//累计投放贷款
		String secondNum1 = bo.getSecondNum1().divide(new BigDecimal(10000)).setScale(2, BigDecimal.ROUND_HALF_UP).toString();
		//投放户数
		String secondNum2 = String.valueOf(bo.getSecondNum2());
		//贷款余额
		String secondNum3 = String.valueOf(bo.getSecondNum3().divide(new BigDecimal(10000)).setScale(2, BigDecimal.ROUND_HALF_UP));
		//上个月结存户数
		String secondNum4 = String.valueOf(bo.getSecondNum4());
		//户均余额
		String secondNum5 = String.valueOf(bo.getSecondNum5());
		/***************本月****************/
		//本月结存户数
		String secondNum6 = bo.getSecondNum6().divide(new BigDecimal(10000)).setScale(2, BigDecimal.ROUND_HALF_UP).toString();
		//新增投放结存
		String secondNum7 = String.valueOf(bo.getSecondNum7().divide(new BigDecimal(10000)).setScale(2, BigDecimal.ROUND_HALF_UP));
		//新增结存户数
		String secondNum8 = String.valueOf(bo.getSecondNum8());		
		//本月新增户均余额
		String secondNum9 = bo.getSecondNum9().setScale(2, BigDecimal.ROUND_HALF_UP).toString();
		//新增逾期贷款余额
		String secondNum10 = String.valueOf(bo.getSecondNum10().divide(new BigDecimal(10000)).setScale(2, BigDecimal.ROUND_HALF_UP));
		String secondNum101 = String.valueOf(bo.getSecondNum101().divide(new BigDecimal(10000)).setScale(2, BigDecimal.ROUND_HALF_UP));
		//新增逾期率
		String secondNum11 = String.valueOf(bo.getSecondNum11());
		String secondNum111 = String.valueOf(bo.getSecondNum111());
		//本年新增不良贷款余额
		String secondNum12 = String.valueOf(bo.getSecondNum12().divide(new BigDecimal(10000)).setScale(2, BigDecimal.ROUND_HALF_UP));
		String secondNum121 = String.valueOf(bo.getSecondNum121().divide(new BigDecimal(10000)).setScale(2, BigDecimal.ROUND_HALF_UP));
		//新增不良率
		String secondNum13 = String.valueOf(bo.getSecondNum13());
		String secondNum131 = String.valueOf(bo.getSecondNum131());

		//去年末全辖逾期贷款余额
		String secondNum14 = String.valueOf(bo.getSecondNum14().divide(new BigDecimal(10000)).setScale(2, BigDecimal.ROUND_HALF_UP));
		
		//（2015年前逾期）的减少额
//		String secondNum15 = bo.getSecondNum14().subtract(bo.getSecondNum17()).toString();
		String contractamtflag5="";
	  	String secondNum15="";
		if (bo.getSecondNum14().compareTo(bo.getSecondNum17()) <=0   ){
			contractamtflag5="增加";
			secondNum15 = bo.getSecondNum17().subtract(bo.getSecondNum14()).toString();
  	    }else {
  	    	contractamtflag5="减少";
  	    	secondNum15 = bo.getSecondNum14().subtract(bo.getSecondNum17()).toString();
  	    }
		
		//本月不良迁徙情况贷款
		String secondNum16 = String.valueOf(bo.getSecondNum16().divide(new BigDecimal(10000)).setScale(2, BigDecimal.ROUND_HALF_UP));
		//本月逾期贷款余额
		String secondNum17 = String.valueOf(bo.getSecondNum17());
		//取各月份的平均值
		String secondNum18 = String.valueOf(bo.getSecondNum18());
		//由逾期迁徙至不良类别的贷款
		String firstNum7 = String.valueOf(bo.getFirstNum7());
		//平均迁徙率
		String firstNum8 = String.valueOf(bo.getFirstNum8());
		//本月迁徙率
		String firstNum9 = String.valueOf(bo.getFirstNum9());
		
		//小贷公司数
		//String companycount = String.valueOf(bo.getCompanycount());
		dataMap.put("firstYear",firstYear);
		dataMap.put("firstMonth",firstMonth);
		dataMap.put("firstNum1",firstNum1);
		dataMap.put("firstNum2",firstNum2);
		dataMap.put("firstNum3",firstNum3);
		dataMap.put("firstNum4",firstNum4);
		dataMap.put("firstNum5",firstNum5);
		dataMap.put("firstNum6",firstNum6);
		dataMap.put("firstNum7",firstNum7);
		dataMap.put("firstNum8",firstNum8);
		dataMap.put("firstNum9",firstNum9);
		
		dataMap.put("firstMoney",firstMoney);
		dataMap.put("firstMoney1",firstMoney1);
		dataMap.put("firsrtLastMoth",firsrtLastMoth);
		dataMap.put("firstLastYear",firstLastYear);
		dataMap.put("fisrtPercent",fisrtPercent);
		dataMap.put("fisrtPercent1",fisrtPercent1);
		dataMap.put("fisrtPercent2",fisrtPercent2);
		dataMap.put("fisrtPercent3",fisrtPercent3);
		dataMap.put("fisrtPercent4",fisrtPercent4);
		dataMap.put("fisrtPercent5",fisrtPercent5);
		dataMap.put("fisrtPercent6",fisrtPercent6);
		
		dataMap.put("contractamtflag",contractamtflag);
		dataMap.put("contractamtflag1",contractamtflag1);
		dataMap.put("contractamtflag2",contractamtflag2);
		dataMap.put("contractamtflag3",contractamtflag3);
		dataMap.put("contractamtflag4",contractamtflag4);
		dataMap.put("contractamtflag5",contractamtflag5);
		
		dataMap.put("secondNum1",secondNum1);
		dataMap.put("secondNum2",secondNum2);
		dataMap.put("secondNum3",secondNum3);
		dataMap.put("secondNum4",secondNum4);
		dataMap.put("secondNum5",secondNum5);
		dataMap.put("secondNum6",secondNum6);
		dataMap.put("secondNum7",secondNum7);
		dataMap.put("secondNum8",secondNum8);
		dataMap.put("secondNum9",secondNum9);
		dataMap.put("secondNum10",secondNum10);
		dataMap.put("secondNum101",secondNum101);
		dataMap.put("secondNum11",secondNum11);
		dataMap.put("secondNum111",secondNum111);
		dataMap.put("secondNum12",secondNum12);
		dataMap.put("secondNum121",secondNum121);
		dataMap.put("secondNum13",secondNum13);
		dataMap.put("secondNum131",secondNum131);
		dataMap.put("secondNum14",secondNum14);
		dataMap.put("secondNum15",secondNum15);
		dataMap.put("secondNum16",secondNum16);
		dataMap.put("secondNum17",secondNum17);
		dataMap.put("secondNum18",secondNum18);
//		dataMap.put("secondNum19",secondNum19);
		dataMap.put("companycount", companycount);

		//第一部分资产质量状况简报
		dataMap.put("tbl1", bo.getTabledata1()) ;
		dataMap.put("tbl2", bo.getTabledata2()) ;	  
		dataMap.put("tbl3", bo.getTabledata3());
		dataMap.put("tbl4", bo.getTabledata4());
		dataMap.put("tbl5", bo.getTabledata5());
		dataMap.put("tbl6", bo.getTabledata6());
		dataMap.put("tbl7", bo.getTabledata7());
		dataMap.put("tbl8", bo.getTabledata8());
		dataMap.put("tbl81", bo.getTabledata81());
		dataMap.put("tbl9", bo.getTabledata9());
		dataMap.put("tbl10", bo.getTabledata10());
		//第二部分风险分析报告
		dataMap.put("tbl101", bo.getTabledata101()); 
		dataMap.put("tbl102", bo.getTabledata102()); 
		dataMap.put("tbl103a", bo.getTabledata103a()); 
		dataMap.put("tbl103b", bo.getTabledata103b()); 
		dataMap.put("tbl105", bo.getTabledata105()) ;
		dataMap.put("tbl106", bo.getTabledata106()) ;
		dataMap.put("tbl107", bo.getTabledata107()) ;
		dataMap.put("tbl108", bo.getTabledata108()) ;
		dataMap.put("tbl109", bo.getTabledata109()) ;
		dataMap.put("tbl1010", bo.getTabledata1010()) ;
		dataMap.put("tbl1011", bo.getTabledata1011()) ;
		
		dataMap.put("tbl1010a", bo.getTabledata1010a()) ;
		return dataMap;
		
	}
}