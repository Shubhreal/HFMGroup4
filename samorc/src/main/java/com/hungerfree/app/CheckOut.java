package com.hungerfree.app;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name = "checkout")
public class CheckOut implements Serializable {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(unique = true)
	private String firstName;
	private String lastName;
	private String email;
	private String phoneNumber;
	private String foodType;
	private String quantity;
	private String address;
	private String measure;
	
	public CheckOut() {
		super();
		
	}
	public CheckOut(long id, String firstName, String lastName, String email, String phoneNumber, String foodType,
			String quantity, String address, String measure) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.foodType = foodType;
		this.quantity = quantity;
		this.address = address;
		this.measure = measure;
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
	public String getFoodType() {
		return foodType;
	}
	public void setFoodType(String foodType) {
		this.foodType = foodType;
	}
	public String getQuantity() {
		return quantity;
	}
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getMeasure() {
		return measure;
	}
	public void setMeasure(String measure) {
		this.measure = measure;
	}
	@Override
	public String toString() {
		return "CheckOut [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", phoneNumber=" + phoneNumber + ", foodType=" + foodType + ", quantity=" + quantity + ", address="
				+ address + ", measure=" + measure + "]";
	}
	
	
}