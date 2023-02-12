package com.springapi.service;




import com.springapi.entity.Category;
import com.springapi.model.CategoryModel;


public interface CategoryService {
	
	public abstract void removeCategory(long id);
	public abstract Category addCategory(CategoryModel categoryModel);
	public abstract Category updateCategory(CategoryModel categoryModel);
	public abstract Category findCategoryById(long id);
	public abstract CategoryModel findCategoryByIdModel(long id);
	public abstract Category transform(CategoryModel categoryModel);
	public abstract CategoryModel transform(Category category);
	
}
