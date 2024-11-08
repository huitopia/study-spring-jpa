package com.example.studyspringjpa.common.exception.specific;

import com.example.studyspringjpa.common.ErrorType;

public class ForbiddenAccessException extends CustomException {
    public ForbiddenAccessException(String message) {
        super(ErrorType.FORBIDDEN,message);
    }
}
