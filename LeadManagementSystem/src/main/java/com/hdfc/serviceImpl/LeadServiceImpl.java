package com.hdfc.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hdfc.entities.Lead;
import com.hdfc.exception.ResourceNotFoundException;
import com.hdfc.repository.LeadRepositoty;
import com.hdfc.service.LeadService;

@Service
public class LeadServiceImpl implements LeadService {

	@Autowired
	private LeadRepositoty leadRepository;

	@Override
	public Lead createLead(Lead lead) {
		lead.setProcessingStatus("Created");
		return leadRepository.save(lead);
	}
	
	@Override
    public List<Lead> getAllLead() {
        return this.leadRepository.findAll();
    }

	 @Override
	    public Lead getLeadById(String id) {

	        Optional<Lead> leadDb = this.leadRepository.findById(id);

	        if (leadDb.isPresent()) {
	            return leadDb.get();
	        } else {
	            throw new ResourceNotFoundException("Record not found with id : " + id);
	        }
	    }
	 
	 @Override
	    public Lead updateLead(Lead lead) {
	        Optional<Lead > leadDb = this.leadRepository.findById(lead.getId());

	        if (leadDb.isPresent()) {
	            Lead leadUpdate = leadDb.get();
	            leadUpdate.setId(lead.getId());
	            leadUpdate.setCustId(lead.getCustId());
	            leadUpdate.setCustMobileNo(lead.getCustMobileNo());
	            leadUpdate.setCustName(lead.getCustName());
	            leadUpdate.setCustEmailId(lead.getCustEmailId());
	            leadUpdate.setCustAccountNo(lead.getCustAccountNo());
	            leadUpdate.setCustLeadType(lead.getCustLeadType());
	            leadUpdate.setCustLeadsubType(lead.getCustLeadsubType());
	            leadUpdate.setCustBranchId(lead.getCustBranchId());
	            leadUpdate.setCustBranchName(lead.getCustBranchName());
	            leadRepository.save(leadUpdate);
	            return leadUpdate;
	        } else {
	            throw new ResourceNotFoundException("Record not found with id : " + lead.getId());
	        }
	    }
}
