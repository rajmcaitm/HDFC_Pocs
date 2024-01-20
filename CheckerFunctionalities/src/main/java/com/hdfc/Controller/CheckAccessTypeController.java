package com.hdfc.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hdfc.exception.AccessTypeException;
import com.hdfc.service.CheckAccessTypeService;

@RestController
@CrossOrigin()
@RequestMapping("api")
public class CheckAccessTypeController {
	
	public static final String MAKER1 = "MAKER1";
	public static final String MAKER1_CHECKER1 = "MAKER1 & CHECKER1";
	public static final String MAKER2_CHECKER2 = "MAKER2 & CHECKER2";
	public static final String CHECKER2 = "CHECKER2";
	public static final String MAKER2 = "MAKER2";
	public static final String CHECKER1 = "CHECKER1";
	
	@Autowired
	private CheckAccessTypeService checkAccessTypeService;

	@GetMapping("/access/{id}")
	public ResponseEntity<?> getAccessType(@PathVariable Long id) throws AccessTypeException {

		String accessType = checkAccessTypeService.getAccessType(id);
		System.err.println("access type : "+accessType);
		
		if(accessType!= null && (accessType.equalsIgnoreCase(MAKER1) || accessType.equalsIgnoreCase(MAKER1_CHECKER1))) {
			return new ResponseEntity<>(accessType, HttpStatus.OK);
		}else if(accessType!= null && (accessType.equalsIgnoreCase(MAKER2_CHECKER2) || accessType.equalsIgnoreCase(CHECKER2))) {
			return new ResponseEntity<>(accessType, HttpStatus.OK);
		}else if(accessType!= null && (accessType.equalsIgnoreCase(MAKER2) || accessType.equalsIgnoreCase(CHECKER1))) {
			return new ResponseEntity<>(accessType, HttpStatus.OK);
		
		}else {
			throw new AccessTypeException("access not allowed");
		}
			
		
		
	}

}
