package com.api.CanteenConnect.Entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "OrderDetails") 
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString

public class OrderDetails extends BaseEntity {
	
	/*
	 * @ManyToMany()
	 * 
	 * @JoinTable(name="order_fooditem", joinColumns
	 * = @JoinColumn(name="order_id"),inverseJoinColumns
	 * =@JoinColumn(name="fooditem_id")) private Set<Fooditems> FoodItems=new
	 * HashSet<>();
	 * 
	 * @Column(name="Quantity") private int Quantity;
	 * 
	 * @Column(name="Rate") private int Rate;
	 * 
	 * @Column(name="totalamount") private double totalamount;
	 */

	@ManyToOne()
	@JsonIgnore
	@JoinColumn(name="foodItemId")
	private Fooditems orderedfoodItem;
	
	@ManyToOne()
	@JoinColumn(name ="orderListId" )
	private Orderlist orderId;
	
	@Column(name="Quantity") 
	private int Quantity;
}
