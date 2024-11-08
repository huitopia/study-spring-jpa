package com.example.studyspringjpa.common;

public enum ErrorType {
    /* 400 : 실패 */
    BAD_REQUEST("잘못된 요청입니다."),
    VALIDATION_ERROR("유효성 검사 오류"),
    /* 401 : 인증 안됨 */
    UNAUTHORIZED("인증되지 않은 접근입니다."),
    /* 403 : 권한 없음 */
    FORBIDDEN("권한이 없습니다."),
    /* 404 : 리소스 못 찾음 */
    RESOURCE_NOT_FOUND("리소스를 찾을 수 없습니다."),
    /* 409 : 중복 */
    DUPLICATE_RESOURCE("중복된 항목이 존재합니다."),
    /* 500 : 예상치 못한 오류 */
    INTERNAL_SERVER_ERROR("내부 서버 오류가 발생했습니다.");

    private final String message;

    ErrorType(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
