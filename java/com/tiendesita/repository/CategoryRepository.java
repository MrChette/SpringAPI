package com.tiendesita.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tiendesita.entity.Category;

public interface CategoryRepository extends JpaRepository<Category,Serializable>{

}
