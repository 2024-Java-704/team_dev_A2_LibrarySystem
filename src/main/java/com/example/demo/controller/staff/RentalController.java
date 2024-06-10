package com.example.demo.controller.staff;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.entity.Lending;
import com.example.demo.repository.LendingRepository;

@Controller
public class RentalController {

	@Autowired
	LendingRepository lendingRepository;

	@GetMapping("/staff/staffMg/rentalList")
	public String index(
			Model model) {
		
		List<Lending> lendingList = lendingRepository.findAll();
		model.addAttribute("lendings", lendingList);
		
		/*if (lendingList.size() == 0) {*/
//			model.addAttribute("error", "貸し出している本がありません");
			/*} else {
				
			}*/
		return "/staff/rentalList";
	}

	@GetMapping("/staff/staffMg/rentalAdd")
	public String add(Model model) {
		return "/staff/rentalAdd";
	}

	@GetMapping("/staff/staffMg/rentalEdit")
	public String edit(Model model) {
		return "/staff/rentalEdit";
	}

	@GetMapping("/staff/staffMg/return")
	public String ret(Model model) {
		return "/staff/return";
	}
}
