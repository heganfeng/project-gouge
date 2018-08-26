package com.gouge.exception;

/**
 * Created by grandfen on 17/4/24.
 */
public class ApiException extends RuntimeException{

    String code = "-1";

    public ApiException(String message) {
        super(message);
    }

    public ApiException(String code, String message) {
        super(message);
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
