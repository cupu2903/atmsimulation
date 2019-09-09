package com.mitrais.ayr.model.domain;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class AccountData {

    public static Map<String, Account> account = new HashMap<>();

    public static final void init(){
        account.put("112233", new Account("112233","012108", "John Doe", new BigDecimal(100)));
        account.put("112244", new Account("112244","932012", "Jane Doe", new BigDecimal(30)));
    }
}
