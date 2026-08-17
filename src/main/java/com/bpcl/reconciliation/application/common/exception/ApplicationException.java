package com.bpcl.reconciliation.application.common.exception;

/**
 * Base exception for failures originating from the application layer.
 */
public abstract class ApplicationException extends RuntimeException {

    protected ApplicationException(String message) {
        super(message);
    }

    protected ApplicationException(String message, Throwable cause) {
        super(message, cause);
    }
}