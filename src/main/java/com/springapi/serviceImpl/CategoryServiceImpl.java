package com.springapi.serviceImpl;



import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.springapi.entity.Category;
import com.springapi.entity.Product;
import com.springapi.model.CategoryModel;
import com.springapi.model.ProductModel;
import com.springapi.repository.CategoryRepository;
import com.springapi.repository.ProductRepository;
import com.springapi.service.CategoryService;
import com.springapi.service.ProductService;


@Service("categoryServiceImpl")
public class CategoryServiceImpl implements CategoryService{
	
	
	@Autowired
	@Qualifier("categoryRepository")
	private CategoryRepository categoryRepository;
	
	@Autowired
	@Qualifier("productRepository")
	private ProductRepository productRepository;
	

	

	@Override
	public Category addCategory(CategoryModel categoryModel) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public void removeCategory(long id) {
		categoryRepository.deleteById(id);
	}
	
	

	@Override
	public Category findCategoryById(long id) {
		return categoryRepository.findById(id);
	}
	@Override
	public CategoryModel findCategoryByIdModel(long id) {
		return transform(categoryRepository.findById(id));
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
