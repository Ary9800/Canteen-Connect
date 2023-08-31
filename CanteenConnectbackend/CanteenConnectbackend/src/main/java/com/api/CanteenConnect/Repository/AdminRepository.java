package com.api.CanteenConnect.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.api.CanteenConnect.Entities.Admin;


public interface AdminRepository extends JpaRepository<Admin, Long> {
//@Query("SELECT a FROM Admin a WHERE a.email = ?")
	Admin findByEmail(String email);

}
