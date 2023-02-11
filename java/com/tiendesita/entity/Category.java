package com.tiendesita.entity;


import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Category {
	
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String description;
	
	@OneToMany(mappedBy="category")
    private Set<Product> Product;

	public Category() {
		super();
	}

	public Category(Long id, String name, String description, Set<com.tiendesita.entity.Product> product) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		Product = product;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Set<Product> getProduct() {
		return Product;
	}

	public void setProduct(Set<Product> product) {
		Product = product;
	}

	@Override
	public String toString() {
		return "Category [id=" + id + ", name=" + name + ", description=" + description + ", Product=" + Product + "]";
	}
	
	
	
	


	
	

}
