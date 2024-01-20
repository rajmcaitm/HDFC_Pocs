package com.hdfc.service;

import java.util.List;

import com.hdfc.entities.Lead;

public interface LeadService {

	Lead createLead(Lead lead);

	List<Lead> getAllLead();

	Lead getLeadById(String id);

	Lead updateLead(Lead lead);

}