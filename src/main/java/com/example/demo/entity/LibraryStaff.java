package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "library_staff")
public class LibraryStaff {

	//フィールド
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@ManyToOne
	@JoinColumn(name = "library_id")
	private Library library;
	private String name;
	private String email;
	private String password;

	//コンストラクタ
	public LibraryStaff() {
	}

	public LibraryStaff(Library library, String name, String email, String password) {
		this.library = library;
		this.name = name;
		this.email = email;
		this.password = password;
	}

	public LibraryStaff(Integer id, Library library, String name, String email, String password) {
		this.id = id;
		this.library = library;
		this.name = name;
		this.email = email;
		this.password = password;
	}

	//アクセッサー
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Library getLibrary() {
		return library;
	}

	public void setLibrary(Library library) {
		this.library = library;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
