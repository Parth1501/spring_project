package com.rakuten.training.dal;

import java.util.List;

import com.rakuten.training.domain.Review;



public interface ReviewDAO {
	public Review save(Review toBeSaved);
	public Review findById(int id);
	public void deleteById(int id);
	public List<Review> findByPid(int productId);
	public List<Review> findByRatingGreaterThan(int rating);

}
