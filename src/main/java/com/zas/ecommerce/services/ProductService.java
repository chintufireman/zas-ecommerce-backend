package com.zas.ecommerce.services;

import java.util.List;

import com.zas.ecommerce.payloads.ProductDto;

public interface ProductService {
	public ProductDto createProduct(ProductDto product);

    public List<ProductDto> getAllProduct();
    
    public List<ProductDto> getProductByCategory(Integer categoryId);
}
