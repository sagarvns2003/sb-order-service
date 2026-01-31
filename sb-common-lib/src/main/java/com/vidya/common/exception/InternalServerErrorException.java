package com.vidya.common.exception;

/**
 * @author Vidya Sagar Gupta
 * @since v1.0.0
 */
public class InternalServerErrorException extends BaseException {
    public InternalServerErrorException(ErrorResponse errorResponse) {
        super(errorResponse);
    }
}
