package com.expense.service;

import java.util.List;

import com.expense.model.Category;

public interface CategoryService {

	public List<Category> getCategories();

	public Category createCategory(Category category);

	public void deleteCategory(Integer categoryId);

	// public Optional<Category> findCategory(Integer categoryId);

	Category getCategory(Integer categoryId);

	public void updateCategory(Integer id, Category category);
}
