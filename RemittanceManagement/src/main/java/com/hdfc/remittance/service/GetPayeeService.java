package com.hdfc.remittance.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hdfc.remittance.dto.PayeeDetailsList;
import com.hdfc.remittance.dto.PayeeDetailsResponse;
import com.hdfc.remittance.entity.PayeeDetails;
import com.hdfc.remittance.repository.GetPayeeRepository;

@Service
public class GetPayeeService {
	@Autowired
	GetPayeeRepository getPayeeRepository;
	

	public List<PayeeDetailsList> findAllPayeeByCustomer(Long custId) {
		PayeeDetailsList pdr = new PayeeDetailsList();
		List<PayeeDetails> payeeDetails = getPayeeRepository.findAllPayeeByCustId(custId);
		List<PayeeDetailsList> lpdr =new ArrayList<>();
		for(PayeeDetails ps:payeeDetails) {
			pdr.setNickName(ps.getNickName());
			pdr.setAccountNumber(ps.getAccountNumber());
			pdr.setSwiftCode(ps.getSwiftCode());
			pdr.setCity(ps.getCity());
			pdr.setCountry(ps.getCountry());
		    lpdr.add(new PayeeDetailsList(ps.getNickName(),ps.getAccountNumber(),ps.getSwiftCode(),ps.getCity(),ps.getCountry()));
			
		}
		return lpdr;

	}
}
