package com.hdfc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hdfc.entities.SBAccount;

@Repository
public interface SBAccountRepository extends JpaRepository<SBAccount, Long>{

}
