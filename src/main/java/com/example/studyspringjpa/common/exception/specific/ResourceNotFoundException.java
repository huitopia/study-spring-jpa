package com.example.studyspringjpa.common.exception.specific;

import com.example.studyspringjpa.common.ErrorType;

public class ResourceNotFoundException extends CustomException {
    public ResourceNotFoundException(String message) {
        super(ErrorType.RESOURCE_NOT_FOUND, message);
    }
}
