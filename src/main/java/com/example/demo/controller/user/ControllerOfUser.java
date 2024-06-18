package com.example.demo.controller.user;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.entity.Book;
import com.example.demo.entity.Lending;
import com.example.demo.entity.Library;
import com.example.demo.entity.LibraryStaff;
import com.example.demo.entity.Reservation;
import com.example.demo.entity.Status;
import com.example.demo.entity.User;
import com.example.demo.model.Account;
import com.example.demo.repository.BookRepository;
import com.example.demo.repository.CategoryRepository;
import com.example.demo.repository.LendingRepository;
import com.example.demo.repository.LibraryRepository;
import com.example.demo.repository.LibraryStaffRepository;
import com.example.demo.repository.ReservationRepository;
import com.example.demo.repository.StatusRepository;
import com.example.demo.repository.UserRepository;

@Controller
public class ControllerOfUser {

	@Autowired
	BookRepository bookRepository;

	@Autowired
	CategoryRepository categoryRepository;

	@Autowired
	UserRepository userRepository;

	@Autowired
	StatusRepository statusRepository;

	@Autowired
	LendingRepository lendingRepository;

	@Autowired
	LibraryRepository libraryRepository;

	@Autowired
	ReservationRepository reservationRepository;

	@Autowired
	LibraryStaffRepository libraryStaffRepository;

	@Autowired
	Account account;

	@GetMapping("/user/libraryTop")
	public String libraryTop(Model model) {
		List<Library> library = libraryRepository.findAll();
		model.addAttribute("libraries", library);
		return "/user/library";
	}

	@GetMapping("/user/{id}/staffLogin")
	public String userPageStaffLogin(
			@PathVariable("id") Integer libraryId, Model model) {
		Library library = libraryRepository.findById(libraryId).get();
		model.addAttribute("library", library);
		return "/user/staffLogin";
	}

	@PostMapping("/user/{id}/staffLogin")
	public String userPageLogin(
			@PathVariable("id") Integer libraryId,
			@RequestParam(name = "email", defaultValue = "") String email,
			@RequestParam(name = "password", defaultValue = "") String password,
			RedirectAttributes redirectAttributes,
			Model model) {
		List<String> errorList = new ArrayList<>();
		if (email.equals("")) {
			errorList.add("メールアドレスを入力してください");
		}
		if (password.equals("")) {
			errorList.add("パスワードを入力してください");
		}
		List<LibraryStaff> libraryStaffs = libraryStaffRepository.findByEmailAndPassword(email, password);
		if (libraryStaffs.size() == 0) {
			errorList.add("メールアドレスとパスワードが一致しません");
		} else {
			LibraryStaff libraryStaff = libraryStaffs.get(0);
			if (libraryStaff.getLibrary().getId() != libraryId) {
				errorList.add("本図書館の職員ではありません");
			}
		}
		if (errorList.size() > 0) {
			redirectAttributes.addAttribute("error", errorList);
			redirectAttributes.addFlashAttribute("error", errorList);
			return "redirect:/user/{id}/staffLogin";
		} else {
			account.setLibraryId(libraryId);
			Library library = libraryRepository.findById(libraryId).get();
			account.setLibraryName(library.getName());
			return "/user/userTop";
		}
	}

	@GetMapping("/user/userTop") //ユーザートップ（検索画面）
	public String index() {
		return "/user/userTop";
	}

	@GetMapping("/user/childrenSearch") //子供用
	public String indexChildren() {
		return "/user/childrenSearch";
	}

	@PostMapping("/user/userSearch") //検索処理・検索結果表示
	public String search(
			@RequestParam(name = "title", defaultValue = "") String title,
			@RequestParam(name = "category", defaultValue = "") Integer categoryId,
			@RequestParam(name = "author", defaultValue = "") String author,
			@RequestParam(name = "publisher", defaultValue = "") String publisher,
			@RequestParam(name = "publishDay", defaultValue = "") LocalDate publishDay,
			Model model) {

		List<Book> bookList = new ArrayList<>();
		if (title.contains("　")) {//タイトル全角条件複数
			String[] titles = title.split("　");

			for (String tai : titles) {
				bookList.addAll(bookRepository.findByTitleContaining(tai));
			}
			List<Book> booktitles = new ArrayList<>(new HashSet<>(bookList)); //タイトルの検索結果

			model.addAttribute("books", booktitles);

		}
		if (title.contains("\s")) {//タイトル半角条件複数
			String[] titles = title.split("\s");

			for (String tai : titles) {
				bookList.addAll(bookRepository.findByTitleContaining(tai));
			}
			List<Book> booktitles = new ArrayList<>(new HashSet<>(bookList));
			model.addAttribute("books", booktitles);
			return "/user/userSearch";
		}
		if (!(title.equals(""))) {//タイトル条件ひとつ
			bookList.addAll(bookRepository.findByTitleContaining(title));

			if (categoryId != null) {
				//				Category category = categoryRepository.findByCategoryNum(categoryId);
				//				List<Book> findByCategory = bookRepository.findByCategory(category);
				//				bookList.addAll(findByCategory);
			}
		}
		return "/user/userSearch";

	}
	//		List<Book> bookList = new ArrayList<>();
	//		if (title.contains("　")) {//タイトル全角条件複数
	//			String[] titles = title.split("　");
	//
	//			for (String tai : titles) {
	//				bookList.addAll(bookRepository.findByTitleContaining(tai));
	//			}
	//			List<Book> booktitles = new ArrayList<>(new HashSet<>(bookList)); //タイトルの検索結果
	//
	//			List<Integer> bookIds = new ArrayList<>();//本のIDだけを入れるリストを作成
	//			for (Book book : booktitles) {
	//				bookIds.add(book.getId());
	//			}
	//
	//			//booktitlesに対して絞り込み
	//
	//			if (categoryId != null) {//分類番号があったら
	//				for (Integer bookId : bookIds) {
	//					List<Book> findByCategory = bookRepository.findByIdAndCategoryId(bookId, categoryId);
	//
	//				}
	//			}
	//
	//			model.addAttribute("books", booktitles);
	//			return "/user/userSearch";
	//		}
	//		if (title.contains("\s")) {//タイトル半角条件複数
	//			String[] titles = title.split("\s");
	//
	//			for (String tai : titles) {
	//				bookList.addAll(bookRepository.findByTitleContaining(tai));
	//			}
	//			List<Book> booktitles = new ArrayList<>(new HashSet<>(bookList));
	//			model.addAttribute("books", booktitles);
	//			return "/user/userSearch";
	//		}

	//=======================================================

	//		if (!(title.equals(""))) {//タイトル条件ひとつ
	//			bookList.addAll(bookRepository.findByTitleContaining(title));
	//
	//			if (categoryId != null) {
	//				Category category = categoryRepository.findByCategoryNum(categoryId);
	//				List<Book> findByCategory = bookRepository.findByCategory(category);
	//				bookList.addAll(findByCategory);
	//			}
	//		}
	//		if (categoryId != null) {
	//			Category category = categoryRepository.findByCategoryNum(categoryId);
	//			List<Book> findByCategory = bookRepository.findByCategory(category);
	//			bookList.addAll(findByCategory);
	//		}
	//
	//		if (!(author.equals(""))) {
	//			bookList.addAll(bookRepository.findByAuthorContaining(author));
	//		}
	//
	//		if (!(publisher.equals(""))) {//出版社条件ひとつ
	//			bookList.addAll(bookRepository.findByPublisherContaining(publisher));
	//		}
	//
	//		if (!(Objects.isNull(publishDay))) {
	//			bookList.addAll(bookRepository.findByPubYear(publishDay));
	//		}

	//	}

	@GetMapping("/user/{id}/bookDetail") //詳細表示
	public String userBookDetail(
			@PathVariable("id") Integer id,
			Model model) {
		Book book = bookRepository.findById(id).get();
		model.addAttribute("bookDetail", book);
		List<Book> findByTitle = bookRepository.findByTitleContaining(book.getTitle());
		model.addAttribute("bookList", findByTitle);
		return "/user/userDetail";
	}

	@GetMapping("/user/{bookId}/order") //注文画面表示
	public String userBookOrder(
			@PathVariable("bookId") Integer id,
			Model model) {
		Book book = bookRepository.findById(id).get();
		List<Library> libraries = libraryRepository.findAll();
		model.addAttribute("bookOrder", book);
		model.addAttribute("library", libraries);
		return "/user/order";
	}

	@PostMapping("/user/{bookId}/order") //注文処理
	public String userBookReserve(
			@PathVariable("bookId") Integer id,
			@RequestParam(name = "userId", defaultValue = "") Integer userId,
			@RequestParam(name = "userPassword", defaultValue = "") String userPassword,
			Model model) {
		List<String> errorList = new ArrayList<>();

		if (userId == null) {
			errorList.add("利用者IDを入力してください");
		}
		if (userPassword.equals("")) {
			errorList.add("パスワードを入力してください");
		}
		List<User> userList = userRepository.findByIdAndPassword(userId, userPassword);
		User user = new User();
		if (userList.size() == 0) {
			errorList.add("利用者IDとパスワードが一致しませんでした");
		} else {
			user = userList.get(0);
			if (user.getLibrary().getId() != account.getLibraryId()) {
				errorList.add("本図書館では登録されていない利用者です");
			}
		}
		Book book = bookRepository.findById(id).get();
		if ((book.getLibrary().getId() == account.getLibraryId()) && (book.getCondition().getId() == 1)) {
			errorList.add("こちらの資料は本図書館で貸出可能です");
		}
		if (errorList.size() > 0) {
			model.addAttribute("error", errorList);
			model.addAttribute("bookOrder", book);
			List<Library> libraries = libraryRepository.findAll();
			model.addAttribute("library", libraries);
			return "/user/order";
		} else {
			user = userList.get(0);
			LocalDate today = LocalDate.now();
			Library bookLibrary = book.getLibrary();
			Library library = libraryRepository.findById(account.getLibraryId()).get();
			Integer conditionId = book.getCondition().getId();
			LocalDate scheduled = null;
			Lending lending = lendingRepository.findFirstByBookIdOrderByIdDesc(book.getId());

			//貸出可能
			if (conditionId == 1) {
				scheduled = today.plusDays(2);
			}
			//貸出不可
			if (conditionId != 1) {
				scheduled = lending.getLimitDate().plusDays(1);
			}
			Status status = new Status();
			if (bookLibrary.getId() == account.getId()) {
				status = statusRepository.findById(1).get();
			}
			if (bookLibrary.getId() != account.getId()) {
				status = statusRepository.findById(3).get();
			}
			Reservation reservation = new Reservation(user, book, today, scheduled, library, status);
			reservationRepository.save(reservation);
			Reservation reserved = reservationRepository.findByUserIdAndBookIdOrderByIdDesc(userId, id).get(0);
			model.addAttribute("reservation", reserved);
			model.addAttribute("bookLibrary", bookLibrary);
			return "/user/orderEnd";
		}

	}
}
