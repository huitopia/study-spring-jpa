package com.example.studyspringjpa.response;

public class SuccessResult<T> {
    private String message;
    private String status;
    private T data;

    public SuccessResult(SuccessType successType) {
        this.message = successType.getMessage();
        this.status = "OK";
        this.data = null;
    }

    public SuccessResult(SuccessType successType, String customMessage, T data) {
        this.message = customMessage != null ? customMessage : successType.getMessage();
        this.status = "OK";
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
