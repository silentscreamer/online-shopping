package com.saquib.onlineshopping.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.saquib.backendofshop.dao.ProductDao;
import com.saquib.backendofshop.dto.Product;

@RestController
@RequestMapping("/jason/data")
public class JasonDataController {
@Autowired
ProductDao pdao;
	
	@RequestMapping("/all/products")
	
	public List<Product> getallProd()
	{
		return pdao.listActiveprod();
	}
	
	@RequestMapping("/catagory/{id}/products")
	
	public List<Product> listActiveprodbycatagory(@PathVariable int id)
	{
		return pdao.listActiveprodbycatagory(id);
	}
	
	@RequestMapping("/products/{count}")
	
	public List<Product> getlatestactiveprod(@PathVariable int count)
	{
		return pdao.getlatestactiveprod(count);
	}
}
