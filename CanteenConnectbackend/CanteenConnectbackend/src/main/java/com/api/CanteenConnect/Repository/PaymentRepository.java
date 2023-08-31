package com.api.CanteenConnect.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.CanteenConnect.Entities.*;

public interface PaymentRepository extends JpaRepository<Payment,Long> {

}
