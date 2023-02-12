package com.springapi.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springapi.entity.Category;


@Repository("categoryRepository")
public interface CategoryRepository extends JpaRepository<Category,Serializable>{

	
}
