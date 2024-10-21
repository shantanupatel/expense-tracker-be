package com.expense.controller;

//import java.security.Timestamp;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.expense.dto.CategoryDto;
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
	public GenericResponse<List<CategoryDto>> getCategories() {
		GenericResponse<List<CategoryDto>> response = new GenericResponse<List<CategoryDto>>(HttpStatus.OK.value(),
				"List of Categories retrieved successfully", categoryService.getAllCategories());

		return response;
	}

	@Operation(summary = "Create a new Category", description = "Create a new Category. The response is an Category object with id, category name, created by, created date and last updated date.")
	@PostMapping(consumes = { "application/json" })
	public GenericResponse<String> createCategory(@RequestBody Category category) throws Exception {

		categoryService.createNewCategory(category);

		GenericResponse<String> response = new GenericResponse<String>(HttpStatus.OK.value(),
				"New category " + category.getCategoryName() + " created successfully", null);

		return response;
	}

	@Operation(summary = "Get Category by specified ID", description = "Get Category by specified ID. The response is an Category object with id, category name, created by, created date and last updated date.")
	@GetMapping("/{categoryId}")
	public GenericResponse<CategoryDto> getCategory(@PathVariable Integer categoryId) {
		String message = "Retrieved Category with id " + categoryId;
		GenericResponse<CategoryDto> response = new GenericResponse<CategoryDto>(HttpStatus.OK.value(), message,
				categoryService.getCategoryById(categoryId));

		return response;
	}

	// @Operation(summary = "Create a new Category", description = "Create a new
	// Category. The response is an Category object with id, category name, created
	// by, created date and last updated date.")
	// @PostMapping(consumes = { "application/json" }, value = "/categorysave")
	// public ResponseEntity<String> createCategorySave(@RequestBody CategoryDto
	// categoryDto) throws Exception {
	//
	// Category newCategoryEntity = new Category();
	//
	// newCategoryEntity.setCategoryName(categoryDto.getCategoryName());
	// newCategoryEntity.setCreatedBy(categoryDto.getCreatedBy());
	//
	// Category createdCategory = categoryService.createCategory(newCategoryEntity);
	//
	// return new ResponseEntity<>("", HttpStatus.CREATED);
	//
	// }

	@DeleteMapping("/{categoryId}")
	public GenericResponse<String> deleteCategory(@PathVariable int categoryId) {
		categoryService.deleteCategory(categoryId);

		return new GenericResponse<>(HttpStatus.OK.value(), "Category with id " + categoryId + " deleted successfully",
				null);
	}

	@PutMapping("/{categoryId}")
	public GenericResponse<String> updateCategory(@PathVariable int categoryId,
			@RequestBody CategoryDto updatedCategory) {
		categoryService.updateCategoryById(categoryId, updatedCategory);

		return new GenericResponse<>(HttpStatus.OK.value(), "Category with id " + categoryId + " updated successfully",
				null);
	}
}
