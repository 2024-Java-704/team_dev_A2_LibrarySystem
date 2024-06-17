package com.example.demo.controller.children;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.Book;
import com.example.demo.repository.BookRepository;

@Controller
public class ChildrenController {

	@Autowired
	BookRepository bookRepository;

	@PostMapping("/user/childrenSearch")
	public String search(
			@RequestParam(name = "keyword", defaultValue = "") String keyword,
			Model model) {
		List<Book> bookList = new ArrayList<>();
		if (keyword.contains("\s")) { //複数条件
			String[] keywords = keyword.split("\s");

			for (String key : keywords) {

				bookList.addAll(bookRepository.findByHuriganaContaining(key));

			}
			List<Book> booklists = new ArrayList<>(new HashSet<>(bookList));
			model.addAttribute("books", booklists);
			return "/user/userSearch";
		}

		if (!(keyword.equals(""))) {//条件ひとつ
			bookList.addAll(bookRepository.findByHuriganaContaining(keyword));
		}
		model.addAttribute("books", bookList);
		return "/user/userSearch";
	}

}
