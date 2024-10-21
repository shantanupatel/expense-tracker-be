package com.expense.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.expense.dto.CategoryDto;
import com.expense.dto.CategoryMapper;
import com.expense.exception.DuplicateEntryException;
import com.expense.exception.IdNotFoundException;
import com.expense.model.Category;
import com.expense.repository.CategoryRepository;
import com.expense.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {

	private final CategoryRepository categoryRepository;

	public CategoryServiceImpl(CategoryRepository categoryRepository) {
		super();
		this.categoryRepository = categoryRepository;
	}

	@Override
	public List<CategoryDto> getAllCategories() {
		List<Category> categories = categoryRepository.findAll();

		return categories.stream().map(CategoryMapper::mapToCategoryDto).collect(Collectors.toList());

	}

	@Override
	public Category createNewCategory(Category category) {
		String categoryName = category.getCategoryName();

		Optional<Category> foundCategory = categoryRepository.findByCategoryName(categoryName);

		if (foundCategory.isPresent()) {
			throw new DuplicateEntryException("Category with name " + categoryName + " already exists.");
		}

		Category savedCategory = categoryRepository.save(category);

		return savedCategory;
	}

	@Override
	public void deleteCategory(Integer categoryId) {
		Category category = categoryRepository.findById(categoryId)
				.orElseThrow(() -> new IdNotFoundException("Category with id " + categoryId + " not found."));

		categoryRepository.deleteById(categoryId);
	}

	@Override
	public CategoryDto getCategoryById(Integer categoryId) {
		Optional<Category> optionalCategory = categoryRepository.findById(categoryId);

		// condition to avoid NoSuchElementException
		// https://www.javaguides.net/2023/08/javautilnosuchelementexception-no-value.html
		if (optionalCategory.isEmpty()) {
			throw new IdNotFoundException("Category with id " + categoryId + " does not exist.");
		}

		return CategoryMapper.mapToCategoryDto(optionalCategory.get());
	}

	@Override
	public void updateCategoryById(Integer categoryId, CategoryDto category) {

		Optional<Category> selectedCategory = categoryRepository.findById(categoryId);

		if (selectedCategory.isEmpty()) {
			throw new IdNotFoundException("Category with id " + categoryId + " does not exist.");
		}

		Category categoryDetails = selectedCategory.get();

		categoryDetails.setCategoryName(category.getCategoryName());

		categoryRepository.save(categoryDetails);

	}

}
