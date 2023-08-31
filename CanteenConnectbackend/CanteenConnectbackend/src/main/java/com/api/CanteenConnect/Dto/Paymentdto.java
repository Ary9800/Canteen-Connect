package com.api.CanteenConnect.Dto;

import java.time.LocalDate;
import java.util.Date;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;

import com.api.CanteenConnect.Entities.Modeofpayment;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Paymentdto {
	   private Long id;
	   @Min(value = 1, message = "User ID should be at least 1")
	    private int userId;

	    @Min(value = 1, message = "Order list ID should be at least 1")
	    private int orderlistId;

	    private double billAmount;

	    @PastOrPresent(message = "Date should be in the past or present")
	    private LocalDate date;

	    @NotNull(message = "Payment mode is required")
	    private Modeofpayment payment;
}
