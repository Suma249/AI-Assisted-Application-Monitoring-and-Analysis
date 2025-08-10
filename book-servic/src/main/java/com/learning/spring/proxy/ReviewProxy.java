package com.learning.spring.proxy;



import java.util.List;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.learning.spring.dto.Review;

@FeignClient(name="review-service", url="http://localhost:8083")// without eurekaa
//@FeignClient(name="review-service")// with eurekaa
public interface ReviewProxy {

	@GetMapping("/reviews/book/{bookId}")
	List<Review> getReviewsByBookId(@PathVariable String bookId);
}
