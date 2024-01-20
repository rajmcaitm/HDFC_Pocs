package com.hdfc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hdfc.entities.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

	/*
	 * @Query(value =
	 * "select ad.acc_num,ad.acc_name,ad.custaddr1,ad.custaddr2,ad.custaddr3,ad.emailid,ad.iec,ad.mobileno,ad.pannumber,c.custname from account_details as ad inner join customer c on c.custid=ad.custid where c.custid=:custId"
	 * , nativeQuery = true) public CustomerResponse
	 * findCustomerDetailsByCustId(Long custId);
	 */
}
