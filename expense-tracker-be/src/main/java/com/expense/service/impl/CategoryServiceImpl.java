package com.expense.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

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
	public List<Category> getCategories() {

		return this.categoryRepository.findAll();
	}

	@Override
	public Category createCategory(Category category) {
		String categoryName = category.getCategoryName();

		Optional<Category> foundCategory = categoryRepository.findByCategoryName(categoryName);

		if (foundCategory.isPresent()) {
			throw new DuplicateEntryException("Category with name " + categoryName + " already exists.");
		}

		return categoryRepository.save(category);
	}

	@Override
	public void deleteCategory(Integer categoryId) {
		categoryRepository.deleteById(categoryId);
	}

	@Override
	public Category getCategory(Integer categoryId) {
		Optional<Category> selectedCategory = categoryRepository.findById(categoryId);

		if (selectedCategory.isEmpty()) {
			throw new IdNotFoundException("Category with id: " + categoryId + " does not exist.");
		}

		return selectedCategory.get();
	}

}
