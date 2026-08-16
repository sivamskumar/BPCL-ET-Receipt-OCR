package com.bpcl.reconciliation.domain.reconciliation;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeReconciliationRepository
        extends JpaRepository<EmployeeReconciliation, Long> {

    Optional<EmployeeReconciliation>
            findByReconciliationIdAndShiftEmployeeId(
                    Long reconciliationId,
                    Long shiftEmployeeId);

    boolean existsByReconciliationIdAndShiftEmployeeId(
            Long reconciliationId,
            Long shiftEmployeeId);

    List<EmployeeReconciliation>
            findByReconciliationIdOrderByEmployeeIdAsc(
                    Long reconciliationId);

    List<EmployeeReconciliation>
            findByEmployeeIdOrderByIdDesc(
                    Long employeeId);

    List<EmployeeReconciliation>
            findByReconciliationIdAndReconciliationStatus(
                    Long reconciliationId,
                    ReconciliationStatus reconciliationStatus);
}