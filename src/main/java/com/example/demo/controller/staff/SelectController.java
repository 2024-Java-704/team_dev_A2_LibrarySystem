package com.example.demo.controller.staff;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.model.Account;

@Controller
public class SelectController {

	@Autowired
	Account acount;

	@GetMapping("/staff/staffTop")
	public String index(
			@RequestParam(name = "librayId", defaultValue = "") Integer libraryId,
			@RequestParam(name = "librayName", defaultValue = "") String libraryName,
			Model model) {
		acount.setLibraryId(libraryId);
		acount.setLibraryName(libraryName);
		return "/staff/staffTop";
	}

	@GetMapping("/staff/materialMg")
	public String materialMg(Model model) {
		return "/staff/materialManagement";
	}
}
