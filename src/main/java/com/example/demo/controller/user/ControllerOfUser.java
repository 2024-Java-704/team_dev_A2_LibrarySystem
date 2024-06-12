package com.example.demo.controller.user;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.Book;
import com.example.demo.entity.Category;
import com.example.demo.entity.Lending;
import com.example.demo.entity.Library;
import com.example.demo.entity.Reservation;
import com.example.demo.entity.Status;
import com.example.demo.entity.User;
import com.example.demo.repository.BookRepository;
import com.example.demo.repository.CategoryRepository;
import com.example.demo.repository.LendingRepository;
import com.example.demo.repository.LibraryRepository;
import com.example.demo.repository.ReservationRepository;
import com.example.demo.repository.StatusRepository;
import com.example.demo.repository.UserRepository;

@Controller
public class ControllerOfUser {

	@Autowired
	BookRepository bookRepository;

	@Autowired
	CategoryRepository categoryRepository;

	@Autowired
	UserRepository userRepository;

	@Autowired
	StatusRepository statusRepository;

	@Autowired
	LendingRepository lendingRepository;

	@Autowired
	LibraryRepository libraryRepository;

	@Autowired
	ReservationRepository reservationRepository;

	@GetMapping("/user/userTop") //ユーザートップ（検索画面）
	public String index() {
		return "/user/userTop";
	}

	@GetMapping("/user/childrenSearch") //子供用
	public String indexChildren() {
		return "/user/childrenSearch";
	}

	@PostMapping("/user/userSearch") //検索処理・検索結果表示
	public String search(
			@RequestParam(name = "title", defaultValue = "") String title,
			@RequestParam(name = "category", defaultValue = "") String categoryId,
			@RequestParam(name = "author", defaultValue = "") String author,
			@RequestParam(name = "publisher", defaultValue = "") String publisher,
			@RequestParam(name = "publishDay", defaultValue = "") LocalDate publishDay,
			Model model) {

		List<Book> bookList = new ArrayList<>();
		if (!(title.equals(""))) {
			bookList.addAll(bookRepository.findByTitleContaining(title));
		}
		if (categoryId != null) {
			Category category = categoryRepository.findByCategoryNum(categoryId);
			List<Book> findByCategory = bookRepository.findByCategory(category);
			bookList.addAll(findByCategory);
		}
		if (!(publisher.equals(""))) {
			bookList.addAll(bookRepository.findByPublisherContaining(publisher));
		}
		if (!(author.equals(""))) {
			bookList.addAll(bookRepository.findByAuthorContaining(author));
		}
		if (!(Objects.isNull(publishDay))) {
			bookList.addAll(bookRepository.findByPubYear(publishDay));
		}
		model.addAttribute("books", bookList);
		return "/user/userSearch";
	}

	@GetMapping("/user/{id}/bookDetail") //詳細表示
	public String userBookDetail(
			@PathVariable("id") Integer id,
			Model model) {
		Book book = bookRepository.findById(id).get();
		model.addAttribute("bookDetail", book);
		return "/user/userDetail";
	}

	@GetMapping("/user/{bookId}/order") //注文画面表示
	public String userBookOrder(
			@PathVariable("bookId") Integer id,
			Model model) {
		Book book = bookRepository.findById(id).get();
		model.addAttribute("bookOrder", book);
		return "/user/order";
	}

	@PostMapping("/user/{bookId}/order") //注文処理
	public String userBookReserve(
			@PathVariable("bookId") Integer id,
			@RequestParam(name = "userId", defaultValue = "") Integer userId,
			@RequestParam(name = "userPassword", defaultValue = "") String userPassword,
			Model model) {
		List<String> errorList = new ArrayList<>();

		if (userId == null) {
			errorList.add("利用者IDを入力してください");
		}
		if (userPassword == "") {
			errorList.add("パスワードを入力してください");
		}
		List<User> userList = userRepository.findByIdAndPassword(userId, userPassword);
		if (userList.size() == 0) {
			errorList.add("利用者IDとパスワードが一致しませんでした");
		}
		if (errorList.size() > 0) {
			Book book = bookRepository.findById(id).get();
			model.addAttribute("error", errorList);
			model.addAttribute("bookOrder", book);
			return "/user/order";
		} else {
			User user = userList.get(0);
			Book book = bookRepository.findById(id).get();
			LocalDate today = LocalDate.now();
			Library library = book.getLibrary();
			Status status = statusRepository.findById(1).get();
			Integer conditionId = book.getCondition().getId();
			LocalDate scheduled = null;
			Lending lending = lendingRepository.findFirstByBookIdOrderByIdDesc(book.getId());

			//貸出可能
			if (conditionId == 1) {
				scheduled = today.plusDays(2);
			}
			//貸出不可
			if (conditionId != 1) {
				scheduled = lending.getLimitDate().plusDays(1);
			}

			//エラーチェック

			Reservation reservation = new Reservation(user, book, today, scheduled, library, status);
			reservationRepository.save(reservation);
			Reservation reserved = reservationRepository.findByUserIdAndBookIdOrderByIdDesc(userId, id).get(0);
			model.addAttribute("reservation", reserved);
			return "/user/orderEnd";
		}

	}
}
