package com.rakuten.training.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.rakuten.training.domain.Review;
import com.rakuten.training.service.Message;
import com.rakuten.training.service.ReviewService;

@RestController
@CrossOrigin
public class ReviewController {
	
	@Autowired
	ReviewService service;
	
	
	@GetMapping("/reviews")
	public List<Review> getAllReviews() {
		return service.findAll();
	}
	
	
	
	@PostMapping("/products/{pid}/reviews")
	public ResponseEntity<Review> addNewReviewEntity(@RequestBody Review toBeAdded,@PathVariable int pid) {
		service.addReviewToProduct(toBeAdded, pid);
		return new ResponseEntity(toBeAdded,HttpStatus.CREATED);
	}
	
	@GetMapping("/reviews/{id}")
	public  ResponseEntity<Object> findById(@PathVariable("id") int id) {
		Review r=service.findById(id);
		if(r!=null)
			return new ResponseEntity<>(r,HttpStatus.OK);
		return new ResponseEntity<>(new Message(400, "Review not found"),HttpStatus.BAD_REQUEST);
	}
	
	@DeleteMapping("/reviews/{id}")
	public ResponseEntity deleteById(@PathVariable("id") int id) {
		try {
			service.deleteById(id);
			return new ResponseEntity(new Message(200,"Deleted Successfully"),HttpStatus.OK);
		}
		catch(IllegalStateException e) {
			return new ResponseEntity(new Message(400,e.getMessage()),HttpStatus.BAD_REQUEST);
		}
	}
	
	
	
	
	
}
