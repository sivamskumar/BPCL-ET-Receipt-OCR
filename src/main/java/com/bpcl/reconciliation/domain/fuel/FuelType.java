package com.bpcl.reconciliation.domain.fuel;

import com.bpcl.reconciliation.persistence.common.BaseEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(
        name = "fuel_type",
        schema = "reconciliation"
)
public class FuelType extends BaseEntity {

    @Column(
            name = "fuel_code",
            nullable = false,
            length = 30,
            unique = true
    )
    private String fuelCode;

    @Column(
            name = "fuel_name",
            nullable = false,
            length = 100
    )
    private String fuelName;

    @Column(
            name = "active",
            nullable = false
    )
    private boolean active = true;

    protected FuelType() {
    }

    public FuelType(
            String fuelCode,
            String fuelName) {

        this.fuelCode = fuelCode;
        this.fuelName = fuelName;
        this.active = true;
    }

    public String getFuelCode() {
        return fuelCode;
    }

    public void setFuelCode(String fuelCode) {
        this.fuelCode = fuelCode;
    }

    public String getFuelName() {
        return fuelName;
    }

    public void setFuelName(String fuelName) {
        this.fuelName = fuelName;
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