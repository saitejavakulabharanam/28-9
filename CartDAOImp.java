package com.teja.backend.dao;

import java.math.BigDecimal;
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

import com.teja.backend.dao.CartDAO;
import com.teja.backend.model.Cart;
import com.teja.backend.model.Product;

@Repository("cartDAO")

public class CartDAOImp implements CartDAO {

	@Autowired
	ProductDAO productDAO;
	private static final Query SessionFactory = null;
	@Autowired
	private SessionFactory sessionFactory;

	public CartDAOImp(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Transactional
	public boolean save(Cart cart) {
		try {
			Session s = sessionFactory.getCurrentSession();
			Transaction tx = s.beginTransaction();
			s.save(cart);
			tx.commit();
			return true;
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	@Transactional
	public boolean update(Cart cart) {
		try {
			Session s = sessionFactory.getCurrentSession();
			Transaction tx = s.beginTransaction();
			s.update(cart);
			tx.commit();
			return true;
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	@Transactional
	public boolean delete(Cart cart){
		try {
			Session s = sessionFactory.getCurrentSession();
			Transaction tx = s.beginTransaction();
			s.delete(cart);
			tx.commit();
			return true;
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	@Transactional
	public Cart getbyid(int id) {
		try {
			String hql = "from Cart where id=" + "'" + id + "'";
			Session s = sessionFactory.getCurrentSession();
			Transaction tx = s.beginTransaction();
			org.hibernate.Query query = s.createQuery(hql);
			List<Cart> list = query.list();
			tx.commit();
			if (list == null)

				return null;
			else {
				return list.get(0);
			}
		} catch (HibernateException e) {
			e.printStackTrace();
			return null;
		}

	}

	public List<Cart> mycartproducts(String id) {
		try {
			String hql = "from Cart where user_id=" + "'" + id + "'";
			Session s = sessionFactory.getCurrentSession();
			Transaction tx = s.beginTransaction();
			org.hibernate.Query query = s.createQuery(hql);
			List<Cart> all = query.list();
			tx.commit();
			return all;
		} catch (HibernateException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Transactional
	public int totalproducts(String id) {
		try {
			String hql = "from Cart where user_id=" + "'" + id + "'";
			Session s = sessionFactory.getCurrentSession();
			Transaction tx = s.beginTransaction();
			org.hibernate.Query query = s.createQuery(hql);
			List<Cart> all = query.list();
			tx.commit();
			int k = 0;
			for (Cart temp : all) {
				k = k + 1;
			}
			return k;
		} catch (HibernateException e) {
			e.printStackTrace();
			return 0;
		}
	}
	
	
	public int totalprice(String id){
	try{
		String hql = "from Cart where user_id=" + "'" + id + "'";
		Session s = sessionFactory.getCurrentSession();
		Transaction tx = s.beginTransaction();
		org.hibernate.Query query = s.createQuery(hql);
		List<Cart> all = query.list();
		tx.commit();
		int k=0;
		for (Cart temp : all) {
			k = k + temp.getPrice();
		}		
		return k;	
	} catch (HibernateException e) {
		e.printStackTrace();
		return 0;
	}
	
	}
	@Transactional
	public boolean orphanremoval(String id) {
		try {
			String hql = "delete from Cart where prod_id="+"'"+id+"'";
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
	public List<Cart> list() {
		try {
			String hql = "from Cart";
			Session s = sessionFactory.getCurrentSession();
			Transaction tx = s.beginTransaction();
			org.hibernate.Query query = s.createQuery(hql);
			List<Cart> all = query.list();
			tx.commit();
			return all;
		} catch (HibernateException e) {
			e.printStackTrace();
			return null;
		}

	}
}