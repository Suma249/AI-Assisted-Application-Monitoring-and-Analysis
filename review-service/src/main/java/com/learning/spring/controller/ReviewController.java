package com.learning.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learning.spring.entity.Review;
import com.learning.spring.service.ReviewService;

@RestController
@RequestMapping("/reviews")
public class ReviewController {

	@Autowired
	private ReviewService service;
	
	@GetMapping("/book/{bookId}")
	public List<Review> getReviews(@PathVariable String bookId){
		return service.findBookById(bookId);
	}
	
	@PostMapping
	public Review saveReview(@RequestBody Review review) {
		return service.saveReview(review);
	}
}
