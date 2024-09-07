package com.expense.service.impl;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.stereotype.Service;

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
	public List<Category> getCategories() {

		return this.categoryRepository.findAll();
	}

	@Override
	public Category createCategory(Category category) {
		return this.categoryRepository.save(category);
	}

	@Override
	public void deleteCategory(Integer categoryId) {
		categoryRepository.deleteById(categoryId);
	}

	@Override
	public Category getCategory(Integer categoryId) {
		return categoryRepository.findById(categoryId)
				.orElseThrow(() -> new NoSuchElementException("No Category present with id: " + categoryId));
	}

}
