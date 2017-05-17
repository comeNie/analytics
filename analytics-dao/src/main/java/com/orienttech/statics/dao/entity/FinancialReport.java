package com.orienttech.statics.dao.entity;

import static com.orienttech.statics.commons.utils.Contants.TJ_SCHEMA;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.orienttech.statics.commons.entity.BaseEntity;
@Entity
@Table(name = "FINANCIAL_REPORTS", schema = TJ_SCHEMA)
public class FinancialReport extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8839180145042042824L;
	@Id
	@Column(name="FUNCTION_ID")
	private Long functionId;
	/**
	 * 序号
	 */
	@Column(name="ROW_ID")
	private Long rowId;
	/**
	 * 报表名称
	 */
	@Column(name="REPORT_NAME",length=100)
	private String reportName;
	/**
	 * 路径
	 */
	@Column(name="SEARCHPATH",length=800)
	private String searchPath;
	/**
	 * 报表类型（1.表2.图3.混合）
	 */
	@Column(name="REPORT_TYPE",length=1)
	private String reportType;
	/**
	 * 表前文字
	 */
	@Column(name="SCRIPT_BEFORE",length=3000)
	private String scriptBefore;
	/**
	 * 表后文字
	 */
	@Column(name="SCRIPT_AFTER",length=3000)
	private String scriptAfter;
	/**
	 * 状态(0有效1无效)
	 */
	@Column(name="STATUS",length=1)
	private String status;
	@Column(name="x1")
	private Integer x1;
	@Column(name="y1")
	private Integer y1;
	@Column(name="x2")
	private Integer x2;
	@Column(name="y2")
	private Integer y2;
	
	/**
	 * 类型（1是单个，2是所有小贷）
	 */
	@Column(name="label")
	private String label;
	
	
	@Column(name="SEQUENCE")
	private String sequence;
	
	public Long getRowId() {
		return rowId;
	}
	public void setRowId(Long rowId) {
		this.rowId = rowId;
	}
	public Long getFunctionId() {
		return functionId;
	}
	public void setFunctionId(Long functionId) {
		this.functionId = functionId;
	}
	public String getReportName() {
		return reportName;
	}
	public void setReportName(String reportName) {
		this.reportName = reportName;
	}
	public String getSearchPath() {
		return searchPath;
	}
	public void setSearchPath(String searchPath) {
		this.searchPath = searchPath;
	}
	public String getReportType() {
		return reportType;
	}
	public void setReportType(String reportType) {
		this.reportType = reportType;
	}
	public String getScriptBefore() {
		return scriptBefore;
	}
	public void setScriptBefore(String scriptBefore) {
		this.scriptBefore = scriptBefore;
	}
	public String getScriptAfter() {
		return scriptAfter;
	}
	public void setScriptAfter(String scriptAfter) {
		this.scriptAfter = scriptAfter;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Integer getX1() {
		return x1;
	}
	public void setX1(Integer x1) {
		this.x1 = x1;
	}
	public Integer getY1() {
		return y1;
	}
	public void setY1(Integer y1) {
		this.y1 = y1;
	}
	public Integer getX2() {
		return x2;
	}
	public void setX2(Integer x2) {
		this.x2 = x2;
	}
	public Integer getY2() {
		return y2;
	}
	public void setY2(Integer y2) {
		this.y2 = y2;
	}
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	public String getSequence() {
		return sequence;
	}
	public void setSequence(String sequence) {
		this.sequence = sequence;
	}
}
