package com.teja.controller;

import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.teja.backend.dao.CategoryDAO;
import com.teja.backend.dao.ProductDAO;
import com.teja.backend.model.BillingAddress;
import com.teja.backend.model.Category;

@Controller
public class CategoryController {
	@Autowired
	CategoryDAO categoryDAO;
	@Autowired
	Category category;
	@Autowired
	ProductDAO productDAO;

	@ModelAttribute
	public Category returnObject() {
		return new Category();
	}

	@RequestMapping("/Addcategory")
	public ModelAndView AddcategoryPage() {
		ModelAndView mv = new ModelAndView("manageall");
		mv.addObject("add", 0);
		mv.addObject("categoryList", categoryDAO.list());
		mv.addObject("listcat", 0);
		return mv;
	}

	@RequestMapping(value = "/Categoryreg", method = RequestMethod.POST)
	public ModelAndView Categoryregister(@Valid @ModelAttribute("category") Category cat, BindingResult result,
			HttpServletRequest request) throws IOException {
	
		ModelAndView mv = new ModelAndView("manageall");
		if(result.hasErrors()){
			mv.addObject("add", 0);
		mv.addObject("listcat", 0);}
		else{
			categoryDAO.save(cat);	
		}
		
		mv.addObject("categoryList", categoryDAO.list());
		mv.addObject("listcat", 0);
		return mv;
	}

	@RequestMapping(value = "/Updatecat{id}")
	public ModelAndView UpdatecatPage(@PathVariable("id") String id) throws Exception {
		ModelAndView mv = new ModelAndView("manageall");
		category = categoryDAO.getbyid(id);
		mv.addObject("cat", category);
		mv.addObject("add", 0);
		mv.addObject("edit", 1);
		mv.addObject("categoryList", categoryDAO.list());
		mv.addObject("listcat", 0);
		return mv;
	}

	@RequestMapping(value = "/categoryupdate", method = RequestMethod.POST)
	public ModelAndView Updatecategory(@Valid @ModelAttribute("category") Category cat,@RequestParam("description")String description,BindingResult result,
			HttpServletRequest request) throws IOException {

		ModelAndView mv = new ModelAndView("manageall");
		cat.setDescription(description);
		categoryDAO.update(cat);
		mv.addObject("categoryList", categoryDAO.list());
		mv.addObject("listcat", 0);
		return mv;
	}

	@RequestMapping(value = "/Deletecategory{id}")
	public ModelAndView deleteCategory(@PathVariable("id") String id) throws Exception {
		category = categoryDAO.getbyid(id);
		productDAO.orphanremoval(category.getId());
		categoryDAO.delete(category);
		ModelAndView mv = new ModelAndView("manageall");
		mv.addObject("categoryList", categoryDAO.list());
		mv.addObject("listcat", 0);
		return mv;
	}

}
