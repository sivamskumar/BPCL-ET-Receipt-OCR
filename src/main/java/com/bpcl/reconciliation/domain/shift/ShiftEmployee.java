package com.bpcl.reconciliation.domain.shift;

import java.time.OffsetDateTime;

import com.bpcl.reconciliation.domain.employee.Employee;

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
        name = "shift_employee",
        schema = "reconciliation"
)
public class ShiftEmployee {

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
            name = "employee_code_snapshot",
            nullable = false,
            length = 30
    )
    private String employeeCodeSnapshot;

    @Column(
            name = "employee_name_snapshot",
            nullable = false,
            length = 150
    )
    private String employeeNameSnapshot;

    @Column(
            name = "created_at",
            nullable = false
    )
    private OffsetDateTime createdAt;

    @Column(
            name = "created_by",
            nullable = false
    )
    private Long createdBy;

    protected ShiftEmployee() {
    }

    public ShiftEmployee(
            Shift shift,
            Employee employee,
            Long createdBy) {

        this.shift = shift;
        this.employee = employee;
        this.employeeCodeSnapshot = employee.getEmployeeCode();
        this.employeeNameSnapshot = employee.getEmployeeName();
        this.createdBy = createdBy;
    }

    @PrePersist
    protected void onCreate() {
        if (createdAt == null) {
            createdAt = OffsetDateTime.now();
        }
    }

    public Long getId() {
        return id;
    }

    public Shift getShift() {
        return shift;
    }

    public void setShift(Shift shift) {
        this.shift = shift;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public String getEmployeeCodeSnapshot() {
        return employeeCodeSnapshot;
    }

    public String getEmployeeNameSnapshot() {
        return employeeNameSnapshot;
    }

    public OffsetDateTime getCreatedAt() {
        return createdAt;
    }

    public Long getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Long createdBy) {
        this.createdBy = createdBy;
    }
}