package com.api.CanteenConnect.Controller;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.CanteenConnect.Dto.Admindto;
import com.api.CanteenConnect.Dto.Categorydto;
import com.api.CanteenConnect.Dto.Fooditemdto;
import com.api.CanteenConnect.Entities.Admin;
import com.api.CanteenConnect.Entities.Orderlist;

import com.api.CanteenConnect.Iservice.AdminService;

import com.api.CanteenConnect.Iservice.Icategory;
import com.api.CanteenConnect.Iservice.Ifooditem;
import com.api.CanteenConnect.Iservice.Iorderlist;
import com.api.CanteenConnect.Repository.AdminRepository;
import com.api.CanteenConnect.model.LoginModel;

@RestController
@RequestMapping("/admin")
@CrossOrigin(origins = "*")
public class AdminController {
public  AdminController() {}
@Autowired
private Ifooditem fooditemservice;
@Autowired
private Iorderlist orderservice;
@Autowired
private Icategory categoryservice;


@Autowired
private AdminService adminService;


  @PostMapping("/signup") public ResponseEntity<?>signupadmin(@Valid @RequestBody Admindto
  admin){ return ResponseEntity.status(HttpStatus.ACCEPTED).body( adminService.signup(admin)); }
  @PostMapping("/login")
  public ResponseEntity<?> loginAdmin(@RequestBody LoginModel credential  ) {
     
 
     
      return ResponseEntity.status(HttpStatus.FOUND).body(adminService.loginadmin(credential));
  }
@GetMapping("/fooditem")
public ResponseEntity<?> getallfooditem(){
	return ResponseEntity.status(HttpStatus.FOUND).body(fooditemservice.getallfooditem());
}
@GetMapping("/{id}/fooditembyid")
public ResponseEntity<?> getfooditembyid(@PathVariable Long id){
	return ResponseEntity.status(HttpStatus.FOUND).body(fooditemservice.getFoodItembyid(id));}


@PostMapping("/food-items")
public ResponseEntity<?> addFoodItem(@Valid @RequestBody Fooditemdto foodItem) {
	System.out.println(foodItem);
    
    return  ResponseEntity.status(HttpStatus.CREATED).body( fooditemservice.createFoodItem(foodItem));
}
@PutMapping("/food-items/{id}")
public ResponseEntity<?> updateFoodItem(@Valid @PathVariable Long id,@Valid @RequestBody Fooditemdto foodItem) {
   
    return  ResponseEntity.status(HttpStatus.ACCEPTED).body( fooditemservice.updateFoodItem(id, foodItem));
}
@DeleteMapping("/food-items/{id}")
public ResponseEntity<?> deleteFoodItem(@PathVariable Long id) {
   
    return  ResponseEntity.status(HttpStatus.NO_CONTENT).body( fooditemservice.deleteFoodItem(id));
}
@GetMapping("/category")
public ResponseEntity<?> getallcategory(){
	return ResponseEntity.status(HttpStatus.OK).body(categoryservice.getallcategory());
}
@GetMapping("/{id}/category1")
public ResponseEntity<?> getcategorybyid(@PathVariable Long id){
	return ResponseEntity.status(HttpStatus.FOUND).body(categoryservice.getcategorybyid(id));}
@PostMapping("/addcategory")
public ResponseEntity<?> addCategory(@Valid @RequestBody Categorydto category1) {
	
    return  ResponseEntity.status(HttpStatus.CREATED).body(categoryservice.createCategory(category1));
}
@PutMapping("/Category/{Cid}")
public ResponseEntity<?> updateCategory(@PathVariable Long Cid,@Valid  @RequestBody Categorydto category1) {
	
    return  ResponseEntity.status(HttpStatus.NO_CONTENT).body(categoryservice.updateCategory(Cid, category1));
}
@DeleteMapping("/Category/{id}")
public ResponseEntity<?> deleteCategory(@PathVariable Long id) {
	categoryservice.deleteCategory(id);
    return ResponseEntity.status(HttpStatus.NO_CONTENT).body(categoryservice.deleteCategory(id));
}

@GetMapping("/orders/{orderId}/feedback")
public ResponseEntity<?> checkOrderFeedback(@PathVariable Long orderId) {
    java.util.Optional<Orderlist> feedback = orderservice.getFeedbackByOrderId(orderId);
    if (feedback != null) {
        return ResponseEntity.ok(feedback);
    } else {
        return ResponseEntity.notFound().build();
    }
}






}
