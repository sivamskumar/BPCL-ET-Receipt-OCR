package com.bpcl.reconciliation.application.common.context;

/**
 * Provides information about the user currently executing
 * an application use case.
 */
public interface CurrentUserContext {

    Long getUserId();

    String getUsername();
}