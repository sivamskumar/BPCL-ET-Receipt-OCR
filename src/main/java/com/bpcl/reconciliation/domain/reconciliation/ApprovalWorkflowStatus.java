package com.bpcl.reconciliation.domain.reconciliation;

public enum ApprovalWorkflowStatus {

    DRAFT,
    PENDING_LEVEL_1_REVIEW,
    RETURNED_TO_EMPLOYEE,
    RESUBMITTED,
    LEVEL_1_APPROVED,
    LEVEL_1_APPROVED_WITH_REMARKS,
    PENDING_LEVEL_2_APPROVAL,
    APPROVED
}