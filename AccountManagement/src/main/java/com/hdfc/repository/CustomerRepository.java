package com.hdfc.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.hdfc.entities.CustomerTable;

@Repository
@Transactional
public interface CustomerRepository extends JpaRepository<CustomerTable, Long> {
	
	 @Query(value = "Select * from customer_table where cust_id=:customerId", nativeQuery = true)
	 CustomerTable validateCustomerId(Long customerId);
	 
	 @Query(value = "Select phone_number from customer_table where cust_id=:customerId", nativeQuery = true)
	 Long getCustomerMoboleNo(Long customerId);
	 
	 @Query(value = "select c.phone_number from customer_table as c inner join account_number as a on a.customer_id = c.id where account_no =:accountNo", nativeQuery = true)
	 Long getCustomerPhoneNo(Long accountNo);
	 
	 @Modifying
	 @Query(value = "update cheque_table set cheque_quantities =? where cheque_acc_no=?", nativeQuery = true)
	 void saveChequeQuantity(Integer quantity, Long accountNo);
	 
	 @Query(value = "Select c.name, c.address from customer_table as c inner join account_number as a on a.customer_id = c.id where account_no =:accountNo", nativeQuery = true)
	 String getCustomerAddressByAccountNo(Long accountNo);

}
