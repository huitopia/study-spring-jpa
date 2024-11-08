package com.example.studyspringjpa.common.exception.specific;

import com.example.studyspringjpa.common.ErrorType;

public class CustomException extends RuntimeException {
    private final ErrorType errorType;  // ErrorType을 필드로 추가
    // 기본 메시지 사용
    public CustomException(ErrorType errorType) {
        super(errorType.getMessage());
        this.errorType = errorType;
    }

    // 추가 메시지가 있으면 기본 메시지 없이 커스텀 메시지만 사용
    public CustomException(ErrorType errorType, String additionalMessage) {
        super(additionalMessage != null && !additionalMessage.isEmpty() ? additionalMessage : errorType.getMessage());  // 추가 메시지가 있으면 사용, 없으면 기본 메시지 사용
        this.errorType = errorType;
    }

    public ErrorType getErrorType() {
        return errorType;
    }
}
