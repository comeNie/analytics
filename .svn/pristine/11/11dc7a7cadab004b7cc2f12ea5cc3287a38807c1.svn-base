package com.orienttech.statics.service.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class LineChartInfo {
	private LciXAxis xAxis;
	private List<LciSerie> series;
	
	
	public LciXAxis getxAxis() {
		return xAxis;
	}
	public void setxAxis(LciXAxis xAxis) {
		this.xAxis = xAxis;
	}
	public List<LciSerie> getSeries() {
		return series;
	}
	public void setSeries(List<LciSerie> series) {
		this.series = series;
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
	
}
