package com.springapi.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.springapi.entity.Product;
import com.springapi.model.ProductModel;
import com.springapi.repository.ProductRepository;
import com.springapi.service.ProductService;


@Service("productServiceImpl")
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	@Qualifier("productRepository")
	private ProductRepository productRepository;

	@Override
	public ProductModel addProduct(ProductModel productModel) {
		productRepository.save(transform(productModel));
		return productModel;
	}

	
	@Override
	public List<ProductModel> listAllProductsByCategory(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Product findProductById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ProductModel findProductByIdModel(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Product updateProduct(ProductModel productModel) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void removeProduct(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeProductsInCategory(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Product transform(ProductModel productModel) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Product transform(Product product) {
		// TODO Auto-generated method stub
		return null;
	}

}
