package com.example.demo.controller.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.LibraryManager;
import com.example.demo.model.Account;
import com.example.demo.repository.LibraryManagerRepository;

@Controller
public class LibraryMgController {

	@Autowired
	private LibraryManagerRepository libraryManagerRepository;

	@Autowired
	Account account;

	@GetMapping("/admin/libraryMg")
	public String index(
			Model model) {

		List<LibraryManager> libraryMgList = libraryManagerRepository.findAll();
		model.addAttribute("libraryMgList", libraryMgList);

		return "/admin/libraryMgList";
	}

	@GetMapping("/admin/libraryMg/libraryMgAdd")
	public String add(Model model) {
		return "/admin/libraryMgAdd";
	}

	@PostMapping("/admin/libraryMg/libraryMgAdd")
	public String addre(
			@RequestParam(value = "name", defaultValue = "") String name,
			@RequestParam(value = "email", defaultValue = "") String email,
			@RequestParam(value = "password", defaultValue = "") String password,
			Model model) {
		LibraryManager admin = new LibraryManager(name, email, password);

		libraryManagerRepository.save(admin);

		return "redirect:/admin/libraryMg";
	}

	@GetMapping("/admin/libraryMg/{id}/edit")
	public String edit(
			@PathVariable("id") Integer id, Model model) {
		LibraryManager librarymg = libraryManagerRepository.findById(id).get();
		model.addAttribute("librarymg", librarymg);
		return "/admin/libraryMgEdit";
	}

	@PostMapping("/admin/libraryMg/{id}/edit")
	public String handleEdit(
			@PathVariable("id") Integer id,
			@RequestParam(value = "name", defaultValue = "") String name,
			@RequestParam(value = "email", defaultValue = "") String email,
			@RequestParam(value = "password", defaultValue = "") String password,
			Model model) {
		LibraryManager manager = new LibraryManager(id, name, email, password);

		libraryManagerRepository.save(manager);
		return "redirect:/admin/libraryMg";
	}

	@PostMapping("/admin/libraryMg/{id}/delete")
	public String delete(
			@PathVariable("id") Integer id, Model model) {
		libraryManagerRepository.deleteById(id);
		return "redirect:/admin/libraryMg";
	}
	
	
	@GetMapping("/manager/staff/login")
	public String login(
			@RequestParam(name = "libraryId", defaultValue = "") Integer libraryId,
			@RequestParam(name = "libraryName", defaultValue = "") String libraryName,
			Model model) {
		account.setLibraryId(libraryId);
		account.setLibraryName(libraryName);
		return "redirect:/staff/staffTop";
		
	}
}
