package com.springapi.serviceImpl;

import org.springframework.stereotype.Service;

import com.springapi.entity.Category;
import com.springapi.entity.Product;
import com.springapi.model.CategoryModel;
import com.springapi.service.CategoryService;


@Service("categoryServiceImpl")
public class CategoryServiceImpl implements CategoryService{

	@Override
	public void removeCategory(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Category transform(CategoryModel categoryModel) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Category transform(Category category) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Category addCategory(CategoryModel categoryModel) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Product findCategoryById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
