package com.teja.backend.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.teja.backend.model.Cart;
import com.teja.backend.model.Product;

@Repository
public interface ProductDAO {
	// declare all CURD operations
	
	public boolean save(Product product);

	public boolean update(Product product);

	public boolean delete(Product product);

	public boolean orphanremoval(String id);
	
	public Product getbyid(String id);

	public List<Product> getbycat(String id);
	
	public List<Product> getbybrand(String name);
	
	public List<Product> getbybrandandcat(String name,String id);
	
	public List<Product> list();
}