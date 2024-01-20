package com.hdfc.service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hdfc.connection.PostgreConnection;
import com.hdfc.dto.LeadLoanResponse;
import com.hdfc.dto.LoanDiscrepancyDetailsResponse;
import com.hdfc.entities.AllDetailsResponse;
import com.hdfc.entities.LoanDetails;
import com.hdfc.entities.NewCaseResponse;
import com.hdfc.repository.LoanRepository;

@Service
public class LoanService {

	@Autowired
	LoanRepository loanRepository;

	public LoanDetails getLoanDetails(Long id) {

		return loanRepository.getById(id);

	}

	public LoanDetails saveLoanDetails(LoanDetails loanDetails, Long custId, String refNo) throws SQLException {
		Connection con = null;
		Statement stmt = null;
		loanDetails.setCustId(custId);
		loanDetails.setRefferenceNumber(refNo);
		loanDetails.setProcessingStatus("Created");
		if(refNo.startsWith("L")) {			
			String query = "DELETE FROM lead WHERE lead_ref_no  =" + "'" + refNo + "'";
			con = PostgreConnection.getConnection();
			stmt = con.createStatement();
			stmt.executeUpdate(query);
		}

		return loanRepository.save(loanDetails);

	}

	@SuppressWarnings("unchecked")
	public List<NewCaseResponse> getAllStatus() {
		Connection con = null;
		Statement stmt = null;
		NewCaseResponse newCaseResponse = new NewCaseResponse();
		List<NewCaseResponse> responseList = new ArrayList<>();
		try {
			con = PostgreConnection.getConnection();

			stmt = con.createStatement();
			String query = "select ld.reffernce_number,ld.custid,c.custname,ld.currency_type,ld.loan_amount,ld.processing_status from loan_details as ld inner join customer c on ld.custid=c.custid";
			ResultSet rs = stmt.executeQuery(query);

			while (rs.next()) {

				String reffernceNumber = String.valueOf(rs.getString("reffernce_number"));
				newCaseResponse.setReffernceNumber(reffernceNumber);
				Long custId = Long.valueOf(rs.getLong("custid"));
				newCaseResponse.setCustId(custId);
				String custName = String.valueOf(rs.getString("custName"));
				newCaseResponse.setCustName(custName);
				String currencyType = String.valueOf(rs.getString("currency_type"));
				newCaseResponse.setCurrencyType(currencyType);
				newCaseResponse.setLoanAmount(rs.getLong("loan_amount"));
				String processingStatus = String.valueOf(rs.getString("processing_status"));
				newCaseResponse.setProcessingStatus(processingStatus);
				responseList.add(new NewCaseResponse(newCaseResponse.getReffernceNumber(), newCaseResponse.getCustId(), newCaseResponse.getCustName(), newCaseResponse.getCurrencyType(), newCaseResponse.getCustId(), newCaseResponse.getProcessingStatus()));
				//responseList.add(new NewCaseResponse(newCaseResponse.getCustId(),newCaseResponse.getCustName(),newCaseResponse.getLoanAmount(),newCaseResponse.getProcessingStatus(),newCaseResponse.getReffernceNumber()));
			}
		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			e.printStackTrace();

		}
		return responseList;
		// return (List<NewCaseResponse>) newCaseResponse;
	}

	
	@SuppressWarnings("unchecked")
	public AllDetailsResponse getDetailsByRefNo(String refNo) {
		Connection con = null;
		Statement stmt = null;
		AllDetailsResponse allDetailsResponse = new AllDetailsResponse();
		// List<DetailsResponse> responseList = new ArrayList<>();
		try {
			con = PostgreConnection.getConnection();

			stmt = con.createStatement();
			String query = "select c.custid,c.custname,ad.acc_num,ad.acc_name,ad.custaddr1,ad.custaddr2,ad.emailid,ad.iec,ad.pannumber,ad.mobileno, "
					+ "ld.loan_amount,ld.currency_type,ld.credit_score,ld.rate_of_intrest, "
					+ "ld.documets_attached,ld.intrest_type,ld.loan_tenure,ld.loan_purpose, "
					+ "ld.periodicity_installment,ld.general_remarks,f.\"name\" "
					+ "from customer as c inner join account_details ad on c.custid=ad.custid "
					+ "inner join loan_details ld on ld.custid=ad.custid "
					+ "inner join files f on f.refno=ld.reffernce_number " + "where reffernce_number=" + "'" + refNo
					+ "'";

			System.err.println(query);
			ResultSet rs = stmt.executeQuery(query);

			while (rs.next()) {

				Long custId = Long.valueOf(rs.getLong("custid"));
				allDetailsResponse.setCustId(custId);
			    Long accNum = Long.valueOf(rs.getLong("acc_num"));
				allDetailsResponse.setAccNum(accNum);
				String custName = String.valueOf(rs.getString("custname"));
				allDetailsResponse.setCustName(custName);
				String custAddr1 = String.valueOf(rs.getString("custaddr1"));
				allDetailsResponse.setCustAddr1(custAddr1);
				String custAddr2 = String.valueOf(rs.getString("custaddr2"));
				allDetailsResponse.setCustAddr2(custAddr2);
				String emailId = String.valueOf(rs.getString("emailid"));
				allDetailsResponse.setEmailId(emailId);
				Long iec = Long.valueOf(rs.getLong("iec"));
				allDetailsResponse.setIec(iec);
				String panNumber = String.valueOf(rs.getString("pannumber"));
				allDetailsResponse.setPanNumber(panNumber);
				Long mobileNo = Long.valueOf(rs.getLong("mobileno"));
				allDetailsResponse.setMobileNo(mobileNo);
				Integer loanAmount = Integer.valueOf(rs.getInt("loan_amount"));
				allDetailsResponse.setLoanAmount(loanAmount);
				String currencyType = String.valueOf(rs.getString("currency_type"));
				allDetailsResponse.setCurrencyType(currencyType);
				Integer creditScore = Integer.valueOf(rs.getInt("credit_score"));
				allDetailsResponse.setCreditScore(creditScore);
				Float rateOfIntrest = Float.valueOf(rs.getFloat("rate_of_intrest"));
				allDetailsResponse.setRateOfIntrest(rateOfIntrest);
				Boolean documetsAttached = Boolean.valueOf(rs.getBoolean("documets_attached"));
				allDetailsResponse.setDocumetsAttached(documetsAttached);
				String intrestType = String.valueOf(rs.getString("intrest_type"));
				allDetailsResponse.setIntrestType(intrestType);
				Integer loanTenure = Integer.valueOf(rs.getInt("loan_tenure"));
				allDetailsResponse.setLoanTenure(loanTenure);
				String loanPurpose = String.valueOf(rs.getString("loan_purpose"));
				allDetailsResponse.setLoanPurpose(loanPurpose);
				String periodicityInstallment = String.valueOf(rs.getString("periodicity_installment"));
				allDetailsResponse.setPeriodicityInstallment(periodicityInstallment);
				String generalRemarks = String.valueOf(rs.getString("general_remarks"));
				allDetailsResponse.setGeneralRemarks(generalRemarks);
				String fileName = String.valueOf(rs.getString("name"));
				allDetailsResponse.setFileName(fileName);

			}
		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			e.printStackTrace();

		}
		return allDetailsResponse;
		// return (List<NewCaseResponse>) newCaseResponse;
	}

	public List<LeadLoanResponse> getAllRefs() {

		Connection con = null;
		Statement stmt = null;
		LeadLoanResponse leadLoan = new LeadLoanResponse();
		List<LeadLoanResponse> leadLoanList = new ArrayList<>();

		try {
			con = PostgreConnection.getConnection();

			stmt = con.createStatement();
			//String query = "select l.lead_ref_no, l.cust_id, l.cust_name, l.processing_status, ld.loan_amount, ld.currency_type from lead as l inner join loan_details ld on ld.custid = l.cust_id";
			String query = "select l.lead_ref_no as case_refno, l.cust_id, l.cust_name,l.processing_status as status, ld.loan_amount, ld.currency_type from lead as l inner join loan_details ld on ld.custid = l.cust_id UNION select ld.reffernce_number as case_refno, l.cust_id, l.cust_name, l.processing_status as status, ld.loan_amount, ld.currency_type from lead as l inner join loan_details ld on ld.custid = l.cust_id";
			System.out.println("Formed query :" + query);
			ResultSet rs = stmt.executeQuery(query);

			while (rs.next()) {

				leadLoan.setRefNo(rs.getString("case_refno"));
				leadLoan.setCustId(rs.getLong("cust_id"));
				leadLoan.setCustName(rs.getString("cust_name"));
				leadLoan.setLoanAmount(rs.getLong("loan_amount"));
				leadLoan.setCurrency(rs.getString("currency_type"));
				leadLoan.setProcessingStatus(rs.getString("status"));
				leadLoanList.add(new LeadLoanResponse(leadLoan.getRefNo(), leadLoan.getCustId(), leadLoan.getCustName(),
						leadLoan.getLoanAmount(), leadLoan.getCurrency(), leadLoan.getProcessingStatus()));

			}

		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			e.printStackTrace();

		}
		return leadLoanList;
	}

	public void saveRaiseDiscrepancy(String refNo, String dicripancyReason) {
		Connection con = null;
		Statement stmt = null;

		try {
			con = PostgreConnection.getConnection();
			String status = "Inprogress";	
			stmt = con.createStatement();
			String query = "UPDATE loan_details SET dicripancy_reason =" + "'" + dicripancyReason + "'"
					+ " WHERE reffernce_number =" + "'" + refNo + "'";
			System.out.println("Formed query :" + query);
			String query1 = "UPDATE loan_details SET processing_status =" + "'" + status + "'"
					+ " WHERE reffernce_number =" + "'" + refNo + "'";
			stmt.executeUpdate(query);
			stmt.executeUpdate(query1);

		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			e.printStackTrace();

		}

	}

	public void saveLoanDiscripancyDetials(String discripancyReason, String resolutionReason, String resolvedStatus,
			String refNo) {
		    if (resolvedStatus.equalsIgnoreCase("yes")) {	      
	    	Connection con = null;
            Statement stmt = null;
            try {
                con = PostgreConnection.getConnection();
                String status = "Completed";
                stmt = con.createStatement();
                String query = "UPDATE loan_details SET processing_status =" + "'" + status + "'"
                        + " WHERE reffernce_number =" + "'" + refNo + "'";
                stmt.executeUpdate(query);
            } catch (Exception e) {
                System.err.println(e.getClass().getName() + ": " + e.getMessage());
                e.printStackTrace();
            }
	    }
		    if (resolvedStatus.equalsIgnoreCase("no")) {	      
		    	Connection con = null;
	            Statement stmt = null;
	            try {
	                con = PostgreConnection.getConnection();
	                String status = "Updated";
	                stmt = con.createStatement();
	                String query = "UPDATE loan_details SET processing_status =" + "'" + status + "'"
	                        + " WHERE reffernce_number =" + "'" + refNo + "'";
	                stmt.executeUpdate(query);
	            } catch (Exception e) {
	                System.err.println(e.getClass().getName() + ": " + e.getMessage());
	                e.printStackTrace();
	            }
		    }
		loanRepository.saveLoanDiscripancyDetials(discripancyReason, resolutionReason, resolvedStatus, refNo);
	}
	

	public LoanDiscrepancyDetailsResponse getLoanDiscrepancyDetials(String refNo) {
		LoanDiscrepancyDetailsResponse lddr = new LoanDiscrepancyDetailsResponse();
		LoanDetails loandetail = loanRepository.getLoanDiscrepancyDetials(refNo);
		lddr.setDicripancyReason(loandetail.getDicripancyReason());
		lddr.setResolutionReason(loandetail.getResolutionReason());
		lddr.setResolvedStatus(loandetail.getResolvedStatus());
		return lddr;
	}
	

}
