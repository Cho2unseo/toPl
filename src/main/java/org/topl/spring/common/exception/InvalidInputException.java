package org.topl.spring.common.exception;

import lombok.Getter;

@Getter
public class InvalidInputException extends RuntimeException {
    private final String fieldName;
    private final String message;

    public InvalidInputException(String fieldName, String message) {
        super(message);
        this.fieldName = fieldName;
        this.message = message;
    }
}
