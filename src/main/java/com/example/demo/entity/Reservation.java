package com.example.demo.entity;



import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "reservation")
public class Reservation {
	//フィールド
	@Id //主キー
	@GeneratedValue(strategy = GenerationType.IDENTITY) //自動採番
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;
	
	@ManyToOne
	@JoinColumn(name = "book_id")
	private Book book;
	
	@Column(name = "reservation_date")
	private LocalDate reservationDate;
	
	@Column(name = "scheduled_date")
	private LocalDate scheduledDate;
	
	@ManyToOne
	@JoinColumn(name = "library_id")
	private Library library;
	
	@ManyToOne
	@JoinColumn(name = "status_id")
	private Status status;
	
	Reservation(){	
	}
	Reservation(User user, Book book){
		this.user = user;
		this.book = book;
	}
	Reservation(Integer id, User user, Book book, LocalDate reservationDate, LocalDate scheduledDate, Library library, Status status){
		this.id = id;
		this.user = user;
		this.book = book;
		this.reservationDate = reservationDate;
		this.scheduledDate = scheduledDate;
		this.library = library;
		this.status = status;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	public LocalDate getReservationDate() {
		return reservationDate;
	}
	public void setReservationDate(LocalDate reservationDate) {
		this.reservationDate = reservationDate;
	}
	public LocalDate getScheduledDate() {
		return scheduledDate;
	}
	public void setScheduledDate(LocalDate scheduledDate) {
		this.scheduledDate = scheduledDate;
	}
	public Library getLibrary() {
		return library;
	}
	public void setLibrary(Library library) {
		this.library = library;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	
}
