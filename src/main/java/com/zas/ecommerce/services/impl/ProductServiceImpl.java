package com.zas.ecommerce.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zas.ecommerce.entities.Category;
import com.zas.ecommerce.entities.Product;
import com.zas.ecommerce.payloads.ProductDto;
import com.zas.ecommerce.repo.CategoryRepo;
import com.zas.ecommerce.repo.ProductRepo;
import com.zas.ecommerce.services.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepo productRepo;

	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private CategoryRepo categoryRepo;

	@Override
	public ProductDto createProduct(ProductDto productDto) {
		Category category = this.categoryRepo.findById(productDto.getCategoryId()).get();
		Product product = this.modelMapper.map(productDto, Product.class);
		product.setCategory(category);
		Product newProduct = this.productRepo.save(product);
		ProductDto newProductDto = this.modelMapper.map(newProduct, ProductDto.class);
		return newProductDto;
	}

	@Override
	public List<ProductDto> getAllProduct() {
		List<Product> listOfAllProduct = this.productRepo.findAll();
		List<ProductDto> allProductDto = listOfAllProduct.stream().map(x -> this.modelMapper.map(x, ProductDto.class))
				.collect(Collectors.toList());
		return allProductDto;

	}

	@Override
	public List<ProductDto> getProductByCategory(Integer categoryId) {
		List<Product> products = productRepo.findByCategoryId(categoryId);
		return products.stream().map(product -> modelMapper.map(product, ProductDto.class))
				.collect(Collectors.toList());
	}

}
