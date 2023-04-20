package ru.trapeznikov.didital_chief.exception;

import java.time.LocalDateTime;

public class NotFoundException extends RuntimeException {
    String message;
    LocalDateTime timeStamp;

    public NotFoundException(String message, LocalDateTime timeStamp) {
        this.message = message;
        this.timeStamp = timeStamp;
    }
}
