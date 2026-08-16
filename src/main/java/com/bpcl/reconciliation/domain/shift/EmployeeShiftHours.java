package com.bpcl.reconciliation.domain.shift;

import java.time.OffsetDateTime;

import com.bpcl.reconciliation.domain.employee.Employee;
import com.bpcl.reconciliation.persistence.common.BaseEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(
        name = "employee_shift_hours",
        schema = "reconciliation"
)
public class EmployeeShiftHours extends BaseEntity {

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

    @Column(
            name = "started_at",
            nullable = false
    )
    private OffsetDateTime startedAt;

    @Column(
            name = "ended_at"
    )
    private OffsetDateTime endedAt;

    @Column(
            name = "total_duration_minutes"
    )
    private Integer totalDurationMinutes;

    @Enumerated(EnumType.STRING)
    @Column(
            name = "status",
            nullable = false,
            length = 20
    )
    private EmployeeShiftHoursStatus status;

    @Column(
            name = "remarks",
            length = 1000
    )
    private String remarks;

    protected EmployeeShiftHours() {
    }

    public EmployeeShiftHours(
            Shift shift,
            ShiftEmployee shiftEmployee,
            Employee employee,
            OffsetDateTime startedAt) {

        this.shift = shift;
        this.shiftEmployee = shiftEmployee;
        this.employee = employee;
        this.startedAt = startedAt;
        this.status = EmployeeShiftHoursStatus.STARTED;
    }

    public Shift getShift() {
        return shift;
    }

    public void setShift(Shift shift) {
        this.shift = shift;
    }

    public ShiftEmployee getShiftEmployee() {
        return shiftEmployee;
    }

    public void setShiftEmployee(
            ShiftEmployee shiftEmployee) {

        this.shiftEmployee = shiftEmployee;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public OffsetDateTime getStartedAt() {
        return startedAt;
    }

    public void setStartedAt(
            OffsetDateTime startedAt) {

        this.startedAt = startedAt;
    }

    public OffsetDateTime getEndedAt() {
        return endedAt;
    }

    public Integer getTotalDurationMinutes() {
        return totalDurationMinutes;
    }

    public EmployeeShiftHoursStatus getStatus() {
        return status;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public void complete(
            OffsetDateTime endedAt,
            Integer totalDurationMinutes) {

        this.endedAt = endedAt;
        this.totalDurationMinutes = totalDurationMinutes;
        this.status = EmployeeShiftHoursStatus.COMPLETED;
    }

    public void markCorrected(
            OffsetDateTime startedAt,
            OffsetDateTime endedAt,
            Integer totalDurationMinutes) {

        this.startedAt = startedAt;
        this.endedAt = endedAt;
        this.totalDurationMinutes = totalDurationMinutes;
        this.status = EmployeeShiftHoursStatus.CORRECTED;
    }
}