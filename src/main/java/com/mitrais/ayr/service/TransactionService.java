package com.mitrais.ayr.service;

import com.mitrais.ayr.dto.FundTransferDto;
import com.mitrais.ayr.dto.ResponseDto;
import com.mitrais.ayr.dto.TransactionDto;

public interface TransactionService {

    public ResponseDto trx(TransactionDto dto);
}
