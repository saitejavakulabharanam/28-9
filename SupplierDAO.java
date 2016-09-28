package com.teja.backend.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.teja.backend.model.Category;
import com.teja.backend.model.Supplier;

@Repository
public interface SupplierDAO {
	// declare all CURD operations

	public boolean save(Supplier supplier);

	public boolean update(Supplier supplier);

	public boolean delete(Supplier supplier);

	public Supplier getbyid(String id);
	
	public Supplier getbyname(String name);

	public List<Supplier> list();
}