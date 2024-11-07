package com.example.studyspringjpa.exception.common;

public class CustomException extends RuntimeException {
    private final ErrorType errorType;  // ErrorType을 필드로 추가
    // 기본 메시지 사용
    public CustomException(ErrorType errorType) {
        super(errorType.getMessage());
        this.errorType = errorType;
    }

    // 추가 메시지를 덧붙일 수 있도록 수정
    public CustomException(ErrorType errorType, String additionalMessage) {
        super(errorType.getMessage() + ": " + additionalMessage);
        this.errorType = errorType;
    }

    public ErrorType getErrorType() {
        return errorType;
    }
}
