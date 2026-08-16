package com.bpcl.reconciliation.domain.payment;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CashDenominationEntryRepository
        extends JpaRepository<CashDenominationEntry, Long> {

    Optional<CashDenominationEntry>
            findByShiftIdAndEmployeeIdAndCashDenominationId(
                    Long shiftId,
                    Long employeeId,
                    Long cashDenominationId);

    boolean existsByShiftIdAndEmployeeIdAndCashDenominationId(
            Long shiftId,
            Long employeeId,
            Long cashDenominationId);

    List<CashDenominationEntry>
            findByShiftIdAndEmployeeIdOrderByDenominationValueSnapshotDesc(
                    Long shiftId,
                    Long employeeId);
}