package com.example.demo.controller.staff;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.entity.Book;
import com.example.demo.entity.Category;
import com.example.demo.entity.Condition;
import com.example.demo.entity.Lending;
import com.example.demo.entity.Library;
import com.example.demo.entity.LibraryStaff;
import com.example.demo.entity.Reservation;
import com.example.demo.entity.User;
import com.example.demo.model.Account;
import com.example.demo.repository.BookRepository;
import com.example.demo.repository.ConditionRepository;
import com.example.demo.repository.LendingRepository;
import com.example.demo.repository.LibraryStaffRepository;

@Controller
public class ReturnController {

	@Autowired
	LendingRepository lendingRepository;

	@Autowired
	LibraryStaffRepository libraryStaffRepository;

	@Autowired
	ConditionRepository conditionRepository;

	@Autowired
	BookRepository bookRepository;

	@Autowired
	Account account;

	@GetMapping("/staff/materialMg/{id}/return")
	public String index(@PathVariable("id") Integer id,
			@ModelAttribute("error") String error,
			Model model) {
		System.out.println("aaaaaaaaaaa");
		Lending lending = lendingRepository.findById(id).get();
		model.addAttribute("error", error);
		model.addAttribute("lending", lending);
		return "/staff/return";
	}

	@PostMapping("/staff/materialMg/{id}/return")
	public String Return(
			@PathVariable("id") Integer id,
			@RequestParam(name = "staffId", defaultValue = "") Integer staffId,
			RedirectAttributes redirectAttributes,
			Model model) {
		LibraryStaff libraryStaff = libraryStaffRepository.findById(account.getId()).get();
		Integer loginStaffId = libraryStaff.getId();
		Lending lending = lendingRepository.findById(id).get();
		if (loginStaffId != staffId) {
			String error = "あなたの職員IDと入力されたIDが一致しません";
			redirectAttributes.addFlashAttribute("error", error);
			return "redirect:/staff/materialMg/{id}/return";
		} else {
			//該当lendingにreturnDateを追加
			User user = lending.getUser();
			Book book = lending.getBook();
			LocalDate lendDate = lending.getLendDate();
			LocalDate limitDate = lending.getLimitDate();
			LocalDate returnDate = LocalDate.now();
			Reservation reservation = lending.getReservation();
			Lending lendingFin = new Lending(id, user, book, lendDate, limitDate, returnDate, reservation,
					libraryStaff);
			lendingRepository.save(lendingFin);

			//該当bookのconditionを貸出不可→貸出可
			Integer bookId = book.getId();
			Category category = book.getCategory();
			String bookTitle = book.getTitle();
			String bookHurigana = book.getHurigana();
			String bookAuthor = book.getAuthor();
			String bookPublisher = book.getPublisher();
			LocalDate bookPubYear = book.getPubYear();
			LocalDate bookRegDay = book.getRegDay();
			Library bookLibrary = book.getLibrary();
			Integer conditionId = 1;
			Condition bookCondition = conditionRepository.findById(conditionId).get();
			Integer bookCnt = book.getCnt();
			String bookImg = book.getImg();
			Book bookEdit = new Book(bookId, category, bookTitle, bookHurigana, bookAuthor, bookPublisher, bookPubYear,
					bookRegDay, bookCondition, bookLibrary, bookCnt, bookImg);
			bookRepository.save(bookEdit);

			return "redirect:/staff/materialMg/rentalList";
		}
	}

}
