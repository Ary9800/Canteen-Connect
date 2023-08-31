package com.api.CanteenConnect.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.CanteenConnect.Entities.OrderDetails;

public interface OrderdetailRepo extends JpaRepository<OrderDetails, Long> {

}
