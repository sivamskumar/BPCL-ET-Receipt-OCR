package com.bpcl.reconciliation.domain.reconciliation;

import java.time.OffsetDateTime;

import com.bpcl.reconciliation.domain.employee.Employee;
import com.bpcl.reconciliation.domain.shift.Shift;
import com.bpcl.reconciliation.domain.shift.ShiftEmployee;

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
        name = "reconciliation_submission",
        schema = "reconciliation"
)
public class ReconciliationSubmission {

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

    @Column(
            name = "submission_number",
            nullable = false
    )
    private Integer submissionNumber;

    @Enumerated(EnumType.STRING)
    @Column(
            name = "submission_type",
            nullable = false,
            length = 20
    )
    private ReconciliationSubmissionType submissionType;

    @Column(
            name = "submitted_by",
            nullable = false
    )
    private Long submittedBy;

    @Column(
            name = "submitted_at",
            nullable = false
    )
    private OffsetDateTime submittedAt;

    @Column(
            name = "remarks",
            length = 1000
    )
    private String remarks;

    @ManyToOne(
            fetch = FetchType.LAZY,
            optional = false
    )
    @JoinColumn(
            name = "shift_id",
            nullable = false
    )
    private Shift shift;

    @ManyToOne(
            fetch = FetchType.LAZY,
            optional = false
    )
    @JoinColumn(
            name = "employee_reconciliation_id",
            nullable = false
    )
    private EmployeeReconciliation employeeReconciliation;

    @ManyToOne(
            fetch = FetchType.LAZY,
            optional = false
    )
    @JoinColumn(
            name = "shift_employee_id",
            nullable = false
    )
    private ShiftEmployee shiftEmployee;

    @ManyToOne(
            fetch = FetchType.LAZY,
            optional = false
    )
    @JoinColumn(
            name = "employee_id",
            nullable = false
    )
    private Employee employee;

    protected ReconciliationSubmission() {
    }

    public ReconciliationSubmission(
            Reconciliation reconciliation,
            Shift shift,
            EmployeeReconciliation employeeReconciliation,
            ShiftEmployee shiftEmployee,
            Employee employee,
            Integer submissionNumber,
            Long submittedBy,
            String remarks) {

        this.reconciliation = reconciliation;
        this.shift = shift;
        this.employeeReconciliation = employeeReconciliation;
        this.shiftEmployee = shiftEmployee;
        this.employee = employee;
        this.submissionNumber = submissionNumber;
        this.submittedBy = submittedBy;
        this.remarks = remarks;

        this.submissionType =
                determineSubmissionType(submissionNumber);
    }

    @PrePersist
    protected void onCreate() {
        if (submittedAt == null) {
            submittedAt = OffsetDateTime.now();
        }
    }

    private ReconciliationSubmissionType determineSubmissionType(
            Integer submissionNumber) {

        if (submissionNumber != null
                && submissionNumber == 1) {

            return ReconciliationSubmissionType.INITIAL;
        }

        return ReconciliationSubmissionType.RESUBMISSION;
    }

    public Long getId() {
        return id;
    }

    public Reconciliation getReconciliation() {
        return reconciliation;
    }

    public Integer getSubmissionNumber() {
        return submissionNumber;
    }

    public ReconciliationSubmissionType getSubmissionType() {
        return submissionType;
    }

    public Long getSubmittedBy() {
        return submittedBy;
    }

    public OffsetDateTime getSubmittedAt() {
        return submittedAt;
    }

    public String getRemarks() {
        return remarks;
    }

    public Shift getShift() {
        return shift;
    }

    public EmployeeReconciliation getEmployeeReconciliation() {
        return employeeReconciliation;
    }

    public ShiftEmployee getShiftEmployee() {
        return shiftEmployee;
    }

    public Employee getEmployee() {
        return employee;
    }
}