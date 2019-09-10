package com.mitrais.ayr.service;

import com.mitrais.ayr.model.domain.Account;
import com.mitrais.ayr.model.domain.AccountData;
import com.mitrais.ayr.model.domain.UserSession;

public class AccountService {

    public Account readAccount(String acctNo){
        return AccountData.account.get(acctNo);
    }
}
