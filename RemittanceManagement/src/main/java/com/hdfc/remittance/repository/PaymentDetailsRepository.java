package com.hdfc.remittance.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hdfc.remittance.entity.RemittencePaymentDetails;

public interface PaymentDetailsRepository extends JpaRepository<RemittencePaymentDetails, Long> {

}
