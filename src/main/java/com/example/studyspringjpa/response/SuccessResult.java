package com.example.studyspringjpa.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.springframework.http.HttpStatus;
/* JsonInclude : null 값일 대 필드를 JSON 응답에서 제외 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SuccessResult<T> {
    private String message;
    private HttpStatus httpStatus;  // HTTP 상태 코드 필드 이름을 httpStatus로 변경
    private T data;

    public SuccessResult(SuccessType successType) {
        this.message = successType.getMessage();
        this.httpStatus = successType.getHttpStatus();  // SuccessType에 따라 HTTP 상태 코드 설정
        this.data = null;
    }
    public SuccessResult(SuccessType successType,T data) {
        this.message = successType.getMessage();
        this.httpStatus = successType.getHttpStatus();
        this.data = data;
    }
    public SuccessResult(SuccessType successType, String customMessage) {
        this.message = customMessage;
        this.httpStatus = successType.getHttpStatus();
        this.data = null;
    }
    public SuccessResult(SuccessType successType, String customMessage, T data) {
        this.message = customMessage != null ? customMessage : successType.getMessage();
        this.data = data;
        this.httpStatus = successType.getHttpStatus();
    }

    // getter 및 setter
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public void setHttpStatus(HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
