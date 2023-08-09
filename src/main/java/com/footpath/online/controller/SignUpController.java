package com.footpath.online.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.footpath.online.RequiredAnnotation;
import com.footpath.online.model.Customer;
import com.footpath.online.service.SignUpService;

import jakarta.validation.Valid;

@RestController
@RequestMapping(path = "/footpath")
public class SignUpController {
	@Autowired
	private SignUpService signUpService;
	@Autowired
	private RequiredAnnotation requiredA;
	
	
@PostMapping(value="/signup")
public ResponseEntity<?> signUp(@Valid @RequestBody Customer customer) {
	if(signUpService.insertNewUser(customer)) {
	return new ResponseEntity<>(requiredA.messageSource.getMessage("USER_CREATED", null, null, null), HttpStatus.CREATED);
	}
	else {
		return new ResponseEntity<>(requiredA.messageSource.getMessage("USER_EXIST", null, null, null), HttpStatus.NOT_ACCEPTABLE);
	}
	
}
@PostMapping(value="/signupidcard")
public ResponseEntity<?> signUpUsingIdCard(@Valid @RequestPart("customer") Customer customer,@RequestPart("file") List<MultipartFile> files) {
	if(signUpService.insertNewUser(customer)) {
	return new ResponseEntity<>(requiredA.messageSource.getMessage("USER_CREATED", null, null, null), HttpStatus.CREATED);
	}
	else {
		return new ResponseEntity<>(requiredA.messageSource.getMessage("USER_EXIST", null, null, null), HttpStatus.NOT_ACCEPTABLE);
	}
	
}
}
