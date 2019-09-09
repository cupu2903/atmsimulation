package com.mitrais.ayr.model.domain;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class UserSession {
    public static Account accountCache;

    public static Account getAccountCache() {
        return accountCache;
    }

    public static void setAccountCache(Account accountCache) {
        UserSession.accountCache = accountCache;
    }
}
