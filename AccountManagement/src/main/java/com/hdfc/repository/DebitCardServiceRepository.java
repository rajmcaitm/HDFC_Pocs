package com.hdfc.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.hdfc.entities.DebitCard;

@Transactional
@Repository
public interface DebitCardServiceRepository extends JpaRepository<DebitCard, Long> {
	
	@Query(value = "select c.phone_number from customer_table as c  inner join  debit_card as d on d.customer_id = c.id where debit_card_no =:DebitCardNo", nativeQuery = true)
	String getMobileNo(String DebitCardNo);

}
