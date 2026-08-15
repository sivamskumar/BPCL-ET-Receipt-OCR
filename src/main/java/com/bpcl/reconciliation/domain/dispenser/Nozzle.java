package com.bpcl.reconciliation.domain.dispenser;

import com.bpcl.reconciliation.persistence.common.BaseEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(
        name = "nozzle",
        schema = "reconciliation"
)
public class Nozzle extends BaseEntity {

    @ManyToOne(
            fetch = FetchType.LAZY,
            optional = false
    )
    @JoinColumn(
            name = "dispenser_unit_id",
            nullable = false
    )
    private DispenserUnit dispenserUnit;

    @ManyToOne(
            fetch = FetchType.LAZY,
            optional = false
    )
    @JoinColumn(
            name = "dispenser_side_id",
            nullable = false
    )
    private DispenserSide dispenserSide;

    @Column(
            name = "nozzle_number",
            nullable = false
    )
    private Integer nozzleNumber;

    @Column(
            name = "active",
            nullable = false
    )
    private boolean active = true;

    protected Nozzle() {
    }

    public Nozzle(
            DispenserUnit dispenserUnit,
            DispenserSide dispenserSide,
            Integer nozzleNumber) {

        this.dispenserUnit = dispenserUnit;
        this.dispenserSide = dispenserSide;
        this.nozzleNumber = nozzleNumber;
        this.active = true;
    }

    public DispenserUnit getDispenserUnit() {
        return dispenserUnit;
    }

    public void setDispenserUnit(DispenserUnit dispenserUnit) {
        this.dispenserUnit = dispenserUnit;
    }

    public DispenserSide getDispenserSide() {
        return dispenserSide;
    }

    public void setDispenserSide(DispenserSide dispenserSide) {
        this.dispenserSide = dispenserSide;
    }

    public Integer getNozzleNumber() {
        return nozzleNumber;
    }

    public void setNozzleNumber(Integer nozzleNumber) {
        this.nozzleNumber = nozzleNumber;
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