package com.teja.backend.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.teja.backend.model.BillingAddress;

@Repository
public interface BillingAddressDAO {
	public boolean save(BillingAddress address);

	public boolean update(BillingAddress address);

	public boolean delete(BillingAddress address);

	public BillingAddress getbyid(int id);
	
	public List<BillingAddress> myaddresses(String id);
	
	
	
	
	
	
/*	
	public int totalproducts(String id);

	public int totalprice(String id);
	
	public boolean orphanremoval(String id);
	
	public List<BillingAddress> list();

*/
}
