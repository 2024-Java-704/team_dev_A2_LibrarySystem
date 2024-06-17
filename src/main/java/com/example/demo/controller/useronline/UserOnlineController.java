package com.example.demo.controller.useronline;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.Lending;
import com.example.demo.entity.User;
import com.example.demo.model.Account;
import com.example.demo.repository.LendingRepository;
import com.example.demo.repository.UserRepository;

import jakarta.servlet.http.HttpSession;

@Controller
public class UserOnlineController {
	
	@Autowired
	HttpSession session;
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	LendingRepository lendingRepository;
	
	@Autowired
	Account account;
	
	@GetMapping({"/user/login", "/user/logout" })
	public String index() {
		session.invalidate();
		return "/useronline/login";
	}
	@PostMapping("/user/login")
	public String login(
			@RequestParam(name = "userid", defaultValue = "") Integer userid,
			@RequestParam(name = "password", defaultValue = "") String password,
			Model model) {

		//エラーチェック
		List<String> errorList1 = new ArrayList<>();

		if (userid == 0) {
			errorList1.add("利用者IDを入力してください");
		}
		if (password.length() == 0) {
			errorList1.add("パスワードを入力してください");
		}
		//ログインチェック
		if ((password.length() != 0) && (userid != 0)) {
			List<User> userList = userRepository.findByIdAndPassword(userid, password);
			if ((userList.size() == 0) || (userList == null)) {
				errorList1.add("利用者IDとパスワードが一致しません");
			} else {
				User user = userList.get(0);
				account.setName(user.getName());
				account.setId(user.getId());//名前とユーザーIDをセッション管理
				account.setLibraryId(user.getLibrary().getId());
			}
		}

		//エラー時の処理
		if (errorList1.size() != 0) {
			//エラーの場合ログイン画面へ戻す
			model.addAttribute("errorList1", errorList1);
			model.addAttribute("userid", userid);
			return "/useronline/login";
		} else {
			return "redirect:/user/mypage";
		}
	}
	
	@GetMapping("/user/mypage") //更新画面表示
	public String userMypage(
			Model model) {

		User user = userRepository.findById(account.getId()).get();
		List<Lending> lending = lendingRepository.findByUserId(user.getId());
		model.addAttribute("user", user);
		model.addAttribute("lending", lending);
		return "/useronline/mypage";
	}
}
