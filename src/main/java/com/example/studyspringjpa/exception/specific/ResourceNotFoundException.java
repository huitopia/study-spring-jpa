package com.example.studyspringjpa.exception.specific;

import com.example.studyspringjpa.exception.common.CustomException;
import com.example.studyspringjpa.exception.common.ErrorType;

public class ResourceNotFoundException extends CustomException {
    public ResourceNotFoundException(String message) {
        super(ErrorType.RESOURCE_NOT_FOUND, message);
    }
}
