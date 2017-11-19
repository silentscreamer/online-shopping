package com.saquib.backendofshop.daoImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.saquib.backendofshop.dao.CatagoryDao;
import com.saquib.backendofshop.dto.Catagory;

@Repository("catagoryDao")
public class CatagoryDaoImpl implements CatagoryDao {
	
	
	private static List<Catagory> catagoryList= new ArrayList<Catagory>();
	
	static{
		
		Catagory cat = new Catagory();
		cat.setId(1);
		cat.setName("Mobile");
		cat.setDescription("This is mobile!");
		cat.setImageUrl("CAT_1.png");
		
		catagoryList.add(cat);
		
		cat = new Catagory();
		cat.setId(2);
		cat.setName("Television");
		cat.setDescription("This is Television!");
		cat.setImageUrl("CAT_2.png");
		
		catagoryList.add(cat);
		
		cat = new Catagory();
		cat.setId(3);
		cat.setName("Laptop");
		cat.setDescription("This is Laptop!");
		cat.setImageUrl("CAT_3.png");
		
		catagoryList.add(cat);
	}

	@Override
	public List<Catagory> list() {
		return catagoryList;
	}

	@Override
	public Catagory get(int id) {
		for(Catagory cat:catagoryList){
			if(cat.getId()==id){
				return cat;
			}
		}
		return null;
	}

}
