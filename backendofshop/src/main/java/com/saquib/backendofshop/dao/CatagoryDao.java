package com.saquib.backendofshop.dao;

import java.util.List;

import com.saquib.backendofshop.dto.Catagory;

public interface CatagoryDao {

	Catagory get(int id);

	List<Catagory> list();

	Boolean addCatagory(Catagory c);
	
	Boolean updateCatagory(Catagory c);
	
	Boolean deleteCatagory(Catagory c);
	
}
