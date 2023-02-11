package com.tiendesita.controller;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tiendesita.entity.Product;
import com.tiendesita.model.CategoryModel;
import com.tiendesita.model.ProductModel;
import com.tiendesita.service.CategoryService;
import com.tiendesita.service.ProductService;

@RestController
@RequestMapping("/api")
public class RestCategory {
	
	@Qualifier("categoryServiceImpl")
	private CategoryService categoryService;
	@Qualifier("productServiceImpl")
	private ProductService productService;
	
	//DELETE	/api/categories/{id}	Elimina una categoría y todos sus productos (categoría correspondiente a ese id)
	@DeleteMapping("/categories/{id}")
	public void deleteProduct(@PathVariable int categoryId) {
		categoryService.removeCategory(categoryId);
		productService.removeProductsInCategory(categoryId);
	}
	
	//POST	/api/categories/{id}	Crea una nueva categoría
	@PostMapping("/categories/{id}")
	public CategoryModel createCategory(@PathVariable (name="id", required = true) Integer categoryId,@RequestBody CategoryModel category) {
			category.setId(categoryId);
			categoryService.addCategory(category);
		return category;
	}
	
	
	//PUT	/api/categories/{id}	Actualiza una categoría
	@PutMapping("products/{id}")
	public CategoryModel updateCategory(@PathVariable(name = "id", required = true) Integer categoryId,@RequestBody CategoryModel category) {
			category.setId(categoryId);
			categoryService.addCategory(category);
		return category;
	}
	
	//GET	/api/categories/{id}	Recupera la categoría correspondiente a ese id
	@GetMapping("/categories/{id}")
	public Product listProduct(@PathVariable(name = "id", required = true) Integer categoryId) {
		return categoryService.findCategoryById(categoryId);
	}
}
