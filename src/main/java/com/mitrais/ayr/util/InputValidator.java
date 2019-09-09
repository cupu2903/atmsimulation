package com.mitrais.ayr.util;

public class InputValidator {

    public static boolean validate(String input){
        if (!input.matches("[0-9]+")) {
            return false;
        }
        return true;
    }
}
