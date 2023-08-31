package com.api.CanteenConnect.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.api.CanteenConnect.Iservice.Ifooditem;

@RestController
@CrossOrigin(origins = "*")
public class CategoryController {
public CategoryController() {
	
}
@Autowired
private Ifooditem fooditemservice;

@GetMapping("/category/{categoryId}")
public ResponseEntity<?> getallfoodbycategory(@PathVariable Long categoryId){
	return ResponseEntity.status(HttpStatus.OK).body(fooditemservice.getallfoodbycategory(categoryId));
}}
