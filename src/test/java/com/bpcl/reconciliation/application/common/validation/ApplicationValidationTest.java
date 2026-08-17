package com.bpcl.reconciliation.application.common.validation;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import com.bpcl.reconciliation.application.common.exception.BusinessValidationException;

class ApplicationValidationTest {

    @Test
    void requireNonBlankShouldReturnTrimmedValue() {
        String result =
                ApplicationValidation.requireNonBlank(
                        "  ORG001  ",
                        "Organization code");

        assertEquals("ORG001", result);
    }

    @Test
    void requireNonBlankShouldRejectNullValue() {
        BusinessValidationException exception =
                assertThrows(
                        BusinessValidationException.class,
                        () -> ApplicationValidation.requireNonBlank(
                                null,
                                "Organization code"));

        assertEquals(
                "Organization code must not be blank",
                exception.getMessage());
    }

    @Test
    void requireNonBlankShouldRejectBlankValue() {
        BusinessValidationException exception =
                assertThrows(
                        BusinessValidationException.class,
                        () -> ApplicationValidation.requireNonBlank(
                                "   ",
                                "Organization code"));

        assertEquals(
                "Organization code must not be blank",
                exception.getMessage());
    }

    @Test
    void requireNonNullShouldReturnSameValue() {
        Object value = new Object();

        Object result =
                ApplicationValidation.requireNonNull(
                        value,
                        "Value");

        assertSame(value, result);
    }

    @Test
    void requireNonNullShouldRejectNullValue() {
        BusinessValidationException exception =
                assertThrows(
                        BusinessValidationException.class,
                        () -> ApplicationValidation.requireNonNull(
                                null,
                                "Employee"));

        assertEquals(
                "Employee must not be null",
                exception.getMessage());
    }

    @Test
    void requireShouldAcceptTrueCondition() {
        assertDoesNotThrow(
                () -> ApplicationValidation.require(
                        true,
                        "Validation should succeed"));
    }

    @Test
    void requireShouldRejectFalseCondition() {
        BusinessValidationException exception =
                assertThrows(
                        BusinessValidationException.class,
                        () -> ApplicationValidation.require(
                                false,
                                "Employee must be active"));

        assertEquals(
                "Employee must be active",
                exception.getMessage());
    }
}