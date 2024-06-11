package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.LibraryStaff;

public interface LibraryStaffRepository extends JpaRepository<LibraryStaff, Integer> {

	List<LibraryStaff> findByLibraryId(Integer libraryId);

	List<LibraryStaff> findByEmailAndPassword(String email, String password);

}
