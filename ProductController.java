package com.teja.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.teja.backend.dao.CartDAO;
import com.teja.backend.dao.CategoryDAO;
import com.teja.backend.dao.ProductDAO;
import com.teja.backend.dao.SupplierDAO;
import com.teja.backend.model.Category;
import com.teja.backend.model.Product;
import com.teja.backend.model.Supplier;

@Controller
public class ProductController {

	@Autowired
	Product product;
	@Autowired
	ProductDAO productDAO;
	@Autowired
	CategoryDAO categoryDAO;
	@Autowired
	SupplierDAO supplierDAO;
	@Autowired
	Category category;
	@Autowired
	Supplier supplier;
	@Autowired
	CartDAO cartDAO;

	@ModelAttribute
	public Product returnObject() {
		return new Product();
	}
	
	@RequestMapping("/Addproduct")
	public ModelAndView AddproductPage() {
		ModelAndView mv = new ModelAndView("manageall");
		mv.addObject("add", 1);
		mv.addObject("categoryList", categoryDAO.list());
		mv.addObject("supplierList", supplierDAO.list());
		mv.addObject("listprod", 0);
		mv.addObject("listcat", 0);
		mv.addObject("listsupp", 0);
		return mv;
	}

	@RequestMapping(value = "/Productreg", method = RequestMethod.POST)
	public ModelAndView Productregister(@Valid @ModelAttribute("product") Product prod, BindingResult result,
			HttpServletRequest request) throws IOException {
		ModelAndView mv = new ModelAndView("manageall");

		@SuppressWarnings("unused")
		String filename;
		@SuppressWarnings("unused")
		byte[] bytes;

		System.out.println("image uploaded");

		System.out.println("myproduct controller called");
		MultipartFile image = prod.getImage();
		Path path;
		path = Paths.get("E://Eclipse Projects//new//frontend//src//main//webapp//resources//images//products//" + prod.getName()
				+ ".jpg");

		System.out.println("Path = " + path);
		System.out.println("File name = " + prod.getImage().getOriginalFilename());
		if (image != null && !image.isEmpty()) {
			try {
				image.transferTo(new File(path.toString()));
				System.out.println("Image Saved in:" + path.toString());
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("Image not saved");
			}
		}
		category = categoryDAO.getbyname(prod.getCategory().getName());
		supplier = supplierDAO.getbyname(prod.getSupplier().getName());
		prod.setSupplier(supplier);
		prod.setCategory(category);
		prod.setCat_Id(category.getId());
		prod.setSupp_Id(supplier.getId());

		productDAO.save(prod);
		mv.addObject("listprod", 0);
		
		System.out.println("product added");
		return mv;
	}

	@RequestMapping(value = "/Updateprod&{id}")
	public ModelAndView UpdatecatPage(@PathVariable("id") String id) throws Exception {
		ModelAndView mv = new ModelAndView("manageall");
		product = productDAO.getbyid(id);
		mv.addObject("prod", product);
		mv.addObject("add", 1);
		mv.addObject("edit", 1);
		mv.addObject("categoryList", categoryDAO.list());
		mv.addObject("supplierList", supplierDAO.list());
		mv.addObject("listcat", 0);
		mv.addObject("listsupp", 0);
		mv.addObject("listprod", 0);
		return mv;
	}

	@RequestMapping(value = "/Updateproduct", method = RequestMethod.POST)
	public ModelAndView Updateproduct(@Valid @ModelAttribute("product") Product prod,@RequestParam("description")String description, BindingResult result,
			HttpServletRequest request) throws IOException {
		ModelAndView mv = new ModelAndView("manageall");
		prod.setDescription(description);
		category = categoryDAO.getbyname(prod.getCategory().getName());
		supplier = supplierDAO.getbyname(prod.getSupplier().getName());
		prod.setSupplier(supplier);
		prod.setCategory(category);
		prod.setCat_Id(category.getId());
		prod.setSupp_Id(supplier.getId());
		productDAO.update(prod);
		mv.addObject("listprod", 0);
		return mv;
	}

	@RequestMapping(value = "/Deleteproduct&{id}")
	public ModelAndView Deleteproduct(@Valid @PathVariable("id") String id) throws Exception {
		System.out.println("deleting prod");
		cartDAO.orphanremoval(id);
		product = productDAO.getbyid(id);
		/*
		 * String id=request.getParameter("id"); System.out.println(id);
		 */
		ModelAndView mv = new ModelAndView("manageall");
		productDAO.delete(product);
		mv.addObject("listprod", 0);
		
		return mv;
	}

	String setName;
	List<Product> plist;

	@SuppressWarnings("unchecked")
	@RequestMapping("/GsonCon")
	public @ResponseBody String getValues() throws Exception {
		String result = "";
		plist = productDAO.list();
		Gson gson = new Gson();
		result = gson.toJson(plist);
		return result;
	}

}
