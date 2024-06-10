package com.example.demo.controller.staff;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.model.Account;

@Controller
public class SelectController {
	
	@Autowired
	Account acount;
	
	@GetMapping("/staff/staffMg/staffTop")
	public String index(Model model) {
		return "/staff/staffTop";
	}
	
	@GetMapping("/staff/staffMg/materialMg")
	public String materialMg(Model model) {
		return "/staff/materialManagement";
	}
}
