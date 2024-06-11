package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	List<User> findByName(String name);

	List<User> findByIdAndName(Integer userId, String userName);

	List<User> findByIdAndPassword(Integer userId, String password);

}
