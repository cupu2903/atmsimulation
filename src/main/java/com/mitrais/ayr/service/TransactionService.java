package com.mitrais.ayr.service;

import com.mitrais.ayr.dto.FundTransferDto;
import com.mitrais.ayr.dto.ResponseDto;
import com.mitrais.ayr.dto.TransactionDto;
import com.sun.xml.internal.bind.v2.model.core.ID;

public interface TransactionService<T extends TransactionDto> {

    void trx(T T);

}
