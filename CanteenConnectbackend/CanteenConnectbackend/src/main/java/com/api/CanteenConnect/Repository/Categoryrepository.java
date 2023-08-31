package com.api.CanteenConnect.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.CanteenConnect.Entities.*;

public interface Categoryrepository extends JpaRepository<Category,Long> {

	 

}
