package com.mitrais.ayr.dto;

/**
 * @author Achmad Yusuf Ramadhan cupu2903@gmail.com
 * @version 0.4
 * @since 12/09/2019
 * Data Transfer Object represent to use as a response for login and will be the owner of current session
 */
public class AccountDto {
    private String accountNo;
    private String name;
    private String token;

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
