package com.mitrais.ayr.dto;

/**
 * @author Achmad Yusuf Ramadhan cupu2903@gmail.com
 * @version 0.4
 * @since 12/09/2019
 * ReqLoginDto represent as DTO for Login Request Service
 */
public class ReqLoginDto {
    private String accountNo;
    private String pin;

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }
}
