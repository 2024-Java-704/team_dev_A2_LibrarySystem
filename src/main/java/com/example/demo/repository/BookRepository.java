package com.example.demo.repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entity.Book;
import com.example.demo.entity.Category;

public interface BookRepository extends JpaRepository<Book, Integer> {

	//タイトルあいまい検索
	List<Book> findByTitleContaining(String title);

	List<Book> findByCategory(Category category);

	List<Book> findByAuthorContaining(String author);

	List<Book> findByPublisherContaining(String publisher);

	List<Book> findByPubYear(LocalDate pubYear);

	List<Book> findAllByOrderByCnt();

	List<Book> findAllByOrderByPubYear();

	List<Book> findAllByOrderByHurigana();

	List<Book> findByCategory(Optional<Category> findById);

	List<Book> findByHuriganaContaining(String keyword);

	List<Book> findByIdAndCategoryId(Integer bookId, Integer categoryId);

	@Query("SELECT b FROM Book b WHERE " +
			"(:title IS NULL OR b.title LIKE %:title%) AND " +
			"(:categoryId IS NULL OR b.category.id = :categoryId) AND " +
			"(:author IS NULL OR b.author LIKE %:author%) AND " +
			"(:publisher IS NULL OR b.publisher LIKE %:publisher%) AND " +
			"(:pubYear IS NULL OR b.pubYear = :pubYear)")
	List<Book> searchBooks(@Param("title") String title,
			@Param("categoryId") Integer categoryId,
			@Param("author") String author,
			@Param("publisher") String publisher,
			@Param("pubYear") LocalDate pubYear);

}
