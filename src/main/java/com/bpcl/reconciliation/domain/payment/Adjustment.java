package com.bpcl.reconciliation.domain.payment;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

import com.bpcl.reconciliation.domain.employee.Employee;
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
        name = "adjustment",
        schema = "reconciliation"
)
public class Adjustment {

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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "employee_id")
    private Employee employee;

    @Column(
            name = "amount",
            nullable = false,
            precision = 19,
            scale = 2
    )
    private BigDecimal amount;

    @Column(
            name = "description",
            nullable = false,
            length = 1000
    )
    private String description;

    @Column(
            name = "reference_number",
            length = 150
    )
    private String referenceNumber;

    @Enumerated(EnumType.STRING)
    @Column(
            name = "approval_status",
            nullable = false,
            length = 30
    )
    private AdjustmentApprovalStatus approvalStatus =
            AdjustmentApprovalStatus.PENDING;

    @Column(
            name = "approved_by"
    )
    private Long approvedBy;

    @Column(
            name = "approved_at"
    )
    private OffsetDateTime approvedAt;

    @Column(
            name = "occurred_at",
            nullable = false
    )
    private OffsetDateTime occurredAt;

    @Column(
            name = "created_by",
            nullable = false
    )
    private Long createdBy;

    @Column(
            name = "created_at",
            nullable = false
    )
    private OffsetDateTime createdAt;

    @Version
    @Column(
            name = "version",
            nullable = false
    )
    private Long version;

    @ManyToOne(
            fetch = FetchType.LAZY,
            optional = false
    )
    @JoinColumn(
            name = "adjustment_type_id",
            nullable = false
    )
    private AdjustmentType adjustmentType;

    @Column(
            name = "adjustment_type_code_snapshot",
            nullable = false,
            length = 50
    )
    private String adjustmentTypeCodeSnapshot;

    @Column(
            name = "adjustment_type_name_snapshot",
            nullable = false,
            length = 150
    )
    private String adjustmentTypeNameSnapshot;

    @Enumerated(EnumType.STRING)
    @Column(
            name = "direction_snapshot",
            nullable = false,
            length = 40
    )
    private AdjustmentDirection directionSnapshot;

    protected Adjustment() {
    }

    public Adjustment(
            Shift shift,
            Employee employee,
            AdjustmentType adjustmentType,
            BigDecimal amount,
            String description,
            String referenceNumber,
            OffsetDateTime occurredAt,
            Long createdBy) {

        this.shift = shift;
        this.employee = employee;
        this.adjustmentType = adjustmentType;
        this.amount = amount;
        this.description = description;
        this.referenceNumber = referenceNumber;
        this.occurredAt = occurredAt;
        this.createdBy = createdBy;

        this.adjustmentTypeCodeSnapshot =
                adjustmentType.getAdjustmentTypeCode();

        this.adjustmentTypeNameSnapshot =
                adjustmentType.getAdjustmentTypeName();

        this.directionSnapshot =
                adjustmentType.getDirection();

        this.approvalStatus =
                AdjustmentApprovalStatus.PENDING;
    }

    @PrePersist
    protected void onCreate() {
        if (createdAt == null) {
            createdAt = OffsetDateTime.now();
        }

        if (version == null) {
            version = 0L;
        }
    }

    public Long getId() {
        return id;
    }

    public Shift getShift() {
        return shift;
    }

    public Employee getEmployee() {
        return employee;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public String getDescription() {
        return description;
    }

    public String getReferenceNumber() {
        return referenceNumber;
    }

    public AdjustmentApprovalStatus getApprovalStatus() {
        return approvalStatus;
    }

    public Long getApprovedBy() {
        return approvedBy;
    }

    public OffsetDateTime getApprovedAt() {
        return approvedAt;
    }

    public OffsetDateTime getOccurredAt() {
        return occurredAt;
    }

    public Long getCreatedBy() {
        return createdBy;
    }

    public OffsetDateTime getCreatedAt() {
        return createdAt;
    }

    public Long getVersion() {
        return version;
    }

    public AdjustmentType getAdjustmentType() {
        return adjustmentType;
    }

    public String getAdjustmentTypeCodeSnapshot() {
        return adjustmentTypeCodeSnapshot;
    }

    public String getAdjustmentTypeNameSnapshot() {
        return adjustmentTypeNameSnapshot;
    }

    public AdjustmentDirection getDirectionSnapshot() {
        return directionSnapshot;
    }

    public void approve(
            Long approvedBy,
            OffsetDateTime approvedAt) {

        this.approvalStatus =
                AdjustmentApprovalStatus.APPROVED;

        this.approvedBy = approvedBy;
        this.approvedAt = approvedAt;
    }

    public void reject() {
        this.approvalStatus =
                AdjustmentApprovalStatus.REJECTED;

        this.approvedBy = null;
        this.approvedAt = null;
    }
}