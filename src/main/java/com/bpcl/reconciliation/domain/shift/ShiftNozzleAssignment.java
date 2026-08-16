package com.bpcl.reconciliation.domain.shift;

import java.time.OffsetDateTime;

import com.bpcl.reconciliation.domain.dispenser.DispenserSide;
import com.bpcl.reconciliation.domain.dispenser.Nozzle;
import com.bpcl.reconciliation.domain.employee.Employee;
import com.bpcl.reconciliation.domain.fuel.FuelType;

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
        name = "shift_nozzle_assignment",
        schema = "reconciliation"
)
public class ShiftNozzleAssignment {

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
            name = "shift_dispenser_unit_id",
            nullable = false
    )
    private ShiftDispenserUnit shiftDispenserUnit;

    @ManyToOne(
            fetch = FetchType.LAZY,
            optional = false
    )
    @JoinColumn(
            name = "dispenser_side_id",
            nullable = false
    )
    private DispenserSide dispenserSide;

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
            name = "nozzle_id",
            nullable = false
    )
    private Nozzle nozzle;

    @ManyToOne(
            fetch = FetchType.LAZY,
            optional = false
    )
    @JoinColumn(
            name = "employee_id",
            nullable = false
    )
    private Employee employee;

    @ManyToOne(
            fetch = FetchType.LAZY,
            optional = false
    )
    @JoinColumn(
            name = "fuel_type_id",
            nullable = false
    )
    private FuelType fuelType;

    @Column(
            name = "nozzle_number_snapshot",
            nullable = false
    )
    private Integer nozzleNumberSnapshot;

    @Column(
            name = "fuel_type_code_snapshot",
            nullable = false,
            length = 30
    )
    private String fuelTypeCodeSnapshot;

    @Column(
            name = "assigned_at",
            nullable = false
    )
    private OffsetDateTime assignedAt;

    @Column(
            name = "released_at"
    )
    private OffsetDateTime releasedAt;

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

    protected ShiftNozzleAssignment() {
    }

    public ShiftNozzleAssignment(
            Shift shift,
            ShiftDispenserUnit shiftDispenserUnit,
            DispenserSide dispenserSide,
            ShiftEmployee shiftEmployee,
            Nozzle nozzle,
            Employee employee,
            FuelType fuelType,
            OffsetDateTime assignedAt,
            Long createdBy) {

        this.shift = shift;
        this.shiftDispenserUnit = shiftDispenserUnit;
        this.dispenserSide = dispenserSide;
        this.shiftEmployee = shiftEmployee;
        this.nozzle = nozzle;
        this.employee = employee;
        this.fuelType = fuelType;
        this.nozzleNumberSnapshot = nozzle.getNozzleNumber();
        this.fuelTypeCodeSnapshot = fuelType.getFuelCode();
        this.assignedAt = assignedAt;
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

    public ShiftDispenserUnit getShiftDispenserUnit() {
        return shiftDispenserUnit;
    }

    public DispenserSide getDispenserSide() {
        return dispenserSide;
    }

    public ShiftEmployee getShiftEmployee() {
        return shiftEmployee;
    }

    public Nozzle getNozzle() {
        return nozzle;
    }

    public Employee getEmployee() {
        return employee;
    }

    public FuelType getFuelType() {
        return fuelType;
    }

    public Integer getNozzleNumberSnapshot() {
        return nozzleNumberSnapshot;
    }

    public String getFuelTypeCodeSnapshot() {
        return fuelTypeCodeSnapshot;
    }

    public OffsetDateTime getAssignedAt() {
        return assignedAt;
    }

    public OffsetDateTime getReleasedAt() {
        return releasedAt;
    }

    public OffsetDateTime getCreatedAt() {
        return createdAt;
    }

    public Long getCreatedBy() {
        return createdBy;
    }

    public void release(OffsetDateTime releasedAt) {
        this.releasedAt = releasedAt;
    }
}