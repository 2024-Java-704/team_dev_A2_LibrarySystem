package com.example.demo.controller.staff;

import java.time.LocalDate;
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
import com.example.demo.entity.Lending;
import com.example.demo.entity.LibraryStaff;
import com.example.demo.entity.Reservation;
import com.example.demo.entity.User;
import com.example.demo.repository.BookRepository;
import com.example.demo.repository.LendingRepository;
import com.example.demo.repository.LibraryStaffRepository;
import com.example.demo.repository.ReservationRepository;
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

	@GetMapping("/staff/materialMg/rentalList")
	public String index(
			Model model) {

		List<Lending> lendingList = lendingRepository.findAll();

		if (lendingList.size() == 0) {
			model.addAttribute("error", "貸し出している本がありません");
		} else {
			model.addAttribute("lendings", lendingList);
		}
		return "/staff/rentalList";
	}

	@GetMapping("/staff/materialMg/rentalAdd")
	public String create(Model model) {
		LocalDate rentalDate = LocalDate.now();
		LocalDate limitDate = rentalDate.plusWeeks(1);
		model.addAttribute("rentalDate", rentalDate);
		model.addAttribute("limitDate", limitDate);
		return "/staff/rentalAdd";
	}

	@PostMapping("/staff/materialMg/rentalAdd")
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

		Book book = bookRepository.findById(bookId).orElseThrow();

		try {
			User user = userRepository.findById(userId).orElseThrow();
			LibraryStaff staff = libraryStaffRepository.findById(staffId).orElseThrow();

			if (!(user.getPassword().equals(password))) {
				model.addAttribute("bookId", bookId);
				model.addAttribute("reservationId", reservationId);
				model.addAttribute("staffId", staffId);
				model.addAttribute("limitDate", limitDate);
				model.addAttribute("rentalDate", rentalDate);
				model.addAttribute("userId", userId);
				model.addAttribute("error", "パスワードが違います");
				return "/staff/rentalAdd";
			} else {
				if (reservationId == null) {
					Lending lending = new Lending(user, book, rentalDate, limitDate, staff);
					lendingRepository.save(lending);
				} else {
					Reservation reservation = reservationRepository.findById(reservationId).orElseThrow();
					Lending lending = new Lending(user, book, rentalDate, limitDate, reservation, staff);
					lendingRepository.save(lending);
				}
				return "redirect:/staff/materialMg/rentalList";
			}

		} catch (NoSuchElementException e) {
			model.addAttribute("bookId", bookId);
			model.addAttribute("reservationId", reservationId);
			model.addAttribute("staffId", staffId);
			model.addAttribute("limitDate", limitDate);
			model.addAttribute("rentalDate", rentalDate);
			model.addAttribute("error", "ユーザーが見つかりませんでした");
			return "/staff/rentalAdd";
		}
	}

	@GetMapping("/staff/materialMg/{id}/rentalEdit")
	public String edit(
			@PathVariable("id") Integer id,
			Model model) {
		Lending lending = lendingRepository.findById(id).get();
		model.addAttribute("lending", lending);
		return "/staff/rentalEdit";
	}

	@PostMapping("/staff/materialMg/{id}/rentalEdit")
	public String update(
			@PathVariable("id") Integer id,
			@RequestParam(value = "bookId", defaultValue = "") Integer bookId,
			@RequestParam(value = "lendDate", defaultValue = "") LocalDate lendDate,
			@RequestParam(value = "limitDate", defaultValue = "") LocalDate limitDate,
			@RequestParam(value = "returnedDate", defaultValue = "") LocalDate returnedDate,
			@RequestParam(value = "reservationId", defaultValue = "") Integer reservationId,
			@RequestParam(value = "staffId", defaultValue = "") Integer staffId,
			@RequestParam(value = "rentalId", defaultValue = "") Integer rentalId,
			@RequestParam(value = "userId", defaultValue = "") Integer userId,
			Model model) {

		Book book = bookRepository.findById(bookId).orElseThrow();

		try {
			User user = userRepository.findById(userId).orElseThrow();
			LibraryStaff staff = libraryStaffRepository.findById(staffId).orElseThrow();

			if (reservationId == null) {
				Lending lending = new Lending(id, user, book, lendDate, limitDate, returnedDate, staff);
				lendingRepository.save(lending);
			} else {
				Reservation reservation = reservationRepository.findById(reservationId).orElseThrow();
				Lending lending = new Lending(id, user, book, lendDate, limitDate, returnedDate, reservation, staff);
				lendingRepository.save(lending);
			}
			return "redirect:/staff/materialMg/rentalList";

		} catch (NoSuchElementException e) {
			model.addAttribute("bookId", bookId);
			model.addAttribute("reservationId", reservationId);
			model.addAttribute("limitDate", limitDate);
			model.addAttribute("rentalDate", lendDate);
			model.addAttribute("returnedDate", returnedDate);
			model.addAttribute("staffId", staffId);
			model.addAttribute("rentalId", rentalId);
			model.addAttribute("error", "ユーザーが見つかりませんでした");
			return "/staff/rentalEdit";
		}
	}

	@PostMapping("/staff/materialMg/{id}/delete")
	public String delete(
			@PathVariable("id") Integer id,
			Model model) {

		lendingRepository.deleteById(id);

		return "/staff/materialMg/rentalList";
	}

	@GetMapping("/staff/materialMg/return")
	public String ret(Model model) {
		return "/staff/return";
	}
}
