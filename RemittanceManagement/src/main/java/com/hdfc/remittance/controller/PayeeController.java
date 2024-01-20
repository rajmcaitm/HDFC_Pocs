package com.hdfc.remittance.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hdfc.remittance.dto.BankDetails;
import com.hdfc.remittance.dto.PayeeDetailsResponse;
import com.hdfc.remittance.dto.StoreOTP;
import com.hdfc.remittance.dto.TempOTP;
import com.hdfc.remittance.entity.PayeeDetails;
import com.hdfc.remittance.entity.RemittencePaymentDetails;
import com.hdfc.remittance.exception.ResponseMessage;
import com.hdfc.remittance.service.PayeeService;

@RestController
public class PayeeController {

	@Autowired
	PayeeService payeeService;

	@PostMapping("/payee/save/{custId}")
	public ResponseEntity<?> addPayee(@RequestBody PayeeDetails payeeDetails, @PathVariable Long custId) throws ParseException {
		PayeeDetails payee = payeeService.addPayee(payeeDetails, custId);
		return new ResponseEntity<>(payee, HttpStatus.OK);
	}
	
	@GetMapping("/swiftCode/{swiftCode}") 
    public ResponseEntity<BankDetails> getBankDetails(@PathVariable String swiftCode) throws IOException  {
        return ResponseEntity.ok().body(payeeService.getBankDetails(swiftCode));
    }
	
	@PostMapping("/validateOtp")
	public String verifyOTP(@RequestBody TempOTP otp) {
		if (otp.getOtp() == StoreOTP.getOtp())
			return "Correct OTP";
		else
			return "Invalid OTP";
	}
		
	
	@PutMapping("/updatePayee/{id}")
	public ResponseEntity<?> updatePayee(@RequestBody PayeeDetails payeeDetails, @PathVariable Long id) {
		String message = "";
		try {

			PayeeDetails payee = payeeService.updatePayee(payeeDetails, id);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			message = "INVALID PAYEE DETAILS... " + "!";
			return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
		}
	}
    

	@GetMapping("fetchPayeeDetails/{accountNo}")
	public ResponseEntity<?> fetchPayeeDetails(@PathVariable Long accountNo) {

		PayeeDetailsResponse payeeDetailsResponse = payeeService.fetchPayeeDetails(accountNo);
		System.out.println(payeeDetailsResponse);
		return new ResponseEntity<PayeeDetailsResponse>(payeeDetailsResponse, HttpStatus.OK);
	}
	
	@PostMapping("/savePayment")
    public ResponseEntity <RemittencePaymentDetails> savePaymentDetails(@RequestBody RemittencePaymentDetails remittencePaymentDetails) {
		RemittencePaymentDetails response = this.payeeService.savePaymentDetails(remittencePaymentDetails);
		return new ResponseEntity<RemittencePaymentDetails>(HttpStatus.CREATED);
    }
	
	@PostMapping("/payeeConfirmationRefNo/{fromAccount}")
	public ResponseEntity<String> payeeConfirmationRefNo(@PathVariable String fromAccount) throws SQLException {
		String message  = payeeService.payeeConfirmationRefNo(fromAccount);
		return new ResponseEntity<String>(message, HttpStatus.OK);
	}
	
}
