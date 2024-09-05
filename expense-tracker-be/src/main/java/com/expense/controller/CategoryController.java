package com.expense.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.expense.model.Category;
import com.expense.service.CategoryService;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/categories")
public class CategoryController {

	private final CategoryService categoryService;

	public CategoryController(CategoryService categoryService) {
		this.categoryService = categoryService;
	}

	@Operation(summary = "Get list of Categories", description = "Get list of all Categories. The response is a list of Categories object with id, category name, created by, created date and last updated date.")
	@GetMapping()
	public List<Category> getCategories() throws Exception {

		return categoryService.getCategories();

	}

	@Operation(summary = "Create a new Category", description = "Create a new Category. The response is an Category object with id, category name, created by, created date and last updated date.")
	@PostMapping(consumes = { "application/json" })
	public ResponseEntity<Category> createCategory(@RequestBody Category category) throws Exception {

		System.out.println(category);

		Category newCategory = new Category();

		newCategory.setCategoryName(category.getCategoryName());
		newCategory.setCreatedBy(category.getCreatedBy());

		Category createdCategory = categoryService.createCategory(newCategory);

		return new ResponseEntity<>(createdCategory, HttpStatus.CREATED);

	}

}
