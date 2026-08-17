package com.bpcl.reconciliation.application.common.exception;

/**
 * Indicates that the requested operation conflicts with the
 * current application state or an existing resource.
 */
public class ConflictException extends ApplicationException {

    public ConflictException(String message) {
        super(message);
    }

    public ConflictException(
            String message,
            Throwable cause) {

        super(message, cause);
    }
}