package com.saquib.backendofshop.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.saquib.backendofshop.dto.Catagory;

public interface CatagoryDao {

	List<Catagory> list();
	Catagory get(int id);
}
