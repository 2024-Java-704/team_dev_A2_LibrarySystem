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
@Table(name = "lending")
public class Lending {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // 自動採番
	private Integer id;
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;
	@ManyToOne
	@JoinColumn(name = "book_id")
	private Book book;
	@Column(name = "lend_date")
	private LocalDate lendDate;
	@Column(name = "limit_date")
	private LocalDate limitDate;
	@Column(name = "returned_date")
	private LocalDate returnedDate;
	@ManyToOne
	@JoinColumn(name = "reservation_id")
	private Reservation reservation;
	@ManyToOne
	@JoinColumn(name = "staff_id")
	private LibraryStaff staff;

	public Lending() {

	}

	public Lending(User user, Book book) {
		this.user = user;
		this.book = book;
	}

	public Lending(User user, Book book, LocalDate lendDate, LocalDate limitDate, Reservation reservation,
			LibraryStaff staff) {
		this.user = user;
		this.book = book;
		this.lendDate = lendDate;
		this.limitDate = limitDate;
		this.reservation = reservation;
		this.staff = staff;

	}

	public Lending(User user, Book book, LocalDate lendDate, LocalDate limitDate, LibraryStaff staff) {
		this.user = user;
		this.book = book;
		this.lendDate = lendDate;
		this.limitDate = limitDate;
		this.reservation = null;
		this.staff = staff;

	}

	public Lending(Integer id, User user, Book book, LocalDate lendDate, LocalDate limitDate,
			Reservation reservation,
			LibraryStaff staff) {
		this.id = id;
		this.user = user;
		this.book = book;
		this.lendDate = lendDate;
		this.limitDate = limitDate;
		this.reservation = reservation;
		this.staff = staff;

	}

	public Lending(Integer id, User user, Book book, LocalDate lendDate, LocalDate limitDate, LibraryStaff staff) {
		this.id = id;
		this.user = user;
		this.book = book;
		this.lendDate = lendDate;
		this.limitDate = limitDate;
		this.reservation = null;
		this.returnedDate = null;
		this.staff = staff;

	}

	public Lending(Integer id, User user, Book book, LocalDate lendDate, LocalDate limitDate, LocalDate returnedDate,
			LibraryStaff staff) {
		this.id = id;
		this.user = user;
		this.book = book;
		this.lendDate = lendDate;
		this.limitDate = limitDate;
		this.returnedDate = returnedDate;
		this.reservation = null;
		this.staff = staff;

	}

	public Lending(Integer id, User user, Book book, LocalDate lendDate, LocalDate limitDate, LocalDate returnedDate,
			Reservation reservation, LibraryStaff staff) {
		this.id = id;
		this.user = user;
		this.book = book;
		this.lendDate = lendDate;
		this.limitDate = limitDate;
		this.returnedDate = returnedDate;
		this.reservation = reservation;
		this.staff = staff;
	}

	public Lending(LocalDate lendDate, LocalDate limitDate) {
		this.lendDate = lendDate;
		this.limitDate = limitDate;
	}

	public Integer getId() {
		return id;
	}

	public User getUser() {
		return user;
	}

	public Book getBook() {
		return book;
	}

	public LocalDate getLendDate() {
		return lendDate;
	}

	public LocalDate getLimitDate() {
		return limitDate;
	}

	public LocalDate getReturnedDate() {
		return returnedDate;
	}

	public Reservation getReservation() {
		return reservation;
	}

	public LibraryStaff getStaff() {
		return staff;
	}

	// 返却期限を超えているかどうかを返す
	public boolean getOverLimit() {
		LocalDate nowDate = LocalDate.now();
		return nowDate.compareTo(limitDate) > 0 && returnedDate == null;
	}
}
