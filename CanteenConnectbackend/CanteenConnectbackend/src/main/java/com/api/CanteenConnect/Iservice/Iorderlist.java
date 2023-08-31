package com.api.CanteenConnect.Iservice;

import java.util.Optional;

import javax.validation.Valid;

import com.api.CanteenConnect.Dto.Order1dto;
import com.api.CanteenConnect.Entities.Orderlist;
import com.api.CanteenConnect.model.OrderModel;

public interface Iorderlist {

	String placeOrder(@Valid OrderModel order1);

	Optional<Orderlist> getOrdersByCustomerId(Long customerId);

	Optional<Orderlist> getFeedbackByOrderId(Long orderId);

	Object createFeedback(Long orderid, Order1dto order1);

}
