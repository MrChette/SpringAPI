	package com.springapi.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
	@PostMapping("/categories")
	public ResponseEntity<?> createCategory(@RequestBody CategoryModel category) {
			categoryService.addCategory(category);
		return ResponseEntity.status(HttpStatus.CREATED).body(category);
	}
	
	
	//Actualiza una categoría
	@PutMapping("/categories/{id}")
	public ResponseEntity<?> updateCategory(@PathVariable(name = "id", required = true) long id,@RequestBody CategoryModel category) {
			category.setId(id);
			categoryService.addCategory(category);
		return ResponseEntity.ok(categoryService.updateCategory(category));
	}
	
	//Recupera la categoría correspondiente a ese id
	@GetMapping("/categories/{id}")
	public ResponseEntity<?> listCategory(@PathVariable(name = "id", required = true) long id) {
		CategoryModel categoryM = categoryService.findCategoryByIdModel(id);
		if(categoryM==null)
			return ResponseEntity.notFound().build();
		else
		return ResponseEntity.ok(categoryM);
	}
	
	//Elimina todos los productos de una determinada categoría
	@DeleteMapping("/categories/{id}/products")
	public ResponseEntity<?> deleteProductByCategory(@PathVariable long id) {
		boolean deleted = productService.removeProductsInCategory(id);
		if(deleted)
			return ResponseEntity.ok().build();
		else
			return ResponseEntity.notFound().build();
		
	}
	
	//Elimina una categoría y todos sus productos (categoría correspondiente a ese id)
	@DeleteMapping("/categories/{id}")
	public ResponseEntity<?> deleteProduct(@PathVariable long id) {
		boolean deleted = categoryService.removeCategory(id);
		if(deleted)
			return ResponseEntity.ok().build();
		else
			return ResponseEntity.notFound().build();
	}
}
