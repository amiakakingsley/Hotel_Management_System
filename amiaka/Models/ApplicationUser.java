package com.amiaka.Models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "user")
public class ApplicationUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
    
    private String firstname;
    private String Lastname;
    @Column(unique = true)
    private String email;
    private String password;
    
    private String role;
    
    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "user_details ", joinColumns = {@JoinColumn(name = "USER_NAME",
	referencedColumnName ="ID")}, inverseJoinColumns = {@JoinColumn(name = "ACCOUNT_ID",
	referencedColumnName ="ID")})
    private Account account;
    
    
    public ApplicationUser(){}

    
	
	public ApplicationUser(String firstname, String lastname, String email, String password, String role,
			Account account) {
		super();
		
		this.firstname = firstname;
		Lastname = lastname;
		this.email = email;
		this.password = password;
		this.role = role;
		this.account = account;
	}



	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return Lastname;
	}

	public void setLastname(String lastname) {
		Lastname = lastname;
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

	
	
	public String getRole() {
		return role;
	}



	public void setRole(String role) {
		this.role = role;
	}



	public Account getAccount() {
		return account;
	}



	public void setAccount(Account account) {
		this.account = account;
	}



	@Override
	public String toString() {
		return "ApplicationUser [id=" + id + ", firstname=" + firstname + ", Lastname=" + Lastname + ", email=" + email
				+ ", password=" + password + ", role=" + role + ", account=" + account + "]";
	}
    
    
}
