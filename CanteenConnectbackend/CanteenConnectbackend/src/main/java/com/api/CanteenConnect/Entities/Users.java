package com.api.CanteenConnect.Entities;

import java.time.LocalDate;
import java.util.ArrayList;
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
@Table(name = "Users")

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString(exclude = "password")

public class Users extends BaseEntity {

	@Column(name = "First_name", length = 20)
	private String FirstName;

	@Column(name = "Last_name", length = 20)
	private String LastName;

	@Column(name = "Email", length = 20, unique = true, nullable = true)
	private String email;

	@Column(name = "Password", length = 20, nullable = true)
	private String Password;

	@Column(name = "Question", length = 20)
	private String Question;

	@Column(name = "Answer", length = 20)
	private String Answer;

	@JsonIgnore
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Orderlist> order1;
	

	    public void addOrderlist(Orderlist orderlist) {
	        orderlist.setUser(this);
	        order1.add(orderlist);
	    }

	    public void removeOrderlist(Orderlist orderlist) {
	        orderlist.setUser(null);
	        order1.remove(orderlist);
	    }
	

	public Users(long id) {
		super.setId(id);;
	}
	
	
	

}


