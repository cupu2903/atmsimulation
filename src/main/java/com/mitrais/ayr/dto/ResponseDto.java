package com.mitrais.ayr.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class ResponseDto {
    private String respCode;
    private String message;
    private BigDecimal balance;

    public ResponseDto() {
    }

    public ResponseDto(String respCode, String message, BigDecimal balance) {
        this.respCode = respCode;
        this.message = message;
        this.balance = balance;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public String getRespCode() {
        return respCode;
    }

    public void setRespCode(String respCode) {
        this.respCode = respCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "ResponseDto{" +
                "respCode='" + respCode + '\'' +
                ", message='" + message + '\'' +
                ", balance=" + balance +
                '}';
    }
}
