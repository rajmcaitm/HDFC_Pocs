package com.hdfc.service;

import org.springframework.stereotype.Service;

import com.hdfc.dto.ChequeStatusDto;
@Service
public interface ChequeStatusService {

	ChequeStatusDto getChequeStatusDetails(Long cheque_acc_no,Long chequeNo);

}
