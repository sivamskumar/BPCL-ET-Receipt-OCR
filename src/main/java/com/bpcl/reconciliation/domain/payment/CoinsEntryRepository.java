package com.bpcl.reconciliation.domain.payment;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CoinsEntryRepository
        extends JpaRepository<CoinsEntry, Long> {

    Optional<CoinsEntry>
            findByShiftIdAndEmployeeId(
                    Long shiftId,
                    Long employeeId);

    boolean existsByShiftIdAndEmployeeId(
            Long shiftId,
            Long employeeId);
}