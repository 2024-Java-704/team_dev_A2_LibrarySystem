package com.example.demo.controller.staff;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.Book;
import com.example.demo.entity.Lending;
import com.example.demo.entity.User;
import com.example.demo.model.Account;
import com.example.demo.repository.BookRepository;
import com.example.demo.repository.LendingRepository;
import com.example.demo.repository.UserRepository;

@Controller
public class UserController {

	@Autowired
	UserRepository userRepository;

	@Autowired
	LendingRepository lendingRepository;

	@Autowired
	BookRepository bookRepository;

	@Autowired
	Account account;

	@GetMapping("/staff/userMg")
	public String index() { //利用者機能トップの表示
		return "/staff/userManagement";
	}

	@GetMapping("/staff/userMg/userList") //利用者一覧表示
	public String userListIndex(
			@RequestParam(name = "researchUserId", defaultValue = "") Integer userId,
			@RequestParam(name = "researchUserName", defaultValue = "") String userName,
			Model model) {

		List<User> userList = null;
		User user = null;

		if (!(userId == null || userName.equals(""))) {//IDと名前で検索
			userList = userRepository.findByIdAndName(userId, userName);
			model.addAttribute("userList", userList);
		} else if (userId == null && !(userName.equals(""))) {//名前で検索
			userList = userRepository.findByName(userName);
			model.addAttribute("userList", userList);
		} else if (userName.equals("") && !(userId == null)) {//IDで検索
			user = userRepository.findById(userId).get();
			model.addAttribute("userList", user);
		} else {
			userList = userRepository.findAll();//全検索
			model.addAttribute("userList", userList);
		}

		return "/staff/userList";
	}

	@GetMapping("/staff/userMg/{userId}/userDetail") //利用者詳細表示
	public String userDetail(
			@PathVariable("userId") Integer userId,
			Model model) {

		User user = userRepository.findById(userId).get();
		List<Lending> lendingList = lendingRepository.findByUserId(userId);

		model.addAttribute("user", user);
		model.addAttribute("lendingList", lendingList);
		return "/staff/userDetail";
	}

	@GetMapping("/staff/userMg/new") //新規登録画面表示
	public String add() {
		return "/staff/userAdd";
	}

	@PostMapping("/staff/userMg/add") //登録処理
	public String addUser(
			@RequestParam(name = "name", defaultValue = "") String name,
			@RequestParam(name = "email", defaultValue = "") String email,
			@RequestParam(name = "address", defaultValue = "") String address,
			@RequestParam(name = "tel", defaultValue = "") String tel,
			@RequestParam(name = "password", defaultValue = "") String password,
			Model model) {

		List<String> errorList = new ArrayList<>();
		if (name == null || name.length() == 0) {
			errorList.add("名前を入力してください");
		}
		if (address == null || address.length() == 0) {
			errorList.add("住所を入力してください");
		}
		if (tel == null || tel.length() == 0) {
			errorList.add("電話番号を入力してください");
		}
		if (password == null || password.length() == 0) {
			errorList.add("パスワードを入力してください");
		}
		if (errorList.size() > 0) {
			model.addAttribute("error", errorList);
			model.addAttribute("name", name);
			model.addAttribute("email", email);
			model.addAttribute("address", address);
			model.addAttribute("tel", tel);
			model.addAttribute("password", password);
			return "/staff/userAdd";
		} else {
			User user = new User(name, address, email, tel, password);
			userRepository.save(user);
			return "redirect:/staff/userMg/userList";
		}
	}

	@GetMapping("/staff/userMg/{userId}/userEdit") //更新画面表示
	public String userEdit(
			@PathVariable("userId") Integer userId,
			Model model) {

		User user = userRepository.findById(userId).get();
		model.addAttribute("user", user);
		return "/staff/userEdit";
	}

	@PostMapping("/staff/userMg/{userId}/userEdit") //更新処理
	public String userUpdate(
			@PathVariable("userId") Integer userId,
			@RequestParam(name = "name", defaultValue = "") String name,
			@RequestParam(name = "email", defaultValue = "") String email,
			@RequestParam(name = "address", defaultValue = "") String address,
			@RequestParam(name = "tel", defaultValue = "") String tel,
			@RequestParam(name = "password", defaultValue = "") String password,
			Model model) {

		List<String> errorList = new ArrayList<>();
		if (name == null || name.length() == 0) {
			errorList.add("名前を入力してください");
		}
		if (address == null || address.length() == 0) {
			errorList.add("住所を入力してください");
		}
		if (tel == null || tel.length() == 0) {
			errorList.add("電話番号を入力してください");
		}
		if (password == null || password.length() == 0) {
			errorList.add("パスワードを入力してください");
		}
		if (errorList.size() > 0) {
			model.addAttribute("error", errorList);
			model.addAttribute("name", name);
			model.addAttribute("email", email);
			model.addAttribute("address", address);
			model.addAttribute("tel", tel);
			model.addAttribute("password", password);
			User user = userRepository.findById(userId).get();
			model.addAttribute("user", user);
			return "/staff/userEdit";
		} else {
			User user = new User(userId, name, address, email, tel, password);
			userRepository.save(user);
			return "redirect:/staff/userMg/userList";
		}
	}

	@PostMapping("/staff/userMg/{userId}/userDelete")
	public String userDelete(
			@PathVariable("userId") Integer userId) {
		userRepository.deleteById(userId);
		return "redirect:/staff/userMg/userList";
	}

	@GetMapping("/staff/userMg/delinquentList")
	public String show(Model model) {

		LocalDate today = LocalDate.now();
		List<Book> books = bookRepository.findByLibraryId(account.getLibraryId());
		List<Integer> bookIdList = new ArrayList<>();
		for (Book book : books) {
			bookIdList.add(book.getId());
		}
		List<Lending> delayList = new ArrayList<>();
		for (Integer bookId : bookIdList) {
			delayList.addAll(lendingRepository.findByBookIdAndLimitDateBeforeAndReturnedDateIsNull(bookId, today));
		}
		if (delayList.size() == 0) {
			model.addAttribute("error", "延滞者はいません");
		} else {
			model.addAttribute("delayList", delayList);
		}
		return "/staff/delinquentList";
	}
}
