package com.bpcl.reconciliation.domain.reconciliation;

import java.time.OffsetDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;

@Entity
@Table(
        name = "approval_decision",
        schema = "reconciliation"
)
public class ApprovalDecision {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(
            fetch = FetchType.LAZY,
            optional = false
    )
    @JoinColumn(
            name = "reconciliation_id",
            nullable = false
    )
    private Reconciliation reconciliation;

    @ManyToOne(
            fetch = FetchType.LAZY,
            optional = false
    )
    @JoinColumn(
            name = "reconciliation_submission_id",
            nullable = false
    )
    private ReconciliationSubmission reconciliationSubmission;

    @Column(
            name = "submission_number",
            nullable = false
    )
    private Integer submissionNumber;

    @Enumerated(EnumType.STRING)
    @Column(
            name = "approval_level",
            nullable = false,
            length = 20
    )
    private ApprovalLevel approvalLevel;

    @Enumerated(EnumType.STRING)
    @Column(
            name = "action",
            nullable = false,
            length = 40
    )
    private ApprovalAction action;

    @Column(
            name = "acted_by",
            nullable = false
    )
    private Long actedBy;

    @Column(
            name = "acted_at",
            nullable = false
    )
    private OffsetDateTime actedAt;

    @Column(
            name = "remarks",
            length = 1000
    )
    private String remarks;

    @Column(
            name = "reason",
            length = 1000
    )
    private String reason;

    @Enumerated(EnumType.STRING)
    @Column(
            name = "previous_workflow_status",
            nullable = false,
            length = 50
    )
    private ApprovalWorkflowStatus previousWorkflowStatus;

    @Enumerated(EnumType.STRING)
    @Column(
            name = "new_workflow_status",
            nullable = false,
            length = 50
    )
    private ApprovalWorkflowStatus newWorkflowStatus;

    protected ApprovalDecision() {
    }

    public ApprovalDecision(
            Reconciliation reconciliation,
            ReconciliationSubmission reconciliationSubmission,
            ApprovalLevel approvalLevel,
            ApprovalAction action,
            Long actedBy,
            ApprovalWorkflowStatus previousWorkflowStatus,
            ApprovalWorkflowStatus newWorkflowStatus,
            String remarks,
            String reason) {

        this.reconciliation = reconciliation;
        this.reconciliationSubmission = reconciliationSubmission;
        this.submissionNumber =
                reconciliationSubmission.getSubmissionNumber();

        this.approvalLevel = approvalLevel;
        this.action = action;
        this.actedBy = actedBy;
        this.previousWorkflowStatus = previousWorkflowStatus;
        this.newWorkflowStatus = newWorkflowStatus;
        this.remarks = remarks;
        this.reason = reason;
    }

    @PrePersist
    protected void onCreate() {
        if (actedAt == null) {
            actedAt = OffsetDateTime.now();
        }
    }

    public Long getId() {
        return id;
    }

    public Reconciliation getReconciliation() {
        return reconciliation;
    }

    public ReconciliationSubmission getReconciliationSubmission() {
        return reconciliationSubmission;
    }

    public Integer getSubmissionNumber() {
        return submissionNumber;
    }

    public ApprovalLevel getApprovalLevel() {
        return approvalLevel;
    }

    public ApprovalAction getAction() {
        return action;
    }

    public Long getActedBy() {
        return actedBy;
    }

    public OffsetDateTime getActedAt() {
        return actedAt;
    }

    public String getRemarks() {
        return remarks;
    }

    public String getReason() {
        return reason;
    }

    public ApprovalWorkflowStatus getPreviousWorkflowStatus() {
        return previousWorkflowStatus;
    }

    public ApprovalWorkflowStatus getNewWorkflowStatus() {
        return newWorkflowStatus;
    }
}