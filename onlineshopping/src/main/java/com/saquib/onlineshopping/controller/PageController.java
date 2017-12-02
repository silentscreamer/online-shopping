package com.saquib.onlineshopping.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.saquib.backendofshop.dao.CatagoryDao;
import com.saquib.backendofshop.dao.ProductDao;
import com.saquib.backendofshop.dto.Catagory;
import com.saquib.backendofshop.dto.Product;
import com.saquib.onlineshopping.exception.ProductNotFoundException;

@Controller
public class PageController {
	
	private static final Logger log = LoggerFactory.getLogger(PageController.class);
	
	@Autowired
	private CatagoryDao catagoryDao;
   
	@Autowired
	private ProductDao productDao;
	@RequestMapping(value = { "/", "/home", "/index" })
	public ModelAndView index() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "Home");
		mv.addObject("catagories",catagoryDao.list());
		mv.addObject("userClickHome", true);
		log.info("Indide page controller index method-INFO");
		log.debug("Indide page controller index method-Debug");
		return mv;
	}

	@RequestMapping(value = "/about")
	public ModelAndView about() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "About Us");
		mv.addObject("userClickAbout", true);
		return mv;
	}

	@RequestMapping(value = "/contact")
	public ModelAndView contact() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "Contact Us");
		mv.addObject("userClickContact", true);
		return mv;
	}

	@RequestMapping(value = "/show/all/products")
	public ModelAndView showallproducts() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "All Products");
		mv.addObject("catagories",catagoryDao.list());
		mv.addObject("userClickAllProducts", true);
		return mv;
	}
	@RequestMapping(value = "/show/catagory/{id}/products")
	public ModelAndView showallcatagoryprod(@PathVariable("id") int id) throws ProductNotFoundException {
		
		Catagory catagory=null;
		catagory= catagoryDao.get(id);
		if(catagory==null){
			throw new ProductNotFoundException();
		}
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", catagory.getName());
		mv.addObject("catagories",catagoryDao.list());
		mv.addObject("catagory",catagory);
		mv.addObject("userClickCatagoryProducts", true);
		return mv;
	}
	
	@RequestMapping(value="/show/{id}/product")
	public ModelAndView showsingleprod(@PathVariable("id") int id) throws ProductNotFoundException
	{
		ModelAndView mv = new ModelAndView("page");
		Product prod = productDao.get(id);
		if(prod== null){
			throw new ProductNotFoundException();
		}
		
		prod.setViews(prod.getViews()+1);
		productDao.updateProduct(prod);
		
		mv.addObject("title", prod.getName());
		mv.addObject("product", prod);
		mv.addObject("userclickoneprod", true);
		return mv;
	}
	@RequestMapping(value="/cart/add/{id}/product")
	public ModelAndView addtocart(@PathVariable("id") int id){
		ModelAndView mv = new ModelAndView("page");
		Product prod = productDao.get(id);
		mv.addObject("title", prod.getName());
		mv.addObject("userclickedaddtocrt", true);
		return mv;
	}
	
	
}
