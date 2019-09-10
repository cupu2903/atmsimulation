package com.mitrais.ayr.dto;

import com.mitrais.ayr.model.domain.Transaction;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class WithdrawDto {

    private BigDecimal nominal;
    private BigDecimal balance;
    private LocalDateTime trxDate;

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public LocalDateTime getTrxDate() {
        return trxDate;
    }

    public void setTrxDate(LocalDateTime trxDate) {
        this.trxDate = trxDate;
    }

    public BigDecimal getNominal() {
        return nominal;
    }

    public void setNominal(BigDecimal nominal) {
        this.nominal = nominal;
    }
}
