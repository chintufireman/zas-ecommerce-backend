package com.zas.ecommerce.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.zas.ecommerce.entities.Product;

public interface ProductRepo extends JpaRepository<Product, Integer> {
	@Query("SELECT p FROM Product p WHERE p.category.categoryId = :categoryId")
	List<Product> findByCategoryId(@Param("categoryId") Integer categoryId);

}
