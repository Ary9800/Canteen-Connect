package com.api.CanteenConnect.Entities;

import java.time.LocalDate;
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
@Table(name = "Fooditems")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Fooditems extends BaseEntity {

	@Column(name = "Name", length = 20)
	private String name;

	@Column(name = "Price", length = 20)
	
	private String price;
	@Column(name = "ImageUrl", length = 50)
	
	private String imageURL;

	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "Category_id")
	private Category category;
	
	@OneToMany(mappedBy="orderedfoodItem")
@JsonIgnore
	private List<OrderDetails> orderDetails;

	public Fooditems(long id) {
		super.setId(id);
	}
   
	
	
}
