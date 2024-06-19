package com.example.demo.controller.children;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.Book;
import com.example.demo.model.Account;
import com.example.demo.repository.BookRepository;

@Controller
public class ChildrenController {

	@Autowired
	BookRepository bookRepository;
	
	@Autowired
	Account account;

	@PostMapping("/user/childrenSearch")
	public String search(
			@RequestParam(name = "keyword", defaultValue = "") String keyword,
			Model model) {
		List<Book> bookList = new ArrayList<>();
		if (keyword.contains("\s")) { //複数条件
			String[] keywords = keyword.split("\s");

			for (String key : keywords) {

				bookList.addAll(bookRepository.findByLibraryIdAndHuriganaContaining(account.getLibraryId(),key));

			}
			Set <Integer> titleIds=new HashSet<Integer>();
			for(Book book:bookList) {
				titleIds.add(book.getTitleId());
			}
			List<Book> booklists=new ArrayList<>();
			for(Integer titleId:titleIds) {
				booklists.add(bookRepository.findByTitleId(titleId).get(0));
			}
			model.addAttribute("books", booklists);
			return "/user/userSearch";
		}

		if (!(keyword.equals(""))) {//条件ひとつ
			bookList.addAll(bookRepository.findByLibraryIdAndHuriganaContaining(account.getLibraryId(),keyword));
		}
		Set <Integer> titleIds=new HashSet<Integer>();
		for(Book book:bookList) {
			titleIds.add(book.getTitleId());
		}
		List<Book> booklists=new ArrayList<>();
		for(Integer titleId:titleIds) {
			booklists.add(bookRepository.findByTitleId(titleId).get(0));
		}
		model.addAttribute("books", booklists);
		return "/user/userSearch";
	}

}
