package com.example.demo.controller.staff;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.Lending;
import com.example.demo.repository.LendingRepository;
import com.example.demo.repository.ReservationRepository;

@Controller
public class RentalController {

	@Autowired
	LendingRepository lendingRepository;

	@Autowired
	ReservationRepository reservationRepository;

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
		LocalDate renDate =LocalDate.now();
		LocalDate returnDate=renDate.plusWeeks(1);
		model.addAttribute("renDate",renDate);
		model.addAttribute("returnDate",returnDate);
		return "/staff/rentalAdd";
	}
	
	@PostMapping("/staff/staffMg/rentalAdd")
	public String add(
			@RequestParam(value = "bookid", defaultValue = "") Integer bookid,
			@RequestParam(value = "rentaldate", defaultValue = "") String rentaldate,
			@RequestParam(value = "newreturn", defaultValue = "") String newreturn,
			@RequestParam(value = "reservationid", defaultValue = "") Integer reservationid,
			@RequestParam(value = "staffid", defaultValue = "") Integer staffid,
			@RequestParam(value = "userid", defaultValue = "") Integer userid,
			Model model) {
		
		return "redirect:/staff/rentalList";
	}

	@GetMapping("/staff/materialMg/rentalEdit")
	public String edit(Model model) {
		
		
		
		return "/staff/rentalEdit";
	}

	@GetMapping("/staff/materialMg/return")
	public String ret(Model model) {
		return "/staff/return";
	}
}
