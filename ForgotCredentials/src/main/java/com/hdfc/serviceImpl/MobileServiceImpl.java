package com.hdfc.serviceImpl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import org.springframework.stereotype.Service;

import com.hdfc.connection.PostgreConnection;
import com.hdfc.dto.CustIdMobile;
import com.hdfc.dto.Customer;
import com.hdfc.dto.CustomerDetails;
import com.hdfc.dto.DebitCard;
import com.hdfc.dto.MobileCardNoPin;
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

	@Override
	public MobileCardNoPin sendOtp(DebitCard debitCard) {
		
		Connection con = null;
		Statement stmt = null;
		String countryCode = "+91";
		MobileCardNoPin cust = new MobileCardNoPin();
		
		try {
		con = PostgreConnection.getConnection();
		
		stmt = con.createStatement();
		String query = "SELECT acc.mobileno, card_number, pin FROM account_details acc INNER JOIN debit_card c ON acc.id = c.id where CARD_NUMBER="+"'"+debitCard.getDebitCardNo()+"'";
		System.out.println("formed Query: "+query);
		ResultSet rs = stmt.executeQuery(query);
		System.out.println(rs.getFetchSize());
		
		while ( rs.next() ) {
        
				
			String mobileNo =  countryCode + String.valueOf(rs.getLong("mobileno"));
			int debitCardPin =  rs.getInt("pin");
			String debitCardNo =  rs.getString("card_number");
			System.out.println("mobileNo :"+mobileNo);
			cust.setMobileNo(mobileNo);
			cust.setDebitCardNo(debitCardNo);
			cust.setDebitCardPin(debitCardPin);
			
        }
        } catch ( Exception e ) {
	         System.err.println( e.getClass().getName()+": "+ e.getMessage());
	         e.printStackTrace();
	         
	      }
		return cust; 
	}

	@Override
	public CustIdMobile getCustomerId(CustomerDetails customerDetails) {

		Connection con = null;
		Statement stmt = null;
		String countryCode = "+91";
		CustIdMobile custIdMobile = new CustIdMobile();

		try {
			con = PostgreConnection.getConnection();

			stmt = con.createStatement();
			String query = "select  cust.custid, acc.mobileno, card_number, pin FROM customer cust INNER JOIN  account_details acc ON cust.custid = acc.id INNER JOIN  debit_card card ON acc.id = card.id where card.card_number ="
					+"'"+customerDetails.getDebitCardNo()+"'";
			System.out.println("Formed Query: "+query);
			ResultSet rs = stmt.executeQuery(query);

			while (rs.next()) {
				
				custIdMobile.setCustMobileNO(countryCode + String.valueOf(rs.getLong("mobileno")));
				System.out.println("mobileno: "+custIdMobile.getCustMobileNO());
				custIdMobile.setCustId(rs.getLong("custid"));
				System.out.println("Customer id: "+custIdMobile.getCustId());
				custIdMobile.setCardNo(rs.getString("card_number"));
				custIdMobile.setCardPin(rs.getInt("pin"));

			}
		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			e.printStackTrace();

		}
		return custIdMobile;
	}
	
}
