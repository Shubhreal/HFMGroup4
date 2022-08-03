package com.hungerfree.app;

import java.io.Serializable;


import javax.persistence.*;

@Entity
@Table(name = "signin")
public class Signin implements Serializable{
	@Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	//@Column(unique = true)
	private String email;
	private String password;
	
	public Signin() {
		super();
	}
	public Signin(String email, String password) {
		super();
		this.email = email;
		this.password = password;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
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
	@Override
	public String toString() {
		return "Signin [id=" + id + ", email=" + email + ", password=" + password + "]";
	}
	
	
	
	
}
