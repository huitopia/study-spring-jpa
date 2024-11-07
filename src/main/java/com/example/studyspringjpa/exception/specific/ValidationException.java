package com.example.studyspringjpa.exception.specific;

import com.example.studyspringjpa.exception.common.CustomException;
import com.example.studyspringjpa.exception.common.ErrorType;

public class ValidationException extends CustomException {
    public ValidationException(String message) {
        super(ErrorType.VALIDATION_ERROR, message);
    }
}
