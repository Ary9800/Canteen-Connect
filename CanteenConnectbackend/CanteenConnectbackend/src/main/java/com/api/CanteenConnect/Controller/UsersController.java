package com.api.CanteenConnect.Controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.CanteenConnect.Dto.Admindto;
import com.api.CanteenConnect.Dto.Order1dto;
import com.api.CanteenConnect.Dto.Paymentdto;
import com.api.CanteenConnect.Dto.Userdto;
import com.api.CanteenConnect.Iservice.Icategory;
import com.api.CanteenConnect.Iservice.Ifooditem;
import com.api.CanteenConnect.Iservice.Iorderlist;
import com.api.CanteenConnect.Iservice.Ipayment;
import com.api.CanteenConnect.Iservice.userService;
import com.api.CanteenConnect.model.LoginModel;
import com.api.CanteenConnect.model.OrderModel;



@RestController
@RequestMapping("/customer")
@CrossOrigin(origins = "*")
public class UsersController {
	@Autowired
private Ifooditem fooditemservice;
	@Autowired
	private Icategory categoryservice;
	@Autowired
private Iorderlist orderservice;
	@Autowired
	private userService  userservice;
	 @PostMapping("/signup") 
	 public ResponseEntity<?>signupuser(@Valid @RequestBody Userdto user){
	 System.out.println(user);
	 { return ResponseEntity.status(HttpStatus.ACCEPTED).body( userservice.signup(user)) ;
	 }
	 }
	 
	 
	 
  @PostMapping("/login")
  public ResponseEntity<?> loginUser(@RequestBody LoginModel credential  ) {
System.out.println(credential);
  return ResponseEntity.status(HttpStatus.OK).body(userservice.loginuser(credential));
  }
			  
			  

	@Autowired
	private Ipayment paymentservice;
	public UsersController() {
		System.out.println("in customer controller");
	}
	@GetMapping("/category")
	public ResponseEntity<?> getallcategory(){
		return ResponseEntity.status(HttpStatus.FOUND).body(categoryservice.getallcategory());
	}
	@GetMapping("/{id}/category1")
	public ResponseEntity<?> getcategorybyid(@PathVariable Long id){
		return ResponseEntity.status(HttpStatus.FOUND).body(categoryservice.getcategorybyid(id));}
	@GetMapping("/food-items")
    public ResponseEntity<?> viewFoodItems() {
       
        return ResponseEntity.status(HttpStatus.OK).body( fooditemservice.getAllFoodItems());
    }
	@GetMapping("/{fooditemid}/food-itemsid")
    public ResponseEntity<?> viewFoodItems(@PathVariable Long fooditemid) {
        return ResponseEntity.status(HttpStatus.FOUND).body(fooditemservice.getFoodItembyid(fooditemid));
    }
	@PostMapping("/place-order")
	 public ResponseEntity<?> placeOrder(@Valid @RequestBody OrderModel order1) {
		System.err.println(order1);
        //orderservice.placeOrder(order1);
        return ResponseEntity.status(HttpStatus.CREATED).body(orderservice.placeOrder(order1));
    }
	 @GetMapping("/{customerId}/orders")
	    public  ResponseEntity<?>  viewOrderHistory(@PathVariable Long customerId) {
	        return ResponseEntity.status(HttpStatus.FOUND).body(orderservice.getOrdersByCustomerId(customerId));
	    }
	 @PutMapping("/{orderid}/feedbacks")
	    public ResponseEntity<?> writeFeedback(@PathVariable Long orderid,@Valid @RequestBody Order1dto order1) {
	       
	        return  ResponseEntity.status(HttpStatus.CREATED).body( orderservice.createFeedback(orderid,order1));
	    }
	 @PostMapping("/{customerId}/payments")
	    public ResponseEntity<?> makePayment(
	            @PathVariable Long customerId,
	            @Valid @RequestBody Paymentdto payment
	    ) {
	        
	        return  ResponseEntity.status(HttpStatus.CREATED).body(paymentservice.processPayment(payment));
	    }
	
}
