package com.orienttech.statics.service.model.workflow;

import java.util.List;

public class WorkFlowList {
	private List<WorkFlowInfo> content;
	private Boolean  first;
	private Boolean  firstPage;
	private Boolean  last;
	private Boolean  lastPage;
	private Long  number;
	private Long  numberOfElements;
	private Long  size;
	private Long  totalElements;
	private Long  totalPages;
	
	
	
	public List<WorkFlowInfo> getContent() {
		return content;
	}
	public void setContent(List<WorkFlowInfo> content) {
		this.content = content;
	}
	public Boolean getFirst() {
		return first;
	}
	public void setFirst(Boolean first) {
		this.first = first;
	}
	public Boolean getFirstPage() {
		return firstPage;
	}
	public void setFirstPage(Boolean firstPage) {
		this.firstPage = firstPage;
	}
	public Boolean getLast() {
		return last;
	}
	public void setLast(Boolean last) {
		this.last = last;
	}
	public Boolean getLastPage() {
		return lastPage;
	}
	public void setLastPage(Boolean lastPage) {
		this.lastPage = lastPage;
	}
	public Long getNumber() {
		return number;
	}
	public void setNumber(Long number) {
		this.number = number;
	}
	public Long getNumberOfElements() {
		return numberOfElements;
	}
	public void setNumberOfElements(Long numberOfElements) {
		this.numberOfElements = numberOfElements;
	}
	public Long getSize() {
		return size;
	}
	public void setSize(Long size) {
		this.size = size;
	}
	public Long getTotalElements() {
		return totalElements;
	}
	public void setTotalElements(Long totalElements) {
		this.totalElements = totalElements;
	}
	public Long getTotalPages() {
		return totalPages;
	}
	public void setTotalPages(Long totalPages) {
		this.totalPages = totalPages;
	}
	

}
