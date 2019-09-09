package com.mitrais.ayr.dto;

public class DataPayload {

    private String id;
    private String value;
    private Integer type;

    public DataPayload() {
    }

    public DataPayload(String id, String value, Integer type) {
        this.id = id;
        this.value = value;
        this.type = type;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "DataPayload{" +
                "id='" + id + '\'' +
                ", value='" + value + '\'' +
                ", type=" + type +
                '}';
    }
}
