package com.springapi.controller;

import java.util.List;

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

import com.springapi.entity.Product;
import com.springapi.model.ProductModel;
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
	
	
	//Crea un nuevo producto para una categoría
	@PostMapping("/categories/{id}/product")
	public ProductModel createProduct(@PathVariable (name="id", required = true) long id,@RequestBody ProductModel product) {
			product.setIdCategory(id);
			productService.addProduct(product);
		return product;
	}
	
	//Actualiza el producto correspondiente a ese id
	@PutMapping("/products/{id}")
	public ProductModel updateProduct(@PathVariable(name = "id", required = true) long id,@RequestBody ProductModel product) {
			Product productM = productService.transform(productService.findProductByIdModel(id)) ;
			product.setIdCategory(productM.getCategory().getId());
			productService.updateProduct(product);
		return product;
	}
	
		
	//Elimina el producto correspondiente a ese id
	@DeleteMapping("/products/{id}")
	public void deleteProduct(@PathVariable long id) {
		productService.removeProduct(id);
	}
	
	
	//Recupera el producto correspondiente a ese id
	@GetMapping("/products/{id}")
	public ProductModel listProduct(@PathVariable(name = "id", required = true) long id) {
		return productService.findProductByIdModel(id);
	}

	
	//Recupera todos los productos de una determinada categoría
	@GetMapping("/categories/{id}/products")
	public List<ProductModel> listAllProductsByCategory(@PathVariable(name = "id", required = true) long id) {
		return productService.listAllProductsByCategory(id);
	}
		
	
		
	
	
	
	
	
	
	
}
