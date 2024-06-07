package com.example.demo.controller.staff;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.repository.BookRepository;

@Controller
public class BookMgController {
	@Autowired
	BookRepository bookRepository;
	
	@GetMapping("/staff/materialMg/bookList")
	public String index() {
		return "/staff/bookList";
	}
	
	
}
