package com.example.studyspringjpa.exception.common;

public enum ErrorType {
    /* 400 : 실패 */
    BAD_REQUEST("Bad Request"),
    VALIDATION_ERROR("Validation error"),
    /* 401 : 인증 안됨 */
    UNAUTHORIZED("Unauthorized access"),
    /* 403 : 권한 없음 */
    FORBIDDEN("Forbidden access"),
    /* 404 : 리소스 못 찾음 */
    RESOURCE_NOT_FOUND("Resource not found"),
    /* 409 : 중복 */
    DUPLICATE_ID("Duplicate ID"),
    /* 500 : 예상치 못한 오류 */
    INTERNAL_SERVER_ERROR("Internal server error");

    private final String message;

    ErrorType(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
