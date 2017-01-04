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

import com.teja.backend.dao.CartDAO;
import com.teja.backend.dao.ProductDAO;
import com.teja.backend.dao.UserDetailsDAO;
import com.teja.backend.model.Cart;
import com.teja.backend.model.Category;
import com.teja.backend.model.Product;
import com.teja.backend.model.UserDetails;

@Controller
public class CartController {
	@Autowired
	CartDAO cartDAO;
	@Autowired
	Cart cart;
	@Autowired
	ProductDAO productDAO;
	@Autowired
	Product product;
	@Autowired
	UserDetailsDAO userDetailsDAO;
	@Autowired
	UserDetails user;

	@ModelAttribute
	public Cart returnObject() {
		return new Cart();
	}

	@RequestMapping("/productselect{id}")
	public ModelAndView oneproductPage(@PathVariable("id") String id) throws Exception {
		ModelAndView mv = new ModelAndView("1productview");
		mv.addObject("oneproduct", productDAO.getbyid(id));
		return mv;
	}

	
	
	
	@RequestMapping(value = "/buy{id}&{pid}", method = RequestMethod.POST)
	public ModelAndView buyproductPage(@Valid @PathVariable("id") String id, @PathVariable("pid") String pid,
			@RequestParam("quantity") String quantity, HttpSession session) throws Exception {
		
int z=0;
for(UserDetails camp:userDetailsDAO.checksignin(id))
{z=z+1;
	}		
		
		
		if(z==0){
			ModelAndView mv = new ModelAndView("test");
			return mv;
		}
else{
	ModelAndView mv = new ModelAndView("mycart");
	int k = Integer.parseInt(quantity);
	int y = 0;
	Cart kcart = new Cart();
	for (Cart temp : cartDAO.mycartproducts(id)) {
		if (temp.getProd_Id().equals(pid)) {
			y = 1;
			kcart = temp;
		}
	}
	if (y == 1) {
		kcart.setQuantity(kcart.getQuantity() + k);
		kcart.setPrice(kcart.getQuantity() * kcart.getCartproduct().getPrice());
		cartDAO.update(kcart);
		mv.addObject("cartmessage", kcart.getCartproduct().getName());
		mv.addObject("cartmessage1", " quantity is updated");
	} else {
		cart.setQuantity(k);
		cart.setUser_Id(id);
		cart.setProd_Id(pid);
		cart.setCartuser(userDetailsDAO.getbyid(id));
		product = productDAO.getbyid(pid);
		cart.setCartproduct(product);
		cart.setPrice(cart.getQuantity() * product.getPrice());
		cartDAO.save(cart);
	}

	mv.addObject("mycartList", cartDAO.mycartproducts(id));
	session.setAttribute("cartvalue", cartDAO.totalproducts(id));
	mv.addObject("cartprice", cartDAO.totalprice(id));
	mv.addObject("cartmessage", cart.getCartproduct().getName());
	mv.addObject("cartmessage1", " has been added to your cart");
	return mv;

}
		
			}

	@RequestMapping(value = "/viewmycart{id}")
	public ModelAndView viewmycart(@PathVariable("id") String id) {
		ModelAndView mv = new ModelAndView("mycart");
		mv.addObject("mycartList", cartDAO.mycartproducts(id));
		mv.addObject("cartprice", cartDAO.totalprice(id));
		return mv;
	}

	@RequestMapping(value = "/cartupdate{id}")
	public ModelAndView UpdatecatPage(@PathVariable("id") int id) {
		ModelAndView mv = new ModelAndView("mycart");
		cart = cartDAO.getbyid(id);
		mv.addObject("editcartid", cart.getId());
		mv.addObject("mycartList", cartDAO.mycartproducts(cart.getUser_Id()));
		mv.addObject("cartprice", cartDAO.totalprice(cart.getUser_Id()));
		return mv;
	}

	@RequestMapping(value = "/updatecartquan{id}", method = RequestMethod.POST)
	public ModelAndView Updatecart(@Valid @PathVariable("id") int id, @RequestParam("quantity") String quantity) {
		int k = Integer.parseInt(quantity);
		ModelAndView mv = new ModelAndView("mycart");
		cart = cartDAO.getbyid(id);
		cart.setQuantity(k);
		cart.setPrice(cart.getQuantity() * cart.getCartproduct().getPrice());
		cartDAO.update(cart);
		mv.addObject("cartprice", cartDAO.totalprice(cart.getUser_Id()));
		mv.addObject("mycartList", cartDAO.mycartproducts(cart.getUser_Id()));
		mv.addObject("cartmessage", cart.getCartproduct().getName());
		mv.addObject("cartmessage1", " quantity has been updated");
		return mv;
	}

	@RequestMapping(value = "/cartitemdelete{id}")
	public ModelAndView deleteCategory(@PathVariable("id") int id, HttpSession session) throws Exception {
		cart = cartDAO.getbyid(id);
		cartDAO.delete(cart);
		ModelAndView mv = new ModelAndView("mycart");
		mv.addObject("mycartList", cartDAO.mycartproducts(cart.getUser_Id()));
		session.setAttribute("cartvalue", cartDAO.totalproducts(cart.getUser_Id()));
		mv.addObject("cartprice", cartDAO.totalprice(cart.getUser_Id()));
		mv.addObject("cartmessage", cart.getCartproduct().getName());
		mv.addObject("cartmessage1", " has been deleted from your cart");
		return mv;
	}

}
