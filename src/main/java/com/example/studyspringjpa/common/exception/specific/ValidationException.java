package com.example.studyspringjpa.common.exception.specific;

import com.example.studyspringjpa.common.ErrorType;

public class ValidationException extends CustomException {
    public ValidationException(String message) {
        super(ErrorType.VALIDATION_ERROR, message);
    }
}
