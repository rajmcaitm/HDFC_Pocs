package com.hdfc.controller;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.hdfc.dto.CustomerDto;
import com.hdfc.entities.Customer;
import com.hdfc.service.CustomerService;
//import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
@RequestMapping("v1/api")
@CrossOrigin(origins = "http://localhost:3000")
public class RegisterCustomerController {

	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private RestTemplate restTemplate;
	

	@PostMapping("/registerCustomer")
	public ResponseEntity<Customer> registerUser(@RequestBody Customer customer) {

		Customer registerCustomer = customerService.registerCustomer(customer);
		return new ResponseEntity<Customer>(registerCustomer, HttpStatus.CREATED);
	}
	
	
	@GetMapping("/checkBalance")
    public ResponseEntity <String> checkAccountBalance(@RequestBody CustomerDto customer) {
        return ResponseEntity.ok().body("Your account number "+customer.getAccountNo()+" has remaining balance : "+customerService.checkBalance(customer.getAccountNo(), customer.getUsername(), customer.getPassword()));
    }
	
	@GetMapping("/depositMoney")
    public ResponseEntity <String> depositMoney(@RequestBody Customer customer) {
        return ResponseEntity.ok().body("Your balance has increased Rs. "+customerService.depositMoney(customer.getAccountNo(), customer.getAmount()));
    }
	
	@GetMapping("/withdrawMoney")
    public ResponseEntity <String> withdrawMoney(@RequestBody Customer customer) {
        return ResponseEntity.ok().body("Your balance has decreases Rs. "+customerService.withdrawMoney(customer.getAccountNo(), customer.getAmount()));
    }
	
	@GetMapping("/closeAccount")
    public ResponseEntity <String> toCloseAccount(@PathVariable Long accountNo) {
		Customer customerDetails = customerService.toCloseAccount(accountNo);
		String message = "Welcome "+customerDetails.getUsername()+" your account number "+customerDetails.getAccountNo()+" has closed";
        return ResponseEntity.ok().body(message);
    }
	
	@GetMapping("/fault-tolerance-example")  
	//configuring a fallback method  
	//@HystrixCommand(fallbackMethod="fallbackRetrieveConfigurations")  
	public String retrieveConfigurations()  
	{
		 HttpHeaders headers = new HttpHeaders();
	      headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	      HttpEntity <String> entity = new HttpEntity<String>(headers);
	      
	      return restTemplate.exchange("http://localhost:2222/v1/api/welcome", HttpMethod.GET, entity, String.class).getBody();
	  
	}  
	//defining the fallback method  
	public String fallbackRetrieveConfigurations()  
	{  
	//returning the default configuration     
	return new String("Service is down");   
	}  

	
}
