package com.bpcl.reconciliation.application.common.exception;

/**
 * Indicates that a resource was modified concurrently and the
 * requested operation cannot safely continue.
 */
public class OptimisticLockConflictException extends ConflictException {

    public OptimisticLockConflictException(String message) {
        super(message);
    }

    public OptimisticLockConflictException(
            String message,
            Throwable cause) {

        super(message, cause);
    }
}