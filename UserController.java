package com.teja.controller;

import java.io.IOException;

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

import com.teja.backend.dao.CategoryDAO;
import com.teja.backend.dao.UserDetailsDAO;
import com.teja.backend.model.Category;
import com.teja.backend.model.UserDetails;

@Controller
public class UserController {

	@Autowired
	UserDetailsDAO userDetailsDAO;
	@Autowired
	UserDetails userdetails;

	@ModelAttribute
	public UserDetails returnObject() {
		return new UserDetails();
	}

	/*
	 * @RequestMapping(value = "/Register", method = RequestMethod.POST) public
	 * ModelAndView register(@Valid @ModelAttribute("userDetails") UserDetails
	 * user, BindingResult result, HttpServletRequest request) throws
	 * IOException { ModelAndView mv = new ModelAndView("Home"); if
	 * (user.getPsw2().equals(user.getPassword())) { user.setRole("ROLE_USER");
	 * user.setEnabled("TRUE"); userDetailsDAO.save(user); } return mv; }
	 */
	@RequestMapping("/Updateuser{id}")
	public ModelAndView Updateuser(@PathVariable("id") String id) throws Exception {
		ModelAndView mv = new ModelAndView("manageall");
		userdetails = userDetailsDAO.getbyid(id);
		mv.addObject("user", userdetails);
		mv.addObject("add", 3);
		mv.addObject("edit", 1);
		mv.addObject("listusers", 0);
		mv.addObject("userdetailsList", userDetailsDAO.list());
		return mv;
	}

	@RequestMapping(value = "/Updateuserdetails", method = RequestMethod.POST)
	public ModelAndView Updateuserdetails(@Valid @ModelAttribute("userdetails") UserDetails user,@RequestParam("address")String address) throws Exception {
		System.out.println("updating user");
		/*
		 * String id=request.getParameter("id"); System.out.println(id);
		 */
		ModelAndView mv = new ModelAndView("manageall");
		user.setAddress(address);
		userDetailsDAO.update(user);
		mv.addObject("listusers", 0);
		mv.addObject("userdetailsList", userDetailsDAO.list());
		return mv;
	}

	@RequestMapping(value = "/Deleteuser{id}")
	public ModelAndView Deleteuser(@Valid @PathVariable("id") String id) throws Exception {
		System.out.println("deleting user");
		/*
		 * String id=request.getParameter("id"); System.out.println(id);
		 */
		userdetails = userDetailsDAO.getbyid(id);
		ModelAndView mv = new ModelAndView("manageall");
		userDetailsDAO.cartremoval(id);
		userDetailsDAO.delete(userdetails);
		mv.addObject("listusers", 0);
		mv.addObject("userdetailsList", userDetailsDAO.list());
		return mv;
	}
	

}
