package com.bpcl.reconciliation.domain.dispenser;

import com.bpcl.reconciliation.domain.station.FuelStation;
import com.bpcl.reconciliation.persistence.common.BaseEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(
        name = "dispenser_unit",
        schema = "reconciliation"
)
public class DispenserUnit extends BaseEntity {

    @ManyToOne(
            fetch = FetchType.LAZY,
            optional = false
    )
    @JoinColumn(
            name = "fuel_station_id",
            nullable = false
    )
    private FuelStation fuelStation;

    @Column(
            name = "du_serial_number",
            nullable = false,
            length = 100
    )
    private String duSerialNumber;

    @Column(
            name = "normalized_du_serial_number",
            nullable = false,
            length = 100,
            unique = true
    )
    private String normalizedDuSerialNumber;

    @Column(
            name = "display_name",
            nullable = false,
            length = 150
    )
    private String displayName;

    @Column(
            name = "manufacturer",
            length = 100
    )
    private String manufacturer;

    @Column(
            name = "model_number",
            length = 100
    )
    private String modelNumber;

    @Column(
            name = "active",
            nullable = false
    )
    private boolean active = true;

    protected DispenserUnit() {
    }

    public DispenserUnit(
            FuelStation fuelStation,
            String duSerialNumber,
            String normalizedDuSerialNumber,
            String displayName) {

        this.fuelStation = fuelStation;
        this.duSerialNumber = duSerialNumber;
        this.normalizedDuSerialNumber = normalizedDuSerialNumber;
        this.displayName = displayName;
        this.active = true;
    }

    public FuelStation getFuelStation() {
        return fuelStation;
    }

    public void setFuelStation(FuelStation fuelStation) {
        this.fuelStation = fuelStation;
    }

    public String getDuSerialNumber() {
        return duSerialNumber;
    }

    public void setDuSerialNumber(String duSerialNumber) {
        this.duSerialNumber = duSerialNumber;
    }

    public String getNormalizedDuSerialNumber() {
        return normalizedDuSerialNumber;
    }

    public void setNormalizedDuSerialNumber(
            String normalizedDuSerialNumber) {

        this.normalizedDuSerialNumber = normalizedDuSerialNumber;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getModelNumber() {
        return modelNumber;
    }

    public void setModelNumber(String modelNumber) {
        this.modelNumber = modelNumber;
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