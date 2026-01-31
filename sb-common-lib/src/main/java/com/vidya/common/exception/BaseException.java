package com.vidya.common.exception;

import lombok.Getter;

/**
 * @author Vidya Sagar Gupta
 * @since v1.0.0
 */
@Getter
public class BaseException extends RuntimeException {
  private transient ErrorResponse errorResponse;
  public BaseException(ErrorResponse errorResponse) {
    super(errorResponse.message());
    this.errorResponse = errorResponse;
  }
}
