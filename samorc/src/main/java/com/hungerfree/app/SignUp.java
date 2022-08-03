package com.hungerfree.app;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "signup")
public class SignUp implements Serializable{
	@Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(unique = true)
	private String name;
	private String email;
	private String password;
	private String repeatPassword;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
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
	public String getRepeatPassword() {
		return repeatPassword;
	}
	public void setRepeatPassword(String repeatPassword) {
		this.repeatPassword = repeatPassword;
	}
	public SignUp(long id, String name, String email, String password, String repeatPassword) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
		this.repeatPassword = repeatPassword;
	}
	public SignUp() {
		super();
		
	}
	@Override
	public String toString() {
		return "SignUp [id=" + id + ", name=" + name + ", email=" + email + ", password=" + password
				+ ", repeatPassword=" + repeatPassword + "]";
	}
	
}