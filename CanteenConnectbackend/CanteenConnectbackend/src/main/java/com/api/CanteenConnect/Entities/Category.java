package com.api.CanteenConnect.Entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@Entity
@Table(name = "Category") 
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Category extends BaseEntity {
	@Column(name = "CategoryName", length = 20,nullable=true)
	private String categoryName;
	@Column(name = "description", length = 50)
	private String description;
	@OneToMany(mappedBy = "category",  fetch=FetchType.EAGER,	cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Fooditems> fooditem;
	public void addFooditem(Fooditems fooditem) {
        fooditem.setCategory(this);
        this.fooditem.add(fooditem);
    }

    public void removeFooditem(Fooditems fooditem) {
        fooditem.setCategory(null);
        this.fooditem.remove(fooditem);
    }
}
