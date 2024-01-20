package com.hdfc.remittance.service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.ParseException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

import com.hdfc.remittance.connection.PostgreConnection;
import com.hdfc.remittance.dto.GetPayeeDetails;
import com.hdfc.remittance.dto.SmsPojo;
import com.hdfc.remittance.entity.ChargesDetails;
import com.hdfc.remittance.entity.ChargesDetailsReq;
import com.hdfc.remittance.repository.ChargesRepository;
import com.hdfc.remittance.repository.PayeeRepository;
import com.twilio.exception.ApiException;

@Service
public class ChargesService {

	@Autowired
	ChargesRepository chargesRepository;
	
	@Autowired
	PayeeRepository payeeRepository;
	
	@Autowired
    SmsService service;

    @Autowired
    private SimpMessagingTemplate webSocket;
    
    private final String  TOPIC_DESTINATION = "/lession/sms";
	
	public ChargesDetails calculateCharges(ChargesDetailsReq chargesDetailsReq, Long payeeAccNo) {
	

		ChargesDetails chargesDetails = new ChargesDetails();

		Float fcyAmount = chargesDetailsReq.getFcyAmount();
		Float exchangeRate = chargesDetailsReq.getExchangeRate();

		Float netInr = fcyAmount * exchangeRate;
		Float swiftFee = 500.00F;
		Float fxConCharges = fcyAmount * 0.05F;
		Float processingFee = fcyAmount * 0.09F;
		Float gstProcessingFee = processingFee * 0.18F;
		Float gstOnSwiftFee = swiftFee * 0.18F;
		Float totalAmountInInr = netInr + swiftFee + fxConCharges + processingFee + gstProcessingFee
				+ gstOnSwiftFee;
		Float maxTcs=700000F;
		Float tcs = 0F;
		if(totalAmountInInr >maxTcs) {
			tcs = (totalAmountInInr - maxTcs)*0.05F;
		}
	
		
		Float netTotal =  totalAmountInInr +tcs;
		Float netFcyAmount = (netTotal/exchangeRate);
		chargesDetails.setFcyAmount(fcyAmount);
		chargesDetails.setExchangeRate(exchangeRate);
		chargesDetails.setNetInr(netInr);
		chargesDetails.setSwiftFee(swiftFee);
		chargesDetails.setFxConCharges(fxConCharges);
		chargesDetails.setProcessingFee(processingFee);
		chargesDetails.setGstProcessingFee(gstProcessingFee);
		chargesDetails.setGstOnSwift(gstOnSwiftFee);
		chargesDetails.setTotalAmountInInr(totalAmountInInr);
		chargesDetails.setTcs(tcs);
		chargesDetails.setNetTotal(netTotal);
		chargesDetails.setNetFcyAmount(netFcyAmount);
		chargesDetails.setPayeeAccNo(payeeAccNo);
		
		chargesRepository.save(chargesDetails);
		
		return chargesDetails;

	}
	
	public GetPayeeDetails payeeConfirmation(Long payeeAccNo, Long custId) {
		
		Connection con = null;
		Statement stmt = null;
		String countryCode = "+91";
		GetPayeeDetails payee = new GetPayeeDetails();
		PayeeService payeeService = new PayeeService();
		
		try {
			con = PostgreConnection.getConnection();

			stmt = con.createStatement();
			String query = "select p.accountnumber, p.accountname, p.addressline1, p.addressline2, p.swiftcode, p.city, c.fcyamount, c.totalamountininr from payee as p inner join charges as c on p.accountnumber=c.payeeaccno where accountnumber="+payeeAccNo;
			ResultSet rs = stmt.executeQuery(query);
			
			String mobileNo = countryCode + payeeRepository.getPayerMobileNo(custId);
			SmsPojo sms = new SmsPojo();
			sms.setPhoneNo(mobileNo);
			this.createOtp(sms);
				
			while (rs.next()) {

				payee.setAccountname(rs.getString("accountname"));
				payee.setAccountnumber(rs.getLong("accountnumber"));
				payee.setAddressline1(rs.getString("addressline1"));
				payee.setAddressline2(rs.getString("addressline2"));
				payee.setCity(rs.getString("city"));
				payee.setSwiftcode(rs.getString("swiftcode"));
				payee.setTotalamountininr(rs.getFloat("totalamountininr"));
				payee.setFcyamount(rs.getFloat("fcyamount"));
			}
			
		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			e.printStackTrace();

		}
		return payee;
	}
	
	public void createOtp(SmsPojo sms) throws ParseException {
		try {
			System.err.println("SMS Object : " + sms);
			service.send(sms);
		} catch (ApiException e) {
			webSocket.convertAndSend(TOPIC_DESTINATION, getTimeStamp() + ": Error sending the SMS: " + e.getMessage());
			throw e;
		}
		webSocket.convertAndSend(TOPIC_DESTINATION, getTimeStamp() + ": SMS has been sent!: " + sms.getPhoneNo());

	}

	private String getTimeStamp() {
		return DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format(LocalDateTime.now());
	}
	
}
