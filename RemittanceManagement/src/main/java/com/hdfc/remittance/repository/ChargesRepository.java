package com.hdfc.remittance.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hdfc.remittance.entity.ChargesDetails;

public interface ChargesRepository extends JpaRepository<ChargesDetails, Long> {

}
