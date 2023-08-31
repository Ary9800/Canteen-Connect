package com.api.CanteenConnect.Iservice;

import javax.validation.Valid;

import com.api.CanteenConnect.Dto.Admindto;
import com.api.CanteenConnect.model.LoginModel;

public interface AdminService {
    

	Object signup(@Valid Admindto admin);

	Object loginadmin(LoginModel credential);


}

