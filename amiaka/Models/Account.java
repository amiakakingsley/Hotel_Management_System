package com.amiaka.Models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Account {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(unique = true)
	private String username;
	private double balance = 0.0;
	
	@OneToOne(mappedBy = "account")
	private ApplicationUser users;
	
	public Account() {}

	public Account(String username, double balance, ApplicationUser users) {
		super();
		this.username = username;
		this.balance = balance;
		this.users = users;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public ApplicationUser getUsers() {
		return users;
	}

	public void setUsers(ApplicationUser users) {
		this.users = users;
	}

	@Override
	public String toString() {
		return "Account [id=" + id + ", username=" + username + ", balance=" + balance + ", users=" + users + "]";
	}

	
}
