package com.mitrais.ayr.service;

import com.mitrais.ayr.model.IOperations;
import com.mitrais.ayr.model.domain.Account;

import java.math.BigDecimal;

public interface AccountService extends IOperations<Account, String> {

    public boolean checkBalance(Account acct, BigDecimal nominal);
}
