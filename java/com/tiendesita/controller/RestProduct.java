package com.tiendesita.controller;

import java.util.List;

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
import com.tiendesita.model.ProductModel;
import com.tiendesita.service.ProductService;



@RestController
@RequestMapping("/api")
public class RestProduct {
	
	@Qualifier("productServiceImpl")
	private ProductService productService;
	
	
	//POST	/api/categories/{id}/product	Crea un nuevo producto para una categoría
	@PostMapping("/categories/{id}/product")
	public ProductModel createProduct(@PathVariable (name="id", required = true) Integer categoryId,@RequestBody ProductModel product) {
			product.setIdCategory(categoryId);
			productService.addProduct(product);
		return product;
	}
	
	
	
	//GET	/api/products/{id}	Recupera el producto correspondiente a ese id
	@GetMapping("products/{id}")
	public Product listProduct(@PathVariable(name = "id", required = true) Integer productId) {
		return productService.findProductById(productId);
	}

	
	//GET	/api/categories/{id}/products	Recupera todos los productos de una determinada categoría
	@GetMapping("products/{id}")
	public List<ProductModel> listAllProductsByCategory(@PathVariable(name = "id", required = true) Integer categoryId) {
		return productService.listAllProductsByCategory(categoryId);
	}
	
	
	//PUT	/api/products/{id}	Actualiza el producto correspondiente a ese id
	@PutMapping("products/{id}")
	public ProductModel updateProduct(@PathVariable(name = "id", required = true) Integer productId,@RequestBody ProductModel product) {
			product.setId(productId);
			productService.addProduct(product);
		return product;
	}
	
	
	
		
	//DELETE	/api/products/{id}	Elimina el producto correspondiente a ese id
	@DeleteMapping("/products/{id}")
	public void deleteProduct(@PathVariable int productId) {
		productService.removeProduct(productId);
	}
	
	
	//DELETE	/api/categories/{id}/products	Elimina todos los productos de una determinada categoría
	@DeleteMapping("/products/{id}")
	public void deleteProductByCategory(@PathVariable int categoryId) {
		productService.removeProductsInCategory(categoryId);
	}
	
	
	
}
