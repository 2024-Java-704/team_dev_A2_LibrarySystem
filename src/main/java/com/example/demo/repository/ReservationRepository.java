package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Reservation;
import com.example.demo.entity.Status;

public interface ReservationRepository extends JpaRepository<Reservation, Integer> {

	List<Reservation> findByUserIdAndBookIdOrderByIdDesc(Integer userId, Integer bookId);

	List<Reservation> findByStatus(Status Status);

	List<Reservation> findByBookIdAndLibraryIdAndStatus(Integer bookId, Integer libraryId, Status status);

	List<Reservation> findByBookIdAndLibraryId(Integer bookId, Integer libraryId);

	List<Reservation> findByBookIdNotAndLibraryId(Integer bookId, Integer libraryId);

	List<Reservation> findByBookIdAndLibraryIdNot(Integer bookId, Integer libraryId);

	List<Reservation> findByBookIdOrLibraryId(Integer bookId, Integer libraryId);

	
	List<Reservation> findByUserId(Integer userId);


	List<Reservation> deleteByLibraryId(Integer Id);

	List<Reservation> findByLibraryId(Integer libraryId);

}
