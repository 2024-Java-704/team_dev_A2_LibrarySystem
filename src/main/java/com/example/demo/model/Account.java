
package com.example.demo.model;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

@Component
@SessionScope
public class Account {

	private Integer id;

	private String name;

	private Integer libraryId;

	private String libraryName;

	public Account() {
	}

	public Account(Integer id, String name, Integer libraryId) {
		this.id = id;
		this.name = name;
		this.libraryId = libraryId;
	}

	public Account(Integer id, String name, Integer libraryId, String libraryName) {
		this.id = id;
		this.name = name;
		this.libraryId = libraryId;
		this.libraryName = libraryName;
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

	public Integer getLibraryId() {
		return libraryId;
	}

	public void setLibraryId(Integer libraryId) {
		this.libraryId = libraryId;
	}

	public String getLibraryName() {
		return libraryName;
	}

	public void setLibraryName(String libraryName) {
		this.libraryName = libraryName;
	}

}
