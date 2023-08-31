package com.api.CanteenConnect.Dto;

import java.util.Date;
import java.util.Set;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import com.api.CanteenConnect.Entities.Fooditems;
import com.api.CanteenConnect.Entities.Orderlist;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Orderdetaildto {
	private Long id;
	 @NotNull(message = "Ordered food item ID is required")
	    private  Fooditems orderedfoodItemId;

	    @NotNull(message = "Order ID is required")
	    private Orderlist  orderId;

	    @Min(value = 1, message = "Quantity must be at least 1")
	    private int quantity;

    
}
