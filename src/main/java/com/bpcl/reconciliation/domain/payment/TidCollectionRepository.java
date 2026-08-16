package com.bpcl.reconciliation.domain.payment;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TidCollectionRepository
        extends JpaRepository<TidCollection, Long> {

    Optional<TidCollection>
            findByShiftIdAndEmployeeId(
                    Long shiftId,
                    Long employeeId);

    boolean existsByShiftIdAndEmployeeId(
            Long shiftId,
            Long employeeId);

    List<TidCollection>
            findByTerminalIdentifierOrderByEnteredAtDesc(
                    String terminalIdentifier);
}