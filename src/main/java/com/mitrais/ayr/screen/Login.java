package com.mitrais.ayr.screen;

import com.mitrais.ayr.auth.AuthUser;
import com.mitrais.ayr.dto.DataPayload;
import com.mitrais.ayr.model.view.Component;
import com.mitrais.ayr.model.view.Screen;
import com.mitrais.ayr.util.InputValidator;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static com.mitrais.ayr.model.view.util.EnumViewUtil.ComponentType.*;

public class Login extends UIAdapter {

    private static String getAcctNo(Scanner sc) {
        System.out.println("Please Enter Your Account Number: ");
        String accNum = sc.next();
        if (!InputValidator.validate(accNum)) {
            System.out.println("Please Input Number [0-9] only");
            return null;
        }
        return accNum;
    }

    private static String getPin(Scanner sc) {
        System.out.println("Enter Your PIN: ");
        String pin = sc.next();
        if (!InputValidator.validate(pin)) {
            System.out.println("Please Input Number [0-9] only");
            return null;
        }
        return pin;

    }

    public static String showLoginScreen(Scanner sc) {
        String acctNo = null;
        while (acctNo == null){
            acctNo = getAcctNo(sc);
        }
        String pin  = null;
        while (pin == null){
            pin = getPin(sc);
        }
        return AuthUser.auth(acctNo, pin);
    }

    @Override
    public Screen construct() {
        Screen sc = new Screen();
        sc.setScreenId("1");
        sc.setScreenName("Login");

        Component compAcctNo = new Component("11", FORM, "Please Enter Your Account Number: ", null, null, null);
        compAcctNo.setMaxLength(11);
        compAcctNo.setMinLength(6);
        compAcctNo.setFixedLength(false);
        compAcctNo.setInputType(1);
        Component compPIN = new Component("12", FORM, "Enter Your PIN: ", null, null, null);
        compAcctNo.setMaxLength(6);
        compAcctNo.setFixedLength(true);
        compAcctNo.setInputType(1);

        List<Component> loginComponent = new ArrayList<>();
        loginComponent.add(compAcctNo);
        loginComponent.add(compPIN);
        sc.setComponent(loginComponent);
        return sc;
    }

    @Override
    public void notify(List<DataPayload> data) {

    }
}
