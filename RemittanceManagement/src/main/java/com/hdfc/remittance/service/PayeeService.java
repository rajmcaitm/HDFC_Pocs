package com.hdfc.remittance.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

import com.hdfc.remittance.connection.PostgreConnection;
import com.hdfc.remittance.dto.BankDetails;
import com.hdfc.remittance.dto.BankDetailsMapping;
import com.hdfc.remittance.dto.PayeeDetailsResponse;
import com.hdfc.remittance.dto.SmsPojo;
import com.hdfc.remittance.entity.PayeeDetails;
import com.hdfc.remittance.entity.RemittencePaymentDetails;
import com.hdfc.remittance.repository.PayeeRepository;
import com.hdfc.remittance.repository.PaymentDetailsRepository;
import com.twilio.exception.ApiException;

@Service
public class PayeeService {

	@Autowired
	PayeeRepository payeeRepository;
	
	@Autowired
	PaymentDetailsRepository paymentDetailsRepository;
	
	@Autowired
    SmsService service;

    @Autowired
    private SimpMessagingTemplate webSocket;

    private final String  TOPIC_DESTINATION = "/lession/sms";
	
	public PayeeDetails addPayee(PayeeDetails PayeeDetails, Long custId) throws ParseException {
		PayeeDetails.setCustId(custId);
		String countryCode = "+91";

		String mobileNo = countryCode + payeeRepository.getPayerMobileNo(custId);
		System.err.println("Payer mobile number : " + mobileNo);
		SmsPojo sms = new SmsPojo();
		sms.setPhoneNo(mobileNo);
		this.createOtp(sms);
		PayeeDetails.setRefNo(this.generate1());
		PayeeDetails payeeDetails = payeeRepository.save(PayeeDetails);
		String lastThreeDigit = mobileNo.substring(mobileNo.length() - 3);
		System.err.println("last three digit :"+lastThreeDigit);
		payeeDetails.setPayeeMobileNo("Please enter OTP sent on registered mobile number *******"+lastThreeDigit);
		return payeeDetails;
	}
	
	
	public int generateLeadId() {
		Random random = new Random();
		return random.nextInt(100000);
	}

	public String generate1() {
		return "F" + this.generateLeadId();
	}
	
	public String generate2() {
		return "E" + this.generateLeadId();
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
	
	public BankDetails getBankDetails(String swiftCode) throws IOException  {

		BankDetails details = new BankDetails();
		File myFile = new File("D:\\workspace11\\RemittanceManagement\\src\\main\\resources\\file\\SWIFT CODES.xlsx");
		FileInputStream fis = new FileInputStream(myFile);
		XSSFWorkbook myWorkBook = new XSSFWorkbook(fis);
		XSSFSheet mySheet = myWorkBook.getSheetAt(0);
		List<BankDetailsMapping> bankDetailsList = new ArrayList<BankDetailsMapping>();
		
		for(int i=mySheet.getFirstRowNum()+1;i<=mySheet.getLastRowNum();i++){
			BankDetailsMapping bankDetails = new BankDetailsMapping();
            Row ro=mySheet.getRow(i);
            for(int j=ro.getFirstCellNum();j<=ro.getLastCellNum();j++){
                Cell ce = ro.getCell(j);
              if(j==0){  
                  //If you have Header in text It'll throw exception because it won't get NumericValue
            	  bankDetails.setNo(ce.getNumericCellValue());
              }
              if(j==1){
            	  bankDetails.setInstitution(ce.getStringCellValue());
              }
              if(j==2){
            	  bankDetails.setCityHeading(ce.getStringCellValue());
              }if(j==3){
            	  bankDetails.setCountry(ce.getStringCellValue());
              }if(j==4){
            	  bankDetails.setBranchName(ce.getStringCellValue());
              } if(j==5){
            	  bankDetails.setSwiftCode(ce.getStringCellValue());
              }  
            }
            bankDetailsList.add(bankDetails);
          
            for (int k = 0; k < bankDetailsList.size(); k++) {
				if (swiftCode.equalsIgnoreCase(bankDetailsList.get(k).getSwiftCode())) {
					details.setCity(bankDetailsList.get(k).getCityHeading());
					details.setBankName(bankDetailsList.get(k).getInstitution());
					details.setCountry(bankDetailsList.get(k).getCountry());
				}
			}
        }
		return details;

	}
	
	public PayeeDetails updatePayee(PayeeDetails payeeDetails, Long id) throws ParseException {

		String countryCode = "+91";
		PayeeDetails existingPayeeDetails = payeeRepository.findById(id).get();
		existingPayeeDetails.setAccountNumber(payeeDetails.getAccountNumber());
		existingPayeeDetails.setAccountName(payeeDetails.getAccountName());
		existingPayeeDetails.setNickName(payeeDetails.getNickName());
		existingPayeeDetails.setAddressLine1(payeeDetails.getAddressLine1());
		existingPayeeDetails.setAddressLine2(payeeDetails.getAddressLine2());
		existingPayeeDetails.setSwiftCode(payeeDetails.getSwiftCode());
		existingPayeeDetails.setCity(payeeDetails.getCity());
		existingPayeeDetails.setBankName(payeeDetails.getBankName());
		existingPayeeDetails.setCountry(payeeDetails.getCountry());
		existingPayeeDetails.setiBan(payeeDetails.getiBan());
		
		String mobileNo = countryCode + payeeRepository.getPayerMobileNo(payeeDetails.getCustId());
		SmsPojo sms = new SmsPojo();
		sms.setPhoneNo(mobileNo);
		this.createOtp(sms);
		existingPayeeDetails.setRefNo(this.generate2());
		PayeeDetails payeeResponse = payeeRepository.save(existingPayeeDetails);
		String lastThreeDigit = mobileNo.substring(mobileNo.length() - 3);
		System.err.println("last three digit :" + lastThreeDigit);
		payeeDetails.setPayeeMobileNo("Please enter OTP sent on registered mobile number *******" + lastThreeDigit);
		return payeeResponse;
	}

  	public PayeeDetailsResponse fetchPayeeDetails(Long accountNo) {

		PayeeDetails payeeDetails = payeeRepository.getPayeeDetailsByAccountNo(accountNo);
		PayeeDetailsResponse payeeDetailsResponse = new PayeeDetailsResponse();
		payeeDetailsResponse.setAccountname(payeeDetails.getAccountName());
		payeeDetailsResponse.setAccountnumber(payeeDetails.getAccountNumber());
		payeeDetailsResponse.setNickname(payeeDetails.getNickName());
		payeeDetailsResponse.setAddressline1(payeeDetails.getAddressLine1());
		payeeDetailsResponse.setAddressline2(payeeDetails.getAddressLine2());
		payeeDetailsResponse.setSwiftcode(payeeDetails.getSwiftCode());
		payeeDetailsResponse.setCity(payeeDetails.getCity());
		return payeeDetailsResponse;
	}
  	
  	public RemittencePaymentDetails savePaymentDetails(RemittencePaymentDetails remittencePaymentDetails) {
        return paymentDetailsRepository.save(remittencePaymentDetails);
    }
  	
	public String payeeConfirmationRefNo(String fromAccount) throws SQLException {
		
		String message = "***Transaction processed successfully with Ref No:";
		Connection con = null;
		Statement stmt = null;
		
		String refNo = this.generateConfirmationRefNo();
		con = PostgreConnection.getConnection();
		stmt = con.createStatement();
		String query = "update remitt_payment set refNo="+"'"+refNo+"'"+" where fromaccount="+"'"+fromAccount+"'";
		System.err.println("Query :"+query);
		stmt.executeUpdate(query);
		
		return message+refNo;

	}

	public int generateRefNo() {
		Random random = new Random();
		return random.nextInt(1000000000);
	}

	public String generateConfirmationRefNo() {
		return "ORM" + this.generateRefNo();
	}
  	
}
