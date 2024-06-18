package com.example.demo.controller.user;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.Book;
import com.example.demo.entity.Category;
import com.example.demo.model.Account;
import com.example.demo.repository.BookRepository;
import com.example.demo.repository.CategoryRepository;

import jakarta.servlet.http.HttpSession;

@Controller
public class SearchBookController {

	@Autowired
	BookRepository bookRepository;

	@Autowired
	CategoryRepository categoryRepository;
	
	@Autowired
	Account account;

	@PostMapping("/user/userDetailSearch") //検索処理・検索結果表示
	public String search(
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
				bookList.addAll(bookRepository.showBook(account.getLibraryId()));
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
		Set <Integer> titleIds=new HashSet<Integer>();
		for(Book book:bookList) {
			titleIds.add(book.getTitleId());
		}
		List<Book> bookTitles=new ArrayList<>();
		for(Integer titleId:titleIds) {
			bookTitles.add(bookRepository.findByTitleId(titleId).get(0));
		}
		
		/*List<Book> bookTitles = new ArrayList<>(new HashSet<>(books));*/
		
		// 検索結果をセッションに保存
		session.setAttribute("searchResults", bookTitles);

		// 書籍IDリストをカンマ区切りの文字列に変換してモデルに追加
		String bookIds = bookTitles.stream()
				.map(book -> book.getId().toString())
				.collect(Collectors.joining(","));
		model.addAttribute("bookIds", bookIds);

		model.addAttribute("books", bookTitles);
		return "/user/userSearch";
	}

	// 50音順に並べ替え
	@GetMapping("/user/userDetailSearch/jporder")
	public String jporder(HttpSession session, Model model) {
		// セッションから検索結果を取得
		@SuppressWarnings("unchecked")
		List<Book> bookTitles = (List<Book>) session.getAttribute("searchResults");

		if (bookTitles == null || bookTitles.isEmpty()) {
			model.addAttribute("books", new ArrayList<Book>());
			return "/user/userSearch";
		}

		bookTitles = bookTitles.stream()
				.sorted(Comparator.comparing(Book::getHurigana))
				.collect(Collectors.toList());

		model.addAttribute("books", bookTitles);
		return "/user/userSearch";

	}

	// 人気順に並べ替え
	@GetMapping("/user/userDetailSearch/popularity")
	public String popularity(HttpSession session, Model model) {
		// セッションから検索結果を取得
		@SuppressWarnings("unchecked")
		List<Book> bookTitles = (List<Book>) session.getAttribute("searchResults");

		if (bookTitles == null || bookTitles.isEmpty()) {
			model.addAttribute("books", new ArrayList<Book>());
			return "/user/userSearch";
		}

		bookTitles = bookTitles.stream()
				.sorted(Comparator.comparing(Book::getCnt).reversed())
				.collect(Collectors.toList());

		model.addAttribute("books", bookTitles);
		return "/user/userSearch";
	}

	// 出版日順に並べ替え
	@GetMapping("/user/userDetailSearch/pubYear")
	public String pubYear(HttpSession session, Model model) {
		// セッションから検索結果を取得
		@SuppressWarnings("unchecked")
		List<Book> bookTitles = (List<Book>) session.getAttribute("searchResults");

		if (bookTitles == null || bookTitles.isEmpty()) {
			model.addAttribute("books", new ArrayList<Book>());
			return "/user/userSearch";
		}

		bookTitles = bookTitles.stream()
				.sorted(Comparator.comparing(Book::getPubYear))
				.collect(Collectors.toList());

		model.addAttribute("books", bookTitles);
		return "/user/userSearch";
	}

}
