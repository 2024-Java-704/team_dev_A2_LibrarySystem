package com.example.demo.controller.staff;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.Reservation;
import com.example.demo.repository.ReservationRepository;

@Controller
public class ReservationController {

	@Autowired
	ReservationRepository reservationRepository;

	@GetMapping("/staff/staffMG/reservationList")
	public String index() {
		return "/staff/resevationList";
	}

	@PostMapping("/staff/staffMG/reservationAdd")
	public String reservationAdd(@RequestParam("category") String title,
			@RequestParam("title") String category,
			@RequestParam("author") String author,
			@RequestParam("publisher") String publisher,
			@RequestParam("pubYear") String pubYear,
			Model model) {

		List<Reservation> reservationList = reservationRepository.findAll();
		model.addAttribute("reservations", reservationList);

		return "/staff/reservationAdd";
	}

	@PostMapping("/reservationList/{id}/delete")
	public String delete(@PathVariable("id") Integer id, Model model) {

		reservationRepository.deleteById(id);

		return "redirect:/reservationList";
	}
}
