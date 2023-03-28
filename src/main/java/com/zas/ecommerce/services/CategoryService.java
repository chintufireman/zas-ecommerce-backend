package com.zas.ecommerce.services;

import java.util.List;

import com.zas.ecommerce.payloads.CategoryDto;


public interface CategoryService {
	public CategoryDto createCategory(CategoryDto product);

    public List<CategoryDto> getAllCategories();
    
    public CategoryDto getCategoryById(Integer categoryId);
}
