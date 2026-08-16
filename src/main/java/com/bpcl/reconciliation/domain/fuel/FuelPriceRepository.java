package com.bpcl.reconciliation.domain.fuel;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface FuelPriceRepository
        extends JpaRepository<FuelPrice, Long> {

    List<FuelPrice>
            findByFuelStationIdAndFuelTypeIdOrderByEffectiveFromDesc(
                    Long fuelStationId,
                    Long fuelTypeId);

    @Query("""
            SELECT fp
            FROM FuelPrice fp
            WHERE fp.fuelStation.id = :fuelStationId
              AND fp.fuelType.id = :fuelTypeId
              AND fp.active = true
              AND fp.effectiveFrom <= :effectiveAt
              AND (
                    fp.effectiveTo IS NULL
                    OR fp.effectiveTo > :effectiveAt
                  )
            ORDER BY fp.effectiveFrom DESC
            """)
    List<FuelPrice> findEffectivePrices(
            @Param("fuelStationId") Long fuelStationId,
            @Param("fuelTypeId") Long fuelTypeId,
            @Param("effectiveAt") OffsetDateTime effectiveAt);

    default Optional<FuelPrice> findEffectivePrice(
            Long fuelStationId,
            Long fuelTypeId,
            OffsetDateTime effectiveAt) {

        return findEffectivePrices(
                fuelStationId,
                fuelTypeId,
                effectiveAt)
                .stream()
                .findFirst();
    }
}