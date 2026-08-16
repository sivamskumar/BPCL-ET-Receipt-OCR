package com.bpcl.reconciliation.domain.reconciliation;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ReconciliationRepository
        extends JpaRepository<Reconciliation, Long> {

    Optional<Reconciliation>
            findByShiftIdAndCalculationVersion(
                    Long shiftId,
                    Integer calculationVersion);

    Optional<Reconciliation>
            findFirstByShiftIdOrderByCalculationVersionDesc(
                    Long shiftId);

    List<Reconciliation>
            findByShiftIdOrderByCalculationVersionAsc(
                    Long shiftId);

    List<Reconciliation>
            findByApprovalWorkflowStatusOrderByCalculatedAtAsc(
                    ApprovalWorkflowStatus approvalWorkflowStatus);

    List<Reconciliation>
            findByReconciliationStatusOrderByCalculatedAtDesc(
                    ReconciliationStatus reconciliationStatus);
}