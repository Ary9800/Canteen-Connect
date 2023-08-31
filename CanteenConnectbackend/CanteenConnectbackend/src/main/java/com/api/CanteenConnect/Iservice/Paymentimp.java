package com.api.CanteenConnect.Iservice;


import javax.transaction.Transactional;

import org.springframework.stereotype.Service;


import com.api.CanteenConnect.Dto.Paymentdto;
import com.api.CanteenConnect.Entities.Payment;
@Service
@Transactional
public class Paymentimp implements Ipayment {

	@Override
	public String processPayment(Paymentdto payment) {
return null;

	}

}
