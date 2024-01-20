package com.hdfc.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hdfc.dto.CheckerCustomerDetails;
import com.hdfc.dto.CustomerDetails;
import com.hdfc.service.CustomerDetailsService;

@RestController
@RequestMapping("api")
public class GetCustDetailsController {

	@Autowired
	private CustomerDetailsService custDetailsService;

	@GetMapping("/checker1/{refNo}")
	public ResponseEntity<?> getChecker1CustomerDetails(@PathVariable Long refNo) {

		CustomerDetails custDetails = custDetailsService.getCustomerDetails(refNo);
		return new ResponseEntity<>(custDetails, HttpStatus.OK);
	}
	
	@GetMapping("/checker2/{refNo}")
	public ResponseEntity<?> getChecker2CustomerDetails(@PathVariable Long refNo) {

		CheckerCustomerDetails checkerCustDetails = custDetailsService.getCheckerCustomerDetails(refNo);
		return new ResponseEntity<>(checkerCustDetails, HttpStatus.OK);
	}

}
