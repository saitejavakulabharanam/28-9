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

import com.teja.backend.model.BillingAddress;


@Repository("billingAddressDAO")

public class BillingAddressDAOImp implements BillingAddressDAO {
	private static final Query SessionFactory = null;
	@Autowired
	private SessionFactory sessionFactory;

	public BillingAddressDAOImp(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Transactional
	public boolean save(BillingAddress address) {
		try {
			Session s = sessionFactory.getCurrentSession();
			Transaction tx = s.beginTransaction();
			s.save(address);
			tx.commit();
			return true;
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}}
	
	
	@Transactional
	public boolean update(BillingAddress address)	{
		try {
			Session s = sessionFactory.getCurrentSession();
			Transaction tx = s.beginTransaction();
			s.update(address);
			tx.commit();
			return true;
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	@Transactional
	public boolean delete(BillingAddress address){
		try {
			Session s = sessionFactory.getCurrentSession();
			Transaction tx = s.beginTransaction();
			s.delete(address);
			tx.commit();
			return true;
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	@Transactional
	public BillingAddress getbyid(int id){
		try {
			String hql = "from BillingAddress where id=" + "'" + id + "'";
			Session s = sessionFactory.getCurrentSession();
			Transaction tx = s.beginTransaction();
			org.hibernate.Query query = s.createQuery(hql);
			List<BillingAddress> list = query.list();
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

	@Transactional
	public List<BillingAddress> myaddresses(String id) {
		try {
			String hql = "from BillingAddress where user_id=" + "'" + id + "'";
			Session s = sessionFactory.getCurrentSession();
			Transaction tx = s.beginTransaction();
			org.hibernate.Query query = s.createQuery(hql);
			List<BillingAddress> all = query.list();
			tx.commit();
			return all;
		} catch (HibernateException e) {
			e.printStackTrace();
			return null;
		}
	}
	
}


