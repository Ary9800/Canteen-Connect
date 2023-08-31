package com.api.CanteenConnect.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

public class LoginModel {
	
	@NotNull
private String email;
	@NotNull
private String password;
public LoginModel(String email, @NotNull String password) {
	super();
	this.email = email;
	this.password = password;
}
public String getUsername() {
	return email;
}
public void setUsername(String email) {
	this.email = email;
}
public String getPassword() {
	return password;
}
public void setPassword(@NotNull String password) {
	this.password = password;
}
@Override
public String toString() {
	return "Adminmodel [email=" + email + ", password=" + password + "]";
}
}
