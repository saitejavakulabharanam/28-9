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

import com.teja.backend.dao.SupplierDAO;
import com.teja.backend.model.Category;
import com.teja.backend.model.Supplier;

@Controller
public class SupplierController {

	@Autowired
	private SupplierDAO supplierDAO;
	@Autowired
	private Supplier supplier;

	@ModelAttribute
	public Supplier returnObject() {
		return new Supplier();
	}

	@RequestMapping("/Addsupplier")
	public ModelAndView AddsupplierPage() {
		ModelAndView mv = new ModelAndView("manageall");
		mv.addObject("add", 2);
		mv.addObject("listsupp", 0);
		mv.addObject("supplierList", supplierDAO.list());
		return mv;
	}

	@RequestMapping(value = "/Supplierreg", method = RequestMethod.POST)
	public ModelAndView Supplierregister(@Valid @ModelAttribute("supplier") Supplier supp, BindingResult result,
			HttpServletRequest request) throws IOException {
		ModelAndView mv = new ModelAndView("manageall");
		if(result.hasErrors()){
			mv.addObject("add", 2);}
		else{
			supplierDAO.save(supp);	
		}
		mv.addObject("listsupp", 0);
		mv.addObject("supplierList", supplierDAO.list());
		return mv;
	}

	@RequestMapping(value = "/Updatesupp{id}")
	public ModelAndView UpdatesuppPage(@PathVariable("id") String id) throws Exception {
		ModelAndView mv = new ModelAndView("manageall");
		supplier = supplierDAO.getbyid(id);
		mv.addObject("supp", supplier);
		mv.addObject("add", 2);
		mv.addObject("edit", 1);
		mv.addObject("listsupp", 0);
		mv.addObject("supplierList", supplierDAO.list());
		return mv;
	}

	@RequestMapping(value = "/Updatesupplier", method = RequestMethod.POST)
	public ModelAndView Updatesupplier(@Valid @ModelAttribute("supplier") Supplier supp,@RequestParam("address")String address, BindingResult result,
			HttpServletRequest request) throws IOException {
		System.out.println("updating supp");
		/*
		 * String id=request.getParameter("id"); System.out.println(id);
		 */
		ModelAndView mv = new ModelAndView("manageall");
		
		supp.setAddress(address);
		supplierDAO.update(supp);
		mv.addObject("listsupp", 0);
		mv.addObject("supplierList", supplierDAO.list());
		return mv;
	}

	@RequestMapping(value = "/Deletesupplier{id}")
	public ModelAndView Deletesupplier(@Valid @PathVariable("id") String id) throws Exception {

		/*
		 * String id=request.getParameter("id"); System.out.println(id);
		 */
		supplier = supplierDAO.getbyid(id);
		ModelAndView mv = new ModelAndView("manageall");
		supplierDAO.delete(supplier);
		mv.addObject("listsupp", 0);
		mv.addObject("supplierList", supplierDAO.list());
		return mv;
	}

}
