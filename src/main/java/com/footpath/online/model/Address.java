package com.footpath.online.model;

public class Address {
private String city;
private Long pin;
private String fullAddress;
public String getCity() {
	return city;
}
public void setCity(String city) {
	this.city = city;
}
public Long getPin() {
	return pin;
}
public void setPin(Long pin) {
	this.pin = pin;
}
public String getFullAddress() {
	return fullAddress;
}
public void setFullAddress(String fullAddress) {
	this.fullAddress = fullAddress;
}
@Override
public String toString() {
	return "Address [city=" + city + ", pin=" + pin + ", fullAddress=" + fullAddress + "]";
}

}
