package com.teja.backend.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.teja.backend.model.Category;
import com.teja.backend.model.Supplier;
import com.teja.backend.dao.SupplierDAO;

@Repository(value = "supplierDAO")

public class SupplierDAOImpl implements SupplierDAO {

	@Autowired
	Supplier supplier;
	private static org.hibernate.SessionFactory SessionFactory = null;
	@Autowired
	private SessionFactory sessionFactory;

	public SupplierDAOImpl(SessionFactory sessionFactory) {
		this.SessionFactory = sessionFactory;
	}

	@Transactional
	public boolean save(Supplier supplier) {
		try {
			Session s = sessionFactory.getCurrentSession();
			Transaction tx = s.beginTransaction();
			s.save(supplier);
			tx.commit();
			return true;
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	@Transactional
	public boolean update(Supplier supplier) {
		try {
			Session s = sessionFactory.getCurrentSession();
			Transaction tx = s.beginTransaction();
			s.update(supplier);
			tx.commit();
			return true;
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	@Transactional
	public boolean delete(Supplier supplier) {
		try {
			Session s = sessionFactory.getCurrentSession();
			Transaction tx = s.beginTransaction();
			s.delete(supplier);
			tx.commit();
			return true;
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	@Transactional
	public Supplier getbyid(String id) {
		Session s = sessionFactory.getCurrentSession();
		Transaction tx = s.beginTransaction();
		supplier = (Supplier) s.get(Supplier.class, id);
		tx.commit();
		return supplier;
	}
	
	@Transactional
	public Supplier getbyname(String name) {
		Session s = sessionFactory.getCurrentSession();
		Transaction tx = s.beginTransaction();
		String hql = "from Supplier where name="+"'"+name+"'";
		org.hibernate.Query query = s.createQuery(hql);
		List<Supplier> list=query.list();
		tx.commit();
		if(list==null || list.isEmpty())
		{return null;}
		else{
			return list.get(0);
		}
	}
	
	@Transactional
	public List<Supplier> list() {
		String hql = "from Supplier";
		Session s = sessionFactory.getCurrentSession();
		Transaction tx = s.beginTransaction();
		org.hibernate.Query query = s.createQuery(hql);
		List<Supplier> all=query.list();
		tx.commit();
		return all;
	}
}