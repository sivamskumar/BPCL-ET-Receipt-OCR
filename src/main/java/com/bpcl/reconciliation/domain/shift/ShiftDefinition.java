package com.bpcl.reconciliation.domain.shift;

import java.time.LocalDate;
import java.time.LocalTime;

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
        name = "shift_definition",
        schema = "reconciliation"
)
public class ShiftDefinition extends BaseEntity {

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
            name = "shift_number",
            nullable = false
    )
    private Integer shiftNumber;

    @Column(
            name = "shift_name",
            nullable = false,
            length = 100
    )
    private String shiftName;

    @Column(
            name = "start_time",
            nullable = false
    )
    private LocalTime startTime;

    @Column(
            name = "end_time",
            nullable = false
    )
    private LocalTime endTime;

    @Column(
            name = "effective_from",
            nullable = false
    )
    private LocalDate effectiveFrom;

    @Column(
            name = "effective_to"
    )
    private LocalDate effectiveTo;

    @Column(
            name = "active",
            nullable = false
    )
    private boolean active = true;

    protected ShiftDefinition() {
    }

    public ShiftDefinition(
            FuelStation fuelStation,
            Integer shiftNumber,
            String shiftName,
            LocalTime startTime,
            LocalTime endTime,
            LocalDate effectiveFrom) {

        this.fuelStation = fuelStation;
        this.shiftNumber = shiftNumber;
        this.shiftName = shiftName;
        this.startTime = startTime;
        this.endTime = endTime;
        this.effectiveFrom = effectiveFrom;
        this.active = true;
    }

    public FuelStation getFuelStation() {
        return fuelStation;
    }

    public void setFuelStation(FuelStation fuelStation) {
        this.fuelStation = fuelStation;
    }

    public Integer getShiftNumber() {
        return shiftNumber;
    }

    public void setShiftNumber(Integer shiftNumber) {
        this.shiftNumber = shiftNumber;
    }

    public String getShiftName() {
        return shiftName;
    }

    public void setShiftName(String shiftName) {
        this.shiftName = shiftName;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalTime endTime) {
        this.endTime = endTime;
    }

    public LocalDate getEffectiveFrom() {
        return effectiveFrom;
    }

    public void setEffectiveFrom(LocalDate effectiveFrom) {
        this.effectiveFrom = effectiveFrom;
    }

    public LocalDate getEffectiveTo() {
        return effectiveTo;
    }

    public void setEffectiveTo(LocalDate effectiveTo) {
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