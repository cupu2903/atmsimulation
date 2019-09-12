package com.mitrais.ayr.dto;

import java.math.BigDecimal;

/**
 * @author Achmad Yusuf Ramadhan cupu2903@gmail.com
 * @version 0.4
 * @since 12/09/2019
 * represent as Response Data for Account Statement Service
 */
public class TransactionDto {
    private String trxId;
    private String trxDate;
    private String serviceName;
    private BigDecimal nominal;
    private int dcFlag;

    public String getTrxId() {
        return trxId;
    }

    public void setTrxId(String trxId) {
        this.trxId = trxId;
    }

    public String getTrxDate() {
        return trxDate;
    }

    public void setTrxDate(String trxDate) {
        this.trxDate = trxDate;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public BigDecimal getNominal() {
        return nominal;
    }

    public void setNominal(BigDecimal nominal) {
        this.nominal = nominal;
    }

    public int getDcFlag() {
        return dcFlag;
    }

    public void setDcFlag(int dcFlag) {
        this.dcFlag = dcFlag;
    }
}
