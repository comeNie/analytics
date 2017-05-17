package com.orienttech.statics.service.model.report;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Id;

import com.orienttech.statics.commons.utils.CommonHelper;
import com.orienttech.statics.dao.entity.financialreport.RiskReportMonth;
/**
 * 旬度贷款业务情况通报Bo
 * @author wangxy
 *
 */
public class RiskReportMonthBo implements Serializable{

	private static final long serialVersionUID = -8109657068970354619L;
		//单个的固定值数组
		private String  busidate ;   // 业务日期
		private int org_cnt;
		private int  companycount;   // 公司数
		private BigDecimal contractamt ; //放款金额
		private BigDecimal lcontractamt ; //放款金额，去年同期
		private BigDecimal contractamtmini; //小微金额
		private BigDecimal contractnum ; //放款笔数
		private BigDecimal lcontractnum ; //放款金额，去年同期
		private BigDecimal contractnummini; //小微金额
		private BigDecimal contractrate; // 利率

		private BigDecimal loanbalamt ; //结存金额
		private BigDecimal lloanbalamt ; //结存金额，去年同期
		private BigDecimal loanbalamtmini; //小微金额
		private BigDecimal loanbalnum ; //结存笔数
		private BigDecimal lloanbalnum ; //结存金额，去年同期
		private BigDecimal loanbalnummini; //小微笔数
		private BigDecimal loanbalrate; // 利率
		
		private String outFileName;//生成文件名
		
		private BigDecimal firstNum1;
		private BigDecimal firstNum2;
		private BigDecimal firstNum3;
		private BigDecimal firstNum4;
		private BigDecimal firstNum7;
		private BigDecimal firstNum8;
		private BigDecimal firstNum9;
		
		private BigDecimal firstMoney;
		private BigDecimal firstMoney1;
		private BigDecimal fisrtPercent1;
		private BigDecimal fisrtPercent2;
		private BigDecimal fisrtPercent3;
		private BigDecimal fisrtPercent4;
		private BigDecimal fisrtPercent5;
		private BigDecimal fisrtPercent6;
		
		
		private BigDecimal secondNum1;
		private BigDecimal secondNum2;
		private BigDecimal secondNum3;
		private BigDecimal secondNum4;
		private BigDecimal secondNum5;
		private BigDecimal secondNum6;
		private BigDecimal secondNum7;
		private BigDecimal secondNum8;
		private BigDecimal secondNum9;
		private BigDecimal secondNum10;
		private BigDecimal secondNum101;
		private BigDecimal secondNum11;
		private BigDecimal secondNum111;
		private BigDecimal secondNum12;
		private BigDecimal secondNum121;
		private BigDecimal secondNum13;
		private BigDecimal secondNum131;
		private BigDecimal secondNum14;
		private BigDecimal secondNum15;
		private BigDecimal secondNum16;
		private BigDecimal secondNum17;//本月逾期贷款余额减少额
		private BigDecimal secondNum18;//取各月份的平均值
		
		private BigDecimal tab1Num;//
		private BigDecimal tab1Num1;//本月逾期贷款余额减少额
		private BigDecimal tab1Num3;//表一四月份逾期余额

		private BigDecimal tbl1sum1 ;//表1汇总
		private BigDecimal tbl1sum2 ;//表1汇总
		private BigDecimal tbl1sum3 ;//表1汇总
		
		private BigDecimal tbl2sum1 ;//表2汇总
		private BigDecimal tbl2sum2 ;//表2汇总
		private BigDecimal tbl2sum3 ;//表2汇总
		
		private BigDecimal tbl3sum1 ;//表3汇总
		private BigDecimal tbl3sum2 ;//表3汇总
		private BigDecimal tbl3sum3 ;//表3汇总
		
		private BigDecimal tbl4sum1 ;//表4汇总
		private BigDecimal tbl4sum2 ;//表4汇总
		private BigDecimal tbl4sum3 ;//表4汇总
		
		private BigDecimal tbl5sum1 ;//表5汇总
		private BigDecimal tbl5sum2 ;//表5汇总
		private BigDecimal tbl5sum3 ;//表5汇总
		
		private BigDecimal tbl6sum1 ;//表6汇总
		private BigDecimal tbl6sum2 ;//表6汇总
		private BigDecimal tbl6sum3 ;//表6汇总
		
		private BigDecimal tbl7sum1 ;//表7汇总
		private BigDecimal tbl7sum2 ;//表7汇总
		private BigDecimal tbl7sum3 ;//表7汇总
		
		private BigDecimal tbl8sum1 ;//表8汇总
		private BigDecimal tbl8sum2 ;//表8汇总
		private BigDecimal tbl8sum3 ;//表8汇总
		
		private BigDecimal tbl9sum1 ;//表9汇总
		private BigDecimal tbl9sum2 ;//表91汇总
		private BigDecimal tbl9sum3 ;//表9汇总
		
		private BigDecimal tbl10sum1 ;//表10汇总
		private BigDecimal tbl10sum2 ;//表10汇总
		private BigDecimal tbl10sum3 ;//表10汇总
		
		//表1-表10
	  	private List<RiskReportMonth> tabledata1=new ArrayList<RiskReportMonth>();
	  	private List<RiskReportMonth> tabledata2=new ArrayList<RiskReportMonth>();
	  	private List<RiskReportMonth> tabledata3=new ArrayList<RiskReportMonth>();
	  	private List<RiskReportMonth> tabledata4=new ArrayList<RiskReportMonth>();
	  	private List<RiskReportMonth> tabledata5=new ArrayList<RiskReportMonth>();
	  	private List<RiskReportMonth> tabledata6=new ArrayList<RiskReportMonth>();
	  	private List<RiskReportMonth> tabledata7=new ArrayList<RiskReportMonth>();
	  	private List<RiskReportMonth> tabledata8=new ArrayList<RiskReportMonth>();
	  	private List<RiskReportMonth> tabledata81=new ArrayList<RiskReportMonth>();
	  	private List<RiskReportMonth> tabledata9=new ArrayList<RiskReportMonth>();
	  	private List<RiskReportMonth> tabledata10=new ArrayList<RiskReportMonth>();
	  	
	  	private List<RiskReportMonth> tabledata1011=new ArrayList<RiskReportMonth>();
	  	private List<RiskReportMonth> tabledata1010a=new ArrayList<RiskReportMonth>();//第二章表10--违约滚动率和回滚率分析	
	  	private List<RiskReportMonth> tabledata1010=new ArrayList<RiskReportMonth>();//第二章表10--违约滚动率和回滚率分析
	  	private List<RiskReportMonth> tabledata109=new ArrayList<RiskReportMonth>();//第二章表9--各客户来源资产结构分布
	  	private List<RiskReportMonth> tabledata108=new ArrayList<RiskReportMonth>();//第二章表8--各投放行业资产结构分布
	  	private List<RiskReportMonth> tabledata107=new ArrayList<RiskReportMonth>();//第二章表7--各还款方式资产结构分布
		private List<RiskReportMonth> tabledata106=new ArrayList<RiskReportMonth>();//第二章表6--各利率区间资产结构分布
		private List<RiskReportMonth> tabledata105=new ArrayList<RiskReportMonth>();//第二章表5--各担保方式资产结构分布
		private List<RiskReportMonth> tabledata103b=new ArrayList<RiskReportMonth>();//第二章表4--各贷款额度区间资产结构分布(2)贷款期限
		private List<RiskReportMonth> tabledata103a=new ArrayList<RiskReportMonth>();//第二章表3--各贷款额度区间资产结构分布(1)
		private List<RiskReportMonth> tabledata102=new ArrayList<RiskReportMonth>();//第二章表2--机构与区域风险指标对比
		private List<RiskReportMonth> tabledata101=new ArrayList<RiskReportMonth>();//第二章表1--各区域资产结构整体情
		
		public RiskReportMonthBo() {
			super();
		}
		
		

		public String getOutFileName() {
			return outFileName;
		}

		public void setOutFileName(String outFileName) {
			this.outFileName = outFileName;
		}

		public String condition() {
			return busidate;
		}

		public String getBusidate() {
			return busidate;
		}

		public void setBusidate(String busidate) {
			this.busidate = busidate;
		}

		public int getCompanycount() {
			return companycount;
		}

		public int getOrg_cnt() {
			return org_cnt;
		}

		public void setOrg_cnt(int org_cnt) {
			this.org_cnt = org_cnt;
		}

		public void setCompanycount(int companycount) {
			this.companycount = companycount;
		}

		public BigDecimal getContractamt() {
			return contractamt;
		}

		public void setContractamt(BigDecimal contractamt) {
			this.contractamt = contractamt;
		}

		public BigDecimal getLcontractamt() {
			return lcontractamt;
		}

		public void setLcontractamt(BigDecimal lcontractamt) {
			this.lcontractamt = lcontractamt;
		}

		public BigDecimal getContractamtmini() {
			return contractamtmini;
		}

		public void setContractamtmini(BigDecimal contractamtmini) {
			this.contractamtmini = contractamtmini;
		}

		public BigDecimal getContractnum() {
			return contractnum;
		}

		public void setContractnum(BigDecimal contractnum) {
			this.contractnum = contractnum;
		}

		public BigDecimal getLcontractnum() {
			return lcontractnum;
		}

		public void setLcontractnum(BigDecimal lcontractnum) {
			this.lcontractnum = lcontractnum;
		}

		public BigDecimal getContractnummini() {
			return contractnummini;
		}

		public void setContractnummini(BigDecimal contractnummini) {
			this.contractnummini = contractnummini;
		}

		public BigDecimal getContractrate() {
			return contractrate;
		}

		public void setContractrate(BigDecimal contractrate) {
			this.contractrate = contractrate;
		}

		public BigDecimal getLoanbalamt() {
			return loanbalamt;
		}

		public void setLoanbalamt(BigDecimal loanbalamt) {
			this.loanbalamt = loanbalamt;
		}

		public BigDecimal getLloanbalamt() {
			return lloanbalamt;
		}

		public void setLloanbalamt(BigDecimal lloanbalamt) {
			this.lloanbalamt = lloanbalamt;
		}

		public BigDecimal getLoanbalamtmini() {
			return loanbalamtmini;
		}

		public void setLoanbalamtmini(BigDecimal loanbalamtmini) {
			this.loanbalamtmini = loanbalamtmini;
		}

		public BigDecimal getLoanbalnum() {
			return loanbalnum;
		}

		public void setLoanbalnum(BigDecimal loanbalnum) {
			this.loanbalnum = loanbalnum;
		}

		public BigDecimal getLloanbalnum() {
			return lloanbalnum;
		}

		public void setLloanbalnum(BigDecimal lloanbalnum) {
			this.lloanbalnum = lloanbalnum;
		}

		public BigDecimal getLoanbalnummini() {
			return loanbalnummini;
		}

		public void setLoanbalnummini(BigDecimal loanbalnummini) {
			this.loanbalnummini = loanbalnummini;
		}

		public BigDecimal getLoanbalrate() {
			return loanbalrate;
		}

		public void setLoanbalrate(BigDecimal loanbalrate) {
			this.loanbalrate = loanbalrate;
		}
		

		public BigDecimal getFisrtPercent6() {
			return fisrtPercent6;
		}

		public void setFisrtPercent6(BigDecimal fisrtPercent6) {
			this.fisrtPercent6 = fisrtPercent6;
		}

		public BigDecimal getFisrtPercent5() {
			return fisrtPercent5;
		}

		public void setFisrtPercent5(BigDecimal fisrtPercent5) {
			this.fisrtPercent5 = fisrtPercent5;
		}

		public BigDecimal getFisrtPercent1() {
			return fisrtPercent1;
		}

		public void setFisrtPercent1(BigDecimal fisrtPercent1) {
			this.fisrtPercent1 = fisrtPercent1;
		}

		public BigDecimal getFisrtPercent2() {
			return fisrtPercent2;
		}

		public void setFisrtPercent2(BigDecimal fisrtPercent2) {
			this.fisrtPercent2 = fisrtPercent2;
		}

		public BigDecimal getFisrtPercent3() {
			return fisrtPercent3;
		}

		public void setFisrtPercent3(BigDecimal fisrtPercent3) {
			this.fisrtPercent3 = fisrtPercent3;
		}

		public BigDecimal getFisrtPercent4() {
			return fisrtPercent4;
		}

		public void setFisrtPercent4(BigDecimal fisrtPercent4) {
			this.fisrtPercent4 = fisrtPercent4;
		}

		public BigDecimal getFirstNum1() {
			return firstNum1;
		}

		public void setFirstNum1(BigDecimal firstNum1) {
			this.firstNum1 = firstNum1;
		}

		public BigDecimal getFirstNum2() {
			return firstNum2;
		}

		public void setFirstNum2(BigDecimal firstNum2) {
			this.firstNum2 = firstNum2;
		}

		public BigDecimal getFirstNum3() {
			return firstNum3;
		}

		public void setFirstNum3(BigDecimal firstNum3) {
			this.firstNum3 = firstNum3;
		}

		public BigDecimal getFirstNum4() {
			return firstNum4;
		}

		public void setFirstNum4(BigDecimal firstNum4) {
			this.firstNum4 = firstNum4;
		}

		public BigDecimal getFirstMoney() {
			return firstMoney;
		}

		public void setFirstMoney(BigDecimal firstMoney) {
			this.firstMoney = firstMoney;
		}

		public BigDecimal getFirstMoney1() {
			return firstMoney1;
		}

		public void setFirstMoney1(BigDecimal firstMoney1) {
			this.firstMoney1 = firstMoney1;
		}
     

		
		public BigDecimal getSecondNum1() {
			return secondNum1;
		}

		public void setSecondNum1(BigDecimal secondNum1) {
			this.secondNum1 = secondNum1;
		}

		public BigDecimal getSecondNum2() {
			return secondNum2;
		}

		public void setSecondNum2(BigDecimal secondNum2) {
			this.secondNum2 = secondNum2;
		}

		public BigDecimal getSecondNum3() {
			return secondNum3;
		}

		public void setSecondNum3(BigDecimal secondNum3) {
			this.secondNum3 = secondNum3;
		}

		public BigDecimal getSecondNum4() {
			return secondNum4;
		}

		public void setSecondNum4(BigDecimal secondNum4) {
			this.secondNum4 = secondNum4;
		}

		public BigDecimal getSecondNum5() {
			return secondNum5;
		}

		public void setSecondNum5(BigDecimal secondNum5) {
			this.secondNum5 = secondNum5;
		}

		public BigDecimal getSecondNum6() {
			return secondNum6;
		}

		public void setSecondNum6(BigDecimal secondNum6) {
			this.secondNum6 = secondNum6;
		}

		public BigDecimal getSecondNum7() {
			return secondNum7;
		}

		public void setSecondNum7(BigDecimal secondNum7) {
			this.secondNum7 = secondNum7;
		}

		public BigDecimal getSecondNum8() {
			return secondNum8;
		}

		public void setSecondNum8(BigDecimal secondNum8) {
			this.secondNum8 = secondNum8;
		}

		public BigDecimal getSecondNum9() {
			return secondNum9;
		}

		public void setSecondNum9(BigDecimal secondNum9) {
			this.secondNum9 = secondNum9;
		}

		public BigDecimal getSecondNum10() {
			return secondNum10;
		}

		public void setSecondNum10(BigDecimal secondNum10) {
			this.secondNum10 = secondNum10;
		}

		public BigDecimal getSecondNum11() {
			return secondNum11;
		}

		public void setSecondNum11(BigDecimal secondNum11) {
			this.secondNum11 = secondNum11;
		}

		public BigDecimal getSecondNum12() {
			return secondNum12;
		}

		public void setSecondNum12(BigDecimal secondNum12) {
			this.secondNum12 = secondNum12;
		}

		public BigDecimal getSecondNum13() {
			return secondNum13;
		}

		public void setSecondNum13(BigDecimal secondNum13) {
			this.secondNum13 = secondNum13;
		}

		public BigDecimal getSecondNum14() {
			return secondNum14;
		}

		public void setSecondNum14(BigDecimal secondNum14) {
			this.secondNum14 = secondNum14;
		}

		public BigDecimal getSecondNum15() {
			return secondNum15;
		}

		public void setSecondNum15(BigDecimal secondNum15) {
			this.secondNum15 = secondNum15;
		}

		public BigDecimal getSecondNum16() {
			return secondNum16;
		}

		public void setSecondNum16(BigDecimal secondNum16) {
			this.secondNum16 = secondNum16;
		}

		public BigDecimal getSecondNum17() {
			return secondNum17;
		}

		public void setSecondNum17(BigDecimal secondNum17) {
			this.secondNum17 = secondNum17;
		}

		public BigDecimal getSecondNum18() {
			return secondNum18;
		}

		public void setSecondNum18(BigDecimal secondNum18) {
			this.secondNum18 = secondNum18;
		}

		public BigDecimal getTab1Num() {
			return tab1Num;
		}

		public void setTab1Num(BigDecimal tab1Num) {
			this.tab1Num = tab1Num;
		}

		public BigDecimal getTab1Num1() {
			return tab1Num1;
		}

		public void setTab1Num1(BigDecimal tab1Num1) {
			this.tab1Num1 = tab1Num1;
		}

		public BigDecimal getTbl1sum1() {
			return tbl1sum1;
		}

		public void setTbl1sum1(BigDecimal tbl1sum1) {
			this.tbl1sum1 = tbl1sum1;
		}

		public BigDecimal getTbl1sum2() {
			return tbl1sum2;
		}

		public void setTbl1sum2(BigDecimal tbl1sum2) {
			this.tbl1sum2 = tbl1sum2;
		}

		public BigDecimal getTbl1sum3() {
			return tbl1sum3;
		}

		public void setTbl1sum3(BigDecimal tbl1sum3) {
			this.tbl1sum3 = tbl1sum3;
		}

		public BigDecimal getTbl2sum1() {
			return tbl2sum1;
		}

		public void setTbl2sum1(BigDecimal tbl2sum1) {
			this.tbl2sum1 = tbl2sum1;
		}

		public BigDecimal getTbl2sum2() {
			return tbl2sum2;
		}

		public void setTbl2sum2(BigDecimal tbl2sum2) {
			this.tbl2sum2 = tbl2sum2;
		}

		public BigDecimal getTbl2sum3() {
			return tbl2sum3;
		}

		public void setTbl2sum3(BigDecimal tbl2sum3) {
			this.tbl2sum3 = tbl2sum3;
		}

		public BigDecimal getTbl3sum1() {
			return tbl3sum1;
		}

		public void setTbl3sum1(BigDecimal tbl3sum1) {
			this.tbl3sum1 = tbl3sum1;
		}

		public BigDecimal getTbl3sum2() {
			return tbl3sum2;
		}

		public void setTbl3sum2(BigDecimal tbl3sum2) {
			this.tbl3sum2 = tbl3sum2;
		}

		public BigDecimal getTbl3sum3() {
			return tbl3sum3;
		}

		public void setTbl3sum3(BigDecimal tbl3sum3) {
			this.tbl3sum3 = tbl3sum3;
		}

		public BigDecimal getTbl4sum1() {
			return tbl4sum1;
		}

		public void setTbl4sum1(BigDecimal tbl4sum1) {
			this.tbl4sum1 = tbl4sum1;
		}

		public BigDecimal getTbl4sum2() {
			return tbl4sum2;
		}

		public void setTbl4sum2(BigDecimal tbl4sum2) {
			this.tbl4sum2 = tbl4sum2;
		}

		public BigDecimal getTbl4sum3() {
			return tbl4sum3;
		}

		public void setTbl4sum3(BigDecimal tbl4sum3) {
			this.tbl4sum3 = tbl4sum3;
		}

		public BigDecimal getTbl5sum1() {
			return tbl5sum1;
		}

		public void setTbl5sum1(BigDecimal tbl5sum1) {
			this.tbl5sum1 = tbl5sum1;
		}

		public BigDecimal getTbl5sum2() {
			return tbl5sum2;
		}

		public void setTbl5sum2(BigDecimal tbl5sum2) {
			this.tbl5sum2 = tbl5sum2;
		}

		public BigDecimal getTbl5sum3() {
			return tbl5sum3;
		}

		public void setTbl5sum3(BigDecimal tbl5sum3) {
			this.tbl5sum3 = tbl5sum3;
		}

		public BigDecimal getTbl6sum1() {
			return tbl6sum1;
		}

		public void setTbl6sum1(BigDecimal tbl6sum1) {
			this.tbl6sum1 = tbl6sum1;
		}

		public BigDecimal getTbl6sum2() {
			return tbl6sum2;
		}

		public void setTbl6sum2(BigDecimal tbl6sum2) {
			this.tbl6sum2 = tbl6sum2;
		}

		public BigDecimal getTbl6sum3() {
			return tbl6sum3;
		}

		public void setTbl6sum3(BigDecimal tbl6sum3) {
			this.tbl6sum3 = tbl6sum3;
		}

		public BigDecimal getTbl7sum1() {
			return tbl7sum1;
		}

		public void setTbl7sum1(BigDecimal tbl7sum1) {
			this.tbl7sum1 = tbl7sum1;
		}

		public BigDecimal getTbl7sum2() {
			return tbl7sum2;
		}

		public void setTbl7sum2(BigDecimal tbl7sum2) {
			this.tbl7sum2 = tbl7sum2;
		}

		public BigDecimal getTbl7sum3() {
			return tbl7sum3;
		}

		public void setTbl7sum3(BigDecimal tbl7sum3) {
			this.tbl7sum3 = tbl7sum3;
		}

		public BigDecimal getTbl8sum1() {
			return tbl8sum1;
		}

		public void setTbl8sum1(BigDecimal tbl8sum1) {
			this.tbl8sum1 = tbl8sum1;
		}

		public BigDecimal getTbl8sum2() {
			return tbl8sum2;
		}

		public void setTbl8sum2(BigDecimal tbl8sum2) {
			this.tbl8sum2 = tbl8sum2;
		}

		public BigDecimal getTbl8sum3() {
			return tbl8sum3;
		}

		public void setTbl8sum3(BigDecimal tbl8sum3) {
			this.tbl8sum3 = tbl8sum3;
		}

		public BigDecimal getTbl9sum1() {
			return tbl9sum1;
		}

		public void setTbl9sum1(BigDecimal tbl9sum1) {
			this.tbl9sum1 = tbl9sum1;
		}

		public BigDecimal getTbl9sum2() {
			return tbl9sum2;
		}

		public void setTbl9sum2(BigDecimal tbl9sum2) {
			this.tbl9sum2 = tbl9sum2;
		}

		public BigDecimal getTbl9sum3() {
			return tbl9sum3;
		}

		public void setTbl9sum3(BigDecimal tbl9sum3) {
			this.tbl9sum3 = tbl9sum3;
		}

		public BigDecimal getTbl10sum1() {
			return tbl10sum1;
		}

		public void setTbl10sum1(BigDecimal tbl10sum1) {
			this.tbl10sum1 = tbl10sum1;
		}

		public BigDecimal getTbl10sum2() {
			return tbl10sum2;
		}

		public void setTbl10sum2(BigDecimal tbl10sum2) {
			this.tbl10sum2 = tbl10sum2;
		}

		public BigDecimal getTbl10sum3() {
			return tbl10sum3;
		}

		public void setTbl10sum3(BigDecimal tbl10sum3) {
			this.tbl10sum3 = tbl10sum3;
		}
		
		

		public List<RiskReportMonth> getTabledata1() {
			return tabledata1;
		}

		public void setTabledata1(RiskReportMonth tabledata1) {
			this.tabledata1.add(tabledata1);
		}

		public List<RiskReportMonth> getTabledata2() {
			return tabledata2;
		}

		public void setTabledata2(RiskReportMonth tabledata2) {
			this.tabledata2.add(tabledata2);
		}

		public List<RiskReportMonth> getTabledata3() {
			return tabledata3;
		}

		public void setTabledata3(RiskReportMonth tabledata3) {
			this.tabledata3.add(tabledata3);
		}

		public List<RiskReportMonth> getTabledata4() {
			return tabledata4;
		}

		public void setTabledata4(RiskReportMonth tabledata4) {
			this.tabledata4.add(tabledata4);
		}

		public List<RiskReportMonth> getTabledata5() {
			return tabledata5;
		}

		public void setTabledata5(RiskReportMonth tabledata5) {
			this.tabledata5.add(tabledata5);
		}

		public List<RiskReportMonth> getTabledata6() {
			return tabledata6;
		}

		public void setTabledata6(RiskReportMonth tabledata6) {
			this.tabledata6.add(tabledata6);
		}

		public List<RiskReportMonth> getTabledata7() {
			return tabledata7;
		}

		public void setTabledata7(RiskReportMonth tabledata7) {
			this.tabledata7.add(tabledata7);
		}

		public List<RiskReportMonth> getTabledata8() {
			return tabledata8;
		}

		public void setTabledata8(RiskReportMonth tabledata8) {
			this.tabledata8.add(tabledata8);
		}
		public List<RiskReportMonth> getTabledata81() {
			return tabledata81;
		}

		public void setTabledata81(RiskReportMonth tabledata81) {
			this.tabledata81.add(tabledata81);
		}

		public List<RiskReportMonth> getTabledata9() {
			return tabledata9;
		}

		public void setTabledata9(RiskReportMonth tabledata9) {
			this.tabledata9.add(tabledata9);
		}

		public List<RiskReportMonth> getTabledata10() {
			return tabledata10;
		}

		public void setTabledata10(RiskReportMonth tabledata10) {
			this.tabledata10.add(tabledata10);
		}
		
		public List<RiskReportMonth> getTabledata1010a() {
			return tabledata1010a;
		}
		public void setTabledata1010a(RiskReportMonth tabledata1010a) {
			this.tabledata1010a.add(tabledata1010a);
		}
		
		public List<RiskReportMonth> getTabledata1010() {
			return tabledata1010;
		}
		public void setTabledata1010(RiskReportMonth tabledata1010) {
			this.tabledata1010.add(tabledata1010);
		}
		
		public List<RiskReportMonth> getTabledata109() {
			return tabledata109;
		}
		public void setTabledata109(RiskReportMonth tabledata109) {
			this.tabledata109.add(tabledata109);
		}
		public List<RiskReportMonth> getTabledata1011() {
			return tabledata1011;
		}
		public void setTabledata1011(RiskReportMonth tabledata1011) {
			this.tabledata1011.add(tabledata1011);
		}
		public List<RiskReportMonth> getTabledata108() {
			return tabledata108;
		}

		public void setTabledata108(RiskReportMonth tabledata108) {
			this.tabledata108.add(tabledata108);
		}
		public List<RiskReportMonth> getTabledata102() {
			return tabledata102;
		}

		public void setTabledata102(RiskReportMonth tabledata102) {
			this.tabledata102.add(tabledata102);
		}
		
		public List<RiskReportMonth> getTabledata101() {
			return tabledata101;
		}

		public void setTabledata101(RiskReportMonth tabledata101) {
			this.tabledata101.add(tabledata101);
		}
		public List<RiskReportMonth> getTabledata103a() {
			return tabledata103a;
		}

		public void setTabledata103a(RiskReportMonth tabledata103a) {
			this.tabledata103a.add(tabledata103a);
		}
		
		public List<RiskReportMonth> getTabledata103b() {
			return tabledata103b;
		}

		public void setTabledata103b(RiskReportMonth tabledata103b) {
			this.tabledata103b.add(tabledata103b);
		}
		public List<RiskReportMonth> getTabledata105() {
			return tabledata105;
		}

		public void setTabledata105(RiskReportMonth tabledata105) {
			this.tabledata105.add(tabledata105);
		}
		public List<RiskReportMonth> getTabledata106() {
			return tabledata106;
		}

		public void setTabledata106(RiskReportMonth tabledata106) {
			this.tabledata106.add(tabledata106);
		}
		public List<RiskReportMonth> getTabledata107() {
			return tabledata107;
		}

		public void setTabledata107(RiskReportMonth tabledata107) {
			this.tabledata107.add(tabledata107);
		}

		public BigDecimal getFirstNum7() {
			return firstNum7;
		}
		public void setFirstNum7(BigDecimal firstNum7) {
			this.firstNum7 = firstNum7;
		}
		public BigDecimal getFirstNum8() {
			return firstNum8;
		}
		public void setFirstNum8(BigDecimal firstNum8) {
			this.firstNum8 = firstNum8;
		}
		public BigDecimal getFirstNum9() {
			return firstNum9;
		}
		public void setFirstNum9(BigDecimal firstNum9) {
			this.firstNum9 = firstNum9;
		}

		public BigDecimal getSecondNum101() {
			return secondNum101;
		}

		public void setSecondNum101(BigDecimal secondNum101) {
			this.secondNum101 = secondNum101;
		}

		public BigDecimal getSecondNum111() {
			return secondNum111;
		}

		public void setSecondNum111(BigDecimal secondNum111) {
			this.secondNum111 = secondNum111;
		}



		public BigDecimal getSecondNum121() {
			return secondNum121;
		}



		public void setSecondNum121(BigDecimal secondNum121) {
			this.secondNum121 = secondNum121;
		}



		public BigDecimal getSecondNum131() {
			return secondNum131;
		}



		public void setSecondNum131(BigDecimal secondNum131) {
			this.secondNum131 = secondNum131;
		}
		
		
}
