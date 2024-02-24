package org.example.bookstore.exception;

import org.springframework.http.HttpStatus;

public class ApiRequestException extends RuntimeException{

    private final HttpStatus statusCode;
    public ApiRequestException(String message) {
        super(message);
        this.statusCode = HttpStatus.BAD_REQUEST;
    }

    public ApiRequestException(String message, Throwable cause) {
        super(message, cause);
        this.statusCode = HttpStatus.BAD_REQUEST; // Default to BAD_REQUEST
    }

    public ApiRequestException(String message, HttpStatus statusCode) {
        super(message);
        this.statusCode = statusCode;
    }

    public HttpStatus getStatusCode() {
        return statusCode;
    }
}
