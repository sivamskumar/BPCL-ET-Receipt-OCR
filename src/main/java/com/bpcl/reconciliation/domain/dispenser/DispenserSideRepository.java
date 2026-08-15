package com.bpcl.reconciliation.domain.dispenser;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface DispenserSideRepository
        extends JpaRepository<DispenserSide, Long> {

    Optional<DispenserSide> findByDispenserUnitIdAndSideName(
            Long dispenserUnitId,
            String sideName);

    boolean existsByDispenserUnitIdAndSideName(
            Long dispenserUnitId,
            String sideName);

    List<DispenserSide> findByDispenserUnitIdAndActiveTrue(
            Long dispenserUnitId);
}