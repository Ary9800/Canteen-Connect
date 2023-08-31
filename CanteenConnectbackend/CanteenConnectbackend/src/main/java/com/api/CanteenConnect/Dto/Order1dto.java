package com.api.CanteenConnect.Dto;

import java.time.LocalDate;
import java.util.Date;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

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
public class Order1dto {

	private Long id;
    @Min(value = 0, message = "Bill amount must be a non-negative number")
    private int billAmount;

    @NotNull(message = "Date and time is required")
    private Date dateAndTime;
    @DecimalMin(value = "0.0", inclusive = false, message = "Discount must be greater than 0")
    private float discount;

    @NotNull(message = "User ID is required")
    private Long userId;
    @NotNull(message = "Status is required")
    private String status;
    
    private Orderdetaildto orderDetails;
   
    @Size(max = 20, message = "Feedback must be at most 20 characters")
    private String feedback;
    
}
