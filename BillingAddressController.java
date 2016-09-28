package com.teja.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
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

import com.teja.backend.dao.BillingAddressDAO;
import com.teja.backend.model.BillingAddress;
import com.teja.backend.model.Cart;
import com.teja.backend.model.Category;

@Controller
public class BillingAddressController {

	@Autowired
	BillingAddressDAO billingAddressDAO;
	@Autowired
	BillingAddress billingAddress;

	@ModelAttribute
	public BillingAddress returnObject() {
		return new BillingAddress();
	}

	@RequestMapping(value = "/placeorder{id}")
	public ModelAndView billingPage(@PathVariable("id") String id) {
		ModelAndView mv = new ModelAndView("billingaddress");
		List<BillingAddress> myaddresses = new ArrayList<BillingAddress>();
		myaddresses = billingAddressDAO.myaddresses(id);
		int k = 0;
		for (BillingAddress temp : myaddresses) {
			k = k + 1;
		}
		if (k == 0) {
			mv.addObject("add", 4);
		}
		mv.addObject("billingaddresses", myaddresses);
		return mv;
	}

	@RequestMapping(value = "/addressreg", method = RequestMethod.POST)
	public ModelAndView Categoryregister(@Valid @ModelAttribute("billingAddress") BillingAddress add,
			BindingResult result, HttpServletRequest request) throws IOException {
		ModelAndView mv = new ModelAndView("billingaddress");
		billingAddressDAO.save(add);
		mv.addObject("billingaddresses", billingAddressDAO.myaddresses(add.getUser_Id()));
		return mv;
	}
	
	@RequestMapping(value = "/editaddress{id}")
	public ModelAndView UpdateaddressPage(@PathVariable("id") int id) throws Exception {
		ModelAndView mv = new ModelAndView("billingaddress");
		billingAddress = billingAddressDAO.getbyid(id);
		mv.addObject("address", billingAddress);
		mv.addObject("add", 4);
		mv.addObject("edit", 1);
		mv.addObject("billingaddresses", billingAddressDAO.myaddresses(billingAddress.getUser_Id()));
		return mv;
	}

	@RequestMapping(value = "/addressupdate", method = RequestMethod.POST)
	public ModelAndView Updatecategory(@Valid @ModelAttribute("billingAddress") BillingAddress add,BindingResult result,
			HttpServletRequest request) throws IOException {
		ModelAndView mv = new ModelAndView("billingaddress");
		billingAddressDAO.update(add);
		mv.addObject("billingaddresses", billingAddressDAO.myaddresses(add.getUser_Id()));
		mv.addObject("billingmessage", "The address is successfully updated");
		return mv;
	}

	@RequestMapping(value = "/removeaddress{id}")
	public ModelAndView deleteCategory(@PathVariable("id") int id){
		billingAddress=billingAddressDAO.getbyid(id);
		billingAddressDAO.delete(billingAddress);
		ModelAndView mv = new ModelAndView("billingaddress");
		List<BillingAddress> myaddresses = new ArrayList<BillingAddress>();
		myaddresses = billingAddressDAO.myaddresses(billingAddress.getUser_Id());
		int k = 0;
		for (BillingAddress temp : myaddresses) {
			k = k + 1;
		}
		if (k == 0) {
			mv.addObject("add", 4);
		}
		mv.addObject("billingaddresses", myaddresses);
		mv.addObject("billingmessage", "The address is successfully deleted");
		return mv;
	}
	
}