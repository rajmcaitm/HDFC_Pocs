package com.hdfc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hdfc.entities.Lead;
import com.hdfc.service.LeadService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class LeadController {

	public static final String LEAD_MESSAGE = "**Lead created successfully with Lead id - ";
	public static final String PRE_LEAD_UPDATE = "**Lead id - ";
	public static final String POST_LEAD_UPDATE = " modified successfully";

	@Autowired
	private LeadService leadService;

	@PostMapping("/createLead")
	public ResponseEntity<String> createProduct(@RequestBody Lead lead) {

		Lead leadDetails = leadService.createLead(lead);
		return new ResponseEntity<String>(LEAD_MESSAGE + leadDetails.getId(), HttpStatus.CREATED);
	}
	@GetMapping("/leads")
    public ResponseEntity < List < Lead >> getAllLead() {
        return ResponseEntity.ok().body(leadService.getAllLead());
    }
	
	@GetMapping("/lead/{id}")
    public ResponseEntity<Lead> getLeadById(@PathVariable String id) {
        return ResponseEntity.ok().body(leadService.getLeadById(id));
    }
	
	@PutMapping("/leads/{id}")
    public ResponseEntity<String> updateLead(@PathVariable String id, @RequestBody Lead lead) {
        lead.setId(id);
        Lead leadDetails = this.leadService.updateLead(lead);
        return new ResponseEntity<String>(PRE_LEAD_UPDATE+lead.getId()+POST_LEAD_UPDATE, HttpStatus.OK);
    }
}
