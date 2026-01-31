package com.vidya.order.service.adapters.rest;

import com.vidya.common.exception.BadRequestException;
import com.vidya.common.exception.ErrorResponse;
import com.vidya.common.exception.InternalServerErrorException;
import com.vidya.order.service.adapters.rest.controller.OrderController;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.resource.NoResourceFoundException;

/**
 * @author Vidya Sagar Gupta
 * @since v1.0.0
 */
@Slf4j
@RestControllerAdvice(assignableTypes = {OrderController.class})
public class GlobalRestExceptionHandler {

  @ExceptionHandler(BadRequestException.class)
  public ResponseEntity<ErrorResponse> handleBadRequestException(BadRequestException exp) {
    log.error(
        "Bad request [message: {}, description: {}]",
        exp.getErrorResponse().message(),
        exp.getErrorResponse().description());
    return ResponseEntity.status(exp.getErrorResponse().errorCode()).body(exp.getErrorResponse());
  }

  @ExceptionHandler(InternalServerErrorException.class)
  public ResponseEntity<ErrorResponse> handleInternalServerErrorException(
      InternalServerErrorException exp) {
    log.error(
        "Internal server error [message: {}, description: {}]",
        exp.getErrorResponse().message(),
        exp.getErrorResponse().description());
    return ResponseEntity.status(exp.getErrorResponse().errorCode()).body(exp.getErrorResponse());
  }

  @ExceptionHandler(NoResourceFoundException.class)
  public ResponseEntity<ErrorResponse> handleNoResourceFoundException(
      NoResourceFoundException exp) {
    log.error("Requested resource not found... ", exp);
    return ResponseEntity.status(HttpStatus.NOT_FOUND)
        .body(
            ErrorResponse.builder()
                .errorCode(HttpStatus.NOT_FOUND.value())
                .message(exp.getMessage())
                .description(exp.getMessage())
                .build());
  }
}
