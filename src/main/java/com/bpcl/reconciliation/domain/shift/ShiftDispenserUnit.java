package com.bpcl.reconciliation.domain.shift;

import java.time.OffsetDateTime;

import com.bpcl.reconciliation.domain.dispenser.DispenserUnit;

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
import jakarta.persistence.Version;

@Entity
@Table(
        name = "shift_dispenser_unit",
        schema = "reconciliation"
)
public class ShiftDispenserUnit {

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
            name = "dispenser_unit_id",
            nullable = false
    )
    private DispenserUnit dispenserUnit;

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
            name = "created_at",
            nullable = false
    )
    private OffsetDateTime createdAt;

    @Column(
            name = "created_by",
            nullable = false
    )
    private Long createdBy;

    @Version
    @Column(
            name = "version",
            nullable = false
    )
    private Long version;

    protected ShiftDispenserUnit() {
    }

    public ShiftDispenserUnit(
            Shift shift,
            DispenserUnit dispenserUnit,
            OffsetDateTime startedAt) {

        this.shift = shift;
        this.dispenserUnit = dispenserUnit;
        this.startedAt = startedAt;
    }

    @PrePersist
    protected void onCreate() {
        if (createdAt == null) {
            createdAt = OffsetDateTime.now();
        }

        if (version == null) {
            version = 0L;
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

    public DispenserUnit getDispenserUnit() {
        return dispenserUnit;
    }

    public void setDispenserUnit(
            DispenserUnit dispenserUnit) {

        this.dispenserUnit = dispenserUnit;
    }

    public OffsetDateTime getStartedAt() {
        return startedAt;
    }

    public void setStartedAt(
            OffsetDateTime startedAt) {

        this.startedAt = startedAt;
    }

    public OffsetDateTime getEndedAt() {
        return endedAt;
    }

    public void setEndedAt(
            OffsetDateTime endedAt) {

        this.endedAt = endedAt;
    }

    public OffsetDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(
            OffsetDateTime createdAt) {

        this.createdAt = createdAt;
    }

    public Long getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Long createdBy) {
        this.createdBy = createdBy;
    }

    public Long getVersion() {
        return version;
    }
}