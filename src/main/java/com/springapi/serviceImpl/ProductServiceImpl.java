	package com.springapi.serviceImpl;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.springapi.entity.Category;
import com.springapi.entity.Product;
import com.springapi.model.CategoryModel;
import com.springapi.model.ProductModel;
import com.springapi.repository.CategoryRepository;
import com.springapi.repository.ProductRepository;
import com.springapi.service.ProductService;


@Service("productServiceImpl")
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	@Qualifier("productRepository")
	private ProductRepository productRepository;
	
	@Autowired
	@Qualifier("categoryRepository")
	private CategoryRepository categoryRepository;
	
	@Autowired
	@Qualifier("categoryServiceImpl")
	private CategoryServiceImpl categoryServiceImpl;
	
	
	
	
	
	@Override
	public ProductModel addProduct(ProductModel productModel) {
		productRepository.save(transform(productModel));
		return productModel;
	}

	
	@Override
	public List<ProductModel> listAllProductsByCategory(int id) {
		System.out.println(id);
		Stream<Object> category =categoryRepository.findById(id).stream().map(c->categoryServiceImpl.transform(c));
		System.out.println(category);
//		return productRepository.findAll().stream().filter(p -> p.getCategory() == category).map(c->transform(c)).collect(Collectors.toList());
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
		ModelMapper modelMapper = new ModelMapper();
		return modelMapper.map(productModel, Product.class);
	}

	@Override
	public ProductModel transform(Product product) {
		ModelMapper modelMapper = new ModelMapper();
		return modelMapper.map(product, ProductModel.class);
	}

}
