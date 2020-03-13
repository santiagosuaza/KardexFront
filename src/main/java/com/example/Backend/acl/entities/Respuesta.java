package com.example.Backend.acl.entities;

import lombok.Data;

@Data
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
}
