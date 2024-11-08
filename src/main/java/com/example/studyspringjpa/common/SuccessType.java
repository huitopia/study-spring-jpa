package com.example.studyspringjpa.common;

import org.springframework.http.HttpStatus;

public enum SuccessType {
    /*
    * OPERATION_SUCCESS
    *   1. 전반적인 작업 완료
    *   2. 여러 작업이 하나의 트랜잭션 안에서 처리되었을 때
    *   3. 특정 작업 없이 전체적인 프로세스 완료
    */
    OPERATION_SUCCESS("작업이 성공적으로 완료되었습니다.", HttpStatus.OK),
    DATA_SAVED("데이터가 성공적으로 저장되었습니다.", HttpStatus.CREATED),
    DATA_UPDATED("데이터가 성공적으로 수정되었습니다.",HttpStatus.OK),
    DATA_DELETED("데이터가 성공적으로 삭제되었습니다.",HttpStatus.OK),
    DATA_RETRIEVED("데이터가 성공적으로 조회되었습니다.", HttpStatus.OK);

    private final String message;
    private final HttpStatus httpStatus;

    SuccessType(String message, HttpStatus httpStatus) {
        this.message = message;
        this.httpStatus = httpStatus;
    }

    public String getMessage() {
        return message;
    }
    public HttpStatus getHttpStatus() {
        return httpStatus;
    }
}
