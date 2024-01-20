package com.hdfc.serviceImpl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.hdfc.connection.PostgreConnection;
import com.hdfc.dto.Account;
import com.hdfc.dto.CustomerDetails;
import com.hdfc.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {

	
	@Override
	public CustomerDetails getCustomerDetailsByCustId(Long customerId) {
		
		Connection con = null;
		Statement stmt = null;
		CustomerDetails custDetails = new CustomerDetails();
		List<Account> accList = new ArrayList<Account>();
		Account acc = new Account();
		Long data = 0L;
		try {
		con = PostgreConnection.getConnection();
		
		stmt = con.createStatement();
		//String query = "select acc.mobileno FROM account_details acc INNER JOIN customer c ON c.custid = acc.id where custid ="+customerId;
		String query = "select cust.customer_id, cust.customer_mobileNo, cust.customer_name, cust.customer_emailId, accno.customer_accno FROM lead_customer cust INNER JOIN lead_customer_accno accno ON cust.cust_id = accno.cust_id where customer_id ="+customerId;
		System.out.println("SQL: "+query);
		ResultSet rs = stmt.executeQuery(query);
		
		while ( rs.next() ) {
        
			custDetails.setCustomerId(rs.getLong("customer_id"));	
			
			custDetails.setCustomerMobileNo(rs.getLong("customer_mobileNo"));
			custDetails.setCustomerName(rs.getString("customer_name"));
			custDetails.setCustomerEmailId(rs.getString("customer_emailId"));
			
			accList.add(new Account(rs.getLong("customer_accno")));
			
		}
		
		custDetails.setCustomerAccountNo(accList);
        } catch ( Exception e ) {
	         System.err.println( e.getClass().getName()+": "+ e.getMessage());
	         e.printStackTrace();
	         
	      }
		return custDetails; 
	}
	
	
}
