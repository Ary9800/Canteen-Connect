package com.api.CanteenConnect.Iservice;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.CanteenConnect.CustomException.OrderNotFoundException;
import com.api.CanteenConnect.Dto.Admindto;
import com.api.CanteenConnect.Entities.Admin;
import com.api.CanteenConnect.Repository.AdminRepository;
import com.api.CanteenConnect.model.LoginModel;

@Service
@Transactional
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminRepository adminRepository;
    @Autowired
private ModelMapper mapper;


	@Override
	public Object signup(@Valid Admindto admin) {
	Admin admin1=mapper.map(admin, Admin.class);
	
		return adminRepository.save(admin1);
	}


	@Override
	public Object loginadmin(LoginModel credential) {
		String email=credential.getUsername();
		System.out.println(email);
		String password=credential.getPassword();
		System.out.println(password);
		Admin admincredential=adminRepository.findByEmail(email);
		System.out.println(admincredential);
		
		if (admincredential != null && admincredential.getPassword() != null && admincredential.getPassword().equals(password)) {
	        return admincredential;
		}
		else {
		throw new OrderNotFoundException("password incorrect");	
		}
		
	}

 
   
}
