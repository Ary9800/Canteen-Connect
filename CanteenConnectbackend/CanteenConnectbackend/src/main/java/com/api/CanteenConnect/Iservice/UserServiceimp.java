package com.api.CanteenConnect.Iservice;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.CanteenConnect.CustomException.OrderNotFoundException;
import com.api.CanteenConnect.Dto.Userdto;
import com.api.CanteenConnect.Entities.Admin;
import com.api.CanteenConnect.Entities.Users;
import com.api.CanteenConnect.Repository.UserRepository;
import com.api.CanteenConnect.model.LoginModel;
@Service
@Transactional
public class UserServiceimp implements userService {
@Autowired
private ModelMapper mapper;
@Autowired
private UserRepository userrepo;
	@Override
	public Object signup(@Valid Userdto user) {
		try {
		Users user1=mapper.map(user, Users.class);
		System.out.println(user1);
		return userrepo.save(user1);
	
	}catch(Exception e) {
		throw new OrderNotFoundException("user not added"+e);
	}

}
	@Override
	public Object loginuser(LoginModel credential) {
		String email=credential.getUsername();
		System.out.println(email);
		String password=credential.getPassword();
		Users usercredential=userrepo.findByEmail(email);
		System.out.println(usercredential);
		if(usercredential.getPassword().equals(password)) {
			return usercredential;
		}
		else {
		throw new OrderNotFoundException("password incorrect");	
		}
	
	}}
