package com.bpcl.reconciliation.application.common.context;

import java.util.Optional;

/**
 * Provides the fuel-station scope for the current
 * application execution context.
 */
public interface CurrentStationContext {

    Optional<Long> getFuelStationId();
}