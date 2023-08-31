package com.api.CanteenConnect.model;

import java.util.List;

import com.api.CanteenConnect.Entities.OrderDetails;
import com.api.CanteenConnect.Entities.Orderlist;
import com.api.CanteenConnect.Entities.Users;

public class OrderModel {

 private	int userId;
 private String feedback;
 private int billAmount;
 private int discout;
 private String status;
 List<Integer> item;

 List<Integer> quantity;
 
 //get OrderDetails
 public  Orderlist getOrderDetails() {
	 return new Orderlist(billAmount, discout, status, feedback, new Users(userId));
 }

 
 
 public String getStatus() {
	return status;
}



public void setStatus(String status) {
	this.status = status;
}



public int getBillAmount() {
	return billAmount;
}


public void setBillAmount(int billAmount) {
	this.billAmount = billAmount;
}


public int getDiscout() {
	return discout;
}


public void setDiscout(int discout) {
	this.discout = discout;
}


public int getUserId() {
	return userId;
}
public void setUserId(int userId) {
	this.userId = userId;
}
public String getFeedback() {
	return feedback;
}
public void setFeedback(String feedback) {
	this.feedback = feedback;
}
public List<Integer> getItem() {
	return item;
}
public void setItem(List<Integer> item) {
	this.item = item;
}
public List<Integer> getQuantity() {
	return quantity;
}
public void setQuantity(List<Integer> quantity) {
	this.quantity = quantity;
}



@Override
public String toString() {
	return "OrderModel [userId=" + userId + ", feedback=" + feedback + ", billAmount=" + billAmount + ", discout="
			+ discout + ", status=" + status + ", item=" + item + ", quantity=" + quantity + "]";
}
 

}
