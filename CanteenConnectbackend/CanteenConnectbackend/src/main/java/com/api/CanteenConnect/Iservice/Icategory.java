package com.api.CanteenConnect.Iservice;

import com.api.CanteenConnect.Dto.Categorydto;
import com.api.CanteenConnect.Entities.Category;

public interface Icategory {

	String createCategory(Categorydto category1);

	String updateCategory(Long id, Categorydto category1);

	String deleteCategory(Long id);

	Object getallcategory();
	Category getcategorybyid(Long id);

	


	

}
