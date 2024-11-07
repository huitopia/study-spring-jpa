package com.example.studyspringjpa.exception.common;

public class CustomException extends RuntimeException {
    private final ErrorType errorType;  // ErrorType을 필드로 추가
    private final String message;

    public CustomException(ErrorType errorType, String message) {
        super(message);  // 메시지는 부모 클래스 RuntimeException에 전달
        this.errorType = errorType;  // ErrorType은 CustomException 클래스에서 처리
        this.message = message;
    }

    public ErrorType getErrorType() {
        return errorType;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
