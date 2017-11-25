package com.saquib.backendofshop.daoImpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.saquib.backendofshop.dao.ProductDao;
import com.saquib.backendofshop.dto.Catagory;
import com.saquib.backendofshop.dto.Product;

@Repository("productDao")
@Transactional
public class ProductDaoImpl implements ProductDao {

	@Autowired
	SessionFactory sf;

	@Override
	public Product get(int id) {

		return sf.getCurrentSession().get(Product.class, Integer.valueOf(id));

	}

	@Override
	public List<Product> list() {
		Query q = sf.getCurrentSession().createQuery("FROM Product", Product.class);

		List<Product> l = q.getResultList();
		return l;
	}

	@Override
	public Boolean addProduct(Product p) {
		try {
			sf.getCurrentSession().persist(p);
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	@Override
	public Boolean updateProduct(Product p) {
		try {
			sf.getCurrentSession().update(p);
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	@Override
	public Boolean deleteProduct(Product p) {
		p.setActive(false);

		try {
			sf.getCurrentSession().update(p);
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	@Override
	public List<Product> listActiveprod() {
		Query<Product> q = sf.getCurrentSession().createQuery("FROM Product where is_Active = :active",Product.class);
		q.setParameter("active", true);
		List<Product> l = q.getResultList();
		return l;
	}

	@Override
	public List<Product> listActiveprodbycatagory(int catagoryId) {
		Query<Product> q = sf.getCurrentSession().createQuery("FROM Product where is_Active = :active AND catagoryId = :catagoryId",Product.class);
		q.setParameter("active", true);
		q.setParameter("catagoryId", catagoryId);
		List<Product> l = q.getResultList();
		return l;
	}

	@Override
	public List<Product> getlatestactiveprod(int count) {
		Query<Product> q = sf.getCurrentSession().createQuery("FROM Product where is_Active = :active ORDER BY id",Product.class);
		q.setParameter("active", true);
		q.setFirstResult(0);
		q.setMaxResults(count);
		List<Product> l = q.getResultList();
		return l;
	}

}
