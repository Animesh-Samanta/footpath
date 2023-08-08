package com.footpath.online.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.footpath.online.dao.ProductDao;
import com.footpath.online.model.Product;



@RestController
@RequestMapping(path = "/footpath")
public class ProductController {
	@Autowired
	private ProductDao productDao;
	@GetMapping(value="/product")
	public ResponseEntity<List<Product>> getAllProducts() {
      return null;
    }
}
