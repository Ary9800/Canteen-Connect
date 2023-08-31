package com.api.CanteenConnect.Entities;



import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@Entity
@Table(name = "Orderlist") 
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Orderlist  extends BaseEntity {
//	
 
	@Column(name = "BillAmount")
	private int BillAmount;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "Dateandtime")
	private Date dateandtime;
	
	@Column(name = "Discount", length=20)
	private float Discount;
	
	@Column(name = "Status", length = 20)
	private String Status;
	
	@OneToMany(mappedBy  ="orderId")
	private List<OrderDetails> Odetail;
	
	@Column(name="feedback", length=20)
	private String feedback;

	@ManyToOne
    @JoinColumn(name = "user_id")
    private Users user;

	public Orderlist(int billAmount, float discount,String status, String feedback, Users user) {
		super();
		BillAmount = billAmount;
		this.dateandtime = new Date(System. currentTimeMillis()) ;
		Discount = discount;
		Status = status;
		this.feedback = feedback;
		this.user = user;
	}
	
    

}
