package com.tiendesita.service;

import java.util.List;


import com.tiendesita.entity.Product;
import com.tiendesita.model.ProductModel;

public interface ProductService {
	
	//POST	/api/categories/{id}/product	Crea un nuevo producto para una categoría
	public abstract ProductModel addProduct(ProductModel productModel);
	
	//GET	/api/categories/{id}/products	Recupera todos los productos de una determinada categoría
	public abstract List<ProductModel> listAllProductsByCategory(int id);
	
	//GET	/api/products/{id}	Recupera el producto correspondiente a ese id
	public abstract Product findProductById(int id);
	public abstract ProductModel findProductByIdModel(int id);
	
	//PUT	/api/products/{id}	Actualiza el producto correspondiente a ese id
	public abstract Product updateProduct(ProductModel productModel);
	
	//DELETE	/api/products/{id}	Elimina el producto correspondiente a ese id
	public abstract void removeProduct(int id);
		
	//DELETE	/api/categories/{id}/products	Elimina todos los productos de una determinada categoría
	public abstract void removeProductsInCategory(int id);
	
	
	public abstract Product transform(ProductModel productModel);
	public abstract Product transform(Product product);
}
