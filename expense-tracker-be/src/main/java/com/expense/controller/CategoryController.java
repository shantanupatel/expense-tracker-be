package com.expense.controller;

//import java.security.Timestamp;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.expense.model.Category;
import com.expense.response.GenericResponse;
import com.expense.service.impl.CategoryServiceImpl;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/categories")
public class CategoryController {

	private final CategoryServiceImpl categoryService;

	public CategoryController(CategoryServiceImpl categoryService) {
		this.categoryService = categoryService;
	}

	@Operation(summary = "Get list of Categories", description = "Get list of all Categories. The response is a list of Categories object with id, category name, created by, created date and last updated date.")
	@GetMapping()
//	public List<Category> getCategories() throws Exception {
//
//		return categoryService.getCategories();
//
//	}

	public GenericResponse<List<Category>> getCategories() {

		GenericResponse<List<Category>> response = new GenericResponse<List<Category>>(HttpStatus.OK.value(),
				"List of Categories retrieved successfully", categoryService.getCategories());

		return response;
	}

	@Operation(summary = "Create a new Category", description = "Create a new Category. The response is an Category object with id, category name, created by, created date and last updated date.")
	@PostMapping(consumes = { "application/json" })
	public ResponseEntity<Category> createCategory(@RequestBody Category category) throws Exception {

		Category newCategory = new Category();

		newCategory.setCategoryName(category.getCategoryName());
		newCategory.setCreatedBy(category.getCreatedBy());

		Category createdCategory = categoryService.createCategory(newCategory);

		return new ResponseEntity<>(createdCategory, HttpStatus.CREATED);

	}

	@Operation(summary = "Get Category by specified ID", description = "Get Category by specified ID. The response is an Category object with id, category name, created by, created date and last updated date.")
	@GetMapping("/{categoryId}")
	public GenericResponse<Category> getCategory(@PathVariable Integer categoryId) {
		GenericResponse<Category> response = new GenericResponse<Category>(HttpStatus.OK.value(), "",
		categoryService.getCategory(categoryId));

		return response;
	}

}
