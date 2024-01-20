package com.hdfc.serviceImpl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.hdfc.dto.CustomerDetails;
import com.hdfc.service.CheckAccessTypeService;
import com.hfdc.connection.PostgreConnection;

@Service
public class CheckAccessTypeServiceImpl implements CheckAccessTypeService {

	@Override
	public String getAccessType(Long id) {
		
		Connection con = null;
		Statement stmt = null;
		String accessType = null;
		
		try {
		con = PostgreConnection.getConnection();
		
		stmt = con.createStatement();
		String query = "select ps.access_type from profile_service ps inner join account_details acc ON acc.emailid = ps.email_id inner join customer c ON c.custId =acc.id where custid ="+id;
		ResultSet rs = stmt.executeQuery(query);
		while ( rs.next() ) {
        accessType =	rs.getString("access_type");
        	
        }
        
		} catch ( Exception e ) {
	         System.err.println( e.getClass().getName()+": "+ e.getMessage() );
	         
	      }
 		
		return accessType; 
	}
		
	}


