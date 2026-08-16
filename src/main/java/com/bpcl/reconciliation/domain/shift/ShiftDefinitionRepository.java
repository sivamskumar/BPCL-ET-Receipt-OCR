package com.bpcl.reconciliation.domain.shift;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ShiftDefinitionRepository
        extends JpaRepository<ShiftDefinition, Long> {

    List<ShiftDefinition>
            findByFuelStationIdAndActiveTrueOrderByShiftNumberAsc(
                    Long fuelStationId);

    List<ShiftDefinition>
            findByFuelStationIdAndShiftNumberOrderByEffectiveFromDesc(
                    Long fuelStationId,
                    Integer shiftNumber);

    @Query("""
            SELECT sd
            FROM ShiftDefinition sd
            WHERE sd.fuelStation.id = :fuelStationId
              AND sd.shiftNumber = :shiftNumber
              AND sd.active = true
              AND sd.effectiveFrom <= :businessDate
              AND (
                    sd.effectiveTo IS NULL
                    OR sd.effectiveTo >= :businessDate
                  )
            ORDER BY sd.effectiveFrom DESC
            """)
    List<ShiftDefinition> findEffectiveDefinitions(
            @Param("fuelStationId") Long fuelStationId,
            @Param("shiftNumber") Integer shiftNumber,
            @Param("businessDate") LocalDate businessDate);

    default Optional<ShiftDefinition> findEffectiveDefinition(
            Long fuelStationId,
            Integer shiftNumber,
            LocalDate businessDate) {

        return findEffectiveDefinitions(
                fuelStationId,
                shiftNumber,
                businessDate)
                .stream()
                .findFirst();
    }
}