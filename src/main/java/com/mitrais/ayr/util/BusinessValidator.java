package com.mitrais.ayr.util;

import java.math.BigDecimal;

public class BusinessValidator {

    public String WithdrawValidator(String value){
        String rc = "00";
        Integer nominal = Integer.parseInt(value);
        if(nominal> 1000 || nominal < 10){
            rc= "30";
        }
        if(nominal % 10 != 0){
            rc = "30";
        }
        return rc;
    }
}
