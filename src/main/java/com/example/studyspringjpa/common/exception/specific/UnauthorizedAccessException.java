package com.example.studyspringjpa.common.exception.specific;

import com.example.studyspringjpa.common.ErrorType;

public class UnauthorizedAccessException extends CustomException {
    public UnauthorizedAccessException(String message) {
        super(ErrorType.UNAUTHORIZED, message);
    }
}
