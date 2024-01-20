
package com.hdfc.Controller;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hdfc.dto.LeadLoanResponse;
import com.hdfc.dto.LoanDiscrepancyDetailsResponse;
import com.hdfc.entities.AllDetailsResponse;
import com.hdfc.entities.LoanDetails;
import com.hdfc.entities.NewCaseResponse;
import com.hdfc.service.LoanService;

@RestController
public class LoanController {

	@Autowired
	LoanService loanService;

	@GetMapping("/loan/{id}")
	public ResponseEntity<?> getLoanDetials(@PathVariable("id") Long id) {
		LoanDetails loanDetails = loanService.getLoanDetails(id);
		System.out.println("admin+++++++++++" + loanDetails);
		return new ResponseEntity<>(loanDetails, HttpStatus.OK);
	}

	@PostMapping("/loan/save/{custId}/{refNo}")
	public ResponseEntity<LoanDetails> saveLoanDetials(@RequestBody LoanDetails loanDetails, @PathVariable Long custId,
			@PathVariable String refNo) throws SQLException {
		System.out.println("admin+++++++++++" + loanDetails);
		LoanDetails loanDetailsResponse = loanService.saveLoanDetails(loanDetails, custId, refNo);
		System.out.println("admin+++++++++++" + loanDetailsResponse);
		return new ResponseEntity<LoanDetails>(HttpStatus.CREATED);
	}

	@GetMapping("/getAllStatus")
	public ResponseEntity<List<NewCaseResponse>> getAllStatus() {

		System.out.println(loanService.getAllStatus().size());
		return ResponseEntity.ok().body(loanService.getAllStatus());
	}

	@GetMapping("/getDetailsByRefNo/{refNo}")
	public ResponseEntity<AllDetailsResponse> getDetailsByRefNo(@PathVariable String refNo) {

		System.out.println(loanService.getAllStatus().size());
		return ResponseEntity.ok().body(loanService.getDetailsByRefNo(refNo));
	}

	@GetMapping("/refs")
	public ResponseEntity<List<LeadLoanResponse>> getAllRefs() {
		return ResponseEntity.ok().body(loanService.getAllRefs());
	}

	@PostMapping("/raiseDiscrepancy/{refNo}/{dicripancyReason}")
	public void saveRaiseDiscrepancy(@PathVariable String refNo, @PathVariable String dicripancyReason) {
		loanService.saveRaiseDiscrepancy(refNo, dicripancyReason);
	}

	@PostMapping("loan/save/descripency/{discripancyReason}/{resolutionReason}/{resolvedStatus}/{refNo}")
	public ResponseEntity<?> saveLoanDiscripancyDetials(@PathVariable String discripancyReason,
			@PathVariable String resolutionReason, @PathVariable String resolvedStatus, @PathVariable String refNo) {
		loanService.saveLoanDiscripancyDetials(discripancyReason, resolutionReason, resolvedStatus, refNo);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@GetMapping("/loan/viewDiscripancy/{refNo}")
	public ResponseEntity<LoanDiscrepancyDetailsResponse> getLoanDiscrepancyDetials(@PathVariable String refNo) {
		System.out.println(refNo);
		LoanDiscrepancyDetailsResponse loanDiscrepancyDetails = loanService.getLoanDiscrepancyDetials(refNo);
		System.out.println("admin+++++++++++" + loanDiscrepancyDetails);
		return new ResponseEntity<LoanDiscrepancyDetailsResponse>(loanDiscrepancyDetails, HttpStatus.OK);
	}
	


}
