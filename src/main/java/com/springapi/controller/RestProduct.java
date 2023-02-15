package com.springapi.controller;

import java.util.List;

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

import com.springapi.entity.Product;
import com.springapi.model.ProductModel;
import com.springapi.repository.ProductRepository;
import com.springapi.service.CategoryService;
import com.springapi.service.ProductService;



@RestController
@RequestMapping("/api")
public class RestProduct {
	
	@Autowired
	@Qualifier("categoryServiceImpl")
	private CategoryService categoryService;
	
	@Autowired
	@Qualifier("productServiceImpl")
	private ProductService productService;
	
	@Autowired
	@Qualifier("productRepository")
	private ProductRepository productRepository;
	
	
	//Crea un nuevo producto para una categoría
	@PostMapping("/categories/{id}/product")
	public ResponseEntity<?> createProduct(@PathVariable (name="id", required = true) long id,@RequestBody ProductModel product) {
			product.setIdCategory(id);
			productService.addProduct(product);
			return ResponseEntity.status(HttpStatus.CREATED).body(product);
	}
	
	//Actualiza el producto correspondiente a ese id si existe
	@PutMapping("/products/{id}")
	public ResponseEntity<?> updateProduct(@PathVariable(name = "id", required = true) long id,@RequestBody ProductModel product) {
			boolean exist = productRepository.findByIdProduct(id)!=null;
			if(exist) {
				Product productM = productService.transform(productService.findProductByIdModel(id)) ;
				product.setIdCategory(productM.getCategory().getId());
				product.setId(id);
				productService.updateProduct(product);
				return ResponseEntity.ok(product);
			}
			else
				return ResponseEntity.notFound().build();
	}
	
	
	//Recupera el producto correspondiente a ese id
	@GetMapping("/products/{id}")
	public ResponseEntity<?> listProduct(@PathVariable(name = "id", required = true) long id) {
		ProductModel productM = productService.findProductByIdModel(id);
			if(productM==null)
				return ResponseEntity.notFound().build();
			else
				return ResponseEntity.ok(productM);
	}

	
	//Recupera todos los productos de una determinada categoría
	@GetMapping("/categories/{id}/products")
	public ResponseEntity<?> listAllProductsByCategory(@PathVariable(name = "id", required = true) long id) {
		List<ProductModel> productL = productService.listAllProductsByCategory(id);
		if(productL.isEmpty())
			return ResponseEntity.notFound().build();
		else
			return ResponseEntity.ok(productL);
	}
		
	
	//Elimina el producto correspondiente a ese id
	@DeleteMapping("/products/{id}")
	public ResponseEntity<?> deleteProduct(@PathVariable long id) {
		boolean deleted  = productService.removeProduct(id);
		if(deleted)
			return ResponseEntity.ok().build();
		else
			return ResponseEntity.notFound().build();
	}
	
	
		
	
	
	
	
	
	
	
}
