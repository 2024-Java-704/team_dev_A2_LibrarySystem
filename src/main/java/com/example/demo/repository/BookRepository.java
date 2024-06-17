package com.example.demo.repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Book;
import com.example.demo.entity.Category;

public interface BookRepository extends JpaRepository<Book, Integer> {

	// タイトルあいまい検索
	List<Book> findByTitleContaining(String title);

	List<Book> findByCategory(Category category);

	List<Book> findByAuthorContaining(String author);

	List<Book> findByPublisherContaining(String publisher);

	List<Book> findByPubYear(LocalDate pubYear);

	List<Book> findAllByOrderByCnt();

	List<Book> findByLibraryIdOrderByCntDesc(Integer libraryId);

	List<Book> findAllByOrderByPubYear();

	List<Book> findByLibraryIdOrderByPubYear(Integer libraryId);

	List<Book> findAllByOrderByHurigana();

	List<Book> findByLibraryIdOrderByHurigana(Integer libraryId);

	List<Book> findByCategory(Optional<Category> findById);

	List<Book> findByHuriganaContaining(String keyword);

	List<Book> findByIdAndCategoryId(Integer bookId, Integer categoryId);

	// ここから追加分
	List<Book> findByTitleNotContaining(String title);

	List<Book> findByAuthorNotContaining(String author);

	List<Book> findByPublisherNotContaining(String publisher);

	List<Book> findByCategoryNotIn(List<Category> categories); // 修正点

	List<Book> findByPubYearNotIn(List<LocalDate> pubYears);

	List<Book> findByLibraryId(Integer libraryId);

}
