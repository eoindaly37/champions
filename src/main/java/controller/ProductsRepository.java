package controller;

import model.Products;
import org.springframework.data.jpa.repository.JpaRepository;

interface ProductsRepository extends JpaRepository<Products, Long> {

}