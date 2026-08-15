package com.bpcl.reconciliation.domain.dispenser;

import java.time.OffsetDateTime;

import com.bpcl.reconciliation.domain.fuel.FuelType;
import com.bpcl.reconciliation.persistence.common.BaseEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(
        name = "nozzle_fuel_type_assignment",
        schema = "reconciliation"
)
public class NozzleFuelTypeAssignment extends BaseEntity {

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
            name = "fuel_type_id",
            nullable = false
    )
    private FuelType fuelType;

    @Column(
            name = "effective_from",
            nullable = false
    )
    private OffsetDateTime effectiveFrom;

    @Column(
            name = "effective_to"
    )
    private OffsetDateTime effectiveTo;

    @Column(
            name = "active",
            nullable = false
    )
    private boolean active = true;

    protected NozzleFuelTypeAssignment() {
    }

    public NozzleFuelTypeAssignment(
            Nozzle nozzle,
            FuelType fuelType,
            OffsetDateTime effectiveFrom) {

        this.nozzle = nozzle;
        this.fuelType = fuelType;
        this.effectiveFrom = effectiveFrom;
        this.active = true;
    }

    public Nozzle getNozzle() {
        return nozzle;
    }

    public void setNozzle(Nozzle nozzle) {
        this.nozzle = nozzle;
    }

    public FuelType getFuelType() {
        return fuelType;
    }

    public void setFuelType(FuelType fuelType) {
        this.fuelType = fuelType;
    }

    public OffsetDateTime getEffectiveFrom() {
        return effectiveFrom;
    }

    public void setEffectiveFrom(
            OffsetDateTime effectiveFrom) {

        this.effectiveFrom = effectiveFrom;
    }

    public OffsetDateTime getEffectiveTo() {
        return effectiveTo;
    }

    public void setEffectiveTo(
            OffsetDateTime effectiveTo) {

        this.effectiveTo = effectiveTo;
    }

    public boolean isActive() {
        return active;
    }

    public void activate() {
        this.active = true;
    }

    public void deactivate() {
        this.active = false;
    }
}