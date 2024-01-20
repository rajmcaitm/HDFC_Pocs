package com.hdfc.remittance.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hdfc.remittance.dto.PaymentDetailsResponse;
import com.hdfc.remittance.entity.AccountDetails;
import com.hdfc.remittance.repository.GetPaymentDetailsRepository;

@Service
public class GetPaymentDetailsService {
	@Autowired
	GetPaymentDetailsRepository getPaymentDetailsRepository;

	public List<String> getListAccPaymentDetailsService(Long custId, String currency) {

		List<String> listacc = new ArrayList<>();
		List<AccountDetails> accDetails = getPaymentDetailsRepository.findListAccByCustId(custId);
		for (int i = 0; i < accDetails.size(); i++) {
			String fromAcc = accDetails.get(i).getAccNo().substring(11);
			String initilize = null;
			if (fromAcc.equalsIgnoreCase("INR") || fromAcc.equalsIgnoreCase(currency)) {
				initilize = accDetails.get(i).getAccNo();
				listacc.add(initilize);
			}
		}

		return listacc;
	}

	public PaymentDetailsResponse getPaymentDetailsService(String accNum, String currency) {
		PaymentDetailsResponse pdr = new PaymentDetailsResponse();
		AccountDetails accDetails = getPaymentDetailsRepository.findPaymentDetailsByAccNum(accNum);
		String currBalance = currency + "-" + String.valueOf(accDetails.getBalance());
		pdr.setAccountNum(accDetails.getAccNo());
		pdr.setBalance(currBalance);
		pdr.setRemittanceCurrency(accDetails.getCurrencyType());
		return pdr;
	}
}
