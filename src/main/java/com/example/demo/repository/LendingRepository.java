package com.example.demo.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Lending;

public interface LendingRepository extends JpaRepository<Lending, Integer> {

	List<Lending> findByUserId(Integer userId);

	//延滞者用のクエリ文
	//	@Query(value="SELECT * FROM lending "
	//			+ "WHERE limit_date < :today", nativeQuery=true)
	//	List<Lending> lateList(@Param("today") LocalDate today);

	List<Lending> findByLimitDateBefore(LocalDate today);

	Lending findFirstByBookIdOrderByIdDesc(Integer bookId);

	//	@Query(value="SELECT * FROM lending "
	//				+ "WHERE limit_date < :today", nativeQuery=true)
	//	Lending lending(@Param("today") LocalDate today);
}
