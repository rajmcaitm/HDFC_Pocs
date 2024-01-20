package com.hdfc.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.hdfc.entities.Customer;

@Repository
@Transactional
public interface CustomerRepositoty extends JpaRepository<Customer, Long> {

   @Query(value = "Select amount from customeraccount where account_no=:accountNo and username =:username and password =:password", nativeQuery = true)
   Double checkBalance(Long accountNo, String username, String password);
  
   @Query(value = "Select amount from customeraccount where account_no=:accountNo", nativeQuery = true)
   Double getAmountByAccountNo(Long accountNo);

   @Modifying
   @Query(value = "update customeraccount set amount=? where account_no=?", nativeQuery = true)
   void updateDepositAmount(Double totalAmount, Long accountNo);

   @Modifying
   @Query(value = "update customeraccount set amount=? where account_no=?", nativeQuery = true)
    void updateRemainingAmount(Double remainingAmount, Long accountNo);
   
   @Modifying
   @Query(value = "delete customeraccount where account_no=?", nativeQuery = true)
   public Customer toCloseAccount(Long accountNo);
		

}
