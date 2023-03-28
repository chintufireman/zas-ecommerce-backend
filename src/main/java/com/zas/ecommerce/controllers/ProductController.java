package com.zas.ecommerce.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zas.ecommerce.payloads.ProductDto;
import com.zas.ecommerce.services.ProductService;

@RestController
@RequestMapping("/api/v1/product")
public class ProductController {
	@Autowired
	private ProductService productService;
	
	@PostMapping("/create")
    public ResponseEntity<ProductDto> createUser(@RequestBody ProductDto product){
        ProductDto createdProduct = this.productService.createProduct(product);
        return new ResponseEntity<ProductDto>(createdProduct,HttpStatus.CREATED);
    }
	
	@GetMapping("/all")
    public ResponseEntity<List<ProductDto>> getAllCarts(){
        List<ProductDto> products = this.productService.getAllProduct();
        return  ResponseEntity.ok(products);
    }
	
	@GetMapping("/{categoryid}")
    public ResponseEntity<List<ProductDto>> getCartById(@PathVariable Integer categoryid){
		List<ProductDto> products = this.productService.getProductByCategory(categoryid);
        return new ResponseEntity<List<ProductDto>>(products,HttpStatus.OK);
    }
}
