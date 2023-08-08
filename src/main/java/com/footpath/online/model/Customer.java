package com.footpath.online.model;

import java.util.List;

public class Customer {
private String name;
private String email;
private String password;
private List<Address> addresses;
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
public List<Address> getAddresses() {
	return addresses;
}
public void setAddresses(List<Address> addresses) {
	this.addresses = addresses;
}
@Override
public String toString() {
	return "User [name=" + name + ", email=" + email + ", password=" + password + ", addresses=" + addresses + "]";
}

}
