package com.example.demo.controller.user;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.Book;
import com.example.demo.entity.Category;
import com.example.demo.repository.BookRepository;
import com.example.demo.repository.CategoryRepository;

@Controller
public class SearchBookController {

	@Autowired
	BookRepository bookRepository;

	@Autowired
	CategoryRepository categoryRepository;

	@PostMapping("/user/userDetailSearch") //検索処理・検索結果表示
	public String search(
			@RequestParam(name = "title", defaultValue = "") String title,
			@RequestParam(name = "category", defaultValue = "") String categoryNum,
			@RequestParam(name = "author", defaultValue = "") String author,
			@RequestParam(name = "publisher", defaultValue = "") String publisher,
			@RequestParam(name = "publishDay", defaultValue = "") LocalDate publishDay,
			@RequestParam(name = "sort", defaultValue = "") String sort,
			Model model) {

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
				bookList.addAll(bookRepository.findByTitleContaining(key));
			}
		} else {
			// タイトルがない場合、全件取得
			if (sort.equals("jporder")) {
				bookList.addAll(bookRepository.findAllByOrderByHurigana());

			} else {
				bookList.addAll(bookRepository.findAll());
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
		model.addAttribute("taitle", title);
		model.addAttribute("categoryNum", categoryNum);
		model.addAttribute("author", author);
		model.addAttribute("publisher", publisher);
		model.addAttribute("publishDay", publishDay);
		model.addAttribute("books", bookTitles);
		return "/user/userSearch";
	}

}
