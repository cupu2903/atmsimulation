package com.mitrais.ayr.model.domain;

import java.io.Serializable;
import java.math.BigDecimal;

public class Account implements Serializable {

    private String acctNo;
    private String pin;
    private String name;
    private BigDecimal balance;

    public Account(String acctNo, String pin, String name, BigDecimal balance) {
        this.acctNo = acctNo;
        this.pin = pin;
        this.name = name;
        this.balance = balance;
    }

    public String getAcctNo() {
        return acctNo;
    }

    public void setAcctNo(String acctNo) {
        this.acctNo = acctNo;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "Account{" +
                "acctNo='" + acctNo + '\'' +
                ", pin='" + pin + '\'' +
                ", name='" + name + '\'' +
                ", balance=" + balance +
                '}';
    }
}
