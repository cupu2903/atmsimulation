package com.mitrais.ayr.persistence.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;


@Entity
@Table(name = "transaction_log")
public class TransactionLog implements Serializable {

    @Id
    @Column(name = "trx_id")
    private String trxId;
    @Column(name = "service_id")
    private String serviceId;
    @Column(name = "account_no")
    private String accountNo;
    @Column(name = "trx_indicator")
    private Integer trxIndicator;
    private BigDecimal nominal;
    @Column(name = "crt_dt")
    private LocalDateTime crtDt;
    @Column(name = "reff_no")
    private String reffNo;

    public String getReffNo() {
        return reffNo;
    }

    public void setReffNo(String reffNo) {
        this.reffNo = reffNo;
    }

    public String getTrxId() {
        return trxId;
    }

    public void setTrxId(String trxId) {
        this.trxId = trxId;
    }

    public String getServiceId() {
        return serviceId;
    }

    public void setServiceId(String serviceId) {
        this.serviceId = serviceId;
    }

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public Integer getTrxIndicator() {
        return trxIndicator;
    }

    public void setTrxIndicator(Integer trxIndicator) {
        this.trxIndicator = trxIndicator;
    }

    public BigDecimal getNominal() {
        return nominal;
    }

    public void setNominal(BigDecimal nominal) {
        this.nominal = nominal;
    }

    public LocalDateTime getCrtDt() {
        return crtDt;
    }

    public void setCrtDt(LocalDateTime crtDt) {
        this.crtDt = crtDt;
    }

    @Override
    public String toString() {
        return "TransactionDto{" +
                "trxId='" + trxId + '\'' +
                ", serviceId='" + serviceId + '\'' +
                ", accountId='" + accountNo + '\'' +
                ", trxFlag=" + trxIndicator +
                ", nominal=" + nominal +
                ", trxDate=" + crtDt +
                '}';
    }
}
