package com.api.CanteenConnect.Iservice;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;


import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.api.CanteenConnect.CustomException.FoodItemCreationException;
import com.api.CanteenConnect.CustomException.FooditemNotFoundException;
import com.api.CanteenConnect.Dto.Fooditemdto;
import com.api.CanteenConnect.Entities.Category;
import com.api.CanteenConnect.Entities.Fooditems;
import com.api.CanteenConnect.Repository.Categoryrepository;
import com.api.CanteenConnect.Repository.fooditemsRepository;
@Service
@Transactional
public class Fooditem implements Ifooditem {
	@Autowired
	private fooditemsRepository fooditemrepo;
	@Autowired
	private ModelMapper mapper;
@Autowired
private Categoryrepository categoryrrepo;
	@Override
	public List<Fooditems> getAllFoodItems() {
		 
	       
	        return fooditemrepo.findAll();
	
	}

    
	@Override
	public Optional<Fooditems> getFoodItembyid(Long id) {
		
		return Optional.of(fooditemrepo.findById(id).orElseThrow(()->new FooditemNotFoundException("fooditemitem not found")));
	}

	@Override
	public String createFoodItem(Fooditemdto foodItem) {
		 Long foodItemId = foodItem.getId(); // Assuming getId() returns the ID from the DTO
		    
		    if (foodItemId != null && fooditemrepo.existsById(foodItemId)) {
		        throw new FoodItemCreationException("Food item with ID " + foodItemId + " already exists.");
		    }
		    
		    try {
		        Fooditems fooditem = mapper.map(foodItem, Fooditems.class);
		        Category category = categoryrrepo.findById(foodItem.getCategoryId())
		                .orElseThrow(() -> new FooditemNotFoundException("Category with ID " + foodItem.getCategoryId() + " not found"));
		        fooditem.setCategory(category);
		        fooditemrepo.save(fooditem);
		        return "fooditem created";
		    } catch (Exception e) {
		        throw new FoodItemCreationException("Failed to create food item: " + e.getMessage());
		    }
		
	}

	@Override
	public String updateFoodItem(Long id, Fooditemdto foodItem) {
		
Fooditems fooditementity= fooditemrepo.findById(id).orElseThrow(()->new FooditemNotFoundException("fooditemitem not found"));
try {
	fooditementity.setPrice(foodItem.getPrice());
	
	fooditemrepo.save(fooditementity);
	return "fooditem updated";
}catch(Exception e) {
	throw new  FooditemNotFoundException("Food item not updated  "+e.getMessage() );
}
	}

	@Override
	public String deleteFoodItem(Long id) {
		if (!fooditemrepo.existsById(id)) {
            throw new FooditemNotFoundException("Food item not found  " );
        }
		fooditemrepo.deleteById(id);
		return "fooditem deleted successfully";
	}


	@Override
	public Object getallfooditem() {
		
		return fooditemrepo.findAll() ;
	}


	@Override
	public List<Fooditems> getallfoodbycategory(Long categoryId) {
		return fooditemrepo.findByCategory_Id(categoryId);
		 
	}


	

}
