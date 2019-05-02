package com.web.carpool.model.SharedModels;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotEmpty;

import lombok.Data;

@Embeddable
@Data
public class Account {
	@Column(name = "username")
	@NotEmpty(message = "Username cannot be empty")
	private String username;

	@Column(name = "password")
	@NotEmpty(message = "Password cannot be empty")
	private String password;
	
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
}
