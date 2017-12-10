package com.saquib.onlineshopping.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.saquib.backendofshop.dao.CatagoryDao;
import com.saquib.backendofshop.dao.ProductDao;
import com.saquib.backendofshop.dto.Catagory;
import com.saquib.backendofshop.dto.Product;
import com.saquib.onlineshopping.Utils.FileUploadUtility;

@Controller
@RequestMapping("/manage")
public class ManagementController {

	@Autowired
	private CatagoryDao cd;

	@Autowired
	private ProductDao pd;
	private static final Logger logger = LoggerFactory.getLogger(ManagementController.class);

	@RequestMapping(value = "/products", method = RequestMethod.GET)
	public ModelAndView showManageProd(@RequestParam(name = "operation", required = false) String operation) {

		ModelAndView mv = new ModelAndView("page");
		mv.addObject("userClicksManageProd", true);
		mv.addObject("title", "Manage Product");

		Product newProd = new Product();
		newProd.setSupplierId(1);
		newProd.setActive(true);

		mv.addObject("product", newProd);

		if (operation != null) {

			if (operation.equals("product")) {

				mv.addObject("message", "Product Added Successfully!");

			}
		}

		return mv;
	}

	@RequestMapping(value = "/products", method = RequestMethod.POST)
	public String productSubmit(@Valid @ModelAttribute("product") Product newProd, BindingResult results,
			Model model ,HttpServletRequest request) {

		if(results.hasErrors()){
			logger.error(results.toString());
			model.addAttribute("userClicksManageProd", true);
			model.addAttribute("title", "Manage Product");
			return "page";
		}
		
		pd.addProduct(newProd);
		
		if(!newProd.getFile().getOriginalFilename().equals("")){
			FileUploadUtility.uploadFile(request,newProd.getFile(),newProd.getName());
			
		}

		logger.info(newProd.toString());

		return "redirect:/manage/products?operation=product";

	}

	@ModelAttribute("catagories")
	public List<Catagory> getCatagory() {

		return cd.list();

	}

}
