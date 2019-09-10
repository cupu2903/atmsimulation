package com.mitrais.ayr.dto;

import java.math.BigDecimal;

public class FundTransferDto extends TransactionDto {

    private String refNo;
    private String destAccount;

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
