package com.example.demo.controller.staff;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.Book;
import com.example.demo.entity.Condition;
import com.example.demo.entity.Lending;
import com.example.demo.entity.LibraryStaff;
import com.example.demo.entity.Reservation;
import com.example.demo.entity.Status;
import com.example.demo.entity.User;
import com.example.demo.model.Account;
import com.example.demo.repository.BookRepository;
import com.example.demo.repository.ConditionRepository;
import com.example.demo.repository.LendingRepository;
import com.example.demo.repository.LibraryRepository;
import com.example.demo.repository.LibraryStaffRepository;
import com.example.demo.repository.ReservationRepository;
import com.example.demo.repository.StatusRepository;
import com.example.demo.repository.UserRepository;

@Controller
public class RentalController {

	@Autowired
	LendingRepository lendingRepository;

	@Autowired
	ReservationRepository reservationRepository;

	@Autowired
	BookRepository bookRepository;

	@Autowired
	LibraryStaffRepository libraryStaffRepository;

	@Autowired
	UserRepository userRepository;

	@Autowired
	StatusRepository statusRepository;

	@Autowired
	LibraryRepository libraryRepository;

	@Autowired
	ConditionRepository conditionRepository;

	@Autowired
	Account account;

	@GetMapping("/staff/materialMg/rentalList") //貸出一覧表示
	public String index(
			Model model) {

		List<Book> books = bookRepository.findByLibraryId(account.getLibraryId());
		List<Integer> bookIdList = new ArrayList<>();
		for (Book book : books) {
			bookIdList.add(book.getId());
		}
		List<Lending> lendingList = new ArrayList<>();
		for (Integer bookId : bookIdList) {
			lendingList.addAll(lendingRepository.findByBookIdAndReturnedDateIsNull(bookId));
		}
		if (lendingList.size() == 0) {
			model.addAttribute("error", "貸し出している本がありません");
		} else {
			model.addAttribute("lendings", lendingList);
		}
		return "/staff/rentalList";
	}

	@GetMapping("/staff/materialMg/rentalAdd") //新規貸出画面へ
	public String create(Model model) {
		LocalDate rentalDate = LocalDate.now();
		LocalDate limitDate = rentalDate.plusWeeks(1);
		model.addAttribute("rentalDate", rentalDate);
		model.addAttribute("limitDate", limitDate);
		model.addAttribute("staffId", account.getId());
		return "/staff/rentalAdd";
	}

	@GetMapping("/staff/materialMg/{bookId}/rentalAdd") //資料詳細から貸出処理
	public String detailCreate(
			@PathVariable("bookId") Integer id, Model model) {
		LocalDate rentalDate = LocalDate.now();
		LocalDate limitDate = rentalDate.plusWeeks(1);
		model.addAttribute("rentalDate", rentalDate);
		model.addAttribute("limitDate", limitDate);
		model.addAttribute("staffId", account.getId());
		model.addAttribute("bookId", id);
		return "/staff/rentalAdd";
	}

	@GetMapping("/staff/materialMg/{id}/rentalAddRes") //予約・注文から貸出処理
	public String resCreate(
			@PathVariable("id") Integer id, Model model) {
		LocalDate rentalDate = LocalDate.now();
		LocalDate limitDate = rentalDate.plusWeeks(1);
		model.addAttribute("rentalDate", rentalDate);
		model.addAttribute("limitDate", limitDate);
		Reservation reservation = reservationRepository.findById(id).get();
		model.addAttribute("bookId", reservation.getBook().getId());
		model.addAttribute("staffId", account.getId());
		model.addAttribute("userId", reservation.getUser().getId());
		model.addAttribute("reservationId", id);
		return "/staff/rentalAdd";
	}

	@PostMapping("/staff/materialMg/rentalAdd") //貸出（lending）テーブルに追加
	public String add(
			@RequestParam(value = "bookId", defaultValue = "") Integer bookId,
			@RequestParam(value = "rentalDate", defaultValue = "") LocalDate rentalDate,
			@RequestParam(value = "limitDate", defaultValue = "") LocalDate limitDate,
			@RequestParam(value = "reservationId", defaultValue = "") Integer reservationId,
			@RequestParam(value = "staffId", defaultValue = "") Integer staffId,
			@RequestParam(value = "userId", defaultValue = "") Integer userId,
			@RequestParam(value = "password", defaultValue = "") String password,
			@RequestParam(value = "error", defaultValue = "") String error,
			Model model) {

		try {
			bookRepository.findById(bookId).orElseThrow();
		} catch (NoSuchElementException e) {
			model.addAttribute("bookId", bookId);
			model.addAttribute("reservationId", reservationId);
			model.addAttribute("staffId", staffId);
			model.addAttribute("limitDate", limitDate);
			model.addAttribute("rentalDate", rentalDate);
			model.addAttribute("userId", userId);
			model.addAttribute("error", "資料が見つかりませんでした");
			return "/staff/rentalAdd";
		}

		try {
			libraryStaffRepository.findById(staffId).orElseThrow();
		} catch (NoSuchElementException e) {
			model.addAttribute("bookId", bookId);
			model.addAttribute("reservationId", reservationId);
			model.addAttribute("staffId", staffId);
			model.addAttribute("limitDate", limitDate);
			model.addAttribute("rentalDate", rentalDate);
			model.addAttribute("userId", userId);
			model.addAttribute("error", "スタッフが見つかりませんでした");
			return "/staff/rentalAdd";
		}

		try {
			userRepository.findById(userId).orElseThrow();
		} catch (NoSuchElementException e) {
			model.addAttribute("bookId", bookId);
			model.addAttribute("reservationId", reservationId);
			model.addAttribute("staffId", staffId);
			model.addAttribute("limitDate", limitDate);
			model.addAttribute("rentalDate", rentalDate);
			model.addAttribute("userId", userId);
			model.addAttribute("error", "ユーザーが見つかりませんでした");
			return "/staff/rentalAdd";
		}

		try {
			if (reservationId == null) {
				User user = userRepository.findByIdAndPassword(userId, password).get(0);
				Book book = bookRepository.findById(bookId).orElseThrow();
				Condition condition = conditionRepository.findById(2).get();
				book.setCondition(condition);
				bookRepository.save(book);
				LibraryStaff staff = libraryStaffRepository.findById(staffId).orElseThrow();
				Lending lending = new Lending(user, book, rentalDate, limitDate, staff);
				lendingRepository.save(lending);
				return "redirect:/staff/materialMg/rentalList";
			} else {
				reservationRepository.findById(reservationId).orElseThrow();
			}

		} catch (NoSuchElementException e) {
			model.addAttribute("bookId", bookId);
			model.addAttribute("reservationId", reservationId);
			model.addAttribute("staffId", staffId);
			model.addAttribute("limitDate", limitDate);
			model.addAttribute("rentalDate", rentalDate);
			model.addAttribute("userId", userId);
			model.addAttribute("error", "予約IDが見つかりませんでした");
			return "/staff/rentalAdd";

		} catch (IndexOutOfBoundsException e) {
			model.addAttribute("bookId", bookId);
			model.addAttribute("reservationId", reservationId);
			model.addAttribute("staffId", staffId);
			model.addAttribute("limitDate", limitDate);
			model.addAttribute("rentalDate", rentalDate);
			model.addAttribute("userId", userId);
			model.addAttribute("error", "パスワードが違います");
			return "/staff/rentalAdd";
		}

		try {
			User user = userRepository.findByIdAndPassword(userId, password).get(0);
			Book book = bookRepository.findById(bookId).orElseThrow();
			Condition condition = conditionRepository.findById(2).get();
			book.setCondition(condition);
			bookRepository.save(book);
			LibraryStaff staff = libraryStaffRepository.findById(staffId).orElseThrow();
			Reservation reservation = reservationRepository.findById(reservationId).orElseThrow();
			Lending lending = new Lending(user, book, rentalDate, limitDate, reservation, staff);
			lendingRepository.save(lending);
			Status status = statusRepository.findById(3).get();
			reservation.setStatus(status);
			reservationRepository.save(reservation);
			return "redirect:/staff/materialMg/rentalList";

		} catch (IndexOutOfBoundsException e) {
			model.addAttribute("bookId", bookId);
			model.addAttribute("reservationId", reservationId);
			model.addAttribute("staffId", staffId);
			model.addAttribute("limitDate", limitDate);
			model.addAttribute("rentalDate", rentalDate);
			model.addAttribute("userId", userId);
			model.addAttribute("error", "パスワードが違います");
			return "/staff/rentalAdd";
		}

	}

	@GetMapping("/staff/materialMg/{id}/rentalEdit") //貸出情報の編集画面表示
	public String edit(
			@PathVariable("id") Integer id,
			Model model) {
		Lending lending = lendingRepository.findById(id).get();
		try {
			if (lending.getReservation().getId() != null) {
				model.addAttribute("lending", lending);
				return "/staff/rentalEdit";
			}
		} catch (NullPointerException e) {
			model.addAttribute("reservationId", "");
			model.addAttribute("lending", lending);
		}
		return "/staff/rentalEdit";
	}

	@PostMapping("/staff/materialMg/{id}/rentalEdit") //編集処理
	public String update(
			@PathVariable("id") Integer id,
			@RequestParam(value = "bookId", defaultValue = "") Integer bookId,
			@RequestParam(value = "lendDate", defaultValue = "") LocalDate lendDate,
			@RequestParam(value = "limitDate", defaultValue = "") LocalDate limitDate,
			@RequestParam(value = "returnedDate", defaultValue = "") LocalDate returnedDate,
			@RequestParam(value = "reservationId", defaultValue = "") Integer reservationId,
			@RequestParam(value = "staffId", defaultValue = "") Integer staffId,
			@RequestParam(value = "userId", defaultValue = "") Integer userId,
			Model model) {
		try {
			bookRepository.findById(bookId).orElseThrow();
		} catch (NoSuchElementException e) {
			model.addAttribute("bookId", bookId);
			model.addAttribute("reservationId", reservationId);
			model.addAttribute("rentalDate", lendDate);
			model.addAttribute("staffId", staffId);
			model.addAttribute("limitDate", limitDate);
			model.addAttribute("returnedDate", returnedDate);
			model.addAttribute("userId", userId);
			model.addAttribute("error", "資料が見つかりませんでした");
			return "/staff/rentalEdit";
		}

		try {
			libraryStaffRepository.findById(staffId).orElseThrow();
		} catch (NoSuchElementException e) {
			model.addAttribute("bookId", bookId);
			model.addAttribute("reservationId", reservationId);
			model.addAttribute("rentalDate", lendDate);
			model.addAttribute("staffId", staffId);
			model.addAttribute("limitDate", limitDate);
			model.addAttribute("returnedDate", returnedDate);
			model.addAttribute("userId", userId);
			model.addAttribute("error", "スタッフが見つかりませんでした");
			return "/staff/rentalEdit";
		}

		try {
			userRepository.findById(userId).orElseThrow();
		} catch (NoSuchElementException e) {
			model.addAttribute("bookId", bookId);
			model.addAttribute("reservationId", reservationId);
			model.addAttribute("rentalDate", lendDate);
			model.addAttribute("staffId", staffId);
			model.addAttribute("limitDate", limitDate);
			model.addAttribute("returnedDate", returnedDate);
			model.addAttribute("userId", userId);
			model.addAttribute("error", "ユーザーが見つかりませんでした");
			return "/staff/rentalEdit";
		}

		try {
			if (reservationId == null) {
				User user = userRepository.findById(userId).get();
				Book book = bookRepository.findById(bookId).orElseThrow();
				LibraryStaff staff = libraryStaffRepository.findById(staffId).orElseThrow();
				Lending lending = new Lending(id, user, book, lendDate, limitDate, returnedDate, staff);
				lendingRepository.save(lending);
				return "redirect:/staff/materialMg/rentalList";
			} else {
				User user = userRepository.findById(userId).orElseThrow();
				Book book = bookRepository.findById(bookId).orElseThrow();
				LibraryStaff staff = libraryStaffRepository.findById(staffId).orElseThrow();
				Reservation reservation = reservationRepository.findById(reservationId).orElseThrow();
				Lending lending = new Lending(id, user, book, lendDate, limitDate, returnedDate, reservation, staff);
				lendingRepository.save(lending);
				return "redirect:/staff/materialMg/rentalList";
			}

		} catch (NoSuchElementException e) {
			model.addAttribute("bookId", bookId);
			model.addAttribute("reservationId", reservationId);
			model.addAttribute("rentalDate", lendDate);
			model.addAttribute("staffId", staffId);
			model.addAttribute("limitDate", limitDate);
			model.addAttribute("returnedDate", returnedDate);
			model.addAttribute("userId", userId);
			model.addAttribute("error", "予約IDが見つかりませんでした");
			return "/staff/rentalEdit";

		}
	}

	@PostMapping("/staff/materialMg/{id}/rentalDelete") //貸出情報の削除
	public String delete(
			@PathVariable("id") Integer id,
			Model model) {

		lendingRepository.deleteById(id);

		return "redirect:/staff/materialMg/rentalList";
	}

}
