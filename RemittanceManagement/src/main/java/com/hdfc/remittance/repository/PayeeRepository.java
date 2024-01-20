package com.hdfc.remittance.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.hdfc.remittance.entity.PayeeDetails;

public interface PayeeRepository extends JpaRepository<PayeeDetails, Long> {
	
	@SuppressWarnings("unchecked")
	PayeeDetails save(PayeeDetails payeeDetails);
	
	@Query(value = "Select mobileno from account_details where custid=:custId", nativeQuery = true)
	String getPayerMobileNo(Long custId);
	
	Optional<PayeeDetails> findById(long id);
	
	@Query(value = "select * from payee where accountnumber=:accountNo", nativeQuery = true)
	PayeeDetails getPayeeDetailsByAccountNo(Long accountNo); 
}
