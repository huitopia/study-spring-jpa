package com.example.studyspringjpa.exception.specific;

import com.example.studyspringjpa.exception.common.CustomException;
import com.example.studyspringjpa.exception.common.ErrorType;

public class DuplicateResourceException extends CustomException {
    public DuplicateResourceException(String message) {
        super(ErrorType.DUPLICATE_RESOURCE,message);
    }
}
