package com.zas.ecommerce.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zas.ecommerce.entities.Category;
import com.zas.ecommerce.entities.Product;
import com.zas.ecommerce.payloads.CategoryDto;
import com.zas.ecommerce.payloads.ProductDto;
import com.zas.ecommerce.repo.CategoryRepo;
import com.zas.ecommerce.repo.ProductRepo;
import com.zas.ecommerce.services.CategoryService;
import com.zas.ecommerce.services.ProductService;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private CategoryRepo categoryRepo;

	@Override
	public CategoryDto createCategory(CategoryDto categoryDto) {
		Category category = this.modelMapper.map(categoryDto, Category.class);
		Category newCategory = this.categoryRepo.save(category);
		CategoryDto newCategoryDto = this.modelMapper.map(newCategory, CategoryDto.class);
		return newCategoryDto;
	}

	@Override
	public List<CategoryDto> getAllCategories() {
		List<Category> categoris = this.categoryRepo.findAll();
		List<CategoryDto> allCategoryDto = categoris.stream().map(x -> this.modelMapper.map(x, CategoryDto.class))
				.collect(Collectors.toList());
		return allCategoryDto;
	}

	@Override
	public CategoryDto getCategoryById(Integer categoryId) {
		Category category = this.categoryRepo.findById(categoryId).get();
		return this.modelMapper.map(category, CategoryDto.class);
	}
}
