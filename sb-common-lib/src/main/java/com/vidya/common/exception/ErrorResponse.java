package com.vidya.common.exception;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Builder;

/**
 * @author Vidya Sagar Gupta
 * @since v1.0.0
 */
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public record ErrorResponse(int errorCode, String message, String description) {}
