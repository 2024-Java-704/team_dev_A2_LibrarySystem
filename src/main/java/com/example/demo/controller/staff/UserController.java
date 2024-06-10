package com.example.demo.controller.staff;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.Lending;
import com.example.demo.entity.User;
import com.example.demo.repository.LendingRepository;
import com.example.demo.repository.UserRepository;

@Controller
public class UserController {
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	LendingRepository lendingRepository;
	
	@GetMapping("/staff/staffMg/userManagement")
	public String index() { //利用者機能トップの表示
		return "/staff/userManagement";
	}
	
	@GetMapping("/staff/staffMg/userList") //利用者一覧表示
	public String userListIndex(
			@RequestParam(name="researchUserId",defaultValue="") Integer userId,
			@RequestParam(name="researchUserName",defaultValue="") String userName,
			Model model) {
		
		List<User> userList=null;
		User user = null;
		
		if(!(userId==null||userName.equals(""))) {//IDと名前で検索
			userList=userRepository.findByIdAndName(userId,userName);
			model.addAttribute("userList",userList);
		}
		else if(userId==null&&!(userName.equals(""))) {//名前で検索
			userList=userRepository.findByName(userName);
			model.addAttribute("userList",userList);
		}
		else if(userName.equals("")&&!(userId==null)) {//IDで検索
			user=userRepository.findById(userId).get();
			model.addAttribute("userList",user);
		}
		else {
			userList=userRepository.findAll();//全検索
			model.addAttribute("userList",userList);
		}
		
		return "/staff/userList";
	}
	
	@GetMapping("/staff/staffMg/{userId}/userDetail") //利用者詳細表示
	public String userDetail(
			@PathVariable("userId") Integer userId,
			Model model) {
		
		User user=userRepository.findById(userId).get();
		List<Lending> lendingList=lendingRepository.findByUserId(userId);
		
		model.addAttribute("user",user);
		model.addAttribute("lendingList",lendingList);
		return "/staff/userDetail";
	}
}
