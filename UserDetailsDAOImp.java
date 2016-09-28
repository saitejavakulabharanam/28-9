package com.teja.backend.dao;

import java.util.List;

import javax.management.Query;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.teja.backend.model.Category;
import com.teja.backend.model.Product;
import com.teja.backend.model.UserDetails;
import com.teja.backend.dao.UserDetailsDAO;

@Repository(value = "userDetailsDAO")

public class UserDetailsDAOImp implements UserDetailsDAO {
	@Autowired
	UserDetails user;

	private static final Query SessionFactory = null;
	@Autowired
	private SessionFactory sessionFactory;

	public UserDetailsDAOImp(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Transactional
	public boolean save(UserDetails userdetails) {
		try {
			Session s = sessionFactory.getCurrentSession();
			Transaction tx = s.beginTransaction();
			s.save(userdetails);
			tx.commit();
			// sessionFactory.getCurrentSession().save(userdetails);
			return true;
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	@Transactional
	public boolean update(UserDetails userdetails) {
		try {
			Session s = sessionFactory.getCurrentSession();
			Transaction tx = s.beginTransaction();
			s.update(userdetails);
			tx.commit();
			// sessionFactory.getCurrentSession().update(userdetails);
			return true;
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	@Transactional
	public boolean delete(UserDetails userdetails) {
		try {
			Session s = sessionFactory.getCurrentSession();
			Transaction tx = s.beginTransaction();
			s.delete(userdetails);
			tx.commit();
			// sessionFactory.getCurrentSession().delete(userdetails);
			return true;
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	@Transactional
	
	public boolean cartremoval(String id){
		try {
			String hql = "delete from Cart where user_id="+"'"+id+"'";
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
	public UserDetails getbyid(String id) {
		Session s = sessionFactory.getCurrentSession();
		Transaction tx = s.beginTransaction();
		user = (UserDetails) s.get(UserDetails.class, id);
		tx.commit();
		return user;
	}
		
	@Transactional
	public UserDetails isValidUser(String name, String password) {
		String hql = "from UserDetails where id ='" + name + "' and password='" + password + "'";
		Session s = sessionFactory.getCurrentSession();
		Transaction tx = s.beginTransaction();
		org.hibernate.Query query = s.createQuery(hql);
		List<UserDetails> list = query.list();
		tx.commit();
		if (list == null)
		{System.out.println("till now");
			return null;}
		else {
			return list.get(0);
		}
	}

	@Transactional
	public List<UserDetails> list() {
		String hql = "from UserDetails";
		Session s = sessionFactory.getCurrentSession();
		Transaction tx = s.beginTransaction();
		org.hibernate.Query query = s.createQuery(hql);
		List<UserDetails> all=query.list();
		tx.commit();
		return all;
	}
	
	public List<UserDetails> checksignin(String id) {
		String hql = "from UserDetails where id="+"'"+id+"'";
		Session s = sessionFactory.getCurrentSession();
		Transaction tx = s.beginTransaction();
		org.hibernate.Query query = s.createQuery(hql);
		List<UserDetails> all=query.list();
		tx.commit();
		return all;
	}
	
}
