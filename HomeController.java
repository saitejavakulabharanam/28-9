package com.teja.controller;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.teja.backend.dao.BillingAddressDAO;
import com.teja.backend.dao.CartDAO;
import com.teja.backend.dao.CategoryDAO;
import com.teja.backend.dao.ProductDAO;
import com.teja.backend.dao.UserDetailsDAO;
import com.teja.backend.model.BillingAddress;
import com.teja.backend.model.Cart;
import com.teja.backend.model.Category;
import com.teja.backend.model.Product;
import com.teja.backend.model.UserDetails;

@Controller
public class HomeController {
	@Autowired
	CategoryDAO categoryDAO;
	@Autowired
	Category category;
	@Autowired
	UserDetailsDAO userdetailsDAO;
	@Autowired
	UserDetails userdetails;
	@Autowired
	CartDAO cartDAO;
	@Autowired
	Cart cart;
	@Autowired
	Product product;
	@Autowired
	ProductDAO productDAO;
	@Autowired
	BillingAddressDAO billingAddressDAO;
	@Autowired
	BillingAddress billingAddress;
	
	
	@ModelAttribute
	public UserDetails returnObject() {
		return new UserDetails();
	}
	
	
	
	
	
	@RequestMapping(value="/")
	public ModelAndView LandingPage(HttpSession label) {
		ModelAndView mv = new ModelAndView("Home");
		label.setAttribute("eleccat",categoryDAO.getbylabel("electronics") );
		label.setAttribute("applcat",categoryDAO.getbylabel("appliances") );
		label.setAttribute("mencat",categoryDAO.getbylabel("men") );
		label.setAttribute("womencat",categoryDAO.getbylabel("women") );
		label.setAttribute("kidcat",categoryDAO.getbylabel("kids") );
		label.setAttribute("homecat",categoryDAO.getbylabel("home") );
		label.setAttribute("bookcat",categoryDAO.getbylabel("books") );		
		return mv;
	}
	
	@RequestMapping(value="/Home")
	public ModelAndView HomePage() {
		ModelAndView mv = new ModelAndView("Home");
		return mv;
	}
	
	@RequestMapping(value="/uncons")
	public ModelAndView constPage() {
		ModelAndView mv = new ModelAndView("underconstruction");
		return mv;
	}
	@RequestMapping("/navselect{id}")
	public ModelAndView siteviewPage(@PathVariable("id")String id){
		ModelAndView mv = new ModelAndView("siteview");
		//System.out.println(productDAO.getbrands(id));
		mv.addObject("nextpagecatid", id);
		mv.addObject("siteproducts", productDAO.getbycat(id));
		return mv;
	}
	
	@RequestMapping(value="/billingselect{id}")
	public ModelAndView paymentPage(@PathVariable("id")String id) {
		ModelAndView mv = new ModelAndView("cardpage");
		return mv;
	}
	
	@RequestMapping(value="/cashondel{id}")
	public ModelAndView cashondelPage(@PathVariable("id")String id) {
		ModelAndView mv = new ModelAndView("endpage");
		for(Cart temp:cartDAO.mycartproducts(id))
		{
			product=productDAO.getbyid(temp.getProd_Id());
			product.setQuantity(product.getQuantity()-temp.getQuantity());
			productDAO.update(product);
		}
		mv.addObject("byemessage", "Please Keep your cash with you at the time of Delivery");
		return mv;
	}
	
	@RequestMapping(value="/creditdel{id}")
	public ModelAndView creditdelPage(@PathVariable("id")String id) {
		ModelAndView mv = new ModelAndView("endpage");
		for(Cart temp:cartDAO.mycartproducts(id))
		{
			product=productDAO.getbyid(temp.getProd_Id());
			product.setQuantity(product.getQuantity()-temp.getQuantity());
			productDAO.update(product);
		}
		mv.addObject("byemessage", "You have paid the Amount Your Product will be delivered Shortly");
		return mv;
	}
	
	
	
	
	@RequestMapping("/gomobile")
	public ModelAndView gomobPage(){
		ModelAndView mv = new ModelAndView("siteview");
		category=categoryDAO.getbyname("Phones");
		mv.addObject("siteproducts", productDAO.getbycat(category.getId()));
		return mv;
	}
	@RequestMapping("/gosport")
	public ModelAndView goPage1(){
		ModelAndView mv = new ModelAndView("siteview");
		category=categoryDAO.getbyname("Sports");
		mv.addObject("siteproducts", productDAO.getbycat(category.getId()));
		return mv;
	}
	@RequestMapping("/gotab")
	public ModelAndView goPage2(){
		ModelAndView mv = new ModelAndView("siteview");
		category=categoryDAO.getbyname("Tablets");
		mv.addObject("siteproducts", productDAO.getbycat(category.getId()));
		return mv;
	}
	@RequestMapping("/gotowel")
	public ModelAndView goPage3(){
		ModelAndView mv = new ModelAndView("siteview");
		category=categoryDAO.getbyname("Towels");
		mv.addObject("siteproducts", productDAO.getbycat(category.getId()));
		return mv;
	}
	@RequestMapping("/gobulb")
	public ModelAndView goPage4(){
		ModelAndView mv = new ModelAndView("siteview");
		category=categoryDAO.getbyname("Bulbs");
		mv.addObject("siteproducts", productDAO.getbycat(category.getId()));
		return mv;
	}
	@RequestMapping("/gotv")
	public ModelAndView goPage5(){
		ModelAndView mv = new ModelAndView("siteview");
		category=categoryDAO.getbyname("TV");
		mv.addObject("siteproducts", productDAO.getbycat(category.getId()));
		return mv;
	}
	@RequestMapping("/gowash")
	public ModelAndView goPage6(){
		ModelAndView mv = new ModelAndView("siteview");
		category=categoryDAO.getbyname("Washing Machines");
		mv.addObject("siteproducts", productDAO.getbycat(category.getId()));
		return mv;
	}
	@RequestMapping("/golap")
	public ModelAndView goPage7(){
		ModelAndView mv = new ModelAndView("siteview");
		category=categoryDAO.getbyname("Laptops");
		mv.addObject("siteproducts", productDAO.getbycat(category.getId()));
		return mv;
	}
	@RequestMapping("/gohead")
	public ModelAndView goPage8(){
		ModelAndView mv = new ModelAndView("siteview");
		category=categoryDAO.getbyname("Head Phones");
		mv.addObject("siteproducts", productDAO.getbycat(category.getId()));
		return mv;
	}
	@RequestMapping("/gofan")
	public ModelAndView goPage9(){
		ModelAndView mv = new ModelAndView("siteview");
		category=categoryDAO.getbyname("Fans");
		mv.addObject("siteproducts", productDAO.getbycat(category.getId()));
		return mv;
	}
	@RequestMapping("/gobook")
	public ModelAndView goPage10(){
		ModelAndView mv = new ModelAndView("siteview");
		category=categoryDAO.getbyname("Books");
		mv.addObject("siteproducts", productDAO.getbycat(category.getId()));
		return mv;
	}
	
	
	@RequestMapping("/rolex")
	public ModelAndView rolexPage(){
		ModelAndView mv = new ModelAndView("siteview");
		mv.addObject("siteproducts", productDAO.getbybrand("Rolex"));
		return mv;
	}
	
	@RequestMapping("/puma")
	public ModelAndView pumaPage(){
		ModelAndView mv = new ModelAndView("siteview");
		mv.addObject("siteproducts", productDAO.getbybrand("Puma"));
		return mv;
	}
	
	@RequestMapping("/lee")
	public ModelAndView leePage(){
		ModelAndView mv = new ModelAndView("siteview");
		mv.addObject("siteproducts", productDAO.getbybrand("Lee Cooper"));
		return mv;
	}
	
	@RequestMapping("/apple")
	public ModelAndView applePage(){
		ModelAndView mv = new ModelAndView("siteview");
		mv.addObject("siteproducts", productDAO.getbybrand("Apple"));
		return mv;
	}
	
	
	
	@RequestMapping(value="/login_session_attributes")
	public String login_session_attributes(HttpSession session,@RequestParam(value="username")String id){
		Object name=SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		System.out.println("inside security check");
		
		userdetails=userdetailsDAO.getbyid(id);
		session.setAttribute("username", userdetails.getId());
		  
    	
		session.setAttribute("LoggedIn", "true");
		session.setAttribute("eleccat",categoryDAO.getbylabel("electronics") );
		session.setAttribute("applcat",categoryDAO.getbylabel("appliances") );
		session.setAttribute("mencat",categoryDAO.getbylabel("men") );
		session.setAttribute("womencat",categoryDAO.getbylabel("women") );
		session.setAttribute("kidcat",categoryDAO.getbylabel("kids") );
		session.setAttribute("homecat",categoryDAO.getbylabel("home") );
		session.setAttribute("bookcat",categoryDAO.getbylabel("books") );		
		session.setAttribute("cartvalue", cartDAO.totalproducts(userdetails.getId()));
		@SuppressWarnings("unchecked")
		Collection<GrantedAuthority> authorities =(Collection<GrantedAuthority>) SecurityContextHolder.getContext().getAuthentication().getAuthorities();
		
		String role="ROLE_USER";
		for(GrantedAuthority authority : authorities)
		{
			if(authority.getAuthority().equals(role))
			{
				System.out.println(role);
				return "Home";
			}
			else
			{
				session.setAttribute("isAdmin", 1);
			}
			}
		return "manageall" ;
		
	}
	
	
}