package com.expense.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.expense.model.Category;
import com.expense.service.CategoryService;

@RestController
@RequestMapping(value = "/")
public class CategoryController {

	private final CategoryService categoryService;

	public CategoryController(CategoryService categoryService) {
		this.categoryService = categoryService;
	}

	@GetMapping(path = "categories")
	public List<Category> getCategories() throws Exception {

		return categoryService.getCategories();

	}
}
