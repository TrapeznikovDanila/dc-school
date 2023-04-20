package ru.trapeznikov.didital_chief.exception;

import java.time.LocalDateTime;

public class ValidationException extends RuntimeException {
    String message;
    LocalDateTime timeStamp;

    public ValidationException(String message, LocalDateTime timeStamp) {
        this.message = message;
        this.timeStamp = timeStamp;
    }
}
