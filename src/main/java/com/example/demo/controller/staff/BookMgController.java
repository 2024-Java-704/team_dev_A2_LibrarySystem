package com.example.demo.controller.staff;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.Book;
import com.example.demo.entity.Category;
import com.example.demo.entity.Condition;
import com.example.demo.entity.Library;
import com.example.demo.repository.BookRepository;
import com.example.demo.repository.CategoryRepository;
import com.example.demo.repository.ConditionRepository;
import com.example.demo.repository.LibraryRepository;
import com.example.demo.repository.ReservationRepository;

@Controller
public class BookMgController {
	@Autowired
	BookRepository bookRepository;
	
	@Autowired
	CategoryRepository categoryRepository;
	
	@Autowired
	ReservationRepository reservationRepository;
	
	@Autowired
	LibraryRepository libraryRepository;
	
	@Autowired
	ConditionRepository conditionRepository;
	
	@GetMapping("/staff/materialMg/bookList")
	public String index(Model model) {
		List<Book> bookList=bookRepository.findAll();
		model.addAttribute("bookList",bookList);
		return "/staff/bookList";
	}
	
	@PostMapping("/staff/materialMg/add")
	public String materialAdd(@RequestParam("category")Integer categoryId,
			@RequestParam("title")String title,
			@RequestParam("hurigana")String hurigana,
			@RequestParam("author")String author,
			@RequestParam("publisher")String publisher,
			@RequestParam("pubYear")LocalDate pubYear,
			@RequestParam("library")Integer libraryId,
			@RequestParam("img")String img,
			Model model){
		
		Category category=categoryRepository.findById(categoryId).get();
		Library library=libraryRepository.findById(libraryId).get();
		Condition condition=conditionRepository.findById(1).get();
		
		Book book=new Book(category,title,hurigana,author,publisher,pubYear,library,condition,img);
		bookRepository.save(book);
		return "redirect:/staff/bookList";
	}
	
	@GetMapping("/staff/materialMg/create")
	public String create() {
		return "/staff/bookAdd";
	}
	
	@GetMapping("/staff/materialMg/{id}/edit")
	public String edit(@PathVariable("id")Integer id,Model model) {
		Book book=bookRepository.findById(id).get();
		model.addAttribute("book",book);
		return "/staff/bookEdit";
	}
	
	@PostMapping("/staff/materialMg/{id}/edit")
	public String update(
			@PathVariable("id")Integer id,
			@RequestParam("categoryId") Integer categoryId,
			@RequestParam("title")String title,
			@RequestParam("hurigana")String hurigana,
			@RequestParam("author")String author,
			@RequestParam("publisher")String publisher,
			@RequestParam("pubYear")LocalDate pubYear,
			@RequestParam("regDay") LocalDate regDay,
			@RequestParam("condition")Integer conditionId,
			@RequestParam("library")Integer libraryId,
			@RequestParam("img")String img,
			Model model) {
		
		Category category=categoryRepository.findById(categoryId).get();
		Library library=libraryRepository.findById(libraryId).get();
		Condition condition=conditionRepository.findById(1).get();
		
		Book book =new Book(id,category,title,hurigana,author,publisher,pubYear,regDay,condition,library,img);
		bookRepository.save(book);
		return "redirect:/staff/bookList";
		
	}
	
	@PostMapping("/staff/materialMg/{id}/delete")
	public String delete(
			@PathVariable("id") Integer id ,Model model) {
		bookRepository.deleteById(id);
		return "redirect:/admin/items";
	}
	
	
	
	
}
