package com.mitrais.ayr.util;

public class ResponseHandler {

    public static String getMessage(String respCode){
        String message;
        switch (respCode) {
            case "53":
                message = "Invalid Account Number";
                break;
            case "55":
                message = "Invalid PIN";
                break;
            case "51":
                message = "Insufficient Balance";
                break;
            case "14":
                message = "Destination Account Not Found";
                break;
            case "75":
                message = "Your Account Was Blocked, Due to Your Failure Input Time Exceeded";
            default:
                message = "Unknown Error";
                break;
        }
        return message;
    }
}
