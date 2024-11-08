package com.example.studyspringjpa.common.exception.handler;

import com.example.studyspringjpa.common.exception.specific.CustomException;
import com.example.studyspringjpa.common.ErrorResponse;
import com.example.studyspringjpa.common.ErrorType;
import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    // CustomException 처리
    @ExceptionHandler(CustomException.class)
    public ResponseEntity<ErrorResponse> handleCustomException(CustomException ex) {
        ErrorResponse errorResponse = new ErrorResponse(ex.getErrorType(), ex.getMessage());
        HttpStatus status = getHttpStatusForErrorType(ex.getErrorType());
        return ResponseEntity.status(status).body(errorResponse);
    }

    // ValidationException 처리
    @ExceptionHandler({MethodArgumentNotValidException.class, ConstraintViolationException.class})
    public ResponseEntity<ErrorResponse> handleValidationException(Exception ex) {
        ErrorType errorType = ErrorType.VALIDATION_ERROR;
        String errorMessage = buildValidationErrorMessage(ex);
        ErrorResponse errorResponse = new ErrorResponse(errorType, errorMessage);
        HttpStatus status = getHttpStatusForErrorType(errorType);
        return ResponseEntity.status(status).body(errorResponse);
    }

    // 기타 예외 처리
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleOtherExceptions(Exception ex) {
        ErrorType errorType = ErrorType.INTERNAL_SERVER_ERROR;
        String errorMessage = "Unexpected error: " + ex.getMessage();
        ErrorResponse errorResponse = new ErrorResponse(errorType, errorMessage);
        HttpStatus status = getHttpStatusForErrorType(errorType);
        return ResponseEntity.status(status).body(errorResponse);
    }

    private String buildValidationErrorMessage(Exception ex) {
        if (ex instanceof MethodArgumentNotValidException) {
            return "Validation failed: " + ex.getMessage();
        } else if (ex instanceof ConstraintViolationException) {
            return "Validation failed: " + ex.getMessage();
        }
        return "Unknown validation error";
    }

    private HttpStatus getHttpStatusForErrorType(ErrorType errorType) {
        switch (errorType) {
            case BAD_REQUEST: return HttpStatus.BAD_REQUEST;
            case UNAUTHORIZED: return HttpStatus.UNAUTHORIZED;
            case FORBIDDEN: return HttpStatus.FORBIDDEN;
            case RESOURCE_NOT_FOUND: return HttpStatus.NOT_FOUND;
            case DUPLICATE_RESOURCE: return HttpStatus.CONFLICT;
            case VALIDATION_ERROR: return HttpStatus.BAD_REQUEST;
            default: return HttpStatus.INTERNAL_SERVER_ERROR;
        }
    }
}
