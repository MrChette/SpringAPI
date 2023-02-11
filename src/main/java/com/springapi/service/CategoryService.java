package com.springapi.service;

import com.springapi.entity.Category;
import com.springapi.entity.Product;
import com.springapi.model.CategoryModel;

public interface CategoryService {
	
	//DELETE	/api/categories/{id}	Elimina una categoría y todos sus productos (categoría correspondiente a ese id)
	public abstract void removeCategory(int id);
	
	//POST	/api/categories/{id}	Crea una nueva categoría
	public abstract Category addCategory(CategoryModel categoryModel);
	
	//GET	/api/products/{id}	Recupera el producto correspondiente a ese id
	public abstract Product findCategoryById(int id);
	
	public abstract Category transform(CategoryModel categoryModel);
	public abstract Category transform(Category category);

}
