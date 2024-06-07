package com.example.demo.controller.staff;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {
	
	@GetMapping("/staff/userMg")
	public String index(
			) {
		return "userManagement";
	}
}
