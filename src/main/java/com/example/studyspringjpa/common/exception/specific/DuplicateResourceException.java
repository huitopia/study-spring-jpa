package com.example.studyspringjpa.common.exception.specific;

import com.example.studyspringjpa.common.ErrorType;

public class DuplicateResourceException extends CustomException {
    public DuplicateResourceException(String message) {
        super(ErrorType.DUPLICATE_RESOURCE,message);
    }
}
