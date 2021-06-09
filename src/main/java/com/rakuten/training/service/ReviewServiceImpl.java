package com.rakuten.training.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rakuten.training.dal.ProductDAO;
import com.rakuten.training.dal.ReviewDAO;
import com.rakuten.training.domain.Product;
import com.rakuten.training.domain.Review;

@Service
@Transactional
public class ReviewServiceImpl implements ReviewService {

	@Autowired
	ReviewDAO reviewDao;

	@Autowired
	ProductDAO productDao;

	@Override
	public int addReviewToProduct(Review toBeSaved, int productId) {
		Product p = productDao.findById(productId);
		toBeSaved.setProduct(p);
		reviewDao.save(toBeSaved);
		return toBeSaved.getId();
	}

	@Override
	public Review findById(int id) {
		return reviewDao.findById(id);
	}

	@Override
	public void deleteById(int id) {
		reviewDao.deleteById(id);
	}

	


}
