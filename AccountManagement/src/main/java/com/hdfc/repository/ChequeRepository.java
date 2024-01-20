package com.hdfc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.hdfc.entities.Cheque;

@Repository
public interface ChequeRepository extends JpaRepository<Cheque, Integer> {

	@Query(value = "select cheque_status from CHEQUE_TABLE where cheque_no =:chequeNo",nativeQuery=true)
	String getChequeStatus(Long chequeNo);

	@Query(value = "select c.name from customer_table as c inner join account_number as acc on acc.customer_id = c.id where account_no =:accountNo",nativeQuery=true)
	String getChequeDetails(Long accountNo);

}
