package com.mitrais.ayr.service.impl;

import com.mitrais.ayr.model.domain.Account;
import com.mitrais.ayr.model.domain.AccountData;
import com.mitrais.ayr.model.domain.UserSession;
import com.mitrais.ayr.service.AccountService;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class AccountServiceImpl implements AccountService {

    @Override
    public boolean checkBalance(Account acct, BigDecimal nominal) {
        BigDecimal subtract = acct.getBalance().subtract(nominal);
        if (subtract.compareTo(BigDecimal.ZERO) < 0) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public List<Account> findAll() {
        return new ArrayList<>(AccountData.account.values());
    }

    @Override
    public Account findByID(String s) {
        return AccountData.account.get(s);
    }

    @Override
    public Account create(Account entity) {
        return AccountData.account.put(entity.getAcctNo(), entity);
    }

    @Override
    public Account update(Account entity) {
        return null;
    }

    @Override
    public void delete(Account entity) {
        AccountData.account.remove(entity);
    }

    @Override
    public void deleteById(String entityId) {

    }

}
