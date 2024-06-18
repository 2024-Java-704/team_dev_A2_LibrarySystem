package com.example.demo.controller.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.Book;
import com.example.demo.entity.Library;
import com.example.demo.entity.LibraryStaff;
import com.example.demo.entity.Reservation;
import com.example.demo.entity.User;
import com.example.demo.repository.BookRepository;
import com.example.demo.repository.LibraryRepository;
import com.example.demo.repository.LibraryStaffRepository;
import com.example.demo.repository.ReservationRepository;
import com.example.demo.repository.UserRepository;

@Controller
public class LibraryListController {

	@Autowired
	private LibraryRepository libraryRepository;

	@Autowired
	private BookRepository bookRepository;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private ReservationRepository reservationRepository;

	@Autowired
	private LibraryStaffRepository libraryStaffRepository;

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

	@PostMapping("/admin/adminList/{libraryId}/libraryDelete")
	public String libraryDelete(
			@PathVariable("libraryId") Integer id) {

		Library library = libraryRepository.findById(id).get();
		libraryRepository.delete(library);

		List<Book> bookList = bookRepository.findByLibraryId(id);
		for (Book book : bookList) {
			bookRepository.delete(book);
		}

		List<User> userList = userRepository.findByLibrary(library);
		for (User user : userList) {
			userRepository.delete(user);
		}

		List<LibraryStaff> staffList = libraryStaffRepository.findByLibraryId(id);
		for (LibraryStaff staff : staffList) {
			libraryStaffRepository.delete(staff);
		}

		List<Reservation> reservationList = reservationRepository.findByLibraryId(id);
		for (Reservation reservation : reservationList) {
			reservationRepository.delete(reservation);
		}
		return "redirect:/admin/libraryList";
	}

}
