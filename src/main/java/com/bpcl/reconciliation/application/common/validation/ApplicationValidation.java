package com.bpcl.reconciliation.application.common.validation;

import com.bpcl.reconciliation.application.common.exception.BusinessValidationException;

/**
 * Provides reusable validation operations for application-layer use cases.
 */
public final class ApplicationValidation {

    private ApplicationValidation() {
    }

    public static String requireNonBlank(
            String value,
            String fieldName) {

        if (value == null || value.isBlank()) {
            throw new BusinessValidationException(
                    fieldName + " must not be blank");
        }

        return value.trim();
    }

    public static <T> T requireNonNull(
            T value,
            String fieldName) {

        if (value == null) {
            throw new BusinessValidationException(
                    fieldName + " must not be null");
        }

        return value;
    }

    public static void require(
            boolean condition,
            String message) {

        if (!condition) {
            throw new BusinessValidationException(message);
        }
    }
}