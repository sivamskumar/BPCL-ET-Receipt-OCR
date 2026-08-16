package com.bpcl.reconciliation.domain.shift;

import java.time.OffsetDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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
        name = "employee_shift_hours_correction",
        schema = "reconciliation"
)
public class EmployeeShiftHoursCorrection {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(
            fetch = FetchType.LAZY,
            optional = false
    )
    @JoinColumn(
            name = "employee_shift_hours_id",
            nullable = false
    )
    private EmployeeShiftHours employeeShiftHours;

    @Column(
            name = "previous_started_at",
            nullable = false
    )
    private OffsetDateTime previousStartedAt;

    @Column(
            name = "previous_ended_at"
    )
    private OffsetDateTime previousEndedAt;

    @Column(
            name = "corrected_started_at",
            nullable = false
    )
    private OffsetDateTime correctedStartedAt;

    @Column(
            name = "corrected_ended_at"
    )
    private OffsetDateTime correctedEndedAt;

    @Column(
            name = "previous_duration_minutes"
    )
    private Integer previousDurationMinutes;

    @Column(
            name = "corrected_duration_minutes"
    )
    private Integer correctedDurationMinutes;

    @Column(
            name = "correction_reason",
            nullable = false,
            length = 1000
    )
    private String correctionReason;

    @Column(
            name = "corrected_by",
            nullable = false
    )
    private Long correctedBy;

    @Column(
            name = "corrected_at",
            nullable = false
    )
    private OffsetDateTime correctedAt;

    protected EmployeeShiftHoursCorrection() {
    }

    public EmployeeShiftHoursCorrection(
            EmployeeShiftHours employeeShiftHours,
            OffsetDateTime previousStartedAt,
            OffsetDateTime previousEndedAt,
            OffsetDateTime correctedStartedAt,
            OffsetDateTime correctedEndedAt,
            Integer previousDurationMinutes,
            Integer correctedDurationMinutes,
            String correctionReason,
            Long correctedBy) {

        this.employeeShiftHours = employeeShiftHours;
        this.previousStartedAt = previousStartedAt;
        this.previousEndedAt = previousEndedAt;
        this.correctedStartedAt = correctedStartedAt;
        this.correctedEndedAt = correctedEndedAt;
        this.previousDurationMinutes = previousDurationMinutes;
        this.correctedDurationMinutes = correctedDurationMinutes;
        this.correctionReason = correctionReason;
        this.correctedBy = correctedBy;
    }

    @PrePersist
    protected void onCreate() {
        if (correctedAt == null) {
            correctedAt = OffsetDateTime.now();
        }
    }

    public Long getId() {
        return id;
    }

    public EmployeeShiftHours getEmployeeShiftHours() {
        return employeeShiftHours;
    }

    public OffsetDateTime getPreviousStartedAt() {
        return previousStartedAt;
    }

    public OffsetDateTime getPreviousEndedAt() {
        return previousEndedAt;
    }

    public OffsetDateTime getCorrectedStartedAt() {
        return correctedStartedAt;
    }

    public OffsetDateTime getCorrectedEndedAt() {
        return correctedEndedAt;
    }

    public Integer getPreviousDurationMinutes() {
        return previousDurationMinutes;
    }

    public Integer getCorrectedDurationMinutes() {
        return correctedDurationMinutes;
    }

    public String getCorrectionReason() {
        return correctionReason;
    }

    public Long getCorrectedBy() {
        return correctedBy;
    }

    public OffsetDateTime getCorrectedAt() {
        return correctedAt;
    }
}