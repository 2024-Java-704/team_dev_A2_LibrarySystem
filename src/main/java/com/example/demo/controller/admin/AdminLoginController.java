package com.example.demo.controller.admin;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.LibraryManager;
import com.example.demo.model.Account;
import com.example.demo.repository.LibraryManagerRepository;

import jakarta.servlet.http.HttpSession;

@Controller
public class AdminLoginController {

	@Autowired
	HttpSession session;

	@Autowired
	Account account;

	@Autowired
	LibraryManagerRepository libraryManagerRepository;

	//ログイン画面表示
	@GetMapping({"/admin/login", "/admin/logout"})
	public String index() {
		session.invalidate();
		return "/admin/adminLogin";
	}

	//ログイン処理
	@PostMapping("/admin/login")
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
			List<LibraryManager> libraryManagerList = libraryManagerRepository.findByEmailAndPassword(email, password);
			if ((libraryManagerList.size() == 0) || (libraryManagerList == null)) {
				errorList1.add("メールアドレスとパスワードが一致しません");
			} else {
				LibraryManager libraryStaff = libraryManagerList.get(0);
				account.setName(libraryStaff.getName());
				account.setId(libraryStaff.getId());//名前とユーザーIDをセッション管理
			}
		}

		//エラー時の処理
		if (errorList1.size() != 0) {
			//エラーの場合ログイン画面へ戻す
			model.addAttribute("errorList1", errorList1);
			model.addAttribute("email", email);
			return "/admin/adminLogin";
		} else {
			return "redirect:/admin/adminTop";
		}
	}
	
	@GetMapping("/admin/adminTop")
	public String index(Model model) {
		return "/admin/adminTop";
	}
	
}
