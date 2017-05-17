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
import com.orienttech.statics.dao.entity.financialreport.FactLoanReportPeriod;
import com.orienttech.statics.service.cognos.ReportRunnerService;
import com.orienttech.statics.service.model.report.FactLoanReportPeriodBo;
import com.orienttech.statics.service.report.TenDaysReportService;
/**   
 * 类名称：TenDaysReportServiceImpl
 * 类描述 ：
 * 创建人:wangxy
 * 创建时间：2015年7月20日 下午3:08:54  
 * 修改人：wangxy
 * 修改时间：
 * 修改备注：
 * 版本： V1.0
 */
@Service
public class TenDaysReportServiceImpl implements TenDaysReportService {

	@Autowired
	private DynamicQuery dynamicQuery;
	@Autowired
	private ReportRunnerService reportRunnerService;
	
	@Override
	public FactLoanReportPeriodBo searchByCondition(String condition){
		
		FactLoanReportPeriodBo bo = new FactLoanReportPeriodBo();
		//统计日期
		bo.setBusidate(condition);
		//要生成word的名称
		String time = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		bo.setOutFileName(time);
		
		StringBuffer sb = new StringBuffer("select t.report_id,t.busi_period,t.rank_num,t.org_id,t.org_name,"
				+ "t.apply_user_id,t.apply_user_name,t.amt1,t.amt2,t.amt3,trim(to_char(amt3,'999999990.00')) memo "
				+ " from fact_loan_report_period t where t.busi_period=?1"
				+ " order by t.report_id,t.rank_num");
    	
		List<Object[]> objsList = dynamicQuery.nativeQuery(Object[].class, sb.toString(), condition);
		if(objsList.size()==0 || objsList==null){
			return null;
		}
		for(Object[] objs: objsList){
			String report_id = CommonHelper.toStr(objs[0]);
			String busi_period = CommonHelper.toStr(objs[1]);
			Integer rank_num = (objs[3]==null ? null:CommonHelper.toInt(objs[2]));
			String org_id = CommonHelper.toStr(objs[3]);
			String org_name = CommonHelper.toStr(objs[4]);
			String apply_user_id = CommonHelper.toStr(objs[5]);
			String apply_user_name = CommonHelper.toStr(objs[6]);
			BigDecimal amt1 = CommonHelper.toBigDecimal(objs[7]);
			BigDecimal amt2 = CommonHelper.toBigDecimal(objs[8]);
			BigDecimal amt3 = CommonHelper.toBigDecimal(objs[9]);
			String memo = CommonHelper.toStr(objs[10]);
			
			//TODO 
			/****************************从这里开始组织BO**********************************/
			
			if(report_id.equalsIgnoreCase("10") && amt1 != null){
				bo.setCompanycount(amt1.intValue());//小贷机构数
			}
			if(report_id.equals("20") && amt1 != null && amt2 != null){
				bo.setContractamt(amt1);//投放贷款金额 
				bo.setContractnum(amt2);//新增贷款笔数
			}
			if(report_id.equals("60") && amt1 != null && amt2 != null){
				bo.setContractamtmini(amt2);//小微贷款金额
				bo.setContractnummini(amt1);//小微贷款笔数
			}
			if(report_id.equals("70") && amt1 != null){
				bo.setContractrate(amt1);//投放贷款年利率
			}
			//TODO
			if(report_id.equals("80") && amt1 != null && amt2 != null){
				bo.setLoanbalamt(amt1);//结存贷款余额
				bo.setLoanbalnum(amt2);//结存贷款户数
				bo.setLoanbalnum1(amt3);//结存贷款笔数
			}
			if(report_id.equals("90") && amt1 != null && amt3 != null){
				bo.setLoanbalnummini(amt2);//小微结存笔数
				bo.setLoanbalamtmini(amt3);//小微结存金额
			}
			if(report_id.equals("100") && amt1 != null){
				bo.setLoanbalrate(amt1);//结存贷款年利率
			}
			
			/****************************开始组织BO表数据**********************************/
			
			FactLoanReportPeriod tabledata = new FactLoanReportPeriod();
			tabledata.setReportId(report_id);
			tabledata.setBusiPeriod(busi_period);
			tabledata.setRankNum(rank_num);
			tabledata.setOrgId(org_id);
			tabledata.setOrgName(org_name);
			tabledata.setApplyUserId(apply_user_id);
			tabledata.setApplyUserName(apply_user_name);
			tabledata.setAmt1(amt1);
			tabledata.setAmt2(amt2);
			tabledata.setAmt3(amt3);
			tabledata.setMemo(memo);
			
			/**表1*/
			if(report_id.equals("110") && org_id != null){
			    bo.setTabledata1(tabledata);
			}
			if(report_id.equals("110") && org_id == null){
			    bo.setTbl1sum1(amt1);
			    bo.setTbl1sum2(amt2);
			    bo.setTbl1sum3(amt3.setScale(2,BigDecimal.ROUND_HALF_UP));
			}
			/**表2*/
			if(report_id.equals("120") && org_id != null){
			    bo.setTabledata2(tabledata);
			}
			if(report_id.equals("120") && org_id == null){
			    bo.setTbl2sum1(amt1);
			    bo.setTbl2sum2(amt2);
			    bo.setTbl2sum3(amt3);
			}
			/**表3*/
			if(report_id.equals("130") && org_id != null){
			    bo.setTabledata3(tabledata);	
			}
			if(report_id.equals("130") && org_id == null){
			    bo.setTbl3sum1(amt1);
			    bo.setTbl3sum2(amt2);
			    bo.setTbl3sum3(amt3.setScale(2,BigDecimal.ROUND_HALF_UP));
			}
			/**表4*/
			if(report_id.equals("140") && org_id != null){
			    bo.setTabledata4(tabledata);	
			}
			if(report_id.equals("140") && org_id == null){
			    bo.setTbl4sum1(amt1);
			    bo.setTbl4sum2(amt2);
			    bo.setTbl4sum3(amt3.setScale(2,BigDecimal.ROUND_HALF_UP));
			}
			/**表5*/
			if(report_id.equals("150") && org_id != null){
			    bo.setTabledata5(tabledata);	
			}
			if(report_id.equals("150") && org_id == null){
			    bo.setTbl5sum1(amt1);
			    bo.setTbl5sum2(amt2);
			    bo.setTbl5sum3(amt3);
			}
			/**表6*/
			if(report_id.equals("160") && org_id != null){
			    bo.setTabledata6(tabledata);	
			}
			if(report_id.equals("160") && org_id == null){
			    bo.setTbl6sum1(amt1);
			    bo.setTbl6sum2(amt2);
			    bo.setTbl6sum3(amt3.setScale(2,BigDecimal.ROUND_HALF_UP));
			}
			/**表7*/
			if(report_id.equals("170") && org_id != null){
			    bo.setTabledata7(tabledata);	
			}
			if(report_id.equals("170") && org_id == null){
			    bo.setTbl7sum1(amt1);
			    bo.setTbl7sum2(amt2);
			    bo.setTbl7sum3(amt3);
			}
			/**表8*/
			if(report_id.equals("180") && org_id != null){
			    bo.setTabledata8(tabledata);	
			}
			if(report_id.equals("180") && org_id == null){
			    bo.setTbl8sum1(amt1);
			    bo.setTbl8sum2(amt2);
			    bo.setTbl8sum3(amt3);
			}
			/**表9*/
			if(report_id.equals("190") && org_id != null){
			    bo.setTabledata9(tabledata);	
			}
			if(report_id.equals("190") && org_id == null){
			    bo.setTbl9sum1(amt1);
			    bo.setTbl9sum2(amt2);
			    bo.setTbl9sum3(amt3);
			}
			/**表10*/
			if(report_id.equals("200") && org_id != null){
			    bo.setTabledata10(tabledata);	
			}
			if(report_id.equals("200") && org_id == null){
			    bo.setTbl10sum1(amt1);
			    bo.setTbl10sum2(amt2);
			    bo.setTbl10sum3(amt3);
			}
		}
		
		/**上年同期*/
		String lcondition=String.valueOf(Integer.parseInt(condition.substring(0,4))-1)+condition.substring(4,7);
		
		StringBuffer strBuffer = new StringBuffer();
		strBuffer.append("select REPORT_ID,BUSI_PERIOD,RANK_NUM,ORG_ID,ORG_NAME,APPLY_USER_ID,APPLY_USER_NAME,AMT1,AMT2,AMT3,MEMO ");
		strBuffer.append(" from FACT_LOAN_REPORT_PERIOD where busi_period =?1");
		strBuffer.append(" order by report_id");
		
		List<Object[]> objList = dynamicQuery.nativeQuery(Object[].class, strBuffer.toString(), lcondition);
		if(objList.size()==0 || objList==null){
			return null;
		}
		for(Object[] objs : objList){
			String lreport_id = CommonHelper.toStr(objs[0]);
			BigDecimal lamt1 = CommonHelper.toBigDecimal(objs[7]);
			BigDecimal lamt2 = CommonHelper.toBigDecimal(objs[8]);
			
			/**从这里开始组织BO(使用的是上年同期的数据)*/
			
			if(lreport_id.equals("20")){
				bo.setLcontractamt(lamt1);//去年同期放款金额
				bo.setLcontractnum(lamt2);//去年同期
			}
			if(lreport_id.equals("80")){
				bo.setLloanbalamt(lamt1);//去年同期放款金额
				bo.setLloanbalnum(lamt2);//去年同期
			}
		}
		return bo;
	}
	
	//TODO toGetMap
	@Override
	public Map<String, Object> toGetMap(FactLoanReportPeriodBo bo) {
		
		Map<String, Object> dataMap = new HashMap<String, Object>();
		
		/****************************开始组装数据_标题**********************************/
		
		//标题"年"
		String busiyear = bo.getBusidate().substring(0,4);
		
		//标题"月",如果月份是0开头，把0截掉吧
		String busimonth="";
		if (bo.getBusidate().substring(4,5).equals("0")){ 
			busimonth = bo.getBusidate().substring(5,6);
		}else{ 
			busimonth = bo.getBusidate().substring(4,6);
		}
		
		//标题"旬度"
		String busiperiod ="";
		switch(Integer.parseInt (bo.getBusidate().substring(6,7))){
			case 1:busiperiod="上";break;
			case 2:busiperiod="中";break;
			case 3:busiperiod="下";break;
		}
	
		/**********************开始组装数据_文本_各邦信小额贷款公司**************************/
		
		//当前系统日期
		Date now = new Date(); 
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy年MM月dd日");
		String sysdate = dateFormat.format(now);
		
		//小贷公司数
		String companycount = String.valueOf(bo.getCompanycount());
		
		//旬度日期范围
		String busiscope="";
		if(bo.getBusidate().substring(6,7).equals("1")){
			//上旬
			busiscope=busiyear+"年"+busimonth+"月1日至"+busimonth+"月10日";  
		}
		if(bo.getBusidate().substring(6,7).equals("2")){
			//中旬
			busiscope=busiyear+"年"+busimonth+"月11日至"+busimonth+"月20日";  
		}
		if(bo.getBusidate().substring(6,7).equals("3")){
			//下旬
			if(busimonth.equals("1")||busimonth.equals("3")||busimonth.equals("5")||busimonth.equals("7")||busimonth.equals("8")||busimonth.equals("10")||busimonth.equals("12")){
				busiscope=busiyear+"年"+busimonth+"月21日至"+busimonth+"月31日";  
		    }
     		if(busimonth.equals("4")||busimonth.equals("6")||busimonth.equals("9")||busimonth.equals("11")){
     			busiscope=busiyear+"年"+busimonth+"月21日至"+busimonth+"月30日";  
		    }
     		if(busimonth.equals("02") && (busiyear.equals("2012")||busiyear.equals("2016")||busiyear.equals("2020"))){
     			busiscope=busiyear+"年"+busimonth+"月21日至"+busimonth+"月29日";  
		    }
     		if(busimonth.equals("02") && !busiyear.equals("2012") && !busiyear.equals("2016")&&!busiyear.equals("2020")){
    			busiscope=busiyear+"年"+busimonth+"月21日至"+busimonth+"月28日";  
		    }
		}
		
		/************************表8的标题**********************************/
		
		String tbl8param = "";
		if(Integer.parseInt(bo.getBusidate().substring(6,7)) ==1){
			tbl8param = busimonth + "月中旬";
		}
		if(Integer.parseInt(bo.getBusidate().substring(6,7)) ==2){
			tbl8param = busimonth + "月下旬";
		}
		if(Integer.parseInt(bo.getBusidate().substring(6,7)) ==3){
			tbl8param = Integer.valueOf(busimonth)+1 + "月上旬";
		}
		
		/***********************贷款总体情况_第一段******************************/
		
		//本旬投放贷款
		String contractamt = bo.getContractamt().divide(new BigDecimal(10000)).setScale(2, BigDecimal.ROUND_HALF_UP).toString();
		
		//去年同期投放贷款
		String lcontractamt = bo.getLcontractamt().divide(new BigDecimal(10000)).setScale(2, BigDecimal.ROUND_HALF_UP).toString();
			 
		//投放金额"增加"或"减少"
		String contractamtflag="";
		String contractamtscope="";
		if(bo.getLcontractamt().compareTo(bo.getContractamt()) <=0   ){
			contractamtflag="增加";
			contractamtscope="增幅";
		}else {
			contractamtflag="减少";
			contractamtscope="降幅";
		}
		  
		//增加减少的差值
		//contractamtsubtract = bo.getContractamt().subtract(bo.getLcontractamt()).divide(new BigDecimal(10000)).abs().setScale(2, BigDecimal.ROUND_HALF_UP).toString();
		String contractamtsubtract = new BigDecimal(contractamt).subtract(new BigDecimal(lcontractamt)).abs().toString();

		//增幅或降幅
		//contractamtfudu =  ( bo.getContractamt().subtract(bo.getLcontractamt())).multiply(new BigDecimal(100)).divide(bo.getLcontractamt(),4).abs().setScale(2, BigDecimal.ROUND_HALF_UP).toString();
		String contractamtfudu = new BigDecimal(contractamt).subtract(new BigDecimal(lcontractamt)).multiply(new BigDecimal(100)).divide(new BigDecimal(lcontractamt),4).abs().setScale(2, BigDecimal.ROUND_HALF_UP).toString();

		//小微贷款金额占比      计算公式：小微贷款金额contractamtmini/投放贷款金额 contractamt
		//先转换成亿元//BigDecimal contractamtminiNum = bo.getContractamtmini().divide(new BigDecimal(10000)).setScale(2, BigDecimal.ROUND_HALF_UP);
		//String contractamtmini = contractamtminiNum.multiply(new BigDecimal(100)).divide(new BigDecimal(contractamt),4).setScale(2, BigDecimal.ROUND_HALF_UP).toString();
		String contractamtmini = bo.getContractamtmini().multiply(new BigDecimal(100)).divide(bo.getContractamt(),4,BigDecimal.ROUND_HALF_UP).setScale(2, BigDecimal.ROUND_HALF_UP).toString();
  
		//新增贷款笔数   report_id:20：AMT2
		String contractnum = bo.getContractnum().setScale(0, BigDecimal.ROUND_HALF_UP).toString();
  
		//去年同期投放笔数
		String lcontractnum = bo.getLcontractnum().setScale(0, BigDecimal.ROUND_HALF_UP).toString();
    	  
		//投放笔数增加或减少
		String contractnumflag="";
		String contractnumscope="";
		if (bo.getLcontractnum().compareTo(bo.getContractnum()) <=0){
			contractnumflag="增加";
			contractnumscope="增幅";
		}else{
			contractnumflag="减少";
			contractnumscope="降幅";
		}

		//增加减少的笔数
		String contractnumsubtract = bo.getContractnum().subtract(bo.getLcontractnum()).abs().setScale(0, BigDecimal.ROUND_HALF_UP).toString();

		//笔数增幅或降幅
		String contractnumfudu = new BigDecimal(contractnumsubtract).multiply(new BigDecimal(100)).divide(bo.getLcontractnum(),4,BigDecimal.ROUND_HALF_UP).abs().setScale(2, BigDecimal.ROUND_HALF_UP).toString();

		//小微贷款笔数占比   (小微笔数report_id:60：AMT1) 71.12
		String contractnummini = bo.getContractnummini().multiply(new BigDecimal(100)).divide(bo.getContractnum(),2,BigDecimal.ROUND_HALF_UP).setScale(2, BigDecimal.ROUND_HALF_UP).toString();
  
		//新增贷款笔均
		String contractamtaver = bo.getContractamt().divide(bo.getContractnum(),2).setScale(2, BigDecimal.ROUND_HALF_UP).toString();

		//新增贷款平均年利率
		String contractrate = bo.getContractrate().setScale(2, BigDecimal.ROUND_HALF_UP).toString();
		
		/**************************贷款总体情况_第二段**********************************/
		
		//本旬度截止日期
		String busiend="";
		if(bo.getBusidate().substring(6,7).equals("1")){
			//上旬
			busiend= busimonth+"月10日";  
		}
		if(bo.getBusidate().substring(6,7).equals("2")){
			//中旬
			busiend=busimonth+"月20日";  
		}
		if(bo.getBusidate().substring(6,7).equals("3")){
			//下旬
			if(busimonth.equals("1")||busimonth.equals("3")||busimonth.equals("5")||busimonth.equals("7")||busimonth.equals("8")||busimonth.equals("10")||busimonth.equals("12")){
				busiend=busimonth+"月31日";  
			}
			if(busimonth.equals("4")||busimonth.equals("6")||busimonth.equals("9")||busimonth.equals("11")){
				busiend=busimonth+"月30日";  
			}
			if(busimonth.equals("02") && (busiyear.equals("2012")||busiyear.equals("2016")||busiyear.equals("2020"))){
				busiend=busimonth+"月29日";  
			}
			if(busimonth.equals("02") && !busiyear.equals("2012") && !busiyear.equals("2016")&&!busiyear.equals("2020")){
				busiend=busimonth+"月28日";  
			}
		}
		  
		//全辖结存贷款余额
		String loanbalamt = bo.getLoanbalamt().divide(new BigDecimal(10000)).setScale(2, BigDecimal.ROUND_HALF_UP).toString();
	  
		//去年同期全辖结存贷款金额
		String lloanbalamt = bo.getLloanbalamt().divide(new BigDecimal(10000)).setScale(2, BigDecimal.ROUND_HALF_UP).toString();
  
		//结存贷款金额增加或减少
		String loanbalamtflag="";
		String loanbalamtscope="";
		if (bo.getLloanbalamt().compareTo(bo.getLoanbalamt()) <=0){
			loanbalamtflag="增加";
			loanbalamtscope="增幅";
		}else{
			loanbalamtflag="减少";
			loanbalamtscope="降幅";
		}
		
		//结存贷款余额增加减少的差值
		String  loanbalamtsubtract = bo.getLoanbalamt().subtract(bo.getLloanbalamt()).divide(new BigDecimal(10000)).abs().setScale(2, BigDecimal.ROUND_HALF_UP).toString();
  
		//结存贷款余额增幅或降幅 
		//String  loanbalamtfudu = ( bo.getLoanbalamt().subtract(bo.getLloanbalamt())).multiply(new BigDecimal(100)).divide(bo.getLloanbalamt(),4).abs().setScale(2, BigDecimal.ROUND_HALF_UP).toString();
		String loanbalamtfudu = new BigDecimal(loanbalamtsubtract).multiply(new BigDecimal(100)).divide(new BigDecimal(lloanbalamt),2,BigDecimal.ROUND_HALF_UP).toString();
  
		//小微结存金额占比(小微结存金额/结存贷款余额)186648.08***701196
		String loanbalamtmini = bo.getLoanbalamtmini().multiply(new BigDecimal(100)).divide(bo.getLoanbalamt(),4,BigDecimal.ROUND_HALF_UP).setScale(2, BigDecimal.ROUND_HALF_UP).toString();
  
		//结存贷款户数
		String loanbalnum = bo.getLoanbalnum().setScale(0, BigDecimal.ROUND_HALF_UP).toString();
  
		//去年同期结存贷款户数
		String lloanbalnum = bo.getLloanbalnum().setScale(0, BigDecimal.ROUND_HALF_UP).toString();
 
		//结存贷款户数增加或减少
		String loanbalnumflag="";
		String loanbalnumscope="";
		if(bo.getLloanbalnum().compareTo(bo.getLoanbalnum()) <=0){
			loanbalnumflag="增加";
			loanbalnumscope="增幅";
		}else{
			loanbalnumflag="减少";
			loanbalnumscope="降幅";
		}
  
		//结存贷款户数增加减少的差值
		String loanbalnumsubtract = bo.getLoanbalnum().subtract(bo.getLloanbalnum()).abs().setScale(0, BigDecimal.ROUND_HALF_UP).toString();
  
		//结存贷款户数增幅或降幅
		//String loanbalnumfudu =  (( bo.getLoanbalnum().subtract(bo.getLloanbalnum())).multiply(new BigDecimal(100)).divide(bo.getLloanbalnum(),4).abs()).setScale(2, BigDecimal.ROUND_HALF_UP).toString();
		String loanbalnumfudu = new BigDecimal(loanbalnumsubtract).multiply(new BigDecimal(100)).divide(new BigDecimal(lloanbalnum),2,BigDecimal.ROUND_HALF_UP).toString();
    	  
		//TODO 小微贷款结存笔数占比  16742 18343
		String loanbalnummini = bo.getLoanbalnummini().multiply(new BigDecimal(100)).divide(bo.getLoanbalnum1(),2,BigDecimal.ROUND_HALF_UP).setScale(2, BigDecimal.ROUND_HALF_UP).toString();
    	  
		//结存贷款户均(结存贷款余额/结存贷款户数)
		String loanbalamtaver = bo.getLoanbalamt().divide(bo.getLoanbalnum(),2,BigDecimal.ROUND_HALF_UP).setScale(2, BigDecimal.ROUND_HALF_UP).toString();
    	  
		//结存贷款利率
		String loanbalrate = bo.getLoanbalrate().setScale(2, BigDecimal.ROUND_HALF_UP).toString();

		//TODO PUT进map集合
		dataMap.put("tbl8param", tbl8param);
		dataMap.put("busiyear",busiyear);
		dataMap.put("busimonth",busimonth);
		dataMap.put("busiperiod",busiperiod);
		dataMap.put("sysdate",sysdate);
		dataMap.put("companycount",companycount);
		dataMap.put("busiscope", busiscope);
		dataMap.put("contractamt",contractamt);//本旬投放金额
		dataMap.put("lcontractamt",lcontractamt);//本旬投放金额去年同期数   
		dataMap.put("contractamtflag",contractamtflag);//增加减少文字
		dataMap.put("contractamtsubtract",contractamtsubtract);//增加减少金额
		dataMap.put("contractamtscope",contractamtscope);//增幅降幅文字
		dataMap.put("contractamtfudu",contractamtfudu);//增幅降幅百分比
		dataMap.put("contractamtmini",contractamtmini);//小微百分比
		dataMap.put("contractnum",contractnum);//新增笔数
		dataMap.put("lcontractnum",lcontractnum);//本旬投放笔数去年同期数   
		dataMap.put("contractnumflag",contractnumflag);//增加减少文字
		dataMap.put("contractnumsubtract",contractnumsubtract);//增加减少笔数
		dataMap.put("contractnumscope",contractnumscope);//增幅降幅文字
		dataMap.put("contractnumfudu",contractnumfudu);//增幅降幅百分比
		dataMap.put("contractnummini",contractnummini);//小微百分比
		dataMap.put("contractamtaver",contractamtaver);//利率
		dataMap.put("contractrate",contractrate);//利率

		dataMap.put("busiend",busiend);//月末日
		dataMap.put("loanbalamt",loanbalamt);//本旬结存金额
		dataMap.put("lloanbalamt",lloanbalamt);//本旬结存金额去年同期数   
		dataMap.put("loanbalamtflag",loanbalamtflag);//增加减少文字
		dataMap.put("loanbalamtsubtract",loanbalamtsubtract);//增加减少金额
		dataMap.put("loanbalamtscope",loanbalamtscope);//增幅降幅文字
		dataMap.put("loanbalamtfudu",loanbalamtfudu);//增幅降幅百分比
		dataMap.put("loanbalamtmini",loanbalamtmini);//小微百分比
		dataMap.put("loanbalnum",loanbalnum);//本旬结存笔数
		dataMap.put("lloanbalnum",lloanbalnum);//本旬结存笔数去年同期数   
		dataMap.put("loanbalnumflag",loanbalnumflag);//增加减少文字
		dataMap.put("loanbalnumsubtract",loanbalnumsubtract);//增加减少笔数
		dataMap.put("loanbalnumscope",loanbalnumscope);//增幅降幅文字
		dataMap.put("loanbalnumfudu",loanbalnumfudu);//增幅降幅百分比
		dataMap.put("loanbalnummini",loanbalnummini);//小微百分比
		dataMap.put("loanbalamtaver",loanbalamtaver);//平均
		dataMap.put("loanbalrate",loanbalrate);//利率
		  
		dataMap.put("tbl1", bo.getTabledata1());
		dataMap.put("tbl1sum1", bo.getTbl1sum1());
		dataMap.put("tbl1sum2", bo.getTbl1sum2());
		dataMap.put("tbl1sum3", bo.getTbl1sum3().toString());
		  
		dataMap.put("tbl2", bo.getTabledata2());
		dataMap.put("tbl2sum1", bo.getTbl2sum1());
		dataMap.put("tbl2sum2", bo.getTbl2sum2());
		dataMap.put("tbl2sum3", bo.getTbl2sum3());
		  
		dataMap.put("tbl3", bo.getTabledata3());
		dataMap.put("tbl3sum1", bo.getTbl3sum1());
		dataMap.put("tbl3sum2", bo.getTbl3sum2());
		dataMap.put("tbl3sum3", bo.getTbl3sum3().toString());
		  
		dataMap.put("tbl4", bo.getTabledata4());
		dataMap.put("tbl4sum1", bo.getTbl4sum1());
		dataMap.put("tbl4sum2", bo.getTbl4sum2());
		dataMap.put("tbl4sum3", bo.getTbl4sum3().toString());
		  
		dataMap.put("tbl5", bo.getTabledata5());
		dataMap.put("tbl5sum1", bo.getTbl5sum1());
		dataMap.put("tbl5sum2", bo.getTbl5sum2());
		dataMap.put("tbl5sum3", bo.getTbl5sum3());
		  
		dataMap.put("tbl6", bo.getTabledata6());
		dataMap.put("tbl6sum1", bo.getTbl6sum1());
		dataMap.put("tbl6sum2", bo.getTbl6sum2());
		dataMap.put("tbl6sum3", bo.getTbl6sum3().toString());
		
		dataMap.put("tbl7", bo.getTabledata7());
		dataMap.put("tbl7sum1", bo.getTbl7sum1());
		dataMap.put("tbl7sum2", bo.getTbl7sum2());
		dataMap.put("tbl7sum3", bo.getTbl7sum3());
		
		dataMap.put("tbl8", bo.getTabledata8());
		dataMap.put("tbl8sum1", bo.getTbl8sum1());
		dataMap.put("tbl8sum2", bo.getTbl8sum2());
		dataMap.put("tbl8sum3", bo.getTbl8sum3());
		
		dataMap.put("tbl9", bo.getTabledata9());
		dataMap.put("tbl9sum1", bo.getTbl9sum1());
		dataMap.put("tbl9sum2", bo.getTbl9sum2());
		dataMap.put("tbl9sum3", bo.getTbl9sum3());
		
		dataMap.put("tbl10", bo.getTabledata10());
		dataMap.put("tbl10sum1", bo.getTbl10sum1());
		dataMap.put("tbl10sum2", bo.getTbl10sum2());
		dataMap.put("tbl10sum3", bo.getTbl10sum3());
		
		return dataMap;
	}
}



















