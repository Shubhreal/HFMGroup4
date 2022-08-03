package com.hungerfree.app;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.*;

@Entity
@Table(name = "mediator")
public class Mediator implements Serializable {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(unique = true)
	private String firstName;
	private String lastName;
	private String email;
	private String phoneNumber;
	private String alternatephoneNumber;
	private Date dob;
	private String address1;
	private String address2;
	
	public Mediator() {
		super();
		
	}
	public Mediator(long id, String firstName, String lastName, String email, String phoneNumber,
			String alternatephoneNumber, Date dob, String address1, String address2) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.alternatephoneNumber = alternatephoneNumber;
		this.dob = dob;
		this.address1 = address1;
		this.address2 = address2;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getAlternatephoneNumber() {
		return alternatephoneNumber;
	}
	public void setAlternatephoneNumber(String alternatephoneNumber) {
		this.alternatephoneNumber = alternatephoneNumber;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public String getAddress1() {
		return address1;
	}
	public void setAddress1(String address1) {
		this.address1 = address1;
	}
	public String getAddress2() {
		return address2;
	}
	public void setAddress2(String address2) {
		this.address2 = address2;
	}
	@Override
	public String toString() {
		return "Mediator [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", phoneNumber=" + phoneNumber + ", alternatephoneNumber=" + alternatephoneNumber + ", dob=" + dob
				+ ", address1=" + address1 + ", address2=" + address2 + "]";
	}
	
}