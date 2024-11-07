package com.example.studyspringjpa.exception.specific;

import com.example.studyspringjpa.exception.common.CustomException;
import com.example.studyspringjpa.exception.common.ErrorType;

public class DuplicateIdException extends CustomException {
    public DuplicateIdException(String message) {
        super(ErrorType.DUPLICATE_ID,message);
    }
}
