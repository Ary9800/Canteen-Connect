package com.api.CanteenConnect.Entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@Entity
@Table(name = "Payment") 
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Payment extends BaseEntity {
	@Column(name="user")
	private int user;
	@Column(name="orderlist")
	private int orderlist;
	@Column(name="bill")
	private double billamount;
	@Column(name="Date")
	private LocalDate  Date;
	@Enumerated(EnumType.STRING)
	@Column(name="payment")
	private Modeofpayment payment;
	

}
