package com.springapi.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springapi.entity.Product;

public interface ProductRepository extends JpaRepository<Product,Serializable> {
	

}
