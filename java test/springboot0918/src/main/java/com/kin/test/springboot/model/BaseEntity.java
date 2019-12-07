package com.kin.test.springboot.model;

import java.io.Serializable;

public class BaseEntity implements Serializable{
	
	private String sortName;
	private Integer beginNum;
	private Integer pageNo;
	private Integer pageSize;
	private String sortOrder;
	public String getSortName() {
		return sortName;
	}
	public void setSortName(String sortName) {
		this.sortName = sortName;
	}
	public Integer getBeginNum() {
		return beginNum;
	}
	public void setBeginNum(Integer beginNum) {
		this.beginNum = beginNum;
	}
	public Integer getPageNo() {
		return pageNo;
	}
	public void setPageNo(Integer pageNo) {
		this.pageNo = pageNo;
	}
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	public String getSortOrder() {
		return sortOrder;
	}
	public void setSortOrder(String sortOrder) {
		this.sortOrder = sortOrder;
	}
	@Override
	public String toString() {
		return "BaseEntity [sortName=" + sortName + ", beginNum=" + beginNum + ", pageNo=" + pageNo + ", pageSize="
				+ pageSize + ", sortOrder=" + sortOrder + "]";
	}
	public BaseEntity() {
		
	}
}
