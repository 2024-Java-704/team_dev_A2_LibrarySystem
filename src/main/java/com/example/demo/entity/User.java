package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "users")
public class User {

	@Id //主キー
	@GeneratedValue(strategy = GenerationType.IDENTITY) //自動採番
	private Integer id;

	private String name;
	private String address;
	private String email;
	private String tel;
	private String password;
	@ManyToOne
	@JoinColumn(name = "library_id")
	private Library library;

	public User() {
	}

	public User(String name, String address, String email, String tel, String password,Library library) {
		this.name = name;
		this.address = address;
		this.email = email;
		this.tel = tel;
		this.password = password;
		this.library=library;
	}

	public User(Integer id, String name, String address, String email, String tel, String password) {
		this.id = id;
		this.name = name;
		this.address = address;
		this.email = email;
		this.tel = tel;
		this.password = password;
	}

	public User(Integer id, String name, String address, String email, String tel, String password, Library library) {
		this.id = id;
		this.name = name;
		this.address = address;
		this.email = email;
		this.tel = tel;
		this.password = password;
		this.library = library;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Library getLibrary() {
		return library;
	}

	public void setLibrary(Library library) {
		this.library = library;
	}
}
