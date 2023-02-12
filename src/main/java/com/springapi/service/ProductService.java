package com.springapi.service;

import java.util.List;

import com.springapi.entity.Category;
import com.springapi.entity.Product;
import com.springapi.model.ProductModel;


public interface ProductService {
	
	//POST	/api/categories/{id}/product	Crea un nuevo producto para una categoría
	public abstract ProductModel addProduct(ProductModel productModel);
	
	//GET	/api/categories/{id}/products	Recupera todos los productos de una determinada categoría
	public abstract List<ProductModel> listAllProductsByCategory(long id);
	
	//DELETE	/api/categories/{id}/products	Elimina todos los productos de una determinada categoría
	public abstract void removeProductsInCategory(long id);
	
	//GET	/api/products/{id}	Recupera el producto correspondiente a ese id
	public abstract Product findProductById(long id);
	public abstract ProductModel findProductByIdModel(long id);
	
	//PUT	/api/products/{id}	Actualiza el producto correspondiente a ese id
	public abstract ProductModel updateProduct(ProductModel productModel);
	
	//DELETE	/api/products/{id}	Elimina el producto correspondiente a ese id
	public abstract void removeProduct(long id);
		

	
	
	public abstract Product transform(ProductModel productModel);
	public abstract ProductModel transform(Product product);
}
