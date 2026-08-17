package com.bpcl.reconciliation.application.common.context;

/**
 * Provides the organization scope for the current
 * application execution context.
 */
public interface CurrentOrganizationContext {

    Long getOrganizationId();
}