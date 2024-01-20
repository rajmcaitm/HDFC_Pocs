package com.hdfc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hdfc.entities.Lead;

public interface LeadRepositoty extends JpaRepository<Lead, String> {

}
