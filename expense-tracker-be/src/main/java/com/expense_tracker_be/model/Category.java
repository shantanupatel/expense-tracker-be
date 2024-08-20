package com.expense_tracker_be.model;

import java.time.LocalDateTime;

public class Category {

	private int id;
	private String categoryName;
	private String createdBy;
	private LocalDateTime createdDate;
	private LocalDateTime updatedDate;

	public Category(String categoryName, String createdBy, LocalDateTime createdDate, LocalDateTime updatedDate) {
		super();
		this.categoryName = categoryName;
		this.createdBy = createdBy;
		this.createdDate = createdDate;
		this.updatedDate = updatedDate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public LocalDateTime getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(LocalDateTime createdDate) {
		this.createdDate = createdDate;
	}

	public LocalDateTime getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(LocalDateTime updatedDate) {
		this.updatedDate = updatedDate;
	}

	@Override
	public String toString() {
		return "Category [id=" + id + ", categoryName=" + categoryName + ", createdBy=" + createdBy + ", createdDate="
				+ createdDate + ", updatedDate=" + updatedDate + "]";
	}

}
