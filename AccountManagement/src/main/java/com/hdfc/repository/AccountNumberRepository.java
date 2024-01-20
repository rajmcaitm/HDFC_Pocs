package com.hdfc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.hdfc.entities.AccountNumber;

@Repository
public interface AccountNumberRepository extends JpaRepository<AccountNumber, Long> {
	
	@Query(value = "select a.account_no from account_number as a inner join customer_table as c on c.id =a.customer_id where c.cust_id=:custId", nativeQuery = true)
	List<?> findListOfAccountNoByCustId(Long custId);
	
	@Query(value = "select balance from account_number where account_no =:accountNo", nativeQuery = true)
	Float getAccBalanceByAccountNo(Long accountNo);

	@Query(value = "select c.phone_number from customer_table as c  inner join account_number as a on a.customer_id = c.id where account_no =:accNo", nativeQuery = true)
	Long getMobileNumberBasedOnAccountNo(Long accNo);
	
}
