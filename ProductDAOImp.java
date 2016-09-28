package com.teja.backend.dao;

import java.util.ArrayList;
import java.util.List;

import javax.management.Query;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.teja.backend.dao.ProductDAO;
import com.teja.backend.model.Cart;
import com.teja.backend.model.Product;

@Repository(value = "productDAO")

public class ProductDAOImp implements ProductDAO {
	@Autowired
	Product product;

	private static final Query SessionFactory = null;
	@Autowired
	private SessionFactory sessionFactory;

	public ProductDAOImp(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Transactional
	public boolean save(Product product) {
		try {
			Session s = sessionFactory.getCurrentSession();
			Transaction tx = s.beginTransaction();
			s.save(product);
			tx.commit();
			return true;
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	@Transactional
	public boolean update(Product product) {
		try {
			Session s = sessionFactory.getCurrentSession();
			Transaction tx = s.beginTransaction();
			s.update(product);
			tx.commit();
			return true;
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	@Transactional
	public boolean delete(Product product) {
		try {
			Session s = sessionFactory.getCurrentSession();
			Transaction tx = s.beginTransaction();
			s.delete(product);
			tx.commit();
			return true;
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	@Transactional
	public boolean orphanremoval(String id) {
		try {
			String hql = "delete from Product where cat_id="+"'"+id+"'";
			Session s = sessionFactory.getCurrentSession();
			Transaction tx = s.beginTransaction();
			org.hibernate.Query query = s.createQuery(hql);
			query.executeUpdate();
			tx.commit();
			return true;
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	
	@Transactional
	public Product getbyid(String id) {
		try{Session s = sessionFactory.getCurrentSession();
		Transaction tx = s.beginTransaction();
		product = (Product) s.get(Product.class, id);
		tx.commit();
		return product;}
		catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	@Transactional
	public List<Product> getbycat(String id){
		try{String hql = "from Product where cat_id="+"'"+id+"'";
		Session s = sessionFactory.getCurrentSession();
		Transaction tx = s.beginTransaction();
		org.hibernate.Query query = s.createQuery(hql);
		List<Product> all = query.list();
		tx.commit();
		return all;}
		catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	@Transactional
	public List<Product> getbybrand(String name){
		try{String hql = "from Product where brand="+"'"+name+"'";
		Session s = sessionFactory.getCurrentSession();
		Transaction tx = s.beginTransaction();
		org.hibernate.Query query = s.createQuery(hql);
		List<Product> all = query.list();
		tx.commit();
		return all;}
		catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	@Transactional
	public List<Product> getbybrandandcat(String name,String id){
		try{String hql = "from Product where brand="+"'"+name+"'"+" and cat_id="+"'"+id+"'";
		Session s = sessionFactory.getCurrentSession();
		Transaction tx = s.beginTransaction();
		org.hibernate.Query query = s.createQuery(hql);
		List<Product> all = query.list();
		tx.commit();
		return all;}
		catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	@Transactional
	public List<Product> list() {
		try{String hql = "from Product";
		Session s = sessionFactory.getCurrentSession();
		Transaction tx = s.beginTransaction();
		org.hibernate.Query query = s.createQuery(hql);
		List<Product> all = query.list();
		tx.commit();
		return all;}
		catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
}