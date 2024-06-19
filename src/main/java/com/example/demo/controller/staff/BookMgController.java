package com.example.demo.controller.staff;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.Book;
import com.example.demo.entity.Category;
import com.example.demo.entity.Condition;
import com.example.demo.entity.Library;
import com.example.demo.model.Account;
import com.example.demo.repository.BookRepository;
import com.example.demo.repository.CategoryRepository;
import com.example.demo.repository.ConditionRepository;
import com.example.demo.repository.LibraryRepository;
import com.example.demo.repository.ReservationRepository;

import jakarta.servlet.http.HttpSession;

@Controller
public class BookMgController {
	@Autowired
	BookRepository bookRepository;

	@Autowired
	CategoryRepository categoryRepository;

	@Autowired
	ReservationRepository reservationRepository;

	@Autowired
	LibraryRepository libraryRepository;

	@Autowired
	ConditionRepository conditionRepository;

	@Autowired
	Account account;

	@GetMapping("/staff/materialMg/bookList")
	public String index(Model model) {
		return "/staff/bookList";
	}

	@PostMapping("/staff/staffDetailSearch") //検索処理・検索結果表示
	public String searchBook(
			@RequestParam(name = "title", defaultValue = "") String title,
			@RequestParam(name = "category", defaultValue = "") String categoryNum,
			@RequestParam(name = "author", defaultValue = "") String author,
			@RequestParam(name = "publisher", defaultValue = "") String publisher,
			@RequestParam(name = "publishDay", defaultValue = "") LocalDate publishDay,
			@RequestParam(name = "sort", defaultValue = "") String sort,
			Model model,
			HttpSession session) {

		List<Book> bookList = new ArrayList<>();

		// タイトルがある場合
		if (!title.isEmpty()) {
			String[] keywords;
			if (title.contains("\s")) { // 半角スペース対応
				keywords = title.split("\s");
			} else if (title.contains("　")) { // 全角スペース対応
				keywords = title.split("　");
			} else { // スペースがない場合
				keywords = new String[] { title }; // 配列にタイトルを入れる
			}

			for (String key : keywords) {
				bookList.addAll(bookRepository.findByLibraryIdAndTitleContaining(account.getLibraryId(),key));
			}
		} else {
			// タイトルがない場合、全件取得
			if (sort.equals("jporder")) {
				bookList.addAll(bookRepository.findByLibraryIdOrderByHurigana(account.getLibraryId()));

			} else {
				bookList.addAll(bookRepository.findByLibraryIdOrderById(account.getLibraryId()));
			}

		}
		// タイトル以外の条件で絞り込み
		if (!categoryNum.isEmpty()) {
			Category category = categoryRepository.findByCategoryNum(categoryNum);
			if (category != null) {
				bookList = bookList.stream()
						.filter(book -> book.getCategory().equals(category))
						.collect(Collectors.toList());
			}
		}
		if (!author.isEmpty()) {
			bookList = bookList.stream()
					.filter(book -> book.getAuthor().contains(author))
					.collect(Collectors.toList());
		}

		if (!publisher.isEmpty()) {
			bookList = bookList.stream()
					.filter(book -> book.getPublisher().contains(publisher))
					.collect(Collectors.toList());
		}
		if (publishDay != null) {
			bookList = bookList.stream()
					.filter(book -> book.getPubYear().equals(publishDay))
					.collect(Collectors.toList());
		}

		// 重複を削除
		List<Book> bookTitles = new ArrayList<>(new HashSet<>(bookList));

		// 検索結果をセッションに保存
		session.setAttribute("searchResults", bookTitles);

		// 書籍IDリストをカンマ区切りの文字列に変換してモデルに追加
		String bookIds = bookTitles.stream()
				.map(book -> book.getId().toString())
				.collect(Collectors.joining(","));
		model.addAttribute("bookIds", bookIds);
		model.addAttribute("bookList", bookTitles);
		return "/staff/bookList";
	}

	// 50音順に並べ替え
	@GetMapping("/staff/staffDetailSearch/jporder")
	public String jporderBook(HttpSession session, Model model) {
		// セッションから検索結果を取得
		@SuppressWarnings("unchecked")
		List<Book> bookTitles = (List<Book>) session.getAttribute("searchResults");

		if (bookTitles == null || bookTitles.isEmpty()) {
			model.addAttribute("bookList", new ArrayList<Book>());
			return "/staff/bookList";
		}

		bookTitles = bookTitles.stream()
				.sorted(Comparator.comparing(Book::getHurigana))
				.collect(Collectors.toList());

		model.addAttribute("bookList", bookTitles);
		return "/staff/bookList";

	}

	// 人気順に並べ替え
	@GetMapping("/staff/staffDetailSearch/popularity")
	public String popularityBook(HttpSession session, Model model) {
		// セッションから検索結果を取得
		@SuppressWarnings("unchecked")
		List<Book> bookTitles = (List<Book>) session.getAttribute("searchResults");

		if (bookTitles == null || bookTitles.isEmpty()) {
			model.addAttribute("bookList", new ArrayList<Book>());
			return "/staff/bookList";
		}

		bookTitles = bookTitles.stream()
				.sorted(Comparator.comparing(Book::getCnt).reversed())
				.collect(Collectors.toList());

		model.addAttribute("bookList", bookTitles);
		return "/staff/bookList";
	}

	// 出版日順に並べ替え
	@GetMapping("/staff/staffDetailSearch/pubYear")
	public String pubYearBook(HttpSession session, Model model) {
		// セッションから検索結果を取得
		@SuppressWarnings("unchecked")
		List<Book> bookTitles = (List<Book>) session.getAttribute("searchResults");

		if (bookTitles == null || bookTitles.isEmpty()) {
			model.addAttribute("bookList", new ArrayList<Book>());
			return "/staff/bookList";
		}

		bookTitles = bookTitles.stream()
				.sorted(Comparator.comparing(Book::getPubYear))
				.collect(Collectors.toList());

		model.addAttribute("bookList", bookTitles);
		return "/staff/bookList";
	}
	
	
	
	
	@PostMapping("/staff/materialMg/add")
	public String materialAdd(@RequestParam("category") Integer categoryId,
			@RequestParam("title") String title,
			@RequestParam("hurigana") String hurigana,
			@RequestParam("author") String author,
			@RequestParam("publisher") String publisher,
			@RequestParam("pubYear") LocalDate pubYear,
			@RequestParam("img") String img,
			Model model) {

		Category category = categoryRepository.findById(categoryId).get();
		Library library = libraryRepository.findById(account.getLibraryId()).get();
		Condition condition = conditionRepository.findById(1).get();
		Integer cnt = 0;

		Book book = new Book(category, title, hurigana, author, publisher, pubYear, library, condition, cnt,
				img);
		bookRepository.save(book);
		return "redirect:/staff/materialMg/bookList";
	}

	@GetMapping("/staff/materialMg/create")
	public String create(Model model) {
		Library library = libraryRepository.findById(account.getLibraryId()).get();
		List<Category> category = categoryRepository.findAll();
		model.addAttribute("library", library);
		model.addAttribute("category", category);
		return "/staff/bookAdd";
	}

	@GetMapping("/staff/materialMg/{id}/edit")
	public String edit(@PathVariable("id") Integer id, Model model) {
		Book book = bookRepository.findById(id).get();
		List<Category> category = categoryRepository.findAll();
		List<Condition> condition = conditionRepository.findAll();
		model.addAttribute("book", book);
		model.addAttribute("category", category);
		model.addAttribute("condition", condition);
		return "/staff/bookEdit";
	}

	@PostMapping("/staff/materialMg/{id}/edit")
	public String update(
			@PathVariable("id") Integer id,
			@RequestParam("category") Integer categoryId,
			@RequestParam("title") String title,
			@RequestParam("hurigana") String hurigana,
			@RequestParam("author") String author,
			@RequestParam("publisher") String publisher,
			@RequestParam("pubYear") LocalDate pubYear,
			@RequestParam("regDay") LocalDate regDay,
			@RequestParam("condition") Integer conditionId,
			@RequestParam("cnt") Integer cnt,
			@RequestParam(name = "img", defaultValue = "") String img,
			Model model) {

		Category category = categoryRepository.findById(categoryId).get();
		Library library = libraryRepository.findById(account.getLibraryId()).get();
		Condition condition = conditionRepository.findById(conditionId).get();

		Book book = new Book(id, category, title, hurigana, author, publisher, pubYear, regDay, library, condition,
				cnt, img);
		bookRepository.save(book);
		return "redirect:/staff/materialMg/bookList";

	}

	@PostMapping("/staff/materialMg/{id}/bookDelete")
	public String delete(
			@PathVariable("id") Integer id, Model model) {
		bookRepository.deleteById(id);
		return "redirect:/staff/materialMg/bookList";
	}

}
