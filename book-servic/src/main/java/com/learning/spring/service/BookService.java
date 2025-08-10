package com.learning.spring.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learning.spring.dto.Review;
import com.learning.spring.entity.Book;
import com.learning.spring.proxy.ReviewProxy;
import com.learning.spring.repo.BookRepository;

class BookNotFound{
	private String exceptionMessage;
	public BookNotFound(String Message) {
		this.exceptionMessage=Message;
	}
}
@Service
public class BookService {

	//@Autowired
	private BookRepository bookRepo;
	//@Autowired
	private ReviewProxy reviewProxy;
	
	
	
	public BookService(BookRepository bookRepo, ReviewProxy reviewProxy) {
		super();
		this.bookRepo = bookRepo;
		this.reviewProxy = reviewProxy;
	}

	public Book saveBook(Book book) {
		return bookRepo.save(book);
	}
	
	public List<Book> getBooks()
	{
		return bookRepo.findAll();
	}
	
	public Map<String, Object> getBookWithReviews(String bookId){
		Book book=bookRepo.findByBookId(bookId);
		Map<String, Object> response=new HashMap<>();
		if(book==null)
		{
			response.put("exception", new BookNotFound("book with book id: "+bookId+" not found"));
			return response;
		}
		List<Review> reviews=reviewProxy.getReviewsByBookId(bookId);
		response.put("reviews", reviews);
		response.put("book", book);
		return response;
	}
}
