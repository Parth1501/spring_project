package com.rakuten.training.dal;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.rakuten.training.domain.Product;

@Repository
@Transactional
public class ProductDAOJPAImpl implements ProductDAO {
	
	EntityManager manager;
	
	@Autowired
	public void setManager(EntityManager manager) {
		this.manager = manager;
	}

	@Override
	public Product save(Product toBeSaved) {
		manager.persist(toBeSaved);
		return toBeSaved;
	}

	@Override
	public List<Product> findAll() {
		Query q=manager.createQuery("select p from Product as p");
		return q.getResultList();
	}

	@Override
	public Product findById(int id) {
		
		return manager.find(Product.class, id);
	}

	@Override
	public void deleteById(int id) {
		Product p=manager.find(Product.class,id);
		manager.remove(p);
		
		
		
	}
	
	
   @Override
	public List<Product> findByName(String name) {
		Query q = manager.createQuery("select p from Product p where p.name=:n");
		q.setParameter("n", name);
		return q.getResultList();
	}
	
	@Override
	public List<Product> findByNameLike(String name) {
		Query q = manager.createQuery("select p from Product p where p.name like :n");
		q.setParameter("n", "%"+name+"%");
		return q.getResultList();
	}
	
	@Override
	public List<Product> findByPriceLessThan(float price) {
		Query q = manager.createQuery("select p from Product p where p.price<:n");
		q.setParameter("n", price);
		return q.getResultList();
	}
	
	
}
