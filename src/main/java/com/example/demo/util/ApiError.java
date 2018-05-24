package com.example.demo.util;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.springframework.http.HttpStatus;

/**
 * POJO to represent JSON for error
 *
 * @author Mohamed Ibrahim
 */
@JsonPropertyOrder({"status", "message", "timestamp"})
public class ApiError {

    @JsonProperty("status")
    private HttpStatus status;

    @JsonProperty("message")
    private String message;

    private ApiError() {
    }

    public ApiError(HttpStatus status) {
        this();
        this.status = status;
    }

    public ApiError(HttpStatus status, String message) {
        this(status);
        this.message = message;
    }

    public HttpStatus getStatus() {
        return status;
    }
}
