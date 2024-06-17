package com.example.demo.controller.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.Library;
import com.example.demo.repository.LibraryRepository;

@Controller
public class LibraryListController {

	@Autowired
	private LibraryRepository libraryRepository;

	@GetMapping("/admin/libraryList")
	public String index(
			@RequestParam(name = "name", defaultValue = "") String name,
			@RequestParam(name = "address", defaultValue = "") String address,
			@RequestParam(name = "tel", defaultValue = "") String tel,
			Model model) {

		List<Library> libraryList = libraryRepository.findAll();
		model.addAttribute("libraryList", libraryList);
		return "admin/libraryList";
	}

	@GetMapping("/admin/libraryAdd")
	public String add() {
		return "/admin/libraryAdd";
	}

	@PostMapping("/admin/libraryAdd")
	public String addlibrary(
			@RequestParam(name = "name", defaultValue = "") String name,
			@RequestParam(name = "address", defaultValue = "") String address,
			@RequestParam(name = "tel", defaultValue = "") String tel,
			Model model) {
		Library library = new Library(name, address, tel);
		libraryRepository.save(library);
		return "redirect:/admin/libraryList";
	}

	@GetMapping("/admin/adminList/{id}/libraryEdit")
	public String libraryEdit(
			@PathVariable("id") Integer id,
			Model model) {
		Library library = libraryRepository.findById(id).get();
		model.addAttribute("library", library); // Add library to model if needed

		return "admin/libraryEdit"; // Return Thymeleaf template name
	}

	@PostMapping("/admin/adminList/{id}/libraryEdit")
	public String libraryUpdate(
			@PathVariable("id") Integer id,
			@RequestParam(name = "name", defaultValue = "") String name,
			@RequestParam(name = "address", defaultValue = "") String address,
			@RequestParam(name = "tel", defaultValue = "") String tel,
			Model model) {
		Library library = new Library(id, name, address, tel);
		libraryRepository.save(library);
		return "redirect:/admin/libraryList";
	}

	@PostMapping("/admin/adminList/{id}/libraryDelete")
	public String libraryDelete(
			@PathVariable("id") Integer id) {
		libraryRepository.deleteById(id);
		return "redirect:/admin/libraryList";
	}

}
