package com.mitrais.ayr.service;

import com.mitrais.ayr.dto.AccountDto;
import com.mitrais.ayr.persistence.IOperations;
import com.mitrais.ayr.persistence.domain.Account;
import org.springframework.security.core.GrantedAuthority;

import java.math.BigDecimal;
import java.util.Collection;

public interface AccountService extends IOperations<Account, String> {

    public boolean checkBalance(Account acct, BigDecimal nominal);

    String createToken(Account account);

    AccountDto asUserDto(String acctNo);
}
