package com.vidya.common.exception;

/**
 * @author Vidya Sagar Gupta
 * @since v1.0.0
 */
public class BadRequestException extends BaseException {
    public BadRequestException(ErrorResponse errorResponse) {
        super(errorResponse);
    }
}
