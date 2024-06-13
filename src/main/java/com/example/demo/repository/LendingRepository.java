package com.example.demo.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Lending;

public interface LendingRepository extends JpaRepository<Lending, Integer> {

	List<Lending> findByUserId(Integer userId);

	List<Lending> findByLimitDateBefore(LocalDate today);

	Lending findFirstByBookIdOrderByIdDesc(Integer bookId);

	List<Lending> findByReturnedDateIsNull();

	//	@Query(value = "SELECT * FROM lending "
	//			+ "WHERE returned_date IS NULL", nativeQuery = true)
	//	List<Integer> findByReturnedDateIsNull;
}
