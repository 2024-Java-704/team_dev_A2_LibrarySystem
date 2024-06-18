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
import com.example.demo.model.Account;
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

	@Autowired
	Account account;

	@GetMapping("/staff/materialMg/bookList")
	public String index(Model model) {
		List<Book> bookList = bookRepository.showBook(account.getLibraryId());
		model.addAttribute("bookList",bookList);
		return "/staff/bookList";
	}

	@GetMapping("/staff/materialMg/bookList/ranking")
	public String ranking(Model model) {
		List<Book> bookList = bookRepository.findByLibraryIdOrderByCntDesc(account.getLibraryId());
		model.addAttribute("bookList", bookList);
		return "/staff/bookList";
	}

	@GetMapping("/staff/materialMg/bookList/pubYear")
	public String pubYear(Model model) {
		List<Book> bookList = bookRepository.findByLibraryIdOrderByPubYear(account.getLibraryId());
		model.addAttribute("bookList", bookList);
		return "/staff/bookList";
	}

	@GetMapping("/staff/materialMg/bookList/jporder")
	public String jporder(Model model) {
		List<Book> bookList = bookRepository.findByLibraryIdOrderByHurigana(account.getLibraryId());

		model.addAttribute("bookList", bookList);
		return "/staff/bookList";
	}
	
	
	
	
	@PostMapping("/staff/materialMg/add")
	public String materialAdd(@RequestParam("category") Integer categoryId,
			@RequestParam("title") String title,
			@RequestParam("hurigana") String hurigana,
			@RequestParam("author") String author,
			@RequestParam("publisher") String publisher,
			@RequestParam("pubYear") LocalDate pubYear,
			@RequestParam("img") String img,
			Model model) {

		Category category = categoryRepository.findById(categoryId).get();
		Library library = libraryRepository.findById(account.getLibraryId()).get();
		Condition condition = conditionRepository.findById(1).get();
		Integer cnt = 0;

		Book book = new Book(category, title, hurigana, author, publisher, pubYear, library, condition, cnt,
				img);
		bookRepository.save(book);
		return "redirect:/staff/materialMg/bookList";
	}

	@GetMapping("/staff/materialMg/create")
	public String create(Model model) {
		Library library = libraryRepository.findById(account.getLibraryId()).get();
		List<Category> category = categoryRepository.findAll();
		model.addAttribute("library", library);
		model.addAttribute("category", category);
		return "/staff/bookAdd";
	}

	@GetMapping("/staff/materialMg/{id}/edit")
	public String edit(@PathVariable("id") Integer id, Model model) {
		Book book = bookRepository.findById(id).get();
		List<Category> category = categoryRepository.findAll();
		List<Condition> condition = conditionRepository.findAll();
		model.addAttribute("book", book);
		model.addAttribute("category", category);
		model.addAttribute("condition", condition);
		return "/staff/bookEdit";
	}

	@PostMapping("/staff/materialMg/{id}/edit")
	public String update(
			@PathVariable("id") Integer id,
			@RequestParam("category") Integer categoryId,
			@RequestParam("title") String title,
			@RequestParam("hurigana") String hurigana,
			@RequestParam("author") String author,
			@RequestParam("publisher") String publisher,
			@RequestParam("pubYear") LocalDate pubYear,
			@RequestParam("regDay") LocalDate regDay,
			@RequestParam("condition") Integer conditionId,
			@RequestParam("cnt") Integer cnt,
			@RequestParam(name = "img", defaultValue = "") String img,
			Model model) {

		Category category = categoryRepository.findById(categoryId).get();
		Library library = libraryRepository.findById(account.getLibraryId()).get();
		Condition condition = conditionRepository.findById(conditionId).get();

		Book book = new Book(id, category, title, hurigana, author, publisher, pubYear, regDay, library, condition,
				cnt, img);
		bookRepository.save(book);
		return "redirect:/staff/materialMg/bookList";

	}

	@PostMapping("/staff/materialMg/{id}/bookDelete")
	public String delete(
			@PathVariable("id") Integer id, Model model) {
		bookRepository.deleteById(id);
		return "redirect:/staff/materialMg/bookList";
	}

}
