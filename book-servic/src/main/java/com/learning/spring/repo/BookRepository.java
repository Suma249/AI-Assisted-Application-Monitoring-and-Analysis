package com.learning.spring.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.learning.spring.entity.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer>{
public Book findByBookId(String bookId);
}
