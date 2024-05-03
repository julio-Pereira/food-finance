package com.food.finance.exceptions;

/**
 * NoStackTraceException has the purpose to avoid a full stack trace exception
 * that could reduce the performance when an exception is triggered.
 * **/
public class NoStackTraceException extends RuntimeException {

    public NoStackTraceException(final String message) {
        this(message, null);
    }

    public NoStackTraceException(final String message, final Throwable cause) {
        super(message, cause, false, false);
    }
}
