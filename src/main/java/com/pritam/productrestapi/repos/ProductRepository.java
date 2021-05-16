package com.pritam.productrestapi.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pritam.productrestapi.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

}
