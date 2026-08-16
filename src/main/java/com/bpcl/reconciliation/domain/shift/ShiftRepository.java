package com.bpcl.reconciliation.domain.shift;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ShiftRepository
        extends JpaRepository<Shift, Long> {

    Optional<Shift>
            findByFuelStationIdAndBusinessDateAndShiftNumber(
                    Long fuelStationId,
                    LocalDate businessDate,
                    Integer shiftNumber);

    boolean existsByFuelStationIdAndBusinessDateAndShiftNumber(
            Long fuelStationId,
            LocalDate businessDate,
            Integer shiftNumber);

    List<Shift>
            findByFuelStationIdAndBusinessDateOrderByShiftNumberAsc(
                    Long fuelStationId,
                    LocalDate businessDate);

    List<Shift>
            findByFuelStationIdAndStatusOrderByBusinessDateDesc(
                    Long fuelStationId,
                    String status);
}