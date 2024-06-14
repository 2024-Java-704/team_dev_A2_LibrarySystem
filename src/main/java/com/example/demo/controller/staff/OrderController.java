package com.example.demo.controller.staff;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.Book;
import com.example.demo.entity.Library;
import com.example.demo.entity.Reservation;
import com.example.demo.entity.Status;
import com.example.demo.entity.User;
import com.example.demo.model.Account;
import com.example.demo.repository.BookRepository;
import com.example.demo.repository.LibraryRepository;
import com.example.demo.repository.ReservationRepository;
import com.example.demo.repository.StatusRepository;
import com.example.demo.repository.UserRepository;

@Controller
public class OrderController {//reservation
	@Autowired
	private ReservationRepository reservationRepository;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private BookRepository bookRepository;
	@Autowired
	private LibraryRepository libraryRepository;
	@Autowired
	private StatusRepository statusRepository;
	@Autowired
	private Account account;

	@GetMapping("/staff/materialMg/order")
	public String index(
			@RequestParam(value = "reservation", defaultValue = "") Integer reservation,
			@RequestParam(value = "accept", defaultValue = "") String accept,
			@RequestParam(value = "send", defaultValue = "") String send,
			Model model) {
		List<Book> books = bookRepository.findByLibraryId(account.getLibraryId());
		List<Integer> bookIdList = new ArrayList<>();
		for (Book book : books) {
			bookIdList.add(book.getId());
		}
		List<Reservation> orderList = new ArrayList<>();
		if (accept.equals("juchu")) { //受注
			for (Integer bookId : bookIdList) {
				orderList.addAll(reservationRepository.findByBookIdAndLibraryIdNot(
						bookId,
						account.getLibraryId()));
			}
			for (Integer bookId : bookIdList) {
				orderList.removeAll(reservationRepository.findByBookIdAndLibraryId(bookId, account.getId()));
			}
		} else if (send.equals("hacchu")) {//発注
			for (Integer bookId : bookIdList) {
				orderList.addAll(reservationRepository.findByBookIdNotAndLibraryId(
						bookId,
						account.getLibraryId()));
			}
			for (Integer bookId : bookIdList) {
				orderList.removeAll(reservationRepository.findByBookIdAndLibraryId(bookId, account.getId()));
			}
		} else {
			for (Integer bookId : bookIdList) {//一覧表示
				orderList.addAll(reservationRepository.findByBookIdOrLibraryId(
						bookId,
						account.getLibraryId()));
			}
			for (Integer bookId : bookIdList) {
				orderList.removeAll(reservationRepository.findByBookIdAndLibraryId(bookId, account.getId()));
			}
		}

		List<Reservation> order2List = new ArrayList<>(
				new HashSet<>(orderList));
		model.addAttribute("reservationList", order2List);

		return "/staff/orderList";

	}

	@GetMapping("/staff/materialMg/orderAdd")
	public String add(Model model) {
		LocalDate today = LocalDate.now();
		LocalDate scheduledDate = today.plusWeeks(1);

		model.addAttribute("reservationDate", today); //注文日(デフォルトで今日)
		model.addAttribute("scheduledDate", scheduledDate); //貸出予定日(一週間後)

		return "staff/orderAdd";
	}

	@PostMapping("/staff/materialMg/orderAdd")
	public String addd(
			@RequestParam(value = "user", defaultValue = "") Integer user_id,
			@RequestParam(value = "book", defaultValue = "") Integer book_id,
			@RequestParam(value = "reservationDate", defaultValue = "") LocalDate reservationDate,
			@RequestParam(value = "scheduledDate", defaultValue = "") LocalDate scheduledDate,
			@RequestParam(value = "liburary", defaultValue = "") Integer library_id,
			@RequestParam(value = "status", defaultValue = "") Integer status_id,
			Model model) {

		User user = userRepository.findById(user_id).get();
		Book book = bookRepository.findById(book_id).get();
		Library library = libraryRepository.findById(library_id).get();
		Status status = statusRepository.findById(status_id).get();
		Reservation orderReservation = new Reservation(user, book, reservationDate, scheduledDate, library, status);
		reservationRepository.save(orderReservation);
		return "redirect:/staff/materialMg/order";

	}

	@GetMapping("/staff/materialMg/{id}/orderEdit")
	public String edit(
			@PathVariable("id") Integer id,
			Model model) {
		model.addAttribute("id", id);
		Reservation reservation = reservationRepository.findById(id).get();
		model.addAttribute("reservation", reservation);
		return "/staff/orderEdit";

	}

	@PostMapping("/staff/materialMg/{id}/orderEdit")
	public String edits(
			@PathVariable("id") Integer id,
			@RequestParam(value = "user", defaultValue = "") Integer user_id,
			@RequestParam(value = "book", defaultValue = "") Integer book_id,
			@RequestParam(value = "reservationDate", defaultValue = "") LocalDate reservationDate,
			@RequestParam(value = "scheduledDate", defaultValue = "") LocalDate scheduledDate,
			@RequestParam(value = "liburary", defaultValue = "") Integer library_id,
			@RequestParam(value = "status", defaultValue = "") Integer status_id,
			Model model) {
		User user = userRepository.findById(user_id).get();
		Book book = bookRepository.findById(book_id).get();
		Library library = libraryRepository.findById(library_id).get();
		Status status = statusRepository.findById(status_id).get();
		Reservation orderReservation = new Reservation(id, user, book, reservationDate, scheduledDate, library, status);
		reservationRepository.save(orderReservation);
		return "redirect:/staff/materialMg/order";
	}

	@PostMapping("/staff/materialMg/{id}/orderDelete")
	public String delete(

			@PathVariable("id") Integer id, Model model) {
		reservationRepository.deleteById(id);

		return "redirect:/staff/materialMg/order";
	}

}
