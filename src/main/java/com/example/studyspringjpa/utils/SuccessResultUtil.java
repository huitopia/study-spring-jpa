package com.example.studyspringjpa.utils;

import com.example.studyspringjpa.response.SuccessResult;
import com.example.studyspringjpa.response.SuccessType;
import org.springframework.http.ResponseEntity;

public class SuccessResultUtil {
    // 기본 메시지 사용, 데이터와 함께 반환
    public static <T> ResponseEntity<SuccessResult<T>> success(SuccessType successType, T data) {
        SuccessResult<T> successResult = new SuccessResult<>(successType, null, data);
        return ResponseEntity.ok(successResult);
    }

    // 커스텀 메시지 추가, 데이터와 함께 반환
    public static <T> ResponseEntity<SuccessResult<T>> success(SuccessType successType, String customMessage, T data) {
        SuccessResult<T> successResult = new SuccessResult<>(successType, customMessage, data);
        return ResponseEntity.ok(successResult);
    }

    // 데이터 없이 기본 메시지만 반환
    public static ResponseEntity<SuccessResult<Void>> success(SuccessType successType) {
        SuccessResult<Void> successResult = new SuccessResult<>(successType);
        return ResponseEntity.ok(successResult);
    }
}
