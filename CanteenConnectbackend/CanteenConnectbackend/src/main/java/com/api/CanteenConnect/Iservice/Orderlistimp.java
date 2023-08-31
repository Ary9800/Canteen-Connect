package com.api.CanteenConnect.Iservice;

import java.util.Optional;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.CanteenConnect.CustomException.FeedbackNotCreatedException;
import com.api.CanteenConnect.CustomException.OrderNotFoundException;
import com.api.CanteenConnect.Dto.Order1dto;
import com.api.CanteenConnect.Entities.Fooditems;
import com.api.CanteenConnect.Entities.OrderDetails;
import com.api.CanteenConnect.Entities.Orderlist;
import com.api.CanteenConnect.Repository.OrderdetailRepo;
import com.api.CanteenConnect.Repository.OrderlistRepository;
import com.api.CanteenConnect.model.OrderModel;
@Service
@Transactional
public class Orderlistimp implements Iorderlist {
	@Autowired
	private OrderlistRepository orderrepo;
	@Autowired
    private OrderdetailRepo orderDetailsRepo;
	@Autowired
	private ModelMapper mapper;
	@Override
	public String placeOrder(OrderModel order1) {
		// orderList
	Orderlist orderlistSaved=	orderrepo.save(order1.getOrderDetails());
	System.err.println("ash: "+orderlistSaved.getId());
	// save orderdetails 
	for(int i=0;i<order1.getItem().size();i++) {
		System.err.println(orderlistSaved.getId());
		orderDetailsRepo.save(new OrderDetails(new Fooditems(order1.getItem().get(i)), orderlistSaved, order1.getQuantity().get(i)));
	}
	
	return "success";
	}

	@Override
	public Optional<Orderlist> getOrdersByCustomerId(Long customerId) {
		
		return Optional.of(orderrepo.findById(customerId).orElseThrow(() -> new OrderNotFoundException("Orders not found for customer with id: " + customerId)));
	}

	@Override
	public Optional<Orderlist> getFeedbackByOrderId(Long orderId) {
		
		return Optional.of(orderrepo.findById(orderId) .orElseThrow(() -> new FeedbackNotCreatedException("Feedback not found for order with id: " + orderId)));
	}

	@Override
	public String createFeedback(Long orderid, Order1dto order1) {
		Orderlist order2=orderrepo.findById(orderid).orElseThrow(() -> new OrderNotFoundException("Orders not found "));
		try {
			order2.setFeedback(order1.getFeedback());
			orderrepo.save(order2);
			return "feedback added";
		}catch(Exception e) {
			throw new   FeedbackNotCreatedException("feedback not added"+e.getMessage());
		}
		
	}

}
