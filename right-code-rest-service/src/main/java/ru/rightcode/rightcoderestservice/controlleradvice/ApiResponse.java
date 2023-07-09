package ru.rightcode.rightcoderestservice.controlleradvice;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
public class ApiResponse {

    private final HttpStatus httpStatus;
    private final BusinessCode businessCode;
    private final String businessMessage;
    private final LocalDateTime timestamp;
    private final String message;

}
