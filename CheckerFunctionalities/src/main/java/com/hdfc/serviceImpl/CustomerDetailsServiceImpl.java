package com.hdfc.serviceImpl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import org.springframework.stereotype.Service;

import com.hdfc.dto.CheckerCustomerDetails;
import com.hdfc.dto.CustomerDetails;
import com.hdfc.service.CustomerDetailsService;
import com.hfdc.connection.PostgreConnection;

@Service
public class CustomerDetailsServiceImpl implements CustomerDetailsService {

	@Override
	public CustomerDetails getCustomerDetails(Long refNo) {
		
		Connection con = null;
		Statement stmt = null;
		CustomerDetails customerDetails = new CustomerDetails();
		try {
		con = PostgreConnection.getConnection();
		
		stmt = con.createStatement();
		String query = "SELECT c.custid, c.custname, accno.accnum, acc.acc_name, acc.custaddr1, acc.mobileno, acc.custaddr2, acc.emailid, acc.custaddr3, acc.pannumber, tx.amount, tx.currency, tx.purposecode, tx.description, tx.equivalentto, tx.rate FROM account_details acc INNER JOIN customer c ON c.custid = acc.id INNER JOIN Transactions tx ON c.tx_id = tx.id INNER JOIN  Account_Number accno ON acc.id = accno.accountdetails_id where tx.id ="+refNo;
		ResultSet rs = stmt.executeQuery(query);
		
		while ( rs.next() ) {
        	
        	customerDetails.setCustId(rs.getLong("custid"));
        	customerDetails.setCustName(rs.getString("custname"));	
        	customerDetails.setAccountNo(rs.getLong("accnum"));
        	customerDetails.setAccName(rs.getString("acc_name"));	
        	customerDetails.setCustAddr1(rs.getString("custaddr1"));
        	customerDetails.setMobileNo(rs.getLong("mobileno"));
        	customerDetails.setCustAddr2(rs.getString("custaddr2"));
        	customerDetails.setEmailId(rs.getString("emailid"));
        	customerDetails.setCustAddr3(rs.getString("custaddr3"));
        	customerDetails.setPanNumber(rs.getString("pannumber"));
        	customerDetails.setTxAmount(rs.getDouble("amount"));
        	customerDetails.setCurrency(rs.getString("currency"));
        	customerDetails.setPurposeCode(rs.getString("purposecode"));
        	customerDetails.setPurposeDescription(rs.getString("description"));
        	customerDetails.setEquivalentTo(rs.getString("equivalentto"));
        	customerDetails.setRate(rs.getDouble("rate"));
        	
        }
        //rs.close();
        //stmt.close();
        //con.close();
		String sql = "UPDATE transactions SET processing_status = 'In-Progress' WHERE id ="+refNo;
		stmt.execute(sql);
		} catch ( Exception e ) {
	         System.err.println( e.getClass().getName()+": "+ e.getMessage() );
	         
	      }
 		return customerDetails; 
	}

	@Override
	public CheckerCustomerDetails getCheckerCustomerDetails(Long refNo) {
		
		Connection con = null;
		Statement stmt = null;
		CheckerCustomerDetails checkerCustDetails = new CheckerCustomerDetails();
		try {
		con = PostgreConnection.getConnection();
		
		stmt = con.createStatement();
		String checkerQuery = "SELECT c.custid, c.custname, accno.accnum, acc.acc_name, acc.custaddr1, acc.mobileno, acc.custaddr2, acc.emailid, acc.custaddr3, acc.pannumber, tx.amount, tx.currency, tx.purposecode, tx.description, tx.equivalentto, tx.rate, pay.payment_rate, pay.payment_remarks, pay.payment_amount FROM account_details acc INNER JOIN customer c ON c.custid = acc.id INNER JOIN Transactions tx ON c.tx_id = tx.id INNER JOIN  Account_Number accno ON acc.id = accno.accountdetails_id INNER JOIN payment_details pay ON tx.id = pay.id where tx.id ="+refNo;
		ResultSet rs = stmt.executeQuery(checkerQuery);
		
        while ( rs.next() ) {
        	
        	checkerCustDetails.setCustId(rs.getLong("custid"));
        	checkerCustDetails.setCustName(rs.getString("custname"));	
        	checkerCustDetails.setAccountNo(rs.getLong("accnum"));
        	checkerCustDetails.setAccName(rs.getString("acc_name"));	
        	checkerCustDetails.setCustAddr1(rs.getString("custaddr1"));
        	checkerCustDetails.setMobileNo(rs.getLong("mobileno"));
        	checkerCustDetails.setCustAddr2(rs.getString("custaddr2"));
        	checkerCustDetails.setEmailId(rs.getString("emailid"));
        	checkerCustDetails.setCustAddr3(rs.getString("custaddr3"));
        	checkerCustDetails.setPanNumber(rs.getString("pannumber"));
        	checkerCustDetails.setTxAmount(rs.getDouble("amount"));
        	checkerCustDetails.setCurrency(rs.getString("currency"));
        	checkerCustDetails.setPurposeCode(rs.getString("purposecode"));
        	checkerCustDetails.setPurposeDescription(rs.getString("description"));
        	checkerCustDetails.setEquivalentTo(rs.getString("equivalentto"));
        	checkerCustDetails.setRate(rs.getDouble("rate"));
        	checkerCustDetails.setPaymentRate(rs.getDouble("payment_rate"));
        	checkerCustDetails.setPaymentRemarks(rs.getString("payment_remarks"));
        	checkerCustDetails.setPaymentAmount(rs.getDouble("payment_amount"));
        	
        }
        String sql = "UPDATE transactions SET processing_status = 'Completed' WHERE id ="+refNo;
		stmt.execute(sql);
		} catch ( Exception e ) {
	         e.printStackTrace();
	         
	      }
		return checkerCustDetails;
	}
	
}
