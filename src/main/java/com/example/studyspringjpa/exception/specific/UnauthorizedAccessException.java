package com.example.studyspringjpa.exception.specific;

import com.example.studyspringjpa.exception.common.CustomException;
import com.example.studyspringjpa.exception.common.ErrorType;

public class UnauthorizedAccessException extends CustomException {
    public UnauthorizedAccessException(String message) {
        super(ErrorType.UNAUTHORIZED, message);
    }
}
