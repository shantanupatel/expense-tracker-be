package com.expense.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.expense.model.Category;
import com.expense.repository.CategoryRepository;

@Service
public class CategoryService {

	private final CategoryRepository categoryRepository;

	public CategoryService(CategoryRepository categoryRepository) {
		super();
		this.categoryRepository = categoryRepository;
	}

	public List<Category> getCategories() {

		return this.categoryRepository.findAll();
	}

	public Category createCategory(Category category) {
		return this.categoryRepository.save(category);
	}

	public void deleteCategory(Integer categoryId) {
		categoryRepository.deleteById(categoryId);
	}

	public Optional<Category> findCategory(Integer categoryId) {
		return categoryRepository.findById(categoryId);
	}

}
