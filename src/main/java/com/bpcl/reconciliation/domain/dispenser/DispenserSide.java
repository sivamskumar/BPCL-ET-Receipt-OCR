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
        name = "dispenser_side",
        schema = "reconciliation"
)
public class DispenserSide extends BaseEntity {

    @ManyToOne(
            fetch = FetchType.LAZY,
            optional = false
    )
    @JoinColumn(
            name = "dispenser_unit_id",
            nullable = false
    )
    private DispenserUnit dispenserUnit;

    @Column(
            name = "side_name",
            nullable = false,
            length = 50
    )
    private String sideName;

    @Column(
            name = "active",
            nullable = false
    )
    private boolean active = true;

    protected DispenserSide() {
    }

    public DispenserSide(
            DispenserUnit dispenserUnit,
            String sideName) {

        this.dispenserUnit = dispenserUnit;
        this.sideName = sideName;
        this.active = true;
    }

    public DispenserUnit getDispenserUnit() {
        return dispenserUnit;
    }

    public void setDispenserUnit(DispenserUnit dispenserUnit) {
        this.dispenserUnit = dispenserUnit;
    }

    public String getSideName() {
        return sideName;
    }

    public void setSideName(String sideName) {
        this.sideName = sideName;
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