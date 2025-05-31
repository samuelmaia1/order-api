package com.samuelmaia1.github.orderapi.infra;

import com.samuelmaia1.github.orderapi.exceptions.EntityNotFoundException;
import com.samuelmaia1.github.orderapi.exceptions.OrderIsEmptyException;
import com.samuelmaia1.github.orderapi.response.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(OrderIsEmptyException.class)
    public ResponseEntity<ErrorResponse> handleOrderIsEmpty(OrderIsEmptyException exception) {
        ErrorResponse error = buildErrorResponse(HttpStatus.BAD_REQUEST, exception.getMessage());

        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(error);
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleEntityNotFound(EntityNotFoundException exception) {
        ErrorResponse error = buildErrorResponse(HttpStatus.NOT_FOUND, exception.getMessage());

        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(error);
    }

    private ErrorResponse buildErrorResponse(HttpStatus status, String message) {
        return new ErrorResponse(
                message,
                status.value(),
                status.getReasonPhrase(),
                LocalDateTime.now()
        );
    }
}
