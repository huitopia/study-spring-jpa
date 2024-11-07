package com.example.studyspringjpa.exception.specific;

import com.example.studyspringjpa.exception.common.CustomException;
import com.example.studyspringjpa.exception.common.ErrorType;

public class ForbiddenAccessException extends CustomException {
    public ForbiddenAccessException(String message) {
        super(ErrorType.FORBIDDEN,message);
    }
}
