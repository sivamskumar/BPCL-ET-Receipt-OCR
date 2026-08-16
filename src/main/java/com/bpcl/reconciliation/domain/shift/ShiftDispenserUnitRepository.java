package com.bpcl.reconciliation.domain.shift;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ShiftDispenserUnitRepository
        extends JpaRepository<ShiftDispenserUnit, Long> {

    Optional<ShiftDispenserUnit>
            findByShiftIdAndDispenserUnitId(
                    Long shiftId,
                    Long dispenserUnitId);

    boolean existsByShiftIdAndDispenserUnitId(
            Long shiftId,
            Long dispenserUnitId);

    List<ShiftDispenserUnit>
            findByShiftIdOrderByStartedAtAsc(
                    Long shiftId);
}