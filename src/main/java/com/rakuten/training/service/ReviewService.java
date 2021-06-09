package com.rakuten.training.service;

import java.util.List;

import com.rakuten.training.domain.Review;

public interface ReviewService {

	int addReviewToProduct(Review toBeSaved, int productId);

	Review findById(int id);

	void deleteById(int id);
	

}