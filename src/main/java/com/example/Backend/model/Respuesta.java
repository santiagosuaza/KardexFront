package com.example.Backend.model;

public class Respuesta {
    private Object data;
    private Integer code;
    private Boolean status;
    private String message;

    public Respuesta(Object data, Integer code, Boolean status, String message) {
        this.data = data;
        this.code = code;
        this.status = status;
        this.message = message;
    }

    public Respuesta() {
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
