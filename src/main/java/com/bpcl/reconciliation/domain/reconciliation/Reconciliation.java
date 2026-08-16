package com.bpcl.reconciliation.domain.reconciliation;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

import com.bpcl.reconciliation.domain.shift.Shift;

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
import jakarta.persistence.Version;

@Entity
@Table(
        name = "reconciliation",
        schema = "reconciliation"
)
public class Reconciliation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(
            fetch = FetchType.LAZY,
            optional = false
    )
    @JoinColumn(
            name = "shift_id",
            nullable = false
    )
    private Shift shift;

    @Column(
            name = "calculation_version",
            nullable = false
    )
    private Integer calculationVersion;

    @Column(
            name = "expected_sales_amount",
            nullable = false,
            precision = 19,
            scale = 2
    )
    private BigDecimal expectedSalesAmount;

    @Column(
            name = "total_notes_amount",
            nullable = false,
            precision = 19,
            scale = 2
    )
    private BigDecimal totalNotesAmount;

    @Column(
            name = "coins_total",
            nullable = false,
            precision = 19,
            scale = 2
    )
    private BigDecimal coinsTotal;

    @Column(
            name = "cash_total",
            nullable = false,
            precision = 19,
            scale = 2
    )
    private BigDecimal cashTotal;

    @Column(
            name = "tid_total",
            nullable = false,
            precision = 19,
            scale = 2
    )
    private BigDecimal tidTotal;

    @Column(
            name = "credit_total",
            nullable = false,
            precision = 19,
            scale = 2
    )
    private BigDecimal creditTotal;

    @Column(
            name = "additive_adjustment_total",
            nullable = false,
            precision = 19,
            scale = 2
    )
    private BigDecimal additiveAdjustmentTotal;

    @Column(
            name = "deductive_adjustment_total",
            nullable = false,
            precision = 19,
            scale = 2
    )
    private BigDecimal deductiveAdjustmentTotal;

    @Column(
            name = "accounted_amount",
            nullable = false,
            precision = 19,
            scale = 2
    )
    private BigDecimal accountedAmount;

    @Column(
            name = "difference_amount",
            nullable = false,
            precision = 19,
            scale = 2
    )
    private BigDecimal differenceAmount;

    @Column(
            name = "allowed_tolerance",
            nullable = false,
            precision = 19,
            scale = 2
    )
    private BigDecimal allowedTolerance;

    @Enumerated(EnumType.STRING)
    @Column(
            name = "reconciliation_status",
            nullable = false,
            length = 40
    )
    private ReconciliationStatus reconciliationStatus;

    @Enumerated(EnumType.STRING)
    @Column(
            name = "approval_workflow_status",
            nullable = false,
            length = 50
    )
    private ApprovalWorkflowStatus approvalWorkflowStatus =
            ApprovalWorkflowStatus.DRAFT;

    @Column(
            name = "level_1_reviewer_id"
    )
    private Long level1ReviewerId;

    @Column(
            name = "level_2_approver_id"
    )
    private Long level2ApproverId;

    @Column(
            name = "calculated_at",
            nullable = false
    )
    private OffsetDateTime calculatedAt;

    @Column(
            name = "calculated_by",
            nullable = false
    )
    private Long calculatedBy;

    @Column(
            name = "calculation_reason",
            length = 1000
    )
    private String calculationReason;

    @Column(
            name = "final_approved_by"
    )
    private Long finalApprovedBy;

    @Column(
            name = "final_approved_at"
    )
    private OffsetDateTime finalApprovedAt;

    @Column(
            name = "remarks",
            length = 1000
    )
    private String remarks;

    @Version
    @Column(
            name = "version",
            nullable = false
    )
    private Long version;

    protected Reconciliation() {
    }

    public Reconciliation(
            Shift shift,
            Integer calculationVersion,
            BigDecimal expectedSalesAmount,
            BigDecimal totalNotesAmount,
            BigDecimal coinsTotal,
            BigDecimal tidTotal,
            BigDecimal creditTotal,
            BigDecimal additiveAdjustmentTotal,
            BigDecimal deductiveAdjustmentTotal,
            BigDecimal allowedTolerance,
            Long calculatedBy,
            String calculationReason) {

        this.shift = shift;
        this.calculationVersion = calculationVersion;
        this.expectedSalesAmount = expectedSalesAmount;
        this.totalNotesAmount = totalNotesAmount;
        this.coinsTotal = coinsTotal;
        this.tidTotal = tidTotal;
        this.creditTotal = creditTotal;
        this.additiveAdjustmentTotal = additiveAdjustmentTotal;
        this.deductiveAdjustmentTotal = deductiveAdjustmentTotal;
        this.allowedTolerance = allowedTolerance;
        this.calculatedBy = calculatedBy;
        this.calculationReason = calculationReason;

        this.cashTotal =
                totalNotesAmount.add(coinsTotal);

        this.accountedAmount =
                this.cashTotal
                        .add(tidTotal)
                        .add(creditTotal)
                        .add(additiveAdjustmentTotal)
                        .subtract(deductiveAdjustmentTotal);

        this.differenceAmount =
                this.accountedAmount.subtract(expectedSalesAmount);

        this.reconciliationStatus =
                determineStatus(
                        this.differenceAmount,
                        allowedTolerance);

        this.approvalWorkflowStatus =
                ApprovalWorkflowStatus.DRAFT;
    }

    @PrePersist
    protected void onCreate() {
        if (calculatedAt == null) {
            calculatedAt = OffsetDateTime.now();
        }

        if (version == null) {
            version = 0L;
        }
    }

    private ReconciliationStatus determineStatus(
            BigDecimal differenceAmount,
            BigDecimal allowedTolerance) {

        if (differenceAmount.abs()
                .compareTo(allowedTolerance) <= 0) {

            return ReconciliationStatus.MATCHED;
        }

        if (differenceAmount.signum() < 0) {
            return ReconciliationStatus.SHORTAGE;
        }

        return ReconciliationStatus.EXCESS;
    }

    public Long getId() {
        return id;
    }

    public Shift getShift() {
        return shift;
    }

    public Integer getCalculationVersion() {
        return calculationVersion;
    }

    public BigDecimal getExpectedSalesAmount() {
        return expectedSalesAmount;
    }

    public BigDecimal getTotalNotesAmount() {
        return totalNotesAmount;
    }

    public BigDecimal getCoinsTotal() {
        return coinsTotal;
    }

    public BigDecimal getCashTotal() {
        return cashTotal;
    }

    public BigDecimal getTidTotal() {
        return tidTotal;
    }

    public BigDecimal getCreditTotal() {
        return creditTotal;
    }

    public BigDecimal getAdditiveAdjustmentTotal() {
        return additiveAdjustmentTotal;
    }

    public BigDecimal getDeductiveAdjustmentTotal() {
        return deductiveAdjustmentTotal;
    }

    public BigDecimal getAccountedAmount() {
        return accountedAmount;
    }

    public BigDecimal getDifferenceAmount() {
        return differenceAmount;
    }

    public BigDecimal getAllowedTolerance() {
        return allowedTolerance;
    }

    public ReconciliationStatus getReconciliationStatus() {
        return reconciliationStatus;
    }

    public ApprovalWorkflowStatus getApprovalWorkflowStatus() {
        return approvalWorkflowStatus;
    }

    public Long getLevel1ReviewerId() {
        return level1ReviewerId;
    }

    public Long getLevel2ApproverId() {
        return level2ApproverId;
    }

    public OffsetDateTime getCalculatedAt() {
        return calculatedAt;
    }

    public Long getCalculatedBy() {
        return calculatedBy;
    }

    public String getCalculationReason() {
        return calculationReason;
    }

    public Long getFinalApprovedBy() {
        return finalApprovedBy;
    }

    public OffsetDateTime getFinalApprovedAt() {
        return finalApprovedAt;
    }

    public String getRemarks() {
        return remarks;
    }

    public Long getVersion() {
        return version;
    }

    public void moveToLevel1Review() {
        this.approvalWorkflowStatus =
                ApprovalWorkflowStatus.PENDING_LEVEL_1_REVIEW;
    }

    public void returnToEmployee() {
        this.approvalWorkflowStatus =
                ApprovalWorkflowStatus.RETURNED_TO_EMPLOYEE;
    }

    public void markResubmitted() {
        this.approvalWorkflowStatus =
                ApprovalWorkflowStatus.RESUBMITTED;
    }

    public void approveLevel1(Long reviewerId) {
        this.level1ReviewerId = reviewerId;
        this.approvalWorkflowStatus =
                ApprovalWorkflowStatus.LEVEL_1_APPROVED;
    }

    public void approveLevel1WithRemarks(
            Long reviewerId,
            String remarks) {

        this.level1ReviewerId = reviewerId;
        this.remarks = remarks;
        this.approvalWorkflowStatus =
                ApprovalWorkflowStatus.LEVEL_1_APPROVED_WITH_REMARKS;
    }

    public void moveToLevel2Approval(
            Long approverId) {

        this.level2ApproverId = approverId;
        this.approvalWorkflowStatus =
                ApprovalWorkflowStatus.PENDING_LEVEL_2_APPROVAL;
    }

    public void finalApprove(
            Long approvedBy,
            OffsetDateTime approvedAt,
            String remarks) {

        this.finalApprovedBy = approvedBy;
        this.finalApprovedAt = approvedAt;
        this.remarks = remarks;
        this.approvalWorkflowStatus =
                ApprovalWorkflowStatus.APPROVED;
    }
}