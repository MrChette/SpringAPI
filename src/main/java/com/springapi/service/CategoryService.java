package com.springapi.service;




import com.springapi.entity.Category;
import com.springapi.model.CategoryModel;


public interface CategoryService {
	
	//DELETE	/api/categories/{id}	Elimina una categoría y todos sus productos (categoría correspondiente a ese id)
	public abstract void removeCategory(long id);
	//POST	/api/categories/{id}	Crea una nueva categoría
	public abstract Category addCategory(CategoryModel categoryModel);
	
	public abstract Category findCategoryById(long id);
	public abstract CategoryModel findCategoryByIdModel(long id);
	
	
	
	//PUT	/api/categories/{id}	Actualiza una categoría
	//GET	/api/categories/{id}	Recupera la categoría correspondiente a ese id
	
	public abstract Category transform(CategoryModel categoryModel);
	public abstract CategoryModel transform(Category category);
	


}
