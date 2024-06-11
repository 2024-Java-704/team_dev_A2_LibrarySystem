package com.example.demo.controller.user;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.Book;
import com.example.demo.entity.Category;
import com.example.demo.repository.BookRepository;
import com.example.demo.repository.CategoryRepository;

@Controller
public class ControllerOfUser {

	@Autowired
	BookRepository bookRepository;

	@Autowired
	CategoryRepository categoryRepository;

	@GetMapping("/user/userTop")
	public String index() {
		return "/user/userTop";
	}

	@PostMapping("/user/userSearch")
	public String search(
			@RequestParam(name = "title", defaultValue = "") String title,
			@RequestParam(name = "category", defaultValue = "") Integer categoryId,
			@RequestParam(name = "author", defaultValue = "") String author,
			@RequestParam(name = "publisher", defaultValue = "") String publisher,
			@RequestParam(name = "publishDay", defaultValue = "") LocalDate publishDay,
			Model model) {

		List<Book> bookList = new ArrayList<>();
		bookList.addAll(bookRepository.findByTitleContaining(title));
		Category category = categoryRepository.findById(categoryId).get();
		bookList.addAll(bookRepository.findByCategory(category));
		bookList.addAll(bookRepository.findByPublisherContaining(publisher));
		bookList.addAll(bookRepository.findByAuthorContaining(author));
		bookList.addAll(bookRepository.findByPubYear(publishDay));
		model.addAttribute("books", bookList);
		return "/user/userSearch";
	}
}
