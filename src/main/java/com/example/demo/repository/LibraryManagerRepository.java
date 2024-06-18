package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.LibraryManager;

public interface LibraryManagerRepository extends JpaRepository<LibraryManager, Integer> {

	List<LibraryManager> findByEmailAndPassword(String email, String password);
}
