package com.teja.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.teja.backend.dao.CategoryDAO;
import com.teja.backend.dao.ProductDAO;
import com.teja.backend.dao.SupplierDAO;
import com.teja.backend.dao.UserDetailsDAO;
import com.teja.backend.model.Category;
import com.teja.backend.model.Product;
import com.teja.backend.model.Supplier;

@Controller
public class AdminController {

	@Autowired
	private Product product;
	@Autowired
	private Supplier supplier;
	@Autowired
	private Category category;
	@Autowired
	private SupplierDAO supplierDAO;
	@Autowired
	private CategoryDAO categoryDAO;
	@Autowired
	private ProductDAO productDAO;
	@Autowired
	UserDetailsDAO userDetailsDAO;

	@RequestMapping(value = "/productlist")
	public ModelAndView listProducts() {// log.debug("Starting of the
												// method listSupliers");
		ModelAndView mv = new ModelAndView("manageall");
		mv.addObject("listprod", 0);
		return mv;
	}
	@RequestMapping(value = "/categorylist")
	public ModelAndView listCategories() {// log.debug("Starting of the
		// method listCategories");
		ModelAndView mv = new ModelAndView("manageall");
		mv.addObject("listcat", 0);
		mv.addObject("categoryList", categoryDAO.list());
		// log.debug("End of the method listCategories");
		return mv;
	}
	
	@RequestMapping(value = "/supplierlist")
	public ModelAndView listSuppliers() {// log.debug("Starting of the
												// method listSupliers");
		ModelAndView mv = new ModelAndView("manageall");
		mv.addObject("listsupp", 0);
		mv.addObject("supplierList", supplierDAO.list());
		//Log.debug("End of the method listCategories");
		return mv;
	}

	@RequestMapping(value = "/userslist")
	public ModelAndView listUsers() {// log.debug("Starting of the
												// method listSupliers");
		ModelAndView mv = new ModelAndView("manageall");
		mv.addObject("listusers", 0);
		mv.addObject("userdetailsList", userDetailsDAO.list());
		//Log.debug("End of the method listCategories");
		return mv;
	}
	
}
