package com.api.CanteenConnect.Iservice;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.CanteenConnect.CustomException.CategorymNotFoundException;
import com.api.CanteenConnect.CustomException.FoodItemCreationException;
import com.api.CanteenConnect.Dto.Categorydto;
import com.api.CanteenConnect.Entities.Category;

import com.api.CanteenConnect.Entities.Fooditems;
import com.api.CanteenConnect.Repository.Categoryrepository;
@Service
@Transactional
public class Categoryimp implements Icategory {
	@Autowired
	private Categoryrepository categoryrepo;
	@Autowired
	private ModelMapper mapper;
	@Override
	public String createCategory(Categorydto category1) {
Long Categoryid = category1.getId(); // Assuming getId() returns the ID from the DTO
	    
	    if (Categoryid != null && categoryrepo.existsById(Categoryid)) {
	        throw new CategorymNotFoundException("Category with ID " + Categoryid + " already exists.");
	    }
	    
	    try {
	    	String msg="category added";
			Category category=mapper.map(category1,Category.class);
			categoryrepo.save(category);
			 return msg;
	    } catch (Exception e) {
	        throw new CategorymNotFoundException("Failed to create Category: " + e.getMessage());
	    }
		

	}

	@Override
	public String updateCategory(Long id, Categorydto category1) {
		 Category  Categoryentity=categoryrepo .findById(id).orElseThrow(()->new CategorymNotFoundException ("Category not found"));
		try {
			Categoryentity.setCategoryName(category1.getCategoryName());
			categoryrepo.save(Categoryentity);
			return "category updated successfully";
		}catch(Exception e) {
			throw  new CategorymNotFoundException ("Category not added"+e.getMessage());
		}

	}

	@Override
	public String deleteCategory(Long id) {
		if (!categoryrepo.existsById(id)) {
            throw new CategorymNotFoundException("Category not found  " );
        }
		categoryrepo.deleteById(id);
		return "deleted successfully";

	}

	@Override
	public Object getallcategory() {
		
		return categoryrepo.findAll();
	}

	@Override
	public Category getcategorybyid(Long id) {
		return  categoryrepo.findById(id).orElseThrow(()->new CategorymNotFoundException ("Category not found"));
		
	}

	

}
