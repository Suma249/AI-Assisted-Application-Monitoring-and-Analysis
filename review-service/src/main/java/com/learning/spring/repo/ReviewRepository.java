package com.learning.spring.repo;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.learning.spring.entity.Review;

public interface ReviewRepository extends MongoRepository<Review, String> {
	List<Review> findByBookId(String bookId);
}
