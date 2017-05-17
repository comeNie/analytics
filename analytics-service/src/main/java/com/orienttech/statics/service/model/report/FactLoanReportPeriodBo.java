package com.orienttech.statics.service.model.report;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Id;

import com.orienttech.statics.commons.utils.CommonHelper;
import com.orienttech.statics.dao.entity.financialreport.FactLoanReportPeriod;
/**
 * 旬度贷款业务情况通报Bo
 * @author wangxy
 *
 */
public class FactLoanReportPeriodBo implements Serializable{

	private static final long serialVersionUID = -8109657068970354619L;

		//单个的固定值数组
		private String outFileName;//生成文件名
		
		private String  busidate ;   // 业务日期
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
		private BigDecimal loanbalnum1;//结存贷款笔数

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
	  	private List<FactLoanReportPeriod> tabledata1=new ArrayList<FactLoanReportPeriod>();
	  	private List<FactLoanReportPeriod> tabledata2=new ArrayList<FactLoanReportPeriod>();
	  	private List<FactLoanReportPeriod> tabledata3=new ArrayList<FactLoanReportPeriod>();
	  	private List<FactLoanReportPeriod> tabledata4=new ArrayList<FactLoanReportPeriod>();
	  	private List<FactLoanReportPeriod> tabledata5=new ArrayList<FactLoanReportPeriod>();
	  	private List<FactLoanReportPeriod> tabledata6=new ArrayList<FactLoanReportPeriod>();
	  	private List<FactLoanReportPeriod> tabledata7=new ArrayList<FactLoanReportPeriod>();
	  	private List<FactLoanReportPeriod> tabledata8=new ArrayList<FactLoanReportPeriod>();
	  	private List<FactLoanReportPeriod> tabledata9=new ArrayList<FactLoanReportPeriod>();
	  	private List<FactLoanReportPeriod> tabledata10=new ArrayList<FactLoanReportPeriod>();
		 
		public FactLoanReportPeriodBo() {
			super();
		}
		
		public BigDecimal getLoanbalnum1() {
			return loanbalnum1;
		}

		public void setLoanbalnum1(BigDecimal loanbalnum1) {
			this.loanbalnum1 = loanbalnum1;
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
		
		

		public List<FactLoanReportPeriod> getTabledata1() {
			return tabledata1;
		}

		public void setTabledata1(FactLoanReportPeriod tabledata1) {
			this.tabledata1.add(tabledata1);
		}

		public List<FactLoanReportPeriod> getTabledata2() {
			return tabledata2;
		}

		public void setTabledata2(FactLoanReportPeriod tabledata2) {
			this.tabledata2.add(tabledata2);
		}

		public List<FactLoanReportPeriod> getTabledata3() {
			return tabledata3;
		}

		public void setTabledata3(FactLoanReportPeriod tabledata3) {
			this.tabledata3.add(tabledata3);
		}

		public List<FactLoanReportPeriod> getTabledata4() {
			return tabledata4;
		}

		public void setTabledata4(FactLoanReportPeriod tabledata4) {
			this.tabledata4.add(tabledata4);
		}

		public List<FactLoanReportPeriod> getTabledata5() {
			return tabledata5;
		}

		public void setTabledata5(FactLoanReportPeriod tabledata5) {
			this.tabledata5.add(tabledata5);
		}

		public List<FactLoanReportPeriod> getTabledata6() {
			return tabledata6;
		}

		public void setTabledata6(FactLoanReportPeriod tabledata6) {
			this.tabledata6.add(tabledata6);
		}

		public List<FactLoanReportPeriod> getTabledata7() {
			return tabledata7;
		}

		public void setTabledata7(FactLoanReportPeriod tabledata7) {
			this.tabledata7.add(tabledata7);
		}

		public List<FactLoanReportPeriod> getTabledata8() {
			return tabledata8;
		}

		public void setTabledata8(FactLoanReportPeriod tabledata8) {
			this.tabledata8.add(tabledata8);
		}

		public List<FactLoanReportPeriod> getTabledata9() {
			return tabledata9;
		}

		public void setTabledata9(FactLoanReportPeriod tabledata9) {
			this.tabledata9.add(tabledata9);
		}

		public List<FactLoanReportPeriod> getTabledata10() {
			return tabledata10;
		}

		public void setTabledata10(FactLoanReportPeriod tabledata10) {
			this.tabledata10.add(tabledata10);
		}

		public String getOutFileName() {
			return outFileName;
		}

		public void setOutFileName(String outFileName) {
			this.outFileName = outFileName;
		}
		
}
