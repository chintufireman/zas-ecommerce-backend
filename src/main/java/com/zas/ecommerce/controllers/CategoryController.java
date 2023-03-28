package com.zas.ecommerce.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zas.ecommerce.payloads.CategoryDto;
import com.zas.ecommerce.payloads.ProductDto;
import com.zas.ecommerce.services.CategoryService;
import com.zas.ecommerce.services.ProductService;


@RestController
@RequestMapping("/api/v1/category")
public class CategoryController {
	@Autowired
	private CategoryService categoryService;
	
	@PostMapping("/create")
    public ResponseEntity<CategoryDto> createUser(@RequestBody CategoryDto category){
		CategoryDto createdCategory = this.categoryService.createCategory(category);
        return new ResponseEntity<CategoryDto>(createdCategory,HttpStatus.CREATED);
    }
	
	@GetMapping("/all")
    public ResponseEntity<List<CategoryDto>> getAllCarts(){
        List<CategoryDto> categories = this.categoryService.getAllCategories();
        return  ResponseEntity.ok(categories);
    }
	
	@GetMapping("/{categoryid}")
    public ResponseEntity<CategoryDto> getCartById(@PathVariable Integer categoryid){
		CategoryDto category = this.categoryService.getCategoryById(categoryid);
        return new ResponseEntity<CategoryDto>(category,HttpStatus.OK);
    }
	
}
