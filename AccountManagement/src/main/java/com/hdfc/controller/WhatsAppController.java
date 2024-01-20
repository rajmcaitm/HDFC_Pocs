package com.hdfc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hdfc.whatsapp.SendWhatsAppMessage;

@RestController
@RequestMapping("/v1/api")
public class WhatsAppController {

	@Autowired
	private SendWhatsAppMessage sendWhatsAppMessage;

	@GetMapping("/sendWhatsAppMessage/{accountNo}")
	public ResponseEntity<String> sendWhatsAppMessage(@PathVariable Long accountNo) {
		sendWhatsAppMessage.sendWhatsAppMessage(accountNo);
		return new ResponseEntity<String>("~ Mini Statement sent to your registered Whatsapp Mobile Number ~", HttpStatus.CREATED);
	}

}
