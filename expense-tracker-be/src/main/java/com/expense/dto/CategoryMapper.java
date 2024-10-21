package com.expense.dto;

import com.expense.model.Category;

public class CategoryMapper {

	// Convert User JPA Entity into UserDto
	public static CategoryDto mapToCategoryDto(Category category) {
		CategoryDto categoryDto = new CategoryDto(category.getId(), category.getCategoryName(), category.getCreatedBy(),
				category.getExpenses());

		return categoryDto;
	}

	// Convert UserDto into User JPA Entity
	public static Category mapToCategory(CategoryDto categoryDto) {
		Category category = new Category(categoryDto.getId(), categoryDto.getCategoryName(), categoryDto.getCreatedBy(),
				null, null, categoryDto.getExpenses());
		return category;
	}
}
