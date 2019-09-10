package com.mitrais.ayr.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class ResponseDto<T> {
    private String respCode;
    private String message;
    private T data;

    public ResponseDto() {
    }

    public ResponseDto(String respCode, String message) {
        this.respCode = respCode;
        this.message = message;
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

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "ResponseDto{" +
                "respCode='" + respCode + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
