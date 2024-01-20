package com.hdfc.remittance.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.hdfc.remittance.dto.PayeeDetailsResponse;
import com.hdfc.remittance.entity.PayeeDetails;

public interface GetPayeeRepository extends JpaRepository<PayeeDetails, Long>{
	@SuppressWarnings("unchecked")
	@Query(value = "select * from payee where custId =:custId",nativeQuery=true)
	List<PayeeDetails> findAllPayeeByCustId(Long custId);
}
