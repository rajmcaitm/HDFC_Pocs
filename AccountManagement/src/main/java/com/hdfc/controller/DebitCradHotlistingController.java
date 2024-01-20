package com.hdfc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hdfc.entities.DebitCard;
import com.hdfc.service.DebitCardService;

@RestController
@RequestMapping("/v1/api")
public class DebitCradHotlistingController {

	@Autowired
	private DebitCardService detbitCardService;

	@PostMapping("/debitCrad")
	public ResponseEntity<DebitCard> saveDebitCradHotListDetails(@RequestBody DebitCard debitCard) {
		return ResponseEntity.ok().body(detbitCardService.saveDebitCradHotListDetails(debitCard));
	}

	@PostMapping("/debitCrad/{debitCardNo}")
	public ResponseEntity<String> sendOTP(@PathVariable String debitCardNo) {
		detbitCardService.sendOTP(debitCardNo);
		return new ResponseEntity("**YOUR DEBIT CARD HAS BEEN HOTLISTED SUCCESSFULLY**", HttpStatus.OK);
	}

}
