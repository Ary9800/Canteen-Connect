package com.api.CanteenConnect.Iservice;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;

import com.api.CanteenConnect.Dto.Fooditemdto;

import com.api.CanteenConnect.Entities.Fooditems;

public interface Ifooditem {

	List<Fooditems> getAllFoodItems();

	Optional<Fooditems> getFoodItembyid(Long fooditemid);

	String createFoodItem(Fooditemdto foodItem);

	String updateFoodItem(Long id, Fooditemdto foodItem);

	String deleteFoodItem(Long id);

	Object getallfooditem();

	List<Fooditems> getallfoodbycategory(Long categoryId);

	

	

}
