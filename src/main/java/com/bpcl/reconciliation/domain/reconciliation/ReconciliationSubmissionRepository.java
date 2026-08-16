package com.bpcl.reconciliation.domain.reconciliation;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ReconciliationSubmissionRepository
        extends JpaRepository<ReconciliationSubmission, Long> {

    Optional<ReconciliationSubmission>
            findByShiftEmployeeIdAndSubmissionNumber(
                    Long shiftEmployeeId,
                    Integer submissionNumber);

    boolean existsByShiftEmployeeIdAndSubmissionNumber(
            Long shiftEmployeeId,
            Integer submissionNumber);

    Optional<ReconciliationSubmission>
            findByEmployeeReconciliationId(
                    Long employeeReconciliationId);

    List<ReconciliationSubmission>
            findByShiftEmployeeIdOrderBySubmissionNumberAsc(
                    Long shiftEmployeeId);

    List<ReconciliationSubmission>
            findByShiftIdOrderBySubmittedAtAsc(
                    Long shiftId);

    Optional<ReconciliationSubmission>
            findFirstByShiftEmployeeIdOrderBySubmissionNumberDesc(
                    Long shiftEmployeeId);
}