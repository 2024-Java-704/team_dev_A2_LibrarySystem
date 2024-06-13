package com.example.demo.controller.user;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.Book;
import com.example.demo.service.BookService;

@Controller
public class SearchBookController {

	@Autowired
	BookService bookService;

	@PostMapping("/user/userDetailSearch") //検索処理・検索結果表示
	public String search(
			@RequestParam(name = "title", defaultValue = "") String title,
			@RequestParam(name = "category", defaultValue = "") Integer categoryId,
			@RequestParam(name = "author", defaultValue = "") String author,
			@RequestParam(name = "publisher", defaultValue = "") String publisher,
			@RequestParam(name = "publishDay", defaultValue = "") LocalDate publishDay,
			Model model) {

		List<Book> bookList = bookService.searchBooks(title, categoryId, author, publisher, publishDay);
		model.addAttribute("bookList", bookList);
		return "/user/userSearch";
	}

}
