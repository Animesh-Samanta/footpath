package com.footpath.online.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.footpath.online.model.Customer;
import com.footpath.online.service.SignUpService;

@RestController
@RequestMapping(path = "/footpath")
public class SignUpController {
	@Autowired
	private SignUpService signUpService;
	
	
	
@PostMapping(value="/signup")
public ResponseEntity<?> signUp(@RequestBody Customer customer) {
	if(signUpService.insertNewUser(customer)) {
	return new ResponseEntity<>("User registered Successfully!", HttpStatus.CREATED);
	}
	else {
		return new ResponseEntity<>("User already registered with this email!", HttpStatus.NOT_ACCEPTABLE);
	}
}
}
