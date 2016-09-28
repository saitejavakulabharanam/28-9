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

import com.teja.backend.dao.CategoryDAO;
import com.teja.backend.model.Category;

@Repository("categoryDAO")

public class CategoryDAOImp implements CategoryDAO {
@Autowired
Category category;
	private static final Query SessionFactory = null;
	@Autowired
	private SessionFactory sessionFactory;

	public CategoryDAOImp(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Transactional
	public boolean save(Category category) {
		try {
			Session s = sessionFactory.getCurrentSession();
			Transaction tx = s.beginTransaction();
			s.save(category);
			tx.commit();
			return true;
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	@Transactional
	public boolean update(Category category) {
		try {
			Session s = sessionFactory.getCurrentSession();
			Transaction tx = s.beginTransaction();
			s.update(category);
			tx.commit();
			return true;
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	@Transactional
	public boolean delete(Category category) {
		try {
			Session s = sessionFactory.getCurrentSession();
			Transaction tx = s.beginTransaction();
			s.delete(category);
			tx.commit();
			return true;
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	@Transactional
	public Category getbyid(String id) {
		Session s = sessionFactory.getCurrentSession();
		Transaction tx = s.beginTransaction();
		category = (Category) s.get(Category.class, id);
		tx.commit();
		return category;
	}
	
	@Transactional
	public Category getbyname(String name) {
		Session s = sessionFactory.getCurrentSession();
		Transaction tx = s.beginTransaction();
		String hql = "from Category where name="+"'"+name+"'";
		org.hibernate.Query query = s.createQuery(hql);
		List<Category> list=query.list();
		tx.commit();
		if(list==null || list.isEmpty())
		{return null;}
		else{
			return list.get(0);
		}
	}
	
	@Transactional
	public List<Category> getbylabel(String label) {
		Session s = sessionFactory.getCurrentSession();
		Transaction tx = s.beginTransaction();
		String hql = "from Category where label="+"'"+label+"'";
		org.hibernate.Query query = s.createQuery(hql);
		List<Category> all=query.list();
		tx.commit();
		return all;
	}
	
	@Transactional
	public List<Category> list() {
		String hql = "from Category";
		Session s = sessionFactory.getCurrentSession();
		Transaction tx = s.beginTransaction();
		org.hibernate.Query query = s.createQuery(hql);
		List<Category> all=query.list();
		tx.commit();
		return all;
	}
}