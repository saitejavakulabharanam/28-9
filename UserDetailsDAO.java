package com.teja.backend.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.teja.backend.model.Category;
import com.teja.backend.model.UserDetails;

@Repository
public interface UserDetailsDAO {
	// declare all CURD operations
	
	public boolean save(UserDetails userdetails);

	public boolean update(UserDetails userdetails);

	public boolean delete(UserDetails userdetails);
	
	public boolean cartremoval(String id);

	public UserDetails getbyid(String id);

	public List<UserDetails> list();

	public UserDetails isValidUser(String name, String password);
	
	public List<UserDetails> checksignin(String id);
}