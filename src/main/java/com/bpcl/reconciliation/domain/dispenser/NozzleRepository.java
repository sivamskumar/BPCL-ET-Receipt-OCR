package com.bpcl.reconciliation.domain.dispenser;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface NozzleRepository
        extends JpaRepository<Nozzle, Long> {

    Optional<Nozzle> findByDispenserUnitIdAndNozzleNumber(
            Long dispenserUnitId,
            Integer nozzleNumber);

    boolean existsByDispenserUnitIdAndNozzleNumber(
            Long dispenserUnitId,
            Integer nozzleNumber);

    List<Nozzle> findByDispenserUnitIdAndActiveTrue(
            Long dispenserUnitId);

    List<Nozzle> findByDispenserSideIdAndActiveTrue(
            Long dispenserSideId);
}