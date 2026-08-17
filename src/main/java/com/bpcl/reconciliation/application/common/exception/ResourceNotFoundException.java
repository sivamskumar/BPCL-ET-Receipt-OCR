package com.bpcl.reconciliation.application.common.exception;

/**
 * Indicates that a resource required by an application use case
 * could not be found.
 */
public class ResourceNotFoundException extends ApplicationException {

    public ResourceNotFoundException(String message) {
        super(message);
    }

    public ResourceNotFoundException(
            String resourceName,
            Object resourceId) {

        super(resourceName + " not found with identifier: " + resourceId);
    }
}