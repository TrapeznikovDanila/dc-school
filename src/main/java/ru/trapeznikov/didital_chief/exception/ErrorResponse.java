package ru.trapeznikov.didital_chief.exception;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class ErrorResponse {
    String message;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:SS")
    LocalDateTime timeStamp;

    public ErrorResponse(String message, LocalDateTime timeStamp) {
        this.message = message;
        this.timeStamp = timeStamp;
    }
}
