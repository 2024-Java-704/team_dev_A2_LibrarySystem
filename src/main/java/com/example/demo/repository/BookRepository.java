package com.example.demo.repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Book;
import com.example.demo.entity.Category;

public interface BookRepository extends JpaRepository<Book, Integer> {

	List<Book> findByTitleContaining(String title);

	List<Book> findByCategory(Category category);

	List<Book> findByAuthorContaining(String author);

	List<Book> findByPublisherContaining(String publisher);

	List<Book> findByPubYear(LocalDate pubYear);

	List<Book> findAllByOrderByCnt();

	List<Book> findAllByOrderByPubYear();

	List<Book> findAllByOrderByHurigana();

	List<Book> findByCategory(Optional<Category> findById);
}
