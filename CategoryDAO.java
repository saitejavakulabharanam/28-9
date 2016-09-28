package com.teja.backend.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.teja.backend.model.Category;

@Repository
public interface CategoryDAO {
	// declare all CURD operations

	public boolean save(Category category);

	public boolean update(Category category);

	public boolean delete(Category category);

	public Category getbyid(String id);
	
	public Category getbyname(String name);
	
	public List<Category> getbylabel(String label);
	
	
	public List<Category> list();
}