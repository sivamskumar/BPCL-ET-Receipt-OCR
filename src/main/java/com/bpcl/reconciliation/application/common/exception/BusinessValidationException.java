package com.bpcl.reconciliation.application.common.exception;

/**
 * Indicates that an application use case violates a business
 * validation rule.
 */
public class BusinessValidationException extends ApplicationException {

    public BusinessValidationException(String message) {
        super(message);
    }

    public BusinessValidationException(
            String message,
            Throwable cause) {

        super(message, cause);
    }
}