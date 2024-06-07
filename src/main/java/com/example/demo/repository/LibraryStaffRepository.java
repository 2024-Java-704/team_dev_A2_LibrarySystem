package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.LibraryStaff;

public interface LibraryStaffRepository extends JpaRepository<LibraryStaff, Integer> {

}
