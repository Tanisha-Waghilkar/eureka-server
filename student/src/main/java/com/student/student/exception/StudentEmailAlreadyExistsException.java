package com.student.student.exception;

public class StudentEmailAlreadyExistsException extends RuntimeException {

    public StudentEmailAlreadyExistsException(String message) {
        super(message);
    }
}
