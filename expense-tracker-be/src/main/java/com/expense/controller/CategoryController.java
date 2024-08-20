package com.expense.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CategoryController {

	@GetMapping(path = "categories")
	public List<String> getCategories() {
		ArrayList<String> categories = new ArrayList<>();

		categories.add("Category 1");
		categories.add("Category 2");

		return categories;
	}
}
