package com.springapi.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springapi.entity.Category;

public interface CategoryRepository extends JpaRepository<Category,Serializable>{

}
