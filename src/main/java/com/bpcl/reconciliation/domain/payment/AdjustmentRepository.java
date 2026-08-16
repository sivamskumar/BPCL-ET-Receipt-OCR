package com.bpcl.reconciliation.domain.payment;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AdjustmentRepository
        extends JpaRepository<Adjustment, Long> {

    List<Adjustment>
            findByShiftIdAndEmployeeIdOrderByOccurredAtAsc(
                    Long shiftId,
                    Long employeeId);

    List<Adjustment>
            findByShiftIdAndApprovalStatusOrderByOccurredAtAsc(
                    Long shiftId,
                    AdjustmentApprovalStatus approvalStatus);

    List<Adjustment>
            findByShiftIdAndEmployeeIdAndApprovalStatusOrderByOccurredAtAsc(
                    Long shiftId,
                    Long employeeId,
                    AdjustmentApprovalStatus approvalStatus);

    List<Adjustment>
            findByAdjustmentTypeIdAndApprovalStatusOrderByOccurredAtDesc(
                    Long adjustmentTypeId,
                    AdjustmentApprovalStatus approvalStatus);
}