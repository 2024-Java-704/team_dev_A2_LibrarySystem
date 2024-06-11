package com.example.demo.controller.staff;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.Book;
import com.example.demo.entity.Lending;
import com.example.demo.entity.Library;
import com.example.demo.entity.LibraryStaff;
import com.example.demo.entity.Reservation;
import com.example.demo.entity.Status;
import com.example.demo.entity.User;
import com.example.demo.model.Account;
import com.example.demo.repository.BookRepository;
import com.example.demo.repository.LendingRepository;
import com.example.demo.repository.LibraryStaffRepository;
import com.example.demo.repository.StatusRepository;
import com.example.demo.repository.UserRepository;

@Controller
public class BookDetailController {

	@Autowired
	BookRepository bookRepository;

	@Autowired
	LibraryStaffRepository libraryStaffRepository;

	@Autowired
	UserRepository userRepository;

	@Autowired
	StatusRepository statusRepository;

	@Autowired
	LendingRepository lendingRepository;

	@Autowired
	Account account;

	@GetMapping("/staff/{id}/bookdetail") //詳細表示
	public String indexBookDetail(
			@PathVariable("id") Integer id,
			Model model) {

		Book book = bookRepository.findById(id).get();
		//		Integer libraryId = libraryStaffRepository.findById(account.getId()).get();
		//		String reserve = null;
		//		if (book.getLibrary().getId() == account.getId()) {
		//			reserve = "予約";
		//		} else {
		//			reserve = "発注";
		//		}
		//		model.addAttribute("reserve", reserve);
		model.addAttribute("bookDetail", book);
		return "/staff/bookDetail";
	}

	@GetMapping("/staff/staffMg/{bookId}/order")
	public String bookOrder(
			@PathVariable("bookId") Integer id,
			Model model) {
		Book book = bookRepository.findById(id).get();
		model.addAttribute("bookOrder", book);
		return "/staff/bookOrder";
	}

	@PostMapping("/staff/staffMg/{bookId}/order")
	public String bookReserve(
			@PathVariable("bookId") Integer id,
			@RequestParam(name = "userId", defaultValue = "") Integer userId,
			@RequestParam(name = "userPassword", defaultValue = "") String userPassword,
			Model model) {
		List<String> errorList = new ArrayList<>();
		User user = userRepository.findByIdAndPassword(userId, userPassword).get(0);
		if (userId == null) {
			errorList.add("利用者IDを入力してください");
		}
		if (userPassword == "") {
			errorList.add("パスワードを入力してください");
		}
		if (user == null) {
			errorList.add("該当する利用者が見つかりませんでした");
		}
		Book book = bookRepository.findById(id).get();
		LocalDate today = LocalDate.now();
		LibraryStaff librarystaff = libraryStaffRepository.findById(account.getId()).get();
		Library library = librarystaff.getLibrary();
		Status status = statusRepository.findById(1).get();
		Integer conditionId = book.getCondition().getId();
		LocalDate scheduled = null;
		Lending lending = lendingRepository.findFirstByBookIdOrderByIdDesc(book.getId());

		//外の図書館にある＆貸出可能
		if (librarystaff.getLibrary().getId() != book.getLibrary().getId() && (conditionId == 1)) {
			scheduled = today.plusDays(2);
		}
		//自分の図書館にある＆貸出中
		if ((librarystaff.getLibrary().getId() == book.getLibrary().getId())
				&& (conditionId != 1)) {
			scheduled = lending.getLimitDate().plusDays(1);
		}
		//外の図書館にある＆貸出中
		if ((librarystaff.getLibrary().getId() != book.getLibrary().getId()) && (conditionId != 1)) {
			scheduled = lending.getLimitDate().plusDays(2);
		}
		//エラーチェック
		if (conditionId == 1 && (librarystaff.getLibrary().getId() == book.getLibrary().getId())) {
			errorList.add("この資料は本図書館で貸出可能です");
		}
		if (errorList.size() > 0) {
			model.addAttribute("error", errorList);
			model.addAttribute("bookOrder", book);
			return "/staff/bookOrder";
		} else {
			Reservation reservation = new Reservation(user, book, today, scheduled, library, status);
			model.addAttribute("reservation", reservation);
			return "/staff/bookOrderEnd";
		}

	}

}
