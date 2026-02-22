package com.Teacher.exception;

public class TeacherEmailAlreadyExistsException extends RuntimeException {

    public TeacherEmailAlreadyExistsException(String message) {
        super(message);
    }
}
