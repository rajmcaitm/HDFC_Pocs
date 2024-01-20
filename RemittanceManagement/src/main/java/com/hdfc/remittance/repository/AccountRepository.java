package com.hdfc.remittance.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.hdfc.remittance.entity.AccountDetails;

@Repository
public interface AccountRepository extends JpaRepository<AccountDetails, Long> {

	//List<AccountDetails> findByCustomerId(Long custId);

	
	  @Query(value = "select * from account where custid=:custId", nativeQuery =
	  true)
	  
	  List<AccountDetails> findByCustomerId(Long custId);


	 
}
