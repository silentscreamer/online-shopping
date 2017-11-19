package com.saquib.onlineshopping.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.saquib.backendofshop.dao.CatagoryDao;
import com.saquib.backendofshop.dto.Catagory;

@Controller
public class PageController {
	
	@Autowired
	private CatagoryDao catagoryDao;

	@RequestMapping(value = { "/", "/home", "/index" })
	public ModelAndView index() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "Home");
		mv.addObject("catagories",catagoryDao.list());
		mv.addObject("userClickHome", true);
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
	public ModelAndView showallcatagoryprod(@PathVariable("id") int id) {
		
		Catagory catagory=null;
		catagory= catagoryDao.get(id);
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", catagory.getName());
		mv.addObject("catagories",catagoryDao.list());
		mv.addObject("catagory",catagory);
		mv.addObject("userClickCatagoryProducts", true);
		return mv;
	}
	
}
