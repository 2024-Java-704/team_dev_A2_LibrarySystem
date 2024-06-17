package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Library;
import com.example.demo.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	List<User> findByName(String name);

	List<User> findByIdAndName(Integer userId, String userName);

	List<User> findByIdAndPassword(Integer userId, String password);

	List<User> findByLibrary(Library library);

	List<User> findByLibraryIdAndNameContaining(Integer libraryId, String name);

	List<User> findByIdAndLibraryId(Integer userId, Integer libraryId);

	List<User> findByIdAndLibraryIdAndNameContaining(Integer id, Integer libraryId, String name);

}
