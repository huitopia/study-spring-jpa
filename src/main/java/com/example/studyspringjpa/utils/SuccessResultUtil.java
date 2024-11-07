package com.example.studyspringjpa.utils;

import com.example.studyspringjpa.response.SuccessResult;
import com.example.studyspringjpa.response.SuccessType;
import org.springframework.http.ResponseEntity;

public class SuccessResultUtil {
    // defaultMessage
    public static ResponseEntity<SuccessResult<Void>> success(SuccessType successType) {
        SuccessResult<Void> successResult = new SuccessResult<>(successType);
        return new ResponseEntity<>(successResult, successResult.getHttpStatus());
    }

    // defaultMessage + data
    public static <T> ResponseEntity<SuccessResult<T>> success(SuccessType successType, T data) {
        SuccessResult<T> successResult = new SuccessResult<>(successType, data);
        return new ResponseEntity<>(successResult, successResult.getHttpStatus());
    }

    // customMessage
    public static ResponseEntity<SuccessResult<Void>> success(SuccessType successType, String customMessage) {
        SuccessResult<Void> successResult = new SuccessResult<>(successType, customMessage);
        return new ResponseEntity<>(successResult, successResult.getHttpStatus());
    }

    // customMessage + data
    public static <T> ResponseEntity<SuccessResult<T>> success(SuccessType successType, String customMessage, T data) {
        SuccessResult<T> successResult = new SuccessResult<>(successType, customMessage, data);
        return new ResponseEntity<>(successResult, successResult.getHttpStatus());
    }
}
