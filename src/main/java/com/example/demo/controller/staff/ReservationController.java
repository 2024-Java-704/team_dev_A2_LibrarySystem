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
import com.example.demo.entity.Library;
import com.example.demo.entity.Reservation;
import com.example.demo.entity.Status;
import com.example.demo.entity.User;
import com.example.demo.repository.BookRepository;
import com.example.demo.repository.LibraryRepository;
import com.example.demo.repository.ReservationRepository;
import com.example.demo.repository.StatusRepository;
import com.example.demo.repository.UserRepository;

@Controller
public class ReservationController {
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

	@GetMapping("/staff/materialMg/reservationList")
	public String index(@RequestParam(value = "reservation", defaultValue = "") Integer reservation, Model model) {
		Status status = statusRepository.findById(1).get();
		List<Reservation> reservationList = reservationRepository.findByStatus(status);
		model.addAttribute("reservationList", reservationList);
		return "/staff/resevationList";
	}

	@GetMapping("/staff/materialMg/reservationAdd")
	public String add(Model model) {

		LocalDate today = LocalDate.now();
		LocalDate scheduledDate = today.plusWeeks(1);

		model.addAttribute("reservationDate", today);
		model.addAttribute("scheduledDate", scheduledDate);

		return "/staff/resevationAdd";
	}

	@GetMapping("/staff/materialMg/rental")
	public String rentalList(Model model) {
		Status status = statusRepository.findById(3).get();
		List<Reservation> rentalList = reservationRepository.findByStatus(status);
		model.addAttribute("reservationList", rentalList);
		return "/staff/resevationList";
	}

	@GetMapping("/staff/materialMg/cancel")
	public String cancelList(Model model) {
		Status status = statusRepository.findById(2).get();
		List<Reservation> cancelList = reservationRepository.findByStatus(status);
		model.addAttribute("reservationList", cancelList);
		return "/staff/resevationList";
	}

	@PostMapping("/staff/materialMg/reservationAdd")
	public String reservationAdd(@RequestParam(value = "user", defaultValue = "") Integer user_id,
			@RequestParam(value = "book", defaultValue = "") Integer book_id,
			@RequestParam(value = "reservationDate", defaultValue = "") LocalDate reservationDate,
			@RequestParam(value = "scheduledDate", defaultValue = "") LocalDate scheduledDate,
			@RequestParam(value = "library", defaultValue = "") Integer library_id,
			@RequestParam(value = "status", defaultValue = "") Integer status_id,
			Model model) {

		User user = userRepository.findById(user_id).get();
		Book book = bookRepository.findById(book_id).get();
		Library library = libraryRepository.findById(library_id).get();
		Status status = statusRepository.findById(status_id).get();

		Reservation orderReservation = new Reservation(user, book, reservationDate, scheduledDate, library, status);
		reservationRepository.save(orderReservation);
		return "redirect:/staff/materialMg/reservationList";
	}

	@GetMapping("/staff/materialMg/{id}/reservationEdit")
	public String edits(@PathVariable("id") Integer id,
			Model model) {
		model.addAttribute("id", id);
		Reservation reservation = reservationRepository.findById(id).get();
		model.addAttribute("reservation", reservation);
		return "/staff/resevationEdit";
	}

	@PostMapping("/staff/materialMg/{id}/reservationEdit")
	public String edits(@PathVariable("id") Integer id,
			@RequestParam(value = "user", defaultValue = "") Integer user_id,
			@RequestParam(value = "book", defaultValue = "") Integer book_id,
			@RequestParam(value = "reservationDate", defaultValue = "") LocalDate reservationDate,
			@RequestParam(value = "scheduledDate", defaultValue = "") LocalDate scheduledDate,
			@RequestParam(value = "library", defaultValue = "") Integer library_id,
			@RequestParam(value = "status", defaultValue = "") Integer status_id,
			Model model) {
		User user = userRepository.findById(user_id).get();
		Book book = bookRepository.findById(book_id).get();
		Library library = libraryRepository.findById(library_id).get();
		Status status = statusRepository.findById(status_id).get();
		Reservation orderReservation = new Reservation(id, user, book, reservationDate, scheduledDate, library, status);
		reservationRepository.save(orderReservation);
		return "redirect:/staff/materialMg/reservationList";
	}

	@PostMapping("/staff/materialMg/{id}/delete")
	public String delete(@PathVariable("id") Integer id,
			Model model) {
		Reservation reservation = reservationRepository.findById(id).get();
		Status status = statusRepository.findById(2).get();
		reservation.setStatus(status);
		reservationRepository.save(reservation);
		return "redirect:/staff/materialMg/reservationList";
	}

}
