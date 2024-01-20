package com.hdfc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.hdfc.dto.ChequeStatusDto;
import com.hdfc.entities.Cheque;

@Repository
public interface ChequeStatusRepository extends JpaRepository<Cheque, Integer>{
	@SuppressWarnings("unchecked")
	@Query(value = "select * from CHEQUE_TABLE where cheque_acc_no =:cheque_acc_no",nativeQuery=true)
	Cheque findByChequeAccountNo(Long cheque_acc_no);

}
