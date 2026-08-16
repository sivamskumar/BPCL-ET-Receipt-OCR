package com.bpcl.reconciliation.domain.fuel;

import java.math.BigDecimal;
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
        name = "fuel_price",
        schema = "reconciliation"
)
public class FuelPrice extends BaseEntity {

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
            name = "fuel_type_id",
            nullable = false
    )
    private FuelType fuelType;

    @Column(
            name = "price_per_litre",
            nullable = false,
            precision = 12,
            scale = 3
    )
    private BigDecimal pricePerLitre;

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

    protected FuelPrice() {
    }

    public FuelPrice(
            FuelStation fuelStation,
            FuelType fuelType,
            BigDecimal pricePerLitre,
            OffsetDateTime effectiveFrom) {

        this.fuelStation = fuelStation;
        this.fuelType = fuelType;
        this.pricePerLitre = pricePerLitre;
        this.effectiveFrom = effectiveFrom;
        this.active = true;
    }

    public FuelStation getFuelStation() {
        return fuelStation;
    }

    public void setFuelStation(FuelStation fuelStation) {
        this.fuelStation = fuelStation;
    }

    public FuelType getFuelType() {
        return fuelType;
    }

    public void setFuelType(FuelType fuelType) {
        this.fuelType = fuelType;
    }

    public BigDecimal getPricePerLitre() {
        return pricePerLitre;
    }

    public void setPricePerLitre(BigDecimal pricePerLitre) {
        this.pricePerLitre = pricePerLitre;
    }

    public OffsetDateTime getEffectiveFrom() {
        return effectiveFrom;
    }

    public void setEffectiveFrom(OffsetDateTime effectiveFrom) {
        this.effectiveFrom = effectiveFrom;
    }

    public OffsetDateTime getEffectiveTo() {
        return effectiveTo;
    }

    public void setEffectiveTo(OffsetDateTime effectiveTo) {
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