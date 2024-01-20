/*
 package com.hdfc.repository;
  
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.hdfc.dto.CustomerDetails;
  
  @Repository
  public interface CustomerDetailsRepositoty extends JpaRepository<CustomerDetails, Long>{
  
    //public static final String JOIN_QUERY = "SELECT c.custid, c.custname, accno.accnum, acc.acc_name, acc.custaddr1, acc.mobileno, acc.custaddr2, acc.emailid, acc.custaddr3, acc.pannumber, tx.amount, tx.currency, tx.purposecode, tx.description, tx.equivalentto, tx.rate FROM account_details acc INNER JOIN customer c ON c.custid = acc.id INNER JOIN Transactions tx ON c.tx_id = tx.id INNER JOIN  Account_Number accno ON acc.id = accno.accountdetails_id where tx.id= :refNo";
	  public static final String JOIN_QUERY = "SELECT e from com.hdfc.dto.Customer(e.custId, e.custName) where e.custid= :refNo";
	    
	   @Query(value = JOIN_QUERY, nativeQuery = true)
       CustomerDetails getCustDetailsByRefNo(Long refNo);

}
 */