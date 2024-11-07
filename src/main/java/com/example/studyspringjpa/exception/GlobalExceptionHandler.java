package com.example.studyspringjpa.exception;

import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/*
* @controllerAdvice
*   애플리케이션 내 모든 컨트롤러에서 발생하는 예외 전역으로 처리
* @RestControllerAdvice
*   JSON 응답 형태로 여러 에러 메세지 처리
*/
@RestControllerAdvice
public class GlobalExceptionHandler {
    /*
    * @ExceptionHandler
    *   특정 예외를 처리할 메서드 지정
    */
    // 유효성 검사 오류 처리
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<String> handleValidationException(MethodArgumentNotValidException ex) {
        StringBuilder errorMessages = new StringBuilder();
        BindingResult bindingResult = ex.getBindingResult();

        // 필드 오류들을 가져와서 메시지 처리
        for (FieldError fieldError : bindingResult.getFieldErrors()) {
            errorMessages.append(fieldError.getField())
                    .append(": ")
                    .append(fieldError.getDefaultMessage())
                    .append("\n");
        }

        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(errorMessages.toString());
    }

    // 다른 예외 처리 예시: ConstraintViolationException (JSR-303, JSR-380 예외 처리)
    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<String> handleConstraintViolationException(ConstraintViolationException ex) {
        String errorMessage = "Validation failed: " + ex.getMessage();
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMessage);
    }

    // 기타 예외 처리 (예: IllegalArgumentException 등)
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> handleIllegalArgumentException(IllegalArgumentException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
    }
}
