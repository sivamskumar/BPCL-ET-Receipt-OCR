package com.bpcl.reconciliation.domain.reconciliation;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ApprovalDecisionRepository
        extends JpaRepository<ApprovalDecision, Long> {

    List<ApprovalDecision>
            findByReconciliationSubmissionIdOrderByActedAtAsc(
                    Long reconciliationSubmissionId);

    List<ApprovalDecision>
            findByReconciliationIdOrderByActedAtAsc(
                    Long reconciliationId);

    List<ApprovalDecision>
            findByReconciliationSubmissionIdAndApprovalLevelOrderByActedAtAsc(
                    Long reconciliationSubmissionId,
                    ApprovalLevel approvalLevel);

    List<ApprovalDecision>
            findByActedByOrderByActedAtDesc(
                    Long actedBy);
}