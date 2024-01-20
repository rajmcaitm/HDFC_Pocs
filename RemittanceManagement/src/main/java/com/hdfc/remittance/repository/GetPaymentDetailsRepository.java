package com.hdfc.remittance.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.hdfc.remittance.entity.AccountDetails;

@Repository
public interface GetPaymentDetailsRepository extends JpaRepository<AccountDetails, Long> {

	@Query(value = "select * from account where custid =:custId", nativeQuery = true)
	List<AccountDetails> findListAccByCustId(Long custId);

	@Query(value = "select * from account where accno =:accNum", nativeQuery = true)
	AccountDetails findPaymentDetailsByAccNum(String accNum);

}
