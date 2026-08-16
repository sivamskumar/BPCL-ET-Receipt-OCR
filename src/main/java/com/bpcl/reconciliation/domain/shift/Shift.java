package com.bpcl.reconciliation.domain.shift;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.OffsetDateTime;

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
        name = "shift",
        schema = "reconciliation"
)
public class Shift extends BaseEntity {

    @ManyToOne(
            fetch = FetchType.LAZY,
            optional = false
    )
    @JoinColumn(
            name = "fuel_station_id",
            nullable = false
    )
    private FuelStation fuelStation;

    @ManyToOne(
            fetch = FetchType.LAZY,
            optional = false
    )
    @JoinColumn(
            name = "shift_definition_id",
            nullable = false
    )
    private ShiftDefinition shiftDefinition;

    @Column(
            name = "business_date",
            nullable = false
    )
    private LocalDate businessDate;

    @Column(
            name = "shift_number",
            nullable = false
    )
    private Integer shiftNumber;

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
            name = "status",
            nullable = false,
            length = 40
    )
    private String status;

    @Column(
            name = "reconciliation_tolerance",
            nullable = false,
            precision = 19,
            scale = 2
    )
    private BigDecimal reconciliationTolerance = BigDecimal.ZERO;

    @Column(
            name = "remarks",
            length = 1000
    )
    private String remarks;

    protected Shift() {
    }

    public Shift(
            FuelStation fuelStation,
            ShiftDefinition shiftDefinition,
            LocalDate businessDate,
            Integer shiftNumber,
            OffsetDateTime startedAt,
            String status) {

        this.fuelStation = fuelStation;
        this.shiftDefinition = shiftDefinition;
        this.businessDate = businessDate;
        this.shiftNumber = shiftNumber;
        this.startedAt = startedAt;
        this.status = status;
        this.reconciliationTolerance = BigDecimal.ZERO;
    }

    public FuelStation getFuelStation() {
        return fuelStation;
    }

    public void setFuelStation(FuelStation fuelStation) {
        this.fuelStation = fuelStation;
    }

    public ShiftDefinition getShiftDefinition() {
        return shiftDefinition;
    }

    public void setShiftDefinition(
            ShiftDefinition shiftDefinition) {

        this.shiftDefinition = shiftDefinition;
    }

    public LocalDate getBusinessDate() {
        return businessDate;
    }

    public void setBusinessDate(LocalDate businessDate) {
        this.businessDate = businessDate;
    }

    public Integer getShiftNumber() {
        return shiftNumber;
    }

    public void setShiftNumber(Integer shiftNumber) {
        this.shiftNumber = shiftNumber;
    }

    public OffsetDateTime getStartedAt() {
        return startedAt;
    }

    public void setStartedAt(OffsetDateTime startedAt) {
        this.startedAt = startedAt;
    }

    public OffsetDateTime getEndedAt() {
        return endedAt;
    }

    public void setEndedAt(OffsetDateTime endedAt) {
        this.endedAt = endedAt;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public BigDecimal getReconciliationTolerance() {
        return reconciliationTolerance;
    }

    public void setReconciliationTolerance(
            BigDecimal reconciliationTolerance) {

        this.reconciliationTolerance = reconciliationTolerance;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
}