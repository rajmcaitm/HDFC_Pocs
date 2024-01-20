package com.hdfc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hdfc.dto.ChequeStatusDto;
import com.hdfc.service.ChequeStatusService;
@RestController
@RequestMapping("/v1/api")
public class ChequeStatusController {
	@Autowired
	ChequeStatusService chequeStatusService;
	
	@GetMapping("getChequeStatus/{cheque_acc_no}/{chequeNo}")
	public ChequeStatusDto getChequeStatusDetails(@PathVariable Long cheque_acc_no,@PathVariable Long chequeNo) {
		return chequeStatusService.getChequeStatusDetails(cheque_acc_no,chequeNo);
	}
}