package com.learning.spring.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learning.spring.entity.Book;
import com.learning.spring.service.BookService;

@RestController
@RequestMapping("/books")
public class BookController {

	@Autowired
	private BookService bookService;
	
	@PostMapping()
	public Book addBook(@RequestBody Book book) {
		return bookService.saveBook(book);
	}
	
	@GetMapping()
	public List<Book> getBooks(){
		return bookService.getBooks();
	}
	
	@GetMapping("/{bookId}")
	public Map<String, Object> getBookReviews(@PathVariable String bookId){
		return bookService.getBookWithReviews(bookId);
	}
}
