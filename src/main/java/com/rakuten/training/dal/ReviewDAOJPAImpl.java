package com.rakuten.training.dal;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.rakuten.training.domain.Review;

@Repository
@Transactional
public class ReviewDAOJPAImpl implements ReviewDAO{
	
	
	 @Autowired
	 EntityManager manager;
	 

	@Override
	public Review save(Review toBeSaved) {
		manager.persist(toBeSaved);
		return toBeSaved;
	}


	@Override
	public Review findById(int id) {
		// TODO Auto-generated method stub
		return manager.find(Review.class,id);
	}

	@Override
	public void deleteById(int id) {
		// TODO Auto-generated method stub
		Review r=manager.find(Review.class,id);
		if(r!=null) {
			manager.remove(r);
		}
		
	}


	@Override
	public List<Review> findByPid(int productId) {
		Query q = manager.createQuery("select r from Review r where r.product.id=:x");
		q.setParameter("x", productId);
		return q.getResultList();
	}

	@Override
	public List<Review> findByRatingGreaterThan(int rating) {
		Query q = manager.createQuery("select r from Review r where r.rating>=:x");
		q.setParameter("x", rating);
		return q.getResultList();
	}
	
	
}
