package com.mitrais.ayr.auth;

import com.mitrais.ayr.persistence.domain.Account;
import com.mitrais.ayr.persistence.domain.AccountData;
import com.mitrais.ayr.persistence.domain.UserSession;

public class AuthUser {

    public static String auth(String acctNo, String pin){
        Account account = AccountData.account.get(acctNo);
        if(account == null){
            return "53";
        }
        if(!account.getPin().equals(pin)){
            return "55";
        }
        UserSession.setAccountCache(account);
        return "00";
    }
}
