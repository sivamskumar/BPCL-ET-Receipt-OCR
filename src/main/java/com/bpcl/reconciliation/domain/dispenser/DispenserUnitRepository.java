package com.bpcl.reconciliation.domain.dispenser;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface DispenserUnitRepository
        extends JpaRepository<DispenserUnit, Long> {

    Optional<DispenserUnit> findByNormalizedDuSerialNumber(
            String normalizedDuSerialNumber);

    boolean existsByNormalizedDuSerialNumber(
            String normalizedDuSerialNumber);

    List<DispenserUnit> findByFuelStationIdAndActiveTrue(
            Long fuelStationId);
}