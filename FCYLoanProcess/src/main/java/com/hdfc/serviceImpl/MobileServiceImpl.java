package com.hdfc.serviceImpl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import org.springframework.stereotype.Service;

import com.hdfc.connection.PostgreConnection;
import com.hdfc.dto.Customer;
import com.hdfc.dto.SmsPojo;
import com.hdfc.service.MobileService;

@Service
public class MobileServiceImpl implements MobileService{

	@Override
	public SmsPojo getCustomerMobileNo(Customer customer) {
		
		Connection con = null;
		Statement stmt = null;
		String countryCode = "+91";
		SmsPojo cust = new SmsPojo();
		
		try {
		con = PostgreConnection.getConnection();
		
		stmt = con.createStatement();
		String query = "select acc.mobileno FROM account_details acc INNER JOIN customer c ON c.custid = acc.id where custid ="+customer.getCustomerId();
		ResultSet rs = stmt.executeQuery(query);
		
		while ( rs.next() ) {
        
				
			String mobileNo =  countryCode + String.valueOf(rs.getLong("mobileno"));
			cust.setPhoneNo(mobileNo);
			
        }
        } catch ( Exception e ) {
	         System.err.println( e.getClass().getName()+": "+ e.getMessage());
	         e.printStackTrace();
	         
	      }
		return cust; 
	}

}
