package com.springapi.serviceImpl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;


import com.springapi.entity.Category;
import com.springapi.entity.Product;
import com.springapi.model.CategoryModel;
import com.springapi.service.CategoryService;


@Service("categoryServiceImpl")
public class CategoryServiceImpl implements CategoryService{
	
	
	@Autowired
	@Qualifier("categoryService")
	private CategoryService categoryService;

	@Override
	public void removeCategory(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Category addCategory(CategoryModel categoryModel) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Product findCategoryById(int id) {
		return CategoryModel.;
	}
	
	@Override
	public Category transform(CategoryModel categoryModel) {
		ModelMapper modelMapper=new ModelMapper();
		return modelMapper.map(categoryModel, Category.class);
	}

	@Override
	public CategoryModel transform(Category category) {
		ModelMapper modelMapper=new ModelMapper();
		return modelMapper.map(category, CategoryModel.class);
	}

}
