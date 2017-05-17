package com.orienttech.statics.commons.datatables;

import java.util.Collections;
import java.util.List;

import org.springframework.data.domain.Page;

public class DataTablesPage {
	private Integer draw;
	private Long recordsTotal;
	private Long recordsFiltered;
	private List<?> data = Collections.EMPTY_LIST;
	
	public DataTablesPage() {
		
	}
	
	public DataTablesPage(Integer draw, Page<?> page) {
		this.draw = draw;
		this.recordsTotal = this.recordsFiltered = page.getTotalElements();
		this.data = page.getContent();
	}

	public Integer getDraw() {
		return draw;
	}

	public void setDraw(Integer draw) {
		this.draw = draw;
	}

	public Long getRecordsTotal() {
		return recordsTotal;
	}

	public void setRecordsTotal(Long recordsTotal) {
		this.recordsTotal = recordsTotal;
	}

	public Long getRecordsFiltered() {
		return recordsFiltered;
	}

	public void setRecordsFiltered(Long recordsFiltered) {
		this.recordsFiltered = recordsFiltered;
	}

	public List<?> getData() {
		return data;
	}

	public void setData(List<?> data) {
		this.data = data;
	}
}
