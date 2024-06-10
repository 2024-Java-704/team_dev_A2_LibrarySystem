package com.example.demo.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;


@Entity
@Table(name="book")
public class Book {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name="category_id")
	private Category category;
	private String title;
	private String hurigana;
	private String author;
	private String publisher;
	private LocalDate pubYear;
	private LocalDate regDay;
	
	@ManyToOne
	@JoinColumn(name="library_id")
	private Library library;
	
	@ManyToOne
	@JoinColumn(name="condition_id")
	private Condition condition;
	
	public Book() {
		
	}
	
	public Book(Category category,String title,String hurigana,String author,String publisher,LocalDate pubYear,LocalDate regDay,Library library,Condition condition) {
		this.category=category;
		this.title=title;
		this.hurigana=hurigana;
		this.author=author;
		this.publisher=publisher;
		this.pubYear=pubYear;
		this.regDay=regDay;
		this.library=library;
		this.condition=condition;
	}
	
	
	private Integer cnt;
	private String img;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Category getCategories() {
		return category;
	}
	public void setCategories(Category category) {
		this.category = category;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getHurigana() {
		return hurigana;
	}
	public void setHurigana(String hurigana) {
		this.hurigana = hurigana;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public LocalDate getPubYear() {
		return pubYear;
	}
	public void setPubYear(LocalDate pubYear) {
		this.pubYear = pubYear;
	}
	public LocalDate getRegDay() {
		return regDay;
	}
	public void setRegDay(LocalDate regDay) {
		this.regDay = regDay;
	}
	public Library getLibrary() {
		return library;
	}
	public void setLibrary(Library library) {
		this.library = library;
	}
	public Condition getCondition() {
		return condition;
	}
	public void setCondition(Condition condition) {
		this.condition = condition;
	}
	public Integer getCnt() {
		return cnt;
	}
	public void setCnt(Integer cnt) {
		this.cnt = cnt;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	
	
	
	
	
}
