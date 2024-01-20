package com.hdfc.repository;

import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.hdfc.entities.LoanDetails;

@Repository
@Transactional
public interface LoanRepository extends JpaRepository<LoanDetails, Long> {

	@Modifying
	@Query(value = "UPDATE loan_details SET dicripancy_reason = ?,resolution_reason = ?,resolved_status= ? where reffernce_number = ?", nativeQuery = true)
	public void saveLoanDiscripancyDetials(String discripancyReason, String resolutionReason, String resolvedStatus,
			String refNo);

	@Query(value = "select * from loan_details where reffernce_number =:refNo", nativeQuery = true)
	public LoanDetails getLoanDiscrepancyDetials(String refNo);

}
