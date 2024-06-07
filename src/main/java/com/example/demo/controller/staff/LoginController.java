package com.example.demo.controller.staff;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.LibraryStaff;
import com.example.demo.model.Account;
import com.example.demo.repository.LibraryStaffRepository;

import jakarta.servlet.http.HttpSession;

@Controller
public class LoginController {

	@Autowired
	HttpSession session;

	@Autowired
	Account account;

	@Autowired
	LibraryStaffRepository libraryStaffRepository;

	//ログイン画面表示
	@GetMapping({ "/", "/staff/login", "/staff/logout" })
	public String index() {
		session.invalidate();
		return "/staff/login";
	}

	//ログイン処理
	@PostMapping("/staff/login")
	public String login(
			@RequestParam(name = "email", defaultValue = "") String email,
			@RequestParam(name = "password", defaultValue = "") String password,
			Model model) {

		//エラーチェック
		List<String> errorList1 = new ArrayList<>();

		if (email.length() == 0) {
			errorList1.add("メールアドレスを入力してください");
		}
		if (password.length() == 0) {
			errorList1.add("パスワードを入力してください");
		}
		//ログインチェック
		if ((password.length() != 0) && (email.length() != 0)) {
			List<LibraryStaff> libraryStaffList = libraryStaffRepository.findByEmailAndPassword(email, password);
			if ((libraryStaffList.size() == 0) || (libraryStaffList == null)) {
				errorList1.add("メールアドレスとパスワードが一致しません");
			} else {
				LibraryStaff libraryStaff = libraryStaffList.get(0);
				account.setName(libraryStaff.getName());
				account.setId(libraryStaff.getId());//名前とユーザーIDをセッション管理
			}
		}

		//エラー時の処理
		if (errorList1.size() != 0) {
			//エラーの場合ログイン画面へ戻す
			model.addAttribute("errorList1", errorList1);
			model.addAttribute("email", email);
			return "/staff/login";
		} else {
			return "redirect:/expenses";
		}
	}

}
