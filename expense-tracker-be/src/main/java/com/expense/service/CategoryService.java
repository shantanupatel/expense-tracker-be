package com.expense.service;

import java.util.List;

import com.expense.dto.CategoryDto;
import com.expense.model.Category;

public interface CategoryService {

	// get all categories
	public List<CategoryDto> getAllCategories();

	// create a new category
	public Category createNewCategory(Category category);

	// delete an existing category
	public void deleteCategory(Integer categoryId);

	// get an existing category by id
	CategoryDto getCategoryById(Integer categoryId);

	// update an existing category by id
	public void updateCategoryById(Integer id, CategoryDto category);
}
