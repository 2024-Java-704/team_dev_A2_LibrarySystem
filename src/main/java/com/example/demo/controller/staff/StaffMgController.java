package com.example.demo.controller.staff;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.Library;
import com.example.demo.entity.LibraryStaff;
import com.example.demo.repository.LibraryRepository;
import com.example.demo.repository.LibraryStaffRepository;

@Controller
public class StaffMgController {
	@Autowired
	private LibraryStaffRepository libraryStaffRepository;
	@Autowired
	private LibraryRepository libraryRepository;

	@GetMapping("/staff/staffMg")
	public String index(
			@RequestParam(value = "library", defaultValue = "") Integer library,
			Model model) {
		//		List<LibraryStaff> staffList = libraryStaffRepository.findByLibraryId(library);
		List<LibraryStaff> staffList = libraryStaffRepository.findAll();
		model.addAttribute("staffList", staffList);

		return "/staff/staffList";
	}

	@GetMapping("/staff/staffMg/staffAdd")
	public String add() {
		return "/staff/staffAdd";
	}

	@PostMapping("/staff/staffMg/staffAdd")
	public String addre(
			@RequestParam(value = "name", defaultValue = "") String name,
			@RequestParam(value = "libraryId", defaultValue = "") Integer libraryid,
			@RequestParam(value = "email", defaultValue = "") String email,
			@RequestParam(value = "password", defaultValue = "") String password,
			Model model) {
		Library library = libraryRepository.findById(libraryid).get();
		LibraryStaff staff = new LibraryStaff(library, name, email, password);

		libraryStaffRepository.save(staff);

		return "redirect:/staff/staffMg";
	}

	@GetMapping("/staff/staffMg/{id}/edit")
	public String edit(@PathVariable("id") Integer id, Model model) {
		model.addAttribute("id", id);
		LibraryStaff librarystaff = libraryStaffRepository.findById(id).get();
		model.addAttribute("librarystaff", librarystaff);
		return "/staff/staffEdit";
	}

	@PostMapping("/staff/staffMg/{id}/edit")
	public String handleEdit(
			@PathVariable("id") Integer id,
			@RequestParam(value = "name", defaultValue = "") String name,
			@RequestParam(value = "libraryId", defaultValue = "") Integer libraryid,
			@RequestParam(value = "email", defaultValue = "") String email,
			@RequestParam(value = "password", defaultValue = "") String password,
			Model model) {
		Library library = libraryRepository.findById(libraryid).get();
		LibraryStaff staff = new LibraryStaff(id, library, name, email, password);

		libraryStaffRepository.save(staff);
		return "redirect:/staff/staffMg";
	}

	@PostMapping("/staff/{id}/delete")
	public String delete(

			@PathVariable("id") Integer id, Model model) {
		libraryStaffRepository.deleteById(id);
		return "redirect:/staff/staffMg";
	}

}
