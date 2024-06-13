package com.example.demo.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Book;
import com.example.demo.repository.BookRepository;

@Service
public class BookService {

	@Autowired
	private BookRepository bookRepository;

	public List<Book> searchBooks(String title,
			Integer categoryId,
			String author,
			String publisher,
			LocalDate pubYear) {
		return bookRepository.searchBooks(title, categoryId, author, publisher, pubYear);
	}
}