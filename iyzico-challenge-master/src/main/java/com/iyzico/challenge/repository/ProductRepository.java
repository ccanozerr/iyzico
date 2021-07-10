package com.iyzico.challenge.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.iyzico.challenge.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{

}
