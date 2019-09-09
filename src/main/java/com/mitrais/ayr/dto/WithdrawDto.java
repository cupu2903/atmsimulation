package com.mitrais.ayr.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class WithdrawDto extends ResponseDto {

    private BigDecimal balance;

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }
}
