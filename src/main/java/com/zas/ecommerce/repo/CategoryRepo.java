package com.zas.ecommerce.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zas.ecommerce.entities.Category;

public interface CategoryRepo extends JpaRepository<Category, Integer>{

}
