package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;


@Entity
@Table(name = "user")
public class User {
	
	@Id //主キー
	@GeneratedValue(strategy = GenerationType.IDENTITY) //自動採番
	private Integer id;
	
	private String name;
	private String address;
	private String email;
	private String tel;
	private String password;
	
	User(){
	}
	
	User(Integer id, String name, String address, String email, String tel, String password){
		this.id = id;
		this.name = name;
		this.address = address;
		this.email = email;
		this.tel = tel;
		this.password = password;
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
	
}
