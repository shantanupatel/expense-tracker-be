package com.expense.dto;

import java.util.List;

import com.expense.model.Expense;
import com.expense.model.User;

public class CategoryDto {

	private int id;
	private String categoryName;
	private User createdBy;
	public List<Expense> expenses;

	// @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	// private LocalDateTime createdDate;

	// @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	// private LocalDateTime updatedDate;

	public CategoryDto() {
		super();
	}

	public CategoryDto(int id, String categoryName, User user, List<Expense> expenses) {
		super();
		this.id = id;
		this.categoryName = categoryName;
		this.createdBy = user;
		// this.createdDate = createdDate;
		// this.updatedDate = updatedDate;
		this.expenses = expenses;

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

	public User getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(User createdBy) {
		this.createdBy = createdBy;
	}

	// public LocalDateTime getCreatedDate() {
	// return createdDate;
	// }
	//
	// public void setCreatedDate(LocalDateTime createdDate) {
	// this.createdDate = createdDate;
	// }
	//
	// public LocalDateTime getUpdatedDate() {
	// return updatedDate;
	// }
	//
	// public void setUpdatedDate(LocalDateTime updatedDate) {
	// this.updatedDate = updatedDate;
	// }

	public List<Expense> getExpenses() {
		return expenses;
	}

	public void setExpenses(List<Expense> expenses) {
		this.expenses = expenses;
	}

	@Override
	public String toString() {
		return "Category [id=" + id + ", categoryName=" + categoryName + ", createdBy=" + createdBy + "]";
	}

}
