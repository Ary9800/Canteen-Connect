package com.api.CanteenConnect.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.CanteenConnect.Entities.Fooditems;

public interface fooditemsRepository extends JpaRepository<Fooditems,Long> {
	Optional<Fooditems> findById(Long id);

	List<Fooditems> findByCategory_Id(Long categoryid);

	
}
