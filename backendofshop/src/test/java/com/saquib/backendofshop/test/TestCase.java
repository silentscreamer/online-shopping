package com.saquib.backendofshop.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.saquib.backendofshop.dao.CatagoryDao;
import com.saquib.backendofshop.dto.Catagory;

public class TestCase {

	private static AnnotationConfigApplicationContext context;

	private static Catagory catagory;

	private static CatagoryDao catagoryDao;

	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("com.saquib.backendofshop");
		context.refresh();
		catagoryDao = (CatagoryDao) context.getBean("catagoryDao");
	}

	// @Test
	// public void addCatagory(){
	//
	// catagory = new Catagory();
	// catagory.setName("Laptop");
	// catagory.setDescription("This is Laptop!");
	// catagory.setImageUrl("CAT_1.png");
	// assertEquals("Success", true,catagoryDao.addCatagory(catagory));
	//
	// }

	// @Test
	// public void onecatagory(){
	// catagory= catagoryDao.get(3);
	// assertEquals("Success", "television",catagory.getName());
	// }
	//
	// @Test
	// public void delCatagory(){
	//
	// catagory = catagoryDao.get(2);
	//
	// assertEquals("Success", true,catagoryDao.deleteCatagory(catagory));
	//
	// }
	//
	// @Test
	// public void updateCatagory(){
	//
	// catagory = catagoryDao.get(2);
	// catagory.setActive(true);
	//
	// assertEquals("Success", true,catagoryDao.updateCatagory(catagory));
	//
	// }

	// @Test
	// public void ListCatagory(){
	// assertEquals("Success", 3,catagoryDao.list().size());
	//
	// }
//	@Test
//	public void CRUDtest() {
//
//		/*
//		 * Add
//		 * 
//		 */
//		catagory = new Catagory();
//		catagory.setName("Laptop");
//		catagory.setDescription("This is Laptop!");
//		catagory.setImageUrl("CAT_1.png");
//		assertEquals("Success", true, catagoryDao.addCatagory(catagory));
//
//		catagory = new Catagory();
//		catagory.setName("Mobile");
//		catagory.setDescription("This is Mobile!");
//		catagory.setImageUrl("CAT_2.png");
//		assertEquals("Success", true, catagoryDao.addCatagory(catagory));
//
//		/*
//		 * Update
//		 * 
//		 */
//		catagory = catagoryDao.get(2);
//		catagory.setActive(true);
//		assertEquals("Success", true, catagoryDao.updateCatagory(catagory));
//
//		/*
//		 * Delete
//		 * 
//		 */
//		catagory = catagoryDao.get(2);
//		assertEquals("Success", true, catagoryDao.deleteCatagory(catagory));
//
//		/*
//		 * List
//		 */
//		assertEquals("Success", 1, catagoryDao.list().size());

	//}
}
