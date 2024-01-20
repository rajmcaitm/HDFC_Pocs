package com.hdfc.remittance.service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hdfc.remittance.connection.PostgreConnection;
import com.hdfc.remittance.dto.GetPayeeDetails;
import com.hdfc.remittance.entity.AccountDetails;
import com.hdfc.remittance.entity.PayeeDetails;
import com.hdfc.remittance.repository.AccountRepository;

@Service
public class AccountService {

	@Autowired
	AccountRepository accountRepository;

	public List<AccountDetails> findAllById(Long custId) {

		return accountRepository.findByCustomerId(custId);

	}

	public void updateRemainingBalance(String accountNo, Float fcyAmount) {

		Connection con = null;
		Statement stmt = null;
		Long balance = null;
		Float data = null;
		try {
			con = PostgreConnection.getConnection();
			stmt = con.createStatement();
			String getBalance = "select balance from account where accno="+"'"+accountNo+"'";
			stmt.execute(getBalance);
			System.out.println("Balace :"+getBalance);
			ResultSet rs = stmt.executeQuery(getBalance);
			while(rs.next()) {
				balance = rs.getLong("balance");
				System.err.println("bal "+balance);
			}
			data = balance - fcyAmount;
			String updateBalance = "update account set balance="+data + " where accno="+"'"+accountNo+"'";
			System.out.println("Formed Query :"+updateBalance);
			stmt.executeUpdate(updateBalance);

		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			e.printStackTrace();

		}
	}
	
	public List<String> getListOfAccountNo(Long custId) {

		Connection con = null;
		Statement stmt = null;
		List<String> accountList = new ArrayList<>();
		try {
			con = PostgreConnection.getConnection();
			stmt = con.createStatement();
			String accList = "select accno from account where custid = " + custId;
			ResultSet rs = stmt.executeQuery(accList);
			while (rs.next()) {

				accountList.add(rs.getString("accno"));

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return accountList;
	}

}
