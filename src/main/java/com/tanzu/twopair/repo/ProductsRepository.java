package com.tanzu.twopair.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tanzu.twopair.model.Products;

public interface ProductsRepository extends JpaRepository<Products, Long> {

}