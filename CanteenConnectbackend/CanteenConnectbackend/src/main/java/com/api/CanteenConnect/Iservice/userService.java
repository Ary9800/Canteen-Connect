package com.api.CanteenConnect.Iservice;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.stereotype.Service;

import com.api.CanteenConnect.Dto.Userdto;
import com.api.CanteenConnect.model.LoginModel;

@Service
@Transactional
public interface userService {

	 Object signup(@Valid Userdto user);

	Object loginuser(LoginModel credential); 
	
		
	
	

}
