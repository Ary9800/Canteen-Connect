package com.api.CanteenConnect.Iservice;

import com.api.CanteenConnect.Dto.Paymentdto;
import com.api.CanteenConnect.Entities.Payment;

public interface Ipayment {

	String processPayment(Paymentdto payment);

	
}
