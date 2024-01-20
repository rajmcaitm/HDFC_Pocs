package com.hdfc.controller;

import java.lang.reflect.Field;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ReflectionUtils;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hdfc.entities.Customer;
import com.hdfc.repository.CustomerRepositoty;

@RestController
@RequestMapping("v1/api/update")
public class UpdateCustomerPatchDemoController {

	@Autowired
	CustomerRepositoty customerRepositoty;
	
	@PutMapping("/customer/{id}")
    public ResponseEntity <Customer> updateCustomer(@PathVariable long id, @RequestBody Customer customer) {
		
		Customer customerUpdate = null;
		Optional <Customer> customerDb = this.customerRepositoty.findById(id);

        if (customerDb.isPresent()) {
        	customerUpdate = customerDb.get();
        	customerUpdate.setId(id);
        	customerUpdate.setAmount(customer.getAmount());
        	customerUpdate.setAdderess(customer.getAdderess());
        	customerUpdate.setPhone(customer.getPhone());
        } 
        return ResponseEntity.ok().body(this.customerRepositoty.save(customerUpdate));
    }

	@PatchMapping("/customer/{id}")
	public ResponseEntity<Customer> partialUpdatepdate(@RequestBody Map<String, Object> customer, @PathVariable Long id) {
		Customer cust = customerRepositoty.findById(id).get();

		if (cust == null) {
			return ResponseEntity.notFound().build();
		} 
		/*
		if (customer.containsKey("adderess")) {
			cust.setAdderess((String) customer.get("adderess"));
			System.out.println("addr");
		}
		if (customer.containsKey("phone")) {
			cust.setPhone((Long) customer.get("phone"));
			System.out.println("phone");
		}
		if (customer.containsKey("amount")) {
			cust.setAmount((double) customer.get("amount"));
			System.out.println("amount");
		}
		*/
		
		customer.forEach( (key, value) -> {
            Field field = ReflectionUtils.findField(Customer.class, key);
            if(field != null) {
            	System.err.println(field.getName());
                field.setAccessible(true);
                ReflectionUtils.setField(field, cust, value);
            }
        });
		
		return ResponseEntity.ok(customerRepositoty.save(cust));
	}
}

