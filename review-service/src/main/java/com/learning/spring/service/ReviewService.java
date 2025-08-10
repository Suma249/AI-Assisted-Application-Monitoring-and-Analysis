package com.learning.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learning.spring.entity.Review;
import com.learning.spring.repo.ReviewRepository;

@Service
public class ReviewService {
    
	@Autowired
	private ReviewRepository repository;
	
	public List<Review> findBookById(String bookId){
		return repository.findByBookId(bookId);
	}
	
	public Review saveReview(Review review) {
		return repository.save(review);
	}
}
