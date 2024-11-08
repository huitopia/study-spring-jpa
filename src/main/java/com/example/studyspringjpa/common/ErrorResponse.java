package com.example.studyspringjpa.common;

public class ErrorResponse {
    private String code;
    private String message;

    // 생성자
    public ErrorResponse(ErrorType errorType, String message) {
        this.code = errorType.name();  // ErrorType의 name을 사용해서 코드 설정
        this.message = message;
    }

    // Getters and Setters
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}

