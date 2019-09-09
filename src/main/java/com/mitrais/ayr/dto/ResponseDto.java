package com.mitrais.ayr.dto;

public class ResponseDto extends TransactionDto{
    private String respCode;
    private String message;

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
}
