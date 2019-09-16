package com.mitrais.ayr.persistence.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "atm_service")
public class ATMService implements Serializable {

    @Id
    @Column(name = "service_id")
    private String serviceId;
    @Column(name = "service_name")
    private String serviceName;
    @Column(name = "dc_flag")
    private Integer dcFlag;

    public String getServiceId() {
        return serviceId;
    }

    public void setServiceId(String serviceId) {
        this.serviceId = serviceId;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public Integer getDcFlag() {
        return dcFlag;
    }

    public void setDcFlag(Integer dcFlag) {
        this.dcFlag = dcFlag;
    }
}
