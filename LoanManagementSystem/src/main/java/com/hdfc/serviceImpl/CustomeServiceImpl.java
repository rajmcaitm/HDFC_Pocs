package com.hdfc.serviceImpl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hdfc.connection.PostgreConnection;
import com.hdfc.dto.CustomerResponse;
import com.hdfc.entities.AccountDetails;
import com.hdfc.entities.Customer;
import com.hdfc.repository.AccountDetailsRepository;
import com.hdfc.repository.CustomerRepository;
import com.hdfc.service.CustomerService;

@Service
public class CustomeServiceImpl implements CustomerService {

	@Autowired
	CustomerRepository customerRepository;
	@Autowired
	AccountDetailsRepository accountDetailsRepository;

	@Override
	public CustomerResponse findCustomerDetailsByCustId(Long custId) {
		Connection con = null;
		Statement stmt = null;
		CustomerResponse customerResponse = new CustomerResponse();

		Long data = 0L;
		try {
			con = PostgreConnection.getConnection();

			stmt = con.createStatement();
			// String query = "select acc.mobileno FROM account_details acc INNER JOIN
			// customer c ON c.custid = acc.id where custid ="+customerId;
			String query = "select ad.acc_num,ad.acc_name,ad.custaddr1,ad.custaddr2,ad.emailid,ad.iec,ad.mobileno,ad.pannumber,c.custname from account_details as ad inner join customer c on c.custid=ad.custid where c.custid="
					+ custId;
			System.out.println("SQL: " + query);
			ResultSet rs = stmt.executeQuery(query);

			while (rs.next()) {

				customerResponse.setAcc_num(rs.getLong("acc_num"));
				customerResponse.setAcc_name(rs.getString("acc_name"));
				customerResponse.setCustaddr1(rs.getString("custaddr1"));
				customerResponse.setCustaddr2(rs.getString("custaddr2"));
				customerResponse.setEmailid(rs.getString("emailid"));
				customerResponse.setIec(rs.getLong("iec"));
				customerResponse.setMobileno(rs.getLong("mobileno"));
				customerResponse.setPannumber(rs.getString("pannumber"));
				customerResponse.setCustname(rs.getString("custname"));

			}

		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			e.printStackTrace();

		}
		return customerResponse;

	}

	@Override
	public Customer createCustomer(Customer customer) {
		// TODO Auto-generated method stub
		Customer custDetailsSaved = customerRepository.save(customer);
		return custDetailsSaved;
	}

}
