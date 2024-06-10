package com.example.demo.controller.staff;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.example.demo.model.Account;
import com.example.demo.repository.BookRepository;
import com.example.demo.repository.LibraryStaffRepository;

@Controller
public class BookDetailController {

	@Autowired
	BookRepository bookRepository;

	@Autowired
	LibraryStaffRepository libraryStaffRepository;

	@Autowired
	Account account;

	//	@GetMapping("/staff/bookdetail")
	//	public String indexBookDetail(
	//			@PathVariable("id") Integer id,
	//			Model model) {
	//
	//		Book book = bookRepository.findById(id).get();
	//		libraryStaffRepository.getById();
	//		String reserve = null;
	//		if (book.getLibrary().getId() == account.getId()) {
	//			reserve = "予約";
	//		} else {
	//			reserve = "発注";
	//		}
	//		model.addAttribute("reserve", reserve);
	//		model.addAttribute("bookDetail", book);
	//		return "/staff/bookDetail";
	//	}

}
