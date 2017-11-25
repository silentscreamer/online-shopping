package com.saquib.backendofshop.daoImpl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.saquib.backendofshop.dao.CatagoryDao;
import com.saquib.backendofshop.dto.Catagory;

@Repository("catagoryDao")
@Transactional(readOnly = true)
public class CatagoryDaoImpl implements CatagoryDao {

	@Autowired
	SessionFactory sf;
	private static List<Catagory> catagoryList = new ArrayList<Catagory>();

	@Override
	public List<Catagory> list() {
		Query q = sf.getCurrentSession().createQuery("FROM Catagory where isActive = :active",Catagory.class);
		q.setParameter("active", true);
		List<Catagory> l = q.getResultList();
		return l;
	}

	@Override
	public Catagory get(int id) {
		return sf.getCurrentSession().get(Catagory.class, Integer.valueOf(id));
	}

	@Override

	public Boolean addCatagory(Catagory c) {
		try {
			sf.getCurrentSession().persist(c);
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	@Override
	public Boolean updateCatagory(Catagory c) {
		try {
			sf.getCurrentSession().update(c);
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	@Override
	public Boolean deleteCatagory(Catagory c) {
		c.setActive(false);

		try {
			sf.getCurrentSession().update(c);
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}
}
