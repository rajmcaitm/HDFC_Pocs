package com.hdfc.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hdfc.dto.ChequeStatusDto;
import com.hdfc.entities.Cheque;
import com.hdfc.repository.ChequeStatusRepository;
import com.hdfc.service.ChequeStatusService;

@Service
public class ChequeStatusServiceImpl implements ChequeStatusService {
	@Autowired
	ChequeStatusRepository chequeStatusRepository;

	@Override
	public ChequeStatusDto getChequeStatusDetails(Long cheque_acc_no, Long chequeNo) {
		Cheque csd = chequeStatusRepository.findByChequeAccountNo(cheque_acc_no);
		ChequeStatusDto chequestatusdto = new ChequeStatusDto();
		chequestatusdto.setChequeNo(csd.getChequeNo());
		chequestatusdto.setChequeStatus(csd.getChequeStatus());
		chequestatusdto.setChequeAmount(csd.getChequeAmount());
		chequestatusdto.setClearingDate(csd.getClearingDate());
		chequestatusdto.setPaidTo(csd.getPaidTo());
		//ChequeStatusDto csd1 = new ChequeStatusDto("NA",0.00);
		if(chequestatusdto.getChequeStatus().equalsIgnoreCase("UNUSED") || chequestatusdto.getChequeStatus()== null) {
			
			chequestatusdto.setPaidTo("NA"); 
			chequestatusdto.setChequeAmount(0.00);
			 
			//csd.setClearingDate("DD/MM/YYYY");
		    
			return chequestatusdto;
		}
		else if(chequestatusdto.getChequeStatus().equalsIgnoreCase("paid"))
			return chequestatusdto;
		else 
		return null;
	
	}

}