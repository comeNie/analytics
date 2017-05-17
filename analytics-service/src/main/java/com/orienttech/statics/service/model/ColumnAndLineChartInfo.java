package com.orienttech.statics.service.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class ColumnAndLineChartInfo {
	private LciXAxis xAxis;
	public List<BigDecimal> seriesColumn;
	public List<BigDecimal> seriesPercent;
	public List<Integer> seriesLine;
	public List<Integer> seriesCount;
	
	public ColumnAndLineChartInfo(){
		this.seriesColumn = new ArrayList<BigDecimal>();
		this.seriesPercent = new ArrayList<BigDecimal>();
		this.seriesLine = new ArrayList<Integer>();
		this.seriesCount = new ArrayList<Integer>();
	}
	
	public LciXAxis getxAxis() {
		return xAxis;
	}
	public void setxAxis(LciXAxis xAxis) {
		this.xAxis = xAxis;
	}
	
	public List<BigDecimal> getSeriesColumn() {
		
		return seriesColumn;
	}
	public void setSeriesColumn(List<BigDecimal> seriesColumn) {
		this.seriesColumn = seriesColumn;
	}
	public List<Integer> getSeriesLine() {
		
		return seriesLine;
	}
	public void setSeriesLine(List<Integer> seriesLine) {
		this.seriesLine = seriesLine;
	}


	public List<Integer> getSeriesCount() {
		return seriesCount;
	}

	public void setSeriesCount(List<Integer> seriesCount) {
		this.seriesCount = seriesCount;
	}


	public List<BigDecimal> getSeriesPercent() {
		return seriesPercent;
	}

	public void setSeriesPercent(List<BigDecimal> seriesPercent) {
		this.seriesPercent = seriesPercent;
	}


	public class LciXAxis{
		private List<String> categories=new ArrayList<String>();

		public List<String> getCategories() {
			return categories;
		}

		public void setCategories(List<String> categories) {
			this.categories = categories;
		}
	}
	public class LciSerie{
		private String name;
		private List<BigDecimal> data=new ArrayList<BigDecimal>();
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public List<BigDecimal> getData() {
			return data;
		}
		public void setData(List<BigDecimal> data) {
			this.data = data;
		}
		public void addData(BigDecimal bd) {
			this.data.add(bd);
		}
	}
	
	public class LciSerieColumnAndLine{
		
		private List<BigDecimal> data=new ArrayList<BigDecimal>();
		
		public List<BigDecimal> getData() {
			return data;
		}

		public void setData(List<BigDecimal> data) {
			this.data = data;
		}

		public void addData(BigDecimal bd) {
			this.data.add(bd);
		}
	}
}
