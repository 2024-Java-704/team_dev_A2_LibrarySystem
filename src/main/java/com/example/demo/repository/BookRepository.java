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

	// タイトルあいまい検索
	List<Book> findByTitleIdOrderByLibraryId(Integer titleId);
	
	List<Book> findByCategory(Category category);
	
	List<Book> findByLibraryIdAndTitleContaining(Integer libraryId,String title);
	
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

	List<Book> deleteByLibraryId(Integer Id);
	
	List<Book> findByTitleId(Integer titleId);
	
	@Query(value="select distinct on (title_id) * from book where library_id = :libraryId", nativeQuery=true)
	List<Book> showBook(@Param("libraryId")Integer libraryId);
	
	List<Book> findByLibraryIdAndHuriganaContaining(Integer libraryId,String key);
	

}
