package com.teja.backend.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.teja.backend.model.Supplier;
import com.teja.backend.model.UserDetails;
import com.teja.backend.dao.CartDAO;
import com.teja.backend.dao.CartDAOImp;
import com.teja.backend.dao.CategoryDAO;
import com.teja.backend.dao.CategoryDAOImp;
import com.teja.backend.dao.ProductDAO;
import com.teja.backend.dao.ProductDAOImp;
import com.teja.backend.dao.SupplierDAO;
import com.teja.backend.dao.SupplierDAOImpl;
import com.teja.backend.dao.UserDetailsDAO;
import com.teja.backend.dao.UserDetailsDAOImp;
import com.teja.backend.model.BillingAddress;
import com.teja.backend.model.Cart;
import com.teja.backend.model.Category;
import com.teja.backend.model.Product;

@Configuration
@ComponentScan("com.teja")
@EnableTransactionManagement

public class ApplicationContextConfig {

	@Bean(name = "dataSource")
	public DataSource getDataSource() {
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName("org.h2.Driver");
		dataSource.setUrl("jdbc:h2:tcp://localhost/~/test");
		dataSource.setUsername("sai");
		dataSource.setPassword("");
		return dataSource;
	}
	private Properties getHibernateProperties() {
		Properties properties = new Properties();
		properties.put("hibernate.show_sql", "true");
		properties.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
		properties.put("hibernate.hbm2dll.auto", "update");
		properties.put("hibernate.current_session_context_class", "thread");
		return properties;
	}
	@Autowired
	@Bean(name = "sessionfactory")
	public SessionFactory getSessionFactory(DataSource dataSource) {
		LocalSessionFactoryBuilder sessionBuilder = new LocalSessionFactoryBuilder(dataSource);
		sessionBuilder.addProperties(getHibernateProperties());
		sessionBuilder.addAnnotatedClasses(Category.class);
		sessionBuilder.addAnnotatedClass(Supplier.class);
		sessionBuilder.addAnnotatedClass(Product.class);
		sessionBuilder.addAnnotatedClass(UserDetails.class);
		  sessionBuilder.addAnnotatedClass(Cart.class);
		  sessionBuilder.addAnnotatedClass(BillingAddress.class);
		return sessionBuilder.buildSessionFactory();
	}

	@Autowired
	@Bean(name = "transactionmanager")
	public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory) {
		HibernateTransactionManager transactionManager = new HibernateTransactionManager(sessionFactory);
		return transactionManager;
	}

	@Autowired
	@Bean(name = "categoryDAO")
	public CategoryDAO getCategoryDAO(SessionFactory sessionFactory) {
		return new CategoryDAOImp(sessionFactory);
	}

	@Autowired
	@Bean(name = "category")
	public Category getCategory() {
		return new Category();
	}

	@Autowired
	@Bean(name = "productDAO")
	public ProductDAO getProductDAO(SessionFactory sessionFactory) {
		return new ProductDAOImp(sessionFactory);
	}

	@Autowired
	@Bean(name = "product")
	public Product getProduct() {
		return new Product();
	}
	
	@Autowired
	@Bean(name = "supplierDAO")
	public SupplierDAO getSupplierDAO(SessionFactory sessionFactory) {
		return new SupplierDAOImpl(sessionFactory);
	}

	@Autowired
	@Bean(name = "supplier")
	public Supplier getSupplier() {
		return new Supplier();
	}

	@Autowired
	@Bean(name = "userDetailsDAO")
	public UserDetailsDAO getUserDetailsDAO(SessionFactory sessionFactory) {
		return new UserDetailsDAOImp(sessionFactory);
	}

	@Autowired
	@Bean(name = "userDetails")
	public UserDetails getUserDetails() {
		return new UserDetails();
	}
	@Autowired
	@Bean(name = "cartDAO")
	public CartDAO getCartDAO(SessionFactory sessionFactory) {
		return new CartDAOImp(sessionFactory);
	}

	@Autowired
	@Bean(name = "cart")
	public Cart getCart() {
		return new Cart();
	}

	
}