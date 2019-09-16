package com.mitrais.ayr.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class FundTransferDto {

    private String refNo;
    private String destAccount;
    private BigDecimal nominal;
    private BigDecimal balance;
    private LocalDateTime trxDate;

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public BigDecimal getNominal() {
        return nominal;
    }

    public void setNominal(BigDecimal nominal) {
        this.nominal = nominal;
    }

    public LocalDateTime getTrxDate() {
        return trxDate;
    }

    public void setTrxDate(LocalDateTime trxDate) {
        this.trxDate = trxDate;
    }

    public String getDestAccount() {
        return destAccount;
    }

    public void setDestAccount(String destAccount) {
        this.destAccount = destAccount;
    }

    public String getRefNo() {
        return refNo;
    }

    public void setRefNo(String refNo) {
        this.refNo = refNo;
    }

    @Override
    public String toString() {
        return "FundTransferDto{" +
                "refNo='" + refNo + '\'' +
                ", destAccount='" + destAccount + '\'' +
                "TransactionDto=" + super.toString() + '\'' +
                '}';
    }
}
