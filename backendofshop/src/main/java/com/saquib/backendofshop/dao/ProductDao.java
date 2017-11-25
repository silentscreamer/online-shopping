package com.saquib.backendofshop.dao;

import java.util.List;

import com.saquib.backendofshop.dto.Product;

public interface ProductDao {
	Product get(int id);

	List<Product> list();

	Boolean addProduct(Product p);

	Boolean updateProduct(Product p);

	Boolean deleteProduct(Product p);

	List<Product> listActiveprod();

	List<Product> listActiveprodbycatagory(int catagoryId);

	List<Product> getlatestactiveprod(int count);

}
