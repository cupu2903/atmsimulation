package com.mitrais.ayr.dto;

import java.math.BigDecimal;

public class FundTransferDto {

    private String destAcct;
    private BigDecimal amount;
    private String refNo;
    private BigDecimal balance;

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public String getDestAcct() {
        return destAcct;
    }

    public void setDestAcct(String destAcct) {
        this.destAcct = destAcct;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getRefNo() {
        return refNo;
    }

    public void setRefNo(String refNo) {
        this.refNo = refNo;
    }
}
