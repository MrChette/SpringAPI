package com.springapi.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springapi.model.CategoryModel;
import com.springapi.service.CategoryService;
import com.springapi.service.ProductService;

@RestController
@RequestMapping("/api")
public class RestCategory {
	
	@Autowired
	@Qualifier("categoryServiceImpl")
	private CategoryService categoryService;
	
	@Autowired
	@Qualifier("productServiceImpl")
	private ProductService productService;
	
	
	
	
	
	//Crea una nueva categoría
	@PostMapping("/categories/{id}")
	public CategoryModel createCategory(@PathVariable (name="id", required = true) long id,@RequestBody CategoryModel category) {
			category.setId(id);
			categoryService.addCategory(category);
		return category;
	}
	
	//Elimina una categoría y todos sus productos (categoría correspondiente a ese id)
	@DeleteMapping("/categories/{id}")
		public void deleteProduct(@PathVariable long id) {
			categoryService.removeCategory(id);
	}
	
	
	//Actualiza una categoría
	@PutMapping("/categories/{id}")
	public CategoryModel updateCategory(@PathVariable(name = "id", required = true) long id,@RequestBody CategoryModel category) {
			category.setId(id);
			categoryService.addCategory(category);
		return category;
	}
	
	//GET	/api/categories/{id}	Recupera la categoría correspondiente a ese id
	@GetMapping("/categories/{id}")
	public CategoryModel listCategory(@PathVariable(name = "id", required = true) long id) {
		return categoryService.findCategoryByIdModel(id);
	}
	
	//Elimina todos los productos de una determinada categoría
	@DeleteMapping("/categories/{id}/products")
	public void deleteProductByCategory(@PathVariable long id) {
		productService.removeProductsInCategory(id);
	}
}
