package com.api.CanteenConnect.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.CanteenConnect.Entities.Users;

public interface UserRepository extends JpaRepository<Users, Long> {

	Users findByEmail(String email);

}
