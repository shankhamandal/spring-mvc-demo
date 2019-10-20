package com.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class User {

	@Id
	@Column(name = "username")
	@NotNull(message = "Username cannot be null")
	private String username;

	@Column(name = "password")
	@NotNull(message = "Password cannot be null")
	private String password;

	@Column(name = "firstName")
	@NotNull(message = "First Name cannot be null")
	private String firstName;

	@Column(name = "lastName")
	@NotNull(message = "Last Name cannot be null")
	private String lastName;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password + ", firstName=" + firstName + ", lastName="
				+ lastName + "]";
	}

}
