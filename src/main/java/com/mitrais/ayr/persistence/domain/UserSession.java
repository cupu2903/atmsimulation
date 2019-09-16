package com.mitrais.ayr.persistence.domain;

public class UserSession {
    public static Account accountCache;

    public static Account getAccountCache() {
        return accountCache;
    }

    public static void setAccountCache(Account accountCache) {
        UserSession.accountCache = accountCache;
    }
}
